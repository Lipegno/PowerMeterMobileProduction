package org.sinais.mobile.misc;

import org.sinais.mobile.custom.ui_handler.ScreenSaverHandler;
import org.sinais.mobile.custom.ui_handler.TabbedMenuHandler;
import org.sinais.mobile.services.SocketConnectionService;

import android.content.Context;
import android.util.Log;

public final class RuntimeConfigs {

	private final static String MODULE = "Runtime configurations";
	private final static ScreenSaverHandler screenH = new ScreenSaverHandler(50000);
	private final static TabbedMenuHandler tabMenuH = new TabbedMenuHandler();
	private SocketConnectionService requestReplySocket;
	private int eventsCount;
	private String meterIp;
	private int installation_id;
	private double renew_percent;
	private int webserver_port;
	
	public static class RunTimeConfigsHolder{
		public static final RuntimeConfigs configs = new RuntimeConfigs(); 
	}
	
	public static RuntimeConfigs getConfigs(){
		return RunTimeConfigsHolder.configs;
	}

	public void setEventsCount(int _eventsCount) {
		Log.i(MODULE, "Setting events count to "+ _eventsCount);
		this.eventsCount = _eventsCount;
	}

	public int getEventsCount() {
		Log.i(MODULE, "Getting events count to "+ eventsCount);
		return eventsCount;
	}
	
	public ScreenSaverHandler getScreenHandler(){
		return screenH;
	}
	
	public boolean handlerRunning(){
		return screenH.isRunning();
	}
	
	public void startHandler(){
		screenH.start();
	}
	
	public void setTabbedMenuContext(Context ctx){
		tabMenuH.setContext(ctx);
	}
	
	public TabbedMenuHandler getMenuHandler(){
		return tabMenuH;
	}

	public String getMeterIp() {
		return meterIp;
	}

	public void setMeterIp(String meterIp) {
		this.meterIp = meterIp;
	}

	public int getInstallation_id() {
		return installation_id;
	}

	public void setInstallation_id(int installation_id) {
		this.installation_id = installation_id;
	}

	public SocketConnectionService getRequestReplySocket() {
		return requestReplySocket;
	}

	public void setRequestReplySocket(SocketConnectionService requestReplySocket) {
		this.requestReplySocket = requestReplySocket;
	}

	public double getRenew_percent() {
		return renew_percent;
	}

	public void setRenew_percent(double renew_percent) {
		Log.i(MODULE, "renew quota updated");
		this.renew_percent = renew_percent;
	}

	public int getWebserver_port() {
		return webserver_port;
	}

	public void setWebserver_port(int webserver_port) {
		this.webserver_port = webserver_port;
	}
	

//	public static WebServiceHandler getWebHandler() {
//		return web_handler;
//	}
}
