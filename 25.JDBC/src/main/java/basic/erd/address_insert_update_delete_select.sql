--insert
insert into address values(address_no_seq.nextval,'김경호','123-6779','서울시 여러분');
--pk update
update address set name='김변경',phone='999=9999',address='부산시 여러분' where no=1;
--pk delete
delete from address where no=3;
--pk select
select * from address where no=1;
--select all
select * from address;