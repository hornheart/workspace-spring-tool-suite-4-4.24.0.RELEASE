package dao.address.fourth;

import java.util.List;

public class AddressDao4TestMain {

	public static void main(String[] args)throws Exception {
		 AddressDao4 addressDao4=new AddressDao4();
		 System.out.println("1.insert");
		 int rowCount=addressDao4.insert(new Address(0, "김소미", "888-0000", "대전시 유성구"));
		 System.out.println(rowCount);
		 
		 System.out.println("2.updateByNo");
		 rowCount=addressDao4.updateByNo(new Address(10,"체인지","000-1111","LA"));
		 System.out.println(rowCount);
		 rowCount=addressDao4.updateByNo(new Address(11,"체민지","888-9999","CA"));
		 System.out.println(rowCount);
		 System.out.println("3.deleteByNo");
		 rowCount=addressDao4.deleteByNo(4);
		 System.out.println(rowCount);
		 System.out.println("4.selectByNo");
		 Address findAddress1= addressDao4.selectByNo(11);
		 System.out.println(findAddress1);
		 Address findAddress2=addressDao4.selectByNo(30);
		 System.out.println(findAddress2);
		 Address findAddress3=addressDao4.selectByNo(999);
		 System.out.println(findAddress3);
		 System.out.println("5.selectAll");
		 List<Address> addressList=addressDao4.selectAll();
		 System.out.println(addressList);
	}

}
