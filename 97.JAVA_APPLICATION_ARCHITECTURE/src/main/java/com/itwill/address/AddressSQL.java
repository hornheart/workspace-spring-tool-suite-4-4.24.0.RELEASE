package com.itwill.address;

public class AddressSQL {
	public static final String ADDRESS_INSRET ="insert into address values(address_no_seq.nextval,?,?,?)";
	public static final String ADDRESS_UPDATE ="update address set name=?,phone=?,address=? where no=?";
	public static final String ADDRESS_SELECT_BY_NO = "select * from address where no=?";
	public static final String ADDRESS_SELECT_ALL = "select * from address";
	public static final String ADDRESS_DELETE_BY_NO = "delete from address where no=?";
}
