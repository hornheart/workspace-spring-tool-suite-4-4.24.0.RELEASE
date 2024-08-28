package dao.address;

public class AddressDaoTestMain {

	public static void main(String[] args) throws Exception{
		AddressDao addressDao=new AddressDao();
		System.out.println("1.insert");
		System.out.println(">> insert row count:"+
				addressDao.insert(new Address(0,"김우미","000-0000","대구")));
		System.out.println("2.updateByNo");
		System.out.println(">> update row count:"+
				addressDao.updateByNo(new Address(43, "사삼변경", "444-3333", "제주")));
		System.out.println("3.deleteByNo");
		System.out.println(">> delete row count:"+addressDao.deleteByNo(2));
		System.out.println("4.selectByNo");
		System.out.println(addressDao.selectByNo(43));
		System.out.println("5.selectAll");
		System.out.println(addressDao.selectAll());
		
		

	}

}
