CREATE TABLE `print_shop_cart` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `user_id` int(11) NOT NULL COMMENT '用户id',
  `good_id` int(2) NOT NULL COMMENT '商品id',
  `supplier_id` int(11) DEFAULT '0' COMMENT '供应商id',
  `count` int(11) NOT NULL COMMENT '购买数量',
  `operation_json` text NOT NULL COMMENT '图片操作信息',
  `operation_count` int(3) DEFAULT '0' COMMENT '操作图片数量',
  `create_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '更新时间',
  `version` int(11) DEFAULT '0' COMMENT '本条记录操作的最新版本号',
  `del_flag` tinyint(1) DEFAULT '0' COMMENT '删除标记(0-否，1-是)',
  PRIMARY KEY (`id`),
  KEY `idx_user_id` (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=1005 DEFAULT CHARSET=utf8 COMMENT='购物车信息表';



ALTER TABLE `print`.`print_loan` 
ADD COLUMN `coupon_user_id_list` varchar(255) NULL COMMENT '优惠券ids。|11|22|33|' AFTER `coupon_user_id`;

ALTER TABLE `print`.`print_pay_logs` 
ADD COLUMN `coupon_user_id_list` varchar(255) NULL COMMENT '优惠券id' AFTER `coupon_user_id`;

update print_loan set coupon_user_id_list = CONCAT('|',coupon_user_id,'|') 
where coupon_user_id is not null;
update print_pay_logs set coupon_user_id_list = CONCAT('|',coupon_user_id,'|') 
where coupon_user_id is not null;
