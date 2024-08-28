--member table  CRUD sql

--insert

insert into member(member_id,member_password,member_name,member_address,member_age,member_married,member_regdate)
                values('aaaa','aaaa','김경수','부산시 영도구',37,'F',sysdate);
insert into member(member_id,member_password,member_name,member_address,member_age,member_married,member_regdate)
                values('bbbb','bbbb','김경우','서울시 도봉구',23,'F',sysdate);
insert into member(member_id,member_password,member_name,member_address,member_age,member_married,member_regdate)
                values('cccc','cccc','김경미','서울시  강남구',47,'T',sysdate);
                
--update pk

update member set 
    member_password='0000',
    member_name='김변경',
    member_address='제주도민',
    member_age=20,
    member_married='T',
    member_regdate=sysdate
where member_id='aaaa';

--delete pk
delete from member where member_id='aaaa';
--select pk
select member_id,member_password,member_name,member_address,member_age,member_married,member_regdate from member where member_id='bbbb';
--select All
select member_id,member_password,member_name,member_address,member_age,member_married,member_regdate from member;
commit;

desc member;


                
                
                