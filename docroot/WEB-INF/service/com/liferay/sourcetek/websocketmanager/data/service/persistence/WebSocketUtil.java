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

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import com.liferay.sourcetek.websocketmanager.data.model.WebSocket;

import java.util.List;

/**
 * The persistence utility for the web socket service. This utility wraps {@link WebSocketPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author alejandro.soto
 * @see WebSocketPersistence
 * @see WebSocketPersistenceImpl
 * @generated
 */
public class WebSocketUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#clearCache()
	 */
	public static void clearCache() {
		getPersistence().clearCache();
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#clearCache(com.liferay.portal.model.BaseModel)
	 */
	public static void clearCache(WebSocket webSocket) {
		getPersistence().clearCache(webSocket);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#countWithDynamicQuery(DynamicQuery)
	 */
	public long countWithDynamicQuery(DynamicQuery dynamicQuery)
		throws SystemException {
		return getPersistence().countWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<WebSocket> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<WebSocket> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<WebSocket> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean)
	 */
	public static WebSocket update(WebSocket webSocket, boolean merge)
		throws SystemException {
		return getPersistence().update(webSocket, merge);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean, ServiceContext)
	 */
	public static WebSocket update(WebSocket webSocket, boolean merge,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(webSocket, merge, serviceContext);
	}

	/**
	* Caches the web socket in the entity cache if it is enabled.
	*
	* @param webSocket the web socket
	*/
	public static void cacheResult(
		com.liferay.sourcetek.websocketmanager.data.model.WebSocket webSocket) {
		getPersistence().cacheResult(webSocket);
	}

	/**
	* Caches the web sockets in the entity cache if it is enabled.
	*
	* @param webSockets the web sockets
	*/
	public static void cacheResult(
		java.util.List<com.liferay.sourcetek.websocketmanager.data.model.WebSocket> webSockets) {
		getPersistence().cacheResult(webSockets);
	}

	/**
	* Creates a new web socket with the primary key. Does not add the web socket to the database.
	*
	* @param websocketId the primary key for the new web socket
	* @return the new web socket
	*/
	public static com.liferay.sourcetek.websocketmanager.data.model.WebSocket create(
		long websocketId) {
		return getPersistence().create(websocketId);
	}

	/**
	* Removes the web socket with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param websocketId the primary key of the web socket
	* @return the web socket that was removed
	* @throws com.liferay.sourcetek.websocketmanager.data.NoSuchWebSocketException if a web socket with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.sourcetek.websocketmanager.data.model.WebSocket remove(
		long websocketId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.sourcetek.websocketmanager.data.NoSuchWebSocketException {
		return getPersistence().remove(websocketId);
	}

	public static com.liferay.sourcetek.websocketmanager.data.model.WebSocket updateImpl(
		com.liferay.sourcetek.websocketmanager.data.model.WebSocket webSocket,
		boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(webSocket, merge);
	}

	/**
	* Returns the web socket with the primary key or throws a {@link com.liferay.sourcetek.websocketmanager.data.NoSuchWebSocketException} if it could not be found.
	*
	* @param websocketId the primary key of the web socket
	* @return the web socket
	* @throws com.liferay.sourcetek.websocketmanager.data.NoSuchWebSocketException if a web socket with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.sourcetek.websocketmanager.data.model.WebSocket findByPrimaryKey(
		long websocketId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.sourcetek.websocketmanager.data.NoSuchWebSocketException {
		return getPersistence().findByPrimaryKey(websocketId);
	}

	/**
	* Returns the web socket with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param websocketId the primary key of the web socket
	* @return the web socket, or <code>null</code> if a web socket with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.sourcetek.websocketmanager.data.model.WebSocket fetchByPrimaryKey(
		long websocketId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(websocketId);
	}

	/**
	* Returns all the web sockets where name = &#63;.
	*
	* @param name the name
	* @return the matching web sockets
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.sourcetek.websocketmanager.data.model.WebSocket> findByName(
		java.lang.String name)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByName(name);
	}

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
	public static java.util.List<com.liferay.sourcetek.websocketmanager.data.model.WebSocket> findByName(
		java.lang.String name, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByName(name, start, end);
	}

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
	public static java.util.List<com.liferay.sourcetek.websocketmanager.data.model.WebSocket> findByName(
		java.lang.String name, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByName(name, start, end, orderByComparator);
	}

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
	public static com.liferay.sourcetek.websocketmanager.data.model.WebSocket findByName_First(
		java.lang.String name,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.sourcetek.websocketmanager.data.NoSuchWebSocketException {
		return getPersistence().findByName_First(name, orderByComparator);
	}

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
	public static com.liferay.sourcetek.websocketmanager.data.model.WebSocket findByName_Last(
		java.lang.String name,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.sourcetek.websocketmanager.data.NoSuchWebSocketException {
		return getPersistence().findByName_Last(name, orderByComparator);
	}

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
	public static com.liferay.sourcetek.websocketmanager.data.model.WebSocket[] findByName_PrevAndNext(
		long websocketId, java.lang.String name,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.sourcetek.websocketmanager.data.NoSuchWebSocketException {
		return getPersistence()
				   .findByName_PrevAndNext(websocketId, name, orderByComparator);
	}

	/**
	* Returns all the web sockets.
	*
	* @return the web sockets
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.sourcetek.websocketmanager.data.model.WebSocket> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
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
	public static java.util.List<com.liferay.sourcetek.websocketmanager.data.model.WebSocket> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

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
	public static java.util.List<com.liferay.sourcetek.websocketmanager.data.model.WebSocket> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the web sockets where name = &#63; from the database.
	*
	* @param name the name
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByName(java.lang.String name)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByName(name);
	}

	/**
	* Removes all the web sockets from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of web sockets where name = &#63;.
	*
	* @param name the name
	* @return the number of matching web sockets
	* @throws SystemException if a system exception occurred
	*/
	public static int countByName(java.lang.String name)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByName(name);
	}

	/**
	* Returns the number of web sockets.
	*
	* @return the number of web sockets
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static WebSocketPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (WebSocketPersistence)PortletBeanLocatorUtil.locate(com.liferay.sourcetek.websocketmanager.data.service.ClpSerializer.getServletContextName(),
					WebSocketPersistence.class.getName());

			ReferenceRegistry.registerReference(WebSocketUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	public void setPersistence(WebSocketPersistence persistence) {
		_persistence = persistence;

		ReferenceRegistry.registerReference(WebSocketUtil.class, "_persistence");
	}

	private static WebSocketPersistence _persistence;
}