<%@ include file="/html/init.jsp" %>

<%
	WebSocket webSocket = (WebSocket) ((ResultRow) request.getAttribute(WebKeys.SEARCH_CONTAINER_RESULT_ROW)).getObject();
%>
<portlet:renderURL var="updateWebSocketUrl">
	<portlet:param name="redirect" value="<%=persistentURL.toString()%>" />
	<portlet:param name="jspPage" value="/html/update_websocket.jsp" />
	<portlet:param name="socketId" value="<%=String.valueOf(webSocket.getWebsocketId())%>" />
</portlet:renderURL>

<portlet:renderURL var="monitorWebSocketUrl">
    <portlet:param name="redirect" value="<%=persistentURL.toString()%>" />
    <portlet:param name="jspPage" value="/html/monitor_websocket.jsp" />
    <portlet:param name="socketId" value="<%=String.valueOf(webSocket.getWebsocketId())%>" />
</portlet:renderURL>

<liferay-ui:icon-menu>
    <liferay-ui:icon image="edit" method="get" cssClass="edit" url="<%=updateWebSocketUrl %>" message="Edit WebSocket"/>
    <liferay-ui:icon image="edit" method="get" cssClass="monitor" url="<%=monitorWebSocketUrl %>" message="Monitor WebSocket"/>
</liferay-ui:icon-menu>
