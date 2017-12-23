/*
Navicat MySQL Data Transfer

Source Server         : local
Source Server Version : 50719
Source Host           : localhost:3306
Source Database       : rtc

Target Server Type    : MYSQL
Target Server Version : 50719
File Encoding         : 65001

Date: 2017-12-09 15:44:05
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
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of class
-- ----------------------------
INSERT INTO `class` VALUES ('1', '1', 'math', '30', '50');
INSERT INTO `class` VALUES ('2', '2', 'English', '20', '40');

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
INSERT INTO `class_stu` VALUES ('1', '3');
INSERT INTO `class_stu` VALUES ('1', '4');
INSERT INTO `class_stu` VALUES ('2', '2');
INSERT INTO `class_stu` VALUES ('2', '3');

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
INSERT INTO `ques_set` VALUES ('3', '2', '1', '0', '100');

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
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of saq
-- ----------------------------
INSERT INTO `saq` VALUES ('1', '用枚举法写出下列集合。（1）大于10小于20的整数全体；（2）20的所有因数的全体；（3）小于100的12正倍数。', '（1）设A为大于10小于20的整数全体，则 A={11, 12, 13, 14, 15, 16, 17, 18, 19}；（2）设B为20的所有因数的全体，则B={1, 2, 4, 5, 10, 20}；（3）设C为小于100的12正倍数，则C={12, 24, 36, 48, 60, 72, 84, 96}。', '0', null, null, null, null);
INSERT INTO `saq` VALUES ('2', '用描述法写出下列集合。（1）从0到1000的整数；（2）奇数的全体；（3）7的倍数；（4）所有实数集上一元一次方程的解组成的集合；（5）能被100整除的整数集合；（6）直角坐标系中，单位元(不包括单位圆周)的点集。', '（1）A={x|(x Z)并且(0≤x≤1000)}；（2）O={x|(k Z)并且(x=2k+1)}；（3）B={x|(k Z)并且(x=7k)}；（4）D={x|(x R)并且(a R)并且(a≠0)并且(b R)并且(ax+b=0))}；（5）E={x|(k Z)并且(x=100k)}；（6）F={<x, y>|(x, y R)并且(x2+y2<1)}。', '0', null, null, null, null);
INSERT INTO `saq` VALUES ('3', '枚举法写出下列集合。（1）{x|(x Z)并且(2＜x＜10)}；（2）{x|x是十进制的数字符号}；（3）{x|x是P 进制的数字符号}，P = 2, 8, 16；（4）{x|(x = 2)或(x = 5)}；（5）F = {＜x, y＞|(x, y Z)并且(0≤x≤2)并且(-2≤y≤1)}；（6）{x|x是People\'s Republic of China中的英文字母}。', '（1）{x|(x Z)并且(2<x<10)}=｛3, 4, 5, 6, 7, 8, 9｝；（2）{x|x是十进制的数字符号}={0, 1, 2, 3, 4, 5, 6, 7, 8, 9}；（3）{x|x是二进制的数字符号}={0, 1}；\r\n       {x|x是八进制的数字符号}={0, 1, 2, 3, 4, 5, 6, 7}；\r\n{x|x是十六进制的数字符号}\r\n={0, 1, 2, 3, 4, 5, 6, 7, 8, 9, A, B, C, D, E, F}；\r\n（4）{x|(x=2)或(x=5)}={2, 5}；\r\n（5）F={<0, -2>, <0, -1>, <0, 0>, <0, 1>, <1, -2>, <1, -1>, <1, 0>, <1, 1>, <2, -2>, <2, -1>, <2, 0>, <2, 1>}；\r\n（6）{x|x是People\'s Republic of China 中的英文字母}\r\n ={a, b, c, e, f, h, i, l, n, o, p, r, s, u}。\r\n', '0', null, null, null, null);
INSERT INTO `saq` VALUES ('4', '设全集为Z，下列哪些集合是相等的?（1）A = {x|x是偶数或奇数}；（2）B = {x| ((y Z)并且(x = 2y))}；（3）C = {1, 2, 3}；（4）D = {0, 1, -1, 2, -2, 3, -3, 4, -4, …}；（5）E = {2x|x Z}；（6）F = {3, 3, 2, 1, 2}；（7）G = {x|x3 - 6x2 - 7x - 6 = 0}；（8）H = {x|x3 - 6x2+11x - 6 = 0}。', 'A=D； B=E； C=F=H。', '0', null, null, null, null);
INSERT INTO `saq` VALUES ('5', '找出下列集合之间的关系。（1）A = {x|(x Z)并且(1＜x＜5)；（2）B = {2, 3}；（3）C = {x|x2 - 5x+6 = 0}；（4）D = {{2, 3}}；（5）E = {2}；（6）F = {x|(x = 2)或(x = 3)或(x = 4)或(x = 5)}；（7）G = {2x|(1≤x≤3)}；（8）H = {x|(x Z)并且(x2 + x + 1 = 0)}。', '因为A = {2, 3, 4}，C = {2, 3}，F = {2, 3, 4, 5}，G = {2, 4, 6}，H = ，所以有H E B A F，B D，H E G，H C，B = C。', '0', null, null, null, null);
INSERT INTO `saq` VALUES ('6', '设S = {N, Q, R}，问下列结论否正确。（1）2 N, N S，则2 S；（2）N Q, Q S，则N S；（3）N Q, Q R，则N R。', '(1)，(2)是错误的，(3)是正确的。', '0', null, null, null, null);
INSERT INTO `saq` VALUES ('7', '求下列集合的基数和每个集合的幂集。（1）{1, 2, 3}；（2）{1, {2, 3}}；（3）{{1, {2, 3}}}；（4）{{1, 2}}；（5）{{Φ, 2}, {2}}；（6）{a, {a}}；（7）{Φ, a, {b}}。', '（1）基数为3，幂集为：{Φ,{1},{2}, {3}, {1, 2}, {1, 3}, {2, 3}, {1, 2, 3}}；（2）基数为2，幂集为：{Φ, {1}, {{2, 3}}, {1, {2, 3}}}；（3）基数为1，幂集为：{Φ, {{1, {2, 3}}}}；（4）基数为1，幂集为：{Φ, {{1, 2}}}；（5）基数为2，幂集为：{Φ, {{Φ, 2}}, {{2}}, {{Φ, 2}, {2}}}；（6）基数为2，幂集为：{Φ, {a}, {{a}}, {a, {a}}}；（7）基数为3，幂集为：{Φ, {a}, {Φ}, {{b}}, {Φ, a}, {Φ, {b}}, {a, {b}}, \r\n{Φ, a, {b}}} 。\r\n', '0', null, null, null, null);
INSERT INTO `saq` VALUES ('8', '用公式表示图中的阴影部分。图7.1.4  图7.1.5', '图7.1.4和7.1.5阴影部分可分别表示为：B∩C∩\\bar{A}，(\\bar{A}∩\\bar{B}∩\\bar{C})。', '1', '/images/7-1-4.png', null, null, null);

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
INSERT INTO `set_class` VALUES ('1', '3', '2017-12-09 15:22:37');

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
INSERT INTO `set_ques` VALUES ('3', '3', '4');
INSERT INTO `set_ques` VALUES ('3', '8', '4');

-- ----------------------------
-- Table structure for stu_ques_record
-- ----------------------------
DROP TABLE IF EXISTS `stu_ques_record`;
CREATE TABLE `stu_ques_record` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `stuId` int(11) NOT NULL,
  `quesId` int(11) NOT NULL,
  `quesType` tinyint(1) NOT NULL,
  `flag` tinyint(1) DEFAULT NULL,
  `quesSetId` int(11) DEFAULT NULL,
  `stuAnswer` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `INDEX_QUES_SET_ID` (`quesSetId`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of stu_ques_record
-- ----------------------------
INSERT INTO `stu_ques_record` VALUES ('1', '1', '1', '1', '0', '1', '学生回答');
INSERT INTO `stu_ques_record` VALUES ('2', '1', '1', '3', '0', '1', '我的回答');
INSERT INTO `stu_ques_record` VALUES ('3', '1', '3', '4', '0', '3', '第三题回答');
INSERT INTO `stu_ques_record` VALUES ('4', '1', '8', '4', '0', '3', '第八题回答');

-- ----------------------------
-- Table structure for stu_set_record
-- ----------------------------
DROP TABLE IF EXISTS `stu_set_record`;
CREATE TABLE `stu_set_record` (
  `stuId` int(11) NOT NULL,
  `classId` int(11) DEFAULT NULL,
  `quesSetId` int(11) NOT NULL,
  `flag` tinyint(4) DEFAULT NULL,
  `committedDate` datetime DEFAULT NULL,
  `checkedDate` datetime DEFAULT NULL,
  `accuracy` float DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of stu_set_record
-- ----------------------------
INSERT INTO `stu_set_record` VALUES ('3', '1', '2', '2', '2017-12-07 20:43:08', '2017-12-08 18:43:16', '80');
INSERT INTO `stu_set_record` VALUES ('1', '1', '2', '2', '2017-12-05 20:52:48', '2017-12-09 20:52:52', '100');
INSERT INTO `stu_set_record` VALUES ('1', '1', '3', '1', '2017-12-09 15:30:56', null, null);

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
INSERT INTO `teacher` VALUES ('2', 'Peter', '1', '18781982388', 'qwe123', 'ustc');

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
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', 'mailxiaoz@163.com', 'qwe123123', 'xiaozhang', 'zx', '1', 'uestc', '1', '18781999999', '3126929722', null, null);
INSERT INTO `user` VALUES ('2', null, 'qwe123', 'testuser', 'tom', '0', null, '2', null, null, null, null);
INSERT INTO `user` VALUES ('3', null, 'qwe123123', 'maccount', 'jerry', '1', null, 'u3', null, null, null, null);
INSERT INTO `user` VALUES ('4', '4@163.com', 'qwe123', 'account4', 'mars', '0', 'ustc', 'u3', '18788888888', '312882', null, null);
