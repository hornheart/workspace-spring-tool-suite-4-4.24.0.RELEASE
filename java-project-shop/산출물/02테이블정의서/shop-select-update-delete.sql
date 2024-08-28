/********************회원************************/


/********************제품************************/

--상품리스트
select * from PRODUCT;
--상세보기
select * from PRODUCT where p_no=1; 


/********************카트************************/
--guard1 멤버한사람의  카트에 제품번호 존재여부
select count(*)  as p_count from cart c join userinfo u on c.userid=u.userid where u.userid='guard1' and c.p_no=1;

--guard1 멤버한사람의 카트아이템리스트
select * from cart c join product p
on c.p_no=p.p_no
where userid='guard1';

--guard1님 카트아이템1개삭제
delete from cart where cart_no=7;


--guard1님 카트아이템전체삭제
delete from cart where userid='guard1';

--guard1님 카트에있는  cart_no 1번 수량 3개로수정
update cart set cart_qty = 3 where cart_no=11;

--guard1 카트에 있는 1번제품의 수량증가
update cart set cart_qty=cart_qty+2 where userid='guard1' and p_no=1;



/*******************주문****************************/
--guard1 멤버한사람의 주문목록
--select * from orders where userid='guard1';


select * from orders o  
join order_item oi  
on o.o_no=oi.o_no 
join product p
on oi.p_no=p.p_no
where o.userid='guard1';

