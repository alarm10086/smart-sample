-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `username` varchar(50) DEFAULT NULL,
  `password` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', 'admin', '$shiro1$SHA-256$500000$vEgQXP9//FEW/4AKvslZkQ==$5G2JPj8umTRl9rf7zc7t9V2ke7a2sgNPGIlqJyqh/EE=');

-- ----------------------------
-- Table structure for product
-- ----------------------------
DROP TABLE IF EXISTS `product`;
CREATE TABLE `product` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `product_type_id` bigint(20) NOT NULL,
  `name` varchar(100) NOT NULL,
  `code` char(5) NOT NULL,
  `price` int(10) NOT NULL,
  `description` text,
  `picture` varchar(100),
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of product
-- ----------------------------
INSERT INTO `product` VALUES ('1', '1', 'iPhone 3g', 'MP001', '3000', 'iPhone 3g 移动电话', '');
INSERT INTO `product` VALUES ('2', '1', 'iPhone 3gs', 'MP002', '3500', 'iPhone 3gs 移动电话', '');
INSERT INTO `product` VALUES ('3', '2', 'iPad 2', 'TC001', '3000', 'iPad 2 平板电脑', '');
INSERT INTO `product` VALUES ('4', '1', 'iPhone 4', 'MP003', '4000', 'iPhone 4 移动电话', '');
INSERT INTO `product` VALUES ('5', '1', 'iPhone 4s', 'MP004', '4500', 'iPhone 4s 移动电话', '');
INSERT INTO `product` VALUES ('6', '2', 'iPad 3', 'TC002', '3500', 'iPad 3 平板电脑', '');
INSERT INTO `product` VALUES ('7', '1', 'iPhone 5', 'MP005', '5000', 'iPhone 5 移动电话', '');
INSERT INTO `product` VALUES ('8', '2', 'iPad mini', 'TC003', '2000', 'iPad mini 平板电脑', '');
INSERT INTO `product` VALUES ('9', '2', 'iPad 4', 'TC004', '4000', 'iPad 4 平板电脑', '');
INSERT INTO `product` VALUES ('10', '1', 'iPhone 5c', 'MP006', '3500', 'iPhone 5c 移动电话', '');
INSERT INTO `product` VALUES ('11', '1', 'iPhone 5s', 'MP007', '5500', 'iPhone 5s 移动电话', '');
INSERT INTO `product` VALUES ('12', '2', 'iPad air', 'TC005', '3500', 'iPad air 平板电脑', '');

-- ----------------------------
-- Table structure for product_type
-- ----------------------------
DROP TABLE IF EXISTS `product_type`;
CREATE TABLE `product_type` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) NOT NULL,
  `description` text,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of product_type
-- ----------------------------
INSERT INTO `product_type` VALUES ('1', 'Mobile Phone', '移动电话');
INSERT INTO `product_type` VALUES ('2', 'Tablet Computer', '平板电脑');