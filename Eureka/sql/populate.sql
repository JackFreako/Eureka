 
INSERT INTO Authentication(user,password,enabled) VALUES ('guest','guest', TRUE);
INSERT INTO Authentication(user,password,enabled) VALUES ('admin','admin', TRUE);
 
INSERT INTO Authority (username, authority) VALUES ('guest', 'ROLE_USER');
INSERT INTO Authority (username, authority) VALUES ('admin', 'ROLE_ADMIN');
INSERT INTO Authority (username, authority) VALUES ('admin', 'ROLE_USER');

INSERT INTO  `USERS` (firstname, lastname,email, version, is_admin,rank, userid) VALUES ('MyGuest','LastName','test@test.com',0,0,0,'admin');
INSERT INTO `USERS` (firstname, lastname,email,version,is_admin,rank,userid) VALUES ('Rahul','Joshi','test@test.com',0,0,0,'guest');

INSERT INTO `Product` (`Name`,`Description`,`Price`) VALUES ("Apple Mac Book Pro 4","Laptop for pro use",1200);
INSERT INTO `Product` (`Name`,`Description`,`Price`) VALUES ("Apple Mac Book Air 4","Laptop for traveller",1100);
INSERT INTO `Product` (`Name`,`Description`,`Price`) VALUES ("Acer Aspire E","Laptop for media",350);
INSERT INTO `Product` (`Name`,`Description`,`Price`) VALUES ("Dell Inspiron","Laptop for multi use",500);
INSERT INTO `Product` (`Name`,`Description`,`Price`) VALUES ("Apple iPad 2","Tab for household use",200);
INSERT INTO `Product` (`Name`,`Description`,`Price`) VALUES ("Apple MD788LL/B iPad Air Tablet","High performance tab",400);
INSERT INTO `Product` (`Name`,`Description`,`Price`) VALUES ("Samsung Galaxy Tab A 8-Inch Tablet","Tab for normal use",130);
					