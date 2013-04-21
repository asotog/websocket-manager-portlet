/**
 * Copyright (c) 2000-2012 Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.liferay.sourcetek.websocketmanager.data.model;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link com.liferay.sourcetek.websocketmanager.data.service.http.WebSocketServiceSoap}.
 *
 * @author    alejandro.soto
 * @see       com.liferay.sourcetek.websocketmanager.data.service.http.WebSocketServiceSoap
 * @generated
 */
public class WebSocketSoap implements Serializable {
	public static WebSocketSoap toSoapModel(WebSocket model) {
		WebSocketSoap soapModel = new WebSocketSoap();

		soapModel.setWebsocketId(model.getWebsocketId());
		soapModel.setName(model.getName());
		soapModel.setDescription(model.getDescription());
		soapModel.setPort(model.getPort());
		soapModel.setThread_id(model.getThread_id());
		soapModel.setActive(model.getActive());

		return soapModel;
	}

	public static WebSocketSoap[] toSoapModels(WebSocket[] models) {
		WebSocketSoap[] soapModels = new WebSocketSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static WebSocketSoap[][] toSoapModels(WebSocket[][] models) {
		WebSocketSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new WebSocketSoap[models.length][models[0].length];
		}
		else {
			soapModels = new WebSocketSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static WebSocketSoap[] toSoapModels(List<WebSocket> models) {
		List<WebSocketSoap> soapModels = new ArrayList<WebSocketSoap>(models.size());

		for (WebSocket model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new WebSocketSoap[soapModels.size()]);
	}

	public WebSocketSoap() {
	}

	public long getPrimaryKey() {
		return _websocketId;
	}

	public void setPrimaryKey(long pk) {
		setWebsocketId(pk);
	}

	public long getWebsocketId() {
		return _websocketId;
	}

	public void setWebsocketId(long websocketId) {
		_websocketId = websocketId;
	}

	public String getName() {
		return _name;
	}

	public void setName(String name) {
		_name = name;
	}

	public String getDescription() {
		return _description;
	}

	public void setDescription(String description) {
		_description = description;
	}

	public int getPort() {
		return _port;
	}

	public void setPort(int port) {
		_port = port;
	}

	public String getThread_id() {
		return _thread_id;
	}

	public void setThread_id(String thread_id) {
		_thread_id = thread_id;
	}

	public boolean getActive() {
		return _active;
	}

	public boolean isActive() {
		return _active;
	}

	public void setActive(boolean active) {
		_active = active;
	}

	private long _websocketId;
	private String _name;
	private String _description;
	private int _port;
	private String _thread_id;
	private boolean _active;
}