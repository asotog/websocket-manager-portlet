AUI.add('websocket-monitor', function (A, NAME) {

    A.WebSocketMonitor = A.Base.create('websocket-monitor', A.Widget, [], {
        
        initializer: function () {
            var me = this;
            if (this.get('websocketId')) {
                this.get('util').executeRequest('getActive', {socketId: this.get('websocketId')}, function (data) {
                    A.log('Single websocket data retrieved');
                    me.set('websocketList', data);
                }, this.get('resourceUrl'));
            } else {
                this.get('util').executeRequest('getAllActive', {}, function (data) {
                    A.log('All active websockets data retrieved');
                    me.set('websocketList', data);
                }, this.get('resourceUrl'));
            }
        },

        destructor: function () {
            
        },

        bindUI: function () {
            this.after('websocketListChange', this.syncUI, this);
        },

        syncUI: function () {
            if (this.get('websocketList') && this.get('websocketList').length > 0) {
                var socketList = this.get('websocketList');
                for ( var i = 0; i < socketList.length; i++) {
                    var wsClient = new A.WebSocketClient({name: socketList[i].name, port: socketList[i].port});
                    wsClient.on('message', function(e) {
                       console.info(e); 
                    });
                }
            }
        }

    }, {
        ATTRS: {
            websocketList: {
                value: []
            },
            
            websocketId: {
                value: null
            },
            
            util: {
                value: new A.WebSocketUtility()
            },
            
            resourceUrl: {
                value: null
            }
        },
        HTML_PARSER: {

        }
    });
},'@VERSION@', {
    "requires": ["log", "widget", "base-build", "substitute", "json-stringify", "io", "json-parse", "charts", "websocket-client", "websocket-utility"]
});