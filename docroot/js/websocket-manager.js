AUI.add('websocket-manager', function (A, NAME) {

    A.WebSocketManager = A.Base.create('websocket-manager', A.Widget, [], {

        initializer: function () {

        },

        destructor: function () {

        },

        bindUI: function () {
            var me = this;
            this.get('contentBox').delegate('click', function (e) {
                e.preventDefault();
                me._cmdClick(e);
            }, '.cmd');
        },

        _cmdClick: function (e) {
            var target = e.currentTarget;
            var webSocketId = target.getAttribute('href');
            if (target.hasClass(this.get('START'))) {
                this._toggleWebSocketStatus(this.get('START'), webSocketId, this.get('UP'), target);
            }
            if (target.hasClass(this.get('STOP'))) {
                this._toggleWebSocketStatus(this.get('STOP'), webSocketId, this.get('DOWN'), target);
            }
            if (target.hasClass(this.get('DELETE'))) {
                var confirmation = confirm("This web socket will be removed. Are you sure, do you want to proceed?");
                if (confirmation == true) {
                    this._executeCmd(this.get('DELETE'), webSocketId, function () {
                        target.get('parentNode').get('parentNode').remove();
                    });
                }
            }
        },
        
        _toggleWebSocketStatus: function(operation, webSocketId, status, target) {
            this.get('util').executeRequest(operation, {socketId: webSocketId}, function () {
                target.get('parentNode').get('parentNode').one('.status').set('text', status);
                target.get('parentNode').one('.start').toggleClass('hidden');
                target.get('parentNode').one('.stop').toggleClass('hidden');
            }, this.get('resourceUrl'));
        },

        syncUI: function () {

        }

    }, {
        ATTRS: {
            resourceUrl: {
                value: null
            },
            
            util: {
                value: new A.WebSocketUtility()
            },
            
            START: {
                value: 'start'
            },
            
            DOWN: {
                value: 'Down'  
            },
            
            UP: {
                value: 'Up'  
            },
            
            STOP: {
                value: 'stop'
            },

            DELETE: {
                value: 'delete'
            }
        },
        HTML_PARSER: {

        }
    });

}, '@VERSION@', {
    "requires": ["widget", "base-build", "substitute", "websocket-utility"]
});