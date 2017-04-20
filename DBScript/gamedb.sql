/*
Navicat MariaDB Data Transfer

Source Server         : ����DB
Source Server Version : 100019
Source Host           : localhost:3306
Source Database       : game

Target Server Type    : MariaDB
Target Server Version : 100019
File Encoding         : 65001

Date: 2016-08-16 17:05:47
*/
CREATE DATABASE IF NOT EXISTS `gamedb` DEFAULT CHARACTER SET utf8 COLLATE utf8_unicode_ci;
USE `game`;

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for schedule_job
-- ----------------------------
DROP TABLE IF EXISTS `schedule_job`;
CREATE TABLE `schedule_job` (
  `jobId` int(11) NOT NULL AUTO_INCREMENT COMMENT '���Ƚs��(�y����)',
  `jobName` varchar(128) NOT NULL COMMENT '���ȦW��',
  `jobGroup` varchar(11) NOT NULL COMMENT '���Ȥ���',
  `jobStatus` tinyint(1) NOT NULL COMMENT '���Ȫ��A 0���� 1�ҥ� 2�R��',
  `cronExpression` varchar(128) NOT NULL COMMENT '���ȹB��ɶ�',
  `desc` varchar(256) NOT NULL COMMENT '���ȴy�z����',
  `beanAdderss` varchar(256) NOT NULL COMMENT 'class ��m',
  `beanName` varchar(256) NOT NULL COMMENT '�`�J��bean �W��',
  `beanMethod` varchar(256) NOT NULL COMMENT '�����k',
  PRIMARY KEY (`jobId`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COMMENT='�Ƶ{���';

-- ----------------------------
-- Records of schedule_job
-- ----------------------------
INSERT INTO `schedule_job` VALUES ('1', 'test', 'test1', '1', '0 0/5 * * * ?', '���ձƵ{1', 'com.cs.game.controller.TestController', 'testController', 'testServerAddress');

-- ----------------------------
-- Table structure for userdata
-- ----------------------------
DROP TABLE IF EXISTS `userdata`;
CREATE TABLE `userdata` (
  `user_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '�y����',
  `account` varchar(20) COLLATE utf8_unicode_ci NOT NULL COMMENT '�b��',
  `pwd` varchar(20) COLLATE utf8_unicode_ci NOT NULL COMMENT '�K�X',
  `user_name` varchar(10) COLLATE utf8_unicode_ci NOT NULL COMMENT '���a�W��',
  `reg_time` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00' ON UPDATE CURRENT_TIMESTAMP COMMENT '���U�ɶ�',
  `login_time` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00' ON UPDATE CURRENT_TIMESTAMP COMMENT '�̫�n�J�ɶ�',
  `ac_type` tinyint(4) DEFAULT '1' COMMENT '�b�����A  1:���`  0:���v',
  `tutorial` varchar(255) COLLATE utf8_unicode_ci DEFAULT '0' COMMENT '�s��о�',
  PRIMARY KEY (`user_id`),
  UNIQUE KEY `account` (`account`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of userdata
-- ----------------------------
INSERT INTO `userdata` VALUES ('1', 'leo1', 'leo2', 'leo1', '0000-00-00 00:00:00', '0000-00-00 00:00:00', '1', '0');
INSERT INTO `userdata` VALUES ('2', 'leo2', 'leo2', 'leo1', '0000-00-00 00:00:00', '0000-00-00 00:00:00', '1', '0');
INSERT INTO `userdata` VALUES ('3', 'leo3', 'leo3', 'leo1', '0000-00-00 00:00:00', '0000-00-00 00:00:00', '1', '0');
INSERT INTO `userdata` VALUES ('4', 'leo4', 'leo3', 'leo1', '0000-00-00 00:00:00', '0000-00-00 00:00:00', '1', '0');
INSERT INTO `userdata` VALUES ('5', 'leo5', 'leo3', 'leo1', '0000-00-00 00:00:00', '0000-00-00 00:00:00', '1', '0');
INSERT INTO `userdata` VALUES ('6', 'leo6', 'leo3', 'leo1', '0000-00-00 00:00:00', '0000-00-00 00:00:00', '1', '0');
INSERT INTO `userdata` VALUES ('7', 'leo7', 'leo3', 'leo1', '0000-00-00 00:00:00', '0000-00-00 00:00:00', '1', '0');
INSERT INTO `userdata` VALUES ('9', 'leo10', 'leo10', 'leo1', '0000-00-00 00:00:00', '0000-00-00 00:00:00', '1', '0');

-- ----------------------------
-- Table structure for userdata1
-- ----------------------------
DROP TABLE IF EXISTS `userdata1`;
CREATE TABLE `userdata1` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `os` int(11) NOT NULL DEFAULT '1' COMMENT '1:ios,2:android',
  `uid` varchar(45) NOT NULL COMMENT '�b��',
  `pw` varchar(40) NOT NULL COMMENT '�K�X',
  `snsflag` tinyint(1) NOT NULL DEFAULT '0',
  `name` varchar(40) DEFAULT NULL,
  `coin` int(11) NOT NULL COMMENT '�C����',
  `gold` int(11) NOT NULL COMMENT '����',
  `token` int(11) NOT NULL COMMENT '�N��',
  `tutorial` int(11) NOT NULL COMMENT '�о�',
  `ivcode` varchar(20) NOT NULL COMMENT '�ܽнX',
  `ivflag` tinyint(1) NOT NULL COMMENT '�O�_�w�g��J�B���ܽнX',
  `ivcounts` int(1) NOT NULL COMMENT '�Q��J����',
  `LRflag` int(2) NOT NULL COMMENT '�n�J���y',
  `lastlogin` varchar(20) NOT NULL COMMENT '�W���n�J�ɶ�',
  `ap` tinyint(4) DEFAULT NULL COMMENT '����I��',
  `apTime` varchar(20) DEFAULT NULL COMMENT '����I�Ʀ^�_�ɶ�',
  `apType` tinyint(4) DEFAULT NULL COMMENT '�^�_���A 0:���q 1:��',
  `acType` tinyint(4) DEFAULT '1' COMMENT '�b�����A  1:���`  0:���v',
  `regtime` varchar(20) NOT NULL COMMENT '���U�ɶ��ɶ�',
  PRIMARY KEY (`id`),
  UNIQUE KEY `uid` (`uid`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=33 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of userdata1
-- ----------------------------
INSERT INTO `userdata1` VALUES ('1', '1', '328479e364a55a33fd1a', '741841a9', '0', 'leon', '500', '0', '1', '0', 'a402ad5e2ab6', '0', '0', '0', '2014-05-22 18:33:18', '10', '2014-06-19 17:00:46', '1', '1', '2014-06-19 17:05:10');
INSERT INTO `userdata1` VALUES ('2', '1', '1cc38ef18299a114c94c', 'e22642f0', '0', '4458', '500', '0', '1', '0', '54d48b6f5b30', '0', '0', '0', '2014-05-22 18:36:10', '5', '2014-06-11 18:30:58', '1', '1', '2014-05-22 18:36:10');
INSERT INTO `userdata1` VALUES ('3', '1', 'ebf907342cce128f4ed1', 'a2a14835', '0', '', '500', '0', '1', '0', '429197d43158', '0', '0', '0', '2014-05-22 18:38:12', '5', '2014-06-11 18:30:58', '1', '1', '2014-05-22 18:40:47');
INSERT INTO `userdata1` VALUES ('4', '1', '6b0bba8bcf8153e38951', '0a2e4178', '0', '', '500', '0', '1', '0', 'ff98328c1cc7', '0', '0', '0', '2014-06-11 18:30:58', '5', '2014-06-11 18:30:58', '1', '1', '2014-06-11 18:30:58');
INSERT INTO `userdata1` VALUES ('5', '1', '49aeaac62c6728aaeab4', 'b3444b69', '0', 'leo', '500', '0', '1', '0', '56c1faa9094b', '0', '0', '0', '2014-06-11 18:34:32', '10', '2014-06-30 18:32:00', '1', '1', '2014-06-30 18:32:25');
INSERT INTO `userdata1` VALUES ('6', '0', '7fd8394f8f0b8a15ceb2', '36c541e2', '0', 'AKIRA', '10', '500', '1', '0', '2ebfa7485fa3', '0', '0', '0', '2014-06-25 10:53:54', '10', '2014-06-25 14:26:44', '1', '1', '2014-06-25 14:26:44');
INSERT INTO `userdata1` VALUES ('7', '0', '0516e0fde4804537b09a', '13a6434d', '0', '', '10', '500', '1', '0', 'b9f4a486e513', '0', '0', '0', '2014-06-25 12:01:30', '5', '2014-06-25 12:01:30', '1', '1', '2014-06-25 12:01:30');
INSERT INTO `userdata1` VALUES ('8', '0', '86349ad8861755838c96', '42f442fd', '0', '', '10', '500', '1', '0', 'a1adf3deef43', '0', '0', '0', '2014-06-25 14:25:29', '5', '2014-06-25 14:25:29', '1', '1', '2014-06-25 14:25:29');
INSERT INTO `userdata1` VALUES ('9', '0', '5fd78df5a0c6242b7e6e', 'a10b4044', '0', '', '10', '500', '1', '0', '6f71ff75f201', '0', '0', '0', '2014-06-25 14:26:35', '5', '2014-06-25 14:26:35', '1', '1', '2014-06-25 14:26:35');
INSERT INTO `userdata1` VALUES ('11', '1', '1222222222222222', '1111111', '0', 'aaa', '11', '1', '1', '1', '6f71ff75f201', '0', '0', '0', '2014-06-25 14:26:35', '2', '2014-06-25 14:26:35', '2', '1', '2014-06-25 14:26:35');
INSERT INTO `userdata1` VALUES ('15', '1', '22222222', '', '0', null, '0', '0', '0', '0', '', '0', '0', '0', '', null, null, null, '1', '');
INSERT INTO `userdata1` VALUES ('17', '1', '2', '', '0', null, '0', '0', '0', '0', '', '0', '0', '0', '', null, null, null, '1', '');
INSERT INTO `userdata1` VALUES ('19', '1', '3', '', '0', null, '0', '0', '0', '0', '', '0', '0', '0', '', null, null, null, '1', '');
INSERT INTO `userdata1` VALUES ('22', '1', '4', '', '0', null, '0', '0', '0', '0', '', '0', '0', '0', '', null, null, null, '1', '');
INSERT INTO `userdata1` VALUES ('24', '1', '', '', '0', null, '0', '0', '0', '0', '', '0', '0', '0', '', null, null, null, '1', '');
INSERT INTO `userdata1` VALUES ('32', '1', '23333', '', '0', null, '0', '0', '0', '0', '', '0', '0', '0', '', null, null, null, '1', '');

-- ----------------------------
-- Function structure for test
-- ----------------------------
DROP FUNCTION IF EXISTS `test`;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` FUNCTION `test`() RETURNS int(11)
BEGIN
	#Routine body goes here...
UPDATE userdata set userName = 'leo';
	RETURN 0;
END
;;
DELIMITER ;
