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

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.impl.BaseModelImpl;

import com.liferay.sourcetek.websocketmanager.data.service.WebSocketLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Proxy;

/**
 * @author alejandro.soto
 */
public class WebSocketClp extends BaseModelImpl<WebSocket> implements WebSocket {
	public WebSocketClp() {
	}

	public Class<?> getModelClass() {
		return WebSocket.class;
	}

	public String getModelClassName() {
		return WebSocket.class.getName();
	}

	public long getPrimaryKey() {
		return _websocketId;
	}

	public void setPrimaryKey(long primaryKey) {
		setWebsocketId(primaryKey);
	}

	public Serializable getPrimaryKeyObj() {
		return new Long(_websocketId);
	}

	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
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

	public void persist() throws SystemException {
		if (this.isNew()) {
			WebSocketLocalServiceUtil.addWebSocket(this);
		}
		else {
			WebSocketLocalServiceUtil.updateWebSocket(this);
		}
	}

	@Override
	public WebSocket toEscapedModel() {
		return (WebSocket)Proxy.newProxyInstance(WebSocket.class.getClassLoader(),
			new Class[] { WebSocket.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		WebSocketClp clone = new WebSocketClp();

		clone.setWebsocketId(getWebsocketId());
		clone.setName(getName());
		clone.setDescription(getDescription());
		clone.setPort(getPort());
		clone.setThread_id(getThread_id());
		clone.setActive(getActive());

		return clone;
	}

	public int compareTo(WebSocket webSocket) {
		int value = 0;

		value = getName().compareTo(webSocket.getName());

		if (value != 0) {
			return value;
		}

		return 0;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}

		WebSocketClp webSocket = null;

		try {
			webSocket = (WebSocketClp)obj;
		}
		catch (ClassCastException cce) {
			return false;
		}

		long primaryKey = webSocket.getPrimaryKey();

		if (getPrimaryKey() == primaryKey) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		return (int)getPrimaryKey();
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(13);

		sb.append("{websocketId=");
		sb.append(getWebsocketId());
		sb.append(", name=");
		sb.append(getName());
		sb.append(", description=");
		sb.append(getDescription());
		sb.append(", port=");
		sb.append(getPort());
		sb.append(", thread_id=");
		sb.append(getThread_id());
		sb.append(", active=");
		sb.append(getActive());
		sb.append("}");

		return sb.toString();
	}

	public String toXmlString() {
		StringBundler sb = new StringBundler(22);

		sb.append("<model><model-name>");
		sb.append("com.liferay.sourcetek.websocketmanager.data.model.WebSocket");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>websocketId</column-name><column-value><![CDATA[");
		sb.append(getWebsocketId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>name</column-name><column-value><![CDATA[");
		sb.append(getName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>description</column-name><column-value><![CDATA[");
		sb.append(getDescription());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>port</column-name><column-value><![CDATA[");
		sb.append(getPort());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>thread_id</column-name><column-value><![CDATA[");
		sb.append(getThread_id());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>active</column-name><column-value><![CDATA[");
		sb.append(getActive());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _websocketId;
	private String _name;
	private String _description;
	private int _port;
	private String _thread_id;
	private boolean _active;
}