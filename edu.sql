/*
Navicat MySQL Data Transfer

Source Server         : 172.19.34.104-slzs
Source Server Version : 50614
Source Host           : 172.19.34.104:3306
Source Database       : edu

Target Server Type    : MYSQL
Target Server Version : 50614
File Encoding         : 65001

Date: 2017-09-07 18:48:46
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for sys_department
-- ----------------------------
DROP TABLE IF EXISTS `sys_department`;
CREATE TABLE `sys_department` (
  `departmentId` int(11) NOT NULL AUTO_INCREMENT COMMENT '部门Id唯一标识',
  `parentDepartmentId` int(11) DEFAULT NULL COMMENT '上级部门id',
  `departmentName` varchar(255) NOT NULL COMMENT '部门名称',
  `departmentLevel` int(11) NOT NULL COMMENT '部门level层级',
  `departmentPidJoin` varchar(255) DEFAULT NULL COMMENT '上级部门id的连接串',
  `departmentStatus` int(11) DEFAULT '1' COMMENT '部门状态默认1 启用  2 停用',
  `isIllegalsite` int(11) NOT NULL DEFAULT '2' COMMENT '是否显示境外非法站点，1：显示，2不显示',
  `contactUser` varchar(255) DEFAULT NULL COMMENT '用户联系人',
  `contactType` varchar(255) DEFAULT NULL COMMENT '联系方式',
  `createDate` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `expiredDate` date DEFAULT NULL COMMENT '失效日期',
  PRIMARY KEY (`departmentId`),
  KEY `dep_pdepid_depid` (`parentDepartmentId`) USING BTREE,
  CONSTRAINT `sys_department_ibfk_1` FOREIGN KEY (`parentdepartmentid`) REFERENCES `sys_department` (`departmentid`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=330 DEFAULT CHARSET=utf8 COMMENT='部门表';

-- ----------------------------
-- Records of sys_department
-- ----------------------------
INSERT INTO `sys_department` VALUES ('1', null, '中心机构', '1', '', '1', '1', '', '', '2013-11-28 13:03:10', '2016-01-23');

-- ----------------------------
-- Table structure for sys_resource
-- ----------------------------
DROP TABLE IF EXISTS `sys_resource`;
CREATE TABLE `sys_resource` (
  `resourceId` int(11) NOT NULL AUTO_INCREMENT COMMENT '资源主键ID',
  `resourceName` varchar(255) NOT NULL COMMENT '资源名称',
  `parentResourceId` int(11) DEFAULT NULL COMMENT '父资源id',
  `url` varchar(255) NOT NULL COMMENT '访问地址',
  `isCommResource` int(2) NOT NULL COMMENT '是否公共资源 2否 1是',
  `isButton` int(2) NOT NULL COMMENT '是否为按钮资源 2否 1是',
  `isNavbar` int(2) NOT NULL DEFAULT '2' COMMENT '是否导航资源 2否 1是',
  `seqNo` int(11) NOT NULL DEFAULT '0' COMMENT '导航序号',
  `innerCode` varchar(40) DEFAULT NULL COMMENT '树形编码',
  `level` int(11) NOT NULL COMMENT '当前节点在树形中的层数',
  `status` int(2) NOT NULL DEFAULT '1' COMMENT '资源状态  1：启用   2：停用',
  `updateDate` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`resourceId`),
  KEY `fk_resourceid_presourceid` (`parentResourceId`) USING BTREE,
  CONSTRAINT `sys_resource_ibfk_1` FOREIGN KEY (`parentresourceid`) REFERENCES `sys_resource` (`resourceid`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=2018 DEFAULT CHARSET=utf8 COMMENT='系统资源表';

-- ----------------------------
-- Records of sys_resource
-- ----------------------------

-- ----------------------------
-- Table structure for sys_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_role`;
CREATE TABLE `sys_role` (
  `roleId` int(11) NOT NULL AUTO_INCREMENT COMMENT '角色id',
  `roleName` varchar(50) NOT NULL COMMENT '角色名称',
  `remark` varchar(1024) DEFAULT NULL COMMENT '备注',
  `typeId` int(1) DEFAULT NULL,
  PRIMARY KEY (`roleId`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8 COMMENT='角色表';

-- ----------------------------
-- Records of sys_role
-- ----------------------------
INSERT INTO `sys_role` VALUES ('1', '系统服务工程师', '默认具有所有权限、可增加权限不能减少权限、角色不能删除', '2');
INSERT INTO `sys_role` VALUES ('2', '网评系统管理员', '默认具有所有权限、可增加权限不能减少权限、角色不能删除', '1');
INSERT INTO `sys_role` VALUES ('11', '网评管理员', '', '1');
INSERT INTO `sys_role` VALUES ('12', '网评员', '', '1');

-- ----------------------------
-- Table structure for sys_role_resource
-- ----------------------------
DROP TABLE IF EXISTS `sys_role_resource`;
CREATE TABLE `sys_role_resource` (
  `roleResourceId` int(11) NOT NULL AUTO_INCREMENT COMMENT '角色资源ID',
  `roleId` int(11) NOT NULL COMMENT '角色ID',
  `resourceId` int(11) NOT NULL COMMENT '资源ID',
  PRIMARY KEY (`roleResourceId`),
  KEY `FK_f_resource` (`resourceId`) USING BTREE,
  KEY `fk_role_r` (`roleId`) USING BTREE,
  CONSTRAINT `sys_role_resource_ibfk_1` FOREIGN KEY (`roleid`) REFERENCES `sys_role` (`roleid`) ON DELETE CASCADE,
  CONSTRAINT `sys_role_resource_ibfk_2` FOREIGN KEY (`resourceid`) REFERENCES `sys_resource` (`resourceid`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=13100 DEFAULT CHARSET=utf8 COMMENT='角色分配资源表';

-- ----------------------------
-- Records of sys_role_resource
-- ----------------------------

-- ----------------------------
-- Table structure for sys_role_user
-- ----------------------------
DROP TABLE IF EXISTS `sys_role_user`;
CREATE TABLE `sys_role_user` (
  `roleUserId` int(11) NOT NULL AUTO_INCREMENT COMMENT '角色用户ID',
  `roleId` int(11) NOT NULL COMMENT '角色ID',
  `userId` int(11) NOT NULL COMMENT '用户ID',
  PRIMARY KEY (`roleUserId`),
  KEY `fk_role_user` (`userId`) USING BTREE,
  KEY `fk_role` (`roleId`) USING BTREE,
  CONSTRAINT `sys_role_user_ibfk_1` FOREIGN KEY (`roleid`) REFERENCES `sys_role` (`roleid`) ON DELETE CASCADE,
  CONSTRAINT `sys_role_user_ibfk_2` FOREIGN KEY (`userid`) REFERENCES `sys_user` (`userId`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=467 DEFAULT CHARSET=utf8 COMMENT='用户分配角色表';

-- ----------------------------
-- Records of sys_role_user
-- ----------------------------
INSERT INTO `sys_role_user` VALUES ('18', '1', '1');
INSERT INTO `sys_role_user` VALUES ('19', '11', '19');
INSERT INTO `sys_role_user` VALUES ('21', '11', '21');
INSERT INTO `sys_role_user` VALUES ('22', '11', '22');
INSERT INTO `sys_role_user` VALUES ('47', '11', '36');
INSERT INTO `sys_role_user` VALUES ('49', '11', '14');
INSERT INTO `sys_role_user` VALUES ('63', '11', '41');
INSERT INTO `sys_role_user` VALUES ('64', '11', '42');
INSERT INTO `sys_role_user` VALUES ('65', '11', '43');
INSERT INTO `sys_role_user` VALUES ('66', '11', '44');
INSERT INTO `sys_role_user` VALUES ('67', '11', '45');
INSERT INTO `sys_role_user` VALUES ('70', '11', '47');
INSERT INTO `sys_role_user` VALUES ('71', '11', '48');
INSERT INTO `sys_role_user` VALUES ('72', '11', '49');
INSERT INTO `sys_role_user` VALUES ('228', '2', '2');
INSERT INTO `sys_role_user` VALUES ('289', '11', '252');
INSERT INTO `sys_role_user` VALUES ('310', '11', '273');
INSERT INTO `sys_role_user` VALUES ('311', '11', '69');
INSERT INTO `sys_role_user` VALUES ('313', '11', '275');
INSERT INTO `sys_role_user` VALUES ('316', '12', '46');
INSERT INTO `sys_role_user` VALUES ('347', '11', '311');
INSERT INTO `sys_role_user` VALUES ('348', '11', '312');
INSERT INTO `sys_role_user` VALUES ('349', '11', '313');
INSERT INTO `sys_role_user` VALUES ('350', '11', '314');
INSERT INTO `sys_role_user` VALUES ('353', '12', '316');
INSERT INTO `sys_role_user` VALUES ('355', '12', '317');
INSERT INTO `sys_role_user` VALUES ('356', '12', '318');
INSERT INTO `sys_role_user` VALUES ('357', '12', '319');
INSERT INTO `sys_role_user` VALUES ('358', '12', '320');
INSERT INTO `sys_role_user` VALUES ('359', '12', '321');
INSERT INTO `sys_role_user` VALUES ('360', '12', '322');
INSERT INTO `sys_role_user` VALUES ('361', '12', '323');
INSERT INTO `sys_role_user` VALUES ('362', '12', '324');
INSERT INTO `sys_role_user` VALUES ('363', '12', '325');
INSERT INTO `sys_role_user` VALUES ('364', '12', '326');
INSERT INTO `sys_role_user` VALUES ('365', '12', '327');
INSERT INTO `sys_role_user` VALUES ('381', '12', '342');
INSERT INTO `sys_role_user` VALUES ('422', '2', '37');
INSERT INTO `sys_role_user` VALUES ('425', '2', '383');
INSERT INTO `sys_role_user` VALUES ('429', '11', '387');
INSERT INTO `sys_role_user` VALUES ('449', '11', '406');
INSERT INTO `sys_role_user` VALUES ('455', '12', '412');
INSERT INTO `sys_role_user` VALUES ('456', '12', '413');
INSERT INTO `sys_role_user` VALUES ('458', '12', '414');
INSERT INTO `sys_role_user` VALUES ('464', '12', '415');
INSERT INTO `sys_role_user` VALUES ('465', '12', '416');
INSERT INTO `sys_role_user` VALUES ('466', '12', '417');

-- ----------------------------
-- Table structure for sys_user
-- ----------------------------
DROP TABLE IF EXISTS `sys_user`;
CREATE TABLE `sys_user` (
  `userId` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `loginName` varchar(50) NOT NULL COMMENT '登录用户名',
  `password` varchar(32) NOT NULL COMMENT '登录密码',
  `name` varchar(50) DEFAULT NULL COMMENT '用户昵称',
  `status` int(11) NOT NULL COMMENT '状态',
  `organId` int(11) DEFAULT NULL COMMENT '所属机构',
  `departmentId` int(11) NOT NULL COMMENT '所属部门',
  `limitLoginIp` varchar(255) DEFAULT NULL COMMENT '限制登录IP',
  `lastLoginDate` datetime DEFAULT NULL COMMENT '登录时间',
  `loginCount` int(11) DEFAULT '0' COMMENT '登录次数',
  `failCount` int(11) DEFAULT '0' COMMENT '连续登录失败次数',
  `mobile` varchar(11) DEFAULT NULL COMMENT '手机',
  `email` varchar(100) DEFAULT NULL,
  `createtDate` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '用户创建时间',
  `createUserId` int(11) DEFAULT NULL,
  PRIMARY KEY (`userId`),
  KEY `fk_dep_user` (`departmentId`) USING BTREE,
  CONSTRAINT `sys_user_ibfk_1` FOREIGN KEY (`departmentid`) REFERENCES `sys_department` (`departmentid`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=418 DEFAULT CHARSET=utf8 COMMENT='系统用户表\r\nstatus==1表示账号非锁定，status==2表示账号锁定\r\nusertype==1表示前台用户，usertype==2表示后台用户,usertype==3表示前台，后台用户';

-- ----------------------------
-- Records of sys_user
-- ----------------------------
INSERT INTO `sys_user` VALUES ('1', 'system', 'CB5996EBD19803D7164EEF944407CD76', '超级管理员', '1', '1', '1', '', '2017-09-07 11:37:55', '146', '0', '', '', '2013-12-03 17:21:57', null);

-- ----------------------------
-- View structure for sys_user_resource
-- ----------------------------
DROP VIEW IF EXISTS `sys_user_resource`;
CREATE ALGORITHM=UNDEFINED DEFINER=`slzs`@`%` SQL SECURITY DEFINER VIEW `sys_user_resource` AS select `a`.`userId` AS `userId`,`d`.`resourceName` AS `resourceName`,`d`.`url` AS `url`,`d`.`isNavbar` AS `isNavbar`,`d`.`status` AS `status` from (((`sys_user` `a` left join `sys_role_user` `b` on((`a`.`userId` = `b`.`userId`))) left join `sys_role_resource` `c` on((`c`.`roleId` = `b`.`roleId`))) left join `sys_resource` `d` on((`d`.`resourceId` = `c`.`resourceId`))) ;
