# Host: localhost  (Version: 5.5.53)
# Date: 2017-01-23 23:36:26
# Generator: MySQL-Front 5.3  (Build 4.234)

/*!40101 SET NAMES utf8 */;

#
# Structure for table "article"
#

DROP TABLE IF EXISTS `article`;
CREATE TABLE `article` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `date` date NOT NULL DEFAULT '2017-01-01',
  `authorId` smallint(5) unsigned NOT NULL DEFAULT '0',
  `tags` tinytext NOT NULL COMMENT 'e.g. Tech,Music,Startalk',
  `category` tinytext NOT NULL,
  `title` tinytext NOT NULL,
  `brief` tinytext NOT NULL,
  `content` mediumtext NOT NULL,
  `up` mediumint(8) unsigned NOT NULL DEFAULT '0',
  `down` mediumint(8) unsigned NOT NULL DEFAULT '0',
  `click` mediumint(8) unsigned NOT NULL DEFAULT '0',
  PRIMARY KEY (`Id`,`date`)
) ENGINE=MyISAM AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

#
# Data for table "article"
#

/*!40000 ALTER TABLE `article` DISABLE KEYS */;
INSERT INTO `article` VALUES (1,'2017-01-01',0,'Tech, Startalk','Tech','How to mo the older?','Tech you how to mo the older','Mo is the best way to increase your knowledge.',10000,0,23333),(2,'2017-01-01',0,'Tech, Startalk','Tech','How to mo the older?','Tech you how to mo the older','Mo is the best way to increase your knowledge.',10000,0,23333),(2,'2017-01-02',1,'Tech, Startalk','Tech','How to mo the older?','Tech you how to mo the older','Mo is the best way to increase your knowledge.',10000,0,23333);
/*!40000 ALTER TABLE `article` ENABLE KEYS */;

#
# Structure for table "quiz"
#

DROP TABLE IF EXISTS `quiz`;
CREATE TABLE `quiz` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `formId` tinyint(3) NOT NULL DEFAULT '0',
  `type` tinyint(1) NOT NULL DEFAULT '0',
  `question` tinytext NOT NULL,
  `options` text NOT NULL COMMENT 'e.g. A.Test,B.go,C.run',
  `answer` char(1) NOT NULL DEFAULT 'A',
  PRIMARY KEY (`Id`,`formId`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

#
# Data for table "quiz"
#

/*!40000 ALTER TABLE `quiz` DISABLE KEYS */;
INSERT INTO `quiz` VALUES (1,0,0,'as','A.as,B.as','A');
/*!40000 ALTER TABLE `quiz` ENABLE KEYS */;

#
# Structure for table "quiz_form"
#

DROP TABLE IF EXISTS `quiz_form`;
CREATE TABLE `quiz_form` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `name` tinytext NOT NULL,
  `brief` tinytext NOT NULL,
  PRIMARY KEY (`Id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

#
# Data for table "quiz_form"
#

/*!40000 ALTER TABLE `quiz_form` DISABLE KEYS */;
INSERT INTO `quiz_form` VALUES (1,'test','test');
/*!40000 ALTER TABLE `quiz_form` ENABLE KEYS */;

#
# Structure for table "salt"
#

DROP TABLE IF EXISTS `salt`;
CREATE TABLE `salt` (
  `userId` int(11) NOT NULL AUTO_INCREMENT,
  `salt` tinytext NOT NULL,
  PRIMARY KEY (`userId`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

#
# Data for table "salt"
#

/*!40000 ALTER TABLE `salt` DISABLE KEYS */;
/*!40000 ALTER TABLE `salt` ENABLE KEYS */;

#
# Structure for table "senior_author_application"
#

DROP TABLE IF EXISTS `senior_author_application`;
CREATE TABLE `senior_author_application` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `email` tinytext NOT NULL,
  `zhihu` tinytext,
  `github` tinytext,
  `stackoverflow` tinytext,
  `brief` tinytext NOT NULL,
  `introduce` text NOT NULL,
  `advice` tinyint(1) unsigned NOT NULL DEFAULT '0',
  PRIMARY KEY (`Id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COMMENT='The writer info that need check artificially.';

#
# Data for table "senior_author_application"
#

/*!40000 ALTER TABLE `senior_author_application` DISABLE KEYS */;
/*!40000 ALTER TABLE `senior_author_application` ENABLE KEYS */;

#
# Structure for table "writer"
#

DROP TABLE IF EXISTS `writer`;
CREATE TABLE `writer` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `authorType` tinyint(1) NOT NULL DEFAULT '0',
  `username` tinytext NOT NULL,
  `pass` tinytext NOT NULL,
  `motto` tinytext NOT NULL,
  `avatarURL` tinytext NOT NULL,
  `gender` tinyint(3) NOT NULL DEFAULT '0',
  PRIMARY KEY (`Id`,`authorType`)
) ENGINE=MyISAM AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

#
# Data for table "writer"
#

/*!40000 ALTER TABLE `writer` DISABLE KEYS */;
INSERT INTO `writer` VALUES (1,0,'Eldath','','Mo is the best way to increase knowledge.','http://mo.mo/mo',1);
/*!40000 ALTER TABLE `writer` ENABLE KEYS */;
