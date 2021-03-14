-- appId is GUID, appName is Unique
CREATE TABLE ds_application (
	application_id			VARCHAR(36)			NOT NULL,
	name			VARCHAR(100)		NOT NULL UNIQUE,
	PRIMARY KEY (application_id)
);

CREATE TABLE ds_group (
	group_id			INT 			NOT NULL AUTO_INCREMENT,
	name		VARCHAR(100)	NOT NULL,
	application_id			VARCHAR(36)		NOT NULL,
	PRIMARY KEY (group_id),
	FOREIGN KEY (application_id) REFERENCES ds_application(application_id)
);

CREATE TABLE ds_user (
	user_id			INT				NOT NULL AUTO_INCREMENT,
	name		VARCHAR(255)	NOT NULL UNIQUE,
	PRIMARY KEY	(user_id)			
);

CREATE TABLE ds_user_group (
	user_id 			INT 			NOT NULL,
	group_id 			INT  			NOT NULL,
	PRIMARY KEY (user_id, group_id),
	FOREIGN KEY (user_id) REFERENCES ds_user(user_id),
	FOREIGN KEY (group_id) REFERENCES ds_group(group_id)
);