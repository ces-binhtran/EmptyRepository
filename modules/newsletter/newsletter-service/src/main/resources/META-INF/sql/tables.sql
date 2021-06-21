create table TS_NewsletterArticle (
	uuid_ VARCHAR(75) null,
	newsletterArticleId LONG not null primary key,
	companyId LONG,
	groupId LONG,
	classNameId LONG,
	classPK LONG,
	resourcePrimKey LONG,
	title VARCHAR(75) null,
	author VARCHAR(75) null,
	status INTEGER,
	order_ INTEGER,
	content VARCHAR(75) null
);

create table TS_NewsletterIssue (
	uuid_ VARCHAR(75) null,
	newsletterIssueId LONG not null primary key,
	companyId LONG,
	groupId LONG,
	issueNumber INTEGER,
	title VARCHAR(75) null,
	description VARCHAR(75) null,
	issueDate DATE null,
	status INTEGER,
	resourcePrimKey LONG
);