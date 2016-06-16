package org.sinais.mobile.custom.animation2d;

import java.util.ArrayList;

import android.graphics.Bitmap;
import android.util.Log;


/**
 * Class that represents the dynamic elements in the forest, we define the dynamic elements by the elemnts
 * that appart from the changing images also moves in the screen. The motion on the screen is calculated through a 2d funcion defined by the variables p1 p2 p3 and p4.
 * @author filipequintal
 */
public class DynamicElement extends AnimSprite{

	private String _name;
	private int direction;
	private int velocity;
	private float p1;
	private float p2;
	private float p3;
	private float p4;
	private float b;
	
	private static final String MODULE = "Dynamic Element";
	
	public DynamicElement(ArrayList<Bitmap> imgs, String name, float _x, float _y){
		super(imgs);
		this._name=name;
		setX(_x);
		setY(_y);
	}
	/**
	 * Set that function that will represent the path traveled by this object
	 * @param degree1 coefficient  of the 1st degree in the function
	 * @param degree2 coefficient  of the 2st degree in the function
	 * @param degree3 coefficient  of the 3st degree in the function
	 * @param degree4 coefficient  of the 4st degree in the function
	 * @param inter intersection with the yy axis in the origin
	 * @param direction - direction of the motion (ex: 1 for left to right and -1 other wise)
	 * @param velocity - velocity of the motion
	 */
	public void setPathFunction(float degree1, float degree2, float degree3, float degree4, float inter,int dir, int vel){
		
		p1 		  = degree1;
		p2 		  = degree2;
		p3 		  = degree3;
		p4 		  = degree4;
		b  		  = inter;
		direction = dir;
		velocity  = vel; 
	}
	
	
	public int getDirection() {
		return direction;
	}
	
	public void setDirection(int direction) {
		this.direction = direction;
	}
	
	public int getVelocity() {
		return velocity;
	}
	public void setVelocity(int velocity) {
		this.velocity = velocity;
	}
	
	/**
	 * Moves the image on the screen based on a pre-defined 2d function (1st degree in this case)
	 */
	public void move(){
		
		if(direction<0){ 	//motion to the left
			if(getX()>10){
				setX(getX()+direction*velocity);
				Log.i(MODULE,  getName()+" y "+getY());
				float y = (float) ((p1*getX())+(p2*Math.pow(getX(), 2))+(p3*Math.pow(getX(), 3))+(p4*Math.pow(getX(), 4))+b);
				Log.i(MODULE,  getName()+" y "+y);
				setY(y);
			}
		}
		else{
			if(getX()<1000){		// motion to the right
				setX(getX()+direction*velocity);
				float y = (float) ((p1*getX())+(p2*Math.pow(getX(), 2))+(p3*Math.pow(getX(), 3))+(p4*Math.pow(getX(), 4))+b);
			//	Log.i(MODULE, "element y "+y);
				setY(y);
			}
		}
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