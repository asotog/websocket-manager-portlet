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

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.util.ClassLoaderProxy;
import com.liferay.portal.kernel.util.MethodCache;
import com.liferay.portal.kernel.util.ReferenceRegistry;

/**
 * The utility for the web socket remote service. This utility wraps {@link com.liferay.sourcetek.websocketmanager.data.service.impl.WebSocketServiceImpl} and is the primary access point for service operations in application layer code running on a remote server.
 *
 * <p>
 * This is a remote service. Methods of this service are expected to have security checks based on the propagated JAAS credentials because this service can be accessed remotely.
 * </p>
 *
 * @author alejandro.soto
 * @see WebSocketService
 * @see com.liferay.sourcetek.websocketmanager.data.service.base.WebSocketServiceBaseImpl
 * @see com.liferay.sourcetek.websocketmanager.data.service.impl.WebSocketServiceImpl
 * @generated
 */
public class WebSocketServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link com.liferay.sourcetek.websocketmanager.data.service.impl.WebSocketServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */
	public static void clearService() {
		_service = null;
	}

	public static WebSocketService getService() {
		if (_service == null) {
			Object object = PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					WebSocketService.class.getName());
			ClassLoader portletClassLoader = (ClassLoader)PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					"portletClassLoader");

			ClassLoaderProxy classLoaderProxy = new ClassLoaderProxy(object,
					WebSocketService.class.getName(), portletClassLoader);

			_service = new WebSocketServiceClp(classLoaderProxy);

			ClpSerializer.setClassLoader(portletClassLoader);

			ReferenceRegistry.registerReference(WebSocketServiceUtil.class,
				"_service");
			MethodCache.remove(WebSocketService.class);
		}

		return _service;
	}

	public void setService(WebSocketService service) {
		MethodCache.remove(WebSocketService.class);

		_service = service;

		ReferenceRegistry.registerReference(WebSocketServiceUtil.class,
			"_service");
		MethodCache.remove(WebSocketService.class);
	}

	private static WebSocketService _service;
}