/*
Navicat MariaDB Data Transfer

Source Server         : 本機DB
Source Server Version : 100019
Source Host           : localhost:3306
Source Database       : backend

Target Server Type    : MariaDB
Target Server Version : 100019
File Encoding         : 65001

Date: 2016-08-16 17:05:37
*/
CREATE DATABASE IF NOT EXISTS `backend` DEFAULT CHARACTER SET utf8 COLLATE utf8_unicode_ci;
USE `backend`;

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for security_group
-- ----------------------------
DROP TABLE IF EXISTS `security_group`;
CREATE TABLE `security_group` (
  `group_id` int(11) NOT NULL,
  `group_name` varchar(45) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL COMMENT '群組名稱',
  `group_desc` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '群組說明',
  `group_status` tinyint(1) NOT NULL DEFAULT '0' COMMENT '帳號狀態  0:封鎖 1:正常',
  `pages` text CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL COMMENT '功能列表清單',
  PRIMARY KEY (`group_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of security_group
-- ----------------------------
INSERT INTO `security_group` VALUES ('1', 'ROLE_USER', null, '0', '');

-- ----------------------------
-- Table structure for security_page
-- ----------------------------
DROP TABLE IF EXISTS `security_page`;
CREATE TABLE `security_page` (
  `page_id` int(11) NOT NULL AUTO_INCREMENT,
  `page_name` varchar(255) COLLATE utf8_unicode_ci NOT NULL COMMENT '功能名稱',
  `view_url` varchar(255) COLLATE utf8_unicode_ci NOT NULL COMMENT '頁面連結位置',
  `page_switch` tinyint(3) NOT NULL DEFAULT '0' COMMENT '功能開關 0:關閉 1:開啟',
  `type` tinyint(3) NOT NULL DEFAULT '0' COMMENT '功能狀態 0:選單 1:功能',
  `sort` tinyint(3) NOT NULL DEFAULT '0' COMMENT '功能顯示順序由低至高',
  `view_icon` varchar(255) COLLATE utf8_unicode_ci NOT NULL DEFAULT '' COMMENT '顯示的icon',
  PRIMARY KEY (`page_id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of security_page
-- ----------------------------
INSERT INTO `security_page` VALUES ('1', '回首頁', 'index', '1', '0', '1', 'fa fa-home');
INSERT INTO `security_page` VALUES ('2', '工具', '', '1', '0', '2', 'fa fa-wrench fa-fw');
INSERT INTO `security_page` VALUES ('3', '表格', 'tables', '1', '2', '1', 'fa fa-table fa-fw');
INSERT INTO `security_page` VALUES ('4', '表單', 'forms', '1', '2', '2', 'fa fa-edit fa-fw');
INSERT INTO `security_page` VALUES ('5', 'icons', 'icons', '1', '2', '3', 'fa fa-gear');
INSERT INTO `security_page` VALUES ('6', '權限設定', '', '1', '0', '3', 'fa glyphicon-cog');
INSERT INTO `security_page` VALUES ('7', '功能列表', 'competence/action', '1', '3', '1', 'fa fa-list');
INSERT INTO `security_page` VALUES ('8', '人員設定', 'competence/users', '1', '3', '2', 'fa fa-users');
INSERT INTO `security_page` VALUES ('9', '排程資訊', 'competence/tasks', '1', '3', '3', 'fa glyphicon-tasks ');

-- ----------------------------
-- Table structure for security_user
-- ----------------------------
DROP TABLE IF EXISTS `security_user`;
CREATE TABLE `security_user` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '編號',
  `account` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL COMMENT '帳號',
  `name` varchar(40) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL COMMENT '使用者名稱',
  `password` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL COMMENT '密碼',
  `reg_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '註冊時間',
  `login_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '最後登入時間',
  `status` tinyint(1) NOT NULL DEFAULT '0' COMMENT '帳號狀態  0:封鎖 1:正常 ',
  `group` int(11) NOT NULL DEFAULT '0' COMMENT '群組編號',
  `pages` text CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL COMMENT '功能列表清單',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of security_user
-- ----------------------------
INSERT INTO `security_user` VALUES ('1', 'SYSMAN', 'Admin', 'SYSMAN', '2016-07-04 16:01:42', '2016-07-18 10:21:03', '1', '1', '1,2,3,4,5,6,7,8,9');
