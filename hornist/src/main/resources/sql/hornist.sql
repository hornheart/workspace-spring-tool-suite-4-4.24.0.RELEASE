drop table hornist;

CREATE TABLE HORNIST 
(
  NO NUMBER NOT NULL 
, REG_DATE DATE DEFAULT sysdate 
, WEATHER VARCHAR2(100) DEFAULT 'SUN' 
, CONTENTS VARCHAR2(2000) 
, TITLE VARCHAR2(100) 
, CONSTRAINT HORNIST_PK PRIMARY KEY 
  (
    NO 
  )
  ENABLE 
);


insert into hornist values(1,sysdate,'CLOUDY','content1','title1');