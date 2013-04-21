<%@ include file="/html/init.jsp" %>

<%
    WebSocket webSocket = (WebSocket) ((ResultRow) request.getAttribute(WebKeys.SEARCH_CONTAINER_RESULT_ROW)).getObject();
%>
<a href="<%=String.valueOf(webSocket.getWebsocketId())%>" class="cmd delete">
    <img class="icon" src="/html/themes/control_panel/images/common/delete.png" alt="">Delete</a>