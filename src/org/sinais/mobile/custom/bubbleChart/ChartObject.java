package org.sinais.mobile.custom.bubbleChart;

import java.sql.Timestamp;

import android.graphics.Color;
import android.graphics.Paint;
import android.util.Log;

public class ChartObject  {

	private int _color;
	private Coordinates _coordinates;
	private final Paint mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
	private String appliance_guess;
	private int deltaPMean;
	private int eventID;
	private String timestamp;

	public ChartObject(String color, int r){
		_color = Color.parseColor(color);
		mPaint.setColor(_color);
		_coordinates= new Coordinates(r);
	}
	
	public void set_color(int _color) {
		this._color = _color;
		mPaint.setColor(_color);
	}


	public int get_color() {
		return _color;
	}


	public void set_coordinates(Coordinates _coordinates) {
		this._coordinates = _coordinates;
	}


	public Coordinates get_coordinates() {
		return _coordinates;
	}


	public Paint getmPaint() {
		return mPaint;
	}


	public void setAppliance_guess(String appliance_guess) {
		this.appliance_guess = appliance_guess;
	}

	public String getAppliance_guess() {
		return appliance_guess;
	}


	public void setDeltaPMean(int deltaPMean) {
		this.deltaPMean = deltaPMean;
	}

	public int getDeltaPMean() {
		return deltaPMean;
	}


	public void setEventID(int eventID) {
		this.eventID = eventID;
	}

	public int getEventID() {
		return eventID;
	}


	public void setTimestamp(String timestamp) {
		
		this.timestamp = timestamp.substring(0, 16);
	}

	public String getTimestamp() {
		return timestamp;
	}


	/**
	 * Contains the coordinates of the graphic.
	 */
	public class Coordinates {
		private float _x = 100;
		private float _y = 0;
		private int _r = 0;

		public Coordinates(int radius){
			_r = radius;
		}
		
		public float getX() {
			return _x + _r / 2;
		}

		public void setX(float value) {
			_x = value - _r / 2;
		}

		public float getY() {
			return _y + _r / 2;
		}

		public void setY(float d) {
			_y = d - _r / 2;
		}

		public int getRadius(){
			
			return _r;
		}
		
		public void setRadius(int r){
			_r=r;
		}
		
		public String toString() {
			return "Coordinates: (" + _x + "/" + _y + ")";
		}
	}

}
