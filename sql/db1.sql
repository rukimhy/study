# 2021-06-03 database 실습
show databases;
drop database testdb;
create database testdb;
use testdb;
show tables;
create table mytable1(
	no int,
    name varchar(10),
    phone varchar(20)
);
desc mytable1;
select * from mytable1;
insert into mytable1(no, name, phone) values(1, 'kim', '010-1111-2222');
insert into mytable1 values(2, 'lee', '010-2222-3333');
insert into mytable1(name, phone, no) values('park', '010-3333-4444', 3);
insert into mytable1(no, name) values(4, 'choi');

select * from mytable1 where no=1;
select * from mytable1 where no > 1;
select * from mytable1 where no>1 and no<4;

create table mytable2(
	no int primary key, #null 허용 안함. 중복 허용 안함.
    name varchar(10) not null, 
    phone varchar(20) unique, #null 허용함. 중복 허용 안함.
    address varchar(50)
);
insert into mytable2 values(1, 'kim', '010-1111-2222', 'seoul');
insert into mytable2 values(2, 'lee', '010-2222-3333', 'seoul');
insert into mytable2(no, name, address) values(3, 'hong', 'seoul');
select * from mytable2;
select name, address from mytable2;
select distinct address from mytable2;
select count(*) from mytable2;
select count(phone)+1 from mytable2;
select now();
select substring("20210603170730", 1, 4);
select concat(substring("20210603170730", 1, 4), '년 ' , 'def');

set @date1 = '20210603170730';
select @date1;