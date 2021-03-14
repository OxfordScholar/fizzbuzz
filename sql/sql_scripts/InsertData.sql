-- Insert dummy data into Application
INSERT INTO ds_application(application_id, name) VALUES ('111111111111111111111111111111111111', "App1");
INSERT INTO ds_application(application_id, name) VALUES ('222222222222222222222222222222222222', "App2");
INSERT INTO ds_application(application_id, name) VALUES ('333333333333333333333333333333333333', "App3");
INSERT INTO ds_application(application_id, name) VALUES ('444444444444444444444444444444444444', "App4");

--  Dummy data into Role
INSERT INTO ds_group (name, application_id) VALUES ('admin', "111111111111111111111111111111111111");
INSERT INTO ds_group (name, application_id) VALUES ('analyst', "111111111111111111111111111111111111");
INSERT INTO ds_group (name, application_id) VALUES ('analyst', "444444444444444444444444444444444444");

-- Dummy data into User
INSERT INTO ds_user (name) VALUES ('cn=Hawk Bob (hawkb),ou=people,o=oxfordscholar,c=au'); -- User ID 1
INSERT INTO ds_user (name) VALUES ('Helen'); -- User ID 2
INSERT INTO ds_user (name) VALUES ('Mike'); -- UserID 3
INSERT INTO ds_user (name) VALUES ('Gregg'); -- UserID 4
INSERT INTO ds_user (name) VALUES ('Jess'); -- UserID 5
INSERT INTO ds_user (name) VALUES ('Brenda'); -- UserID 6

-- Dummy data into User_roles
INSERT INTO ds_user_group(user_id, group_id) VALUES (1, 1); -- (Bob, admin)
INSERT INTO ds_user_group(user_id, group_id) VALUES (2, 1); -- (Helen, admin)
INSERT INTO ds_user_group(user_id, group_id) VALUES (3, 2); -- (Mike, analyst)
INSERT INTO ds_user_group(user_id, group_id) VALUES (4, 1); -- (Gregg, admin)
INSERT INTO ds_user_group(user_id, group_id) VALUES (5, 2); -- (Jess, analyst)
INSERT INTO ds_user_group(user_id, group_id) VALUES (6, 2); -- (Brenda, analyst)