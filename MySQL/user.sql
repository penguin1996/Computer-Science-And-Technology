create schema if not exists oauth default char set = utf8mb4;

create schema if not exists spring_security default char set = utf8mb4;

use spring_security;

drop table if exists user;

create table user (
	id integer(10) primary key  comment "学生编号" auto_increment,
    username varchar(16) comment "学生姓名" not null,
    password varchar(16) comment "学生出生年龄" not null,
    birthday date comment "学生生日" not null
) engine = Innodb default charset = utf8mb4 comment = "用户表";

use spring_security;

insert into user values(1,"zc","123456","1995-12-22");

select * from user;

use oauth;

drop table if exists print_ship_money_template;

create table print_ship_money_template (
	id int(11) primary key auto_increment comment "运费模板id",
	master_flag tinyint(1) not null comment "逻辑主表标识[1-是，0-不是]" default 1,
    template_name varchar(200) not null comment "运费模板名" default 0,
    create_name varchar(200) not null comment "模板创建人" default 0,
    master_id int(11) not null comment "子记录对应的主id" default 0,
    eare varchar(200) not null comment "区域" default 0,
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

#修改默认值
alter table print_ship_money_template alter column use_flag set default 0;

select * from print_ship_money_template;

desc print_ship_money_template;