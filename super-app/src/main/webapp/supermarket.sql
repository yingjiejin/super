/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50520
Source Host           : localhost:3306
Source Database       : supermarket

Target Server Type    : MYSQL
Target Server Version : 50520
File Encoding         : 65001

Date: 2017-04-30 15:55:28
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `st_employee`
-- ----------------------------
DROP TABLE IF EXISTS `st_employee`;
CREATE TABLE `st_employee` (
  `employee_id` varchar(10) NOT NULL COMMENT '员工ID',
  `employee_name` varchar(100) NOT NULL COMMENT '员工名称',
  `employee_password` varchar(100) NOT NULL COMMENT '员工密码',
  `employee_type` varchar(50) NOT NULL COMMENT '员工类型',
  PRIMARY KEY (`employee_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of st_employee
-- ----------------------------

-- ----------------------------
-- Table structure for `st_goods`
-- ----------------------------
DROP TABLE IF EXISTS `st_goods`;
CREATE TABLE `st_goods` (
  `goods_id` varchar(10) NOT NULL COMMENT '商品编号',
  `goods_name` varchar(100) NOT NULL COMMENT '商品名称',
  `goods_company` varchar(100) NOT NULL COMMENT '单位',
  `goods_type` varchar(20) NOT NULL COMMENT '商品类别',
  `goods_cost` decimal(15,2) NOT NULL COMMENT '商品成本价',
  `goods_price` decimal(15,2) NOT NULL COMMENT '商品单价',
  PRIMARY KEY (`goods_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of st_goods
-- ----------------------------

-- ----------------------------
-- Table structure for `st_goods_type`
-- ----------------------------
DROP TABLE IF EXISTS `st_goods_type`;
CREATE TABLE `st_goods_type` (
  `type_id` int(10) NOT NULL AUTO_INCREMENT COMMENT '类别编号',
  `type_name` varchar(100) NOT NULL COMMENT '类别名称',
  `type_explain` varchar(200) DEFAULT NULL COMMENT '类别说明',
  PRIMARY KEY (`type_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of st_goods_type
-- ----------------------------

-- ----------------------------
-- Table structure for `st_log`
-- ----------------------------
DROP TABLE IF EXISTS `st_log`;
CREATE TABLE `st_log` (
  `log_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '日志编号',
  `employee_id` varchar(10) NOT NULL COMMENT '员工工号',
  `login_date` date NOT NULL COMMENT '登录时间',
  `logout_date` date NOT NULL COMMENT '退出时间',
  `login_ip` varchar(100) NOT NULL COMMENT '登录IP',
  PRIMARY KEY (`log_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of st_log
-- ----------------------------

-- ----------------------------
-- Table structure for `st_market`
-- ----------------------------
DROP TABLE IF EXISTS `st_market`;
CREATE TABLE `st_market` (
  `bill_id` varchar(10) NOT NULL COMMENT '销售账单号',
  `goods_id` varchar(10) NOT NULL COMMENT '商品编号',
  `sales_quantity` varchar(100) NOT NULL COMMENT '销售数量',
  `amount_receivable` decimal(10,2) NOT NULL COMMENT '应收金额',
  `discount_rate` varchar(100) NOT NULL COMMENT '折扣率',
  `amount_paidvar` decimal(10,2) NOT NULL COMMENT '实收金额',
  `sale_date` date NOT NULL COMMENT '销售日期',
  `operator_id` int(11) NOT NULL COMMENT '操作员ID',
  PRIMARY KEY (`bill_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of st_market
-- ----------------------------

-- ----------------------------
-- Table structure for `st_purchase`
-- ----------------------------
DROP TABLE IF EXISTS `st_purchase`;
CREATE TABLE `st_purchase` (
  `purchase_id` varchar(10) NOT NULL DEFAULT '' COMMENT '进货账单号',
  `goods_id` varchar(10) NOT NULL COMMENT '商品编号',
  `supplier_id` varchar(10) NOT NULL COMMENT '供货商编号',
  `purchase_quantity` varchar(100) NOT NULL COMMENT '进货数量',
  `payment_amount` decimal(10,2) NOT NULL COMMENT '支付金额',
  `purchase_date` date NOT NULL COMMENT '进货日期',
  `operator_id` varchar(10) NOT NULL COMMENT '操作员ID',
  PRIMARY KEY (`purchase_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of st_purchase
-- ----------------------------

-- ----------------------------
-- Table structure for `st_stock`
-- ----------------------------
DROP TABLE IF EXISTS `st_stock`;
CREATE TABLE `st_stock` (
  `stock_id` varchar(10) NOT NULL COMMENT '库存编号',
  `goods_id` varchar(10) NOT NULL COMMENT '商品编号',
  `inventory_quantity` int(11) NOT NULL COMMENT '库存数量',
  PRIMARY KEY (`stock_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of st_stock
-- ----------------------------

-- ----------------------------
-- Table structure for `st_supplier`
-- ----------------------------
DROP TABLE IF EXISTS `st_supplier`;
CREATE TABLE `st_supplier` (
  `supplier_id` varchar(10) NOT NULL COMMENT '供货商编号',
  `supplier_name` varchar(100) NOT NULL COMMENT '供货商名称',
  `contacts` varchar(100) NOT NULL COMMENT '供货商联系人',
  `telephone` varchar(20) NOT NULL COMMENT '供货商电话',
  `address` varchar(100) NOT NULL COMMENT '供货商地址',
  PRIMARY KEY (`supplier_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of st_supplier
-- ----------------------------
