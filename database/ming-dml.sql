-- MySQL dump 10.13  Distrib 8.0.19, for Win64 (x86_64)
--
-- Host: localhost    Database: ming
-- ------------------------------------------------------
-- Server version	8.0.11

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Position to start replication or point-in-time recovery from
--

-- CHANGE MASTER TO MASTER_LOG_FILE='binlog.000031', MASTER_LOG_POS=155;

--
-- Dumping data for table `upms_config`
--
-- ORDER BY:  `config_id`

LOCK TABLES `upms_config` WRITE;
/*!40000 ALTER TABLE `upms_config` DISABLE KEYS */;
/*!40000 ALTER TABLE `upms_config` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `upms_organization`
--
-- ORDER BY:  `organization_id`

LOCK TABLES `upms_organization` WRITE;
/*!40000 ALTER TABLE `upms_organization` DISABLE KEYS */;
INSERT INTO `upms_organization` VALUES (1,0,'ming科技有限公司','深圳总部','2020-05-02 05:55:02'),(2,1,'总公司','深圳总部','2020-05-02 05:55:02'),(4,1,'河北分公司','河北石家庄','2020-05-02 05:55:02'),(5,1,'河南分公司','河南郑州','2020-05-02 05:55:02'),(6,1,'湖北分公司','湖北武汉','2020-05-02 05:55:02'),(7,1,'湖南分公司','湖南长沙','2020-05-02 05:55:02'),(8,2,'总公司研发部','深圳总部研发部门','2020-05-02 19:55:02'),(9,2,'总公司市场部','深圳总部市场部门','2020-05-02 05:55:02'),(10,2,'总公司财务部','深圳总部财务部门','2020-05-02 05:55:02'),(11,2,'总公司运维部','深圳总部运维部门','2020-05-02 05:55:02'),(12,4,'石家庄支公司','河北省石家庄市','2020-05-10 12:35:36'),(13,6,'武汉支公司','湖北省武汉市','2020-05-10 12:36:40'),(14,13,'武汉营销部','武汉支公司市场营销部','2020-05-10 12:37:38');
/*!40000 ALTER TABLE `upms_organization` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `upms_permission`
--
-- ORDER BY:  `permission_id`

LOCK TABLES `upms_permission` WRITE;
/*!40000 ALTER TABLE `upms_permission` DISABLE KEYS */;
INSERT INTO `upms_permission` VALUES (1,1,0,'系统资源管理',1,'','','fa fa-gear',1,'2020-05-02 05:55:02',1),(2,1,1,'系统管理',2,'system:upmsSystem:read','/system/upmsSystem','fa fa-wrench',1,'2020-05-02 05:55:02',1),(3,1,1,'资源管理',2,'system:upmsPermission:read','/system/upmsPermission','fa fa-navicon',1,'2020-05-02 05:55:02',2),(4,1,0,'组织角色管理',1,NULL,'','fa fa-users',1,'2020-05-02 05:55:02',4),(5,1,4,'角色管理',2,'system:upmsRole:read','/system/upmsRole','fa fa-vcard',1,'2020-05-02 05:55:02',5),(6,1,4,'用户管理',2,'system:upmsUser:read','/system/upmsUser','fa fa-user-circle',1,'2020-05-02 05:55:02',6),(7,1,4,'组织管理',2,'system:upmsOrganization:read','/system/upmsOrganization','fa fa-users',1,'2020-05-02 05:55:02',3),(8,1,3,'修改',3,'system:upmsPermission:edit','','',1,'2020-05-07 22:26:23',1),(9,1,3,'删除',3,'system:upmsPermission:remove','','',1,'2020-05-07 22:34:02',1),(10,1,2,'添加',3,'system:upmsSystem:add','','',1,'2020-05-07 22:44:41',3),(15,1,0,'日志监控管理',1,'','','fa fa-video-camera',1,'2020-05-14 21:44:33',10),(16,1,15,'用户操作日志',2,'system:upmsLog:read','/system/upmsLog','fa fa-tachometer',1,'2020-05-14 21:46:41',2),(17,1,3,'添加',3,'system:upmsPermission:add','','',1,'2020-05-14 23:32:57',3),(18,1,2,'修改',3,'system:upmsSystem:edit','','',1,'2020-05-14 23:51:47',3),(19,1,5,'添加',3,'system:upmsRole:add','','',1,'2020-05-14 23:54:46',3),(20,1,5,'修改',3,'system:upmsRole:edit','','',1,'2020-05-14 23:55:16',3),(21,1,6,'添加',3,'system:upmsUser:add','','',1,'2020-05-15 21:24:40',3),(22,1,6,'修改',3,'system:upmsUser:edit','','',1,'2020-05-15 21:25:02',3),(23,1,7,'添加',3,'system:upmsOrganization:add','','',1,'2020-05-15 21:25:34',1),(24,1,7,'修改',3,'system:upmsOrganization:edit','','',1,'2020-05-15 21:27:10',3),(25,1,2,'删除',3,'system:upmsSystem:remove','','',1,'2020-06-03 21:16:13',3),(26,1,7,'删除',3,'system:upmsOrganization:remove','','',1,'2020-06-03 21:17:59',3),(27,1,5,'删除',3,'system:upmsRole:remove','','',1,'2020-06-03 21:18:51',3),(28,1,6,'删除',3,'system:upmsUser:remove','','',1,'2020-06-03 21:19:25',3),(29,1,16,'删除',3,'system:upmsLog:remove','','',1,'2020-06-03 21:20:25',1),(30,1,15,'数据库监控',2,'','/druid/index','fa fa-bar-chart',1,'2020-06-04 22:46:10',2),(31,1,15,'API接口文档',2,'','/swagger-ui.html','fa fa-tags',1,'2020-06-05 22:15:51',3);
/*!40000 ALTER TABLE `upms_permission` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `upms_role`
--
-- ORDER BY:  `role_id`

LOCK TABLES `upms_role` WRITE;
/*!40000 ALTER TABLE `upms_role` DISABLE KEYS */;
INSERT INTO `upms_role` VALUES (1,'super','超级管理员','拥有所有权限','2020-05-02 05:55:02',1),(2,'admin','管理员','拥有除权限管理系统外的所有权限','2020-05-02 05:55:02',2),(6,'test','测试用户','用于测试账号','2020-05-01 21:55:02',3);
/*!40000 ALTER TABLE `upms_role` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `upms_role_permission`
--
-- ORDER BY:  `role_permission_id`

LOCK TABLES `upms_role_permission` WRITE;
/*!40000 ALTER TABLE `upms_role_permission` DISABLE KEYS */;
INSERT INTO `upms_role_permission` VALUES (227,6,1),(228,6,2),(229,6,10),(230,6,18),(231,6,3),(232,6,8),(233,6,17),(234,2,4),(235,2,7),(236,2,23),(237,2,24),(238,2,26),(239,2,5),(240,2,19),(241,2,20),(242,2,27),(243,2,6),(244,2,21),(245,2,22),(246,2,28),(247,2,15),(248,2,16),(249,2,29),(276,1,1),(277,1,2),(278,1,10),(279,1,18),(280,1,25),(281,1,3),(282,1,8),(283,1,9),(284,1,17),(285,1,4),(286,1,7),(287,1,23),(288,1,24),(289,1,26),(290,1,5),(291,1,19),(292,1,20),(293,1,27),(294,1,6),(295,1,21),(296,1,22),(297,1,28),(298,1,15),(299,1,16),(300,1,29),(301,1,30),(302,1,31);
/*!40000 ALTER TABLE `upms_role_permission` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `upms_system`
--
-- ORDER BY:  `system_id`

LOCK TABLES `upms_system` WRITE;
/*!40000 ALTER TABLE `upms_system` DISABLE KEYS */;
INSERT INTO `upms_system` VALUES (1,'','','#29A176','http://localhost/index',1,'ming-upms','权限管理系统','用户权限管理系统（RBAC细粒度用户权限、统一后台、单点登录、会话管理）','2020-05-02 19:55:02',1),(2,NULL,NULL,'#29A176','http://localhost/ming-oa',1,'ming-oa','办公管理系统','办公管理系统（主要负责办公人事、信息公告和流程管理）','2020-05-02 19:55:02',2),(4,'','','','http://localhost/ming-cms',1,'ming-cms','内容管理系统','内容管理系统（文件存储、知识共享）','2020-05-05 18:23:30',1);
/*!40000 ALTER TABLE `upms_system` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `upms_user`
--
-- ORDER BY:  `user_id`

LOCK TABLES `upms_user` WRITE;
/*!40000 ALTER TABLE `upms_user` DISABLE KEYS */;
INSERT INTO `upms_user` VALUES (1,'admin','1d45e9bc108bcf0237885d37df5488c9','66f1b370c660445a8657bf8bf1794486','明杰','/img/profile_small01.jpg','18271681269','1090760001@qq.com',1,0,'2020-05-02 05:55:02',8),(8,'jie_ming514','b733189d4a00b0c882166a6e77a22b04','vKZ6EhUJVfBZxiO1EFdUHfwkJEO5A0','明杰','/img/profile_small03.jpg','18271681268','1090760002@qq.com',1,0,'2020-05-13 20:29:59',11),(9,'test','b5f7a38359cbafdb41452e32b0a1cc5d','l5266XyOiKpXT2FDYMtoOezjgIslyS','测试用户','/img/profile_small03.jpg','13311111111','jie_ming514@163.com',0,0,'2020-05-13 20:30:40',10);
/*!40000 ALTER TABLE `upms_user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `upms_user_organization`
--
-- ORDER BY:  `user_organization_id`

LOCK TABLES `upms_user_organization` WRITE;
/*!40000 ALTER TABLE `upms_user_organization` DISABLE KEYS */;
/*!40000 ALTER TABLE `upms_user_organization` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `upms_user_role`
--
-- ORDER BY:  `user_role_id`

LOCK TABLES `upms_user_role` WRITE;
/*!40000 ALTER TABLE `upms_user_role` DISABLE KEYS */;
INSERT INTO `upms_user_role` VALUES (1,1,1),(2,1,2),(3,8,2),(15,9,1),(16,8,1),(17,9,6),(18,8,6),(19,1,6);
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

-- Dump completed on 2020-11-28 16:04:02
