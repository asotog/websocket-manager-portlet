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

package com.liferay.sourcetek.websocketmanager.data.service.persistence;

import com.liferay.portal.service.persistence.BasePersistence;

import com.liferay.sourcetek.websocketmanager.data.model.WebSocket;

/**
 * The persistence interface for the web socket service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author alejandro.soto
 * @see WebSocketPersistenceImpl
 * @see WebSocketUtil
 * @generated
 */
public interface WebSocketPersistence extends BasePersistence<WebSocket> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link WebSocketUtil} to access the web socket persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Caches the web socket in the entity cache if it is enabled.
	*
	* @param webSocket the web socket
	*/
	public void cacheResult(
		com.liferay.sourcetek.websocketmanager.data.model.WebSocket webSocket);

	/**
	* Caches the web sockets in the entity cache if it is enabled.
	*
	* @param webSockets the web sockets
	*/
	public void cacheResult(
		java.util.List<com.liferay.sourcetek.websocketmanager.data.model.WebSocket> webSockets);

	/**
	* Creates a new web socket with the primary key. Does not add the web socket to the database.
	*
	* @param websocketId the primary key for the new web socket
	* @return the new web socket
	*/
	public com.liferay.sourcetek.websocketmanager.data.model.WebSocket create(
		long websocketId);

	/**
	* Removes the web socket with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param websocketId the primary key of the web socket
	* @return the web socket that was removed
	* @throws com.liferay.sourcetek.websocketmanager.data.NoSuchWebSocketException if a web socket with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.sourcetek.websocketmanager.data.model.WebSocket remove(
		long websocketId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.sourcetek.websocketmanager.data.NoSuchWebSocketException;

	public com.liferay.sourcetek.websocketmanager.data.model.WebSocket updateImpl(
		com.liferay.sourcetek.websocketmanager.data.model.WebSocket webSocket,
		boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the web socket with the primary key or throws a {@link com.liferay.sourcetek.websocketmanager.data.NoSuchWebSocketException} if it could not be found.
	*
	* @param websocketId the primary key of the web socket
	* @return the web socket
	* @throws com.liferay.sourcetek.websocketmanager.data.NoSuchWebSocketException if a web socket with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.sourcetek.websocketmanager.data.model.WebSocket findByPrimaryKey(
		long websocketId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.sourcetek.websocketmanager.data.NoSuchWebSocketException;

	/**
	* Returns the web socket with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param websocketId the primary key of the web socket
	* @return the web socket, or <code>null</code> if a web socket with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.sourcetek.websocketmanager.data.model.WebSocket fetchByPrimaryKey(
		long websocketId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the web sockets where name = &#63;.
	*
	* @param name the name
	* @return the matching web sockets
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.sourcetek.websocketmanager.data.model.WebSocket> findByName(
		java.lang.String name)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the web sockets where name = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param name the name
	* @param start the lower bound of the range of web sockets
	* @param end the upper bound of the range of web sockets (not inclusive)
	* @return the range of matching web sockets
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.sourcetek.websocketmanager.data.model.WebSocket> findByName(
		java.lang.String name, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the web sockets where name = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param name the name
	* @param start the lower bound of the range of web sockets
	* @param end the upper bound of the range of web sockets (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching web sockets
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.sourcetek.websocketmanager.data.model.WebSocket> findByName(
		java.lang.String name, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first web socket in the ordered set where name = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param name the name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching web socket
	* @throws com.liferay.sourcetek.websocketmanager.data.NoSuchWebSocketException if a matching web socket could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.sourcetek.websocketmanager.data.model.WebSocket findByName_First(
		java.lang.String name,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.sourcetek.websocketmanager.data.NoSuchWebSocketException;

	/**
	* Returns the last web socket in the ordered set where name = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param name the name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching web socket
	* @throws com.liferay.sourcetek.websocketmanager.data.NoSuchWebSocketException if a matching web socket could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.sourcetek.websocketmanager.data.model.WebSocket findByName_Last(
		java.lang.String name,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.sourcetek.websocketmanager.data.NoSuchWebSocketException;

	/**
	* Returns the web sockets before and after the current web socket in the ordered set where name = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param websocketId the primary key of the current web socket
	* @param name the name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next web socket
	* @throws com.liferay.sourcetek.websocketmanager.data.NoSuchWebSocketException if a web socket with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.sourcetek.websocketmanager.data.model.WebSocket[] findByName_PrevAndNext(
		long websocketId, java.lang.String name,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.sourcetek.websocketmanager.data.NoSuchWebSocketException;

	/**
	* Returns all the web sockets.
	*
	* @return the web sockets
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.sourcetek.websocketmanager.data.model.WebSocket> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.liferay.sourcetek.websocketmanager.data.model.WebSocket> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the web sockets.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of web sockets
	* @param end the upper bound of the range of web sockets (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of web sockets
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.sourcetek.websocketmanager.data.model.WebSocket> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the web sockets where name = &#63; from the database.
	*
	* @param name the name
	* @throws SystemException if a system exception occurred
	*/
	public void removeByName(java.lang.String name)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the web sockets from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of web sockets where name = &#63;.
	*
	* @param name the name
	* @return the number of matching web sockets
	* @throws SystemException if a system exception occurred
	*/
	public int countByName(java.lang.String name)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of web sockets.
	*
	* @return the number of web sockets
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}