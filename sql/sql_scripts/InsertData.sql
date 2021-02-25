-- Insert dummy data into Application
INSERT INTO Application(appName) VALUES ("App1");
INSERT INTO Application(appName) VALUES ("App2");
INSERT INTO Application(appName) VALUES ("App3");
INSERT INTO Application(appName) VALUES ("App4");

--  Dummy data into Type
INSERT INTO Type (typeName, appId) VALUES ('admin', 1);
INSERT INTO Type (typeName, appId) VALUES ('analyst', 4);

-- Dummy data into User
INSERT INTO User (userName) VALUES ('Bob'); -- User ID 1
INSERT INTO User (userName) VALUES ('Helen'); -- User ID 2
INSERT INTO User (userName) VALUES ('Mike'); -- UserID 3
INSERT INTO User (userName) VALUES ('Gregg'); -- UserID 4
INSERT INTO User (userName) VALUES ('Jess'); -- UserID 5
INSERT INTO User (userName) VALUES ('Brenda'); -- UserID 6

-- Dummy data into User_types
INSERT INTO User_types(userId, typeId) VALUES (1, 1); -- (Bob, admin)
INSERT INTO User_types(userId, typeId) VALUES (2, 1); -- (Helen, admin)
INSERT INTO User_types(userId, typeId) VALUES (3, 2); -- (Mike, analyst)
INSERT INTO User_types(userId, typeId) VALUES (4, 1); -- (Gregg, admin)
INSERT INTO User_types(userId, typeId) VALUES (5, 2); -- (Jess, analyst)
INSERT INTO User_types(userId, typeId) VALUES (6, 2); -- (Brenda, analyst)