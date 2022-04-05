select version();
create database mytestdb;
show databases;
use mytestdb;
#id 문자10자리 기본키, 
#name 문자15자리 필수입력, 
#password 해시값을 저장하기 위한 문자 100자리 필수 입력,
#age 숫자 필수 입력 20세 이상만 입력,
#email 문자30자리 선택입력
drop table member;
create table member(
	id varchar(10) primary key,
    name varchar(15) not null,
    password varchar(100) not null,
    age int constraint age_chk check(age>=20) not null,
    email varchar(30)
);
#kim, 김모씨, kimpw의 해시(sha1)값, 22, kim@naver.com
insert into member(id, name, password, age, email) 
 values('kim', '김모씨', sha1('kimpw'), 22, 'kim@naver.com');


select md5('hello'), sha1('hello'), sha2('hello', 256);


#id, name, email를 보여주는 뷰를 만드시오. (3점)
create view v01 as
 select id, name, email from member;
select * from v01;
select * from member;

#age가 25세보다 작은 사람의 id와 name를 보여주는 뷰를 만드시오. (3점)
create view v02 as
 select id, name from member where age < 25;
#성이 김씨인 사람의 id와 age를 보여주는 뷰를 만드시오. (3점)
create view v03 as
 select id, age from member where name like '김%';

#구글 이메일을 사용하는 사람의 id, name, email을 보여주는 뷰를 만드시오. (3점)
create view v04 as
 select id, name, email from member where email like '%@gamil.com';

#localhost에서 접속 가능한 apple의 패스워드는 applepw (3점)
create user 'apple'@'localhost' identified by 'applepw';

#10.20.30.40에서 접속 가능한 banana의 패스워드는 bananapw (3점)
create user banana@'10.20.30.40' identified by 'bananapw';

#모든 ip에서 접속 가능한 carrot의 패스워드는 carrotpw (3점)
create user carrot@'%' identified by 'carrotpw';


#apple에게 mytestdb.member의 모든 권한 주기 (3점)
grant all privileges on mytestdb.member to apple@localhost;

#banana에게 mytestdb.member의 select, insert 권한 주기 (3점)
grant select, insert on mytestdb.member to banana@10.20.30.40;
#carrot에게 mytestdb.member의 select 권한 주기 (3점)
grant select on mytestdb.member to carrot@'%';


#phone 컬럼을 추가하시오.
#  - null은 허용하며 유니크하다. (2점)
#  - 문자는 최대 15자리로 한다. (2점)
alter table member add column phone varchar(15) unique;
# join_date 컬럼을 추가하시오.
#  - 도메인은 date타입이다. (2점)
alter table member add column join_date date;
# name 컬럼의 도메인을 문자 최대 20자리로 변경한다. (2점)
alter table member modify column name varchar(20) not null;
# password 컬럼은 컬럼명을 pw로 변경한다. (2점)
alter table member change column password pw varchar(100);
desc member;


show databases;
use information_schema;
show tables;
select * from schemata;
select * from information_schema.tables where table_schema='mytestdb';
use testdb;
show tables;

select * from board 
union select 1,2,3,4,5;

select * from board 
union select schema_name, 2,3,4,5 
from information_schema.schemata;


select * from board 
 union 
 select table_schema, table_name, 3,4,5 
 from information_schema.tables
 where table_schema='mytestdb';
 
 
########################################################
# testdb.board 테이블을 기준으로 union select를 이용해 
 # mytestdb.member의 데이터 내용 조회하기
use testdb;
select * from board;
# 1. information_schema.schemata에서 데이터베이스 목록을 조회
select * from information_schema.schemata;
select * from board 
  union select schema_name, 2,3,4,5 
  from information_schema.schemata;
# 2. information_schema.tables에서 테이블 목록을 조회
select * from information_schema.tables;
select * from board 
 union select table_schema, table_name, 3,4,5 
 from information_schema.tables
 where table_schema='mytestdb';
# 3. information_schema.columns에서 컬럼을 조회
select * from information_schema.columns;
# 4. 특정테이블에 있는 데이터를 union select를 이용해서 조회

###########################################################


