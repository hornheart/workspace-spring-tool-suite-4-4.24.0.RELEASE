package dao.guest;

public class GuestSQL {

	public static final String GUEST_INSERT="insert into guest values(guest_no_seq.nextval,?,sysdate,?,?,?,?)";
	public static final String GUEST_UPDATE="update guest set guest_name=?, guest_email=?, guest_title=?";
	public static final String GUEST_DELETE_BY_NO="delete from guest where guest_no=?";
	
}
