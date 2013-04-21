AUI.add('websocket-monitor', function (A, NAME) {

    A.WebSocketMonitor = A.Base.create('websocket-monitor', A.Widget, [], {
        initializer: function () {
            
        },

        destructor: function () {

        },

        bindUI: function () {

        },

        syncUI: function () {

        }

    }, {
        ATTRS: {
            websocketList: {
                value: []
            }
        },
        HTML_PARSER: {

        }
    });
},'@VERSION@', {
    "requires": ["widget", "base-build", "substitute", "json-stringify", "io", "json-parse", "charts"]
});