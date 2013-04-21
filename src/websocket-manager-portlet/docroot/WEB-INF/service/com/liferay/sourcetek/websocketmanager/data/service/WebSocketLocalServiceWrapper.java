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
 * This class is a wrapper for {@link WebSocketLocalService}.
 * </p>
 *
 * @author    alejandro.soto
 * @see       WebSocketLocalService
 * @generated
 */
public class WebSocketLocalServiceWrapper implements WebSocketLocalService,
	ServiceWrapper<WebSocketLocalService> {
	public WebSocketLocalServiceWrapper(
		WebSocketLocalService webSocketLocalService) {
		_webSocketLocalService = webSocketLocalService;
	}

	/**
	* Adds the web socket to the database. Also notifies the appropriate model listeners.
	*
	* @param webSocket the web socket
	* @return the web socket that was added
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.sourcetek.websocketmanager.data.model.WebSocket addWebSocket(
		com.liferay.sourcetek.websocketmanager.data.model.WebSocket webSocket)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _webSocketLocalService.addWebSocket(webSocket);
	}

	/**
	* Creates a new web socket with the primary key. Does not add the web socket to the database.
	*
	* @param websocketId the primary key for the new web socket
	* @return the new web socket
	*/
	public com.liferay.sourcetek.websocketmanager.data.model.WebSocket createWebSocket(
		long websocketId) {
		return _webSocketLocalService.createWebSocket(websocketId);
	}

	/**
	* Deletes the web socket with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param websocketId the primary key of the web socket
	* @throws PortalException if a web socket with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public void deleteWebSocket(long websocketId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		_webSocketLocalService.deleteWebSocket(websocketId);
	}

	/**
	* Deletes the web socket from the database. Also notifies the appropriate model listeners.
	*
	* @param webSocket the web socket
	* @throws SystemException if a system exception occurred
	*/
	public void deleteWebSocket(
		com.liferay.sourcetek.websocketmanager.data.model.WebSocket webSocket)
		throws com.liferay.portal.kernel.exception.SystemException {
		_webSocketLocalService.deleteWebSocket(webSocket);
	}

	/**
	* Performs a dynamic query on the database and returns the matching rows.
	*
	* @param dynamicQuery the dynamic query
	* @return the matching rows
	* @throws SystemException if a system exception occurred
	*/
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _webSocketLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @return the range of matching rows
	* @throws SystemException if a system exception occurred
	*/
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException {
		return _webSocketLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching rows
	* @throws SystemException if a system exception occurred
	*/
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _webSocketLocalService.dynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	* Returns the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _webSocketLocalService.dynamicQueryCount(dynamicQuery);
	}

	public com.liferay.sourcetek.websocketmanager.data.model.WebSocket fetchWebSocket(
		long websocketId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _webSocketLocalService.fetchWebSocket(websocketId);
	}

	/**
	* Returns the web socket with the primary key.
	*
	* @param websocketId the primary key of the web socket
	* @return the web socket
	* @throws PortalException if a web socket with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.sourcetek.websocketmanager.data.model.WebSocket getWebSocket(
		long websocketId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _webSocketLocalService.getWebSocket(websocketId);
	}

	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _webSocketLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the web sockets.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of web sockets
	* @param end the upper bound of the range of web sockets (not inclusive)
	* @return the range of web sockets
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.sourcetek.websocketmanager.data.model.WebSocket> getWebSockets(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _webSocketLocalService.getWebSockets(start, end);
	}

	/**
	* Returns the number of web sockets.
	*
	* @return the number of web sockets
	* @throws SystemException if a system exception occurred
	*/
	public int getWebSocketsCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _webSocketLocalService.getWebSocketsCount();
	}

	/**
	* Updates the web socket in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param webSocket the web socket
	* @return the web socket that was updated
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.sourcetek.websocketmanager.data.model.WebSocket updateWebSocket(
		com.liferay.sourcetek.websocketmanager.data.model.WebSocket webSocket)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _webSocketLocalService.updateWebSocket(webSocket);
	}

	/**
	* Updates the web socket in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param webSocket the web socket
	* @param merge whether to merge the web socket with the current session. See {@link com.liferay.portal.service.persistence.BatchSession#update(com.liferay.portal.kernel.dao.orm.Session, com.liferay.portal.model.BaseModel, boolean)} for an explanation.
	* @return the web socket that was updated
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.sourcetek.websocketmanager.data.model.WebSocket updateWebSocket(
		com.liferay.sourcetek.websocketmanager.data.model.WebSocket webSocket,
		boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _webSocketLocalService.updateWebSocket(webSocket, merge);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	public java.lang.String getBeanIdentifier() {
		return _webSocketLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_webSocketLocalService.setBeanIdentifier(beanIdentifier);
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedService}
	 */
	public WebSocketLocalService getWrappedWebSocketLocalService() {
		return _webSocketLocalService;
	}

	/**
	 * @deprecated Renamed to {@link #setWrappedService}
	 */
	public void setWrappedWebSocketLocalService(
		WebSocketLocalService webSocketLocalService) {
		_webSocketLocalService = webSocketLocalService;
	}

	public WebSocketLocalService getWrappedService() {
		return _webSocketLocalService;
	}

	public void setWrappedService(WebSocketLocalService webSocketLocalService) {
		_webSocketLocalService = webSocketLocalService;
	}

	private WebSocketLocalService _webSocketLocalService;
}