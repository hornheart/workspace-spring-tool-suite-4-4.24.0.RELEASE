/**********************cart insert************************/
--guard1님이 1번2개,3번1개,7번3개 제품담기
insert into cart(cart_no,userId,p_no,cart_qty) values(cart_cart_no_seq.nextval,'guard1',1,2); 
insert into cart(cart_no,userId,p_no,cart_qty) values(cart_cart_no_seq.nextval,'guard1',3,1); 
insert into cart(cart_no,userId,p_no,cart_qty) values(cart_cart_no_seq.nextval,'guard1',7,3); 
--guard2님이 1번2개,3번1개 제품담기
insert into cart(cart_no,userId,p_no,cart_qty) values(cart_cart_no_seq.nextval,'guard2',1,2); 
insert into cart(cart_no,userId,p_no,cart_qty) values(cart_cart_no_seq.nextval,'guard2',3,1); 