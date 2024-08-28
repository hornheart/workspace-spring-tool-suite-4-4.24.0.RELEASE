package com.itwill.address;
/*
 * - 주소록관리 비즈니스로직(업무)을 수행하는 클래스
 * - GUI객체(스윙,서블릿,JSP)에서 직접접근(메쏘드호출)하는 클래스
 * - AdderssDao객체 를 이용해서 데이타에 접근하는 클래스
 * 
 * ########### AddressService 클래스 작성#############
1. AddressService.java 클래스생성 
2. AddressDao객체를 멤버필드로선언
3. AddressService클래스생성자에서 AddressDao객체생성
4. 클라이언트요구사항분석시 도출된 단위업무당 한개의 메쏘드생성
5. AddressService클래스 메쏘드기술(인자 ,반환타입)
6. 메쏘드구현
	ex>
		public class AddressService{
			private AddressDao addressDao;
			public AddressService(){
				addressDao=new AddressDao();
			}
			
			
			 * 주소록쓰기
			 
			public int addressWrite(Address newAddress) 
					throws Exception{
				<< AddressDao객체사용>>
			}
			
			 * 주소록번호로 1개보기
			 
			public Address addressDetail(int no) throws Exception{
				
			}
			
			 * 주소록번호로삭제
			public int addressDelete(int no) 
					throws Exception{
				
			}
			
			 * 주소록 리스트보기
			 
			public List<Address> addressList()throws Exception {
				
			}
		}
7. 구현된 메쏘드 테스트
	<< 반드시 테스트 되어야합니다.>>>
		public class AddressServiceTestMain {
		
			public static void main(String[] args) throws Exception{
				AddressService AddressService=
						new AddressService();
						
			}
		}		
	
 */

import java.util.List;

public class AddressService {
	private AddressDao addressDao;
	
	public AddressService() throws Exception{
		addressDao=new AddressDao();//생성자
	}
/* 주소록쓰기---------------------------------------------1
 * 주소록수정---------------------------------------------2
 * 주소록번호로 1개 상세보기---------------------------3
 * 주소록번호로삭제 번호로 1개-------------------------4
 * 주소록 전체보기---------------------------------------5
 */
	public int addressWrite(Address address) throws Exception{
		return addressDao.insert(address);//1.주소록 쓰기
	}
	
	public int addressUpdate(Address address) throws Exception{
		return addressDao.updateByNo(address);//2.주소록 수정
	}
	
	public Address addressDetail(int no) throws Exception{
		return addressDao.selectByNo(no);//3.주소록 상세보기
	}
	
	public List<Address> addressList() throws Exception{
		return addressDao.selectAll();
	}
	
	public int addressDelete(int no) throws Exception{
		return  addressDao.deleteByNo(no);
	}
}

