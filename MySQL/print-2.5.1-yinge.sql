##print_loan
alter table print_loan add column intercept_reason varchar(255) not null default 0 comment "当印鸽拦截该订单时则显示拦截原因" after goods_name;

alter table print_loan add column customize_no varchar(100) not null default 0 comment "定制单号，印鸽制作完成，当页面跳转回哇印时会携带该参数" after intercept_reason;

alter table print_loan add column redo_order varchar(16) not null default 0 comment "订单是否被重大打(0 = 默认，1=重打订单)" after customize_no;

##print_goods
alter table print_goods add column proprietary_flag tinyint(2) not null comment "哇印自商品标识[1-自营，0-合作]" default 1 after goods_name; 

alter table print_goods add column partner_goods_id varchar(120) not null comment "合作商品ID" default 0 after proprietary_flag; 

##print_loan_goods
ALTER TABLE `print`.`print_loan_goods` CHANGE COLUMN `synthesis_list` `picture_merge_result_list` TEXT NULL DEFAULT NULL COMMENT '照片合成结果图传给三方' ;

##print_loan_address_history
drop table if exists print_loan_address_history;
 
create table print_loan_address_history (
	id int(11) primary key auto_increment comment "订单收货地址记录id",
    loan_no varchar(255) not null default 0 comment "订单号",
    phone varchar(50) not null default 0 comment "收货人手机号",
    recipient varchar(50) not null default 0 comment "收件人",
    province varchar(255)  not null default 0 comment "收货省份",
    city varchar(255)  not null default 0 comment "收货市",
    area varchar(255)  not null default 0 comment "收货地区[区，县等]",
    address varchar(255)  not null default 0 comment "收货详细地址",
    history_time timestamp not null default CURRENT_TIMESTAMP comment "当前地址的历史时间",
    latest_flag tinyint(2) not null default 0 comment "最新地址标识[1-是，0-否]",
	create_time timestamp not null default CURRENT_TIMESTAMP comment "上一次修改地址时间，如果是第一个地址则为创建时间",
    update_time timestamp not null default CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP comment "修改地址时间",
    version int(11) not null comment "最新版本号",
    del_flag tinyint not null comment "删除标记(0-否,1-是)"
)engine=InnoDB default char set = utf8mb4 comment="收货地址修改记录表";

