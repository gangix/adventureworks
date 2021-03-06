ALTER TABLE adventureworks.productreview
ADD COLUMN InAppropriate  BIT(1)  AFTER ModifiedDate;


ALTER TABLE adventureworks.productreview MODIFY COLUMN ProductReviewID BIGINT;



CREATE TABLE `adventureworks.USER` (
  `USER_ID` bigint(20) NOT NULL,
  `USERNAME` varchar(255) DEFAULT NULL,
  `PASSWORD` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`USER_ID`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;


CREATE TABLE `adventureworks.AUTH_USER_GROUP` (
  `AUTH_USER_GROUP_ID` bigint(20) NOT NULL,
  `AUTH_GROUP` varchar(255) DEFAULT NULL,
  `USERNAME` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`AUTH_USER_GROUP_ID`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;


