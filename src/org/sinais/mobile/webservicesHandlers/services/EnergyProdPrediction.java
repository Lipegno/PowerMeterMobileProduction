package org.sinais.mobile.webservicesHandlers.services;

import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.NameValuePair;
import org.apache.http.StatusLine;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.sinais.mobile.webservicesHandlers.ConsumptionHttpRequest;

import android.content.ContentValues;
import android.util.Log;

public class EnergyProdPrediction extends ConsumptionHttpRequest {

	private static final String MODULE = "EnergyPredictionRequest";
	private static final String DATE_KEY = "date";

	public EnergyProdPrediction(String request){
		super.hhhaaackk = request;
	}

	@Override
	public void parseData(String data) {
		try {
			JSONObject result = new JSONObject(data);
			JSONArray prod_data = result.getJSONArray("prod_data");
			ArrayList<ContentValues> parsed_result = new ArrayList<ContentValues>();

			for(int i=0;i<prod_data.length();i++){
				ContentValues temp = new ContentValues();
				JSONObject value = prod_data.getJSONObject(i);
//				Log.i(MODULE,"--");
//				Log.i(MODULE,value.getString("timestamp"));
				//				Log.i("Energy Production",value.getInt("total")+"");
				//				Log.i("Energy Production",value.getInt("termica")+"");
				//				Log.i("Energy Production",value.getInt("hidrica")+"");
				//				Log.i("Energy Production",value.getInt("eolica")+"");
				//				Log.i("Energy Production",value.getInt("biomassa")+"");
				//				Log.i("Energy Production",value.getInt("foto")+"");
				String date = value.getString("timestamp");
				String day_time = date.split(" ")[1];
				int hour = Integer.parseInt(day_time.split(":")[0]);
				int minutes = Integer.parseInt(day_time.split(":")[1]);
				int timeslot = (int) (((hour)*4)+Math.ceil(minutes/15));
//				Log.i(MODULE, "->"+timeslot);
				temp.put("timestamp", value.getString("timestamp"));
				temp.put("total", value.getInt("total"));
				temp.put("termica", value.getInt("termica"));
				temp.put("hidrica", value.getInt("hidrica"));
				temp.put("eolica", value.getInt("eolica"));
				temp.put("biomassa", value.getInt("biomassa"));
				temp.put("foto", value.getInt("foto"));
				temp.put("timeslot", timeslot);
				parsed_result.add(temp);
				ContentValues temp2 = new ContentValues();
				temp2.put("timestamp", value.getString("timestamp"));
				temp2.put("total", value.getInt("total"));
				temp2.put("termica", value.getInt("termica"));
				temp2.put("hidrica", value.getInt("hidrica"));
				temp2.put("eolica", value.getInt("eolica"));
				temp2.put("biomassa", value.getInt("biomassa"));
				temp2.put("foto", value.getInt("foto"));
				temp2.put("timeslot", timeslot+1);
				parsed_result.add(temp2);
			}
			//Log.i("Energy Production", data);
			super.setData(parsed_result);
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void run(){
		Log.i(MODULE,"running request");
		//String request = 		buildRequest();
		String request = hhhaaackk;
		SimpleDateFormat s = new SimpleDateFormat("yyyy-MM-dd");
		String date = s.format(new Date());
		//date = "2013-06-08";
		try {
			List<NameValuePair> params = new ArrayList<NameValuePair>();
			params.add(new BasicNameValuePair(DATE_KEY,date));
			DefaultHttpClient httpClient = new DefaultHttpClient();
			HttpPost httpPost = new HttpPost("http://aveiro.m-iti.org/sinais_energy_production/services/today_prediction_request.php");
			httpPost.setEntity(new UrlEncodedFormEntity(params));
			HttpResponse httpResponse = httpClient.execute(httpPost);
			HttpEntity httpEntity = httpResponse.getEntity();
			InputStream is = httpEntity.getContent();
			BufferedReader reader = new BufferedReader(new InputStreamReader(
					is, "iso-8859-1"), 8);
			StringBuilder sb = new StringBuilder();
			String line = null;
			while ((line = reader.readLine()) != null) 
				sb.append(line + "\n");

			parseData(sb.toString());
		} catch (ClientProtocolException e) {
			e.printStackTrace();

		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e){
			e.printStackTrace();
		}

	}

}
