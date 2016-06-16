package org.sinais.mobile.custom.productionChart;

import java.text.DecimalFormat;

import org.sinais.mobile.storage.DBManager;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.util.Log;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

public class SummaryWidget extends SurfaceView implements SurfaceHolder.Callback{
	
	private float total_month;
	private float total_week;
	private float total_day;
	String color_month = "#F15638";
	String color_week  = "#C95745";
	String color_day   = "#772C16";
	private final static String MODULE = "Summary widget";

	public SummaryWidget(Context context, AttributeSet attrs) {
		super(context, attrs);
		getHolder().addCallback(this);
		// TODO Auto-generated constructor stub
	}
	@SuppressLint("WrongCall")
	public void requestRender(){
		System.gc(); // ainda n‹o se se Ž necess‡rio mas pronto s— para ter certeza chamamos o GC agora.. aqui Ž um lugar seguro
		Canvas c = null;
		SurfaceHolder sh = getHolder();
		try {
			c = sh.lockCanvas(null);
			synchronized (sh) {
				onDraw(c);
			}
		} finally {
			// do this in a finally so that if an exception is thrown
			// during the above, we don't leave the Surface in an
			// inconsistent state
			if (c != null) {
				sh.unlockCanvasAndPost(c); 
			}
		}
	}
	private void drawComp(Canvas c) {
		float w = getWidth();
		float h = getHeight();

		float r0 = (int) Math.round(h/2.3);
		float r1 = calculateRadious(total_month,r0);//(total_month*r0)/max_cons;
		float r2 = calculateRadious(total_week,r0);//(total_week*r0)/max_cons;
		float r3 = calculateRadious(total_day,r0);//(total_day*r0)/max_cons;
		Log.i(MODULE,"radious: month"+r1+" week"+r2+" day"+r3);
		
		Paint paint_month = new Paint();
		paint_month.setColor(Color.parseColor(color_month));
		paint_month.setAntiAlias(true);
		
		Paint paint_week = new Paint();
		paint_week.setColor(Color.parseColor(color_week));
		paint_week.setAntiAlias(true);
		
		Paint paint_day = new Paint();
		paint_day.setColor(Color.parseColor(color_day));
		paint_day.setAntiAlias(true);
		
		if( total_month>total_week ){
			c.drawCircle(w/2, h/2, r1, paint_month);
			c.drawCircle(w/2, h/2, r2, paint_week);
		}else{
			c.drawCircle(w/2, h/2, r2, paint_week);
			c.drawCircle(w/2, h/2, r1, paint_month);
		}

	
		c.drawCircle(w/2, h/2,r3, paint_day);
		
		drawConnections(c,r1,r2,r3);
	}
	private void drawConnections(Canvas c, float r1, float r2, float r3){
		Paint paint = new Paint();
		paint.setColor(Color.BLACK);
		paint.setStrokeWidth(2);
		paint.setAntiAlias(true);
		paint.setColor(Color.parseColor("#D9D9D9"));
		if(r1<r2){
			float temp = r1;
			r1=r2;
			r2=temp;
		}
		
		float h = getHeight();
		double y = (getWidth()/3)*Math.tan(Math.PI/6);
		float c_x = getWidth()/2;
		
		float month_x = (getWidth()/2)+r1+10;
		float month_y= (float) (getHeight()/1.2);
		float week_x =  (getWidth()/2)+r1+10;
		float week_y= (float) (h/2);
		float day_x = (getWidth()/2)+r1+10;
		float day_y= (float) ( (h/2)-y);
			
		c.drawLine(c_x, (h/2+r1)-10, month_x-20, month_y, paint);
		c.drawLine( month_x-20, month_y, month_x, month_y, paint);
		c.drawLine(getWidth()/2+r2-5, (h/2), week_x, week_y, paint);
		c.drawLine(c_x, (h/2),day_x-20 ,day_y , paint);
		c.drawLine(day_x-20 ,day_y,day_x ,day_y , paint);
		
		c.drawCircle(c_x, (h/2+r1)-10, 5, paint);
		c.drawCircle(getWidth()/2+r2-5, (h/2), 5, paint);
		c.drawCircle(c_x,  (h/2), 5, paint);
		
		drawAverages(c,month_x,month_y,week_x,week_y,day_x,day_y);
	}
	private void drawAverages(Canvas c,float month_x, float month_y, float week_x,float week_y, float day_x, float day_y) {
		Paint p = new Paint();
		p.setAntiAlias(true);
		p.setTextSize(13);
		double co2Month = (total_month)*0.762; 
		co2Month = co2Month - co2Month*DBManager.getDBManager().getThisMonthRenewPrecentage();
		double co2Week = (total_week)*0.762; 
		co2Week = co2Week - co2Week*DBManager.getDBManager().getThisWeekRenewPercentage();
		double co2Day = (total_week)*0.762; 
		co2Day = co2Day - co2Day*DBManager.getDBManager().getTodayRenewPrecentage();
		
		if(total_month>total_week){
			p.setColor(Color.parseColor(color_month));
			drawAverage(c,month_x+10,month_y,total_month,co2Month,p);
			p.setColor(Color.parseColor(color_week));
			drawAverage(c,week_x+10,week_y,total_week,co2Week,p);
		}else{
			p.setColor(Color.parseColor(color_week));
			drawAverage(c,month_x+10,month_y,total_week,co2Week,p);
			p.setColor(Color.parseColor(color_month));
			drawAverage(c,week_x+10,week_y,total_month,co2Month,p);
		}
		p.setColor(Color.parseColor(color_day));
		drawAverage(c,day_x+10,day_y,total_day,co2Day,p);
	}
	private void drawAverage(Canvas c, float x, float y,float val,double co2,Paint p){
		DecimalFormat df = new DecimalFormat("#.#");
		c.drawText(df.format(val)+" kWh", x, y, p);
		c.drawText(df.format(co2)+" g CO2",x,y+15,p);
		c.drawText(df.format((val)*0.12)+" €", x, y+30, p);
	}
	private void drawDescription(Canvas c){
		Paint p = new Paint();
		p.setTextSize(12);
		p.setColor(Color.BLACK);
		p.setAntiAlias(true);
		c.drawText("Aqui poderá ver um resumo do seu", 0f ,10f, p);
		c.drawText("consumo hoje nesta semana", 0f ,25f, p);
		c.drawText("e neste mes. O tamanho", 0f ,40f, p);
		c.drawText("de cada circulo representa", 0f ,55f, p);
		c.drawText("o consumo no respectivo ", 0f ,70f, p);
		c.drawText("periodo.", 0f ,85f, p);

	}
	private float calculateRadious(float cons, float max_r){
		float max_cons = total_month>total_week?total_month:total_week;
		float result = 0f;
		result = (cons*max_r)/max_cons;
		double dat_data = (Math.log((cons/max_cons)));
		Log.e(MODULE, "Dat data "+dat_data);
		return result+ (float)(result*Math.abs(dat_data));
	}
	@Override
	public void onDraw(Canvas c){
		if(c!=null){
			c.drawColor(Color.parseColor("#FFFFFF"));
			if(total_day!=0){
				drawComp(c);
				drawLegend(c);
				drawDescription(c);
			}else{
				drawLoading(c);
			}
		}
	}
	private void drawLegend(Canvas c) {
		float x = 0;

		Paint p = new Paint();
		p.setAntiAlias(true);
		p.setTextSize(10);
		
		p.setColor(Color.parseColor(color_month));
		c.drawRect(x, getHeight()-40, 10, getHeight()-30, p);
		c.drawText("Mês", 15,  getHeight()-30, p);
		
		p.setColor(Color.parseColor(color_week));
		c.drawRect(x, getHeight()-25, 10, getHeight()-15, p);
		c.drawText("Semana", 15,  getHeight()-15, p);
		
		p.setColor(Color.parseColor(color_day));
		c.drawRect(x, getHeight()-10, 10, getHeight(), p);
		c.drawText("Hoje", 15,  getHeight(), p);
		
	}
	public void drawLoading(Canvas c){
		float y = getHeight()/2;
		float x = getWidth()/2;
		Paint p = new Paint();
		p.setTextSize(15);
		p.setAntiAlias(true);
		p.setColor(Color.parseColor("#F15638"));
		c.drawText("Loading consumption data...", x-p.measureText("Loading consumption data..."), y, p);
	}
	@Override
	public void surfaceChanged(SurfaceHolder holder, int format, int width,
			int height) {
		requestRender();
	}

	@Override
	public void surfaceCreated(SurfaceHolder holder) {
		// TODO Auto-generated method stub
		requestRender();
	}

	@Override
	public void surfaceDestroyed(SurfaceHolder holder) {
		// TODO Auto-generated method stub
		
	}
	public float getTotal_month() {
		return total_month;
	}
	public void setTotal_month(float total_month) {
		this.total_month = total_month;
	}
	public float getTotal_week() {
		return total_week;
	}
	public void setTotal_week(float total_week) {
		this.total_week = total_week;
	}
	public float getTotal_day() {
		return total_day;
	}
	public void setTotal_day(float total_day) {
		this.total_day = total_day;
	}

}
