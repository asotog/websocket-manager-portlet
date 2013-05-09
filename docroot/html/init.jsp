<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>
<%@ taglib uri="http://liferay.com/tld/util" prefix="liferay-util" %>
<%@ taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme" %>
<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui" %>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%@ taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 


<%@page import="com.liferay.portal.kernel.util.StringPool" %>
<%@page import="javax.portlet.PortletURL" %>
<%@page import="java.util.List" %>
<%@page import="com.liferay.sourcetek.websocketmanager.WebSocketManagerUtil" %>
<%@page import="com.liferay.sourcetek.websocketmanager.data.model.WebSocket" %>
<%@page import="com.liferay.sourcetek.websocketmanager.data.model.impl.WebSocketImpl" %>
<%@page import="com.liferay.portlet.PortletURLUtil" %>
<%@page import="com.liferay.portlet.PortletURLUtil" %>
<%@ page import="com.liferay.portal.kernel.dao.search.ResultRow" %>
<%@ page import="com.liferay.portal.kernel.util.WebKeys" %>
<%@ page import="com.liferay.portal.kernel.util.ParamUtil" %>

<portlet:defineObjects />
<liferay-theme:defineObjects />

<%
PortletURL persistentURL = PortletURLUtil.getCurrent(renderRequest, renderResponse);
PortletURL portletURL = renderResponse.createRenderURL();
pageContext.setAttribute("portletURL", portletURL);
String redirectURL = ParamUtil.getString(request, "redirect");
%>
<script type="text/javascript">
var WEBSOCKET_MANAGER_RESOURCE_URL = "<portlet:resourceURL />";
</script>