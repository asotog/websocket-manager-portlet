var wsUri = "ws://localhost:8081/";
var output;

function init() {
    testWebSocket();
}
function testWebSocket() {
    websocket = new WebSocket(wsUri);
    websocket.onopen = function (evt) {
        onOpen(evt)
    };
    websocket.onclose = function (evt) {
        onClose(evt)
    };
    websocket.onmessage = function (evt) {
        onMessage(evt)
    };
    websocket.onerror = function (evt) {
        onError(evt)
    };
}
function onOpen(evt) {
    doSend("LF WebSocket rocks");
}
function onClose(evt) {
    console.info('disconnected')
}
function onMessage(evt) {
    console.info(evt.data);
}
function onError(evt) {

}
function doSend(message) {
    websocket.send(message);
};
init();