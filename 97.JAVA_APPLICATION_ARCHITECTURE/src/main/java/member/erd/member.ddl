DROP TABLE member CASCADE CONSTRAINTS;

CREATE TABLE member(
		member_id                     		VARCHAR2(20)		 NULL ,
		member_password               		VARCHAR2(20)		 NOT NULL,
		member_name                   		VARCHAR2(50)		 NOT NULL,
		member_address                		VARCHAR2(100)		 NULL ,
		member_age                    		NUMBER(3)		 DEFAULT 0		 NULL ,
		member_married                		CHAR(1)		 DEFAULT 'F'		 NULL ,
		member_regdate                		DATE		 DEFAULT sysdate		 NULL 
);



ALTER TABLE member ADD CONSTRAINT IDX_member_PK PRIMARY KEY (member_id);

