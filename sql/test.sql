create database mytestdb;
use mytestdb;
create table member(
	id varchar(10) primary key,
    name varchar(15) not null, 
    password varchar(100) not null,
    age int check(age >= 20) not null,
    email varchar(30)
);
insert into member values('kim', '김모씨', sha1('kimpw'), 22, 'kim@naver.com');
insert into member values('park', '박모씨', sha1('parkpw'), 23, 'park@gmail.com');
insert into member values('lee', '이모씨', sha1('leepw'), 25, 'lee@naver.com');
insert into member values('kim2', '김모씨2', sha1('kim2pw'), 27, 'kim2@gmail.com');
insert into member values('hong', '홍모씨', sha1('hongpw'), 20, 'hong@hanmail.net');
insert into member values('lee2', '이순신', sha1('lee2pw'), 35, null);
insert into member values('jang', '장보고', sha1('jangpw'), 39, null);
insert into member values('mbc', '마봉춘', sha1('mbcpw'), 29, 'mbc@mbc.com');
insert into member values('sbs', '스브스', sha1('sbspw'), 31, 'sbs@sbs.com');
insert into member values('kbs', '코버스', sha1('kbspw'), 33, 'kbs@kbs.com');

#=================================================#
create table encrypt_test(
	txt char(200)
);

set @skey = 'abcd';
select @skey;
select aes_encrypt('hello', @skey);
select hex(aes_encrypt('hello', @skey));

insert into encrypt_test(txt) values (HEX(AES_ENCRYPT('hello', @skey)));
select txt, AES_DECRYPT(UNHEX(txt), @skey) from encrypt_test;

set @@block_encryption_mode = 'aes-256-cbc';
set @key = SHA2('1234', 512);
select @key;
set @iv = random_bytes(16);
insert into encrypt_test(txt) values (hex(aes_encrypt('hello', @key, @iv)));
select txt from encrypt_test;
select txt, aes_decrypt(unhex(txt), @key, @iv) from encrypt_test;

#=================================================#
create view v1 as select id, name, email from member;
select * from v1;

create view v2 as select id, name from member where age < 25;
select * from v2;

create view v3 as select id, age from member where name like '김%';
select * from v3;

create view v4 as select id, name, email from member where email like '%@gmail.com';
select * from v4;

#=======================================
create user 'apple'@localhost identified by 'applepw';
create user 'banana'@10.20.30.40 identified by 'bananapw';
create user 'carrot'@'%' identified by 'carrotpw';
select host, user from mysql.user;


grant all privileges on mytestdb.member to apple@localhost;
grant select, insert on mytestdb.member to banana@10.20.30.40;
grant select on mytestdb.member to carrot@'%';
show grants for apple@localhost;
show grants for banana@10.20.30.40;
show grants for carrot@'%';

#====================================
alter table member add column phone varchar(15) unique;
desc member;