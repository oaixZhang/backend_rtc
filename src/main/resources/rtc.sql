/*
Navicat MySQL Data Transfer

Source Server         : local
Source Server Version : 50719
Source Host           : localhost:3306
Source Database       : rtc

Target Server Type    : MYSQL
Target Server Version : 50719
File Encoding         : 65001

Date: 2017-11-14 13:56:35
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for class
-- ----------------------------
DROP TABLE IF EXISTS `class`;
CREATE TABLE `class` (
  `classId` int(11) NOT NULL AUTO_INCREMENT,
  `teacherId` int(11) NOT NULL,
  `courseName` varchar(10) NOT NULL,
  `courseHours` int(11) DEFAULT NULL,
  `classSize` int(11) NOT NULL,
  PRIMARY KEY (`classId`),
  KEY `FK_TeacherClass` (`teacherId`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of class
-- ----------------------------
INSERT INTO `class` VALUES ('1', '1', 'math', '30', '50');

-- ----------------------------
-- Table structure for class_stu
-- ----------------------------
DROP TABLE IF EXISTS `class_stu`;
CREATE TABLE `class_stu` (
  `classId` int(11) NOT NULL,
  `stuId` int(11) NOT NULL,
  PRIMARY KEY (`classId`,`stuId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of class_stu
-- ----------------------------
INSERT INTO `class_stu` VALUES ('1', '1');

-- ----------------------------
-- Table structure for fillblank
-- ----------------------------
DROP TABLE IF EXISTS `fillblank`;
CREATE TABLE `fillblank` (
  `quesId` int(11) NOT NULL AUTO_INCREMENT,
  `content` varchar(300) NOT NULL,
  `answer` varchar(100) NOT NULL,
  `flag` tinyint(1) NOT NULL,
  `imagePath` varchar(200) DEFAULT NULL,
  `accuracy` double DEFAULT NULL,
  `solveNum` int(11) DEFAULT NULL,
  PRIMARY KEY (`quesId`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of fillblank
-- ----------------------------
INSERT INTO `fillblank` VALUES ('1', '填空小华在解一元二次方程x^{2}-x=0时，只得出一个根x=1，则被漏掉的一个根是_', '4', '0', null, null, null);

-- ----------------------------
-- Table structure for mcq
-- ----------------------------
DROP TABLE IF EXISTS `mcq`;
CREATE TABLE `mcq` (
  `quesId` int(11) NOT NULL AUTO_INCREMENT,
  `option1` varchar(100) DEFAULT NULL,
  `option2` varchar(100) DEFAULT NULL,
  `option3` varchar(100) DEFAULT NULL,
  `option4` varchar(100) DEFAULT NULL,
  `option5` varchar(100) DEFAULT NULL,
  `option6` varchar(100) DEFAULT NULL,
  `content` varchar(300) NOT NULL,
  `answer` varchar(6) NOT NULL,
  `imagePath` varchar(200) DEFAULT NULL,
  `accuracy` double DEFAULT NULL,
  `solveNum` int(11) DEFAULT NULL,
  PRIMARY KEY (`quesId`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of mcq
-- ----------------------------
INSERT INTO `mcq` VALUES ('1', 'o1', 'o2', 'o3', 'o4', 'o5', 'o6', '多选小华在解一元二次方程x^{2}-x=0时，只得出一个根x=1，则被漏掉的一个根是_', 'x=3', null, null, null);

-- ----------------------------
-- Table structure for ques_set
-- ----------------------------
DROP TABLE IF EXISTS `ques_set`;
CREATE TABLE `ques_set` (
  `quesSetId` int(11) NOT NULL,
  `quesNum` int(11) DEFAULT NULL,
  `teacherId` int(11) NOT NULL,
  `flag` tinyint(1) DEFAULT NULL,
  `mark` int(11) DEFAULT NULL,
  PRIMARY KEY (`quesSetId`,`teacherId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of ques_set
-- ----------------------------
INSERT INTO `ques_set` VALUES ('1', '3', '1', '0', '100');
INSERT INTO `ques_set` VALUES ('2', '1', '1', '0', '10');

-- ----------------------------
-- Table structure for saq
-- ----------------------------
DROP TABLE IF EXISTS `saq`;
CREATE TABLE `saq` (
  `quesId` int(11) NOT NULL AUTO_INCREMENT,
  `content` text NOT NULL,
  `answer` text NOT NULL,
  `flag` tinyint(1) NOT NULL,
  `imagePath` varchar(200) DEFAULT NULL,
  `speSym` varchar(100) DEFAULT NULL,
  `accuracy` double DEFAULT NULL,
  `solveNum` int(11) DEFAULT NULL,
  PRIMARY KEY (`quesId`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of saq
-- ----------------------------
INSERT INTO `saq` VALUES ('1', '简答小华在解一元二次方程x^{2}-x=0时，只得出一个根x=1，则被漏掉的一个根是_', 'x=2', '0', null, null, null, null);

-- ----------------------------
-- Table structure for selectques
-- ----------------------------
DROP TABLE IF EXISTS `selectques`;
CREATE TABLE `selectques` (
  `quesId` int(11) NOT NULL AUTO_INCREMENT,
  `content` varchar(300) NOT NULL,
  `answer` char(1) NOT NULL,
  `imagePath` varchar(200) DEFAULT NULL,
  `flagA` tinyint(1) NOT NULL,
  `optionA` varchar(100) DEFAULT NULL,
  `flagB` tinyint(1) NOT NULL,
  `optionB` varchar(100) DEFAULT NULL,
  `flagC` tinyint(1) NOT NULL,
  `optionC` varchar(100) DEFAULT NULL,
  `flagD` tinyint(1) NOT NULL,
  `optionD` varchar(100) DEFAULT NULL,
  `accuracy` double DEFAULT NULL,
  `solveNum` int(11) DEFAULT NULL,
  PRIMARY KEY (`quesId`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of selectques
-- ----------------------------
INSERT INTO `selectques` VALUES ('1', '单选小华在解一元二次方程x^{2}-x=0时，只得出一个根x=1，则被漏掉的一个根是_', 'A', null, '0', 'oA', '1', 'oB', '1', 'oC', '1', 'oD', null, null);

-- ----------------------------
-- Table structure for set_class
-- ----------------------------
DROP TABLE IF EXISTS `set_class`;
CREATE TABLE `set_class` (
  `classId` int(11) NOT NULL,
  `quesSetId` int(11) NOT NULL,
  `date` datetime NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of set_class
-- ----------------------------
INSERT INTO `set_class` VALUES ('1', '1', '2017-11-11 02:45:34');
INSERT INTO `set_class` VALUES ('1', '2', '2017-11-11 11:17:17');

-- ----------------------------
-- Table structure for set_ques
-- ----------------------------
DROP TABLE IF EXISTS `set_ques`;
CREATE TABLE `set_ques` (
  `quesSetId` int(11) NOT NULL,
  `quesId` int(11) NOT NULL,
  `quesType` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of set_ques
-- ----------------------------
INSERT INTO `set_ques` VALUES ('1', '1', '1');
INSERT INTO `set_ques` VALUES ('1', '1', '2');
INSERT INTO `set_ques` VALUES ('1', '1', '3');
INSERT INTO `set_ques` VALUES ('2', '1', '4');

-- ----------------------------
-- Table structure for stu_ques_record
-- ----------------------------
DROP TABLE IF EXISTS `stu_ques_record`;
CREATE TABLE `stu_ques_record` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `stuId` int(11) NOT NULL,
  `quesId` int(11) NOT NULL,
  `quesType` tinyint(1) NOT NULL,
  `errFlag` tinyint(1) DEFAULT NULL,
  `quesSetId` int(11) DEFAULT NULL,
  `stuAnswer` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `INDEX_QUES_SET_ID` (`quesSetId`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of stu_ques_record
-- ----------------------------
INSERT INTO `stu_ques_record` VALUES ('1', '1', '1', '1', '0', '1', '学生回答');

-- ----------------------------
-- Table structure for teacher
-- ----------------------------
DROP TABLE IF EXISTS `teacher`;
CREATE TABLE `teacher` (
  `teacherId` int(11) NOT NULL,
  `name` varchar(20) NOT NULL,
  `gender` tinyint(1) NOT NULL,
  `phoneNum` varchar(11) NOT NULL,
  `password` varchar(20) NOT NULL,
  `school` varchar(20) NOT NULL,
  PRIMARY KEY (`teacherId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of teacher
-- ----------------------------
INSERT INTO `teacher` VALUES ('1', 'Gavin', '1', '15680022990', '123123', 'uestc');

-- ----------------------------
-- Table structure for torf
-- ----------------------------
DROP TABLE IF EXISTS `torf`;
CREATE TABLE `torf` (
  `quesId` int(11) NOT NULL AUTO_INCREMENT,
  `content` varchar(300) NOT NULL,
  `answer` tinyint(1) NOT NULL,
  `flag` tinyint(1) NOT NULL,
  `imagePath` varchar(200) DEFAULT NULL,
  `accuracy` double DEFAULT NULL,
  `solveNum` int(11) DEFAULT NULL,
  PRIMARY KEY (`quesId`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of torf
-- ----------------------------
INSERT INTO `torf` VALUES ('1', '判断小华在解一元二次方程x^{2}-x=0时，只得出一个根x=1，则被漏掉的一个根是x=3', '0', '0', null, null, null);

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `stuId` int(11) NOT NULL AUTO_INCREMENT,
  `email` varchar(50) DEFAULT NULL,
  `password` varchar(20) NOT NULL,
  `userName` varchar(10) NOT NULL,
  `name` varchar(20) NOT NULL,
  `gender` tinyint(1) DEFAULT NULL,
  `school` varchar(20) DEFAULT NULL,
  `grade` varchar(5) NOT NULL,
  `phoneNum` varchar(11) DEFAULT NULL,
  `qqNum` varchar(11) DEFAULT NULL,
  `imagePath` varchar(200) DEFAULT NULL,
  `token` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`stuId`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', 'mailxiaoz@163.com', 'qwe123123', 'xiaozhang', 'zx', '1', 'uestc', '1', '18781999999', '3126929722', null, null);
INSERT INTO `user` VALUES ('5', null, 'qwe123', 'testuser', 'tom', '0', null, '2', null, null, null, null);
INSERT INTO `user` VALUES ('6', null, 'qwe123123', 'maccount', 'jerry', '1', null, 'u3', null, null, null, null);
