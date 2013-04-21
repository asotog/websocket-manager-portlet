create table WebSocketManager_WebSocket (
	websocketId LONG not null primary key,
	name VARCHAR(75) null,
	description VARCHAR(75) null,
	port INTEGER,
	thread_id VARCHAR(75) null,
	active_ BOOLEAN
);