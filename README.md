
# ming
[![image](https://img.shields.io/badge/CSDN-jie_ming514-orange.svg)](https://blog.csdn.net/m1090760001)
![image](https://img.shields.io/badge/license-Apache2.0-blue.svg)


## 一、项目介绍
ming 项目是基于SpringBoot2的一整套后端管理平台，提供整套公共微服务服务模块：集中权限管理（单点登录）、内容管理、人事办公。旨在通过实战分享个人经验简洁高效，减少过渡封装，展现技术本质,以技术服务于业务。


## 二、项目模块

### 2.1. 项目功能

#### 用户管理系统功能（UPMS）
  - 系统登录：系统用户登录，账号为admin/admin/admin123
  - 用户管理：新建用户，修改用户，删除用户，查询用户
  - 机构管理：新建机构，修改机构，删除机构，查询机构
  - 角色管理：新建角色，修改角色，删除角色，查询角色
  - 资源管理：新建资源，修改资源，删除资源，查询资源
  - 字典管理：新建字典，修改字典，删除字典，查询字典
  - 系统日志：记录用户登录和操作日志，查看系统执行日志记录
  - 代码生成：提供代码生成器，最大化的降低代码开发量
  - 主题切换：支持主题切换，自定主题颜色，一键换肤
  
#### 内容管理系统功能（CMS）
  - 未开始

#### 人事办公管理系统功能（OA）
  - 未开始


## 三、技术说明

### 3.1.后端技术
  - 核心框架：spring-boot
  - 安全框架：Apache Shiro
  - 持久层框架：MyBatis
  - 数据库连接池：Alibaba Druid
  - 模板引擎：Thymeleaf
  - 日志管理：Logback

### 3.2.前端技术
  - JS框架：jQuery
  - 弹出层：layer
  - 树结构控件：jsTree
  - 数据表格：bootstrap

### 3.3.开发工具
  - MySql: 数据库
  - Tomcat: 应用服务器
  - Git: 版本管理
  - IntelliJ IDEA: 开发IDE
  - MySQLWorkbench: 数据库客户端

### 3.4.规范约束
  - 参考[阿里巴巴Java开发手册]


## 四、部署说明

### 4.1.运行环境
  - Jdk8+
  - Mysql5.5+

### 4.2.部署说明

#### 运行前准备工作
  1. 新建ming数据库，导入database文件夹下的ming.sql；
  2. 修改application.yml文件中的mysql数据库的用户名和密码；
  
#### 启动
  - com.ming.MingUpmsApplication类的main方法

#### 登录
> 测试账号：admin/admin123


## 五、系统演示
  - 页面加载中


## 六、其他相关
### 6.1. ming 相关博客
  - CSDN博客：[jie_ming514的博客](https://blog.csdn.net/m1090760001)


