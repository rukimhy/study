#기본적인 SQL 명령어 - select, insert, update, delete, create, drop, alter
#key - 기본키, 외래키
show databases;
use testdb;
show tables;
create table user(
	id varchar(20) primary key,
    pw varchar(100) not null,
    name varchar(10) not null,
    email varchar(30)
);
insert into user(id, pw, name, email) values('user1', sha1('user1pw'), 'kim', 'kim@gmail.com');\
select * from user;

#select의 조건 - where, order by, group by, join
select * from user where id like 'user%' order by name;

#데이터사전
show databases;
use information_schema;
show tables;
select * from schemata;
select table_schema, table_name from information_schema.tables;
select schema_name from information_schema.schemata;

#뷰 만들기
use testdb;
create view v01 as select * from user where id like 'user%' order by name;
select * from v01;

#인덱스
show index from user;
create index idx_name on user(name);
alter table user drop index idx_name;
select * from statistics where table_name='user';

#트랜잭션
#a통장 -1만원, b통장 +1만원
start transaction;
select * from user;
delete from user where id='user1';
rollback;
commit;