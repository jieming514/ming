# ming database
-- MySQL dump 10.13  Distrib 5.7.17, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: ming
-- ------------------------------------------------------
-- Server version	5.5.53

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `upms_log`
--

DROP TABLE IF EXISTS `upms_log`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `upms_log` (
  `log_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '编号',
  `description` varchar(100) DEFAULT NULL COMMENT '操作描述',
  `username` varchar(20) DEFAULT NULL COMMENT '操作用户',
  `start_time` bigint(20) DEFAULT NULL COMMENT '操作时间',
  `spend_time` int(11) DEFAULT NULL COMMENT '消耗时间',
  `base_path` varchar(500) DEFAULT NULL COMMENT '根路径',
  `uri` varchar(500) DEFAULT NULL COMMENT 'URI',
  `url` varchar(500) DEFAULT NULL COMMENT 'URL',
  `method` varchar(10) DEFAULT NULL COMMENT '请求类型',
  `parameter` mediumtext,
  `user_agent` varchar(500) DEFAULT NULL COMMENT '用户标识',
  `ip` varchar(30) DEFAULT NULL COMMENT 'IP地址',
  `result` mediumtext,
  `permissions` varchar(100) DEFAULT NULL COMMENT '权限值',
  PRIMARY KEY (`log_id`),
  KEY `log_id` (`log_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='操作日志';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `upms_log`
--

LOCK TABLES `upms_log` WRITE;
/*!40000 ALTER TABLE `upms_log` DISABLE KEYS */;
/*!40000 ALTER TABLE `upms_log` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `upms_organization`
--

DROP TABLE IF EXISTS `upms_organization`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `upms_organization` (
  `organization_id` int(10) unsigned NOT NULL AUTO_INCREMENT COMMENT '编号',
  `pid` int(10) DEFAULT NULL COMMENT '所属上级',
  `name` varchar(20) DEFAULT NULL COMMENT '组织名称',
  `description` varchar(1000) DEFAULT NULL COMMENT '组织描述',
  `ctime` bigint(20) DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`organization_id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4 COMMENT='组织';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `upms_organization`
--

LOCK TABLES `upms_organization` WRITE;
/*!40000 ALTER TABLE `upms_organization` DISABLE KEYS */;
INSERT INTO `upms_organization` VALUES (1,NULL,'总部','北京总部',1),(4,NULL,'河北分部','河北石家庄',1488122466236),(5,NULL,'河南分部','河南郑州',1488122480265),(6,NULL,'湖北分部','湖北武汉',1488122493265),(7,NULL,'湖南分部','湖南长沙',1488122502752);
/*!40000 ALTER TABLE `upms_organization` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `upms_permission`
--

DROP TABLE IF EXISTS `upms_permission`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `upms_permission` (
  `permission_id` int(10) unsigned NOT NULL AUTO_INCREMENT COMMENT '编号',
  `system_id` int(10) unsigned NOT NULL COMMENT '所属系统',
  `pid` int(10) DEFAULT NULL COMMENT '所属上级',
  `name` varchar(20) DEFAULT NULL COMMENT '名称',
  `type` tinyint(4) DEFAULT NULL COMMENT '类型(1:目录,2:菜单,3:按钮)',
  `permission_value` varchar(50) DEFAULT NULL COMMENT '权限值',
  `uri` varchar(100) DEFAULT NULL COMMENT '路径',
  `icon` varchar(50) DEFAULT NULL COMMENT '图标',
  `status` tinyint(4) DEFAULT NULL COMMENT '状态(0:禁止,1:正常)',
  `ctime` bigint(20) DEFAULT NULL COMMENT '创建时间',
  `orders` bigint(20) DEFAULT NULL COMMENT '排序',
  PRIMARY KEY (`permission_id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COMMENT='权限';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `upms_permission`
--

LOCK TABLES `upms_permission` WRITE;
/*!40000 ALTER TABLE `upms_permission` DISABLE KEYS */;
INSERT INTO `upms_permission` VALUES (1,1,0,'系统组织管理',1,'','','zmdi zmdi-accounts-list',1,1,1),(2,1,1,'系统管理',2,'upms:system:read','/manage/system/index','',1,2,2),(3,1,1,'组织管理',2,'upms:organization:read','/manage/organization/index','',1,3,3),(4,1,0,'角色用户管理',1,'','','zmdi zmdi-accounts',1,4,4);
/*!40000 ALTER TABLE `upms_permission` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `upms_role`
--

DROP TABLE IF EXISTS `upms_role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `upms_role` (
  `role_id` int(10) unsigned NOT NULL AUTO_INCREMENT COMMENT '编号',
  `name` varchar(20) DEFAULT NULL COMMENT '角色名称',
  `title` varchar(20) DEFAULT NULL COMMENT '角色标题',
  `description` varchar(1000) DEFAULT NULL COMMENT '角色描述',
  `ctime` bigint(20) NOT NULL COMMENT '创建时间',
  `orders` bigint(20) NOT NULL COMMENT '排序',
  PRIMARY KEY (`role_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COMMENT='角色';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `upms_role`
--

LOCK TABLES `upms_role` WRITE;
/*!40000 ALTER TABLE `upms_role` DISABLE KEYS */;
INSERT INTO `upms_role` VALUES (1,'super','超级管理员','拥有所有权限',1,1),(2,'admin','管理员','拥有除权限管理系统外的所有权限',1487471013117,1487471013117);
/*!40000 ALTER TABLE `upms_role` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `upms_role_permission`
--

DROP TABLE IF EXISTS `upms_role_permission`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `upms_role_permission` (
  `role_permission_id` int(10) unsigned NOT NULL AUTO_INCREMENT COMMENT '编号',
  `role_id` int(10) unsigned NOT NULL COMMENT '角色编号',
  `permission_id` int(10) unsigned NOT NULL COMMENT '权限编号',
  PRIMARY KEY (`role_permission_id`),
  KEY `FK_Reference_23` (`role_id`),
  CONSTRAINT `FK_Reference_23` FOREIGN KEY (`role_id`) REFERENCES `upms_role` (`role_id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COMMENT='角色权限关联表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `upms_role_permission`
--

LOCK TABLES `upms_role_permission` WRITE;
/*!40000 ALTER TABLE `upms_role_permission` DISABLE KEYS */;
INSERT INTO `upms_role_permission` VALUES (1,1,1),(2,1,2),(3,1,3),(4,1,4);
/*!40000 ALTER TABLE `upms_role_permission` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `upms_system`
--

DROP TABLE IF EXISTS `upms_system`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `upms_system` (
  `system_id` int(10) unsigned NOT NULL AUTO_INCREMENT COMMENT '编号',
  `icon` varchar(50) DEFAULT NULL COMMENT '图标',
  `banner` varchar(150) DEFAULT NULL COMMENT '背景',
  `theme` varchar(50) DEFAULT NULL COMMENT '主题',
  `basepath` varchar(100) DEFAULT NULL COMMENT '根目录',
  `status` tinyint(4) DEFAULT NULL COMMENT '状态(-1:黑名单,1:正常)',
  `name` varchar(20) DEFAULT NULL COMMENT '系统名称',
  `title` varchar(20) DEFAULT NULL COMMENT '系统标题',
  `description` varchar(300) DEFAULT NULL COMMENT '系统描述',
  `ctime` bigint(20) DEFAULT NULL COMMENT '创建时间',
  `orders` bigint(20) DEFAULT NULL COMMENT '排序',
  PRIMARY KEY (`system_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COMMENT='系统';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `upms_system`
--

LOCK TABLES `upms_system` WRITE;
/*!40000 ALTER TABLE `upms_system` DISABLE KEYS */;
INSERT INTO `upms_system` VALUES (1,'zmdi zmdi-shield-security','/resources/zheng-admin/images/zheng-upms.png','#29A176','http://upms.zhangshuzheng.cn:1111',1,'zheng-upms-server','权限管理系统','用户权限管理系统（RBAC细粒度用户权限、统一后台、单点登录、会话管理）',1,1);
/*!40000 ALTER TABLE `upms_system` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `upms_user`
--

DROP TABLE IF EXISTS `upms_user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `upms_user` (
  `user_id` int(10) unsigned NOT NULL AUTO_INCREMENT COMMENT '编号',
  `username` varchar(20) NOT NULL COMMENT '帐号',
  `password` varchar(32) NOT NULL COMMENT '密码MD5(密码+盐)',
  `salt` varchar(32) DEFAULT NULL COMMENT '盐',
  `realname` varchar(20) DEFAULT NULL COMMENT '姓名',
  `avatar` varchar(150) DEFAULT NULL COMMENT '头像',
  `phone` varchar(20) DEFAULT NULL COMMENT '电话',
  `email` varchar(50) DEFAULT NULL COMMENT '邮箱',
  `sex` tinyint(4) DEFAULT NULL COMMENT '性别',
  `locked` tinyint(4) DEFAULT NULL COMMENT '状态(0:正常,1:锁定)',
  `ctime` bigint(20) DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COMMENT='用户';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `upms_user`
--

LOCK TABLES `upms_user` WRITE;
/*!40000 ALTER TABLE `upms_user` DISABLE KEYS */;
INSERT INTO `upms_user` VALUES (1,'admin','d1e2292b8991e896b272a37e1c9be3ad','66f1b370c660445a8657bf8bf1794486','管理员','/resources/zheng-admin/images/avatar.jpg','','1090760001@qq.com',1,0,1),(2,'test','285C9762F5F9046F5893F752DFAF3476','d2d0d03310444ad388a8b290b0fe8564','测试账号','/resources/zheng-admin/images/avatar.jpg','','1090760001@qq.com',1,0,1493394720495);
/*!40000 ALTER TABLE `upms_user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `upms_user_organization`
--

DROP TABLE IF EXISTS `upms_user_organization`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `upms_user_organization` (
  `user_organization_id` int(10) unsigned NOT NULL AUTO_INCREMENT COMMENT '编号',
  `user_id` int(10) unsigned NOT NULL COMMENT '用户编号',
  `organization_id` int(10) unsigned NOT NULL COMMENT '组织编号',
  PRIMARY KEY (`user_organization_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='用户组织关联表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `upms_user_organization`
--

LOCK TABLES `upms_user_organization` WRITE;
/*!40000 ALTER TABLE `upms_user_organization` DISABLE KEYS */;
/*!40000 ALTER TABLE `upms_user_organization` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `upms_user_role`
--

DROP TABLE IF EXISTS `upms_user_role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `upms_user_role` (
  `user_role_id` int(10) unsigned NOT NULL AUTO_INCREMENT COMMENT '编号',
  `user_id` int(10) unsigned NOT NULL COMMENT '用户编号',
  `role_id` int(10) DEFAULT NULL COMMENT '角色编号',
  PRIMARY KEY (`user_role_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COMMENT='用户角色关联表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `upms_user_role`
--

LOCK TABLES `upms_user_role` WRITE;
/*!40000 ALTER TABLE `upms_user_role` DISABLE KEYS */;
INSERT INTO `upms_user_role` VALUES (1,1,1),(2,1,2),(3,2,1);
/*!40000 ALTER TABLE `upms_user_role` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-04-24 23:42:18
