/*
 Navicat Premium Data Transfer

 Source Server         : 127.0.0.1
 Source Server Type    : MySQL
 Source Server Version : 50540
 Source Host           : localhost:3306
 Source Schema         : rabc-module

 Target Server Type    : MySQL
 Target Server Version : 50540
 File Encoding         : 65001

 Date: 06/11/2019 22:01:00
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for t_menu
-- ----------------------------
DROP TABLE IF EXISTS `t_menu`;
CREATE TABLE `t_menu`  (
  `id` int(32) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `name` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '菜单名称',
  `icon` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '菜单图标(可存base64,也可以存url)',
  `order_num` int(32) DEFAULT NULL COMMENT '排序号(默认0) ,作用是给前端返回时,固定展示的位置',
  `url` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '访问路径(路由的url)',
  `description` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '菜单描述',
  `type` int(10) DEFAULT NULL COMMENT '类型(1:模块 2:菜单) 模块包含菜单',
  `parent_id` int(16) DEFAULT NULL COMMENT '上次菜单id.自关联menu表,可以为null',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `db_status` int(10) DEFAULT NULL COMMENT '删除标识 0-正常 1-删除',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for t_role
-- ----------------------------
DROP TABLE IF EXISTS `t_role`;
CREATE TABLE `t_role`  (
  `id` int(32) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `name` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '角色名称',
  `description` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '角色描述',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `db_status` int(10) NOT NULL COMMENT '删除状态 0-正常 1-删除',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for t_role_menu
-- ----------------------------
DROP TABLE IF EXISTS `t_role_menu`;
CREATE TABLE `t_role_menu`  (
  `id` int(32) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `role_id` int(32) DEFAULT NULL COMMENT '角色id',
  `menu_id` int(32) DEFAULT NULL COMMENT '菜单id',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `db_status` int(10) DEFAULT NULL COMMENT '删除标识 0-正常  -1伪删除',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for t_user
-- ----------------------------
DROP TABLE IF EXISTS `t_user`;
CREATE TABLE `t_user`  (
  `id` int(32) NOT NULL AUTO_INCREMENT COMMENT '用户姓名',
  `login_name` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '登录名',
  `pwd` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '密码',
  `token` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT 'token',
  `token_expire_time` datetime DEFAULT NULL COMMENT 'token过期时间',
  `name` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '用户姓名',
  `phone` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '用户电话',
  `pwd_error_num` int(16) DEFAULT 0 COMMENT '验证时间内 密码错误次数 默认0',
  `lock_status` int(16) DEFAULT NULL COMMENT '锁定状态 0-锁定 1-未锁定',
  `pwd_error_time` datetime DEFAULT '0000-00-00 00:00:00' COMMENT '密码错误时间(验证时间内第一次错误时间)',
  `lock_time` datetime DEFAULT '0000-00-00 00:00:00' COMMENT '锁定时间(密码错误多次被锁定-)',
  `create_time` datetime DEFAULT '0000-00-00 00:00:00' COMMENT '创建时间',
  `update_time` datetime DEFAULT '0000-00-00 00:00:00' COMMENT '更新时间',
  `db_status` int(16) DEFAULT NULL COMMENT '删除标识 0-正常 1-伪删除',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for t_user_role
-- ----------------------------
DROP TABLE IF EXISTS `t_user_role`;
CREATE TABLE `t_user_role`  (
  `id` int(32) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `user_id` int(32) DEFAULT NULL COMMENT '用户id',
  `role_id` int(32) DEFAULT NULL COMMENT '角色id',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `db_status` int(10) NOT NULL COMMENT '删除标识 0-正常 1-伪删除',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Compact;

SET FOREIGN_KEY_CHECKS = 1;
