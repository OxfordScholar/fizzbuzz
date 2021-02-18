CREATE TABLE Type (
	typeId			INT 			NOT NULL AUTO_INCREMENT,
	typeName		VARCHAR(100)	NOT NULL,
	PRIMARY KEY (typeID)
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