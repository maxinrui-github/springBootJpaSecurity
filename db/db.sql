/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50518
Source Host           : localhost:3306
Source Database       : demo

Target Server Type    : MYSQL
Target Server Version : 50518
File Encoding         : 65001

Date: 2019-07-01 16:06:25
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `sys_meun`
-- ----------------------------
DROP TABLE IF EXISTS `sys_meun`;
CREATE TABLE `sys_meun` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `HREF` varchar(255) COLLATE utf8_bin DEFAULT '''''',
  `NAME` varchar(64) COLLATE utf8_bin NOT NULL DEFAULT '''''',
  `PARENT_ID` int(11) NOT NULL DEFAULT '0',
  `SORT` int(11) NOT NULL DEFAULT '99',
  `IS_FIRST` int(11) NOT NULL DEFAULT '0',
  `ICON` varchar(64) COLLATE utf8_bin DEFAULT '''''',
  PRIMARY KEY (`ID`)
) ENGINE=MyISAM AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of sys_meun
-- ----------------------------
INSERT INTO `sys_meun` VALUES ('1', '\'\'', '系统设置', '0', '99', '0', 'fa fa-cog');
INSERT INTO `sys_meun` VALUES ('2', '\'\'', '菜单二', '0', '2', '1', 'fa fa-cog');
INSERT INTO `sys_meun` VALUES ('3', '\'\'', '菜单三', '1', '3', '0', 'fa fa-cog');
INSERT INTO `sys_meun` VALUES ('4', '\'\'', '菜单四', '1', '98', '0', 'fa fa-cog');

-- ----------------------------
-- Table structure for `sys_role`
-- ----------------------------
DROP TABLE IF EXISTS `sys_role`;
CREATE TABLE `sys_role` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `NAME` varchar(64) COLLATE utf8_bin NOT NULL DEFAULT '''''',
  PRIMARY KEY (`ID`)
) ENGINE=MyISAM AUTO_INCREMENT=15 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of sys_role
-- ----------------------------
INSERT INTO `sys_role` VALUES ('13', 'ROLE_ADMIN');
INSERT INTO `sys_role` VALUES ('14', 'ROLE_USER');

-- ----------------------------
-- Table structure for `sys_role_meun`
-- ----------------------------
DROP TABLE IF EXISTS `sys_role_meun`;
CREATE TABLE `sys_role_meun` (
  `ROLE_ID` int(11) NOT NULL,
  `MEUN_ID` int(11) NOT NULL,
  PRIMARY KEY (`ROLE_ID`,`MEUN_ID`),
  KEY `FKtmke4o3ifvytkw02aj7cfivio` (`MEUN_ID`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of sys_role_meun
-- ----------------------------
INSERT INTO `sys_role_meun` VALUES ('13', '1');
INSERT INTO `sys_role_meun` VALUES ('13', '2');
INSERT INTO `sys_role_meun` VALUES ('13', '3');
INSERT INTO `sys_role_meun` VALUES ('13', '4');

-- ----------------------------
-- Table structure for `sys_user`
-- ----------------------------
DROP TABLE IF EXISTS `sys_user`;
CREATE TABLE `sys_user` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `NAME` varchar(64) COLLATE utf8_bin NOT NULL,
  `PASSWORD` varchar(64) COLLATE utf8_bin NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=MyISAM AUTO_INCREMENT=9 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of sys_user
-- ----------------------------
INSERT INTO `sys_user` VALUES ('8', 'admin', 'e3d0c85bf9d69d7ff11c1440a870d6c7');

-- ----------------------------
-- Table structure for `sys_user_role`
-- ----------------------------
DROP TABLE IF EXISTS `sys_user_role`;
CREATE TABLE `sys_user_role` (
  `USER_ID` int(11) NOT NULL,
  `ROLE_ID` int(11) NOT NULL,
  PRIMARY KEY (`USER_ID`,`ROLE_ID`),
  KEY `FKhh52n8vd4ny9ff4x9fb8v65qx` (`ROLE_ID`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of sys_user_role
-- ----------------------------
INSERT INTO `sys_user_role` VALUES ('8', '13');
INSERT INTO `sys_user_role` VALUES ('8', '14');
