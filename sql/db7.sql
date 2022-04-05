#20210715

use testdb;
select * from board;
#1. information_schema.schemata에서 데이터베이스 목록을 조회
select * from information_schema.schemata;
#2. information_schema.tables에서 테이블 목록을 조회
select * from information_schema.tables;
#3. information_schema.columns에서 컬럼을 조회
select * from information_schema.columns where table_name="board";
#4. 특정테이블에 있는 데이터를 union select를 이용해서 조회
select * from board union select catalog_name, schema_name, default_character_set_name, default_collation_name, sql_path from information_schema.schemata;