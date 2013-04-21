AUI.add('websocket-utility', function (A, NAME) {
    function WebSocketUtility() {

    };
    WebSocketUtility.prototype = {
       
        /**
         * Executes an ajax request
         * 
         * @param cmd
         * @param webSocketId
         * @param callback
         */
        executeRequest: function (cmd, data, callback, resourceUrl) {
            var data = A.merge({cmd: cmd}, data);
            A.io(resourceUrl, {
                method: 'GET',
                data: data,
                on: {
                    success: function (id, o) {
                        var jsonResponse = A.JSON.parse(o.response);
                        callback(jsonResponse.result);
                    }
                },
                headers: {
                    'Content-Type': 'application/json'
                }
            });
        }
    };

    A.WebSocketUtility = WebSocketUtility;
    
}, '@VERSION@', {
    "requires": ["json-stringify", "io", "json-parse"]
});