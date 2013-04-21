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

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.BaseModel;

import com.liferay.sourcetek.websocketmanager.data.model.WebSocketClp;

import java.lang.reflect.Method;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Brian Wing Shun Chan
 */
public class ClpSerializer {
	public static String getServletContextName() {
		if (Validator.isNotNull(_servletContextName)) {
			return _servletContextName;
		}

		synchronized (ClpSerializer.class) {
			if (Validator.isNotNull(_servletContextName)) {
				return _servletContextName;
			}

			try {
				ClassLoader classLoader = ClpSerializer.class.getClassLoader();

				Class<?> portletPropsClass = classLoader.loadClass(
						"com.liferay.util.portlet.PortletProps");

				Method getMethod = portletPropsClass.getMethod("get",
						new Class<?>[] { String.class });

				String portletPropsServletContextName = (String)getMethod.invoke(null,
						"websocket-manager-portlet-deployment-context");

				if (Validator.isNotNull(portletPropsServletContextName)) {
					_servletContextName = portletPropsServletContextName;
				}
			}
			catch (Throwable t) {
				if (_log.isInfoEnabled()) {
					_log.info(
						"Unable to locate deployment context from portlet properties");
				}
			}

			if (Validator.isNull(_servletContextName)) {
				try {
					String propsUtilServletContextName = PropsUtil.get(
							"websocket-manager-portlet-deployment-context");

					if (Validator.isNotNull(propsUtilServletContextName)) {
						_servletContextName = propsUtilServletContextName;
					}
				}
				catch (Throwable t) {
					if (_log.isInfoEnabled()) {
						_log.info(
							"Unable to locate deployment context from portal properties");
					}
				}
			}

			if (Validator.isNull(_servletContextName)) {
				_servletContextName = "websocket-manager-portlet";
			}

			return _servletContextName;
		}
	}

	public static void setClassLoader(ClassLoader classLoader) {
		_classLoader = classLoader;
	}

	public static Object translateInput(BaseModel<?> oldModel) {
		Class<?> oldModelClass = oldModel.getClass();

		String oldModelClassName = oldModelClass.getName();

		if (oldModelClassName.equals(WebSocketClp.class.getName())) {
			return translateInputWebSocket(oldModel);
		}

		return oldModel;
	}

	public static Object translateInput(List<Object> oldList) {
		List<Object> newList = new ArrayList<Object>(oldList.size());

		for (int i = 0; i < oldList.size(); i++) {
			Object curObj = oldList.get(i);

			newList.add(translateInput(curObj));
		}

		return newList;
	}

	public static Object translateInputWebSocket(BaseModel<?> oldModel) {
		WebSocketClp oldCplModel = (WebSocketClp)oldModel;

		Thread currentThread = Thread.currentThread();

		ClassLoader contextClassLoader = currentThread.getContextClassLoader();

		try {
			currentThread.setContextClassLoader(_classLoader);

			try {
				Class<?> newModelClass = Class.forName("com.liferay.sourcetek.websocketmanager.data.model.impl.WebSocketImpl",
						true, _classLoader);

				Object newModel = newModelClass.newInstance();

				Method method0 = newModelClass.getMethod("setWebsocketId",
						new Class[] { Long.TYPE });

				Long value0 = new Long(oldCplModel.getWebsocketId());

				method0.invoke(newModel, value0);

				Method method1 = newModelClass.getMethod("setName",
						new Class[] { String.class });

				String value1 = oldCplModel.getName();

				method1.invoke(newModel, value1);

				Method method2 = newModelClass.getMethod("setDescription",
						new Class[] { String.class });

				String value2 = oldCplModel.getDescription();

				method2.invoke(newModel, value2);

				Method method3 = newModelClass.getMethod("setPort",
						new Class[] { Integer.TYPE });

				Integer value3 = new Integer(oldCplModel.getPort());

				method3.invoke(newModel, value3);

				Method method4 = newModelClass.getMethod("setThread_id",
						new Class[] { String.class });

				String value4 = oldCplModel.getThread_id();

				method4.invoke(newModel, value4);

				Method method5 = newModelClass.getMethod("setActive",
						new Class[] { Boolean.TYPE });

				Boolean value5 = new Boolean(oldCplModel.getActive());

				method5.invoke(newModel, value5);

				return newModel;
			}
			catch (Exception e) {
				_log.error(e, e);
			}
		}
		finally {
			currentThread.setContextClassLoader(contextClassLoader);
		}

		return oldModel;
	}

	public static Object translateInput(Object obj) {
		if (obj instanceof BaseModel<?>) {
			return translateInput((BaseModel<?>)obj);
		}
		else if (obj instanceof List<?>) {
			return translateInput((List<Object>)obj);
		}
		else {
			return obj;
		}
	}

	public static Object translateOutput(BaseModel<?> oldModel) {
		Class<?> oldModelClass = oldModel.getClass();

		String oldModelClassName = oldModelClass.getName();

		if (oldModelClassName.equals(
					"com.liferay.sourcetek.websocketmanager.data.model.impl.WebSocketImpl")) {
			return translateOutputWebSocket(oldModel);
		}

		return oldModel;
	}

	public static Object translateOutput(List<Object> oldList) {
		List<Object> newList = new ArrayList<Object>(oldList.size());

		for (int i = 0; i < oldList.size(); i++) {
			Object curObj = oldList.get(i);

			newList.add(translateOutput(curObj));
		}

		return newList;
	}

	public static Object translateOutput(Object obj) {
		if (obj instanceof BaseModel<?>) {
			return translateOutput((BaseModel<?>)obj);
		}
		else if (obj instanceof List<?>) {
			return translateOutput((List<Object>)obj);
		}
		else {
			return obj;
		}
	}

	public static Object translateOutputWebSocket(BaseModel<?> oldModel) {
		Thread currentThread = Thread.currentThread();

		ClassLoader contextClassLoader = currentThread.getContextClassLoader();

		try {
			currentThread.setContextClassLoader(_classLoader);

			try {
				WebSocketClp newModel = new WebSocketClp();

				Class<?> oldModelClass = oldModel.getClass();

				Method method0 = oldModelClass.getMethod("getWebsocketId");

				Long value0 = (Long)method0.invoke(oldModel, (Object[])null);

				newModel.setWebsocketId(value0);

				Method method1 = oldModelClass.getMethod("getName");

				String value1 = (String)method1.invoke(oldModel, (Object[])null);

				newModel.setName(value1);

				Method method2 = oldModelClass.getMethod("getDescription");

				String value2 = (String)method2.invoke(oldModel, (Object[])null);

				newModel.setDescription(value2);

				Method method3 = oldModelClass.getMethod("getPort");

				Integer value3 = (Integer)method3.invoke(oldModel,
						(Object[])null);

				newModel.setPort(value3);

				Method method4 = oldModelClass.getMethod("getThread_id");

				String value4 = (String)method4.invoke(oldModel, (Object[])null);

				newModel.setThread_id(value4);

				Method method5 = oldModelClass.getMethod("getActive");

				Boolean value5 = (Boolean)method5.invoke(oldModel,
						(Object[])null);

				newModel.setActive(value5);

				return newModel;
			}
			catch (Exception e) {
				_log.error(e, e);
			}
		}
		finally {
			currentThread.setContextClassLoader(contextClassLoader);
		}

		return oldModel;
	}

	private static Log _log = LogFactoryUtil.getLog(ClpSerializer.class);
	private static ClassLoader _classLoader;
	private static String _servletContextName;
}