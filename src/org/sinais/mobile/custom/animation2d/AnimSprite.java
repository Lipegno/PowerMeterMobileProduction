package org.sinais.mobile.custom.animation2d;

import java.util.ArrayList;

import android.graphics.Bitmap;
import android.util.Log;

public abstract class AnimSprite {
	
	private ArrayList<Bitmap> _images;
	private Bitmap _staticImage;
	private int currentIndex;
	private float x;
	private float y;
	
	public AnimSprite( ArrayList<Bitmap> images){
		currentIndex=0;
		_images = images;
	}
	
	public AnimSprite(Bitmap image){
		set_staticImage(image);
	}
	
	public void anim(){
	
		//Log.i("Anim sprite", "size: "+_images.size()+" index: "+currentIndex);
		if(currentIndex<_images.size()-1){
			currentIndex++;
		}
		else{
			currentIndex=0;
		//	Log.i("Anim sprite", "end of cyle");
		}
		
	}
	
	public synchronized Bitmap getImage(){
		
		return _images.get(currentIndex);
	}
	
	public synchronized Bitmap getImage(int index){
		
		if(index < _images.size()){
			return _images.get(index);
		}else{
			return null;
		}
		
	}
	
	public float getY() {
		return y;
	}

	public void setY(float y) {
		this.y = y;
	}
	
	public float getX() {
		return x;
	}

	public void setX(float x) {
		this.x = x;
	}
	

	public Bitmap get_staticImage() {
		return _staticImage;
	}

	public void set_staticImage(Bitmap _staticImage) {
		this._staticImage = _staticImage;
	}
	
	public abstract void setName(String _name);
	public abstract String getName();

}
