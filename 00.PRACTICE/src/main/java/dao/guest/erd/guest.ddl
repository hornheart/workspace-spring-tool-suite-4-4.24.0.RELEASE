/**********************************/
/* Table Name: guest */
/**********************************/
CREATE TABLE guest(
		guest_no                      		NUMBER(10)		 NOT NULL,
		guest_name                    		VARCHAR2(50)		 NOT NULL,
		guest_date                    		DATE		 NOT NULL,
		guest_email                   		VARCHAR2(50)		 NULL ,
		guest_homepage                		VARCHAR2(50)		 NULL ,
		guest_title                   		VARCHAR2(100)		 NOT NULL,
		guest_content                 		VARCHAR2(4000)		 NOT NULL
);

COMMENT ON TABLE guest is 'guest';
COMMENT ON COLUMN guest.guest_no is 'guest_no';
COMMENT ON COLUMN guest.guest_name is 'guest_name';
COMMENT ON COLUMN guest.guest_date is 'guest_date';
COMMENT ON COLUMN guest.guest_email is 'guest_email';
COMMENT ON COLUMN guest.guest_homepage is 'guest_homepage';
COMMENT ON COLUMN guest.guest_title is 'guest_title';
COMMENT ON COLUMN guest.guest_content is 'guest_content';



ALTER TABLE guest ADD CONSTRAINT IDX_guest_PK PRIMARY KEY (guest_no);

