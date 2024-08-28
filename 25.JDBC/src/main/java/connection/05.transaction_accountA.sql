

drop table accountA;
create table accountA( acc_no number(20)  primary key
                                  ,acc_name varchar2(20)
				  ,acc_balance number(10));
insert into accountA values(10000,'이종범',350000);
insert into accountA values(20000,'박찬호',670000);
insert into accountA values(30000,'서재웅',235000);
insert into accountA values(40000,'하리수',110000);
insert into accountA values(50000,'김경호',900000);
insert into accountA values(60000,'고길동',23600);
commit;









