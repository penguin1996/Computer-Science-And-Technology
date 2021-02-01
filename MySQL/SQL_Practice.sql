#MySQL8.0
create schema if not exists study default char set = utf8mb4;

use study;

drop table if exists student;

create table student (
	sid varchar(10) primary key  comment "学生编号",
    sname varchar(16) comment "学生姓名",
    sage varchar(16) comment "学生出生年龄",
    ssex varchar(10) comment "学生性别"
) engine = Innodb default charset = utf8mb4 comment = "学生表";

insert into student values('01' , '赵雷' , '1990-01-01' , '男');
insert into student values('02' , '钱电' , '1990-12-21' , '男');
insert into student values('03' , '孙风' , '1990-12-20' , '男');
insert into student values('04' , '李云' , '1990-12-06' , '男');
insert into student values('05' , '周梅' , '1991-12-01' , '女');
insert into student values('06' , '吴兰' , '1992-01-01' , '女');
insert into student values('07' , '郑竹' , '1989-01-01' , '女');
insert into student values('09' , '张三' , '2017-12-20' , '女');
insert into student values('10' , '李四' , '2017-12-25' , '女');
insert into student values('11' , '李四' , '2012-06-06' , '女');
insert into student values('12' , '赵六' , '2013-06-13' , '女');
insert into student values('13' , '孙七' , '2014-06-01' , '女');

drop table if exists course;

create table course(
	cid varchar(10) primary key comment "课程编号",
    cname varchar(16) comment "课程名称",
    tid varchar(10) comment "教师编号"
) engine = InnoDB default charset = utf8mb4 comment = "课程表";

insert into course values('01' , '语文' , '02');
insert into course values('02' , '数学' , '01');
insert into course values('03' , '英语' , '03');

drop table if exists teacher;

create table teacher (
	tid varchar(10) primary key comment "教师编号",
    tname varchar(16) comment "教师姓名"
) engine = InnoDB default charset = utf8mb4 comment = "教师表";

insert into teacher values('01' , '张三');
insert into teacher values('02' , '李四');
insert into teacher values('03' , '王五');

drop table if exists score;

create table score (
	sid varchar(10) comment "分数编号",
    cid varchar(10) comment "课程编号",
    score int(16) comment "分数"
) engine = InnoDB default charset = utf8mb4 comment "分数表";

insert into score values('01' , '01' , 80);
insert into score values('01' , '02' , 90);
insert into score values('01' , '03' , 99);
insert into score values('02' , '01' , 70);
insert into score values('02' , '02' , 60);
insert into score values('02' , '03' , 80);
insert into score values('03' , '01' , 80);
insert into score values('03' , '02' , 80);
insert into score values('03' , '03' , 80);
insert into score values('04' , '01' , 50);
insert into score values('04' , '02' , 30);
insert into score values('04' , '03' , 20);
insert into score values('05' , '01' , 76);
insert into score values('05' , '02' , 87);
insert into score values('06' , '01' , 31);
insert into score values('06' , '03' , 34);
insert into score values('07' , '02' , 89);
insert into score values('07' , '03' , 98);

#1.查询" 01 "课程比" 02 "课程成绩高的学生的信息及课程分数
#分析：由于需要查询学生的全部信息，所以需要从分数表中查询到符合条件的分数,然后通过left join/right join进行组合
#右连接
select * from student RIGHT JOIN (
    select t1.sid, courseA, courseB 
    from
          (select sid, score as courseA from score where score.cid = '01') as t1, 
          (select sid, score as courseB from score where score.cid = '02') as t2
    where t1.sid = t2.sid AND t1.courseA > t2.courseB
)r 
on student.sid = r.sid;

#左连接
select * from  (
    select t1.sid, courseA, courseB 
    from
          (select sid, score as courseA from score where score.cid = '01') as t1, 
          (select sid, score as courseB from score where score.cid = '02') as t2
    where t1.sid = t2.sid AND t1.courseA > t2.courseB
) r 
LEFT JOIN student
ON student.sid = r.sid;

#查询同时存在“01”课程和“02”课程的情况
select * from 
    (select * from score where score.cid = '01') as t1, 
    (select * from score where score.cid = '02') as t2
where t1.sid = t2.sid;

#查询存在"01"课程但可能不存在"02"课程的情况(不存在显示null)
#这一道就是明显需要使用join的情况了，02可能不存在，即为left join的右侧或right join 的左侧即可
#左连接
select * from 
(select * from score where score.cid = '01') as t1
left join 
(select * from score where score.cid = '02') as t2
on t1.sid = t2.sid;
#右连接
select * from 
(select * from score where score.cid = '02') as t2
right join 
(select * from score where score.cid = '01') as t1
on t1.sid = t2.sid;

#查询不存在" 01 "课程但存在" 02 "课程的情况
select * from score
where score.sid not in (
    select sid from score 
    where score.cid = '01'
) 
AND score.cid= '02';





