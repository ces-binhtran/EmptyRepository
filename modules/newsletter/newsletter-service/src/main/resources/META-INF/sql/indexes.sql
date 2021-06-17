create index IX_BEB40E18 on TS_NewsletterArticle (resourcePrimKey);
create index IX_3E80AFD7 on TS_NewsletterArticle (uuid_[$COLUMN_LENGTH:75$], companyId);
create unique index IX_7514019 on TS_NewsletterArticle (uuid_[$COLUMN_LENGTH:75$], groupId);

create index IX_5F3D7395 on TS_NewsletterIssue (resourcePrimKey);
create index IX_AF23F9FA on TS_NewsletterIssue (uuid_[$COLUMN_LENGTH:75$], companyId);
create unique index IX_EB76B6FC on TS_NewsletterIssue (uuid_[$COLUMN_LENGTH:75$], groupId);