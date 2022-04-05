# 20210610
show databases;
use testdb;
create table users(
	id varchar(20) primary key,
    pw varchar(100) not null,
    name varchar(3) not null
);
alter table users modify name varchar(30) not null;
desc users;
insert into users(id, pw, name) values('user1', sha1('user1pw'), 'kim');
insert into users(id, pw, name) values('user2', sha1('user2pw'), 'lee');
select * from users where id='user1' and pw=sha1('user1pw');

create table book(
	bookid int,
    bookname varchar(20),
    publisher varchar(20),
    price int,
    primary key (bookid)
);

alter table book modify column bookname varchar(30) not null;
alter table book add column memo text;
alter table book change column price bookprice int;
alter table book drop column publisher;
alter table book rename book2;
desc book2;

create table customer(
	c_id varchar(10) not null,
    name varchar(20) not null,
    age int,
    grade varchar(10) not null,
    job varchar(20) not null,
    money int default 0
);
alter table customer add constraint chk_grade check(grade in ('silver', 'gold', 'vip'));
alter table customer modify column c_id varchar(10) primary key;
alter table customer modify column grade varchar(10) default 'silver';
insert into customer values('apple', '정소화', 20, 'gold', '학생', 1000);
insert into customer values('banana', '김선우', 25, 'vip', '간호사', 2500);
insert into customer values('carrot', '고명석', 28, 'gold', '교사', 4500);
insert into customer values('orange', '김용욱', 22, 'silver', '학생', 0);
insert into customer values('melon', '성원용', 35, 'gold', '회사원', 5000);
insert into customer values('peach', '오형준', null, 'silver', '의사', 300);
insert into customer values('pear', '채광주', 31, 'silver', '회사원', 500);
select * from customer;

create table product(
	p_no varchar(5) primary key,
    name varchar(20) not null,
    stock int default 0,
    money int default 0,
    company varchar(20) not null
);
insert into product values('p01', '그냥만두', 5000, 4500, '대한식품');
insert into product values('p02', '매운쫄면', 2500, 5500, '민국푸드');
insert into product values('p03', '쿵떡파이', 3600, 2600, '한빛제과');
insert into product values('p04', '맛난초콜릿', 1250, 2500, '한빛제과');
insert into product values('p05', '얼큰라면', 2200, 1200, '대한식품');
insert into product values('p06', '통통우동', 1000, 1550, '민국푸드');
insert into product values('p07', '달콤비스킷', 1650, 1500, '한빛제과');
select * from product;

create table o_order(
	o_no varchar(5) primary key,
    c_id varchar(10) not null,
    p_no varchar(5) not null,
    count int default 0,
    address varchar(20) not null,
    o_date date not null,
	foreign key(c_id) references customer(c_id) on delete cascade,
    foreign key(p_no) references product(p_no) on delete cascade
);
insert into o_order values('o01', 'apple', 'p03', 10, '서울시 마포구', '2019-01-01');
insert into o_order values('o02', 'melon', 'p01', 5, '인천시 계양구', '2019-01-10');
insert into o_order values('o03', 'banana', 'p06', 45, '경기도 부천시', '2019-01-11');
insert into o_order values('o04', 'carrot', 'p02', 8, '부산시 금정구', '2019-02-01');
insert into o_order values('o05', 'melon', 'p06', 36, '경기도 용인시', '2019-02-20');
insert into o_order values('o06', 'banana', 'p01', 19, '충청북도 보은군', '2019-03-02');
insert into o_order values('o07', 'apple', 'p03', 22, '서울시 영등포구', '2019-03-15');
insert into o_order values('o08', 'pear', 'p02', 50, '강원도 춘천시', '2019-04-10');
insert into o_order values('o09', 'banana', 'p04', 15, '전라남도 목포시', '2019-04-11');
insert into o_order values('o10', 'carrot', 'p03', 20, '경기도 안양시', '2019-05-22');
select * from o_order;
desc o_order;
select distinct c_id from o_order;
select * from o_order where o_date >= '2019-03-01' and o_date <='2019-03-31';
select * from customer where age >= 30 and grade <> 'gold';
select * from o_order where o_date between '2019-02-01' and '2019-02-28';
select * from customer where age >= 20 order by age desc limit 1;
select * from customer where name like '김%';
select * from customer where name like '_소화';
select * from product where name like '%면%';
select * from product order by company, name;
select count(*) as '김씨 수' from customer where name like '김%';