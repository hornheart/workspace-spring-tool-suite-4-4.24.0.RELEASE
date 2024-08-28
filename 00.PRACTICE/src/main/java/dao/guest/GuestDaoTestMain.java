package dao.guest;

import java.util.Date;

public class GuestDaoTestMain {

	public static void main(String[] args) throws Exception{
		GuestDao guest=new GuestDao();
		Date now = new Date();
		
		System.out.println("1.insert");
		guest.insert(new Guest (1,"jee-eun",now,"guard@naver.com","http://","방명록 사용법","방명록 사용법"));
		
		System.out.println(">> insert row count:"+
				guest.insert(new Guest (2,"PARK",now,"guard@naver.com","http://","방명록 사용법","방명록 사용법")));
//		System.out.println("2.updateByNo");
//		System.out.println(">> update row count:"+
//				guestDao(new Guest(43, "사삼변경", "444-3333", "제주")));
//		System.out.println("3.deleteByNo");
//		System.out.println(">> delete row count:"+guestDao.deleteByNo(2));
//		System.out.println("4.selectByNo");
//		System.out.println(guestDao.selectByNo(43));
//		System.out.println("5.selectAll");
//		System.out.println(guestDao.selectAll());

	}

}