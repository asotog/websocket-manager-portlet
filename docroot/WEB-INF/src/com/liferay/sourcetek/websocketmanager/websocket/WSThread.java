package com.liferay.sourcetek.websocketmanager.websocket;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.UnknownHostException;


public class WSThread extends Thread {
	private static final Log _log = LogFactoryUtil
			.getLog(WSThread.class);
	private int port;
	private LiferayWebSocket WS;
	private boolean available = true;
	
	public WSThread(int port) {
		super();
		this.port = port;
	}

	@Override
	public void run() {
		try {
			this.initializeLiferayWebSocket();
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * Starts the websocket server thread in the specified port
	 * 
	 * @throws UnknownHostException
	 */
	private void initializeLiferayWebSocket() throws UnknownHostException {
		LiferayWebSocket websocketServer = null;
		this.WS = new LiferayWebSocket(this.port);
		this.WS.start();
		_log.info("Websocket started on port : " + this.port);
		BufferedReader sysin = new BufferedReader( new InputStreamReader( System.in ) );
		while ( this.available ) {
			String in;
			try {
				in = sysin.readLine();
				this.WS.sendToAll( in );
			} catch (IOException e) {
				_log.info("An error has been generated : " + e.getMessage());
			}
		}
	}

	/**
	 * Stops the current websocket running in the thread
	 * 
	 */
	public void shutDownWebSocket() {
		try {
			this.WS.stop();
			this.setAvailable(false);
		} catch (IOException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public int getPort() {
		return port;
	}

	public void setPort(int port) {
		this.port = port;
	}

	public LiferayWebSocket getWS() {
		return WS;
	}

	public void setWS(LiferayWebSocket wS) {
		WS = wS;
	}

	public boolean isAvailable() {
		return available;
	}

	public void setAvailable(boolean available) {
		synchronized (this) {
			this.available = available;
		}
	}

}
