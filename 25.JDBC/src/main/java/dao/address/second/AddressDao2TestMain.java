package dao.address.second;

public class AddressDao2TestMain {

	public static void main(String[] args)throws Exception {
		 AddressDao2 addressDao2=new AddressDao2();
		 System.out.println("1.insert");
		//addressDao.insert("이소라","122-8989","대전 성심당");
		//addressDao.insert("삼소라","333-4444","대구 뭉티기");
		 addressDao2.insert("뿔소라","899-8989","서울");
		 System.out.println("2.updateByNo");
		 addressDao2.updateByNo(10,"체인지","000-1111","LA");
		 addressDao2.updateByNo(11,"체민지","888-9999","CA");
		 System.out.println("3.deleteByNo");
		 addressDao2.deleteByNo(4);
		 addressDao2.deleteByNo(5);
		 addressDao2.deleteByNo(6);
		 System.out.println("4.selectByNo");
		 addressDao2.selectByNo(11);
		 addressDao2.selectByNo(30);
		 addressDao2.selectByNo(999);
		 System.out.println("5.selectAll");
		 addressDao2.selectAll();
	}

}
