INSERT INTO Type (typeName) VALUES ('admin');
INSERT INTO Type (typeName) VALUES ('analyst');

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
