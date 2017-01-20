# Host: localhost  (Version: 5.5.53)
# Date: 2017-01-20 10:58:15
# Generator: MySQL-Front 5.3  (Build 4.234)
# jdbc:mysql://localhost:3306/main

/*!40101 SET NAMES utf8 */;

#
# Structure for table "article"
#

DROP TABLE IF EXISTS `article`;
CREATE TABLE `article` (
	`Id`       INT(11) NOT NULL AUTO_INCREMENT,
	`pdate`    TINYTEXT,
	`writerId` INT(11) UNSIGNED DEFAULT '0',
	`tags`     TINYTEXT COMMENT 'e.g. Tech,Music,Startalk',
	`category` TINYTEXT,
	`title`    TINYTEXT,
	`brief`    TINYTEXT,
	`content`  MEDIUMTEXT,
	`up`       INT(11) UNSIGNED DEFAULT NULL,
	`down`     INT(11) UNSIGNED DEFAULT NULL,
	`chick`    INT(11) UNSIGNED DEFAULT NULL,
	PRIMARY KEY (`Id`)
)
	ENGINE = MyISAM
	DEFAULT CHARSET = utf8
	ROW_FORMAT = DYNAMIC;

#
# Data for table "article"
#

/*!40000 ALTER TABLE `article`
	DISABLE KEYS */;
/*!40000 ALTER TABLE `article`
	ENABLE KEYS */;

#
# Structure for table "writer"
#

DROP TABLE IF EXISTS `writer`;
CREATE TABLE `writer` (
	`Id`        INT(11) NOT NULL AUTO_INCREMENT,
	`name`      TINYTEXT,
	`motto`     TINYTEXT,
	`avatarURL` TINYTEXT,
	`gender`    INT(11)          DEFAULT NULL,
	PRIMARY KEY (`Id`)
)
	ENGINE = MyISAM
	DEFAULT CHARSET = utf8
	ROW_FORMAT = DYNAMIC;

#
# Data for table "writer"
#

/*!40000 ALTER TABLE `writer`
	DISABLE KEYS */;
/*!40000 ALTER TABLE `writer`
	ENABLE KEYS */;
