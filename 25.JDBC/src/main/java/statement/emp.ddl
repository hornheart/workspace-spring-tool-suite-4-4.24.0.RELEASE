DROP TABLE EMP CASCADE CONSTRAINTS;

CREATE TABLE EMP(
		EMPNO                         		NUMBER(4)		 NOT NULL,
		ENAME                         		VARCHAR2(10)		 NULL ,
		JOB                           		VARCHAR2(9)		 NULL ,
		MGR                           		NUMBER(4)		 NULL ,
		HIREDATE                      		DATE		 NULL ,
		SAL                           		NUMBER(7)		 NULL ,
		COMM                          		NUMBER(7)		 NULL ,
		DEPTNO                        		NUMBER(2)		 NULL 
);



ALTER TABLE EMP ADD CONSTRAINT IDX_EMP_PK PRIMARY KEY (EMPNO);

