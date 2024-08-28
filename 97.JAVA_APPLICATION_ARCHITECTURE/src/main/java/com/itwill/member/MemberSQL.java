package com.itwill.member;
/*
insert into member(member_id,member_password,member_name,member_address,member_age,member_married,member_regdate) values('aaaa','aaaa','김경수','부산시 영도구',37,'F',sysdate);
update member set  member_password='0000', member_name='김변경', member_address='제주도민', member_age=20,member_married='T',member_regdate=sysdate where member_id='aaaa';
delete from member where member_id='aaaa';
select member_id,member_password,member_name,member_address,member_age,member_married,member_regdate from member where member_id='bbbb';
select member_id,member_password,member_name,member_address,member_age,member_married,member_regdate from member;
*/
public class MemberSQL {
	public static final String  MEMBER_INSERT=
	"insert into member(member_id,member_password,member_name,member_address,member_age,member_married,member_regdate) values(?,?,?,?,?,?,sysdate)";
	public static final String  MEMBER_UPDATE=
	"update member set member_password=?,member_name=?,member_address=?,member_age=?,member_married=? where member_id=?";
	public static final String  MEMBER_DELETE=
	"delete from member where member_id=?";
	public static final String  MEMBER_SELECT_BY_ID=
	"select member_id,member_password,member_name,member_address,member_age,member_married,member_regdate from member where member_id=?";
	public static final String  MEMBER_SELECT_ALL=
	"select member_id,member_password,member_name,member_address,member_age,member_married,member_regdate from member";
}
