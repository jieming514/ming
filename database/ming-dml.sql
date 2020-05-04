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
-- Dumping data for table `upms_log`
--

LOCK TABLES `upms_log` WRITE;
/*!40000 ALTER TABLE `upms_log` DISABLE KEYS */;
/*!40000 ALTER TABLE `upms_log` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `upms_organization`
--

LOCK TABLES `upms_organization` WRITE;
/*!40000 ALTER TABLE `upms_organization` DISABLE KEYS */;
INSERT INTO `upms_organization` VALUES (1,NULL,'总部','北京总部','2020-05-02 05:55:02'),(4,NULL,'河北分部','河北石家庄','2020-05-02 05:55:02'),(5,NULL,'河南分部','河南郑州','2020-05-02 05:55:02'),(6,NULL,'湖北分部','湖北武汉','2020-05-02 05:55:02'),(7,NULL,'湖南分部','湖南长沙','2020-05-02 05:55:02');
/*!40000 ALTER TABLE `upms_organization` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `upms_permission`
--

LOCK TABLES `upms_permission` WRITE;
/*!40000 ALTER TABLE `upms_permission` DISABLE KEYS */;
INSERT INTO `upms_permission` VALUES (1,1,0,'系统组织管理',1,'','','fa fa-cog',1,'2020-05-02 05:55:02',1),(2,1,1,'资源管理',2,'upms:system:read','/system/upmsPermission','',1,'2020-05-02 05:55:02',2),(3,1,1,'组织管理',2,'upms:organization:read','/system/upmsOrganization','',1,'2020-05-02 05:55:02',3),(4,1,0,'角色用户管理',1,'','','fa fa-user',1,'2020-05-02 05:55:02',4),(5,1,4,'角色管理',2,'upms:role:read','/system/upmsRole','',1,'2020-05-02 05:55:02',5),(6,1,4,'用户管理',2,'upms:user:read','/system/upmsUser','',1,'2020-05-02 05:55:02',6),(7,1,1,'系统管理',2,'upms:system:read','/system/upmsSystem','',1,'2020-05-02 05:55:02',5);
/*!40000 ALTER TABLE `upms_permission` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `upms_role`
--

LOCK TABLES `upms_role` WRITE;
/*!40000 ALTER TABLE `upms_role` DISABLE KEYS */;
INSERT INTO `upms_role` VALUES (1,'super','超级管理员','拥有所有权限','2020-05-02 05:55:02',1),(2,'admin','管理员','拥有除权限管理系统外的所有权限','2020-05-02 05:55:02',2),(6,'test','测试用户','用于测试账号','2020-05-01 21:55:02',3);
/*!40000 ALTER TABLE `upms_role` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `upms_role_permission`
--

LOCK TABLES `upms_role_permission` WRITE;
/*!40000 ALTER TABLE `upms_role_permission` DISABLE KEYS */;
INSERT INTO `upms_role_permission` VALUES (1,1,1),(2,1,2),(3,1,3),(4,1,4),(5,1,5),(6,1,6),(7,1,7);
/*!40000 ALTER TABLE `upms_role_permission` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `upms_system`
--

LOCK TABLES `upms_system` WRITE;
/*!40000 ALTER TABLE `upms_system` DISABLE KEYS */;
INSERT INTO `upms_system` VALUES (1,'zmdi zmdi-shield-security','/resources/zheng-admin/images/zheng-upms.png','#29A176','http://upms.zhangshuzheng.cn:1111',1,'zheng-upms-server','权限管理系统','用户权限管理系统（RBAC细粒度用户权限、统一后台、单点登录、会话管理）','2020-05-02 05:55:02',1);
/*!40000 ALTER TABLE `upms_system` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `upms_user`
--

LOCK TABLES `upms_user` WRITE;
/*!40000 ALTER TABLE `upms_user` DISABLE KEYS */;
INSERT INTO `upms_user` VALUES (1,'admin','d1e2292b8991e896b272a37e1c9be3ad','66f1b370c660445a8657bf8bf1794486','管理员','/resources/zheng-admin/images/avatar.jpg','18271681268','1090760001@qq.com',1,0,'2020-05-02 05:55:02'),(2,'test','285C9762F5F9046F5893F752DFAF3476','d2d0d03310444ad388a8b290b0fe8564','测试账号','/resources/zheng-admin/images/avatar.jpg','18271681268','1090760001@qq.com',1,0,'2020-05-02 05:55:02');
/*!40000 ALTER TABLE `upms_user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `upms_user_organization`
--

LOCK TABLES `upms_user_organization` WRITE;
/*!40000 ALTER TABLE `upms_user_organization` DISABLE KEYS */;
/*!40000 ALTER TABLE `upms_user_organization` ENABLE KEYS */;
UNLOCK TABLES;

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

-- Dump completed on 2020-05-04 14:21:18
