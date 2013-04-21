AUI().use('websocket-manager', function(A) {
   A.on('domready', function() {
       if (A.one('#websocket-manager-container')) {
           var webSocketManager = new A.WebSocketManager({ srcNode: '#websocket-manager-container', resourceUrl: WEBSOCKET_MANAGER_RESOURCE_URL });
           webSocketManager.render();
       }
   });
});