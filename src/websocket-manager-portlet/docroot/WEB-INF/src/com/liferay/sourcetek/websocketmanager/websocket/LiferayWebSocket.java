package com.liferay.sourcetek.websocketmanager.websocket;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

import java.net.InetSocketAddress;
import java.net.UnknownHostException;
import java.util.Collection;

import org.java_websocket.WebSocket;
import org.java_websocket.handshake.ClientHandshake;
import org.java_websocket.server.WebSocketServer;

public class LiferayWebSocket extends WebSocketServer {
	
	private static final Log _log = LogFactoryUtil
			.getLog(LiferayWebSocket.class);
	
	private int portNumber = 0;
	
	public LiferayWebSocket( int port ) throws UnknownHostException {
		super( new InetSocketAddress( port ) );
		this.portNumber = port;
	}

	@Override
	public void onClose(org.java_websocket.WebSocket arg0, int arg1,
			String arg2, boolean arg3) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onError(WebSocket conn, Exception ex) {
		ex.printStackTrace();
		if( conn != null ) {
			// some errors like port binding failed may not be assignable to a specific websocket
		}
	}

	@Override
	public void onMessage(WebSocket conn, String message) {
		this.sendToAll( message );
		_log.info( conn + ": " + message );
	}

	@Override
	public void onOpen(WebSocket conn, ClientHandshake handshake) {
		// TODO Auto-generated method stub
		this.sendToAll( "new connection: " + handshake.getResourceDescriptor() );
		_log.info(conn.getRemoteSocketAddress().getAddress().getHostAddress() + " connected to websocket on port " + this.portNumber);
	}
	
	/**
	 * Sends a message to all the websocket clients that are currently connected to this web socket
	 * 
	 * @param text
	 */
	public void sendToAll( String text ) {
		Collection<WebSocket> con = connections();
		synchronized ( con ) {
			for( WebSocket c : con ) {
				c.send( text );
			}
		}
	}

}