#20210701
show databases;
show tables;

grant all privileges on testdb.users to user01@localhost;
grant select, insert, update on testdb.customer to user01@localhost with grant option;

show grants for user01@localhost;
revoke update on testdb.customer from user01@localhost;
show grants for user01@localhost;

create role role_1;
grant select, insert, update on testdb.customer to role_1;
grant role_1 to user02@localhost;
show grants for user02@localhost;
