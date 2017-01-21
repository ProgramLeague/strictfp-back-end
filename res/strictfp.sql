# Host: localhost  (Version: 5.5.53)
# Date: 2017-01-21 22:18:49
# Generator: MySQL-Front 5.3  (Build 4.234)

/*!40101 SET NAMES utf8 */;

#
# Structure for table "article"
#

DROP TABLE IF EXISTS `article`;
CREATE TABLE `article` (
	`Id`       INT(11)               NOT NULL AUTO_INCREMENT,
	`pdate`    DATE                  NOT NULL DEFAULT '2017-01-01',
	`writerId` SMALLINT(5) UNSIGNED  NOT NULL DEFAULT '0',
	`tags`     TINYTEXT              NOT NULL
	COMMENT 'e.g. Tech,Music,Startalk',
	`category` TINYTEXT              NOT NULL,
	`title`    TINYTEXT              NOT NULL,
	`brief`    TINYTEXT              NOT NULL,
	`content`  MEDIUMTEXT            NOT NULL,
	`up`       MEDIUMINT(8) UNSIGNED NOT NULL DEFAULT '0',
	`down`     MEDIUMINT(8) UNSIGNED NOT NULL DEFAULT '0',
	`click`    MEDIUMINT(8) UNSIGNED NOT NULL DEFAULT '0',
	PRIMARY KEY (`Id`, `pdate`)
)
	ENGINE = MyISAM
	AUTO_INCREMENT = 3
	DEFAULT CHARSET = utf8
	ROW_FORMAT = DYNAMIC;

#
# Data for table "article"
#

/*!40000 ALTER TABLE `article`
	DISABLE KEYS */;
INSERT INTO `article` VALUES
	(1, '2017-01-01', 1, 'Tech, Startalk', 'Tech', 'How to mo the older?', 'Tech you how to mo the older',
	    'Mo is the best way to increase your knowledge.', 3500, 0, 1000),
	(2, '2017-01-02', 1, 'Tech, Startalk', 'Tech', 'How to mo the older?', 'Tech you how to mo the older',
	    'Mo is the best way to increase your knowledge.', 10000, 0, 10000);
/*!40000 ALTER TABLE `article`
	ENABLE KEYS */;

#
# Structure for table "salt"
#

DROP TABLE IF EXISTS `salt`;
CREATE TABLE `salt` (
	`userid` INT(11)  NOT NULL AUTO_INCREMENT,
	`salt`   TINYTEXT NOT NULL,
	PRIMARY KEY (`userid`)
)
	ENGINE = MyISAM
	DEFAULT CHARSET = utf8;

#
# Data for table "salt"
#

/*!40000 ALTER TABLE `salt`
	DISABLE KEYS */;
/*!40000 ALTER TABLE `salt`
	ENABLE KEYS */;

#
# Structure for table "senior_writer_application"
#

DROP TABLE IF EXISTS `senior_writer_application`;
CREATE TABLE `senior_writer_application` (
	`Id`            INT(11)  NOT NULL AUTO_INCREMENT,
	`email`         TINYTEXT NOT NULL,
	`zhihu`         TINYTEXT,
	`github`        TINYTEXT,
	`stackoverflow` TINYTEXT,
	`brief`         TINYTEXT NOT NULL,
	`introduce`     TEXT     NOT NULL,
	PRIMARY KEY (`Id`)
)
	ENGINE = MyISAM
	DEFAULT CHARSET = utf8
	COMMENT = 'The author info that need check artificially.';

#
# Data for table "senior_writer_application"
#

/*!40000 ALTER TABLE `senior_writer_application`
	DISABLE KEYS */;
/*!40000 ALTER TABLE `senior_writer_application`
	ENABLE KEYS */;

#
# Structure for table "author"
#

DROP TABLE IF EXISTS `author`;
CREATE TABLE `author` (
	`Id`         INT(11)    NOT NULL AUTO_INCREMENT,
	`writertype` TINYINT(1) NOT NULL DEFAULT '0',
	`uname`      TINYTEXT   NOT NULL,
	`pass`       TINYTEXT   NOT NULL,
	`motto`      TINYTEXT   NOT NULL,
	`avatarURL`  TINYTEXT   NOT NULL,
	`gender`     TINYINT(3) NOT NULL DEFAULT '0',
	PRIMARY KEY (`Id`, `writertype`)
)
	ENGINE = MyISAM
	AUTO_INCREMENT = 2
	DEFAULT CHARSET = utf8
	ROW_FORMAT = DYNAMIC;

#
# Data for table "author"
#

/*!40000 ALTER TABLE `author`
	DISABLE KEYS */;
INSERT INTO `author` VALUES (1, 0, 'Eldath', '', 'Mo is the best way to increase knowledge.', 'http://mo.mo/mo', 1);
/*!40000 ALTER TABLE `author`
	ENABLE KEYS */;
