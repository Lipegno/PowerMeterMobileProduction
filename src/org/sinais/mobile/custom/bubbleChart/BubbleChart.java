package org.sinais.mobile.custom.bubbleChart;
import java.util.ArrayList;

import org.sinais.mobile.clusterAnalysis.ClusterCalculator;
import org.sinais.mobile.custom.bubbleChart.ChartObject.Coordinates;
import org.sinais.mobile.misc.EventSampleDTO;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

/**
 * Class that represent a bubble chart, that can handle touch selection to his elements.
 * the chart has a array with the Object to be displayed. the chart can only display XX items at the time
 * after that limit is reached it works in a FIFO queue logic.
 * @author filipequintal
 *
 */
@SuppressLint("WrongCall")
public class BubbleChart extends SurfaceView implements SurfaceHolder.Callback {
	// private RenderThread _thread;
	private ArrayList<ChartObject> _graphics = new ArrayList<ChartObject>();
	private int height;
	private int width;
	private int count;
	private  final static String MODULE = "Bubble Chart";
	Canvas c;
	private int bg_Color;
	private String itemColor;
	private String itemColorAlt;
	private String selectionColor;
	public ChartObject currentSelection;
	private ChartObject firstSelection;
	private int max_chart_scale;
	private long _lastEvent_Viewed;
	private int number_events_displayed=15;
	
	private int selectedColor;
	private int selectedRadius;

	public BubbleChart(Context context, AttributeSet attr) {
		super(context,attr);
		getHolder().addCallback(this);
		//        _thread = new RenderThread(getHolder(), this);
		setFocusable(true);
		setCount(0);
	}

	public void setCount(int count) {
		this.count = count;
	}

	public int getCount() {
		return count;
	}

	public void createChartItems(){
		int i=0;

		for(i=0;i<number_events_displayed;i++){
			_graphics.add(new ChartObject(itemColor, 18));
			ChartObject temp  = _graphics.get(_graphics.size()-1);
			org.sinais.mobile.custom.bubbleChart.ChartObject.Coordinates temp2 = temp.get_coordinates();
			temp2.setX(i*(width/number_events_displayed));
			temp2.setY((float)Math.random()*height);

			Log.e(MODULE, "x "+temp2.getX()+"  y "+temp2.getY());
		}
		Log.e(MODULE, "objects created");
			requestRender();
		}
	
		/**
		 * Add a new item to the chart
		 * @param item Chart Object
		 */
		public void addItem(ChartObject item){
			
			_graphics.remove(0);
		_graphics.add(item);
	}

	public void addItem(){
		
		
		_graphics.add(new ChartObject(itemColor, 18));
		ChartObject temp ;
		
		
		if(_graphics.size()>0){
			  temp = _graphics.get(_graphics.size()-1);
			//  _graphics.remove(0);
		}
		else
			  temp = _graphics.get(0);
		
		org.sinais.mobile.custom.bubbleChart.ChartObject.Coordinates temp2 = temp.get_coordinates();
		temp2.setX(0);
		temp2.setY((float)Math.random()*height);
		updateCoords();
		requestRender();
	}
	
	public void addItem(EventSampleDTO value) throws Exception{
		
		
		if(_graphics.size()==number_events_displayed)
			_graphics.remove(0);
		
		if(_graphics.size()>0)
			setFirstSelection(_graphics.get(0));
		
		String clr = itemColor;
		float _height=0;
		
		if(value.get_deltaPMean()>0)
			clr=itemColor;
			else
				clr=itemColorAlt;
		
		_height = (height)-(Math.abs(value.get_deltaPMean())*height)/max_chart_scale;

//		Log.d(MODULE, "height "+height);
//		Log.i(MODULE, "val "+value.get_deltaPMean());
		ChartObject temp = new ChartObject(clr,18);
		temp.setAppliance_guess(value.get_guess());
		temp.setDeltaPMean(value.get_deltaPMean());
		temp.setEventID(value.get_event_id());
		temp.get_coordinates().setY(_height);
		temp.setTimestamp(value.get_timestamp());
		_graphics.add(temp);
		_lastEvent_Viewed=value.get_event_id();
		Log.i(MODULE,"chart item added value="+(value.get_deltaPMean())+" height "+_height);
		updateCoords();
		requestRender();
		
	}
	
	public void addClusterItem(EventSampleDTO value){
		if(_graphics.size()==number_events_displayed)
			_graphics.remove(0);
		
		if(_graphics.size()>0)
			setFirstSelection(_graphics.get(0));
		
		String clr = ClusterCalculator.getClusterColor(value.get_clusterResults()[0]);
		float _height=0;
		
//		if(value.get_deltaPMean()>0)
//			clr=itemColor;
//			else
//				clr=itemColorAlt;
		
		_height = (height)-(Math.abs(value.get_deltaPMean())*height)/3500;

//		Log.d(MODULE, "height "+height);
//		Log.i(MODULE, "val "+value.get_deltaPMean());
		ChartObject temp = new ChartObject(clr,calculateItemSize(value.get_deltaPMean()));
		temp.setAppliance_guess(value.get_guess());
		temp.setDeltaPMean(value.get_deltaPMean());
		temp.setEventID(value.get_event_id());
		temp.get_coordinates().setY(_height);
		temp.setTimestamp(value.get_timestamp());
		_graphics.add(temp);
		_lastEvent_Viewed=value.get_event_id();
		Log.i(MODULE,"chart item added value="+(value.get_deltaPMean())+" height "+_height);
		updateCoords();
		requestRender();
	}
	
