package org.sinais.mobile.clusterAnalysis;

import android.util.Log;

public class ClusterCalculator {
	
	static String[] colors = {"#3366FF","#6633FF","#CC33FF","#FF33CC","#33CCFF",
					          "#003DF5","#002EB8","#FF3366","#33FFCC","#B88A00",
					          "#F5B800","#FF6633","#33FF66","#66FF33","#CCFF33",
					          "#FFCC33","#669999","#666699","#669980","#AFCACA",
					          "#996699","#669966","#CAAFAF","#996680","#9900FF"};
	
	/**
	 * Calculates to which cluster the event belongs to
	 * @param deltaPDuring 	- mean of the real power change during the event.
	 * @param deltaQDuring	- mean of the reactive power change during the event.
	 * @return an int array [cluster,node on the tree, degree of confidence]
	 */
	public static int[] calculateCluster(double deltaPDuring, double deltaQDuring){
		
		int node=0;
		int prediction=0;
		double probability=0;
		
		int[] result = {0,0,0};
		
		if ((((deltaPDuring !=0   &&  (deltaPDuring <= 532.5751220454802)) || deltaPDuring==0   &&  (deltaQDuring==0  || (deltaQDuring > -806.6923525))))  &&  (deltaPDuring !=0   &&  (deltaPDuring <= -1058.216643039065))  &&  ((deltaPDuring !=0   &&  (deltaPDuring <= -2215.201081478227)) || deltaPDuring==0   &&  (deltaQDuring !=0   &&  (deltaQDuring <= -83.630713)))  &&  ((deltaPDuring !=0   &&  (deltaPDuring <= -2937.075358164229)) || deltaPDuring==0   &&  (deltaQDuring !=0   &&  (deltaQDuring <= -119.571002))))
		{
			node = 13;
			prediction = 17;
			probability = 0.963654;
		}
		/* node 37 */
		else if ((((deltaPDuring !=0   &&  (deltaPDuring <= 532.5751220454802)) || deltaPDuring==0   &&  (deltaQDuring==0  || (deltaQDuring > -806.6923525))))  &&  (deltaPDuring !=0   &&  (deltaPDuring <= -1058.216643039065))  &&  (((deltaPDuring !=0   &&  (deltaPDuring <= -2215.201081478227)) || deltaPDuring==0   &&  (deltaQDuring !=0   &&  (deltaQDuring <= -83.630713))))  &&  (((deltaPDuring !=0   &&  (deltaPDuring > -2937.075358164229)) || deltaPDuring==0   &&  (deltaQDuring==0  || (deltaQDuring > -119.571002))))  &&  (deltaQDuring==0  || (deltaQDuring <= 340.2927987378777))  &&  (deltaQDuring !=0   &&  (deltaQDuring <= -241.0540198282197)))
		{
			node = 37;
			prediction = 5;
			probability = 0.933333;

		}/* node 38 */
		else if (((deltaPDuring !=0   &&  (deltaPDuring <= 532.5751220454802)) || deltaPDuring==0   &&  (deltaQDuring==0  || (deltaQDuring > -806.6923525)))  &&  (deltaPDuring !=0   &&  (deltaPDuring <= -1058.216643039065))  &&  (((deltaPDuring !=0   &&  (deltaPDuring <= -2215.201081478227)) || deltaPDuring==0   &&  (deltaQDuring !=0   &&  (deltaQDuring <= -83.630713))))  &&  (((deltaPDuring !=0   &&  (deltaPDuring > -2937.075358164229)) || deltaPDuring==0   &&  (deltaQDuring==0  || (deltaQDuring > -119.571002))))  &&  (deltaQDuring==0  || (deltaQDuring <= 340.2927987378777))  &&  (deltaQDuring==0  || (deltaQDuring > -241.0540198282197)))
		{
			node = 38;
			prediction = 19;
			probability = 0.990733;

		}/* node 24 */
		else if ((((deltaPDuring !=0   &&  (deltaPDuring <= 532.5751220454802)) || deltaPDuring==0   &&  (deltaQDuring==0  || (deltaQDuring > -806.6923525))))  &&  (deltaPDuring !=0   &&  (deltaPDuring <= -1058.216643039065))  &&  (((deltaPDuring !=0   &&  (deltaPDuring <= -2215.201081478227)) || deltaPDuring==0   &&  (deltaQDuring !=0   &&  (deltaQDuring <= -83.630713))))  &&  (((deltaPDuring !=0   &&  (deltaPDuring > -2937.075358164229)) || deltaPDuring==0   &&  (deltaQDuring==0  || (deltaQDuring > -119.571002))))  &&  (deltaQDuring !=0   &&  (deltaQDuring > 340.2927987378777)))
		{
			node = 24;
			prediction = 18;
			probability = 1.000000;

		}/* node 39 */
		else if ((((deltaPDuring !=0   &&  (deltaPDuring <= 532.5751220454802)) || deltaPDuring==0   &&  (deltaQDuring==0  || (deltaQDuring > -806.6923525))))  &&  (deltaPDuring !=0   &&  (deltaPDuring <= -1058.216643039065))  &&  (((deltaPDuring !=0   &&  (deltaPDuring > -2215.201081478227)) || deltaPDuring==0   &&  (deltaQDuring==0  || (deltaQDuring > -83.630713))))  &&  (deltaQDuring==0  || (deltaQDuring <= 255.4050885823112))  &&  (((deltaPDuring !=0   &&  (deltaPDuring <= -1447.498626296387)) || deltaPDuring==0   &&  (deltaQDuring==0  || (deltaQDuring <= -32.5329455))))  &&  (((deltaQDuring !=0   &&  (deltaQDuring <= -224.7615524532918)) || deltaQDuring==0   &&  (deltaPDuring !=0   &&  (deltaPDuring <= -2211.934008)))))
		{
			node = 39;
			prediction = 5;
			probability = 0.912281;

		}/* node 40 */
		else if ((((deltaPDuring !=0   &&  (deltaPDuring <= 532.5751220454802)) || deltaPDuring==0   &&  (deltaQDuring==0  || (deltaQDuring > -806.6923525))))  &&  (deltaPDuring !=0   &&  (deltaPDuring <= -1058.216643039065))  &&  (((deltaPDuring !=0   &&  (deltaPDuring > -2215.201081478227)) || deltaPDuring==0   &&  (deltaQDuring==0  || (deltaQDuring > -83.630713))))  &&  (deltaQDuring==0  || (deltaQDuring <= 255.4050885823112))  &&  (((deltaPDuring !=0   &&  (deltaPDuring <= -1447.498626296387)) || deltaPDuring==0   &&  (deltaQDuring==0  || (deltaQDuring <= -32.5329455))))  &&  (((deltaQDuring !=0   &&  (deltaQDuring > -224.7615524532918)) || deltaQDuring==0   &&  (deltaPDuring==0  || (deltaPDuring > -2211.934008)))))
		{
			node = 40;
			prediction = 20;
			probability = 0.993537;

		}/* node 26 */
		else if ((((deltaPDuring !=0   &&  (deltaPDuring <= 532.5751220454802)) || deltaPDuring==0   &&  (deltaQDuring==0  || (deltaQDuring > -806.6923525))))  &&  (deltaPDuring !=0   &&  (deltaPDuring <= -1058.216643039065))  &&  (((deltaPDuring !=0   &&  (deltaPDuring > -2215.201081478227)) || deltaPDuring==0   &&  (deltaQDuring==0  || (deltaQDuring > -83.630713))))  &&  (deltaQDuring==0  || (deltaQDuring <= 255.4050885823112))  &&  (((deltaPDuring !=0   &&  (deltaPDuring > -1447.498626296387)) || deltaPDuring==0   &&  (deltaQDuring !=0   &&  (deltaQDuring > -32.5329455)))))
		{
			node = 26;
			prediction = 21;
			probability = 0.994444;

		}/* node 16 */
		else if ((((deltaPDuring !=0   &&  (deltaPDuring <= 532.5751220454802)) || deltaPDuring==0   &&  (deltaQDuring==0  || (deltaQDuring > -806.6923525))))  &&  (deltaPDuring !=0   &&  (deltaPDuring <= -1058.216643039065))  &&  (((deltaPDuring !=0   &&  (deltaPDuring > -2215.201081478227)) || deltaPDuring==0   &&  (deltaQDuring==0  || (deltaQDuring > -83.630713))))  &&  (deltaQDuring !=0   &&  (deltaQDuring > 255.4050885823112)))
		{
			node = 16;
			prediction = 18;
			probability = 0.929961;

		}/* node 27 */
		else if ((((deltaPDuring !=0   &&  (deltaPDuring <= 532.5751220454802)) || deltaPDuring==0   &&  (deltaQDuring==0  || (deltaQDuring > -806.6923525))))  &&  (deltaPDuring==0  || (deltaPDuring > -1058.216643039065))  &&  (((deltaQDuring !=0   &&  (deltaQDuring <= 314.5150056049885)) || deltaQDuring==0   &&  (deltaPDuring==0  || (deltaPDuring > -158.9578955))))  &&  (((deltaQDuring !=0   &&  (deltaQDuring <= -423.7250150386998)) || deltaQDuring==0   &&  (deltaPDuring !=0   &&  (deltaPDuring > 148.128046))))  &&  (((deltaQDuring !=0   &&  (deltaQDuring <= -857.2317249974815)) || deltaQDuring==0   &&  (deltaPDuring !=0   &&  (deltaPDuring > 301.7365325)))))
		{
			node = 27;
			prediction = 7;
			probability = 0.994220;

		}/* node 28 */
		else if ((((deltaPDuring !=0   &&  (deltaPDuring <= 532.5751220454802)) || deltaPDuring==0   &&  (deltaQDuring==0  || (deltaQDuring > -806.6923525))))  &&  (deltaPDuring==0  || (deltaPDuring > -1058.216643039065))  &&  (((deltaQDuring !=0   &&  (deltaQDuring <= 314.5150056049885)) || deltaQDuring==0   &&  (deltaPDuring==0  || (deltaPDuring > -158.9578955))))  &&  (((deltaQDuring !=0   &&  (deltaQDuring <= -423.7250150386998)) || deltaQDuring==0   &&  (deltaPDuring !=0   &&  (deltaPDuring > 148.128046))))  &&  (((deltaQDuring !=0   &&  (deltaQDuring > -857.2317249974815)) || deltaQDuring==0   &&  (deltaPDuring==0  || (deltaPDuring <= 301.7365325)))))
		{
			node = 28;
			prediction = 6;
			probability = 0.894102;

		}/* node 41 */
		else if ((((deltaPDuring !=0   &&  (deltaPDuring <= 532.5751220454802)) || deltaPDuring==0   &&  (deltaQDuring==0  || (deltaQDuring > -806.6923525))))  &&  (deltaPDuring==0  || (deltaPDuring > -1058.216643039065))  &&  (((deltaQDuring !=0   &&  (deltaQDuring <= 314.5150056049885)) || deltaQDuring==0   &&  (deltaPDuring==0  || (deltaPDuring > -158.9578955))))  &&  (((deltaQDuring !=0   &&  (deltaQDuring > -423.7250150386998)) || deltaQDuring==0   &&  (deltaPDuring==0  || (deltaPDuring <= 148.128046))))  &&  (((deltaQDuring !=0   &&  (deltaQDuring <= -113.8784674122736)) || deltaQDuring==0   &&  (deltaPDuring !=0   &&  (deltaPDuring > 63.316189))))  &&  (deltaPDuring !=0   &&  (deltaPDuring <= -98.07373611587812)))
		{
			node = 41;
			prediction = 3;
			probability = 0.993590;

		}/* node 55 */
		else if ((((deltaPDuring !=0   &&  (deltaPDuring <= 532.5751220454802)) || deltaPDuring==0   &&  (deltaQDuring==0  || (deltaQDuring > -806.6923525))))  &&  (deltaPDuring==0  || (deltaPDuring > -1058.216643039065))  &&  (((deltaQDuring !=0   &&  (deltaQDuring <= 314.5150056049885)) || deltaQDuring==0   &&  (deltaPDuring==0  || (deltaPDuring > -158.9578955))))  &&  (((deltaQDuring !=0   &&  (deltaQDuring > -423.7250150386998)) || deltaQDuring==0   &&  (deltaPDuring==0  || (deltaPDuring <= 148.128046))))  &&  (((deltaQDuring !=0   &&  (deltaQDuring <= -113.8784674122736)) || deltaQDuring==0   &&  (deltaPDuring !=0   &&  (deltaPDuring > 63.316189))))  &&  (deltaPDuring==0  || (deltaPDuring > -98.07373611587812))  &&  (((deltaQDuring !=0   &&  (deltaQDuring <= -232.3911911145869)) || deltaQDuring==0   &&  (deltaPDuring==0  || (deltaPDuring > 73.88925))))  &&  (deltaQDuring==0  || (deltaQDuring <= -237.0380895544011)))
		{
			node = 55;
			prediction = 1;
			probability = 0.999230;

		}/* node 56 */
		else if ((((deltaPDuring !=0   &&  (deltaPDuring <= 532.5751220454802)) || deltaPDuring==0   &&  (deltaQDuring==0  || (deltaQDuring > -806.6923525))))  &&  (deltaPDuring==0  || (deltaPDuring > -1058.216643039065))  &&  (((deltaQDuring !=0   &&  (deltaQDuring <= 314.5150056049885)) || deltaQDuring==0   &&  (deltaPDuring==0  || (deltaPDuring > -158.9578955))))  &&  (((deltaQDuring !=0   &&  (deltaQDuring > -423.7250150386998)) || deltaQDuring==0   &&  (deltaPDuring==0  || (deltaPDuring <= 148.128046))))  &&  (((deltaQDuring !=0   &&  (deltaQDuring <= -113.8784674122736)) || deltaQDuring==0   &&  (deltaPDuring !=0   &&  (deltaPDuring > 63.316189))))  &&  (deltaPDuring==0  || (deltaPDuring > -98.07373611587812))  &&  (((deltaQDuring !=0   &&  (deltaQDuring <= -232.3911911145869)) || deltaQDuring==0   &&  (deltaPDuring==0  || (deltaPDuring > 73.88925))))  &&  (deltaQDuring !=0   &&  (deltaQDuring > -237.0380895544011)))
		{
			node = 56;
			prediction = 2;
			probability = 0.976744;

		}/* node 48 */
		else if ((((deltaPDuring !=0   &&  (deltaPDuring <= 532.5751220454802)) || deltaPDuring==0   &&  (deltaQDuring==0  || (deltaQDuring > -806.6923525))))  &&  (deltaPDuring==0  || (deltaPDuring > -1058.216643039065))  &&  (((deltaQDuring !=0   &&  (deltaQDuring <= 314.5150056049885)) || deltaQDuring==0   &&  (deltaPDuring==0  || (deltaPDuring > -158.9578955))))  &&  (((deltaQDuring !=0   &&  (deltaQDuring > -423.7250150386998)) || deltaQDuring==0   &&  (deltaPDuring==0  || (deltaPDuring <= 148.128046))))  &&  (((deltaQDuring !=0   &&  (deltaQDuring <= -113.8784674122736)) || deltaQDuring==0   &&  (deltaPDuring !=0   &&  (deltaPDuring > 63.316189))))  &&  (deltaPDuring==0  || (deltaPDuring > -98.07373611587812))  &&  (((deltaQDuring !=0   &&  (deltaQDuring > -232.3911911145869)) || deltaQDuring==0   &&  (deltaPDuring !=0   &&  (deltaPDuring <= 73.88925)))))
		{
			node = 48;
			prediction = 2;
			probability = 1.000000;

		}/* node 57 */
		else if ((((deltaPDuring !=0   &&  (deltaPDuring <= 532.5751220454802)) || deltaPDuring==0   &&  (deltaQDuring==0  || (deltaQDuring > -806.6923525))))  &&  (deltaPDuring==0  || (deltaPDuring > -1058.216643039065))  &&  (((deltaQDuring !=0   &&  (deltaQDuring <= 314.5150056049885)) || deltaQDuring==0   &&  (deltaPDuring==0  || (deltaPDuring > -158.9578955))))  &&  (((deltaQDuring !=0   &&  (deltaQDuring > -423.7250150386998)) || deltaQDuring==0   &&  (deltaPDuring==0  || (deltaPDuring <= 148.128046))))  &&  (((deltaQDuring !=0   &&  (deltaQDuring > -113.8784674122736)) || deltaQDuring==0   &&  (deltaPDuring==0  || (deltaPDuring <= 63.316189))))  &&  (((deltaQDuring !=0   &&  (deltaQDuring <= 68.06727685687696)) || deltaQDuring==0   &&  (deltaPDuring==0  || (deltaPDuring <= 432.818169))))  &&  (deltaPDuring !=0   &&  (deltaPDuring <= -362.7133471675755))  &&  (((deltaPDuring !=0   &&  (deltaPDuring <= -850.5751685534256)) || deltaPDuring==0   &&  (deltaQDuring==0  || (deltaQDuring > -61.0417585)))))
		{
			node = 57;
			prediction = 21;
			probability = 0.993590;

		}/* node 58 */
		else if ((((deltaPDuring !=0   &&  (deltaPDuring <= 532.5751220454802)) || deltaPDuring==0   &&  (deltaQDuring==0  || (deltaQDuring > -806.6923525))))  &&  (deltaPDuring==0  || (deltaPDuring > -1058.216643039065))  &&  (((deltaQDuring !=0   &&  (deltaQDuring <= 314.5150056049885)) || deltaQDuring==0   &&  (deltaPDuring==0  || (deltaPDuring > -158.9578955))))  &&  (((deltaQDuring !=0   &&  (deltaQDuring > -423.7250150386998)) || deltaQDuring==0   &&  (deltaPDuring==0  || (deltaPDuring <= 148.128046))))  &&  (((deltaQDuring !=0   &&  (deltaQDuring > -113.8784674122736)) || deltaQDuring==0   &&  (deltaPDuring==0  || (deltaPDuring <= 63.316189))))  &&  (((deltaQDuring !=0   &&  (deltaQDuring <= 68.06727685687696)) || deltaQDuring==0   &&  (deltaPDuring==0  || (deltaPDuring <= 432.818169))))  &&  (deltaPDuring !=0   &&  (deltaPDuring <= -362.7133471675755))  &&  (((deltaPDuring !=0   &&  (deltaPDuring > -850.5751685534256)) || deltaPDuring==0   &&  (deltaQDuring !=0   &&  (deltaQDuring <= -61.0417585)))))
		{
			node = 58;
			prediction = 3;
			probability = 0.890183;

		}/* node 59 */
		else if ((((deltaPDuring !=0   &&  (deltaPDuring <= 532.5751220454802)) || deltaPDuring==0   &&  (deltaQDuring==0  || (deltaQDuring > -806.6923525))))  &&  (deltaPDuring==0  || (deltaPDuring > -1058.216643039065))  &&  (((deltaQDuring !=0   &&  (deltaQDuring <= 314.5150056049885)) || deltaQDuring==0   &&  (deltaPDuring==0  || (deltaPDuring > -158.9578955))))  &&  (((deltaQDuring !=0   &&  (deltaQDuring > -423.7250150386998)) || deltaQDuring==0   &&  (deltaPDuring==0  || (deltaPDuring <= 148.128046))))  &&  (((deltaQDuring !=0   &&  (deltaQDuring > -113.8784674122736)) || deltaQDuring==0   &&  (deltaPDuring==0  || (deltaPDuring <= 63.316189))))  &&  (((deltaQDuring !=0   &&  (deltaQDuring <= 68.06727685687696)) || deltaQDuring==0   &&  (deltaPDuring==0  || (deltaPDuring <= 432.818169))))  &&  (deltaPDuring==0  || (deltaPDuring > -362.7133471675755))  &&  (deltaQDuring !=0   &&  (deltaQDuring <= -57.00096674163616)))
		{
			node = 59;
			prediction = 2;
			probability = 0.800730;

		}/* node 60 */
		else if ((((deltaPDuring !=0   &&  (deltaPDuring <= 532.5751220454802)) || deltaPDuring==0   &&  (deltaQDuring==0  || (deltaQDuring > -806.6923525))))  &&  (deltaPDuring==0  || (deltaPDuring > -1058.216643039065))  &&  (((deltaQDuring !=0   &&  (deltaQDuring <= 314.5150056049885)) || deltaQDuring==0   &&  (deltaPDuring==0  || (deltaPDuring > -158.9578955))))  &&  (((deltaQDuring !=0   &&  (deltaQDuring > -423.7250150386998)) || deltaQDuring==0   &&  (deltaPDuring==0  || (deltaPDuring <= 148.128046))))  &&  (((deltaQDuring !=0   &&  (deltaQDuring > -113.8784674122736)) || deltaQDuring==0   &&  (deltaPDuring==0  || (deltaPDuring <= 63.316189))))  &&  (((deltaQDuring !=0   &&  (deltaQDuring <= 68.06727685687696)) || deltaQDuring==0   &&  (deltaPDuring==0  || (deltaPDuring <= 432.818169))))  &&  (deltaPDuring==0  || (deltaPDuring > -362.7133471675755))  &&  (deltaQDuring==0  || (deltaQDuring > -57.00096674163616)))
		{
			node = 60;
			prediction = 16;
			probability = 0.961091;

		}/* node 51 */
		else if ((((deltaPDuring !=0   &&  (deltaPDuring <= 532.5751220454802)) || deltaPDuring==0   &&  (deltaQDuring==0  || (deltaQDuring > -806.6923525))))  &&  (deltaPDuring==0  || (deltaPDuring > -1058.216643039065))  &&  (((deltaQDuring !=0   &&  (deltaQDuring <= 314.5150056049885)) || deltaQDuring==0   &&  (deltaPDuring==0  || (deltaPDuring > -158.9578955))))  &&  (((deltaQDuring !=0   &&  (deltaQDuring > -423.7250150386998)) || deltaQDuring==0   &&  (deltaPDuring==0  || (deltaPDuring <= 148.128046))))  &&  (((deltaQDuring !=0   &&  (deltaQDuring > -113.8784674122736)) || deltaQDuring==0   &&  (deltaPDuring==0  || (deltaPDuring <= 63.316189))))  &&  (((deltaQDuring !=0   &&  (deltaQDuring > 68.06727685687696)) || deltaQDuring==0   &&  (deltaPDuring !=0   &&  (deltaPDuring > 432.818169))))  &&  (((deltaQDuring !=0   &&  (deltaQDuring <= 206.3304014487137)) || deltaQDuring==0   &&  (deltaPDuring==0  || (deltaPDuring > -144.4354435)))))
		{
			node = 51;
			prediction = 15;
			probability = 0.921995;

		}/* node 52 */
		else if ((((deltaPDuring !=0   &&  (deltaPDuring <= 532.5751220454802)) || deltaPDuring==0   &&  (deltaQDuring==0  || (deltaQDuring > -806.6923525))))  &&  (deltaPDuring==0  || (deltaPDuring > -1058.216643039065))  &&  (((deltaQDuring !=0   &&  (deltaQDuring <= 314.5150056049885)) || deltaQDuring==0   &&  (deltaPDuring==0  || (deltaPDuring > -158.9578955))))  &&  (((deltaQDuring !=0   &&  (deltaQDuring > -423.7250150386998)) || deltaQDuring==0   &&  (deltaPDuring==0  || (deltaPDuring <= 148.128046))))  &&  (((deltaQDuring !=0   &&  (deltaQDuring > -113.8784674122736)) || deltaQDuring==0   &&  (deltaPDuring==0  || (deltaPDuring <= 63.316189))))  &&  (((deltaQDuring !=0   &&  (deltaQDuring > 68.06727685687696)) || deltaQDuring==0   &&  (deltaPDuring !=0   &&  (deltaPDuring > 432.818169))))  &&  (((deltaQDuring !=0   &&  (deltaQDuring > 206.3304014487137)) || deltaQDuring==0   &&  (deltaPDuring !=0   &&  (deltaPDuring <= -144.4354435)))))
		{
			node = 52;
			prediction = 25;
			probability = 0.999651;

		}/* node 31 */
		else if ((((deltaPDuring !=0   &&  (deltaPDuring <= 532.5751220454802)) || deltaPDuring==0   &&  (deltaQDuring==0  || (deltaQDuring > -806.6923525))))  &&  (deltaPDuring==0  || (deltaPDuring > -1058.216643039065))  &&  (((deltaQDuring !=0   &&  (deltaQDuring > 314.5150056049885)) || deltaQDuring==0   &&  (deltaPDuring !=0   &&  (deltaPDuring <= -158.9578955))))  &&  (((deltaQDuring !=0   &&  (deltaQDuring <= 659.3898289014337)) || deltaQDuring==0   &&  (deltaPDuring !=0   &&  (deltaPDuring > -156.2785645))))  &&  (((deltaQDuring !=0   &&  (deltaQDuring <= 402.6885027712262)) || deltaQDuring==0   &&  (deltaPDuring !=0   &&  (deltaPDuring > -90.443861)))))
		{
			node = 31;
			prediction = 25;
			probability = 1.000000;

		}/* node 32 */
		else if ((((deltaPDuring !=0   &&  (deltaPDuring <= 532.5751220454802)) || deltaPDuring==0   &&  (deltaQDuring==0  || (deltaQDuring > -806.6923525))))  &&  (deltaPDuring==0  || (deltaPDuring > -1058.216643039065))  &&  (((deltaQDuring !=0   &&  (deltaQDuring > 314.5150056049885)) || deltaQDuring==0   &&  (deltaPDuring !=0   &&  (deltaPDuring <= -158.9578955))))  &&  (((deltaQDuring !=0   &&  (deltaQDuring <= 659.3898289014337)) || deltaQDuring==0   &&  (deltaPDuring !=0   &&  (deltaPDuring > -156.2785645))))  &&  (((deltaQDuring !=0   &&  (deltaQDuring > 402.6885027712262)) || deltaQDuring==0   &&  (deltaPDuring==0  || (deltaPDuring <= -90.443861)))))
		{
			node = 32;
			prediction = 22;
			probability = 0.993454;

		}/* node 61 */
		else if ((((deltaPDuring !=0   &&  (deltaPDuring <= 532.5751220454802)) || deltaPDuring==0   &&  (deltaQDuring==0  || (deltaQDuring > -806.6923525))))  &&  (deltaPDuring==0  || (deltaPDuring > -1058.216643039065))  &&  (((deltaQDuring !=0   &&  (deltaQDuring > 314.5150056049885)) || deltaQDuring==0   &&  (deltaPDuring !=0   &&  (deltaPDuring <= -158.9578955))))  &&  (((deltaQDuring !=0   &&  (deltaQDuring > 659.3898289014337)) || deltaQDuring==0   &&  (deltaPDuring==0  || (deltaPDuring <= -156.2785645))))  &&  (((deltaQDuring !=0   &&  (deltaQDuring <= 994.5160454378472)) || deltaQDuring==0   &&  (deltaPDuring==0  || (deltaPDuring > -301.0461535))))  &&  (deltaQDuring==0  || (deltaQDuring <= 979.2089712511126))  &&  (((deltaQDuring !=0   &&  (deltaQDuring <= 895.0261938715838)) || deltaQDuring==0   &&  (deltaPDuring==0  || (deltaPDuring > -249.690493))))  &&  (((deltaQDuring !=0   &&  (deltaQDuring <= 679.2148598704965)) || deltaQDuring==0   &&  (deltaPDuring !=0   &&  (deltaPDuring > -132.935098)))))
		{
			node = 61;
			prediction = 22;
			probability = 0.985673;

		}/* node 62 */
		else if ((((deltaPDuring !=0   &&  (deltaPDuring <= 532.5751220454802)) || deltaPDuring==0   &&  (deltaQDuring==0  || (deltaQDuring > -806.6923525))))  &&  (deltaPDuring==0  || (deltaPDuring > -1058.216643039065))  &&  (((deltaQDuring !=0   &&  (deltaQDuring > 314.5150056049885)) || deltaQDuring==0   &&  (deltaPDuring !=0   &&  (deltaPDuring <= -158.9578955))))  &&  (((deltaQDuring !=0   &&  (deltaQDuring > 659.3898289014337)) || deltaQDuring==0   &&  (deltaPDuring==0  || (deltaPDuring <= -156.2785645))))  &&  (((deltaQDuring !=0   &&  (deltaQDuring <= 994.5160454378472)) || deltaQDuring==0   &&  (deltaPDuring==0  || (deltaPDuring > -301.0461535))))  &&  (deltaQDuring==0  || (deltaQDuring <= 979.2089712511126))  &&  (((deltaQDuring !=0   &&  (deltaQDuring <= 895.0261938715838)) || deltaQDuring==0   &&  (deltaPDuring==0  || (deltaPDuring > -249.690493))))  &&  (((deltaQDuring !=0   &&  (deltaQDuring > 679.2148598704965)) || deltaQDuring==0   &&  (deltaPDuring==0  || (deltaPDuring <= -132.935098)))))
		{
			node = 62;
			prediction = 24;
			probability = 0.999775;

		}/* node 54 */
		else if ((((deltaPDuring !=0   &&  (deltaPDuring <= 532.5751220454802)) || deltaPDuring==0   &&  (deltaQDuring==0  || (deltaQDuring > -806.6923525))))  &&  (deltaPDuring==0  || (deltaPDuring > -1058.216643039065))  &&  (((deltaQDuring !=0   &&  (deltaQDuring > 314.5150056049885)) || deltaQDuring==0   &&  (deltaPDuring !=0   &&  (deltaPDuring <= -158.9578955))))  &&  (((deltaQDuring !=0   &&  (deltaQDuring > 659.3898289014337)) || deltaQDuring==0   &&  (deltaPDuring==0  || (deltaPDuring <= -156.2785645))))  &&  (((deltaQDuring !=0   &&  (deltaQDuring <= 994.5160454378472)) || deltaQDuring==0   &&  (deltaPDuring==0  || (deltaPDuring > -301.0461535))))  &&  (deltaQDuring==0  || (deltaQDuring <= 979.2089712511126))  &&  (((deltaQDuring !=0   &&  (deltaQDuring > 895.0261938715838)) || deltaQDuring==0   &&  (deltaPDuring !=0   &&  (deltaPDuring <= -249.690493)))))
		{
			node = 54;
			prediction = 24;
			probability = 0.997235;

		}/* node 46 */
		else if ((((deltaPDuring !=0   &&  (deltaPDuring <= 532.5751220454802)) || deltaPDuring==0   &&  (deltaQDuring==0  || (deltaQDuring > -806.6923525))))  &&  (deltaPDuring==0  || (deltaPDuring > -1058.216643039065))  &&  (((deltaQDuring !=0   &&  (deltaQDuring > 314.5150056049885)) || deltaQDuring==0   &&  (deltaPDuring !=0   &&  (deltaPDuring <= -158.9578955))))  &&  (((deltaQDuring !=0   &&  (deltaQDuring > 659.3898289014337)) || deltaQDuring==0   &&  (deltaPDuring==0  || (deltaPDuring <= -156.2785645))))  &&  (((deltaQDuring !=0   &&  (deltaQDuring <= 994.5160454378472)) || deltaQDuring==0   &&  (deltaPDuring==0  || (deltaPDuring > -301.0461535))))  &&  (deltaQDuring !=0   &&  (deltaQDuring > 979.2089712511126)))
		{
			node = 46;
			prediction = 23;
			probability = 0.942446;

		}/* node 34 */
		else if ((((deltaPDuring !=0   &&  (deltaPDuring <= 532.5751220454802)) || deltaPDuring==0   &&  (deltaQDuring==0  || (deltaQDuring > -806.6923525))))  &&  (deltaPDuring==0  || (deltaPDuring > -1058.216643039065))  &&  (((deltaQDuring !=0   &&  (deltaQDuring > 314.5150056049885)) || deltaQDuring==0   &&  (deltaPDuring !=0   &&  (deltaPDuring <= -158.9578955))))  &&  (((deltaQDuring !=0   &&  (deltaQDuring > 659.3898289014337)) || deltaQDuring==0   &&  (deltaPDuring==0  || (deltaPDuring <= -156.2785645))))  &&  (((deltaQDuring !=0   &&  (deltaQDuring > 994.5160454378472)) || deltaQDuring==0   &&  (deltaPDuring !=0   &&  (deltaPDuring <= -301.0461535)))))
		{
			node = 34;
			prediction = 23;
			probability = 1.000000;

		}/* node 11 */
		else if ((((deltaPDuring !=0   &&  (deltaPDuring > 532.5751220454802)) || deltaPDuring==0   &&  (deltaQDuring !=0   &&  (deltaQDuring <= -806.6923525))))  &&  (((deltaPDuring !=0   &&  (deltaPDuring <= 2232.925748937547)) || deltaPDuring==0   &&  (deltaQDuring==0  || (deltaQDuring <= 82.8043715))))  &&  (deltaQDuring !=0   &&  (deltaQDuring <= -213.7756075988746)))
		{
			node = 11;
			prediction = 4;
			probability = 0.804181;

		}/* node 21 */
		else if ((((deltaPDuring !=0   &&  (deltaPDuring > 532.5751220454802)) || deltaPDuring==0   &&  (deltaQDuring !=0   &&  (deltaQDuring <= -806.6923525))))  &&  (((deltaPDuring !=0   &&  (deltaPDuring <= 2232.925748937547)) || deltaPDuring==0   &&  (deltaQDuring==0  || (deltaQDuring <= 82.8043715))))  &&  (deltaQDuring==0  || (deltaQDuring > -213.7756075988746))  &&  (((deltaPDuring !=0   &&  (deltaPDuring <= 1022.698904188214)) || deltaPDuring==0   &&  (deltaQDuring !=0   &&  (deltaQDuring > 120.222765)))))
		{
			node = 21;
			prediction = 14;
			probability = 0.966357;

		}/* node 35 */
		else if ((((deltaPDuring !=0   &&  (deltaPDuring > 532.5751220454802)) || deltaPDuring==0   &&  (deltaQDuring !=0   &&  (deltaQDuring <= -806.6923525))))  &&  (((deltaPDuring !=0   &&  (deltaPDuring <= 2232.925748937547)) || deltaPDuring==0   &&  (deltaQDuring==0  || (deltaQDuring <= 82.8043715))))  &&  (deltaQDuring==0  || (deltaQDuring > -213.7756075988746))  &&  (((deltaPDuring !=0   &&  (deltaPDuring > 1022.698904188214)) || deltaPDuring==0   &&  (deltaQDuring==0  || (deltaQDuring <= 120.222765))))  &&  (deltaPDuring !=0   &&  (deltaPDuring <= 1477.215786880407)))
		{
			node = 35;
			prediction = 13;
			probability = 0.979307;

		}/* node 36 */
		else if ((((deltaPDuring !=0   &&  (deltaPDuring > 532.5751220454802)) || deltaPDuring==0   &&  (deltaQDuring !=0   &&  (deltaQDuring <= -806.6923525))))  &&  (((deltaPDuring !=0   &&  (deltaPDuring <= 2232.925748937547)) || deltaPDuring==0   &&  (deltaQDuring==0  || (deltaQDuring <= 82.8043715))))  &&  (deltaQDuring==0  || (deltaQDuring > -213.7756075988746))  &&  (((deltaPDuring !=0   &&  (deltaPDuring > 1022.698904188214)) || deltaPDuring==0   &&  (deltaQDuring==0  || (deltaQDuring <= 120.222765))))  &&  (deltaPDuring==0  || (deltaPDuring > 1477.215786880407)))
		{
			node = 36;
			prediction = 12;
			probability = 0.933695;

		}/* node 6 */
		else if((((deltaPDuring !=0   &&  (deltaPDuring > 532.5751220454802)) || deltaPDuring==0   &&  (deltaQDuring !=0   &&  (deltaQDuring <= -806.6923525))))  &&  (((deltaPDuring !=0   &&  (deltaPDuring > 2232.925748937547)) || deltaPDuring==0   &&  (deltaQDuring !=0   &&  (deltaQDuring > 82.8043715)))))
		{
			node = 6;
			prediction = 9;
			probability = 0.801097;
		
		}
		result[0]=prediction;
		result[1]=node;
		result[2]=(int) Math.round(probability*100);
		
		return result;
		
		
}
	
	public static String getClusterColor(int cluster_number){
		
		String color="#ffffff";
		Log.i("CLuster", "cluster "+cluster_number);
		for(int i=1;i<=25;i++){
			if(cluster_number==i){
				color=colors[i-1];
				break;
			}
		}
		return color;

	}
	
}
