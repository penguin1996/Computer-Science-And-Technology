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

#查询平均成绩大于等于 60 分的同学的学生编号和学生姓名和平均成绩
#分析，我们可以根据学生编号将成绩分组，对分组的score求平均值，最后在选取结果中利用AVG函数进行求平均值并判断是否大于等于60即可
#一般的联合搜索
select student.sid,sname,avgScore from student,(
    select sid, AVG(score) as avgScore from score 
    GROUP BY sid
    HAVING AVG(score)> 60
    )r
where student.sid = r.sid;
#左连接
select s.sid,avgSocre,sname from(
select sid, AVG(score) as avgSocre from score  
GROUP BY sid 
HAVING AVG(score)> 60
)r left join 
(select student.sid, student.sname from
student)s on s.sid = r.sid;
#右连接
select student.sid, student.sname, r.avgScore from student right join(
      select sid, AVG(score) AS avgScore from score
      GROUP BY sid
      HAVING AVG(score)> 60
)r on student.sid = r.sid;
#注意：我们必须给AVG函数计算的结果给一个别名avgScore

#查询在socre表存在成绩的学生信息
select DISTINCT student.*
from student,score
where student.sid=score.sid;

#查询所有同学的学生编号,学生姓名,所有课程的成绩综合
#联合查询（不会显示没有选课的学生）
select student.sid, student.sname,r.coursenumber,r.scoresum
from student,
(select score.sid, sum(score.score) as scoresum, count(score.cid) as coursenumber from score 
group by score.sid) r
where student.sid = r.sid;
#通过join查询可以显示没有选课的学生（没有选课的学生为NULL）
select s.sid, s.sname,r.coursenumber,r.scoresum
from (
    (select student.sid,student.sname 
    from student
    )s 
    left join 
    (select 
        score.sid, sum(score.score) as scoresum, count(score.cid) as coursenumber
        from score 
        group by score.sid
    )r 
   on s.sid = r.sid
);

#查有成绩的学生信息
#exists
select * from student 
where exists (select score.sid from score where student.sid = score.sid);

#in
select * from student
where student.sid in (select score.sid from score);

#查询姓氏是李的老师的数量
select count(*) as nameNum
from teacher
where tname like '李%';

#查询学习过张三老师课程的学生信息
#多表联合查询
select student.* from student,teacher,course,score
where 
    student.sid = score.sid 
    and course.cid=score.cid 
    and course.tid = teacher.tid 
    and tname = '张三';
    
#查询没有学习所有课程的同学信息
#因为有学生什么课都没有选，反向思考，先查询选了所有课的学生，再选择这些人之外的学生.
select * from student
where student.sid not in (
  select score.sid from score
  group by score.sid
  having count(score.cid)= (select count(cid) from course)
);

#查询至少有一门课程与学号为“01”的同学所学相同的同学的信息
select * from student 
where student.sid in (
    select score.sid from score 
    where score.cid in(
        select score.cid from score 
        where score.sid = '01'
    )
);

#查询和" 01 "号的同学学习的课程完全相同的其他同学的信息
#待做

#查询没有学过张三老师的任一门课的学生姓名
#嵌套查询
select * from student
    where student.sid not in(
        select score.sid from score where score.cid in(
            select course.cid from course where course.tid in(
                select teacher.tid from teacher where tname = "张三"
            )
        )
    );
#多表联合查询(存在问题)
select * from student
where student.sid not in(
    select score.sid from score,course,teacher 
    where
        score.cid = course.cid
        and course.tid = teacher.tid
        and teacher.tname= "张三"
);

#查询两门及其以上不及格课程的同学的学号，姓名及其平均成绩
select student.sid, student.sname,b.avgScore
from student RIGHT JOIN
(select sid, AVG(score) as avgScore from score
    where sid in (
              select sid from score 
              where score<60 
              GROUP BY sid 
              HAVING count(score)>1)
    GROUP BY sid) b on student.sid=b.sid;

#检索" 01 "课程分数小于 60，按分数降序排列的学生信息
select student.*, score.score from student, score
where student.sid = score.sid
and score.score < 60
and cid = "01"
ORDER BY score.score DESC;

#按平均成绩从高到低显示所有学生的所有课程的成绩以及平均成绩
select * from score 
left join (
    select sid,avg(score) as avgScore from score 
    group by sid
    )r 
