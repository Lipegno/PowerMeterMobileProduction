package org.sinais.mobile.custom.productionChart;

import org.sinais.mobile.R;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.util.Log;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

public class SummaryComparisonWidget  extends SurfaceView implements SurfaceHolder.Callback{
	
	private int maxDailyCons;
	private int maxWeeklyCons;
	private int maxMonthlyCons;
	private float daily_cons;
	private float daily_avg;
	private float weekly_cons;
	private float weekly_avg;
	private float monthly_cons;
	private float monthly_avg;
	private static final String MODULE = "Summary Comparison Widget";


	public SummaryComparisonWidget(Context context,AttributeSet attrs) {
		super(context,attrs);
		getHolder().addCallback(this);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public void onDraw(Canvas c){
		if(c!=null){
			c.drawColor(Color.parseColor("#FFFFFF"));
			drawComp(c);
		}
	}
	private void drawComp(Canvas c) {
		float w = getWidth();
		float h = getHeight();
		int rect1_h = (int) Math.round(h/10);
		int starY = 10;
		Paint textPaint = new Paint();
		textPaint.setTextSize(22);
		textPaint.setAntiAlias(true);
		c.drawLine(w/2, starY, w/2, h,textPaint);
		drawComparison(starY+35, c, daily_cons, daily_avg, getMaxDailyCons(),"Ontem "," Hoje");
		drawComparison(starY+90, c, weekly_cons, weekly_avg, getMaxWeeklyCons(),"Semana passada "," Esta semana ");
		drawComparison(starY+145, c, monthly_cons, monthly_avg, getMaxMonthlyCons(),"Mês passado "," Este Mês");
	}
	private int calculateBarWidth(float avg,float max){
		return Math.round((avg*getWidth()/2)/max);
	}
	private void drawComparison(int y,Canvas c,float cons, float avg, float max, String period1, String period2){
			
		int cons_width = calculateBarWidth(cons,max);
		Log.e(MODULE , "cons width "+cons_width);
		int avg_width  = calculateBarWidth(avg,max);
		Log.e(MODULE, "avg width "+avg_width);
		Paint p = new Paint();
		Paint p2 = new Paint();
		Paint textPaint = new Paint();
		textPaint.setTextSize(15);
		textPaint.setAntiAlias(true);

		p.setColor(Color.parseColor("#B3B3B3"));
		p.setAntiAlias(true);
		p2.setColor(Color.parseColor("#F0492D"));
		p2.setAntiAlias(true);
		float w = getWidth();
		int middle = (int)(w/2);
		
		Rect r  = new Rect(middle - avg_width, y,middle,y+30);
		float textx = textPaint.measureText(period1);
    	c.drawText(period1,(w/2)-textx, y-5, textPaint);
		c.drawRect(r, p);
		c.drawBitmap(BitmapFactory.decodeResource(getResources(), R.drawable.left_tip), middle - avg_width, y, p);
		
    	Rect r2 = new Rect(middle, y,middle+cons_width,y+30);
    	textx = textPaint.measureText(cons+"");
    	float tx = (middle+cons_width-textx) > middle ? (middle+cons_width-textx) : middle;
    	
		c.drawText(period2,w/2, y-5, textPaint);
		c.drawRect(r2, p2);
		c.drawBitmap(BitmapFactory.decodeResource(getResources(), R.drawable.right_tip),middle+cons_width, y, p);
		textx = textPaint.measureText(cons+"");
		p2.setColor(Color.WHITE);
		c.drawText(cons+"", tx, y+18, p2);

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

	@Override
	public void surfaceChanged(SurfaceHolder holder, int format, int width,
			int height) {
		// TODO Auto-generated method stub
		requestRender();
		
	}

	@Override
	public void surfaceCreated(SurfaceHolder holder) {
		// TODO Auto-generated method stub
		Log.e("COMP","COMP WIDGET CREATED");
		requestRender();
	}

	@Override
	public void surfaceDestroyed(SurfaceHolder holder) {
		// TODO Auto-generated method stub
		
	}

	public int getMaxDailyCons() {
		return maxDailyCons;
	}

	public void setMaxDailyCons(int maxDailyCons) {
		this.maxDailyCons = maxDailyCons;
	}

	public int getMaxWeeklyCons() {
		return maxWeeklyCons;
	}

	public void setMaxWeeklyCons(int maxWeeklyCons) {
		this.maxWeeklyCons = maxWeeklyCons;
	}

	public int getMaxMonthlyCons() {
		return maxMonthlyCons;
	}

	public void setMaxMonthlyCons(int maxMonthlyCons) {
		this.maxMonthlyCons = maxMonthlyCons;
	}

	public float getDaily_cons() {
		return daily_cons;
	}

	public void setDaily_cons(float daily_cons) {
		this.daily_cons = daily_cons;
	}

	public float getDaily_avg() {
		return daily_avg;
	}

	public void setDaily_avg(float daily_avg) {
		this.daily_avg = daily_avg;
	}

	public float getWeekly_cons() {
		return weekly_cons;
	}

	public void setWeekly_cons(float weekly_cons) {
		this.weekly_cons = weekly_cons;
	}

	public float getWeekly_avg() {
		return weekly_avg;
	}

	public void setWeekly_avg(float weekly_avg) {
		this.weekly_avg = weekly_avg;
	}

	public float getMonthly_cons() {
		return monthly_cons;
	}

	public void setMonthly_cons(float monthly_cons) {
		this.monthly_cons = monthly_cons;
	}

	public float getMonthly_avg() {
		return monthly_avg;
	}

	public void setMonthly_avg(float monthly_avg) {
		this.monthly_avg = monthly_avg;
	}
}
