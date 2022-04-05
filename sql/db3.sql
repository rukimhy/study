#20210617
show databases;
use testdb;
show tables;
select * from testdb.customer;
select * from product;
select * from o_order;

select * from customer, product;

select c_id, c.name, age, grade, job, c.money, p_no, 
p.name, stock, p.money, company from customer as c, product as p;

select * from customer group by grade;
select count(*), job from customer group by job;
select count(age), job from customer group by job;
select count(c_id), job from customer group by job;
select max(money), job from customer group by job;
select min(money), job from customer group by job;
select sum(age), job from customer group by job;
select avg(age), job from customer group by job;

#문제 - 적립금이 10원 이상인 사람만 직업별 평균나이를 구하시오.
select avg(age), job from customer where money>=10 group by job;

#평균나이가 20대인 직업
select avg(age), job from customer where money>=10 group by job
having avg(age) >= 20 and avg(age)<30;

select avg(age) as age2, job from customer where money >= 10 group by job
having age2 >= 20 and age2 < 30;

select avg(age) age2, job from customer where money >= 10 group by job
having age2 between 20 and 30;

select avg(age) age2, job from customer where money >= 10 group by job
having (age2 div 10) = 2;

#문제1 - 고객들을 등급별로 적립금이 가장 많은 사람을 찾으시오.
select max(money), name from customer group by grade;

#문제2 - 제조사별로 재고가 가장 많은 제품을 찾으시오.
#문제3 - 제조사별로 가격이 3000원 이상인 제품의 개수를 구하시오.
#문제4 - 제조사별로 재고가 3천개 이상인 제품을 모두 구하시오.
#문제5 - 제조사별로 재고총액(재고량x가격)이 가장 큰 순으로 조회하시오.

#--------------------
select c_id, o.p_no, count, address, name 
from o_order as o, product as p where o.p_no = p.p_no;

select c_id, o.p_no, count, address, name 
from o_order as o inner join product as p on o.p_no = p.p_no;

select * from o_order as o inner join customer as c on o.c_id = c.c_id;
select * from customer as c inner join o_order as o on o.c_id = c.c_id;
select * from customer as c left join o_order as o on o.c_id = c.c_id;
select * from customer as c right join o_order as o on o.c_id = c.c_id;

#주문테이블, 고객테이블, 상품테이블 조인하기
select * from customer as c 
inner join o_order as o on o.c_id = c.c_id
inner join product as p on o.p_no = p.p_no;

select c.name, p.name, p.money, o.count, o.address, o.o_date 
from customer as c, o_order as o, product as p
where c.c_id = o.c_id and o.p_no = p.p_no;
