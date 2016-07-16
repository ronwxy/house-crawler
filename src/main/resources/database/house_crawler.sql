/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50713
Source Host           : localhost:3306
Source Database       : house_crawler

Target Server Type    : MYSQL
Target Server Version : 50713
File Encoding         : 65001

Date: 2016-07-16 23:44:24
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for t_building
-- ----------------------------
DROP TABLE IF EXISTS `t_building`;
CREATE TABLE `t_building` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `presell_no` varchar(255) DEFAULT NULL,
  `building_no` varchar(255) DEFAULT NULL,
  `certificate_date` date DEFAULT NULL,
  `approve_sell_area` decimal(10,2) DEFAULT NULL,
  `land_no` varchar(255) DEFAULT NULL,
  `project_approve_no` varchar(255) DEFAULT NULL,
  `land_approve_no` varchar(255) DEFAULT NULL,
  `build_approve_no` varchar(255) DEFAULT NULL,
  `code` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for t_house
-- ----------------------------
DROP TABLE IF EXISTS `t_house`;
CREATE TABLE `t_house` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `house_no` int(11) DEFAULT NULL,
  `floor_no` int(11) DEFAULT NULL,
  `house_use` varchar(255) DEFAULT NULL,
  `house_type` varchar(255) DEFAULT NULL,
  `decorate` varchar(255) DEFAULT NULL,
  `building_area` decimal(10,2) DEFAULT NULL,
  `house_area` decimal(10,2) DEFAULT NULL,
  `share_area` decimal(10,2) DEFAULT NULL,
  `publish_price` decimal(10,2) DEFAULT NULL,
  `total_price` decimal(10,2) DEFAULT NULL,
  `sale_state` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for t_project
-- ----------------------------
DROP TABLE IF EXISTS `t_project`;
CREATE TABLE `t_project` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `project_name` varchar(255) DEFAULT NULL,
  `address` varchar(255) DEFAULT NULL,
  `presell_no` varchar(60) DEFAULT NULL,
  `certificate_date` date DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for t_project_detail
-- ----------------------------
DROP TABLE IF EXISTS `t_project_detail`;
CREATE TABLE `t_project_detail` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `project_name` varchar(255) DEFAULT NULL,
  `area` varchar(255) DEFAULT NULL,
  `approval_no` varchar(255) DEFAULT NULL,
  `company` varchar(255) DEFAULT NULL,
  `building_num` int(11) DEFAULT NULL,
  `project_address` varchar(255) DEFAULT NULL,
  `min_price` decimal(10,2) DEFAULT NULL,
  `sell_address` varchar(255) DEFAULT NULL,
  `sell_phone` varchar(255) DEFAULT NULL,
  `house_num` int(11) DEFAULT NULL,
  `bus` varchar(255) DEFAULT NULL,
  `total_ area` decimal(10,2) DEFAULT NULL,
  `design_company` varchar(255) DEFAULT NULL,
  `total_building_area` decimal(10,2) DEFAULT NULL,
  `sell_proxy` varchar(255) DEFAULT NULL,
  `size_rate` decimal(10,2) DEFAULT NULL,
  `property_company` varchar(255) DEFAULT NULL,
  `green_rate` decimal(10,2) DEFAULT NULL,
  `build_company` varchar(255) DEFAULT NULL,
  `property_price` decimal(10,2) DEFAULT NULL,
  `finish_date` date DEFAULT NULL,
  `project_summary` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
