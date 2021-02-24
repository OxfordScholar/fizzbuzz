INSERT INTO Application(appName) VALUES ("App1");
INSERT INTO Application(appName) VALUES ("App2");
INSERT INTO Application(appName) VALUES ("App3");
INSERT INTO Application(appName) VALUES ("App4");

INSERT INTO Type (typeName, appId) VALUES ('admin', 1);
INSERT INTO Type (typeName, appId) VALUES ('analyst', 4);

INSERT INTO User (userName) VALUES ('Bob');
INSERT INTO User (userName) VALUES ('Helen');
INSERT INTO User (userName) VALUES ('Mike');
INSERT INTO User (userName) VALUES ('Gregg');
INSERT INTO User (userName) VALUES ('Jess');
INSERT INTO User (userName) VALUES ('Brenda');

INSERT INTO User_types(userId, typeId) VALUES (1, 1);
INSERT INTO User_types(userId, typeId) VALUES (2, 1);
INSERT INTO User_types(userId, typeId) VALUES (3, 2);
INSERT INTO User_types(userId, typeId) VALUES (5, 2);
INSERT INTO User_types(userId, typeId) VALUES (6, 2);