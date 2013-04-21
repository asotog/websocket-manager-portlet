<%@ include file="/html/toolbar.jsp"%>

<aui:form action="<%= webSocketFormOperationURL %>" method="post" name="fm">

	<aui:model-context model="<%= WebSocket.class %>" />

	<aui:fieldset>
		<aui:input name="name" label="WebSocket Name" value="<%=websocket.getName() %>"  />
		
		<aui:input name="description" cols="60" rows="8" type="textarea"  label="Description" value="<%=websocket.getDescription() %>"  />

        <aui:input name="port" label="Port" value="<%=String.valueOf(websocket.getPort()) %>" />
        
        <aui:input name="websocketId"  type="hidden" value="<%=String.valueOf(websocket.getWebsocketId()) %>" />
        
		<aui:button-row>
			<aui:button type="submit" />
			<aui:button href="<%= redirectURL %>" type="cancel" />
		</aui:button-row>
	</aui:fieldset>
</aui:form>