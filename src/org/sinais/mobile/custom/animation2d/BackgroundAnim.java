package org.sinais.mobile.custom.animation2d;

import java.util.ArrayList;

import android.graphics.Bitmap;

/**
 * Class that represents a bakcground elements. We define this elements as the ones don't move on the screen, their only
 * animation is made by changing the images.
 * @author filipequintal
 *
 */
public class BackgroundAnim extends AnimSprite {
	
	private String _name;
	
	public BackgroundAnim(ArrayList<Bitmap> images, String name){
		super(images);
		super.setX(0);
		super.setY(0);
		_name = name;
		
	}

	@Override
	public void setName(String name) {
		this._name=name;
		
	}

	@Override
	public String getName() {
		return this._name;
	}
	

}
