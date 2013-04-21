<%@ include file="/html/init.jsp"%>

<%
WebSocket websocket = new WebSocketImpl();
long socketId = ParamUtil.getLong(request, "socketId", -1);
if (socketId != -1) {
	websocket = WebSocketManagerUtil.getWebSocket(socketId);
}
%>


<liferay-portlet:actionURL name="webSocketFormOperation" varImpl="webSocketFormOperationURL">
    <portlet:param name="cmd" value="update" />
    <portlet:param name="redirect" value="<%= redirectURL %>" />
</liferay-portlet:actionURL>

<liferay-ui:header backURL='<%= redirectURL %>'
        localizeTitle="<%= false %>" title='Edit WebSocket' />

<%@ include file="/html/websocket_form.jsp"%>