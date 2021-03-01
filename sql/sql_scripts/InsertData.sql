-- Insert dummy data into Application
INSERT INTO Application(appId, appName) VALUES ('111111111111111111111111111111111111', "App1");
INSERT INTO Application(appId, appName) VALUES ('222222222222222222222222222222222222', "App2");
INSERT INTO Application(appId, appName) VALUES ('333333333333333333333333333333333333', "App3");
INSERT INTO Application(appId, appName) VALUES ('444444444444444444444444444444444444', "App4");

--  Dummy data into Role
INSERT INTO Role (roleName, appId) VALUES ('admin', "111111111111111111111111111111111111");
INSERT INTO Role (roleName, appId) VALUES ('analyst', "444444444444444444444444444444444444");

-- Dummy data into User
INSERT INTO User (userName) VALUES ('Bob'); -- User ID 1
INSERT INTO User (userName) VALUES ('Helen'); -- User ID 2
INSERT INTO User (userName) VALUES ('Mike'); -- UserID 3
INSERT INTO User (userName) VALUES ('Gregg'); -- UserID 4
INSERT INTO User (userName) VALUES ('Jess'); -- UserID 5
INSERT INTO User (userName) VALUES ('Brenda'); -- UserID 6

-- Dummy data into User_roles
INSERT INTO User_roles(userId, roleId) VALUES (1, 1); -- (Bob, admin)
INSERT INTO User_roles(userId, roleId) VALUES (2, 1); -- (Helen, admin)
INSERT INTO User_roles(userId, roleId) VALUES (3, 2); -- (Mike, analyst)
INSERT INTO User_roles(userId, roleId) VALUES (4, 1); -- (Gregg, admin)
INSERT INTO User_roles(userId, roleId) VALUES (5, 2); -- (Jess, analyst)
INSERT INTO User_roles(userId, roleId) VALUES (6, 2); -- (Brenda, analyst)