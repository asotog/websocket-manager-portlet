<%@ include file="/html/init.jsp"%>

<%
List<WebSocket> websocketsList = (List<WebSocket>) request.getAttribute("websockets-list");
%>
<div id="websocket-manager-container">
	<aui:form action="<%= portletURL.toString() %>" method="get" name="fm">
		<%@ include file="/html/toolbar.jsp"%>
	
		<liferay-ui:search-container deltaConfigurable="<%= true %>"
			emptyResultsMessage="There no created websockets"
			iteratorURL="<%= PortletURLUtil.clone(persistentURL, renderResponse) %>">
			<liferay-ui:search-container-results results="<%= websocketsList %>"
				total="<%= websocketsList.size() %>" />
	
			<liferay-ui:search-container-row
				className="com.liferay.sourcetek.websocketmanager.data.model.WebSocket"
				keyProperty="websocketId" modelVar="curWebSocket">
				<liferay-ui:search-container-column-text name="Name"
					value="<%= String.valueOf(curWebSocket.getName()) %>" />
	            <liferay-ui:search-container-column-text name="Port"
	                value="<%= String.valueOf(curWebSocket.getPort()) %>" />
	            <liferay-ui:search-container-column-text name="Description"
	                value="<%= String.valueOf(curWebSocket.getDescription()) %>" />
	            <liferay-ui:search-container-column-text name="Status" cssClass="status"
	                value='<%= (curWebSocket.getActive() ? "Up" : "Down") %>' />
                <liferay-ui:search-container-column-jsp align="right"
					path="/html/view_column_action.jsp" /> 
			    <liferay-ui:search-container-column-jsp align="left"
                    path="/html/websocket_operations.jsp" /> 
                <liferay-ui:search-container-column-jsp align="left"
                    path="/html/websocket_delete.jsp" />
			</liferay-ui:search-container-row>
	
			<liferay-ui:search-iterator />
		</liferay-ui:search-container>
	
	</aui:form>
</div>