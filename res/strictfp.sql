# Host: localhost  (Version: 5.5.53)
# Date: 2017-01-20 20:00:51
# Generator: MySQL-Front 5.3  (Build 4.234)
# jdbc:mysql://localhost:3306/main

/*!40101 SET NAMES utf8 */;

#
# Structure for table "article"
#

DROP TABLE IF EXISTS `article`;
CREATE TABLE `article` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `pdate` int(8) NOT NULL DEFAULT '20170101',
  `writerId` smallint(5) unsigned NOT NULL DEFAULT '0',
  `tags` tinytext NOT NULL COMMENT 'e.g. Tech,Music,Startalk',
  `category` tinytext NOT NULL,
  `title` tinytext NOT NULL,
  `brief` tinytext NOT NULL,
  `content` mediumtext NOT NULL,
  `up` mediumint(8) unsigned NOT NULL DEFAULT '0',
  `down` mediumint(8) unsigned NOT NULL DEFAULT '0',
  `chick` mediumint(8) unsigned NOT NULL DEFAULT '0',
  PRIMARY KEY (`Id`,`pdate`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

#
# Data for table "article"
#

/*!40000 ALTER TABLE `article` DISABLE KEYS */;
/*!40000 ALTER TABLE `article` ENABLE KEYS */;

#
# Structure for table "writer"
#

DROP TABLE IF EXISTS `writer`;
CREATE TABLE `writer` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `name` tinytext NOT NULL,
  `motto` tinytext NOT NULL,
  `avatarURL` tinytext NOT NULL,
  `gender` tinyint(3) NOT NULL DEFAULT '0',
  PRIMARY KEY (`Id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

#
# Data for table "writer"
#

/*!40000 ALTER TABLE `writer` DISABLE KEYS */;
/*!40000 ALTER TABLE `writer` ENABLE KEYS */;
