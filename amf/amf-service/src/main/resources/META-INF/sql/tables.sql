create table Amf_AmfAuditEvent (
	amfAuditEventId LONG not null primary key,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	eventType VARCHAR(75) null,
	ipAddress VARCHAR(75) null,
	groupId LONG,
	companyId LONG
);