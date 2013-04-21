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

package com.liferay.sourcetek.websocketmanager.data.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * <p>
 * This class is a wrapper for {@link WebSocketService}.
 * </p>
 *
 * @author    alejandro.soto
 * @see       WebSocketService
 * @generated
 */
public class WebSocketServiceWrapper implements WebSocketService,
	ServiceWrapper<WebSocketService> {
	public WebSocketServiceWrapper(WebSocketService webSocketService) {
		_webSocketService = webSocketService;
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedService}
	 */
	public WebSocketService getWrappedWebSocketService() {
		return _webSocketService;
	}

	/**
	 * @deprecated Renamed to {@link #setWrappedService}
	 */
	public void setWrappedWebSocketService(WebSocketService webSocketService) {
		_webSocketService = webSocketService;
	}

	public WebSocketService getWrappedService() {
		return _webSocketService;
	}

	public void setWrappedService(WebSocketService webSocketService) {
		_webSocketService = webSocketService;
	}

	private WebSocketService _webSocketService;
}