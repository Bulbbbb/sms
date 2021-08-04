-- MySQL dump 10.13  Distrib 5.7.26, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: gms
-- ------------------------------------------------------
-- Server version	5.7.26

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
-- Table structure for table `t_auth`
--

DROP TABLE IF EXISTS `t_auth`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_auth` (
	`a_num` varchar(100) NOT NULL COMMENT '权限编码',
	`a_name` varchar(100) DEFAULT NULL COMMENT '权限名称',
	PRIMARY KEY (`a_num`),
	UNIQUE KEY `t_auth_a_num_uindex` (`a_num`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='权限分级表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_auth`
--

LOCK TABLES `t_auth` WRITE;
/*!40000 ALTER TABLE `t_auth` DISABLE KEYS */;
INSERT INTO `t_auth` VALUES ('1','超级用户'),('2','教师'),('3','学生');
/*!40000 ALTER TABLE `t_auth` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_auth_power`
--

DROP TABLE IF EXISTS `t_auth_power`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_auth_power` (
	`auth_num` varchar(100) NOT NULL COMMENT '权限编码',
	`pow_num` varchar(100) DEFAULT NULL COMMENT '二级功能编码',
	`pow_name` varchar(100) DEFAULT NULL COMMENT '功能名称',
	`auth_name` varchar(100) DEFAULT NULL COMMENT '权限名称',
	KEY `auth_power_t_auth_a_num_fk` (`auth_num`),
	KEY `auth_power_t_power_2_p_num_fk` (`pow_num`),
	CONSTRAINT `auth_power_t_auth_a_num_fk` FOREIGN KEY (`auth_num`) REFERENCES `t_auth` (`a_num`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='权限功能联表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_auth_power`
--

LOCK TABLES `t_auth_power` WRITE;
/*!40000 ALTER TABLE `t_auth_power` DISABLE KEYS */;
INSERT INTO `t_auth_power` VALUES ('1','2001','系统管理',''),('1','2003','课程管理',NULL),('1','2004','成绩管理',NULL),('1','2005','机构管理',NULL),('2','2002','信息管理',NULL),('2','2003','课程管理',NULL),('2','2004','成绩管理',NULL),('1','2002','信息管理',NULL),('3','2006','课程查询',NULL),('3','2007','成绩查询',NULL),('3','2008','选课',NULL);
/*!40000 ALTER TABLE `t_auth_power` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_class`
--

DROP TABLE IF EXISTS `t_class`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_class` (
	`c_name` varchar(100) DEFAULT NULL COMMENT '班级名称',
	`c_num` varchar(100) NOT NULL COMMENT '班级编号',
	`key1` varchar(100) DEFAULT NULL COMMENT '预留字段1',
	`c_user_num` varchar(100) DEFAULT NULL COMMENT '班主任编号',
	`c_major` varchar(100) DEFAULT NULL COMMENT '所属专业',
	`c_ins` varchar(100) DEFAULT NULL COMMENT '所属学院',
	PRIMARY KEY (`c_num`),
	UNIQUE KEY `t_class_c_num_uindex` (`c_num`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='班级表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_class`
--

LOCK TABLES `t_class` WRITE;
/*!40000 ALTER TABLE `t_class` DISABLE KEYS */;
INSERT INTO `t_class` VALUES ('17移动通信本科二班','02',NULL,NULL,'网络工程（移动通信方向）','信息科学与工程学院');
/*!40000 ALTER TABLE `t_class` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_course`
--

DROP TABLE IF EXISTS `t_course`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_course` (
	`c_name` varchar(100) DEFAULT NULL COMMENT '课程姓名',
	`c_num` varchar(100) NOT NULL COMMENT '课程编号',
	`key1` varchar(100) DEFAULT NULL COMMENT '预留字段1',
	`key2` varchar(100) DEFAULT NULL COMMENT '预留字段2',
	`key3` varchar(100) DEFAULT NULL COMMENT '预留字段3',
	`c_ins` varchar(100) DEFAULT NULL COMMENT '开设学院',
	`is_sel` varchar(10) DEFAULT NULL COMMENT '是否可选',
	`c_gra` varchar(50) DEFAULT NULL COMMENT '学分',
	`c_time` varchar(50) DEFAULT NULL COMMENT '学时',
	`week` varchar(50) DEFAULT NULL COMMENT '上课时间',
	`cla` varchar(50) DEFAULT NULL COMMENT '上课时间',
	UNIQUE KEY `t_course_c_num_uindex` (`c_num`),
	KEY `t_course_t_ins_i_name_fk` (`c_ins`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='课程表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_course`
--

LOCK TABLES `t_course` WRITE;
/*!40000 ALTER TABLE `t_course` DISABLE KEYS */;
INSERT INTO `t_course` VALUES ('应用写作','A111003',NULL,NULL,NULL,'文学院','否','1','16',NULL,NULL),('高等数学A1','D121001',NULL,NULL,NULL,'信息科学与工程学院','否','6','96',NULL,NULL),('高等数学A2','D121002',NULL,NULL,NULL,'信息科学与工程学院','否','6','96',NULL,NULL),('线性代数B','D121210',NULL,NULL,NULL,'信息科学与工程学院','否','3','48',NULL,NULL),('概率统计','D121211',NULL,NULL,NULL,'信息科学与工程学院','否','4','64',NULL,NULL),('大学体育1','I111001',NULL,NULL,NULL,'体育学院','否','1','32',NULL,NULL),('大学体育2','I111002',NULL,NULL,NULL,'体育学院','否','1','32',NULL,NULL),('大学体育3','I111003',NULL,NULL,NULL,'体育学院','否','1','32',NULL,NULL),('大学体育4','I111004',NULL,NULL,NULL,'体育学院','否','1','32',NULL,NULL),('C语言程序设计','L121501',NULL,NULL,NULL,'信息科学与工程学院','否','4.5','96',NULL,NULL),('移动通信工程导论','L121551',NULL,NULL,NULL,'信息科学与工程学院','否','2','32',NULL,NULL),('数字电子技术','L121552',NULL,NULL,NULL,'信息科学与工程学院','否','2.5','48',NULL,NULL),('数字图像处理技术','L122013',NULL,NULL,NULL,'信息科学与工程学院','否','1.5','32',NULL,NULL),('电子商务应用','L122024',NULL,NULL,NULL,'信息科学与工程学院','否','1.5','32',NULL,NULL),('计算机辅助设计','L122033',NULL,NULL,NULL,'信息科学与工程学院','否','1.5','32',NULL,NULL),('Web编程基础','L122553',NULL,NULL,NULL,'信息科学与工程学院','否','1.5','32',NULL,NULL),('计算机组成原理','L131002',NULL,NULL,NULL,'信息科学与工程学院','否','3.5','64',NULL,NULL),('操作系统','L131005',NULL,NULL,NULL,'信息科学与工程学院','否','3.5','64',NULL,NULL),('计算机网络','L131006',NULL,NULL,NULL,'信息科学与工程学院','否','3.5','64',NULL,NULL),('Java程序设计','L131013',NULL,NULL,NULL,'信息科学与工程学院','否','3','64',NULL,NULL),('数据结构','L131081',NULL,NULL,NULL,'信息科学与工程学院','否','3.5','64',NULL,NULL),('数据通信技术','L131552',NULL,NULL,NULL,'信息科学与工程学院','否','5','96',NULL,NULL),('光传输技术','L131554',NULL,NULL,NULL,'信息科学与工程学院','否','3','64',NULL,NULL),('网络安全技术','L131557',NULL,NULL,NULL,'信息科学与工程学院','否','2','48',NULL,NULL),('数据库系统原理与应用','L131560',NULL,NULL,NULL,'信息科学与工程学院','否','3','64',NULL,NULL),('Linux服务器管理与应用','L132017',NULL,NULL,NULL,'信息科学与工程学院','否','3','64',NULL,NULL),('综合布线与工程管理','L132077',NULL,NULL,NULL,'信息科学与工程学院','否','3','64',NULL,NULL),('J2EE轻量级解决方案','L132123',NULL,NULL,NULL,'信息科学与工程学院','否','3','64',NULL,NULL),('Java Web程序设计','L132504',NULL,NULL,NULL,'信息科学与工程学院','否','3','64',NULL,NULL),('移动云端开发技术','L132508',NULL,NULL,NULL,'信息科学与工程学院','否','3','64',NULL,NULL),('云网络维护与管理','L132512',NULL,NULL,NULL,'信息科学与工程学院','否','3','64',NULL,NULL),('云网络与信息安全','L132513',NULL,NULL,NULL,'信息科学与工程学院','否','3','64',NULL,NULL),('路由与交换技术','L132550',NULL,NULL,NULL,'信息科学与工程学院','否','3','64',NULL,NULL),('3G移动通信技术','L132551',NULL,NULL,NULL,'信息科学与工程学院','否','3','64',NULL,NULL),('网络协议分析与实现','L132552',NULL,NULL,NULL,'信息科学与工程学院','否','3','64',NULL,NULL),('移动网络规划与优化','L132553',NULL,NULL,NULL,'信息科学与工程学院','否','3','64',NULL,NULL),('电信工程实施','L132554',NULL,NULL,NULL,'信息科学与工程学院','否','3','64',NULL,NULL),('4G移动通信技术','L132555',NULL,NULL,NULL,'信息科学与工程学院','否','3','64',NULL,NULL),('现代交换技术','L132556',NULL,NULL,NULL,'信息科学与工程学院','否','3','64',NULL,NULL),('行业认证','L141087',NULL,NULL,NULL,'信息科学与工程学院','否','1','32',NULL,NULL),('市场营销','L142016',NULL,NULL,NULL,'信息科学与工程学院','否','2','64',NULL,NULL),('金融基础','L142017',NULL,NULL,NULL,'信息科学与工程学院','否','2','64',NULL,NULL),('创业项目路演','L142018',NULL,NULL,NULL,'信息科学与工程学院','否','2','64',NULL,NULL),('网络攻防实战','L142019',NULL,NULL,NULL,'信息科学与工程学院','否','1','0',NULL,NULL),('网页设计实战','L142020',NULL,NULL,NULL,'信息科学与工程学院','否','2','64',NULL,NULL),('UI设计实战','L142021',NULL,NULL,NULL,'信息科学与工程学院','否','2','64',NULL,NULL),('物联网设计实战','L142022',NULL,NULL,NULL,'信息科学与工程学院','否','2','64',NULL,NULL),('ACM程序设计实战','L142023',NULL,NULL,NULL,'信息科学与工程学院','否','2','0',NULL,NULL),('数学建模与算法','L142024',NULL,NULL,NULL,'信息科学与工程学院','否','2','0',NULL,NULL),('软件设计实战','L142025',NULL,NULL,NULL,'信息科学与工程学院','否','1','0',NULL,NULL),('认知见习','L151003',NULL,NULL,NULL,'信息科学与工程学院','否','1','0',NULL,NULL),('专业实习','L151400',NULL,NULL,NULL,'信息科学与工程学院','否','7','0',NULL,NULL),('项目实训一','L152001',NULL,NULL,NULL,'信息科学与工程学院','否','1','0',NULL,NULL),('项目实训二','L152002',NULL,NULL,NULL,'信息科学与工程学院','否','1','0',NULL,NULL),('项目实训三','L152003',NULL,NULL,NULL,'信息科学与工程学院','否','1','0',NULL,NULL),('项目实训四','L152004',NULL,NULL,NULL,'信息科学与工程学院','否','1','0',NULL,NULL),('项目实训五','L152005',NULL,NULL,NULL,'信息科学与工程学院','否','1','0',NULL,NULL),('项目实训六','L152006',NULL,NULL,NULL,'信息科学与工程学院','否','1','0',NULL,NULL),('创业基础','LZ00001',NULL,NULL,NULL,'信息科学与工程学院','否','2','16',NULL,NULL),('毕业教育','LZ00002',NULL,NULL,NULL,'信息科学与工程学院','否','2','0',NULL,NULL),('毕业设计（论文）','LZ00003',NULL,NULL,NULL,'信息科学与工程学院','否','6','0',NULL,NULL),('课外拓展活动','Lz042001',NULL,NULL,NULL,'信息科学与工程学院','否','2','32',NULL,NULL),('大学英语1','R111016',NULL,NULL,NULL,'大学英语教学部','否','4','64',NULL,NULL),('大学英语2','R111017',NULL,NULL,NULL,'大学英语教学部','否','4','64',NULL,NULL),('大学英语3','R111018',NULL,NULL,NULL,'大学英语教学部','否','2','32',NULL,NULL),('大学英语4','R111019',NULL,NULL,NULL,'大学英语教学部','否','2','32',NULL,NULL),('思想道德修养与法律基础','S111001',NULL,NULL,NULL,'马克思主义学院','否','3','32',NULL,NULL),('中国近现代史纲要','S111002',NULL,NULL,NULL,'马克思主义学院','否','2','32',NULL,NULL),('马克思主义基本原理概论','S111003',NULL,NULL,NULL,'马克思主义学院','否','3','32',NULL,NULL),('毛泽东思想和中国特色社会主义理论体系概论','S111004',NULL,NULL,NULL,'马克思主义学院','否','6','64',NULL,NULL),('形势与政策2','S111006',NULL,NULL,NULL,'马克思主义学院','否','0.2','8',NULL,NULL),('形势与政策3','S111007',NULL,NULL,NULL,'马克思主义学院','否','0.3','8',NULL,NULL),('形势与政策4','S111008',NULL,NULL,NULL,'马克思主义学院','否','0.2','8',NULL,NULL),('形势与政策5','S111009',NULL,NULL,NULL,'马克思主义学院','否','0.3','8',NULL,NULL),('形势与政策6','S111010',NULL,NULL,NULL,'马克思主义学院','否','0.2','8',NULL,NULL),('化学与人类','xx0001',NULL,NULL,NULL,'化学化工与材料科学学院','是','1','24','六','2'),('数学大观','xx0002',NULL,NULL,NULL,'信息科学与工程学院','是','1','24','六','2'),('军事理论','Z011001',NULL,NULL,NULL,'学生工作处','否','2','32',NULL,NULL),('企业走进校园','Z041501',NULL,NULL,NULL,'信息科学与工程学院','否','0.5','16',NULL,NULL),('准职业人导向训练一','Z041502',NULL,NULL,NULL,'信息科学与工程学院','否','1','32',NULL,NULL),('准职业人导向训练二','Z041503',NULL,NULL,NULL,'信息科学与工程学院','否','1','32',NULL,NULL),('职业定位与发展一','Z041504',NULL,NULL,NULL,'信息科学与工程学院','否','1','32',NULL,NULL),('职业定位与发展二','Z041505',NULL,NULL,NULL,'信息科学与工程学院','否','1','32',NULL,NULL),('求职能力提升训练','Z041506',NULL,NULL,NULL,'信息科学与工程学院','否','0.5','16',NULL,NULL),('军事技能训练','Z051001',NULL,NULL,NULL,'学生工作处','否','2','32',NULL,NULL),('社会实践3','Z051004',NULL,NULL,NULL,'团委','否','0.3','0',NULL,NULL),('社会实践4','Z051005',NULL,NULL,NULL,'团委','否','0.3','0',NULL,NULL),('社会实践5','Z051006',NULL,NULL,NULL,'团委','否','0.3','0',NULL,NULL),('社会实践6','Z051007',NULL,NULL,NULL,'团委','否','0.3','0',NULL,NULL);
/*!40000 ALTER TABLE `t_course` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_ins`
--

DROP TABLE IF EXISTS `t_ins`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_ins` (
	`i_num` varchar(100) NOT NULL COMMENT '机构编号',
	`i_name` varchar(100) DEFAULT NULL COMMENT '机构名称',
	`key1` varchar(100) DEFAULT NULL COMMENT '预留字段1',
	`key2` varchar(100) DEFAULT NULL COMMENT '预留字段2',
	`key3` varchar(100) DEFAULT NULL COMMENT '预留字段3',
	PRIMARY KEY (`i_num`),
	UNIQUE KEY `t_ins_i_name_i_num_uindex` (`i_name`,`i_num`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='机构表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_ins`
--

LOCK TABLES `t_ins` WRITE;
/*!40000 ALTER TABLE `t_ins` DISABLE KEYS */;
INSERT INTO `t_ins` VALUES ('01','大学英语教学部',NULL,NULL,NULL),('02','马克思主义学院',NULL,NULL,NULL),('03','团委',NULL,NULL,NULL),('04','文学院',NULL,NULL,NULL),('05','学生工作处',NULL,NULL,NULL),('06','体育学院',NULL,NULL,NULL),('07','化学化工与材料科学学院',NULL,NULL,NULL),('10','美术学院',NULL,NULL,NULL),('12','信息科学与工程学院',NULL,NULL,NULL);
/*!40000 ALTER TABLE `t_ins` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_maj_cour`
--

DROP TABLE IF EXISTS `t_maj_cour`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_maj_cour` (
	`maj_name` varchar(100) DEFAULT NULL COMMENT '专业名称',
	`cour_name` varchar(100) DEFAULT NULL COMMENT '课程名称',
	`cour_ins` varchar(100) DEFAULT NULL COMMENT '开课机构',
	`year` varchar(10) DEFAULT NULL COMMENT '开课学年',
	`school` varchar(10) DEFAULT NULL COMMENT '开课学期'
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='专业课程表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_maj_cour`
--

LOCK TABLES `t_maj_cour` WRITE;
/*!40000 ALTER TABLE `t_maj_cour` DISABLE KEYS */;
INSERT INTO `t_maj_cour` VALUES ('网络工程（移动通信方向）','大学英语1','大学英语教学部','1','1'),('网络工程（移动通信方向）','应用写作','文学院','1','1'),('网络工程（移动通信方向）','大学体育1','体育学院','1','1'),('网络工程（移动通信方向）','C语言程序设计','信息科学与工程学院','1','1'),('网络工程（移动通信方向）','移动通信工程导论','信息科学与工程学院','1','1'),('网络工程（移动通信方向）','数字电子技术','信息科学与工程学院','1','1'),('网络工程（移动通信方向）','认知见习','信息科学与工程学院','1','1'),('网络工程（移动通信方向）','思想道德修养与法律基础','马克思主义学院','1','1'),('网络工程（移动通信方向）','军事理论','学生工作处','1','1'),('网络工程（移动通信方向）','军事技能训练','学生工作处','1','1'),('网络工程（移动通信方向）','企业走进校园','信息科学与工程学院','1','1');
/*!40000 ALTER TABLE `t_maj_cour` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_major`
--

DROP TABLE IF EXISTS `t_major`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_major` (
	`m_name` varchar(100) DEFAULT NULL COMMENT '专业姓名',
	`m_num` varchar(100) NOT NULL COMMENT '专业编号',
	`key1` varchar(100) DEFAULT NULL COMMENT '预留字段1',
	`key2` varchar(100) DEFAULT NULL COMMENT '预留字段2',
	`key3` varchar(100) DEFAULT NULL COMMENT '预留字段3',
	`m_ins` varchar(100) DEFAULT NULL COMMENT '所属学院',
	PRIMARY KEY (`m_num`),
	UNIQUE KEY `t_major_m_num_uindex` (`m_num`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='专业表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_major`
--

LOCK TABLES `t_major` WRITE;
/*!40000 ALTER TABLE `t_major` DISABLE KEYS */;
INSERT INTO `t_major` VALUES ('网络工程（移动通信方向）','20',NULL,NULL,NULL,'信息科学与工程学院');
/*!40000 ALTER TABLE `t_major` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_power`
--

DROP TABLE IF EXISTS `t_power`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_power` (
	`p_name` varchar(100) DEFAULT NULL COMMENT '功能名称',
	`p_num` varchar(100) NOT NULL COMMENT '功能编号',
	`key1` varchar(100) DEFAULT NULL COMMENT '预留字段1',
	`key2` varchar(100) DEFAULT NULL COMMENT '预留字段2',
	`key3` varchar(100) DEFAULT NULL COMMENT '预留字段3',
	PRIMARY KEY (`p_num`),
	UNIQUE KEY `t_power_2_p_num_uindex` (`p_num`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='二级功能表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_power`
--

LOCK TABLES `t_power` WRITE;
/*!40000 ALTER TABLE `t_power` DISABLE KEYS */;
INSERT INTO `t_power` VALUES ('权限管理','2001',NULL,NULL,NULL),('信息录入','2002',NULL,NULL,NULL),('信息查询','2003',NULL,NULL,NULL),('信息更新','2004',NULL,NULL,NULL),('课程创建','2005',NULL,NULL,NULL),('课程查询','2006',NULL,NULL,NULL),('课程更新','2007',NULL,NULL,NULL),('成绩录入','2008',NULL,NULL,NULL),('成绩查询','2009',NULL,NULL,NULL),('成绩更新','2010',NULL,NULL,NULL),('机构创建','2011',NULL,NULL,NULL),('机构查询','2012',NULL,NULL,NULL),('机构更新','2013',NULL,NULL,NULL);
/*!40000 ALTER TABLE `t_power` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_stu`
--

DROP TABLE IF EXISTS `t_stu`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_stu` (
	`s_name` varchar(100) DEFAULT NULL COMMENT '学生姓名',
	`s_num` varchar(100) NOT NULL COMMENT '学生编号',
	`s_sex` varchar(1) DEFAULT NULL COMMENT '学生性别',
	`s_email` varchar(100) DEFAULT NULL COMMENT '邮箱',
	`s_phone` varchar(100) DEFAULT NULL COMMENT '电话',
	`s_addr` varchar(100) DEFAULT NULL COMMENT '籍贯',
	`s_pic` varchar(200) DEFAULT NULL COMMENT '照片',
	`s_state` varchar(100) DEFAULT NULL COMMENT '状态',
	`s_in` varchar(100) DEFAULT NULL COMMENT '入学年份',
	`s_birth` varchar(100) DEFAULT NULL COMMENT '出生年份',
	`key1` varchar(100) DEFAULT NULL COMMENT '预留字段1',
	`key2` varchar(100) DEFAULT NULL COMMENT '预留字段2',
	`key3` varchar(100) DEFAULT NULL COMMENT '预留字段3',
	`s_ins` varchar(100) NOT NULL COMMENT '所属学院',
	`s_maj` varchar(100) NOT NULL COMMENT '所属专业',
	`s_cla` varchar(100) DEFAULT NULL COMMENT '所属班级',
	`s_auth` varchar(100) DEFAULT NULL COMMENT '学生权限等级',
	`s_pwd` varchar(100) DEFAULT NULL COMMENT '密码',
	PRIMARY KEY (`s_num`),
	UNIQUE KEY `t_stu_s_num_uindex` (`s_num`),
	KEY `t_stu_t_class_c_num_fk` (`s_cla`),
	KEY `t_stu_t_ins_i_num_fk` (`s_ins`),
	KEY `t_stu_t_major_m_num_fk` (`s_maj`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='学生表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_stu`
--

LOCK TABLES `t_stu` WRITE;
/*!40000 ALTER TABLE `t_stu` DISABLE KEYS */;
INSERT INTO `t_stu` VALUES ('学生1','11111111111','男',NULL,NULL,NULL,NULL,'枣庄学院在读','2021',NULL,NULL,NULL,NULL,'信息科学与工程学院','网络工程（移动通信方向）','17移动通信本科二班','3','11111'),('白顺义','201712200201','男',NULL,NULL,NULL,NULL,'枣庄学院在读','2021',NULL,NULL,NULL,NULL,'信息科学与工程学院','网络工程（移动通信方向）','17移动通信本科二班','3','00201'),('柏娇','201712200202','女',NULL,NULL,NULL,NULL,'枣庄学院在读','2021',NULL,NULL,NULL,NULL,'信息科学与工程学院','网络工程（移动通信方向）','17移动通信本科二班','3','00202'),('陈海悦','201712200203','女',NULL,NULL,NULL,NULL,'枣庄学院在读','2021',NULL,NULL,NULL,NULL,'信息科学与工程学院','网络工程（移动通信方向）','17移动通信本科二班','3','00203'),('陈浩楠','201712200204','女',NULL,NULL,NULL,NULL,'枣庄学院在读','2021',NULL,NULL,NULL,NULL,'信息科学与工程学院','网络工程（移动通信方向）','17移动通信本科二班','3','00204'),('陈建锟','201712200205','男',NULL,NULL,NULL,NULL,'枣庄学院在读','2021',NULL,NULL,NULL,NULL,'信息科学与工程学院','网络工程（移动通信方向）','17移动通信本科二班','3','00205'),('迟百慧','201712200206','女',NULL,NULL,NULL,NULL,'枣庄学院在读','2021',NULL,NULL,NULL,NULL,'信息科学与工程学院','网络工程（移动通信方向）','17移动通信本科二班','3','00206'),('傅友鑫','201712200207','男',NULL,NULL,NULL,NULL,'枣庄学院在读','2021',NULL,NULL,NULL,NULL,'信息科学与工程学院','网络工程（移动通信方向）','17移动通信本科二班','3','00207'),('郝继尧','201712200208','男',NULL,NULL,NULL,NULL,'枣庄学院在读','2021',NULL,NULL,NULL,NULL,'信息科学与工程学院','网络工程（移动通信方向）','17移动通信本科二班','3','00208'),('华群','201712200209','女',NULL,NULL,NULL,NULL,'枣庄学院在读','2021',NULL,NULL,NULL,NULL,'信息科学与工程学院','网络工程（移动通信方向）','17移动通信本科二班','3','00209'),('籍光耀','201712200210','男',NULL,NULL,NULL,NULL,'枣庄学院在读','2021',NULL,NULL,NULL,NULL,'信息科学与工程学院','网络工程（移动通信方向）','17移动通信本科二班','3','00210'),('蒋锐钰','201712200211','男',NULL,NULL,NULL,NULL,'枣庄学院在读','2021',NULL,NULL,NULL,NULL,'信息科学与工程学院','网络工程（移动通信方向）','17移动通信本科二班','3','00211'),('雷婷','201712200212','女',NULL,NULL,NULL,NULL,'枣庄学院在读','2021',NULL,NULL,NULL,NULL,'信息科学与工程学院','网络工程（移动通信方向）','17移动通信本科二班','3','00212'),('李丙鑫','201712200213','男',NULL,NULL,NULL,NULL,'枣庄学院在读','2021',NULL,NULL,NULL,NULL,'信息科学与工程学院','网络工程（移动通信方向）','17移动通信本科二班','3','00213'),('李青竹','201712200215','女',NULL,NULL,NULL,NULL,'枣庄学院在读','2021',NULL,NULL,NULL,NULL,'信息科学与工程学院','网络工程（移动通信方向）','17移动通信本科二班','3','00215'),('李鑫茹','201712200216','女',NULL,NULL,NULL,NULL,'枣庄学院在读','2021',NULL,NULL,NULL,NULL,'信息科学与工程学院','网络工程（移动通信方向）','17移动通信本科二班','3','00216'),('李志强','201712200217','男',NULL,NULL,NULL,NULL,'枣庄学院在读','2021',NULL,NULL,NULL,NULL,'信息科学与工程学院','网络工程（移动通信方向）','17移动通信本科二班','3','00217'),('刘立博','201712200218','男',NULL,NULL,NULL,NULL,'枣庄学院在读','2021',NULL,NULL,NULL,NULL,'信息科学与工程学院','网络工程（移动通信方向）','17移动通信本科二班','3','00218'),('刘胜光','201712200219','男',NULL,NULL,NULL,NULL,'枣庄学院在读','2021',NULL,NULL,NULL,NULL,'信息科学与工程学院','网络工程（移动通信方向）','17移动通信本科二班','3','00219'),('刘书鑫','201712200220','男',NULL,NULL,NULL,NULL,'枣庄学院在读','2021',NULL,NULL,NULL,NULL,'信息科学与工程学院','网络工程（移动通信方向）','17移动通信本科二班','3','00220'),('刘莹','201712200221','女',NULL,NULL,NULL,NULL,'枣庄学院在读','2021',NULL,NULL,NULL,NULL,'信息科学与工程学院','网络工程（移动通信方向）','17移动通信本科二班','3','00221'),('卢清涛','201712200222','男',NULL,NULL,NULL,NULL,'枣庄学院在读','2021',NULL,NULL,NULL,NULL,'信息科学与工程学院','网络工程（移动通信方向）','17移动通信本科二班','3','00222'),('马铎源','201712200223','女',NULL,NULL,NULL,NULL,'枣庄学院在读','2021',NULL,NULL,NULL,NULL,'信息科学与工程学院','网络工程（移动通信方向）','17移动通信本科二班','3','00223'),('马伟','201712200224','男',NULL,NULL,NULL,NULL,'枣庄学院在读','2021',NULL,NULL,NULL,NULL,'信息科学与工程学院','网络工程（移动通信方向）','17移动通信本科二班','3','00224'),('牛耘','201712200225','女',NULL,NULL,NULL,NULL,'枣庄学院在读','2021',NULL,NULL,NULL,NULL,'信息科学与工程学院','网络工程（移动通信方向）','17移动通信本科二班','3','00225'),('任允健','201712200226','男',NULL,NULL,NULL,NULL,'枣庄学院在读','2021',NULL,NULL,NULL,NULL,'信息科学与工程学院','网络工程（移动通信方向）','17移动通信本科二班','3','00226'),('史鹏升','201712200227','男',NULL,NULL,NULL,NULL,'枣庄学院在读','2021',NULL,NULL,NULL,NULL,'信息科学与工程学院','网络工程（移动通信方向）','17移动通信本科二班','3','00227'),('司文悦','201712200228','女',NULL,NULL,NULL,NULL,'枣庄学院在读','2021',NULL,NULL,NULL,NULL,'信息科学与工程学院','网络工程（移动通信方向）','17移动通信本科二班','3','00228'),('孙红燕','201712200229','女',NULL,NULL,NULL,NULL,'枣庄学院在读','2021',NULL,NULL,NULL,NULL,'信息科学与工程学院','网络工程（移动通信方向）','17移动通信本科二班','3','00229'),('孙永杰','201712200230','男',NULL,NULL,NULL,NULL,'枣庄学院在读','2021',NULL,NULL,NULL,NULL,'信息科学与工程学院','网络工程（移动通信方向）','17移动通信本科二班','3','00230'),('王瑞祥','201712200231','男',NULL,NULL,NULL,NULL,'枣庄学院在读','2021',NULL,NULL,NULL,NULL,'信息科学与工程学院','网络工程（移动通信方向）','17移动通信本科二班','3','00231'),('王腾','201712200232','女',NULL,NULL,NULL,NULL,'枣庄学院在读','2021',NULL,NULL,NULL,NULL,'信息科学与工程学院','网络工程（移动通信方向）','17移动通信本科二班','3','00232'),('王现阔','201712200233','男',NULL,NULL,NULL,NULL,'枣庄学院在读','2021',NULL,NULL,NULL,NULL,'信息科学与工程学院','网络工程（移动通信方向）','17移动通信本科二班','3','00233'),('王晓涵','201712200234','男',NULL,NULL,NULL,NULL,'枣庄学院在读','2021',NULL,NULL,NULL,NULL,'信息科学与工程学院','网络工程（移动通信方向）','17移动通信本科二班','3','00234'),('王湛博','201712200235','男',NULL,NULL,NULL,NULL,'枣庄学院在读','2021',NULL,NULL,NULL,NULL,'信息科学与工程学院','网络工程（移动通信方向）','17移动通信本科二班','3','00235'),('吴升坤','201712200236','男',NULL,NULL,NULL,NULL,'枣庄学院在读','2021',NULL,NULL,NULL,NULL,'信息科学与工程学院','网络工程（移动通信方向）','17移动通信本科二班','3','00236'),('徐畅','201712200237','男',NULL,NULL,NULL,NULL,'枣庄学院在读','2021',NULL,NULL,NULL,NULL,'信息科学与工程学院','网络工程（移动通信方向）','17移动通信本科二班','3','00237'),('闫涛','201712200238','男',NULL,NULL,NULL,NULL,'枣庄学院在读','2021',NULL,NULL,NULL,NULL,'信息科学与工程学院','网络工程（移动通信方向）','17移动通信本科二班','3','00238'),('杨萍原','201712200239','女',NULL,NULL,NULL,NULL,'枣庄学院在读','2021',NULL,NULL,NULL,NULL,'信息科学与工程学院','网络工程（移动通信方向）','17移动通信本科二班','3','00239'),('杨新露','201712200240','女',NULL,NULL,NULL,NULL,'枣庄学院在读','2021',NULL,NULL,NULL,NULL,'信息科学与工程学院','网络工程（移动通信方向）','17移动通信本科二班','3','00240'),('于芳','201712200241','女',NULL,NULL,NULL,NULL,'枣庄学院在读','2021',NULL,NULL,NULL,NULL,'信息科学与工程学院','网络工程（移动通信方向）','17移动通信本科二班','3','00241'),('于雨欣','201712200242','女',NULL,NULL,NULL,NULL,'枣庄学院在读','2021',NULL,NULL,NULL,NULL,'信息科学与工程学院','网络工程（移动通信方向）','17移动通信本科二班','3','00242'),('翟庆侠','201712200243','女',NULL,NULL,NULL,NULL,'枣庄学院在读','2021',NULL,NULL,NULL,NULL,'信息科学与工程学院','网络工程（移动通信方向）','17移动通信本科二班','3','00243'),('张高飞','201712200244','男',NULL,NULL,NULL,NULL,'枣庄学院在读','2021',NULL,NULL,NULL,NULL,'信息科学与工程学院','网络工程（移动通信方向）','17移动通信本科二班','3','00244'),('张瑜','201712200245','女',NULL,NULL,NULL,NULL,'枣庄学院在读','2021',NULL,NULL,NULL,NULL,'信息科学与工程学院','网络工程（移动通信方向）','17移动通信本科二班','3','00245'),('张毓畅','201712200246','男',NULL,NULL,NULL,NULL,'枣庄学院在读','2021',NULL,NULL,NULL,NULL,'信息科学与工程学院','网络工程（移动通信方向）','17移动通信本科二班','3','00246'),('种道清','201712200247','男',NULL,NULL,NULL,NULL,'枣庄学院在读','2021',NULL,NULL,NULL,NULL,'信息科学与工程学院','网络工程（移动通信方向）','17移动通信本科二班','3','00247'),('周超','201712200248','女',NULL,NULL,NULL,NULL,'枣庄学院在读','2021',NULL,NULL,NULL,NULL,'信息科学与工程学院','网络工程（移动通信方向）','17移动通信本科二班','3','00248'),('周盼','201712200249','女',NULL,NULL,NULL,NULL,'枣庄学院在读','2021',NULL,NULL,NULL,NULL,'信息科学与工程学院','网络工程（移动通信方向）','17移动通信本科二班','3','00249'),('邹忠冉','201712200250','男',NULL,NULL,NULL,NULL,'枣庄学院在读','2021',NULL,NULL,NULL,NULL,'信息科学与工程学院','网络工程（移动通信方向）','17移动通信本科二班','3','00250');
/*!40000 ALTER TABLE `t_stu` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_stu_cour`
--

DROP TABLE IF EXISTS `t_stu_cour`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_stu_cour` (
	`stu_name` varchar(100) NOT NULL COMMENT '学生',
	`cour_name` varchar(100) NOT NULL COMMENT '课程',
	`year` varchar(100) DEFAULT NULL COMMENT '年份',
	`school` varchar(100) DEFAULT NULL COMMENT '学期',
	`cla` varchar(100) DEFAULT NULL COMMENT '班级',
	`grade` varchar(100) DEFAULT NULL COMMENT '分数',
	`num` varchar(100) DEFAULT NULL COMMENT '学号',
	KEY `t_stu_cour_t_stu_s_num_fk` (`stu_name`),
	KEY `t_stu_cour_t_course_c_num_fk` (`cour_name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='学生课程表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_stu_cour`
--

LOCK TABLES `t_stu_cour` WRITE;
/*!40000 ALTER TABLE `t_stu_cour` DISABLE KEYS */;
INSERT INTO `t_stu_cour` VALUES ('白顺义','C语言程序设计','1','1','17移动通信本科二班','20',NULL),('孙永杰','大学英语1','1','1','17移动通信本科二班','30',NULL);
/*!40000 ALTER TABLE `t_stu_cour` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_user`
--

DROP TABLE IF EXISTS `t_user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_user` (
	`u_name` varchar(100) DEFAULT NULL COMMENT '姓名',
	`u_num` varchar(100) NOT NULL COMMENT '工号',
	`u_job` varchar(100) DEFAULT NULL COMMENT '职位',
	`u_sex` varchar(100) DEFAULT NULL COMMENT '性别',
	`u_birth` varchar(100) DEFAULT NULL COMMENT '出生日期，只需要年份',
	`u_email` varchar(100) DEFAULT NULL COMMENT '邮箱',
	`u_edu` varchar(100) DEFAULT NULL COMMENT '学历',
	`u_phone` varchar(100) DEFAULT NULL COMMENT '电话',
	`key1` varchar(100) DEFAULT NULL COMMENT '预留字段1',
	`key2` varchar(100) DEFAULT NULL COMMENT '预留字段2',
	`key3` varchar(100) DEFAULT NULL COMMENT '预留字段3',
	`u_pwd` varchar(100) NOT NULL COMMENT '登录密码',
	`u_ins` varchar(100) DEFAULT NULL COMMENT '所属机构',
	`t_auth` varchar(100) DEFAULT NULL COMMENT '用户权限等级',
	`u_in` varchar(50) DEFAULT NULL COMMENT '入职时间',
	PRIMARY KEY (`u_num`),
	UNIQUE KEY `t_user_u_num_uindex` (`u_num`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_user`
--

LOCK TABLES `t_user` WRITE;
/*!40000 ALTER TABLE `t_user` DISABLE KEYS */;
INSERT INTO `t_user` VALUES ('超级用户','11111','领导','男',NULL,NULL,'博士',NULL,NULL,NULL,NULL,'11111','教务处','1','2021'),('老师1','11112','讲师','男',NULL,NULL,'博士',NULL,NULL,NULL,NULL,'11112','信息科学与工程学院','2','2021'),('老师2','11113','讲师','男',NULL,NULL,'博士',NULL,NULL,NULL,NULL,'11113','信息科学与工程学院','2','2021'),('老师3','11114','讲师','女',NULL,NULL,'博士',NULL,NULL,NULL,NULL,'11114','信息科学与工程学院','2','2021'),('老师4','11115','教授','女',NULL,NULL,'博士',NULL,NULL,NULL,NULL,'11115','信息科学与工程学院','2','2021'),('老师5','11116','副教授','男',NULL,NULL,'博士',NULL,NULL,NULL,NULL,'11116','信息科学与工程学院','2','2021'),('老师6','11117','研究员','女',NULL,NULL,'博士',NULL,NULL,NULL,NULL,'11117','信息科学与工程学院','2','2021'),('老师7','11118','副教授','男',NULL,NULL,'博士',NULL,NULL,NULL,NULL,'11118','信息科学与工程学院','2','2021'),('老师8','11119','副教授','女',NULL,NULL,'博士',NULL,NULL,NULL,NULL,'11119','信息科学与工程学院','2','2021'),('老师9','11120','辅导员','男',NULL,NULL,'博士',NULL,NULL,NULL,NULL,'11120','信息科学与工程学院','2','2021'),('老师10','11121','辅导员','女',NULL,NULL,'博士',NULL,NULL,NULL,NULL,'11121','信息科学与工程学院','2','2021'),('老师11','11122','教授','男',NULL,NULL,'博士',NULL,NULL,NULL,NULL,'11122','信息科学与工程学院','2','2021'),('老师12','11123','教授','男',NULL,NULL,'博士',NULL,NULL,NULL,NULL,'11123','信息科学与工程学院','2','2021');
/*!40000 ALTER TABLE `t_user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_xuanke`
--

DROP TABLE IF EXISTS `t_xuanke`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_xuanke` (
	`s_name` varchar(100) DEFAULT NULL COMMENT '学生姓名',
	`s_num` varchar(100) DEFAULT NULL COMMENT '学号',
	`c_name` varchar(100) DEFAULT NULL COMMENT '课程姓名',
	`c_num` varchar(100) DEFAULT NULL COMMENT '课程编号',
	`c_ins` varchar(100) DEFAULT NULL COMMENT '开课学院',
	`c_gra` varchar(100) DEFAULT NULL COMMENT '学分',
	`c_time` varchar(100) DEFAULT NULL COMMENT '学时',
	`week` varchar(100) DEFAULT NULL COMMENT '星期',
	`cla` varchar(100) DEFAULT NULL COMMENT '节'
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='选课';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_xuanke`
--

LOCK TABLES `t_xuanke` WRITE;
/*!40000 ALTER TABLE `t_xuanke` DISABLE KEYS */;
INSERT INTO `t_xuanke` VALUES ('孙永杰','201712200230','化学与人类','xx0001','化学化工与材料科学学院','1','24','六','2'),('孙永杰','201712200230','数学大观','xx0002','信息科学与工程学院','1','24','六','2'),('白顺义','201712200201','化学与人类','xx0001','化学化工与材料科学学院','1','24','六','2');
/*!40000 ALTER TABLE `t_xuanke` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-06-08 11:12:30
