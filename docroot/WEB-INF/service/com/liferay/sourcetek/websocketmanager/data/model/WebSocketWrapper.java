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

import com.liferay.portal.model.ModelWrapper;

/**
 * <p>
 * This class is a wrapper for {@link WebSocket}.
 * </p>
 *
 * @author    alejandro.soto
 * @see       WebSocket
 * @generated
 */
public class WebSocketWrapper implements WebSocket, ModelWrapper<WebSocket> {
	public WebSocketWrapper(WebSocket webSocket) {
		_webSocket = webSocket;
	}

	public Class<?> getModelClass() {
		return WebSocket.class;
	}

	public String getModelClassName() {
		return WebSocket.class.getName();
	}

	/**
	* Returns the primary key of this web socket.
	*
	* @return the primary key of this web socket
	*/
	public long getPrimaryKey() {
		return _webSocket.getPrimaryKey();
	}

	/**
	* Sets the primary key of this web socket.
	*
	* @param primaryKey the primary key of this web socket
	*/
	public void setPrimaryKey(long primaryKey) {
		_webSocket.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the websocket ID of this web socket.
	*
	* @return the websocket ID of this web socket
	*/
	public long getWebsocketId() {
		return _webSocket.getWebsocketId();
	}

	/**
	* Sets the websocket ID of this web socket.
	*
	* @param websocketId the websocket ID of this web socket
	*/
	public void setWebsocketId(long websocketId) {
		_webSocket.setWebsocketId(websocketId);
	}

	/**
	* Returns the name of this web socket.
	*
	* @return the name of this web socket
	*/
	public java.lang.String getName() {
		return _webSocket.getName();
	}

	/**
	* Sets the name of this web socket.
	*
	* @param name the name of this web socket
	*/
	public void setName(java.lang.String name) {
		_webSocket.setName(name);
	}

	/**
	* Returns the description of this web socket.
	*
	* @return the description of this web socket
	*/
	public java.lang.String getDescription() {
		return _webSocket.getDescription();
	}

	/**
	* Sets the description of this web socket.
	*
	* @param description the description of this web socket
	*/
	public void setDescription(java.lang.String description) {
		_webSocket.setDescription(description);
	}

	/**
	* Returns the port of this web socket.
	*
	* @return the port of this web socket
	*/
	public int getPort() {
		return _webSocket.getPort();
	}

	/**
	* Sets the port of this web socket.
	*
	* @param port the port of this web socket
	*/
	public void setPort(int port) {
		_webSocket.setPort(port);
	}

	/**
	* Returns the thread_id of this web socket.
	*
	* @return the thread_id of this web socket
	*/
	public java.lang.String getThread_id() {
		return _webSocket.getThread_id();
	}

	/**
	* Sets the thread_id of this web socket.
	*
	* @param thread_id the thread_id of this web socket
	*/
	public void setThread_id(java.lang.String thread_id) {
		_webSocket.setThread_id(thread_id);
	}

	/**
	* Returns the active of this web socket.
	*
	* @return the active of this web socket
	*/
	public boolean getActive() {
		return _webSocket.getActive();
	}

	/**
	* Returns <code>true</code> if this web socket is active.
	*
	* @return <code>true</code> if this web socket is active; <code>false</code> otherwise
	*/
	public boolean isActive() {
		return _webSocket.isActive();
	}

	/**
	* Sets whether this web socket is active.
	*
	* @param active the active of this web socket
	*/
	public void setActive(boolean active) {
		_webSocket.setActive(active);
	}

	public boolean isNew() {
		return _webSocket.isNew();
	}

	public void setNew(boolean n) {
		_webSocket.setNew(n);
	}

	public boolean isCachedModel() {
		return _webSocket.isCachedModel();
	}

	public void setCachedModel(boolean cachedModel) {
		_webSocket.setCachedModel(cachedModel);
	}

	public boolean isEscapedModel() {
		return _webSocket.isEscapedModel();
	}

	public java.io.Serializable getPrimaryKeyObj() {
		return _webSocket.getPrimaryKeyObj();
	}

	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_webSocket.setPrimaryKeyObj(primaryKeyObj);
	}

	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _webSocket.getExpandoBridge();
	}

	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_webSocket.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new WebSocketWrapper((WebSocket)_webSocket.clone());
	}

	public int compareTo(
		com.liferay.sourcetek.websocketmanager.data.model.WebSocket webSocket) {
		return _webSocket.compareTo(webSocket);
	}

	@Override
	public int hashCode() {
		return _webSocket.hashCode();
	}

	public com.liferay.portal.model.CacheModel<com.liferay.sourcetek.websocketmanager.data.model.WebSocket> toCacheModel() {
		return _webSocket.toCacheModel();
	}

	public com.liferay.sourcetek.websocketmanager.data.model.WebSocket toEscapedModel() {
		return new WebSocketWrapper(_webSocket.toEscapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _webSocket.toString();
	}

	public java.lang.String toXmlString() {
		return _webSocket.toXmlString();
	}

	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_webSocket.persist();
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedModel}
	 */
	public WebSocket getWrappedWebSocket() {
		return _webSocket;
	}

	public WebSocket getWrappedModel() {
		return _webSocket;
	}

	public void resetOriginalValues() {
		_webSocket.resetOriginalValues();
	}

	private WebSocket _webSocket;
}