<%@ include file="/html/init.jsp"%>

<%
WebSocket websocket = null;
long socketId = ParamUtil.getLong(request, "socketId", -1);
if (socketId != -1) {
    websocket = WebSocketManagerUtil.getWebSocket(socketId);
} 
%>
<c:if test="<%= (websocket != null) %>">
	<%
	    String title = "Monitor "  + websocket.getName();
	%>
	<c:choose>
	<c:when test="<%= websocket.isActive() %>">
	   <script type="text/javascript">
        var WEBSOCKET_ID = <%=websocket.getWebsocketId() %>;
        </script>
        <liferay-ui:header backURL='<%= redirectURL %>'
                localizeTitle="<%= false %>" title="<%=title %>" />
                
        <div id="websocket-monitor-container"></div>
        
	</c:when>
	<c:otherwise>
	
	   <div class="portlet-msg-info">This websocket server is not running.</div>
	
	</c:otherwise>
	</c:choose>

</c:if>


