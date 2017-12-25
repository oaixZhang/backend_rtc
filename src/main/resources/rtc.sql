/*
Navicat MySQL Data Transfer

Source Server         : local
Source Server Version : 50719
Source Host           : localhost:3306
Source Database       : rtc

Target Server Type    : MYSQL
Target Server Version : 50719
File Encoding         : 65001

Date: 2017-12-25 14:46:37
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for answer
-- ----------------------------
DROP TABLE IF EXISTS `answer`;
CREATE TABLE `answer` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `student_id` int(11) NOT NULL,
  `set_id` int(11) DEFAULT NULL,
  `question_id` int(11) NOT NULL,
  `is_processed` bit(1) DEFAULT b'0' COMMENT '是否批改，1为已批改，0为未批改',
  `is_correct` bit(1) DEFAULT b'0' COMMENT '1代表正确，0代表不正确',
  `content` varchar(1000) DEFAULT NULL,
  `point` int(11) DEFAULT NULL COMMENT '该题目得分',
  `createtime` datetime DEFAULT NULL,
  `modifior` varchar(50) DEFAULT NULL COMMENT '谁批阅的这题目',
  `modifytime` datetime DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `INDEX_QUES_SET_ID` (`set_id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of answer
-- ----------------------------
INSERT INTO `answer` VALUES ('1', '1', '1', '1', null, null, '学生回答', null, null, null, null);
INSERT INTO `answer` VALUES ('2', '1', '1', '1', null, null, '我的回答', null, null, null, null);
INSERT INTO `answer` VALUES ('3', '1', '3', '3', null, null, '第三题回答', null, null, null, null);
INSERT INTO `answer` VALUES ('4', '1', '3', '8', null, null, '第八题回答', null, null, null, null);

-- ----------------------------
-- Table structure for class
-- ----------------------------
DROP TABLE IF EXISTS `class`;
CREATE TABLE `class` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `teacher_id` int(11) NOT NULL,
  `course_name` varchar(10) NOT NULL,
  `course_hours` int(11) DEFAULT NULL,
  `class_size` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_TeacherClass` (`teacher_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of class
-- ----------------------------
INSERT INTO `class` VALUES ('1', '1', 'math', '30', '50');
INSERT INTO `class` VALUES ('2', '2', 'English', '20', '40');

-- ----------------------------
-- Table structure for class_student
-- ----------------------------
DROP TABLE IF EXISTS `class_student`;
CREATE TABLE `class_student` (
  `id` int(11) NOT NULL,
  `class_id` int(11) NOT NULL,
  `user_id` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of class_student
-- ----------------------------
INSERT INTO `class_student` VALUES ('1', '1', '1');
INSERT INTO `class_student` VALUES ('2', '1', '3');
INSERT INTO `class_student` VALUES ('3', '1', '4');
INSERT INTO `class_student` VALUES ('4', '2', '2');
INSERT INTO `class_student` VALUES ('5', '2', '3');

-- ----------------------------
-- Table structure for question
-- ----------------------------
DROP TABLE IF EXISTS `question`;
CREATE TABLE `question` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `type` varchar(20) DEFAULT NULL COMMENT '单选single,多选multiple,填空completion,简答simple_answer',
  `title` text NOT NULL,
  `answer` text NOT NULL,
  `img_url` varchar(200) DEFAULT NULL,
  `point` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of question
-- ----------------------------
INSERT INTO `question` VALUES ('1', null, '用枚举法写出下列集合。（1）大于10小于20的整数全体；（2）20的所有因数的全体；（3）小于100的12正倍数。', '（1）设A为大于10小于20的整数全体，则 A={11, 12, 13, 14, 15, 16, 17, 18, 19}；（2）设B为20的所有因数的全体，则B={1, 2, 4, 5, 10, 20}；（3）设C为小于100的12正倍数，则C={12, 24, 36, 48, 60, 72, 84, 96}。', null, null);
INSERT INTO `question` VALUES ('2', null, '用描述法写出下列集合。（1）从0到1000的整数；（2）奇数的全体；（3）7的倍数；（4）所有实数集上一元一次方程的解组成的集合；（5）能被100整除的整数集合；（6）直角坐标系中，单位元(不包括单位圆周)的点集。', '（1）A={x|(x Z)并且(0≤x≤1000)}；（2）O={x|(k Z)并且(x=2k+1)}；（3）B={x|(k Z)并且(x=7k)}；（4）D={x|(x R)并且(a R)并且(a≠0)并且(b R)并且(ax+b=0))}；（5）E={x|(k Z)并且(x=100k)}；（6）F={<x, y>|(x, y R)并且(x2+y2<1)}。', null, null);
INSERT INTO `question` VALUES ('3', null, '枚举法写出下列集合。（1）{x|(x Z)并且(2＜x＜10)}；（2）{x|x是十进制的数字符号}；（3）{x|x是P 进制的数字符号}，P = 2, 8, 16；（4）{x|(x = 2)或(x = 5)}；（5）F = {＜x, y＞|(x, y Z)并且(0≤x≤2)并且(-2≤y≤1)}；（6）{x|x是People\'s Republic of China中的英文字母}。', '（1）{x|(x Z)并且(2<x<10)}=｛3, 4, 5, 6, 7, 8, 9｝；（2）{x|x是十进制的数字符号}={0, 1, 2, 3, 4, 5, 6, 7, 8, 9}；（3）{x|x是二进制的数字符号}={0, 1}；\r\n       {x|x是八进制的数字符号}={0, 1, 2, 3, 4, 5, 6, 7}；\r\n{x|x是十六进制的数字符号}\r\n={0, 1, 2, 3, 4, 5, 6, 7, 8, 9, A, B, C, D, E, F}；\r\n（4）{x|(x=2)或(x=5)}={2, 5}；\r\n（5）F={<0, -2>, <0, -1>, <0, 0>, <0, 1>, <1, -2>, <1, -1>, <1, 0>, <1, 1>, <2, -2>, <2, -1>, <2, 0>, <2, 1>}；\r\n（6）{x|x是People\'s Republic of China 中的英文字母}\r\n ={a, b, c, e, f, h, i, l, n, o, p, r, s, u}。\r\n', null, null);
INSERT INTO `question` VALUES ('4', null, '设全集为Z，下列哪些集合是相等的?（1）A = {x|x是偶数或奇数}；（2）B = {x| ((y Z)并且(x = 2y))}；（3）C = {1, 2, 3}；（4）D = {0, 1, -1, 2, -2, 3, -3, 4, -4, …}；（5）E = {2x|x Z}；（6）F = {3, 3, 2, 1, 2}；（7）G = {x|x3 - 6x2 - 7x - 6 = 0}；（8）H = {x|x3 - 6x2+11x - 6 = 0}。', 'A=D； B=E； C=F=H。', null, null);
INSERT INTO `question` VALUES ('5', null, '找出下列集合之间的关系。（1）A = {x|(x Z)并且(1＜x＜5)；（2）B = {2, 3}；（3）C = {x|x2 - 5x+6 = 0}；（4）D = {{2, 3}}；（5）E = {2}；（6）F = {x|(x = 2)或(x = 3)或(x = 4)或(x = 5)}；（7）G = {2x|(1≤x≤3)}；（8）H = {x|(x Z)并且(x2 + x + 1 = 0)}。', '因为A = {2, 3, 4}，C = {2, 3}，F = {2, 3, 4, 5}，G = {2, 4, 6}，H = ，所以有H E B A F，B D，H E G，H C，B = C。', null, null);
INSERT INTO `question` VALUES ('6', null, '设S = {N, Q, R}，问下列结论否正确。（1）2 N, N S，则2 S；（2）N Q, Q S，则N S；（3）N Q, Q R，则N R。', '(1)，(2)是错误的，(3)是正确的。', null, null);
INSERT INTO `question` VALUES ('7', null, '求下列集合的基数和每个集合的幂集。（1）{1, 2, 3}；（2）{1, {2, 3}}；（3）{{1, {2, 3}}}；（4）{{1, 2}}；（5）{{Φ, 2}, {2}}；（6）{a, {a}}；（7）{Φ, a, {b}}。', '（1）基数为3，幂集为：{Φ,{1},{2}, {3}, {1, 2}, {1, 3}, {2, 3}, {1, 2, 3}}；（2）基数为2，幂集为：{Φ, {1}, {{2, 3}}, {1, {2, 3}}}；（3）基数为1，幂集为：{Φ, {{1, {2, 3}}}}；（4）基数为1，幂集为：{Φ, {{1, 2}}}；（5）基数为2，幂集为：{Φ, {{Φ, 2}}, {{2}}, {{Φ, 2}, {2}}}；（6）基数为2，幂集为：{Φ, {a}, {{a}}, {a, {a}}}；（7）基数为3，幂集为：{Φ, {a}, {Φ}, {{b}}, {Φ, a}, {Φ, {b}}, {a, {b}}, \r\n{Φ, a, {b}}} 。\r\n', null, null);
INSERT INTO `question` VALUES ('8', null, '用公式表示图中的阴影部分。图7.1.4  图7.1.5', '图7.1.4和7.1.5阴影部分可分别表示为：B∩C∩\\bar{A}，(\\bar{A}∩\\bar{B}∩\\bar{C})。', '/images/7-1-4.png', null);

-- ----------------------------
-- Table structure for question_item
-- ----------------------------
DROP TABLE IF EXISTS `question_item`;
CREATE TABLE `question_item` (
  `id` int(255) NOT NULL AUTO_INCREMENT,
  `title` varchar(255) DEFAULT NULL,
  `sort` int(11) DEFAULT NULL,
  `question_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of question_item
-- ----------------------------

-- ----------------------------
-- Table structure for set
-- ----------------------------
DROP TABLE IF EXISTS `set`;
CREATE TABLE `set` (
  `id` int(11) NOT NULL,
  `name` varchar(100) DEFAULT NULL COMMENT '题集名称',
  `teacher_id` int(11) NOT NULL COMMENT '哪位老师',
  `creattime` datetime DEFAULT NULL,
  `remark` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of set
-- ----------------------------
INSERT INTO `set` VALUES ('1', null, '1', null, null);
INSERT INTO `set` VALUES ('2', null, '1', null, null);
INSERT INTO `set` VALUES ('3', null, '1', null, null);

-- ----------------------------
-- Table structure for set_class
-- ----------------------------
DROP TABLE IF EXISTS `set_class`;
CREATE TABLE `set_class` (
  `id` int(11) NOT NULL,
  `class_id` int(11) NOT NULL,
  `set_id` int(11) NOT NULL,
  `date` datetime NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of set_class
-- ----------------------------
INSERT INTO `set_class` VALUES ('1', '1', '1', '2017-11-11 02:45:34');
INSERT INTO `set_class` VALUES ('2', '1', '2', '2017-11-11 11:17:17');
INSERT INTO `set_class` VALUES ('3', '1', '3', '2017-12-09 15:22:37');

-- ----------------------------
-- Table structure for set_question
-- ----------------------------
DROP TABLE IF EXISTS `set_question`;
CREATE TABLE `set_question` (
  `id` int(11) NOT NULL,
  `set_id` int(11) NOT NULL,
  `question_id` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of set_question
-- ----------------------------
INSERT INTO `set_question` VALUES ('1', '1', '1');
INSERT INTO `set_question` VALUES ('2', '1', '1');
INSERT INTO `set_question` VALUES ('3', '1', '1');
INSERT INTO `set_question` VALUES ('4', '2', '1');
INSERT INTO `set_question` VALUES ('5', '3', '3');
INSERT INTO `set_question` VALUES ('6', '3', '8');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `phone` varchar(11) DEFAULT NULL,
  `user_name` varchar(20) DEFAULT NULL,
  `password` varchar(20) NOT NULL,
  `is_teacher` bit(1) NOT NULL DEFAULT b'0' COMMENT '用户身份表示，1为老师，0为学生（默认）',
  `name` varchar(20) NOT NULL,
  `gender` tinyint(1) DEFAULT NULL,
  `school` varchar(20) DEFAULT NULL,
  `grade` varchar(5) DEFAULT NULL,
  `email` varchar(50) DEFAULT NULL,
  `qq` varchar(11) DEFAULT NULL,
  `img_url` varchar(200) DEFAULT NULL,
  `token` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', '18781999999', null, 'qwe123123', '\0', 'zx', '1', 'uestc', '1', 'mailxiaoz@163.com', '3126929722', null, null);
INSERT INTO `user` VALUES ('2', '13666666666', null, 'qwe123', '\0', 'tom', '0', null, '2', null, null, null, null);
INSERT INTO `user` VALUES ('3', '18877773333', null, 'qwe123123', '\0', 'jerry', '1', null, 'u3', null, null, null, null);
INSERT INTO `user` VALUES ('4', '18788888888', null, 'qwe123', '\0', 'mars', '0', 'ustc', 'u3', '4@163.com', '312882', null, null);
