# Host: localhost  (Version: 5.5.53)
# Date: 2017-01-20 20:00:51
# Generator: MySQL-Front 5.3  (Build 4.234)
# jdbc:mysql://localhost:3306/strictfp

/*!40101 SET NAMES utf8 */;

#
# Structure for table "article"
#

DROP TABLE IF EXISTS `article`;
CREATE TABLE `article` (
	`Id`       INT(11)               NOT NULL AUTO_INCREMENT,
	`pdate`    INT(8)                NOT NULL DEFAULT '20170101',
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
	`Id`        INT(11)    NOT NULL AUTO_INCREMENT,
	`name`      TINYTEXT   NOT NULL,
	`motto`     TINYTEXT   NOT NULL,
	`avatarURL` TINYTEXT   NOT NULL,
	`gender`    TINYINT(3) NOT NULL DEFAULT '0',
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
