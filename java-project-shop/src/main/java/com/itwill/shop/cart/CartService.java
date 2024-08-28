package com.itwill.shop.cart;

public class CartService {

	private CartDao cartDao;
	public CartService() throws Exception{
		cartDao=new CartDao();
	}
	
	/*
	 * 카트 추가 or 수정
	 */
	public int addCart(Cart cart) throws Exception{
		if(cartDao.countByProductNo(cart.getUser().getUserId(), cart.getProduct().getP_no())>0) {
			//update
			return cartDao.updateByCartNo(cart);
		}else {
			//insert
			return cartDao.insert(cart);
		}
//		return 0;
	}
}
