#20210708
show databases;
use testdb;
show tables;
drop table board;
create table board(
	no int primary key auto_increment,
    title varchar(20) not null,
    memo text,
    writer varchar(20) not null,
    wtime datetime not null
);
desc board;
select * from board;
insert into board(title, memo, writer, wtime) values('테스트', '테스트입니다.', '홍길동', now());
insert into board(title, memo, writer, wtime) values('테스트123', '테스트123입니다.', '가나다', now());
insert into board(title, memo, writer, wtime) values('제목', '내용입니다.', '나다라', now());
insert into board(title, memo, writer, wtime) values('안녕하세요', '안녕하세요 내용입니다.', '다라마', now());
insert into board(title, memo, writer, wtime) values('가나다', '안녕하세요 가나다입니다.', '가나다라', now());

use information_schema;
show tables;
select * from schemata; #데이터베이스 목록
select * from tables where table_schema='testdb'; #테이블 목록
select * from columns where table_schema='testdb' and table_name='board';

select 1,2,3 union select 10, 20, 30;
select * from testdb.board where title like "%테%" union select 'a', 'b', 'c', 'd', 'e';
select * from testdb.board where title like '%테스트%' union select schema_name, 1, 2, 3,4  from information_schema.schemata;