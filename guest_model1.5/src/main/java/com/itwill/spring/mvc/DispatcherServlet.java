package com.itwill.spring.mvc;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import com.itwill.guest.controller.GuestErrorController;
import com.itwill.guest.controller.GuestListController;
import com.itwill.guest.controller.GuestMainController;
import com.itwill.guest.controller.GuestModifyActionController;
import com.itwill.guest.controller.GuestModifyFormController;
import com.itwill.guest.controller.GuestRemoveActionController;
import com.itwill.guest.controller.GuestViewController;
import com.itwill.guest.controller.GuestWriteActionController;
import com.itwill.guest.controller.GuestWriteFormController;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


@WebServlet(urlPatterns = { "*.do" })
public class DispatcherServlet extends HttpServlet {
	private Map<String,Controller> handlerMapping;
	/*
	 << Map<String, Controller> handlerMapping>>
	 ------------------------------------------------
	 |key(String)      |      value(Controller객체) |
	 ------------------------------------------------
	 |/guest_main.do   |com..GuestMainController객체|	
	  -----------------------------------------------
	 |/guest_list.do   |com..GuestListController객체|		
	  -----------------------------------------------
	 |/guest_view.do   |com..GuestViewController객체|		
	 ------------------------------------------------
	 */
	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		handlerMapping=new HashMap<String,Controller>();
		/************직접생성***********/
		handlerMapping.put("/guest_main.do", new GuestMainController());
		handlerMapping.put("/guest_list.do", new GuestListController());
		handlerMapping.put("/guest_view.do", new GuestViewController());
		handlerMapping.put("/guest_write_form.do", new GuestWriteFormController());
		handlerMapping.put("/guest_write_action.do", new GuestWriteActionController());
		handlerMapping.put("/guest_remove_actiopn.do", new GuestRemoveActionController());
		handlerMapping.put("/guest_modify_form.do", new GuestModifyFormController());
		handlerMapping.put("/guest_modify_action.do", new GuestModifyActionController());
		handlerMapping.put("/guest_error.do", new GuestErrorController());
		
	}
	
	
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		/*
		 * 1. DispatcherServlet이 클라이언트의 요청URI를 사용해서 요청분석
		 */
		String requestURI = request.getRequestURI();
		String contextPath = request.getContextPath();
		String command = requestURI.substring(contextPath.length());
		System.out.println("command:" + command);
		/*
		 * 2.DispatcherServlet이 클라이언트 요청에따른 비지니스실행
		 */
		String forwardPath = "";
		Controller controller=handlerMapping.get(command);
		forwardPath=controller.handleRequest(request, response);
		
		/*
		 * 3.DispatcherServlet이 forwardPath를 사용해서 forward 혹은 redirect를한다.
		 */
		/********** forward or redirect **************************/
		/*
		 forward    --> forward:/WEB-INF/views/guest_xxx.jsp
		 redirect   --> redirect:guest_xxx
		 */
		String[] pathArray = forwardPath.split(":");
		String forwardOrRedirect = pathArray[0];
		String path = pathArray[1];
		if (forwardOrRedirect.equals("forward")) {
			RequestDispatcher rd = request.getRequestDispatcher(path);
			rd.forward(request, response);
		} else {
			response.sendRedirect(path);
		}
		/*******************************************************/

	}
}