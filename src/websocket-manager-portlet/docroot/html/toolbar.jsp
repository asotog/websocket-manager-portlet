<%
String toolbarItem = ParamUtil.getString(request, "toolbarItem", "view-all");
%>
<div class="lfr-portlet-toolbar">
    <portlet:renderURL var="viewAllWebSocketUrl">
        <portlet:param name="redirect" value="<%= persistentURL.toString() %>" />
        <portlet:param name="toolbarItem" value="view-all" />
    </portlet:renderURL>
	<portlet:renderURL var="addWebSocketUrl">
	    <portlet:param name="redirect" value="<%= persistentURL.toString() %>" />
	    <portlet:param name="toolbarItem" value="add" />
	    <portlet:param name="jspPage" value="/html/add_websocket.jsp" />
	</portlet:renderURL>


	<span class="lfr-toolbar-button view-button <%= toolbarItem.equals("view-all") ? "current" : StringPool.BLANK %>">
		<a href="<%=viewAllWebSocketUrl %>"><liferay-ui:message key="view-all" /></a>
	</span> 
	<span class="lfr-toolbar-button add-button <%= toolbarItem.equals("add") ? "current" : StringPool.BLANK %>">
        <a href="<%=addWebSocketUrl %>">Add WebSocket</a>
    </span> 
    <span class="lfr-toolbar-button monitor-button <%= toolbarItem.equals("monitor-all") ? "current" : StringPool.BLANK %>">
        <a href="<%=addWebSocketUrl %>">Monitor All</a>
    </span> 


</div>