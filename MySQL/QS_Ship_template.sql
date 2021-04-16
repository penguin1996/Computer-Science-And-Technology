use print;

drop table if exists print_ship_money_template;

create table print_ship_money_template (
	id int(11) primary key auto_increment comment "运费模板id",
	master_flag tinyint(1) not null comment "逻辑主表标识[1-是，0-不是]" default 1,
    template_name varchar(200) not null comment "运费模板名" default 0,
    create_name varchar(200) not null comment "模板创建人" default 0,
    master_id int(11) not null comment "子记录对应的主id" default 0,
    area varchar(200) not null comment "区域" default 0,
    ship_money int(11) not null comment "运费" default 0,
    create_time timestamp not null default CURRENT_TIMESTAMP comment "运费模板创建时间",
    update_time timestamp not null default CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP comment "运费模板更新时间",
    version int(11) not null comment "最新版本号",
    del_flag tinyint not null comment "删除标记(0-否,1-是)"
    ) engine = Innodb default charset = utf8mb4 comment = "运费模板表";
    
alter table print_ship_money_template add column create_name varchar(36) not null comment "运费模板创建人";
alter table print_ship_money_template add column use_flag int(11) not null comment "不等于0则表示有人使用";

alter table print_ship_money_template modify column create_time timestamp;
alter table print_ship_money_template alter column create_time set default 'CURRENT_TIMESTAMP';
alter table print_ship_money_template change column eare area varchar(200) not null comment "区域";
alter table print_ship_money_template alter column master_flag set default 1;

#修改默认值
alter table print_ship_money_template alter column use_flag set default 0;

select * from print_ship_money_template where id = 17 or master_id = 17;

select id, template_name,area,ship_money from print_ship_money_template where id = 17 or master_id = 17;

select id,template_name from print_ship_money_template where master_flag = 1;

select area,ship_money,create_name,template_name from print_ship_money_template;

desc print_ship_money_template;

select u.id as uid, l.id,l.create_time,l.update_time,l.del_flag,l.version,l.loan_no,u.nick_name user_name,l.goods_name,l.recipient,l.phone,l.province,l.city,l.area,l.address,l.money,l.discount_money, l.status,l.is_refund,l.tracking_number,l.courier_company,l.channel,l.out_loan_no,l.supplier_status,c.name channel_name from print_user u
        right join (select * from print_loan where del_flag = 0) l on u.id = l.uid
        left join (select id,name, code from print_channel where del_flag = 0) c on l.channel = c.code ;