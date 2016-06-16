package org.sinais.mobile.custom.animation2d;

import java.util.ArrayList;

import org.sinais.mobile.custom.animation2d.AnimSprite;
import org.sinais.mobile.custom.animation2d.BackgroundAnim;
import org.sinais.mobile.custom.animation2d.DynamicElement;
import org.sinais.mobile.custom.animation2d.StaticElement;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.util.AttributeSet;
import android.util.Log;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

@SuppressLint("WrongCall")
public class Animation extends SurfaceView implements SurfaceHolder.Callback {
	
	private AnimSprite _anim;
	private Snail _snail;

	private Matrix transformMatrix;
	
	private float scale_x;
	private float scale_y;
	private Paint paint = new Paint();
	private ArrayList<AnimSprite> renderStack;
	
	private int cons_level;
	private int current_back=0;
	private String consumption;
	
	private boolean is_created = false;
	
	public AnimSprite get_anim() {
		return _anim;
	}
	
	public void set_anim(AnimSprite _anim) {
		this._anim = _anim;
	}

	public Animation(Context context,AttributeSet attr) {
		super(context,attr);
		getHolder().addCallback(this);
		renderStack = new ArrayList<AnimSprite>();
		transformMatrix = new Matrix();
		scale_x=0f;
		scale_y=0f;    
		transformMatrix.postScale(scale_x, scale_y);
		current_back=0;

		// TODO Auto-generated constructor stub
	}
	
	public void clearRenderStack(){
		renderStack.clear();
	}
	
	public void addtoStack(AnimSprite sprite){
		renderStack.add(sprite);
	}
	
	public void scaleX(){
		scale_x+=5f;
	}

	public void scaleY(){  	
		scale_y+=5f;
	}
	
	public void initSnail(ArrayList<Bitmap> imgs){
		
		this._snail = new Snail(imgs,580,210);
	}
	
	@Override
	public void surfaceChanged(SurfaceHolder holder, int format, int width,	int height) {
		// TODO Auto-generated method stub
		Log.e("ANIMATION", "SURFACE CREATED");
		is_created=true;
		
	}

	@Override
	public void surfaceCreated(SurfaceHolder holder) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void surfaceDestroyed(SurfaceHolder holder) {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void onDraw(Canvas c){
		//transformMatrix.postScale(scale_x, scale_y);
		if(is_created){
			
		
		c.drawColor(Color.BLACK);
		
		for(int i=0;i<renderStack.size();i++){		
			if(renderStack.get(i) instanceof BackgroundAnim){
				
				if(current_back < cons_level)			// iterate through the images until the one that represent the consumption
					current_back++;
				
				if(current_back > cons_level)
					current_back--;
				
				c.drawBitmap(renderStack.get(i).getImage(current_back), ((BackgroundAnim) renderStack.get(i)).getX(),((BackgroundAnim) renderStack.get(i)).getY(),paint);
				
			}else if(renderStack.get(i) instanceof DynamicElement){
				float x = ((DynamicElement) renderStack.get(i)).getX();
				float y = ((DynamicElement) renderStack.get(i)).getY();
				c.drawBitmap(renderStack.get(i).getImage(), ((DynamicElement) renderStack.get(i)).getX(),((DynamicElement) renderStack.get(i)).getY(),paint);
				((DynamicElement) renderStack.get(i)).move();
			}else if(renderStack.get(i) instanceof StaticElement){

				c.drawBitmap(renderStack.get(i).get_staticImage(), 620,7,null);
				paint.setColor(Color.WHITE);
				paint.setStyle(Style.FILL);
				paint.setTextSize(30);
				paint.setAntiAlias(true);
				c.drawText(consumption, 650, 50, paint); 
			}
			renderStack.get(i).anim();
		}
//		scale_x=1;
//		scale_y=1;
		}
	}
	
	
	public void requestRender(){ 
		Canvas c = null;
		SurfaceHolder sh = getHolder();
		try {
			c = sh.lockCanvas(null);
			synchronized (sh) {
				Log.e("ANIMATION", "Mandei render");
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
	
	public int getCons_level() {
		return cons_level;
	}

	public void setCons_level(int cons_level) {
		
		switch(cons_level){		
		case 1:
			this.cons_level=0; 
			break;
		case 2:
			this.cons_level=2;
			break;	
		case 3:
			this.cons_level=4;
			break;
		case 4:
			this.cons_level=6;
			break;
		case 5:
			this.cons_level=8; 
			break;
		}
		
	}

	public String getConsumption() {
		return consumption;
	}

	public void setConsumption(String cons) {
		this.consumption = cons;
	}

	private class Snail {
		
		private ArrayList<Bitmap> _images;
		private int currentIndex;
		public float x;
		public float y;
		
		public Snail( ArrayList<Bitmap> images, float start_x, float start_y){
			currentIndex=0;
			_images = images;
			x = start_x;
			y = start_y;
		}
		
		public void anim(){
		
			//Log.i("Anim sprite", "size: "+_images.size()+" index: "+currentIndex);
			
			//anim images
			if(currentIndex<_images.size()-1){
				currentIndex++;
			}
			else{
				currentIndex=0;
				Log.i("Anim sprite", "end of cyle");
			}
			
			// anim motion formula -- y = -0.14x + 210
			if(x>10){
				x-=5;
				y=(float) ((-0.14*x)+210f);
			}
			
			
		}
		
		public synchronized Bitmap getImage(){
			
			return _images.get(currentIndex);
		}	
		
	}

}
