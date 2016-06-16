package org.sinais.mobile.custom.ui_handler;

import org.sinais.mobile.R;

import android.widget.TextView;

public  class ComparisonBoxHandler {
	
	/**
     * Changes the values and the color in the comparison boxes of this view
     * @param dayComp		day comparison label
     * @param weekComp		week comparison label
     * @param monthComp		month comparison label
     * @param precent_day	 day consumption difference in %
     * @param precent_week	 week consumption difference in %
     * @param precent_month  month consumption difference in %
     */
    public static void changeComparisonBoxes(TextView label,float percent,String period){
    	
    	//day comparison
    	if(period.equals("day")){
	    	if(percent==0){
	    		label.setText(percent+"% vs yesterday");
	    		label.setBackgroundResource(R.drawable.round_box_yellow);
	    	}else if(percent<0){
	    		label.setText(percent+"% vs yesterday");
	    		label.setBackgroundResource(R.drawable.round_box_green);
	    	}else if(percent>4){
	    		label.setText(percent+"% vs yesterday");
	    		label.setBackgroundResource(R.drawable.round_box_red);
	    	}else if(percent>0){
	    		label.setText(percent+"% vs yesterday");
	    		label.setBackgroundResource(R.drawable.round_box_orange);
	    	}
    	}
    	
    	//Week comparison
    	if(period.equals("week")){
	    	if(percent==0){
	    		label.setText(percent+"% vs last week");
	    		label.setBackgroundResource(R.drawable.round_box_yellow);
	    	}else if(percent<0){
	    		label.setText(percent+"% vs last week");
	    		label.setBackgroundResource(R.drawable.round_box_green);
	    	}else if(percent>4){
	    		label.setText(percent+"% vs last week");
	    		label.setBackgroundResource(R.drawable.round_box_red);
	    	}else if(percent>0){
	    		label.setText(percent+"% vs last week");
	    		label.setBackgroundResource(R.drawable.round_box_orange);
	    	}
    	}
    	
    	//Month comparison
    	if(period.equals("month")){
	    	if(percent==0){
	    		label.setText(percent+"% vs last month");
	    		label.setBackgroundResource(R.drawable.round_box_yellow);
	    	}else if(percent<0){
	    		label.setText(percent+"% vs last month");;
	    		label.setBackgroundResource(R.drawable.round_box_green);
	    	}else if(percent>4){
	    		label.setText(percent+"% vs last month");
	    		label.setBackgroundResource(R.drawable.round_box_red);
	    	}else if(percent>0){
	    		label.setText(percent+"% vs last month");
	    		label.setBackgroundResource(R.drawable.round_box_orange);
	    	}
    	}
    	
    }

}
