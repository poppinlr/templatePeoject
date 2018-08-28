DROP TABLE IF EXISTS `access_data`;
CREATE TABLE `access_data` (
  `access_data_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(45) NOT NULL COMMENT '权限名',
  `comment` varchar(255) NOT NULL COMMENT '权限描述',
  `url` varchar(100) NOT NULL COMMENT '权限地址',

  `created_at` datetime NOT NULL,
  `modified_at` datetime NOT NULL,
  `created_by` bigint(20) DEFAULT NULL,
  `modified_by` bigint(20) DEFAULT NULL,
  `active` tinyint(1) NOT NULL,

  PRIMARY KEY (`access_data_id`),
  UNIQUE KEY `access_uk_1` (`url`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

DROP TABLE IF EXISTS `company_data`;
CREATE TABLE `company_data` (
  `company_data_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `company_code` varchar(45) NOT NULL COMMENT '公司代码',
  `company_name` varchar(255) NOT NULL COMMENT '公司名称',
  `address` varchar(255) DEFAULT NULL COMMENT '联系地址',
  `phone` varchar(45) DEFAULT NULL COMMENT '联系电话',

  `created_at` datetime NOT NULL,
  `modified_at` datetime NOT NULL,
  `created_by` bigint(20) DEFAULT NULL,
  `modified_by` bigint(20) DEFAULT NULL,
  `active` tinyint(1) NOT NULL,

  PRIMARY KEY (`company_data_id`),
  UNIQUE KEY `company_uk_1` (`company_code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

DROP TABLE IF EXISTS `role_data`;
CREATE TABLE `role_data` (
  `role_data_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(45) NOT NULL COMMENT '角色名',
  `comment` varchar(255) NOT NULL COMMENT '角色描述',

  `created_at` datetime NOT NULL,
  `modified_at` datetime NOT NULL,
  `created_by` bigint(20) DEFAULT NULL,
  `modified_by` bigint(20) DEFAULT NULL,
  `active` tinyint(1) NOT NULL,

  PRIMARY KEY (`role_data_id`),
  UNIQUE KEY `role_uk_1` (`name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

DROP TABLE IF EXISTS `role_to_access_data`;
CREATE TABLE `role_to_access_data` (
  `role_to_access_data_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `role_data_id` bigint(20) NOT NULL COMMENT 'fk',
  `access_data_id` bigint(20) NOT NULL COMMENT 'fk',

  PRIMARY KEY (`role_to_access_data_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

DROP TABLE IF EXISTS `user_data`;
CREATE TABLE `user_data` (
  `user_data_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `username` varchar(45) NOT NULL COMMENT '系统登录账号',
  `password` VARBINARY(45) NOT NULL COMMENT '系统登录密码',
  `name` varchar(45) NOT NULL COMMENT '系统显示名',
  `phone` varchar(45) NOT NULL COMMENT '联系电话',
  `gender` tinyint(1) NOT NULL COMMENT '性别',
  `company_data_id` bigint(20) NOT NULL COMMENT 'fk',
  `role_data_id` bigint(20) NOT NULL COMMENT 'fk',

  `created_at` datetime NOT NULL,
  `modified_at` datetime NOT NULL,
  `created_by` bigint(20) DEFAULT NULL,
  `modified_by` bigint(20) DEFAULT NULL,
  `active` tinyint(1) NOT NULL,

  PRIMARY KEY (`user_data_id`),
  UNIQUE KEY `user_uk_1` (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;