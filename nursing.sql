/*
 Navicat Premium Data Transfer

 Source Server         : mysql
 Source Server Type    : MySQL
 Source Server Version : 80027
 Source Host           : localhost:3306
 Source Schema         : nursing

 Target Server Type    : MySQL
 Target Server Version : 80027
 File Encoding         : 65001

 Date: 02/01/2022 18:01:55
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for admin
-- ----------------------------
DROP TABLE IF EXISTS `admin`;
CREATE TABLE `admin`  (
  `admin_rname` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `password` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`admin_rname`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of admin
-- ----------------------------
INSERT INTO `admin` VALUES ('admin', '1');

-- ----------------------------
-- Table structure for bed
-- ----------------------------
DROP TABLE IF EXISTS `bed`;
CREATE TABLE `bed`  (
  `bed_id` int NOT NULL AUTO_INCREMENT,
  `room_number` varchar(3) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `bed_status` int NULL DEFAULT NULL,
  `bed_number` int NULL DEFAULT NULL,
  PRIMARY KEY (`bed_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of bed
-- ----------------------------
INSERT INTO `bed` VALUES (1, '204', 0, 1);
INSERT INTO `bed` VALUES (2, '205', 1, 2);
INSERT INTO `bed` VALUES (3, '206', 1, 2);
INSERT INTO `bed` VALUES (4, '207', 0, 3);

-- ----------------------------
-- Table structure for checkin
-- ----------------------------
DROP TABLE IF EXISTS `checkin`;
CREATE TABLE `checkin`  (
  `checkin_id` int NOT NULL AUTO_INCREMENT,
  `user_id` int NOT NULL,
  `bed_id` int NULL DEFAULT NULL,
  `contact_tel` varchar(11) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `checkin_date` datetime NULL DEFAULT NULL,
  PRIMARY KEY (`checkin_id`) USING BTREE,
  INDEX `bed_id`(`bed_id`) USING BTREE,
  INDEX `user_id`(`user_id`) USING BTREE,
  CONSTRAINT `bed_id` FOREIGN KEY (`bed_id`) REFERENCES `bed` (`bed_id`) ON DELETE RESTRICT ON UPDATE CASCADE,
  CONSTRAINT `user_id` FOREIGN KEY (`user_id`) REFERENCES `user` (`user_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of checkin
-- ----------------------------
INSERT INTO `checkin` VALUES (1, 1, 1, '15890607582', '2021-12-29 11:13:03');
INSERT INTO `checkin` VALUES (2, 3, 2, '15875825172', '2021-12-29 11:17:17');
INSERT INTO `checkin` VALUES (3, 4, 3, '', '2022-01-02 16:02:27');
INSERT INTO `checkin` VALUES (4, 5, 1, '', '2022-01-02 16:02:39');
INSERT INTO `checkin` VALUES (5, 6, 2, '', '2022-01-02 16:03:14');
INSERT INTO `checkin` VALUES (6, 7, 3, '', '2022-01-02 16:03:31');

-- ----------------------------
-- Table structure for food
-- ----------------------------
DROP TABLE IF EXISTS `food`;
CREATE TABLE `food`  (
  `food_id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `protein` double NULL DEFAULT NULL,
  `cho` double NULL DEFAULT NULL,
  `heat` double NULL DEFAULT NULL,
  `fat` double NULL DEFAULT NULL,
  `img_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`food_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 13 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of food
-- ----------------------------
INSERT INTO `food` VALUES (3, '西红柿炒鸡蛋', 5.7, 4.3, 85, 5.4, '9262461b-6a4f-4dec-8f14-7901afa9b73a.jpg');
INSERT INTO `food` VALUES (5, '蚝油杏鲍菇', 2.3, 12.2, 101.2, 5.7, '7f1cfd58-ea68-4dd2-8d15-94eb2b1d0fc3.jpg');
INSERT INTO `food` VALUES (6, '老母鸡炖栗子', 17.4, 6.3, 224, 14.3, 'bd706e95-ec4a-481a-bb4d-83e61b2649a2.jpg');
INSERT INTO `food` VALUES (7, '尖椒炒红肠', 5.6, 11.3, 186, 13.4, '8ff1625d-75c6-419f-9d23-6b79a510224b.jpg');
INSERT INTO `food` VALUES (8, '奥尔良鸡腿', 18.8, 9.8, 141, 2.7, '9c9340a5-df9b-426c-affb-a3bea2580c28.jpg');
INSERT INTO `food` VALUES (9, '阳春面', 17.4, 71.5, 477, 13.5, '98c17058-6e0e-49ea-b32e-07dc2ef2ee87.jpg');
INSERT INTO `food` VALUES (10, '小米南瓜羹', 1.6, 13.6, 64, 0.5, '93b3e3ac-0bb6-40f6-a9e6-ec4a2b79f39a.jpg');
INSERT INTO `food` VALUES (13, '当归红糖鸡蛋', 15, 10, 70, 7, '40057480-f4b5-4c56-b2c5-b8f6a349bf4c.jpg');
INSERT INTO `food` VALUES (14, '梅干菜饼', 5, 12, 100, 7, 'fb5de5a2-db6e-4287-a1f0-9cda3c7a7276.jpg');
INSERT INTO `food` VALUES (15, '香辣牛肉炖土豆', 20, 15, 150, 17, '01f09583-a08d-4279-a7ed-bda8a00a348a.jpg');
INSERT INTO `food` VALUES (16, '芦笋炒虾仁', 19, 29, 140, 10, '44f104f6-52d7-46c3-9455-d1531998fec6.jpg');
INSERT INTO `food` VALUES (17, '牛肉年糕汤', 17, 20, 140, 15, '54244578-19dc-49e0-b80a-1829812af51e.jpg');
INSERT INTO `food` VALUES (18, '麻辣龙虾', 15, 29, 110, 10, '7e5d6c97-25d0-42fd-9c43-630437946cdd.jpg');
INSERT INTO `food` VALUES (19, '蒜炒红肠', 19.5, 20.2, 200, 25, 'ef17f9b7-df93-4db0-a5ca-210d9650a3fd.jpg');

-- ----------------------------
-- Table structure for food_menu
-- ----------------------------
DROP TABLE IF EXISTS `food_menu`;
CREATE TABLE `food_menu`  (
  `menu_id` int NOT NULL AUTO_INCREMENT,
  `user_id` int NOT NULL,
  `week` int NULL DEFAULT NULL,
  `eating_time` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `food_id` int NOT NULL,
  PRIMARY KEY (`menu_id`) USING BTREE,
  INDEX `user`(`user_id`) USING BTREE,
  INDEX `food_id`(`food_id`) USING BTREE,
  CONSTRAINT `food_id` FOREIGN KEY (`food_id`) REFERENCES `food` (`food_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `user` FOREIGN KEY (`user_id`) REFERENCES `user` (`user_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE = InnoDB AUTO_INCREMENT = 13 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of food_menu
-- ----------------------------
INSERT INTO `food_menu` VALUES (1, 2, 3, '中餐', 3);
INSERT INTO `food_menu` VALUES (3, 2, 5, '中餐', 3);
INSERT INTO `food_menu` VALUES (4, 2, 1, '早餐', 10);
INSERT INTO `food_menu` VALUES (5, 2, 1, '中餐', 5);
INSERT INTO `food_menu` VALUES (6, 2, 1, '晚餐', 7);
INSERT INTO `food_menu` VALUES (7, 2, 2, '早餐', 9);
INSERT INTO `food_menu` VALUES (8, 2, 2, '中餐', 6);
INSERT INTO `food_menu` VALUES (9, 2, 2, '晚餐', 8);
INSERT INTO `food_menu` VALUES (10, 1, 3, '中餐', 7);
INSERT INTO `food_menu` VALUES (11, 1, 2, '中餐', 6);
INSERT INTO `food_menu` VALUES (12, 2, 4, '中餐', 8);
INSERT INTO `food_menu` VALUES (13, 2, 6, '中餐', 17);
INSERT INTO `food_menu` VALUES (14, 2, 1, '早餐', 14);

-- ----------------------------
-- Table structure for nursing
-- ----------------------------
DROP TABLE IF EXISTS `nursing`;
CREATE TABLE `nursing`  (
  `nursing_id` int NOT NULL AUTO_INCREMENT,
  `nursing_name` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `service_price` int NULL DEFAULT NULL,
  `description` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`nursing_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of nursing
-- ----------------------------
INSERT INTO `nursing` VALUES (1, '按摩', 50, '全身按摩');
INSERT INTO `nursing` VALUES (2, '散步', 0, '在养老院公园散步');
INSERT INTO `nursing` VALUES (3, '剪头发', 78, '高级剪发');

-- ----------------------------
-- Table structure for nursing_record
-- ----------------------------
DROP TABLE IF EXISTS `nursing_record`;
CREATE TABLE `nursing_record`  (
  `record_id` int NOT NULL AUTO_INCREMENT,
  `user_id` int NOT NULL,
  `nursing_id` int NOT NULL,
  `nursing_time` datetime NULL DEFAULT NULL,
  `nursing_content` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`record_id`) USING BTREE,
  INDEX `user_record`(`user_id`) USING BTREE,
  INDEX `nursing_id`(`nursing_id`) USING BTREE,
  CONSTRAINT `nursing_id` FOREIGN KEY (`nursing_id`) REFERENCES `nursing` (`nursing_id`) ON DELETE RESTRICT ON UPDATE CASCADE,
  CONSTRAINT `user_record` FOREIGN KEY (`user_id`) REFERENCES `user` (`user_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of nursing_record
-- ----------------------------
INSERT INTO `nursing_record` VALUES (1, 4, 1, '2022-01-01 16:41:34', '你猜');

-- ----------------------------
-- Table structure for retreat
-- ----------------------------
DROP TABLE IF EXISTS `retreat`;
CREATE TABLE `retreat`  (
  `retreat_id` int NOT NULL AUTO_INCREMENT,
  `checkin_id` int NULL DEFAULT NULL,
  `retreat_time` datetime NULL DEFAULT NULL,
  `retreat_reason` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `ask_time` datetime NULL DEFAULT NULL,
  PRIMARY KEY (`retreat_id`) USING BTREE,
  INDEX `checkin`(`checkin_id`) USING BTREE,
  CONSTRAINT `checkin` FOREIGN KEY (`checkin_id`) REFERENCES `checkin` (`checkin_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of retreat
-- ----------------------------
INSERT INTO `retreat` VALUES (1, 2, '2021-12-30 11:17:37', '完蛋了', '2021-12-29 11:17:46');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `user_id` int NOT NULL AUTO_INCREMENT,
  `id_card` varchar(18) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `name` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `age` int NULL DEFAULT NULL,
  `status` int NULL DEFAULT NULL,
  `sex` varchar(6) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`user_id`) USING BTREE,
  INDEX `sex`(`sex`) USING BTREE,
  INDEX `name`(`name`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES (1, '410105200011020075', '小李', 50, 1, '男');
INSERT INTO `user` VALUES (2, '412105200815470054', '小红', 25, 1, '女');
INSERT INTO `user` VALUES (3, '410105200011850031', '小明', 100, 0, '男');
INSERT INTO `user` VALUES (4, '123456789123456781', '林文威', 20, 1, '男');
INSERT INTO `user` VALUES (5, '123456789021344545', '李鹤', 21, 1, '男');
INSERT INTO `user` VALUES (6, '123456984028472910', '王彬瞻', 20, 1, '男');
INSERT INTO `user` VALUES (7, '325463244365543456', '吴宗辉', 20, 1, '男');

SET FOREIGN_KEY_CHECKS = 1;
