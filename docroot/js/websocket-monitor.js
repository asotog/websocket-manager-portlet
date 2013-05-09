AUI.add('websocket-monitor', function (A, NAME) {

    A.WebSocketMonitor = A.Base.create('websocket-monitor', A.Widget, [], {

        initializer: function () {
            var me = this;
            if (this.get('websocketId')) {
                this.get('util').executeRequest('getActive', {
                    socketId: this.get('websocketId')
                }, function (data) {
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
            var me = this;
            var dataIndex = 0;
            if (this.get('websocketList') && this.get('websocketList').length > 0) {
                var socketList = this.get('websocketList');
                for (var i = 0; i < socketList.length; i++) {
                    var wsClient = new A.WebSocketClient({name: socketList[i].name, port: socketList[i].port});
                    wsClient.on('message', function (e) {
                        me._updateSocketData(dataIndex, e);
                    });
                }
                setInterval(function () {
                    me._updateChart(dataIndex);
                    dataIndex++;
                }, this.get('chartIntervals') * 1000);
            };
        },

        /**
         * Update the socket package transferred info
         * 
         * @param dataIndex
         * @param data
         */
        _updateSocketData: function(dataIndex, data) {
            var me = this;
            var name = me._generateSocketKey(data.socket_info.name);
            var socketsData = me.get('socketsMonitoringData');
            if (socketsData[dataIndex] && socketsData[dataIndex][name]) {
                socketsData[dataIndex][name] += 1;
            } else {
                socketsData[dataIndex] = (socketsData[dataIndex]) ? socketsData[dataIndex] : {};
                socketsData[dataIndex][name] = 1;
            }
            me.set('socketsMonitoringData', socketsData);
        },
        
        /**
         * Refresh chart with latest data
         * 
         * @param dataIndex
         */
        _updateChart: function (dataIndex) {
            var me = this;
            var socketsData = me.get('socketsMonitoringData');
            me.get('srcNode').all('div').remove();
            socketsData[dataIndex] = (socketsData[dataIndex]) ? socketsData[dataIndex] : {};
            socketsData[dataIndex].category = A.DataType.Date.format(new Date(), {format: "%x %X"});
            socketsData[dataIndex] = me._chartValuesFillFix(socketsData[dataIndex]);
            me.set('socketsMonitoringData', socketsData);
            new A.Chart({
                dataProvider: me.get('socketsMonitoringData'),
                render: me.get('srcNode')
            });
        },

        /**
         * When there is no data for a socket in one lapse of time filled with 0
         * 
         * @param data
         * @return data
         */
        _chartValuesFillFix: function (data) {
            var socketList = this.get('websocketList');
            for (var i = 0; i < socketList.length; i++) {
                var socketKey = this._generateSocketKey(socketList[i].name);
                data[socketKey] = (data[socketKey]) ? data[socketKey] : 0;
            }
            return data;
        },

        /**
         * Generate key for associative array/object
         * 
         * @param name
         * @returns string
         */
        _generateSocketKey: function (name) {
            return name.toLowerCase().replace(/\s+/g, '_');
        }

    }, {
        ATTRS: {
            websocketList: {
                value: []
            },

            socketsMonitoringData: {
                value: []
            },

            websocketId: {
                value: null
            },

            util: {
                value: new A.WebSocketUtility()
            },

            /**
             * Seconds to refresh chart
             */
            chartIntervals: {
                value: 5
            },

            resourceUrl: {
                value: null
            }
        },
        HTML_PARSER: {

        }
    });
}, '@VERSION@', {
    "requires": ["log", "widget", "base-build", "datatype-date-format", "substitute", "json-stringify", "io", "json-parse", "charts", "websocket-client", "websocket-utility"]
});