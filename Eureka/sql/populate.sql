 
INSERT INTO Authentication(user,password,enabled) VALUES ('guest','guest', TRUE);
INSERT INTO Authentication(user,password,enabled) VALUES ('admin','admin', TRUE);
 
INSERT INTO Authority (username, authority) VALUES ('guest', 'ROLE_USER');
INSERT INTO Authority (username, authority) VALUES ('admin', 'ROLE_ADMIN');
INSERT INTO Authority (username, authority) VALUES ('admin', 'ROLE_USER');

INSERT INTO  `USERS` (firstname, lastname,email, version, is_admin,rank, userid) VALUES ('MyGuest','LastName','test@test.com',0,0,0,'admin');
INSERT INTO `USERS` (firstname, lastname,email,version,is_admin,rank,userid) VALUES ('Rahul','Joshi','test@test.com',0,0,0,'guest');

					