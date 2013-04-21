package com.liferay.sourcetek.websocketmanager;

import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.util.PortalUtil;
import com.liferay.sourcetek.websocketmanager.data.model.WebSocket;
import com.liferay.sourcetek.websocketmanager.websocket.WSThread;
import com.liferay.util.bridges.mvc.MVCPortlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;
import javax.servlet.http.HttpServletResponse;

public class WebSocketManagerPortlet extends MVCPortlet {
	private static final Log _log = LogFactoryUtil
			.getLog(WebSocketManagerPortlet.class);
	
	private Map<String, WSThread> websocketsThreadMap = new HashMap<String, WSThread>();
	
	@Override
	public void init() throws PortletException {
		super.init();
		_log.info("Initializing websockets");
		this.websocketsThreadMap = WebSocketManagerUtil.initializeWebSockets(WebSocketManagerUtil.listAllWebSockets());
	}

	@Override
	public void destroy() {
		_log.info("Shutting down");
		_log.info("Stopping websockets threads...");
		WebSocketManagerUtil.shutdownWebSockets(websocketsThreadMap);
	}

	@Override
	public void doView(RenderRequest renderRequest,
			RenderResponse renderResponse) throws IOException, PortletException {
		List<WebSocket> websocketsList = WebSocketManagerUtil.listAllWebSockets();
		renderRequest.setAttribute("websockets-list", websocketsList);
		super.doView(renderRequest, renderResponse);
		
	}
	/**
	 * Action for websocket pages forms
	 * 
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	public void webSocketFormOperation(ActionRequest request, ActionResponse response) throws Exception {
		String cmd = request.getParameter("cmd");
		if (cmd.equals(WSManagerConst.ADD)) {
			 String name = ParamUtil.getString(request, "name");
			 String description = ParamUtil.getString(request, "description");
			 int port = ParamUtil.getInteger(request, "port");
			 WebSocketManagerUtil.addWebSocket(name, description, port);
		}
		if (cmd.equals(WSManagerConst.UPDATE)) {
			 long webSocketId = ParamUtil.getLong(request, "websocketId");
			 String name = ParamUtil.getString(request, "name");
			 String description = ParamUtil.getString(request, "description");
			 int port = ParamUtil.getInteger(request, "port");
			 WebSocketManagerUtil.updateWebSocket(this.websocketsThreadMap, webSocketId, name, description, port);
		}
	}

	@Override
	public void serveResource(ResourceRequest resourceRequest,
			ResourceResponse resourceResponse) throws IOException,
			PortletException {
		String cmd = ParamUtil.getString(resourceRequest, "cmd");
		if (cmd.equals(WSManagerConst.STOP) && ParamUtil.getString(resourceRequest, WSManagerConst.SOCKET_ID) != null) {
			String socketId = ParamUtil.getString(resourceRequest, WSManagerConst.SOCKET_ID);
			boolean stopped = WebSocketManagerUtil.shutdownWebSocket(this.websocketsThreadMap, socketId);
			JSONObject jsonResponse = JSONFactoryUtil.createJSONObject();
			jsonResponse.put(WSManagerConst.OPERATION, WSManagerConst.STOP);
			jsonResponse.put(WSManagerConst.RESULT, stopped);
			this.returnJSONObject(resourceResponse, jsonResponse);
		}
		if (cmd.equals(WSManagerConst.START) && ParamUtil.getString(resourceRequest, WSManagerConst.SOCKET_ID) != null) {
			String socketId = ParamUtil.getString(resourceRequest, WSManagerConst.SOCKET_ID);
			boolean started = WebSocketManagerUtil.startWebSocket(this.websocketsThreadMap, socketId);
			JSONObject jsonResponse = JSONFactoryUtil.createJSONObject();
			jsonResponse.put(WSManagerConst.OPERATION, WSManagerConst.START);
			jsonResponse.put(WSManagerConst.RESULT, started);
			this.returnJSONObject(resourceResponse, jsonResponse);
		}
		if (cmd.equals(WSManagerConst.DELETE)) {
			String socketId = ParamUtil.getString(resourceRequest, WSManagerConst.SOCKET_ID);
			WebSocketManagerUtil.deleteWebSocket(this.websocketsThreadMap, socketId);
			JSONObject jsonResponse = JSONFactoryUtil.createJSONObject();
			jsonResponse.put(WSManagerConst.OPERATION, WSManagerConst.DELETE);
			jsonResponse.put(WSManagerConst.RESULT, true);
			this.returnJSONObject(resourceResponse, jsonResponse);
		}
		if (cmd.equals(WSManagerConst.GET_ACTIVE)) {
			String socketId = ParamUtil.getString(resourceRequest, WSManagerConst.SOCKET_ID);
			JSONObject jsonResponse = JSONFactoryUtil.createJSONObject();
			jsonResponse.put(WSManagerConst.OPERATION, WSManagerConst.GET_ACTIVE);
			jsonResponse.put(WSManagerConst.RESULT, WebSocketManagerUtil.getActiveWebSocketToJSON(Long.valueOf(socketId)));
			this.returnJSONObject(resourceResponse, jsonResponse);
		}
		if (cmd.equals(WSManagerConst.GET_ALL_ACTIVE)) {
			JSONObject jsonResponse = JSONFactoryUtil.createJSONObject();
			jsonResponse.put(WSManagerConst.OPERATION, WSManagerConst.GET_ALL_ACTIVE);
			jsonResponse.put(WSManagerConst.RESULT, WebSocketManagerUtil.getAllActiveWebSocketsToJSON());
			this.returnJSONObject(resourceResponse, jsonResponse);
		}
	}
	
	/**
	 * Return the json response
	 * 
	 * @param response
	 * @param jsonObject
	 */
	private void returnJSONObject(ResourceResponse response,
			JSONObject jsonObject) {
		HttpServletResponse servletResponse = PortalUtil
				.getHttpServletResponse(response);
		PrintWriter pw;
		try {
			pw = servletResponse.getWriter();
			pw.write(jsonObject.toString());
			pw.close();
		} catch (IOException e) {
			_log.error("Error while returning json", e);
		}
	}
}
