CREATE TABLE Type (
	typeId			INT 			NOT NULL AUTO_INCREMENT,
	typeName		VARCHAR(100)	NOT NULL,
	appId			INT				NOT NULL,
	PRIMARY KEY (typeID),
	FOREIGN KEY (appId) REFERENCES Application(appId)
);

CREATE TABLE User (
	userId			INT				NOT NULL AUTO_INCREMENT,
	userName		VARCHAR(100)	NOT NULL,
	PRIMARY KEY	(userId)			
);

CREATE TABLE User_types (
	userId 			INT 			NOT NULL,
	typeId 			INT  			NOT NULL,
	PRIMARY KEY (userId, typeId),
	FOREIGN KEY (userId) REFERENCES User(userId),
	FOREIGN KEY (typeId) REFERENCES Type(typeId)
);

CREATE TABLE Application (
	appId			INT				NOT NULL AUTO_INCREMENT,
	appName			INT				NOT NULL,
	PRIMARY KEY (appId)
);