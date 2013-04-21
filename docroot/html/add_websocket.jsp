<%@ include file="/html/init.jsp"%>

<%
WebSocket websocket = new WebSocketImpl();
%>

<liferay-portlet:actionURL name="webSocketFormOperation" varImpl="webSocketFormOperationURL">
    <portlet:param name="cmd" value="add" />
    <portlet:param name="redirect" value="<%= redirectURL %>" />
</liferay-portlet:actionURL>

<liferay-ui:header backURL='<%= redirectURL %>'
        localizeTitle="<%= false %>" title='Add New WebSocket' />

<%@ include file="/html/websocket_form.jsp"%>