	private int calculateItemSize(int deltaPMean){
	
		if(Math.abs(deltaPMean)>3500)
			return 25;
		else if(Math.abs(deltaPMean)<60)
			return 10;
		else
			return Math.round((Math.abs(deltaPMean)*20)/3500)+4;
			
		
		
	}
	
	private void updateCoords(){
		Coordinates itemC;
		
		for(int i=0;i<_graphics.size();i++){
			itemC =_graphics.get(i).get_coordinates();_graphics.get(i).get_coordinates();
			itemC.setX(i*(width/number_events_displayed));
		}
	}

	@Override
	public void onDraw(Canvas canvas) {
		canvas.drawColor(bg_Color);
	//	canvas.drawBitmap(BitmapFactory.decodeResource(getResources(),  R.drawable.chart_bg), 0, 0, null);
		ChartObject.Coordinates coords;
		for (ChartObject graphic : _graphics) {

			coords = graphic.get_coordinates();
			canvas.drawCircle(coords.getX(), coords.getY(),coords.getRadius(), graphic.getmPaint() );
		}

	}

	@Override
	public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {
		// TODO Auto-generated method stub
	}

	@Override
	public void surfaceCreated(SurfaceHolder holder) {
		// _thread.setRunning(true);
		// _thread.start();
		height = getHeight();
		width  = getWidth();
		requestRender();
		//createChartItems();

	}
	public void requestRender(){
		Canvas c = null;
		SurfaceHolder sh = getHolder();
		try {
			c = sh.lockCanvas(null);
			synchronized (sh) {
				//               	_chart.updatePhysics();
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

	@Override
	public void surfaceDestroyed(SurfaceHolder holder) {

	}

	private void checkTouch(float x, float y){

		int i = 0;
		float itemx=0;
		float itemy=0;
		Coordinates itemC=null;
		int itemr=0;

		// clear the formating of the previous selection
		if(currentSelection!=null){
			currentSelection.get_coordinates().setRadius(selectedRadius);
			currentSelection.set_color(selectedColor);
		}

		boolean selected = false;
		for(i=0;i<_graphics.size();i++){

			itemC =_graphics.get(i).get_coordinates();
			itemx = itemC.getX();
			itemy = itemC.getY();
			itemr = itemC.getRadius();


			if((x>itemx-itemr)&&(x<itemx+itemr)){
				if((y>itemy-itemr)&&(y<itemy+itemr)){
					Log.d(MODULE,"EXISTE AQUI ->"+i);
					currentSelection = _graphics.get(i);
					selectedColor  = currentSelection.get_color();
					selectedRadius = currentSelection.get_coordinates().getRadius();
					currentSelection.get_coordinates().setRadius(25);			// increases the size of the selection
					currentSelection.set_color(Color.parseColor(selectionColor));	// changes the color of the selection
					selected=true;
					requestRender();
					break;
				}
			}
		}

		// if none of the items are selected clear the formatation of the previous one
		if(!selected && currentSelection!=null){
			currentSelection.get_coordinates().setRadius(selectedRadius);
			currentSelection.set_color(selectedColor);
			requestRender();
		}
	}

	
	
	@Override
	public boolean onTouchEvent(MotionEvent event) {
		synchronized (getHolder()) {
			if (event.getAction() == MotionEvent.ACTION_DOWN) {
				checkTouch(event.getX(),event.getY());
				Log.d(MODULE, "touch Down");

			} else if (event.getAction() == MotionEvent.ACTION_UP) {
				Log.d(MODULE,"touch Up");
			}
			return true;
		}
	}

	public void setBg_Color(String bg_Color) {
		this.bg_Color = Color.parseColor(bg_Color);
	}

	public int getBg_Color() {
		return bg_Color;
	}

	public void setItemColor(String itemColor) {
		this.itemColor = itemColor;
	}

	public String getItemColor() {
		return itemColor;
	}

	public void setSelectionColor(String selectionColor) {
		this.selectionColor = selectionColor;
	}

	public String getSelectionColor() {
		return selectionColor;
	}

	public void setItemColorAlt(String itemColorAlt) {
		this.itemColorAlt = itemColorAlt;
	}

	public String getItemColorAlt() {
		return itemColorAlt;
	}

	public void setFirstSelection(ChartObject firstSelection) {
		this.firstSelection = firstSelection;
	}

	public ChartObject getFirstSelection() {
		return firstSelection;
	}

	public void setMax_chart_scale(int max_chart_scale) {
		this.max_chart_scale = max_chart_scale;
	}

}
