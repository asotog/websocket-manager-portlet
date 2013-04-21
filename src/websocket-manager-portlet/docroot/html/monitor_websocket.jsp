<%@ include file="/html/init.jsp"%>

<%
WebSocket websocket = null;
long socketId = ParamUtil.getLong(request, "socketId", -1);
if (socketId != -1) {
    websocket = WebSocketManagerUtil.getWebSocket(socketId);
}
if (websocket != null) {
    String title = "Monitor "  + websocket.getName();
%>

<liferay-ui:header backURL='<%= redirectURL %>'
        localizeTitle="<%= false %>" title="<%=title %>" />
        
<div id="websocket-monitor-container">
    
</div>

<script type="text/javascript">
AUI().use('charts', function (A) {
    var myDataValues = [{
            category: "5/1/2010 12:00pm",
            values: 2000
        }, {
            category: "5/2/2010 12:10pm",
            values: 50
        }, {
            category: "5/3/2010",
            values: 400
        }, {
            category: "5/4/2010",
            values: 200
        }, {
            category: "5/5/2010",
            values: 5000
        }
    ];

    var mychart = new A.Chart({
        dataProvider: myDataValues,
        render: "#websocket-monitor-container"
    });
});
</script>
<% } %>


