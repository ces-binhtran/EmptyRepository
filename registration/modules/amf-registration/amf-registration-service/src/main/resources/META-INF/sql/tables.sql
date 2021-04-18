create table AmfRegistration_UserCustom (
	userCustomId LONG not null primary key,
	homePhone VARCHAR(75) null,
	mobilePhone VARCHAR(75) null,
	userId LONG,
	address VARCHAR(75) null,
	address2 VARCHAR(75) null,
	city VARCHAR(75) null,
	state_ VARCHAR(75) null,
	zip VARCHAR(75) null,
	securityQuestion VARCHAR(75) null,
	securityAnswer VARCHAR(75) null,
	acceptedTou BOOLEAN
);