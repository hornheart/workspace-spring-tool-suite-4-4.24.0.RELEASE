insert into product values(10000,'새우깡','새우맛이좋아요',2000,sysdate);
insert into product values(10001,'감자깡','감자맛이구수해요',1800,to_date('2024/07/01','YYYY/MM/DD'));
insert into product values(10002,'꼬북칩','초코맛이좋아요',3300,sysdate-1);
insert into product values(10003,'새우칩','새우맛이비려요',4700,sysdate-2);

select * from product;
select no,name,short_desc,price,ipgo_date from product;