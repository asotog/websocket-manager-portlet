AUI().use('websocket-manager', 'websocket-monitor', function(A) {
   A.on('domready', function() {
       if (A.one('#websocket-manager-container')) {
           var webSocketManager = new A.WebSocketManager({ srcNode: '#websocket-manager-container', resourceUrl: WEBSOCKET_MANAGER_RESOURCE_URL });
           webSocketManager.render();
       }
       if (A.one('#websocket-monitor-container')) {
           var webSocketMonitor = new A.WebSocketMonitor({ srcNode: '#websocket-monitor-container', resourceUrl: WEBSOCKET_MANAGER_RESOURCE_URL, websocketId: WEBSOCKET_ID });
           webSocketMonitor.render();
       }
   });
});