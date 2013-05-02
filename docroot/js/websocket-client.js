AUI.add('websocket-client', function (A, NAME) {

    function WebSocketClient() {
        WebSocketClient.superclass.constructor.apply(this, arguments);
    }
    
    WebSocketClient.TEMPLATES = {
        WEBSOCKET_URL: '{protocol}://{host}:{port}/'
    };
    
    WebSocketClient.EVENTS = {
        ONMESSAGE: 'message'
    };
    
    WebSocketClient.ATTRS = {
        port: {
            value: null
        },
        name: {
            value: null
        },
        useWss: {
            value: false
        }
    };

    A.extend(WebSocketClient, A.Base, {

        initializer: function (cfg) {
            var me = this;
            var websocket = new WebSocket(this.retrieveSocketPath());
            websocket.onopen = function (e) {

            };
            websocket.onclose = function (e) {
               
            };
            websocket.onmessage = function (e) {
                var socketInfo = me.getSocketInfo();
                me.fire(WebSocketClient.EVENTS.ONMESSAGE, {message: e, socket_info: socketInfo});
            };
            websocket.onerror = function (e) {

            };
        },
        
        getSocketInfo: function() {
            return {name: this.get('name'), port: this.get('port')};
        },
        
        retrieveSocketPath: function() {
            return A.substitute(WebSocketClient.TEMPLATES.WEBSOCKET_URL, {protocol: (this.get('useWss') ? 'wss' : 'ws'), host: window.location.hostname, port: this.get('port') });
        },
        
        destroy: function () {

        }
    });

    A.WebSocketClient = WebSocketClient;

}, '0.1', {
    requires: ['base', 'substitute']
});