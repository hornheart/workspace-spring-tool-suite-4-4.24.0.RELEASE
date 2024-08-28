DROP TABLE OrderItem2 CASCADE CONSTRAINTS;
DROP TABLE Orders2 CASCADE CONSTRAINTS;
DROP TABLE Cart2 CASCADE CONSTRAINTS;
DROP TABLE Product2 CASCADE CONSTRAINTS;
DROP TABLE UserInfo2 CASCADE CONSTRAINTS;

CREATE TABLE UserInfo2(
		UserId                        		VARCHAR2(100)		 NULL ,
		Password                      		VARCHAR2(100)		 NULL ,
		Name                          		VARCHAR2(100)		 NULL ,
		Email                         		VARCHAR2(100)		 NULL 
);


CREATE TABLE Product2(
		PNo                           		NUMBER(10)		 NULL ,
		PName                         		VARCHAR2(50)		 NULL ,
		PPrice                        		NUMBER(10)		 NULL ,
		PImage                        		NUMBER(10)		 NULL ,
		PDesc                         		VARCHAR2(200)		 NULL ,
		PClickCount                   		VARCHAR2(10)		 NULL 
);

DROP SEQUENCE Product2_PNo_SEQ;

CREATE SEQUENCE Product2_PNo_SEQ NOMAXVALUE NOCACHE NOORDER NOCYCLE;

CREATE TRIGGER Product2_PNo_TRG
BEFORE INSERT ON Product2
FOR EACH ROW
BEGIN
IF :NEW.PNo IS NOT NULL THEN
  SELECT Product2_PNo_SEQ.NEXTVAL INTO :NEW.PNo FROM DUAL;
END IF;
END;


CREATE TABLE Cart2(
		CartNo                        		NUMBER(10)		 NULL ,
		CartQty                       		NUMBER(10)		 NULL ,
		UserId                        		VARCHAR2(100)		 NULL ,
		PNo                           		NUMBER(10)		 NULL 
);

DROP SEQUENCE Cart2_CartNo_SEQ;

CREATE SEQUENCE Cart2_CartNo_SEQ NOMAXVALUE NOCACHE NOORDER NOCYCLE;

CREATE TRIGGER Cart2_CartNo_TRG
BEFORE INSERT ON Cart2
FOR EACH ROW
BEGIN
IF :NEW.CartNo IS NOT NULL THEN
  SELECT Cart2_CartNo_SEQ.NEXTVAL INTO :NEW.CartNo FROM DUAL;
END IF;
END;


CREATE TABLE Orders2(
		ONo                           		NUMBER(10)		 NULL ,
		ODesc                         		VARCHAR2(100)		 NULL ,
		ODate                         		DATE		 DEFAULT sysdate		 NULL ,
		OPrice                        		NUMBER(10)		 NULL ,
		UserId                        		VARCHAR2(100)		 NULL 
);

DROP SEQUENCE Orders2_ONo_SEQ;

CREATE SEQUENCE Orders2_ONo_SEQ NOMAXVALUE NOCACHE NOORDER NOCYCLE;

CREATE TRIGGER Orders2_ONo_TRG
BEFORE INSERT ON Orders2
FOR EACH ROW
BEGIN
IF :NEW.ONo IS NOT NULL THEN
  SELECT Orders2_ONo_SEQ.NEXTVAL INTO :NEW.ONo FROM DUAL;
END IF;
END;


CREATE TABLE OrderItem2(
		OiNo                          		NUMBER(10)		 NULL ,
		OiQty                         		NUMBER(10)		 NULL ,
		PNo                           		NUMBER(10)		 NULL ,
		ONo                           		NUMBER(10)		 NULL 
);

DROP SEQUENCE OrderItem2_OiNo_SEQ;

CREATE SEQUENCE OrderItem2_OiNo_SEQ NOMAXVALUE NOCACHE NOORDER NOCYCLE;

CREATE TRIGGER OrderItem2_OiNo_TRG
BEFORE INSERT ON OrderItem2
FOR EACH ROW
BEGIN
IF :NEW.OiNo IS NOT NULL THEN
  SELECT OrderItem2_OiNo_SEQ.NEXTVAL INTO :NEW.OiNo FROM DUAL;
END IF;
END;



ALTER TABLE UserInfo2 ADD CONSTRAINT IDX_UserInfo2_PK PRIMARY KEY (UserId);

ALTER TABLE Product2 ADD CONSTRAINT IDX_Product2_PK PRIMARY KEY (PNo);

ALTER TABLE Cart2 ADD CONSTRAINT IDX_Cart2_PK PRIMARY KEY (CartNo);
ALTER TABLE Cart2 ADD CONSTRAINT IDX_Cart2_FK0 FOREIGN KEY (UserId) REFERENCES UserInfo2 (UserId);
ALTER TABLE Cart2 ADD CONSTRAINT IDX_Cart2_FK1 FOREIGN KEY (PNo) REFERENCES Product2 (PNo);

ALTER TABLE Orders2 ADD CONSTRAINT IDX_Orders2_PK PRIMARY KEY (ONo);
ALTER TABLE Orders2 ADD CONSTRAINT IDX_Orders2_FK0 FOREIGN KEY (UserId) REFERENCES UserInfo2 (UserId);

ALTER TABLE OrderItem2 ADD CONSTRAINT IDX_OrderItem2_PK PRIMARY KEY (OiNo);
ALTER TABLE OrderItem2 ADD CONSTRAINT IDX_OrderItem2_FK0 FOREIGN KEY (PNo) REFERENCES Product2 (PNo);
ALTER TABLE OrderItem2 ADD CONSTRAINT IDX_OrderItem2_FK1 FOREIGN KEY (ONo) REFERENCES Orders2 (ONo);