on score.sid = r.sid
order by avgScore desc;

#查询各科成绩最高分，最低分和平均分
#显示形式：课程 ID，课程 name，最高分，最低分，平均分，及格率，中等率，优良率，优秀率
#及格为>=60，中等为：70-80，优良为：80-90，优秀为：>=90
#要求输出课程号和选修人数，查询结果按人数降序排列，若人数相同，按课程号升序排列
select score.cid,
max(score.score) as 最高分,
min(score.score) as 最低分,
AVG(score.score) as 平均分,
count(*) as 选修人数,
sum(case when score.score>=60 then 1 else 0 end )/count(*) as 及格率,
sum(case when score.score>=70 and score.score<80 then 1 else 0 end )/count(*) as 中等率,
sum(case when score.score>=80 and score.score<90 then 1 else 0 end )/count(*) as 优良率,
sum(case when score.score>=90 then 1 else 0 end )/count(*) as 优秀率 
from score
GROUP BY score.cid
ORDER BY count(*) DESC , score.cid ASC;

#按各科成绩进行排序，并显示排名，分数重复是保留名次空缺及同样的分数也分前后名次
/*select  a.sid, a.cid, a.score, count(b.score)+1 as 排名
from (score as a )
left join score as b 
on a.score < b.score and a.cid = b.cid
group by a.cid, a.sid, a.score
order by a.cid, rank ASC;*/

#查询学生总成绩，并进行排名，总分重复不保留名次空缺
#SQL中的变量
set @crank=0;
select q.sid, total, @crank := (@crank +1) as 名次 from(
select score.sid, sum(score.score) as total from score
group by score.sid
order by total desc)q;

/*
统计各科成绩各分数段人数：课程编号，课程名称，[85-100]，[70-85]，[60-70]，[0-60] 及所占百分比
*/
select course.cid,course.cname, 
sum(case when score.score<=100 and score.score>85 then 1 else 0 end) as "[85-100]",
sum(case when score.score<=100 and score.score>85 then 1 else 0 end)/count(*)*100 as "百分比%",
sum(case when score.score<=85 and score.score>70 then 1 else 0 end) as "[70-85]",
sum(case when score.score<=85 and score.score>70 then 1 else 0 end)/count(*)*100 as "百分比%",
sum(case when score.score<=70 and score.score>60 then 1 else 0 end) as "[60-70]",
sum(case when score.score<=70 and score.score>60 then 1 else 0 end)/count(*)*100 as "百分比%",
sum(case when score.score<=60 and score.score>0 then 1 else 0 end) as "[0-60]",
sum(case when score.score<=60 and score.score>0 then 1 else 0 end)/count(*)*100 as "百分比%"
from score left join course
on score.cid = course.cid
group by score.cid;

/*
查询各科成绩钱三名的记录
*/
#方式一：计算比自己分数大的记录数量，如果小于3就select，
#然后对所有select到的结果按照分数和课程编号进行排序
#group by之后是不可以取limit
select * from score
 where (
	select count(*) from score as s
    where score.cid = s.cid and score.score < s.score
 ) < 3 order by cid asc, score.score desc;
#方式二：自身左交，即先用自己交自己，条件为
select * from score s left join score ss on s.cid = ss.cid and s.score < ss.score
order by s.cid,s.score;

#查询1990年出生的学生名单
select * from student
where year(student.sage) = 1990;

#按照出生年月日，当前月日 < 出生年月的则年龄减一
select student.sid as 学生编号 , student.sname as 学生姓名,
TIMESTAMPDIFF(YEAR,student.sage,CURDATE()) as 学生年龄 from student;

#查询上周过生日的学生
select * from student where weekofyear(student.sage) = weekofyear(CURDATE()) - 1;

#查询本周过生日的学生
select * from student where weekofyear(student.sage) = weekofyear(CURDATE());

#查询下周过生日的学生
select * from student where weekofyear(student.sage) = weekofyear(CURDATE())+1;

#查询上个月过生日的学生
select * from student where month(student.sage) = month(curdate()) - 1;

#查询本月过生日的学生
select * from student where month(student.sage) = month(curdate());

#查询下个月生日的学生
select * from student where month(student.sage) = month(curdate()) + 1;