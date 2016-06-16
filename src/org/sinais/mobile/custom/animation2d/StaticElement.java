package org.sinais.mobile.custom.animation2d;


import android.graphics.Bitmap;
import android.util.Log;

public class StaticElement extends AnimSprite {
	private String name;
	
	public StaticElement(Bitmap image, String _name){
		super(image);
		name=_name;
		
	}
	
	@Override
	public void setName(String _name) {
		name = name;
		
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public void anim(){
		Log.i("Static Element", "static element with no animation");
	}
}
