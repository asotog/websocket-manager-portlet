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

package com.liferay.sourcetek.websocketmanager.data.model.impl;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import com.liferay.sourcetek.websocketmanager.data.model.WebSocket;

import java.io.Serializable;

/**
 * The cache model class for representing WebSocket in entity cache.
 *
 * @author alejandro.soto
 * @see WebSocket
 * @generated
 */
public class WebSocketCacheModel implements CacheModel<WebSocket>, Serializable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(13);

		sb.append("{websocketId=");
		sb.append(websocketId);
		sb.append(", name=");
		sb.append(name);
		sb.append(", description=");
		sb.append(description);
		sb.append(", port=");
		sb.append(port);
		sb.append(", thread_id=");
		sb.append(thread_id);
		sb.append(", active=");
		sb.append(active);
		sb.append("}");

		return sb.toString();
	}

	public WebSocket toEntityModel() {
		WebSocketImpl webSocketImpl = new WebSocketImpl();

		webSocketImpl.setWebsocketId(websocketId);

		if (name == null) {
			webSocketImpl.setName(StringPool.BLANK);
		}
		else {
			webSocketImpl.setName(name);
		}

		if (description == null) {
			webSocketImpl.setDescription(StringPool.BLANK);
		}
		else {
			webSocketImpl.setDescription(description);
		}

		webSocketImpl.setPort(port);

		if (thread_id == null) {
			webSocketImpl.setThread_id(StringPool.BLANK);
		}
		else {
			webSocketImpl.setThread_id(thread_id);
		}

		webSocketImpl.setActive(active);

		webSocketImpl.resetOriginalValues();

		return webSocketImpl;
	}

	public long websocketId;
	public String name;
	public String description;
	public int port;
	public String thread_id;
	public boolean active;
}