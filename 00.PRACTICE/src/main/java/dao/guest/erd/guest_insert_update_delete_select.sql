insert into guest values(guest_no_seq.nextva, '김경호','sysdate','guard@naver.com','http://','방명록 사용법','방명록처럼 사용하시면 됩니다.' );

delete from guest where guest_no=1;
update guest set guest_name='name수정',
					guest_email='email수정',
					guest_homepage='homepage수정',
					guest_title='title수정',
					guest_content='content수정;
where guest_no = 3;
					
select * from guest;
select * from guest where guest_no =3;
desc guest;
commit;					