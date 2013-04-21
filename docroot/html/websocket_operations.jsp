<%@ include file="/html/init.jsp" %>

<%
    WebSocket webSocket = (WebSocket) ((ResultRow) request.getAttribute(WebKeys.SEARCH_CONTAINER_RESULT_ROW)).getObject();
%>
<a href="<%=String.valueOf(webSocket.getWebsocketId())%>" class="cmd start <%= (webSocket.getActive() ? "hidden" : "") %>">
    <img class="icon" src="/html/icons/site_settings.png" alt="">Start</a>
<a href="<%=String.valueOf(webSocket.getWebsocketId())%>" class="cmd stop <%= (webSocket.getActive() ? "" : "hidden") %>">
    <img class="icon" src="/html/icons/site_settings.png" alt="">Shutdown</a>
