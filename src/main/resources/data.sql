/*
-- Query: SELECT * FROM adventureworks.AUTH_USER_GROUP
LIMIT 0, 1000

-- Date: 2018-09-26 23:16
*/
INSERT INTO `adventureworks.AUTH_USER_GROUP_data` (`AUTH_USER_GROUP_ID`,`AUTH_GROUP`,`USERNAME`) VALUES (1,'USER','adventure');
INSERT INTO `adventureworks.AUTH_USER_GROUP_data` (`AUTH_USER_GROUP_ID`,`AUTH_GROUP`,`USERNAME`) VALUES (2,'ADMIN','adventure');
INSERT INTO `adventureworks.AUTH_USER_GROUP_data` (`AUTH_USER_GROUP_ID`,`AUTH_GROUP`,`USERNAME`) VALUES (3,'USER','olcay');


/*
-- Query: SELECT * FROM adventureworks.USER
LIMIT 0, 1000

-- Date: 2018-09-26 23:17
*/
INSERT INTO `adventureworks.USER` (`USER_ID`,`PASSWORD`,`USERNAME`) VALUES (1,'$2a$11$zqA9103kzZgRV4ee9E9fl.lPPeWmFpODy0r8Ln2nLBZX.rNsazhmK','adventure');
INSERT INTO `adventureworks.USER` (`USER_ID`,`PASSWORD`,`USERNAME`) VALUES (2,'$2a$11$a26.u1mBiAFdDSdrZxzLaODRwNTUfgxBcp7osDyG7VBLc/xmTWPk6','olcay');

