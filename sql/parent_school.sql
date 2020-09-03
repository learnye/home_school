/*
 Navicat Premium Data Transfer

 Source Server         : localhost3308
 Source Server Type    : MySQL
 Source Server Version : 50726
 Source Host           : localhost:3308
 Source Schema         : parent_school

 Target Server Type    : MySQL
 Target Server Version : 50726
 File Encoding         : 65001

 Date: 02/03/2020 21:21:23
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for advice
-- ----------------------------
DROP TABLE IF EXISTS `advice`;
CREATE TABLE `advice`  (
  `id` bigint(19) UNSIGNED NOT NULL AUTO_INCREMENT,
  `name` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '标题',
  `content` varchar(5000) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '内容',
  `reply` varchar(5000) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '回复',
  `parentid` bigint(19) NULL DEFAULT NULL COMMENT '家长',
  `state` tinyint(2) NULL DEFAULT 1 COMMENT '状态',
  `createTime` datetime(0) NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  `updateTime` datetime(0) NULL DEFAULT CURRENT_TIMESTAMP(0) ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '更新时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 8 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of advice
-- ----------------------------
INSERT INTO `advice` VALUES (6, '学生课外时间少', '适当增加一些可玩时间吧', '行', 1, 1, '2020-03-02 18:47:06', '2020-03-02 18:50:00');
INSERT INTO `advice` VALUES (7, '伙食有点差', '早餐没有粥，希望加点', '没问题的，加！', 2, 1, '2020-03-02 21:10:36', '2020-03-02 21:11:01');

-- ----------------------------
-- Table structure for chat
-- ----------------------------
DROP TABLE IF EXISTS `chat`;
CREATE TABLE `chat`  (
  `id` bigint(19) UNSIGNED NOT NULL AUTO_INCREMENT,
  `content` varchar(5000) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '内容',
  `fromName` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '发送人昵称',
  `toName` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '接收人昵称',
  `fromAvatarUrl` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '发送人头像',
  `toAvatarUrl` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '接收人头像',
  `tuid` int(11) NULL DEFAULT NULL COMMENT '教师',
  `parentid` int(11) NULL DEFAULT NULL COMMENT '家长',
  `type` int(11) NULL DEFAULT NULL COMMENT '1家长发送 2教师发送',
  `state` tinyint(2) NULL DEFAULT 1 COMMENT '状态',
  `createTime` datetime(0) NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  `updateTime` datetime(0) NULL DEFAULT CURRENT_TIMESTAMP(0) ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '更新时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 33 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of chat
-- ----------------------------
INSERT INTO `chat` VALUES (12, 'saa', '张明', NULL, 'upload/42541b5e29b34ca683dd9d7a130f186f.jpg', NULL, 1, 1, NULL, 1, '2020-03-02 20:14:59', '2020-03-02 20:14:59');
INSERT INTO `chat` VALUES (13, '你还', '张明', NULL, 'upload/42541b5e29b34ca683dd9d7a130f186f.jpg', NULL, 1, 1, NULL, 1, '2020-03-02 20:15:04', '2020-03-02 20:15:04');
INSERT INTO `chat` VALUES (14, '1111', '张明', NULL, 'upload/42541b5e29b34ca683dd9d7a130f186f.jpg', NULL, 1, 1, NULL, 1, '2020-03-02 20:17:44', '2020-03-02 20:17:44');
INSERT INTO `chat` VALUES (15, '哈哈', '张明', NULL, 'upload/42541b5e29b34ca683dd9d7a130f186f.jpg', NULL, 1, 2, NULL, 1, '2020-03-02 20:24:05', '2020-03-02 20:24:05');
INSERT INTO `chat` VALUES (16, '纳尼？', '王爸爸', NULL, 'upload/d452363cca5e4cc8a38783758762762f.jpg', NULL, 1, 2, 1, 1, '2020-03-02 20:24:38', '2020-03-02 20:33:19');
INSERT INTO `chat` VALUES (17, 'dad', '王爸爸', NULL, 'upload/d452363cca5e4cc8a38783758762762f.jpg', NULL, 1, 2, 1, 1, '2020-03-02 20:26:53', '2020-03-02 20:26:53');
INSERT INTO `chat` VALUES (18, '都叫京东就', '王爸爸', NULL, 'upload/d452363cca5e4cc8a38783758762762f.jpg', NULL, 1, 2, 1, 1, '2020-03-02 20:27:01', '2020-03-02 20:27:01');
INSERT INTO `chat` VALUES (19, 'ada', '王爸爸', NULL, 'upload/d452363cca5e4cc8a38783758762762f.jpg', NULL, 1, 2, 1, 1, '2020-03-02 20:33:04', '2020-03-02 20:33:04');
INSERT INTO `chat` VALUES (20, '111', '张明', NULL, 'upload/42541b5e29b34ca683dd9d7a130f186f.jpg', NULL, 1, 2, 2, 1, '2020-03-02 20:33:53', '2020-03-02 20:33:53');
INSERT INTO `chat` VALUES (21, '111111111111111111111111111111111111111111111111111111111', '张明', NULL, 'upload/42541b5e29b34ca683dd9d7a130f186f.jpg', NULL, 1, 2, 2, 1, '2020-03-02 20:34:07', '2020-03-02 20:34:07');
INSERT INTO `chat` VALUES (22, 'sdaasd', '张明', NULL, 'upload/42541b5e29b34ca683dd9d7a130f186f.jpg', NULL, 1, 2, 2, 1, '2020-03-02 20:34:12', '2020-03-02 20:34:12');
INSERT INTO `chat` VALUES (23, '你是男是女三', '张明', NULL, 'upload/42541b5e29b34ca683dd9d7a130f186f.jpg', NULL, 1, 2, 2, 1, '2020-03-02 20:37:43', '2020-03-02 20:37:43');
INSERT INTO `chat` VALUES (24, 'assa', '张明', NULL, 'upload/42541b5e29b34ca683dd9d7a130f186f.jpg', NULL, 1, 2, 2, 1, '2020-03-02 20:43:42', '2020-03-02 20:43:42');
INSERT INTO `chat` VALUES (25, '1111', '张明', NULL, 'upload/42541b5e29b34ca683dd9d7a130f186f.jpg', NULL, 1, 2, 2, 1, '2020-03-02 20:53:10', '2020-03-02 20:53:10');
INSERT INTO `chat` VALUES (26, '22', '张明', NULL, 'upload/42541b5e29b34ca683dd9d7a130f186f.jpg', NULL, 1, 2, 2, 1, '2020-03-02 20:53:16', '2020-03-02 20:53:16');
INSERT INTO `chat` VALUES (27, '33', '张明', NULL, 'upload/42541b5e29b34ca683dd9d7a130f186f.jpg', NULL, 1, 2, 2, 1, '2020-03-02 20:53:23', '2020-03-02 20:53:23');
INSERT INTO `chat` VALUES (28, 'jsjs', '张明', NULL, 'upload/42541b5e29b34ca683dd9d7a130f186f.jpg', NULL, 1, 2, 2, 1, '2020-03-02 20:56:27', '2020-03-02 20:56:27');
INSERT INTO `chat` VALUES (29, '惊声尖叫三', '张明', NULL, 'upload/42541b5e29b34ca683dd9d7a130f186f.jpg', NULL, 1, 2, 2, 1, '2020-03-02 20:56:30', '2020-03-02 20:56:30');
INSERT INTO `chat` VALUES (30, '你好王爸爸，在么，我是他们老师', '张明', NULL, 'upload/42541b5e29b34ca683dd9d7a130f186f.jpg', NULL, 1, 2, 2, 1, '2020-03-02 21:07:12', '2020-03-02 21:07:12');
INSERT INTO `chat` VALUES (31, '在的在的', '王爸爸', NULL, 'upload/d452363cca5e4cc8a38783758762762f.jpg', NULL, 1, 2, 1, 1, '2020-03-02 21:09:54', '2020-03-02 21:09:54');
INSERT INTO `chat` VALUES (32, '有事请讲老司机', '王爸爸', NULL, 'upload/d452363cca5e4cc8a38783758762762f.jpg', NULL, 1, 2, 1, 1, '2020-03-02 21:10:03', '2020-03-02 21:10:03');

-- ----------------------------
-- Table structure for classroom
-- ----------------------------
DROP TABLE IF EXISTS `classroom`;
CREATE TABLE `classroom`  (
  `id` bigint(19) UNSIGNED NOT NULL AUTO_INCREMENT,
  `name` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '班级名称',
  `state` tinyint(2) NULL DEFAULT 1 COMMENT '状态',
  `createTime` datetime(0) NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  `updateTime` datetime(0) NULL DEFAULT CURRENT_TIMESTAMP(0) ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '更新时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 12 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of classroom
-- ----------------------------
INSERT INTO `classroom` VALUES (5, '育红班', 1, '2020-03-01 08:37:03', '2020-03-01 08:38:43');
INSERT INTO `classroom` VALUES (6, '一年级一班', 1, '2020-03-01 08:37:17', '2020-03-01 08:38:29');
INSERT INTO `classroom` VALUES (7, '二年级一班', 1, '2020-03-01 08:37:28', '2020-03-01 08:37:28');
INSERT INTO `classroom` VALUES (8, '三年级一班', 1, '2020-03-01 08:37:41', '2020-03-01 08:37:41');
INSERT INTO `classroom` VALUES (9, '四年级一班', 1, '2020-03-01 08:37:48', '2020-03-01 08:37:48');
INSERT INTO `classroom` VALUES (10, '五年级一班', 1, '2020-03-01 08:38:03', '2020-03-01 08:38:03');
INSERT INTO `classroom` VALUES (11, '六年级一班', 1, '2020-03-01 08:38:12', '2020-03-01 08:38:12');

-- ----------------------------
-- Table structure for homework
-- ----------------------------
DROP TABLE IF EXISTS `homework`;
CREATE TABLE `homework`  (
  `id` bigint(19) UNSIGNED NOT NULL AUTO_INCREMENT,
  `name` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '标题',
  `content` varchar(5000) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '内容',
  `coverImg` varchar(5000) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '图片',
  `classroomid` bigint(19) NULL DEFAULT NULL COMMENT '所属班级',
  `teacherid` bigint(19) NULL DEFAULT NULL COMMENT '所属教师',
  `state` tinyint(2) NULL DEFAULT 1 COMMENT '状态',
  `createTime` datetime(0) NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  `updateTime` datetime(0) NULL DEFAULT CURRENT_TIMESTAMP(0) ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '更新时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 10 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of homework
-- ----------------------------
INSERT INTO `homework` VALUES (5, '解放电视剧福克斯', '法发顺丰发是方式是发放松放松粉色发放的说法是谁打得过第四个', 'upload/fdd49ef7c79b47edaee6f26947962f98.jpg', 10, 1, 2, '2020-03-02 14:32:07', '2020-03-02 14:32:15');
INSERT INTO `homework` VALUES (6, '英语12页背写', '电饭锅但是但是的', 'upload/1a434e60830040d2936adb9f95d8ee53.png', 10, 1, 1, '2020-03-02 14:32:26', '2020-03-02 21:05:21');
INSERT INTO `homework` VALUES (7, '写数学题20页', '梵蒂冈的身高多少', 'upload/2a920f55907d495e8a9bbe4d1da890e3.png', 10, 1, 1, '2020-03-02 14:32:33', '2020-03-02 21:04:54');
INSERT INTO `homework` VALUES (8, '幅度过大', '非得干点啥', 'upload/6fa30902968b4eb48504d2ef7f447755.png', 10, 1, 2, '2020-03-02 14:32:46', '2020-03-02 21:04:36');
INSERT INTO `homework` VALUES (9, '写5片字', '语文第89页', 'upload/f978b891599048068a11be260fd163ca.jpg', 10, 1, 1, '2020-03-02 21:04:26', '2020-03-02 21:04:26');

-- ----------------------------
-- Table structure for notice
-- ----------------------------
DROP TABLE IF EXISTS `notice`;
CREATE TABLE `notice`  (
  `id` bigint(19) UNSIGNED NOT NULL AUTO_INCREMENT,
  `name` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '名称',
  `content` varchar(5000) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '通知内容',
  `coverImg` varchar(5000) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '图片',
  `state` tinyint(2) NULL DEFAULT 1 COMMENT '状态',
  `createTime` datetime(0) NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  `updateTime` datetime(0) NULL DEFAULT CURRENT_TIMESTAMP(0) ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '更新时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 7 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of notice
-- ----------------------------
INSERT INTO `notice` VALUES (5, '第三季度睡觉觉', '还回到很多事合适的话护肤霜，圣诞节反倒是解放军。', 'upload/97a0271b3ba043e9a531383c8cbc04e1.jpg', 1, '2020-03-02 10:23:39', '2020-03-02 17:05:33');
INSERT INTO `notice` VALUES (6, '放假通知', '新冠肺炎影响，延迟放假啦', 'upload/8d522b8d4950425e8c9fbb7c8faed198.jpg', 1, '2020-03-02 17:08:28', '2020-03-02 17:08:28');

-- ----------------------------
-- Table structure for score
-- ----------------------------
DROP TABLE IF EXISTS `score`;
CREATE TABLE `score`  (
  `id` bigint(19) UNSIGNED NOT NULL AUTO_INCREMENT,
  `name` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '姓名',
  `content` varchar(5000) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '表现',
  `subject` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '科目',
  `studentid` bigint(19) NULL DEFAULT NULL COMMENT '学生',
  `teacherid` bigint(19) NULL DEFAULT NULL COMMENT '教师',
  `score` bigint(19) NULL DEFAULT 0 COMMENT '分数',
  `state` tinyint(2) NULL DEFAULT 1 COMMENT '状态',
  `createTime` datetime(0) NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  `updateTime` datetime(0) NULL DEFAULT CURRENT_TIMESTAMP(0) ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '更新时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 8 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of score
-- ----------------------------
INSERT INTO `score` VALUES (5, '成绩突出', '挺好', '数学', 1, 1, 120, 1, '2020-03-02 16:41:08', '2020-03-02 16:47:50');
INSERT INTO `score` VALUES (6, '2', '2', '22', 1, 1, 2, 2, '2020-03-02 16:51:02', '2020-03-02 16:51:05');
INSERT INTO `score` VALUES (7, '学生表现很棒', '没的说，非常好，超乎想象！', '语文', 2, 1, 99, 1, '2020-03-02 21:06:21', '2020-03-02 21:06:21');

-- ----------------------------
-- Table structure for sys_user
-- ----------------------------
DROP TABLE IF EXISTS `sys_user`;
CREATE TABLE `sys_user`  (
  `id` bigint(19) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `username` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '登陆名',
  `password` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '密码',
  `name` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '' COMMENT '用户名',
  `sex` tinyint(2) UNSIGNED NULL DEFAULT 1 COMMENT '性别',
  `age` tinyint(2) UNSIGNED NULL DEFAULT 0 COMMENT '年龄',
  `createTime` datetime(0) NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  `updateTime` datetime(0) NULL DEFAULT CURRENT_TIMESTAMP(0) ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '更新时间',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `IDx_user_login_name`(`username`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '后台用户登录表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_user
-- ----------------------------
INSERT INTO `sys_user` VALUES (1, 'admin', '123456', '管理员', 1, 0, '2019-06-21 16:23:39', '2019-06-21 16:23:39');

-- ----------------------------
-- Table structure for user_parent
-- ----------------------------
DROP TABLE IF EXISTS `user_parent`;
CREATE TABLE `user_parent`  (
  `id` bigint(19) UNSIGNED NOT NULL AUTO_INCREMENT,
  `username` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '登录名',
  `password` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '密码',
  `name` varchar(300) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' COMMENT '用户昵称',
  `gender` tinyint(2) NULL DEFAULT 0 COMMENT '性别',
  `age` int(9) NULL DEFAULT NULL COMMENT '年龄',
  `avatarUrl` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' COMMENT '头像',
  `phone` char(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' COMMENT '电话',
  `studentid` bigint(19) NULL DEFAULT NULL COMMENT '连接学生',
  `classroomid` bigint(19) NULL DEFAULT NULL COMMENT '所属班级',
  `state` tinyint(2) NULL DEFAULT 1 COMMENT '状态',
  `createTime` datetime(0) NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  `updateTime` datetime(0) NULL DEFAULT CURRENT_TIMESTAMP(0) ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '更新时间',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `uniquekey_user_username`(`username`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user_parent
-- ----------------------------
INSERT INTO `user_parent` VALUES (1, '5', '5', '爱玲她爸', 1, 36, 'upload/cc95dab3c7794ef0b3e0386556a26581.jpg', '18034272032', 1, 10, 1, '2020-03-02 10:21:58', '2020-03-02 20:10:13');
INSERT INTO `user_parent` VALUES (2, 'wangxinyu', '123456', '王爸爸', 1, 25, 'upload/d452363cca5e4cc8a38783758762762f.jpg', '15033182653', 2, 10, 1, '2020-03-02 20:18:58', '2020-03-02 20:19:48');

-- ----------------------------
-- Table structure for user_student
-- ----------------------------
DROP TABLE IF EXISTS `user_student`;
CREATE TABLE `user_student`  (
  `id` bigint(19) UNSIGNED NOT NULL AUTO_INCREMENT,
  `username` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '登录名',
  `password` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '密码',
  `name` varchar(300) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' COMMENT '用户昵称',
  `gender` tinyint(2) NULL DEFAULT 0 COMMENT '性别',
  `age` int(9) NULL DEFAULT NULL COMMENT '年龄',
  `avatarUrl` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' COMMENT '头像',
  `phone` char(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' COMMENT '电话',
  `classroomid` bigint(19) NULL DEFAULT NULL COMMENT '班级',
  `state` tinyint(2) NULL DEFAULT 1 COMMENT '状态',
  `createTime` datetime(0) NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  `updateTime` datetime(0) NULL DEFAULT CURRENT_TIMESTAMP(0) ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '更新时间',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `uniquekey_user_username`(`username`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user_student
-- ----------------------------
INSERT INTO `user_student` VALUES (1, '1', '11', '张爱玲', 2, 15, 'upload/573a1d3f7fbb46e5a45f904182ec77ff.jpg', '18034272031', 10, 1, '2020-03-02 10:10:30', '2020-03-02 19:58:50');
INSERT INTO `user_student` VALUES (2, '2', '2', '王新宇', 1, 16, 'upload/c5ac129519a74dca87dd6ae21e9c7db1.jpg', '18034272031', 10, 1, '2020-03-02 10:11:09', '2020-03-02 19:59:04');

-- ----------------------------
-- Table structure for user_teacher
-- ----------------------------
DROP TABLE IF EXISTS `user_teacher`;
CREATE TABLE `user_teacher`  (
  `id` bigint(19) UNSIGNED NOT NULL AUTO_INCREMENT,
  `username` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '登录名',
  `password` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '密码',
  `name` varchar(300) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' COMMENT '用户昵称',
  `gender` tinyint(2) NULL DEFAULT 0 COMMENT '性别',
  `age` int(9) NULL DEFAULT NULL COMMENT '年龄',
  `avatarUrl` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' COMMENT '头像',
  `phone` char(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' COMMENT '电话',
  `classroomid` bigint(19) NULL DEFAULT NULL COMMENT '班级',
  `state` tinyint(2) NULL DEFAULT 1 COMMENT '状态',
  `createTime` datetime(0) NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  `updateTime` datetime(0) NULL DEFAULT CURRENT_TIMESTAMP(0) ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '更新时间',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `uniquekey_user_username`(`username`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 5 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user_teacher
-- ----------------------------
INSERT INTO `user_teacher` VALUES (1, '1', '111', '张明', 2, 20, 'upload/42541b5e29b34ca683dd9d7a130f186f.jpg', '18034272031', 10, 1, '2020-03-02 10:02:01', '2020-03-02 19:57:49');
INSERT INTO `user_teacher` VALUES (3, '2', '1', '赵子新', 1, 23, 'upload/c54a35cf8a4c466ba023e55498a6ddf3.jpg', '18034272031', 5, 1, '2020-03-02 10:02:22', '2020-03-02 19:58:08');
INSERT INTO `user_teacher` VALUES (4, '3', '3', '汪洋', 2, 26, 'upload/cae2bce9a3f245eba596f8f94a0093d5.jpg', '18034272031', 5, 1, '2020-03-02 10:03:49', '2020-03-02 19:58:24');

SET FOREIGN_KEY_CHECKS = 1;
