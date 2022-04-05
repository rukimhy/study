create database testdb2;
use testdb2;


# 06
select * from information_schema.schemata where SCHEMA_NAME = 'testdb2';
select * from information_schema.tables where table_schema = 'testdb2';

# 08
create table STUDENT(
	Sno int primary key,
    Sname varchar(30),
    Year int constraint year_chk check(Year<=4),
    Dept varchar(30)
);

create table COURSE(
	Cno varchar(30) primary key,
    Cname varchar(30)
);

drop table enrol;
create table ENROL(
	Sno int,
    Cno varchar(30),
    Grade varchar(30),
    Midterm int,
    Final int,
    FOREIGN KEY (Sno) REFERENCES STUDENT (Sno),
    FOREIGN KEY (Cno) REFERENCES COURSE (Cno)
);

# 09
insert into STUDENT(Sno, Sname, Year, Dept) values(100, '나수영', 4, '컴퓨터');
insert into STUDENT(Sno, Sname, Year, Dept) values(200, '이찬수', 3, '전기');
insert into STUDENT(Sno, Sname, Year, Dept) values(300, '정기태', 1, '컴퓨터');
insert into STUDENT(Sno, Sname, Year, Dept) values(400, '송병길', 4, '컴퓨터');
insert into STUDENT(Sno, Sname, Year, Dept) values(500, '박종화', 2, '산공');
select * from student;

insert into COURSE(Cno, Cname) values('C123', '프로그래밍');
insert into COURSE(Cno, Cname) values('C312', '자료구조');
insert into COURSE(Cno, Cname) values('C324', '화일구조');
insert into COURSE(Cno, Cname) values('C413', '데이타베이스');
insert into COURSE(Cno, Cname) values('E412', '반도체');
select * from course;

insert into ENROL(Sno, Cno, Grade, Midterm, Final) values(100, 'C413', 'A', 90, 95);
insert into ENROL(Sno, Cno, Grade, Midterm, Final) values(100, 'E412', 'A', 95, 95);
insert into ENROL(Sno, Cno, Grade, Midterm, Final) values(200, 'C123', 'B', 85, 80);
insert into ENROL(Sno, Cno, Grade, Midterm, Final) values(300, 'C312', 'A', 90, 95);
insert into ENROL(Sno, Cno, Grade, Midterm, Final) values(300, 'C324', 'C', 75, 75);
insert into ENROL(Sno, Cno, Grade, Midterm, Final) values(300, 'C413', 'A', 95, 90);
insert into ENROL(Sno, Cno, Grade, Midterm, Final) values(400, 'C312', 'A', 90, 95);
insert into ENROL(Sno, Cno, Grade, Midterm, Final) values(400, 'C324', 'A', 95, 90);
insert into ENROL(Sno, Cno, Grade, Midterm, Final) values(400, 'C413', 'B', 80, 85);
insert into ENROL(Sno, Cno, Grade, Midterm, Final) values(400, 'E412', 'C', 65, 75);
insert into ENROL(Sno, Cno, Grade, Midterm, Final) values(500, 'C312', 'B', 85, 80);
select * from enrol;

# 10
select s.Sname, s.Dept, c.Cname from STUDENT as s inner join ENROL as e on s.Sno = e.Sno inner join COURSE as c on c.Cno = e.Cno where e.Grade = 'A'; 

# 11
start transaction;
delete from ENROL where Sno=500;
delete from STUdent where Sno=500;
rollback;
commit;

# 12
select Midterm, Final from ENROL order by Midterm desc limit 1;

# 13
create index idx_cname on COURSE(Cname);
show index from course;

# 14
select * from information_schema.schemata where schema_name = 'testdb2';
select * from information_schema.tables where table_schema = 'testdb2';

# 15
drop view view01;
create view view01 as select Dept, count(Dept) as '학과별 학생수' from student group by Dept; 
select * from view01;

# 16
create view view02 as select c.Cno, c.Cname, count(e.Cno) as '학생수' from STUDENT as s inner join ENROL as e on s.Sno = e.Sno inner join COURSE as c on c.Cno = e.Cno group by c.Cno; 
select * from view02;

# 17
create view view03 as select s.Sno, s.Sname from STUDENT as s inner join ENROL as e on s.Sno = e.Sno where e.Grade = 'B'; 
select * from view03;

# 18
create view view04 as select Dept, count(Dept) as '학생수' from STUDENT where Dept = '컴퓨터';
select * from view04;

# 19
create view view05 as select e.Sno, s.Sname from STUDENT as s inner join ENROL as e on s.Sno = e.Sno inner join COURSE as c on c.Cno = e.Cno where c.Cname = '데이타베이스'; 
select * from view05;

# 20
create view view06 as select s.Sname, c.Cname, e.Grade from STUDENT as s inner join ENROL as e on s.Sno = e.Sno inner join COURSE as c on c.Cno = e.Cno where s.Sname = '나수영';
select * from view06;

# 21
drop view view07;
create view view07 as select e.Sno, s.Sname from STUDENT as s inner join ENROL as e on s.Sno = e.Sno inner join COURSE as c on c.Cno = e.Cno where c.Cname='데이타베이스' and e.Grade = 'A';
select * from view07;