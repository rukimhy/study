#20210624
select @@block_encryption_mode;
create table encrypt_test(
	txt char(200)
);
set @skey = 'abcd';
select @skey;
select aes_encrypt('hello world', @skey);
select hex(aes_encrypt('hello world', @skey));

insert into encrypt_test(txt) values (HEX(AES_ENCRYPT('hello world', @skey)));
select txt, AES_DECRYPT(UNHEX(txt), @skey) from encrypt_test;

set @@block_encryption_mode = 'aes-256-cbc';
set @key = SHA2('1234', 512);
select @key;
set @iv = random_bytes(16);
insert into encrypt_test(txt) values (hex(aes_encrypt('안녕하세요', @key, @iv)));
select txt from encrypt_test;
select txt, aes_decrypt(unhex(txt), @key, @iv) from encrypt_test;

select * from users;
desc users;
alter table users add column phone varchar(100);
insert into users(id, pw, name, phone) values ('user3', sha1('user3pw'), 'park', hex(aes_encrypt('010-1234-1234', @key, @iv)));
select id, pw, name, aes_decrypt(unhex(phone), @key, @iv) from users;

create table t1 (a int);
create view v1 as select * from t1 where a < 2;
create view v2 as select * from v1 where a > 0 with local check option;
create view v3 as select * from v1 where a > 0 with cascaded check option;
insert into v2 values(2);
insert into v3 values(2);
insert into v3 values(1);
select * from t1;

select * from customer;
select * from product;
select * from o_order;

#1. 고객 테이블에서 고객의 아이디, 이름, 적립금을 조회하는 뷰
create view view1 as select c_id, name, money from customer;
select * from view1;

#2. 고객 테이블에서 고객등급이 vip, gold인 사람을 조회하는 뷰
create view view2 as select * from customer where grade like 'vip' or grade like 'gold';
select * from customer where grade in ('vip', 'gold');
select * from view2;

#3. 나이가 25세이상인 고객만 조회하는 뷰
create view view3 as select * from customer where age >= 25;
select * from view3;

#4. 제품 테이블에서 제조업체별로 제품의 종류가 몇 개인지 조회하는 뷰
create view view4 as select company, count(name) as '수량' from product group by company;
select * from view4;

#5. 적립금이 1000원이상인 고객을 조회하는 뷰
create view view5 as select * from customer where money >= 1000;
select * from view5;

#6. 배송지가 서울인 고객의 아이디, 이름, 직업을 조회하는 뷰
create view view6 as select c.c_id, c.name, c.job from customer as c inner join o_order as o on o.c_id = c.c_id where o.address like '서울시%';
select * from view6;

#7. 재고량이 2500개 미만인 제품명과 제조업체를 조회하는 뷰
create view view7 as select name, company from product where stock < 2500;
select * from view7;

#8. 제조업체별로 총 재고량을 조회하는 뷰
create view view8 as select company, sum(stock) from product group by company;
select * from view8;

#9. 주문한 제품의 제품명 ,주문수량, 주문고객 아이디, 고객이름, 배송지, 주문일자를 조회하는 뷰
create view view9 as select o.o_no, o.count, c.c_id, c.name, o.address, o_date from customer as c inner join o_order as o on o.c_id = c.c_id;
select * from view9;

#10. 고객별 주문수를 조회하는 뷰
create view view10 as select c.name, count(c.name) from customer as c inner join o_order as o on o.c_id = c.c_id group by c.name;
select * from view10;

#11. 고객별 주문총액을 조회하는 뷰
create view view11 as select c.name, sum(p.money * o.count) as 주문총액 from customer as c inner join o_order as o on o.c_id = c.c_id inner join product as p on o.p_no = p.p_no group by c.name;
select * from view11;

#12. 제품별 총 판매 수량과 단가, 총 판매금액을 조회하는 뷰
create view view12 as select p.name, sum(o.count) as '판매수량', p.money as '단가', sum(p.money * o.count) as '총판매금액' from customer as c inner join o_order as o on o.c_id = c.c_id inner join product as p on o.p_no = p.p_no group by p.name;
select * from view12;

#13. 누적판매량이 가장 많은 제품명을 조회하는 뷰


#14. 나이대별(20대, 30대)로 가장 많이 팔린 제품명, 단가, 제조사를 조회하는 뷰
#15. 월별 총 매출액(모든 상품의 판매수량x단가)을 조회하는 뷰
#16. 직업별로 가장 좋아하는 제품명을 조회하는 뷰

#-----------------------------

select host, user from mysql.user;
create user 'user01'@localhost identified by 'user01pw';
create user user02@localhost identified by 'user02pw';
drop user 'user02'@localhost;
create user 'user02'@localhost identified by 'user02pw';
create user 'user03'@localhost identified by 'user03pw';
create user 'user04'@localhost identified by 'user04pw';
create user 'user05'@localhost identified by 'user05pw';

show tables;
grant all privileges on testdb.users to user01@localhost;
grant select on testdb.customer to user01@localhost;
show grants for user01@localhost;

grant select on testdb.users to user02@localhost;
grant insert on testdb.users to user03@localhost;
grant update on testdb.users to user04@localhost;
grant delete on testdb.users to user05@localhost;