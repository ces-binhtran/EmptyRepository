create index IX_BE14D5CA on Amf_AmfAuditEvent (eventType[$COLUMN_LENGTH:75$]);
create index IX_D376C850 on Amf_AmfAuditEvent (groupId);
create index IX_4B566F50 on Amf_AmfAuditEvent (userId, eventType[$COLUMN_LENGTH:75$]);