package com.liferay.sourcetek.websocketmanager;

import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.sourcetek.websocketmanager.data.model.WebSocket;
import com.liferay.sourcetek.websocketmanager.data.service.WebSocketLocalServiceUtil;
import com.liferay.sourcetek.websocketmanager.websocket.WSThread;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WebSocketManagerUtil {
	private static final Log _log = LogFactoryUtil
			.getLog(WebSocketManagerUtil.class);
	
	/**
	 * Initialize all the active websockets when portlet is loaded first time or redeployed
	 * 
	 * @param websockets
	 * @return Map of started websockets
	 */
	public static Map<String, WSThread> initializeWebSockets(List<WebSocket> websockets) {
		Map<String, WSThread> websocketsThreadMap = new HashMap<String, WSThread>();
		for (WebSocket webSocket : websockets) {
			if (webSocket.getActive()) {
				WSThread websocketThread = new WSThread(webSocket.getPort());
				websocketThread.start();
				_log.info(webSocket.getName() + " initialized");
				websocketsThreadMap.put(String.valueOf(webSocket.getWebsocketId()), websocketThread);
			}
		}
		return websocketsThreadMap;
	}
	
	/**
	 * Stop all the websockets when portlet is undeployed
	 * 
	 * @param websockets
	 */
	public static void shutdownWebSockets(Map<String, WSThread> websockets) {
		for (String key : websockets.keySet()) {
			websockets.get(key).shutDownWebSocket();
			websockets.get(key).interrupt();
			_log.info("WebSocket " + key + " stopped");
		}
	}
	
	/**
	 * Start specific websocket
	 * 
	 * @param websockets
	 * @param socketId
	 * @return
	 */
	public static boolean startWebSocket(Map<String, WSThread> websockets, String socketId) {
		WebSocket websocket = null;
		try {
			websocket = WebSocketLocalServiceUtil.fetchWebSocket(Long.valueOf(socketId).longValue());
			if (websocket != null) {
				WSThread websocketThread = new WSThread(websocket.getPort());
				websocketThread.start();
				_log.info(websocket.getName() + " started");
				websockets.put(socketId, websocketThread);
				websocket.setActive(true);
				WebSocketLocalServiceUtil.updateWebSocket(websocket);
				return true;
			}
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SystemException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	
	/**
	 * Shuts down specific websocket
	 * 
	 * @param websockets
	 * @param socketId
	 */
	public static boolean shutdownWebSocket(Map<String, WSThread> websockets, String socketId) {
		if (websockets.get(socketId) != null) {
			websockets.get(socketId).shutDownWebSocket();
			websockets.get(socketId).interrupt();
			websockets.remove(socketId);
			_log.info("WebSocket " + socketId + " stopped");
			try {
				WebSocket websocket = WebSocketLocalServiceUtil.fetchWebSocket(Long.valueOf(socketId).longValue());
				websocket.setActive(false);
				WebSocketLocalServiceUtil.updateWebSocket(websocket);
			} catch (NumberFormatException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SystemException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return true;
		}
		_log.info("WebSocket " + socketId + " is not in memory");
		return false;
	}
	
	/**
	 * Lists all the websockets
	 * 
	 * @return
	 */
	public static List<WebSocket> listAllWebSockets() {
		List<WebSocket> websocketsList = new ArrayList<WebSocket>();
		int count = 0;
		try {
			count = WebSocketLocalServiceUtil.getWebSocketsCount();
			websocketsList = WebSocketLocalServiceUtil.getWebSockets(0, count);
		} catch (SystemException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		_log.info(websocketsList);
		return websocketsList;
	}
	
	/**
	 * Gets a websocket by socket id
	 * 
	 * @param socketId
	 * @return
	 */
	public static WebSocket getWebSocket(long socketId) {
		try {
			return WebSocketLocalServiceUtil.fetchWebSocket(socketId);
		} catch (SystemException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * Adds a new websocket by default as inactive so administrator should turn it on
	 * 
	 * @param name
	 * @param description
	 * @param port
	 */
	public static void addWebSocket(String name, String description, int port) {
		int count = 0;
		try {
			count = WebSocketLocalServiceUtil.getWebSocketsCount();
		} catch (SystemException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		WebSocket newSocket = WebSocketLocalServiceUtil.createWebSocket(count);
		newSocket.setWebsocketId(count);
		newSocket.setName(name);
		newSocket.setPort(port);
		newSocket.setThread_id("thread_id");
		newSocket.setDescription(description);
		newSocket.setActive(false);

		try {
			WebSocketLocalServiceUtil.addWebSocket(newSocket);
		} catch (SystemException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
	
	public static void updateWebSocket(Map<String, WSThread> websockets, long webSocketId, String name, String description, int port) {
		if (websockets.get(String.valueOf(webSocketId)) == null) {
			try {
				WebSocket websocket = WebSocketLocalServiceUtil.fetchWebSocket(webSocketId);
				websocket.setName(name);
				websocket.setDescription(description);
				websocket.setPort(port);
				WebSocketLocalServiceUtil.updateWebSocket(websocket);
			} catch (SystemException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	/**
	 * Delete a web socket from database, if active stops the thread 
	 * 
	 * @param webSocketId
	 */
	public static void deleteWebSocket(Map<String, WSThread> websockets, String webSocketId) {
		WebSocketManagerUtil.shutdownWebSocket(websockets, webSocketId);
		try {
			WebSocketLocalServiceUtil.deleteWebSocket(Long.valueOf(webSocketId));
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (PortalException e) {
			e.printStackTrace();
		} catch (SystemException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Gets an active websocket
	 * 
	 * @param webSocketId
	 * @return
	 */
	public static JSONArray getActiveWebSocketToJSON(long webSocketId) {
		JSONArray websockets = JSONFactoryUtil.createJSONArray();
		try {
			WebSocket websocket = WebSocketLocalServiceUtil.getWebSocket(webSocketId);
			_log.info(websocket.getActive());
			if (websocket.getActive()) {
				_log.info("Retrieving " + websocket);
				JSONObject websocketJSON = JSONFactoryUtil.createJSONObject();
				websocketJSON.put("name", websocket.getName());
				websocketJSON.put("port", websocket.getPort());
				websockets.put(websocketJSON);
			}
		} catch (PortalException e) {
		} catch (SystemException e) {
		}
		return websockets;
	}
	
	/**
	 * Gets all the active websockets
	 * 
	 * @return
	 */
	public static JSONArray getAllActiveWebSocketsToJSON() {
		JSONArray websocketsJSON = JSONFactoryUtil.createJSONArray();
		try {
			List<WebSocket> websockets = WebSocketLocalServiceUtil.getWebSockets(QueryUtil.ALL_POS, QueryUtil.ALL_POS);
			for (WebSocket webSocket : websockets) {
				if (webSocket.getActive()) {
					JSONObject websocketJSON = JSONFactoryUtil.createJSONObject();
					websocketJSON.put("name", webSocket.getName());
					websocketJSON.put("port", webSocket.getPort());
					websocketsJSON.put(websocketJSON);
				}
			}
		} catch (SystemException e) {
		}
		return websocketsJSON;
	}
}
