# Host: localhost  (Version 5.7.20-log)
# Date: 2018-04-19 15:39:31
# Generator: MySQL-Front 6.0  (Build 2.20)


#
# Structure for table "book"
#

DROP TABLE IF EXISTS `book`;
CREATE TABLE `book` (
  `book_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '图书ID',
  `name` varchar(100) NOT NULL COMMENT '图书名称',
  `number` int(11) NOT NULL COMMENT '图书数量',
  `detail` varchar(200) NOT NULL COMMENT '图书描述',
  PRIMARY KEY (`book_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='图书表';

#
# Data for table "book"
#


#
# Structure for table "friends"
#

DROP TABLE IF EXISTS `friends`;
CREATE TABLE `friends` (
  `friendid` varchar(11) DEFAULT NULL COMMENT '默认表',
  `friendname` varchar(255) DEFAULT NULL,
  `friendheadimg` varchar(255) DEFAULT NULL,
  `friendsignature` varchar(255) DEFAULT NULL,
  `friendemail` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

#
# Data for table "friends"
#

INSERT INTO `friends` VALUES ('1','张三','/img/xx.jpg','张三最帅','1111@163.com'),('2','李四','/img/yy.jpg','李四最帅','2222@qq.com');

#
# Structure for table "friends1"
#

DROP TABLE IF EXISTS `friends1`;
CREATE TABLE `friends1` (
  `userid` varchar(11) DEFAULT NULL,
  `userpassword` varchar(24) DEFAULT NULL,
  `usernickname` varchar(255) DEFAULT NULL,
  `useremail` varchar(255) DEFAULT NULL,
  `usersignature` varchar(255) DEFAULT NULL,
  `userheadimg` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

#
# Data for table "friends1"
#

INSERT INTO `friends1` VALUES ('2','123','昵称李四','123@qq.com','wo ye henshuai9',NULL),('5','123','昵称5',NULL,NULL,NULL);

#
# Structure for table "friends2"
#

DROP TABLE IF EXISTS `friends2`;
CREATE TABLE `friends2` (
  `userid` varchar(11) DEFAULT NULL,
  `userpassword` varchar(24) DEFAULT NULL,
  `usernickname` varchar(255) DEFAULT NULL,
  `useremail` varchar(255) DEFAULT NULL,
  `usersignature` varchar(255) DEFAULT NULL,
  `userheadimg` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

#
# Data for table "friends2"
#

INSERT INTO `friends2` VALUES ('1','123','昵称张三',NULL,NULL,NULL),('5','123','昵称5',NULL,NULL,NULL);

#
# Structure for table "friends5"
#

DROP TABLE IF EXISTS `friends5`;
CREATE TABLE `friends5` (
  `userid` varchar(11) DEFAULT NULL,
  `userpassword` varchar(24) DEFAULT NULL,
  `usernickname` varchar(255) DEFAULT NULL,
  `useremail` varchar(255) DEFAULT NULL,
  `usersignature` varchar(255) DEFAULT NULL,
  `userheadimg` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

#
# Data for table "friends5"
#

INSERT INTO `friends5` VALUES ('1','123','昵称张三',NULL,NULL,NULL),('2','123','昵称李四','123@qq.com','wo ye henshuai9',NULL);

#
# Structure for table "friendship"
#

DROP TABLE IF EXISTS `friendship`;
CREATE TABLE `friendship` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `mainid` varchar(255) DEFAULT NULL,
  `clientid` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`Id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8;

#
# Data for table "friendship"
#

INSERT INTO `friendship` VALUES (1,'1','2'),(2,'1','3'),(3,'1','4'),(4,'1','5'),(5,'2','1'),(6,'2','3'),(7,'3','2'),(8,'3','1'),(9,'2','3'),(10,'3','1'),(11,'3','4');

#
# Structure for table "userinfo"
#

DROP TABLE IF EXISTS `userinfo`;
CREATE TABLE `userinfo` (
  `userid` varchar(11) DEFAULT NULL,
  `userpassword` varchar(24) DEFAULT NULL,
  `usernickname` varchar(255) DEFAULT NULL,
  `useremail` varchar(255) DEFAULT NULL,
  `usersignature` varchar(255) DEFAULT NULL,
  `userheadimg` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用来存储所有用户信息';

#
# Data for table "userinfo"
#

INSERT INTO `userinfo` VALUES ('1','123','昵称张三','123@qq.com','我最帅',NULL),('2','123','昵称李四','123@qq.com','wo ye henshuai9',NULL),('5','123','昵称5','1','','');
