/*
Navicat MySQL Data Transfer

Source Server         : test
Source Server Version : 50627
Source Host           : localhost:3306
Source Database       : quality

Target Server Type    : MYSQL
Target Server Version : 50627
File Encoding         : 65001

Date: 2019-05-20 09:20:43
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for t_application
-- ----------------------------
DROP TABLE IF EXISTS `t_application`;
CREATE TABLE `t_application` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `field_id` int(11) NOT NULL,
  `application` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_application
-- ----------------------------
INSERT INTO `t_application` VALUES ('1', '1', '大数据平台');
INSERT INTO `t_application` VALUES ('2', '1', '运营分析');
INSERT INTO `t_application` VALUES ('3', '1', '数据集市');
INSERT INTO `t_application` VALUES ('4', '3', '信用卡外围');
INSERT INTO `t_application` VALUES ('5', '4', '理赔数据分析');

-- ----------------------------
-- Table structure for t_field
-- ----------------------------
DROP TABLE IF EXISTS `t_field`;
CREATE TABLE `t_field` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `industry_id` int(11) NOT NULL,
  `field` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_field
-- ----------------------------
INSERT INTO `t_field` VALUES ('1', '1', '数据应用');
INSERT INTO `t_field` VALUES ('2', '1', '风险管理');
INSERT INTO `t_field` VALUES ('3', '1', '信用卡');
INSERT INTO `t_field` VALUES ('4', '2', '财险');

-- ----------------------------
-- Table structure for t_industry
-- ----------------------------
DROP TABLE IF EXISTS `t_industry`;
CREATE TABLE `t_industry` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `industry` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_industry
-- ----------------------------
INSERT INTO `t_industry` VALUES ('1', '银行');
INSERT INTO `t_industry` VALUES ('2', '保险');
INSERT INTO `t_industry` VALUES ('3', '云');

-- ----------------------------
-- Table structure for t_menu
-- ----------------------------
DROP TABLE IF EXISTS `t_menu`;
CREATE TABLE `t_menu` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `text` varchar(50) NOT NULL,
  `state` varchar(10) NOT NULL,
  `pid` int(11) NOT NULL,
  `iconCls` varchar(50) DEFAULT NULL,
  `url` varchar(50) DEFAULT NULL,
  `icon_cls` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_menu
-- ----------------------------
INSERT INTO `t_menu` VALUES ('6', '业务管理', 'closed', '0', 'icon-system', null, null);
INSERT INTO `t_menu` VALUES ('7', '项目摘要信息导入', 'open', '6', 'icon-user', 'projDigest/multiUpload', null);
INSERT INTO `t_menu` VALUES ('9', '项目摘要成果管理', 'open', '6', 'icon-user', 'projDigest/projDigestQuery', null);

-- ----------------------------
-- Table structure for t_projdigest
-- ----------------------------
DROP TABLE IF EXISTS `t_projdigest`;
CREATE TABLE `t_projdigest` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `proj_outcome_id` varchar(255) DEFAULT NULL,
  `lob` varchar(50) DEFAULT NULL,
  `proj_name` varchar(255) DEFAULT NULL,
  `proj_num` varchar(100) DEFAULT NULL,
  `cust_name` varchar(255) DEFAULT NULL,
  `proj_brief` varchar(1000) DEFAULT NULL,
  `proj_begin_date` varchar(50) DEFAULT NULL,
  `proj_end_date` varchar(50) DEFAULT NULL,
  `archive_path` varchar(255) DEFAULT NULL,
  `proj_manager_name` varchar(50) DEFAULT NULL,
  `proj_manage_id` varchar(50) DEFAULT NULL,
  `proj_manage_email` varchar(50) NOT NULL,
  `proj_manage_tel` varchar(255) DEFAULT NULL,
  `industry_category` varchar(255) DEFAULT NULL,
  `field_category` varchar(255) DEFAULT NULL,
  `application_category` varchar(255) DEFAULT NULL,
  `used_language` varchar(50) DEFAULT NULL,
  `system_soft` varchar(255) DEFAULT NULL,
  `system_hard` varchar(255) DEFAULT NULL,
  `used_database` varchar(50) DEFAULT NULL,
  `test_framework` varchar(50) DEFAULT NULL,
  `key_tech_skills` varchar(255) DEFAULT NULL,
  `is_import` char(1) DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=301 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_projdigest
-- ----------------------------
INSERT INTO `t_projdigest` VALUES ('298', 'PROJ_20170706_P164C407D_01', '银行第二业务线', '友利银行微信支付改造项目', 'P164C407D', '友利银行', 'null null null null null null 项目关闭 微信支付改造 系统包括进件、对账、清分 null null null null null null', '2016-02-19', '2016-09-30', null, '边朝会/bianchaohui', 'E100071094', 'bianchaohui@chinasofti.com', '15963553227', null, null, null, null, 'linux redhat6.6,oracle11g,wehphere', null, null, null, '微信支付 null null java/oracle/linux', '1');
INSERT INTO `t_projdigest` VALUES ('299', 'PROJ_20170731_P154C400E_01', '商业银行业务线', '大华银行自贸区FTZ账户改造', 'P154C400E', '大华银行（中国）有限公司', 'null null null null null null 项目关闭 处理自贸区主子账户 支持相同账号不同币种导入、修改大小额来往帐以及其他相关外接系统自贸区交易支持主子账户处理 null null null null null null', '2015-07-15', '2016-06-30', null, '沈超', 'E000417200', 'shen_chao@huateng.com', '13917175762', null, null, null, null, 'AIX5.1、Oracle11g、eclipse、extra372', null, null, null, '自贸区交易、主子账户 null null linux C、shell、java、oracle', '1');
INSERT INTO `t_projdigest` VALUES ('300', 'PROJ_20170731_P164C402B_01', '商业银行业务线', '大华银行TPB CR分行关闭', 'P164C402B', '大华银行（中国）有限公司', 'null null null null null null 项目关闭 删除已存在分行 删除已存在分行，并将该分行下的账户移至另一个分行，并保证该分行下账户的交易以及报表正常 null null null null null null', '2016-03-10', '2016-07-30', null, '沈超', 'E000417200', 'shen_chao@huateng.com', '13917175762', null, null, null, null, 'AIX5.1、Oracle11g、eclipse、extra372', null, null, null, '分行删除 null null linux C、shell、java、oracle', '1');
INSERT INTO `t_projdigest` VALUES ('297', 'PROJ_20170703_P174C4030_01', '商业银行业务线', '瑞穗银行EPS系统日本财产保险推广案件', 'P174C4030', '瑞穗银行（中国）有限公司', 'null null null 王明礼 王成亮 null 项目验收 向日本保险推广瑞穗银行EPS银企直连系统转账指令、转账结果查询、交易明细查询 和 账户余额查询功能。 EPS银企直连系统转账指令功能，转账结果查询功能，交易明细查询功能，账户余额查询功能。 null null null null null null', '2017-01-16', '2017-10-22', null, '陈方/chenfang', 'E100015030', 'chen_ada@huateng.com', '18217487896', null, null, null, null, 'Windows2008，AIX,7.1，TCP/IP，LINUX3.10, TOMCAT6.0, LAN，ORACLE11g，', null, null, null, 'EPS银企直连系统 转账指令、转账结果查询 交易明细查询 和 账户余额查询 Java/oracle/linux/SQL', '1');
INSERT INTO `t_projdigest` VALUES ('296', 'PROJ_20170120_P174C4006_01', '商业银行业务线', '瑞穗银行中文化TIPS系统无锡分行推广案件', 'P174C4006', '瑞穗银行（中国）有限公司', 'null null null 邹龙华 许俊领 null 项目关闭 随着电子缴税的业务不断发展，应无锡分行业务要求，现把TIPS业务推广到无锡分行。 G-HATS的General Operation记帐接口功能，TIPS银行端业务功能，TIPS实时来账、批量来账、对账及核对、以及资金汇划业务功能 null null null null null null', '2016-12-19', '2017-06-20', null, '陈方/chenfang', 'E100015030', 'chen_ada@huateng.com', '18217487896', null, null, null, null, 'AIX5.3，TCP/IP，UNIX, TUXEDO8.1, LAN，ORACLE9i，', null, null, null, '电子缴税的业务 TIPS银行端业务 TIPS实时来账、对账及核对业务 C语言/oracle/linux/SQL', '1');
INSERT INTO `t_projdigest` VALUES ('294', 'PROJ_20161028_P164C4050_01', '商业银行业务线', '金华银行超级网银升级项目', 'P164C4050', '金华银行股份有限公司', 'null null null 陈新 null null 项目验收 用户可以通过柜面端系统和网银端系统进行交互；柜面端系统主要负责自由格式、业务状态查询等业务；网银端系统主要负责网银借贷记、第三方贷记、协议类等业务。 报文检查、报文落地处理、记账处理、报文回执和对账处理功能 null null null null null null', '2016-08-01', '2017-12-22', null, '曾成科/zengchengke', 'E100026832', 'zeng_chengke@huateng.com', '18221335030', null, null, null, null, 'Windows2008，AIX,7.1，TCP/IP，LINUX3.10, TOMCAT6.0, LAN，ORACLE11g，', null, null, null, '柜面端系统和网银端系统进行交互 报文处理 记账、对账处理 C/oracle/linux/SQL', '1');
INSERT INTO `t_projdigest` VALUES ('295', 'PROJ_20161230_P164C40B2_01', '商业银行业务线', '金华银行二代支付系统改造项目', 'P164C40B2', '金华银行股份有限公司', 'null null null 陈新 null null 项目验收 金华柜面增加次日到账报文类型，村镇柜面增加次日到账报文类型，网银增加次日到账报文类型，修改冲账交易，针对次日到账人行拒绝业务增加反向记账处理；包括：大额冲账、村镇大额冲账、小额冲账、村镇小额冲账、村镇柜面大额冲账、村镇柜面小额冲账6个交易。 次日到账功能点改善，针对次日到账人行拒绝业务增加反向记账处理，修改冲账对账流程，次日到账对账增加隔日对账。 null null null null null null', '2016-11-14', '2018-05-25', null, '曾成科/zengchengke', 'E100026832', 'zeng_chengke@huateng.com', '18221335030', null, null, null, null, 'Windows2008，AIX,7.1，TCP/IP，LINUX3.10, TOMCAT6.0, LAN，ORACLE11g，', null, null, null, '次日到账功能 网银业务大小额转账 null C/oracle/linux/SQL', '1');
INSERT INTO `t_projdigest` VALUES ('293', 'PROJ_20161028_P164C404B_01', '商业银行业务线', '瑞穗银行中文化系统TIPS武汉&大连分行推广案件', 'P164C404B', '瑞穗银行（中国）有限公司', 'null null null 邹龙华 蔡留宏 null 项目验收 随着电子缴税的业务不断发展，应分行业务要求，现把TIPS业务推广到武汉和大连分行。 G-HATS的General Operation记帐接口功能，TIPS银行端业务功能，TIPS实时来账、批量来账、对账及核对、以及资金汇划业务功能 null null null null null null', '2016-06-23', '2017-02-22', null, '陈方/chenfang', 'E100015030', 'chen_ada@huateng.com', '18217487896', null, null, null, null, 'AIX5.3，TCP/IP，UNIX, TUXEDO8.1, LAN，ORACLE9i，', null, null, null, '电子缴税的业务 TIPS银行端业务 TIPS实时来账、对账及核对业务 C语言/oracle/linux/SQL', '1');
INSERT INTO `t_projdigest` VALUES ('292', 'PROJ_20160527_P154C402C_01', '商业银行业务线', '瑞穗银行中文化系统上海综合业务系统升级三期案件', 'P154C402C', '瑞穗银行（中国）有限公司', 'null null null 陈方 邹龙华 刘泽彬 项目关闭 为支持上海自贸区建设，人行上海分行决定在上海支付结算综合业务系统增加自贸区业务功能。应瑞穗银行要求在中文化系统追加开发行内接口开发，为自由贸易账户跨行、跨境人民币资金收付搭建资金清算渠道。 新增上海同城系统自贸区业务；上海同城系统跨境贷记业务；上海同城自贸区信息类报文业务；上海同城自贸区资金池业务；上海同城系统单位/个人资金归集业务；上海同城系统特准参与者业务等。 null null null null null null', '2015-11-11', '2016-11-08', null, '喻林/yulin(已于2017/3/27离职)', 'E100004452', 'yu_lin@huateng.com/shi_yongqing@huateng.com', '15221694041', null, null, null, null, 'AIX5.1，TCP/IP，UNIX, TUXEDO8.0, LAN，ORACLE9i，SMP3.1.3', null, null, null, '上海支付结算综合业务系统（上海同城） 上海同城系统自贸区业务 跨境人民币贷记业务 C语言/oracle/linux/SQL', '1');
INSERT INTO `t_projdigest` VALUES ('289', 'PROJ_20160119_P154A300A_02', '银行第三业务线', '深圳前海微众银行反欺诈项目', 'P154A300A', '前海银行股份有限公司', 'null null null 封超 李同兵 王华栋 项目验收 通过侦测系统对风险交易进行评估，制定风险交易判断策略 数据采集、报文解析、实时变量计算、规则执行、生成告警、交易入库、统计量配置、警报处理、规则建模、规则编辑、规则发布、 null null null null null null', '2015-06-15', '2015-06-01', null, '冒勇军', 'E100057490', 'maoyongjun@chinasofti.com', '18673999609', null, null, null, null, 'tlinux1.2', null, null, null, '反欺诈、统计变量、黑白名单、警报处理、规则、 null null flowpower框架/JAVA多线程', '1');
INSERT INTO `t_projdigest` VALUES ('290', 'PROJ_20160226_P164C4005_01', '商业银行业务线', '瑞穗银行EPS系统普利司通推广案件', 'P164C4005', '瑞穗银行（中国）有限公司', 'null null null 雷彩艳 null null 项目关闭 应普利司通公司要求，将推广瑞穗银行EPS银企直连系统交易明细查询功能给客户 交易明细查询指令处理功能，针对普利司通公司增加对手名称 null null null null null null', '2015-11-16', '2016-07-22', null, '侍永青/shiyongqing', 'E000417219', 'shi_yongqing@huateng.com', '13761184486', null, null, null, null, 'oracle9i, AIX5.1, UNIX, TCP/IP, TUXEDO8.0', null, null, null, 'EPS银企直连系统，交易明细查询 null null SQL server/oracle/unix', '1');
INSERT INTO `t_projdigest` VALUES ('291', 'PROJ_20160325_P164C400B_01', '商业银行业务线', '瑞穗银行中文化EPS系统日立INTERNET推广案件', 'P164C400B', '瑞穗银行（中国）有限公司', 'null null null 王明礼 null null 项目关闭 开通INTERNET接入，客户将INTERNET渠道作为备用线路；中文化开通EPS系统INTERNET接入功能，且同时开放专线、INTERNET接口，由客户选择接入方式 提供转账（付款）指令处理功能、转账（付款）结果查询指令处理功能、H社交易明细查询指令处理功能、H社账号余额查询指令处理功能。 null null null null null null', '2016-01-25', '2016-07-13', null, '侍永青/shiyongqing', 'E000417219', 'shi_yongqing@huateng.com', '13761184486', null, null, null, null, 'oracle9i, AIX5.1, UNIX, TCP/IP, TUXEDO8.0', null, null, null, '开通INTERNET接入 null null SQL server/oracle/unix', '1');
INSERT INTO `t_projdigest` VALUES ('287', 'PROJ_20151225_P154A300E_01', '银行第三业务线', '人行清算头寸预警项目', 'P154A300E', '大新银行（中国）有限公司', '大新银行二代支付系统(501141) null null null null null 项目验收 解决大新银行业务人员在头寸不足之下导致交易排队的情况 主要提供预警、提示的功能 null null null null null null', '2015-08-18', '2106-01-30', null, '谈家平', 'E100002212', 'tan_jiaping@huateng.com', '18501762482', null, null, null, null, 'Suse_Linux_11_X86_64,oracle11g,MQ7.1', null, null, null, '人民币清算支付 null null Linux系统，C语言、java语言，oracle数据库、', '1');
INSERT INTO `t_projdigest` VALUES ('288', 'PROJ_20151231_P156A6013_02', '银行第三业务线', '永亨电票二期', 'P156A6013', '永亨银行', 'null null null null null null 项目执行与监控 改造系统密码安全设置，总账文件增加客户号，行名行号变更 改造系统密码安全设置，总账文件增加客户号，行名行号变更 null null null null null null', '2015-08-24', '2015-12-31', null, '黎炳亮', 'E100003350', 'li_bingliang@huateng.com', '18688236272', null, null, null, null, 'linux，Microsoft SQL2010，tomcat', null, null, null, '票据 null null linux，java，sql', '1');
INSERT INTO `t_projdigest` VALUES ('285', 'PROJ_20140616_P14444060_01', '银行第二业务线', 'BTMUC AML自贸区合规报送', 'P14444060', '三菱东京日联银行', 'null null null null null null 项目关闭 AML系统改造 增加对于自贸区相关业务的反洗钱改造 null null null null null null', '2014-04-01', '2014-07-14', null, '耿经球', 'E000416075', 'geng_jingqiu@huateng.com', '18621182961', null, null, null, null, 'Delphi ; Sqlserver', null, null, null, '反洗钱 null null Delphi ; Sqlserver', '1');
INSERT INTO `t_projdigest` VALUES ('286', 'PROJ_20151221_P154A3002_01', '银行第三业务线', '深圳农村商业银行TSM项目', 'P154A3002', '深圳农村商业银行', 'null null null null null null 项目验收 一卡多应用，在现有的IC卡上能够加载第三方的行业应用如：公交应用、校园应用、公共自行车应用、医院就诊应用、小区物业应用等。\n在动态加载应用的情况下，提供银行柜面、ATM、自主终端等多种渠道，方便持卡人对应用进行查询，下载等操作，在方面业务拓展的同时提高用户体验。 柜面系统受理本行卡应用下载查询、卡片剩余空间查询、应用下载、卡片应用查询、应用删除等功能。 null null null null null null', '2015-04-10', '2015-07-31', null, '马庆彬', 'E100001502', 'ma_qingbin@huateng.com', '15813747227', null, null, null, null, 'ret hat linux 5.6 64-bit； WebSphere 7.0.0.19；ORACLE 11g Client', null, null, null, 'TSM/多应用 null null linux c；oracle；js', '1');
INSERT INTO `t_projdigest` VALUES ('284', 'adsfaf', 'fdasf', 'fadsf', 'fdsaf', 'fdsaf', 'fdsa', '2019-05-17', '2019-05-17', 'fdsafsa', 'fasdf', null, 'fadsfa@qq.com', 'fdsaf', '1', '1', '1', 'fdas', 'fdasf', 'fdas', 'fdsa', 'fasd', 'fdsa', '');

-- ----------------------------
-- Table structure for t_projdigest_old
-- ----------------------------
DROP TABLE IF EXISTS `t_projdigest_old`;
CREATE TABLE `t_projdigest_old` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `proj_outcome_id` varchar(255) DEFAULT NULL,
  `lob` varchar(255) DEFAULT NULL,
  `proj_name` varchar(255) DEFAULT NULL,
  `proj_num` varchar(255) DEFAULT NULL,
  `cust_name` varchar(255) DEFAULT NULL,
  `relate_proj_name1` varchar(255) DEFAULT NULL,
  `relate_proj_name2` varchar(255) DEFAULT NULL,
  `relate_proj_name3` varchar(255) DEFAULT NULL,
  `subcontract_state` varchar(255) DEFAULT NULL,
  `proj_manager_name` varchar(255) DEFAULT NULL,
  `proj_manage_id` varchar(255) DEFAULT NULL,
  `proj_manage_email` varchar(255) DEFAULT NULL,
  `proj_manage_tel` varchar(255) DEFAULT NULL,
  `proj_manager_director_name` varchar(255) DEFAULT NULL,
  `proj_backbone1` varchar(255) DEFAULT NULL,
  `proj_backbone2` varchar(255) DEFAULT NULL,
  `proj_backbone3` varchar(255) DEFAULT NULL,
  `proj_begin_date` varchar(255) DEFAULT NULL,
  `proj_end_date` varchar(255) DEFAULT NULL,
  `input_date` varchar(255) DEFAULT NULL,
  `proj_state` varchar(255) DEFAULT NULL,
  `business_tech_key1` varchar(255) DEFAULT NULL,
  `business_tech_key2` varchar(255) DEFAULT NULL,
  `business_tech_key3` varchar(255) DEFAULT NULL,
  `business_brief` varchar(255) DEFAULT NULL,
  `business_func` varchar(255) DEFAULT NULL,
  `performance_index` varchar(255) DEFAULT NULL,
  `system_soft` varchar(255) DEFAULT NULL,
  `system_hard` varchar(255) DEFAULT NULL,
  `system_architec` varchar(255) DEFAULT NULL,
  `relavent_standard` varchar(255) DEFAULT NULL,
  `key_tech_skills` varchar(255) DEFAULT NULL,
  `usetools` varchar(255) DEFAULT NULL,
  `remaining_prob` varchar(255) DEFAULT NULL,
  `market_competi` varchar(255) DEFAULT NULL,
  `constraint_depend` varchar(255) DEFAULT NULL,
  `proj_back_bone3` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=448 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_projdigest_old
-- ----------------------------
INSERT INTO `t_projdigest_old` VALUES ('432', 'PROJ_20140616_P14444060_01', '银行第二业务线', 'BTMUC AML自贸区合规报送', 'P14444060', '三菱东京日联银行', null, null, null, null, '耿经球', 'E000416075', 'geng_jingqiu@huateng.com', '18621182961', '黄俊', null, null, null, '2014-04-01', '2014-07-14', '2016-06-24', '项目关闭', '反洗钱', null, null, 'AML系统改造', '增加对于自贸区相关业务的反洗钱改造', null, 'Delphi ; Sqlserver', null, null, null, 'Delphi ; Sqlserver', null, null, null, null, null);
INSERT INTO `t_projdigest_old` VALUES ('433', 'PROJ_20151221_P154A3002_01', '银行第三业务线', '深圳农村商业银行TSM项目', 'P154A3002', '深圳农村商业银行', null, null, null, null, '马庆彬', 'E100001502', 'ma_qingbin@huateng.com', '15813747227', '韩永海', null, null, null, '2015-04-10', '2015-07-31', '2015-12-21', '项目验收', 'TSM/多应用', null, null, '一卡多应用，在现有的IC卡上能够加载第三方的行业应用如：公交应用、校园应用、公共自行车应用、医院就诊应用、小区物业应用等。\n在动态加载应用的情况下，提供银行柜面、ATM、自主终端等多种渠道，方便持卡人对应用进行查询，下载等操作，在方面业务拓展的同时提高用户体验。', '柜面系统受理本行卡应用下载查询、卡片剩余空间查询、应用下载、卡片应用查询、应用删除等功能。', null, 'ret hat linux 5.6 64-bit； WebSphere 7.0.0.19；ORACLE 11g Client', null, null, null, 'linux c；oracle；js', null, null, null, null, null);
INSERT INTO `t_projdigest_old` VALUES ('434', 'PROJ_20151225_P154A300E_01', '银行第三业务线', '人行清算头寸预警项目', 'P154A300E', '大新银行（中国）有限公司', '大新银行二代支付系统(501141)', null, null, null, '谈家平', 'E100002212', 'tan_jiaping@huateng.com', '18501762482', '韩永海', null, null, null, '2015-08-18', '2106-01-30', '2105-12-29', '项目验收', '人民币清算支付', null, null, '解决大新银行业务人员在头寸不足之下导致交易排队的情况', '主要提供预警、提示的功能', null, 'Suse_Linux_11_X86_64,oracle11g,MQ7.1', null, null, null, 'Linux系统，C语言、java语言，oracle数据库、', null, null, null, null, null);
INSERT INTO `t_projdigest_old` VALUES ('435', 'PROJ_20151231_P156A6013_02', '银行第三业务线', '永亨电票二期', 'P156A6013', '永亨银行', null, null, null, null, '黎炳亮', 'E100003350', 'li_bingliang@huateng.com', '18688236272', '黄有智', null, null, null, '2015-08-24', '2015-12-31', '2015-12-18', '项目执行与监控', '票据', null, null, '改造系统密码安全设置，总账文件增加客户号，行名行号变更', '改造系统密码安全设置，总账文件增加客户号，行名行号变更', null, 'linux，Microsoft SQL2010，tomcat', null, null, null, 'linux，java，sql', null, null, null, null, null);
INSERT INTO `t_projdigest_old` VALUES ('436', 'PROJ_20160119_P154A300A_02', '银行第三业务线', '深圳前海微众银行反欺诈项目', 'P154A300A', '前海银行股份有限公司', null, null, null, null, '冒勇军', 'E100057490', 'maoyongjun@chinasofti.com', '18673999609', '覃鹰', '封超', '李同兵', '王华栋', '2015-06-15', '2015-06-01', '2016-01-21', '项目验收', '反欺诈、统计变量、黑白名单、警报处理、规则、', null, null, '通过侦测系统对风险交易进行评估，制定风险交易判断策略', '数据采集、报文解析、实时变量计算、规则执行、生成告警、交易入库、统计量配置、警报处理、规则建模、规则编辑、规则发布、', null, 'tlinux1.2', null, null, null, 'flowpower框架/JAVA多线程', null, null, null, null, null);
INSERT INTO `t_projdigest_old` VALUES ('437', 'PROJ_20160226_P164C4005_01', '商业银行业务线', '瑞穗银行EPS系统普利司通推广案件', 'P164C4005', '瑞穗银行（中国）有限公司', null, null, null, null, '侍永青/shiyongqing', 'E000417219', 'shi_yongqing@huateng.com', '13761184486', '代邵连', '雷彩艳', null, null, '2015-11-16', '2016-07-22', '2017-07-31', '项目关闭', 'EPS银企直连系统，交易明细查询', null, null, '应普利司通公司要求，将推广瑞穗银行EPS银企直连系统交易明细查询功能给客户', '交易明细查询指令处理功能，针对普利司通公司增加对手名称', null, 'oracle9i, AIX5.1, UNIX, TCP/IP, TUXEDO8.0', null, null, null, 'SQL server/oracle/unix', null, null, null, null, null);
INSERT INTO `t_projdigest_old` VALUES ('438', 'PROJ_20160325_P164C400B_01', '商业银行业务线', '瑞穗银行中文化EPS系统日立INTERNET推广案件', 'P164C400B', '瑞穗银行（中国）有限公司', null, null, null, null, '侍永青/shiyongqing', 'E000417219', 'shi_yongqing@huateng.com', '13761184486', '代邵连', '王明礼', null, null, '2016-01-25', '2016-07-13', '2017-07-31', '项目关闭', '开通INTERNET接入', null, null, '开通INTERNET接入，客户将INTERNET渠道作为备用线路；中文化开通EPS系统INTERNET接入功能，且同时开放专线、INTERNET接口，由客户选择接入方式', '提供转账（付款）指令处理功能、转账（付款）结果查询指令处理功能、H社交易明细查询指令处理功能、H社账号余额查询指令处理功能。', null, 'oracle9i, AIX5.1, UNIX, TCP/IP, TUXEDO8.0', null, null, null, 'SQL server/oracle/unix', null, null, null, null, null);
INSERT INTO `t_projdigest_old` VALUES ('439', 'PROJ_20160527_P154C402C_01', '商业银行业务线', '瑞穗银行中文化系统上海综合业务系统升级三期案件', 'P154C402C', '瑞穗银行（中国）有限公司', null, null, null, null, '喻林/yulin(已于2017/3/27离职)', 'E100004452', 'yu_lin@huateng.com/shi_yongqing@huateng.com', '15221694041', '侍永青/shiyongqing', '陈方', '邹龙华', '刘泽彬', '2015-11-11', '2016-11-08', '2017-07-28', '项目关闭', '上海支付结算综合业务系统（上海同城）', '上海同城系统自贸区业务', '跨境人民币贷记业务', '为支持上海自贸区建设，人行上海分行决定在上海支付结算综合业务系统增加自贸区业务功能。应瑞穗银行要求在中文化系统追加开发行内接口开发，为自由贸易账户跨行、跨境人民币资金收付搭建资金清算渠道。', '新增上海同城系统自贸区业务；上海同城系统跨境贷记业务；上海同城自贸区信息类报文业务；上海同城自贸区资金池业务；上海同城系统单位/个人资金归集业务；上海同城系统特准参与者业务等。', null, 'AIX5.1，TCP/IP，UNIX, TUXEDO8.0, LAN，ORACLE9i，SMP3.1.3', null, null, null, 'C语言/oracle/linux/SQL', null, null, null, null, null);
INSERT INTO `t_projdigest_old` VALUES ('440', 'PROJ_20161028_P164C404B_01', '商业银行业务线', '瑞穗银行中文化系统TIPS武汉&大连分行推广案件', 'P164C404B', '瑞穗银行（中国）有限公司', null, null, null, null, '陈方/chenfang', 'E100015030', 'chen_ada@huateng.com', '18217487896', '侍永青/shiyongqing', '邹龙华', '蔡留宏', null, '2016-06-23', '2017-02-22', '2017-07-28', '项目验收', '电子缴税的业务', 'TIPS银行端业务', 'TIPS实时来账、对账及核对业务', '随着电子缴税的业务不断发展，应分行业务要求，现把TIPS业务推广到武汉和大连分行。', 'G-HATS的General Operation记帐接口功能，TIPS银行端业务功能，TIPS实时来账、批量来账、对账及核对、以及资金汇划业务功能', null, 'AIX5.3，TCP/IP，UNIX, TUXEDO8.1, LAN，ORACLE9i，', null, null, null, 'C语言/oracle/linux/SQL', null, null, null, null, null);
INSERT INTO `t_projdigest_old` VALUES ('441', 'PROJ_20161028_P164C4050_01', '商业银行业务线', '金华银行超级网银升级项目', 'P164C4050', '金华银行股份有限公司', null, null, null, null, '曾成科/zengchengke', 'E100026832', 'zeng_chengke@huateng.com', '18221335030', '侍永青/shiyongqing', '陈新', null, null, '2016-08-01', '2017-12-22', '2017-09-05', '项目验收', '柜面端系统和网银端系统进行交互', '报文处理', '记账、对账处理', '用户可以通过柜面端系统和网银端系统进行交互；柜面端系统主要负责自由格式、业务状态查询等业务；网银端系统主要负责网银借贷记、第三方贷记、协议类等业务。', '报文检查、报文落地处理、记账处理、报文回执和对账处理功能', null, 'Windows2008，AIX,7.1，TCP/IP，LINUX3.10, TOMCAT6.0, LAN，ORACLE11g，', null, null, null, 'C/oracle/linux/SQL', null, null, null, null, null);
INSERT INTO `t_projdigest_old` VALUES ('442', 'PROJ_20161230_P164C40B2_01', '商业银行业务线', '金华银行二代支付系统改造项目', 'P164C40B2', '金华银行股份有限公司', null, null, null, null, '曾成科/zengchengke', 'E100026832', 'zeng_chengke@huateng.com', '18221335030', '侍永青/shiyongqing', '陈新', null, null, '2016-11-14', '2018-05-25', '2017-11-08', '项目验收', '次日到账功能', '网银业务大小额转账', null, '金华柜面增加次日到账报文类型，村镇柜面增加次日到账报文类型，网银增加次日到账报文类型，修改冲账交易，针对次日到账人行拒绝业务增加反向记账处理；包括：大额冲账、村镇大额冲账、小额冲账、村镇小额冲账、村镇柜面大额冲账、村镇柜面小额冲账6个交易。', '次日到账功能点改善，针对次日到账人行拒绝业务增加反向记账处理，修改冲账对账流程，次日到账对账增加隔日对账。', null, 'Windows2008，AIX,7.1，TCP/IP，LINUX3.10, TOMCAT6.0, LAN，ORACLE11g，', null, null, null, 'C/oracle/linux/SQL', null, null, null, null, null);
INSERT INTO `t_projdigest_old` VALUES ('443', 'PROJ_20170120_P174C4006_01', '商业银行业务线', '瑞穗银行中文化TIPS系统无锡分行推广案件', 'P174C4006', '瑞穗银行（中国）有限公司', null, null, null, null, '陈方/chenfang', 'E100015030', 'chen_ada@huateng.com', '18217487896', '侍永青/shiyongqing', '邹龙华', '许俊领', null, '2016-12-19', '2017-06-20', '2017-07-28', '项目关闭', '电子缴税的业务', 'TIPS银行端业务', 'TIPS实时来账、对账及核对业务', '随着电子缴税的业务不断发展，应无锡分行业务要求，现把TIPS业务推广到无锡分行。', 'G-HATS的General Operation记帐接口功能，TIPS银行端业务功能，TIPS实时来账、批量来账、对账及核对、以及资金汇划业务功能', null, 'AIX5.3，TCP/IP，UNIX, TUXEDO8.1, LAN，ORACLE9i，', null, null, null, 'C语言/oracle/linux/SQL', null, null, null, null, null);
INSERT INTO `t_projdigest_old` VALUES ('444', 'PROJ_20170703_P174C4030_01', '商业银行业务线', '瑞穗银行EPS系统日本财产保险推广案件', 'P174C4030', '瑞穗银行（中国）有限公司', null, null, null, null, '陈方/chenfang', 'E100015030', 'chen_ada@huateng.com', '18217487896', '侍永青/shiyongqing', '王明礼', '王成亮', null, '2017-01-16', '2017-10-22', '2017-09-05', '项目验收', 'EPS银企直连系统', '转账指令、转账结果查询', '交易明细查询 和 账户余额查询', '向日本保险推广瑞穗银行EPS银企直连系统转账指令、转账结果查询、交易明细查询 和 账户余额查询功能。', 'EPS银企直连系统转账指令功能，转账结果查询功能，交易明细查询功能，账户余额查询功能。', null, 'Windows2008，AIX,7.1，TCP/IP，LINUX3.10, TOMCAT6.0, LAN，ORACLE11g，', null, null, null, 'Java/oracle/linux/SQL', null, null, null, null, null);
INSERT INTO `t_projdigest_old` VALUES ('445', 'PROJ_20170706_P164C407D_01', '银行第二业务线', '友利银行微信支付改造项目', 'P164C407D', '友利银行', null, null, null, null, '边朝会/bianchaohui', 'E100071094', 'bianchaohui@chinasofti.com', '15963553227', '吕广鹏', null, null, null, '2016-02-19', '2016-09-30', '2016-12-01', '项目关闭', '微信支付', null, null, '微信支付改造', '系统包括进件、对账、清分', null, 'linux redhat6.6,oracle11g,wehphere', null, null, null, 'java/oracle/linux', null, null, null, null, null);
INSERT INTO `t_projdigest_old` VALUES ('446', 'PROJ_20170731_P154C400E_01', '商业银行业务线', '大华银行自贸区FTZ账户改造', 'P154C400E', '大华银行（中国）有限公司', null, null, null, null, '沈超', 'E000417200', 'shen_chao@huateng.com', '13917175762', '代绍连', null, null, null, '2015-07-15', '2016-06-30', '2017-07-31', '项目关闭', '自贸区交易、主子账户', null, null, '处理自贸区主子账户', '支持相同账号不同币种导入、修改大小额来往帐以及其他相关外接系统自贸区交易支持主子账户处理', null, 'AIX5.1、Oracle11g、eclipse、extra372', null, null, null, 'linux C、shell、java、oracle', null, null, null, null, null);
INSERT INTO `t_projdigest_old` VALUES ('447', 'PROJ_20170731_P164C402B_01', '商业银行业务线', '大华银行TPB CR分行关闭', 'P164C402B', '大华银行（中国）有限公司', null, null, null, null, '沈超', 'E000417200', 'shen_chao@huateng.com', '13917175762', '代绍连', null, null, null, '2016-03-10', '2016-07-30', '2017-07-31', '项目关闭', '分行删除', null, null, '删除已存在分行', '删除已存在分行，并将该分行下的账户移至另一个分行，并保证该分行下账户的交易以及报表正常', null, 'AIX5.1、Oracle11g、eclipse、extra372', null, null, null, 'linux C、shell、java、oracle', null, null, null, null, null);

