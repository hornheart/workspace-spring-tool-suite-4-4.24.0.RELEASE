package com.itwill.guest;

import java.util.List;
/*
 * - 방명록(guest) 관리 비즈니스로직(업무)를 수행하는 클래스
 * - GUI객체(스윙,서블릿,JSP)에서 직접접근(메쏘드호출)하는클래스
 * - GuestDao객체를 이용해서 데이타베이스에 접근하는클래스
 */
public class GuestServiceImpl implements GuestService{
		private GuestDao guestDao;
		public GuestServiceImpl() throws Exception{
			//this.guestDao=new GuestDaoImplJDBC();
			//this.guestDao=new GuestDaoImplMyBatis();
			this.guestDao=new GuestDaoImplMyBatisInterface();
			
		}
		
		/*
		 * 방명록쓰기
		 */
		@Override
		public int guestWrite(Guest guest) 
				throws Exception{
			/*
			<< GuestDao객체사용>>
			*/
			return guestDao.insert(guest);
		}
		/*
		 * 방명록번호로 1개보기
		 */
		@Override
		public Guest guestDetail(int guest_no) throws Exception{
			return guestDao.findByGuestNo(guest_no);
		}
		/*
		 * 방명록번호로삭제
		 */
		@Override
		public int guestDelete(int guest_no) 
				throws Exception{
			return guestDao.delete(guest_no);
		}
		/*
		 * 방명록 리스트보기
		 */
		@Override
		public List<Guest> guestList()throws Exception {
			return guestDao.findByAll();
		}
		/*
		 * 방명록 이름으로검색해서 리스트보기
		 */
		/*
		public List<Guest> findByGuestName(String guest_name) throws Exception{
			return guestDao.findByGuestName(guest_name);
		}
		*/
		/*
		 * 방명록 전체,이름,제목,내용 으로검색해서 리스트보기
		 */
		/*
		public List<Guest> findByGuest(int searchType,String searchString)throws Exception{
			List<Guest> guestList=new ArrayList<Guest>();
			switch (searchType) {
			case GuestService.GUEST_SEARCH_BY_ALL:
				guestList = guestDao.findByAll();
				break;
			case GuestService.GUEST_SEARCH_BY_NAME:
				guestList=guestDao.findByGuestName(searchString);
				break;
			case GuestService.GUEST_SEARCH_BY_TITLE:
				guestList=guestDao.findByGuestTitle(searchString);
				break;
			case GuestService.GUEST_SEARCH_BY_CONTENT:
				guestList=guestDao.findByGuestContent(searchString);
				break;
			}
			return guestList;
		}
		*/
		/*
		 * 방명록수정
		 */
		@Override
		public int guestUpdate(Guest guest) throws Exception{
			return guestDao.update(guest);
		}
		
		
		
		
	}