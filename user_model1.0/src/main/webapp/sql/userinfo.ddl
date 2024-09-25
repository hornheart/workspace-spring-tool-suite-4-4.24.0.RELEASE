/**********************************/
/* Table Name: USERINFO */
/**********************************/
CREATE TABLE USERINFO(
		USERID                        		VARCHAR2(100)		 NOT NULL,
		PASSWORD                      		VARCHAR2(100)		 NULL ,
		NAME                          		VARCHAR2(100)		 NULL ,
		EMAIL                         		VARCHAR2(100)		 NULL 
);





ALTER TABLE USERINFO ADD CONSTRAINT IDX_USERINFO_PK PRIMARY KEY (USERID);

