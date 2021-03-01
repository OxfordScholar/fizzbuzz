-- appId is GUID, appName is Unique
CREATE TABLE Application (
	appId			VARCHAR(36)			NOT NULL,
	appName			VARCHAR(100)		NOT NULL UNIQUE,
	PRIMARY KEY (appId)
);

CREATE TABLE Role (
	roleId			INT 			NOT NULL AUTO_INCREMENT,
	roleName		VARCHAR(100)	NOT NULL,
	appId			VARCHAR(36)		NOT NULL,
	PRIMARY KEY (roleID),
	FOREIGN KEY (appId) REFERENCES Application(appId)
);

CREATE TABLE User (
	userId			INT				NOT NULL AUTO_INCREMENT,
	userName		VARCHAR(100)	NOT NULL,
	PRIMARY KEY	(userId)			
);

CREATE TABLE User_roles (
	userId 			INT 			NOT NULL,
	roleId 			INT  			NOT NULL,
	PRIMARY KEY (userId, roleId),
	FOREIGN KEY (userId) REFERENCES User(userId),
	FOREIGN KEY (roleId) REFERENCES Role(roleId)
);