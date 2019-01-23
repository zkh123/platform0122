/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50722
Source Host           : localhost:3306
Source Database       : local_test

Target Server Type    : MYSQL
Target Server Version : 50722
File Encoding         : 65001

Date: 2019-01-23 15:22:34
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for ping_tb
-- ----------------------------
DROP TABLE IF EXISTS `ping_tb`;
CREATE TABLE `ping_tb` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '自增主键',
  `userid` bigint(20) NOT NULL COMMENT '用户标识',
  `listingid` bigint(20) DEFAULT NULL COMMENT '标的',
  `bizid` int(11) DEFAULT NULL COMMENT '业务标识',
  `zuid` int(11) DEFAULT NULL COMMENT '业务分组',
  `dingid` int(11) DEFAULT NULL COMMENT '业务定义',
  `months` int(11) DEFAULT NULL COMMENT '区分业务',
  `credit_score` decimal(20,16) DEFAULT NULL,
  `credit_level` varchar(10) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '信用评级',
  `credit_bin` int(11) DEFAULT NULL COMMENT 'bin值',
  `credit_level_pro` varchar(10) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '前台评级',
  `model_label` varchar(150) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '模型标签',
  `model_ver` varchar(150) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '模型版本',
  `process_flag` int(11) DEFAULT NULL COMMENT '审批结论',
  `block_days` int(11) DEFAULT NULL COMMENT '禁言天数',
  `info` text COLLATE utf8mb4_unicode_ci COMMENT '扩展Json',
  `inserttime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '插入时间',
  `updatetime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `isactive` tinyint(1) NOT NULL DEFAULT '1' COMMENT '逻辑删除',
  PRIMARY KEY (`id`),
  KEY `idx_inserttime` (`inserttime`),
  KEY `idx_updatetime` (`updatetime`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='ping /*# Owner: huanglijun ;Manager: wuyiming #*/';

-- ----------------------------
-- Records of ping_tb
-- ----------------------------
INSERT INTO `ping_tb` VALUES ('1', '10000', '-1', '1202', '103', '103', '-2', '0.1230000033974648', 'A', '1', 'AA', 'appyi', 'v3_201804', '1', '31', '{\"credit_jiangji\": \"小a\", \"credit_duotou\": \"大B\"}', '2019-01-22 15:25:31', '2019-01-22 15:51:29', '1');
