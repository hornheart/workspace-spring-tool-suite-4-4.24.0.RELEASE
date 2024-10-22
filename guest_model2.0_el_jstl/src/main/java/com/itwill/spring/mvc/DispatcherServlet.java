package com.itwill.spring.mvc;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
/*
1.클라이언트(웹브라우져)의 모든요청을 받는 서블릿작성
2.확장자 *.do 인 모든클라이언트의 요청이 서블릿을 실행하도록 url pattern mapping
*/ 

@WebServlet(urlPatterns = { "*.do" },loadOnStartup = 0)
public class DispatcherServlet extends HttpServlet {
	/*
	 * 요청command에 해당하는 Controller객체보관 맵
	 */
	private Map<String,Controller> handlerMapping;
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		handlerMapping=new HashMap<String,Controller>();
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
		/************Controller객체직접생성***********
		handlerMapping.put("/guest_main.do", new GuestMainController());
		handlerMapping.put("/guest_list.do", new GuestListController());
		handlerMapping.put("/guest_view.do", new GuestViewController());
		handlerMapping.put("/guest_write_form.do", new GuestWriteFormController());
		handlerMapping.put("/guest_write_action.do", new GuestWriteActionController());
		handlerMapping.put("/guest_remove_actiopn.do", new GuestRemoveActionController());
		handlerMapping.put("/guest_modify_form.do", new GuestModifyFormController());
		handlerMapping.put("/guest_modify_action.do", new GuestModifyActionController());
		handlerMapping.put("/guest_error.do", new GuestErrorController());
		***********************************************/
		
		/************설정파일(controller_mapping.properties)을 읽어서 Controller객체생성*******************/
		try {
			InputStream controllerMappingInputStream=
					DispatcherServlet.class.getResourceAsStream("/controller_mapping.properties");
			Properties properties=new Properties();
			properties.load(controllerMappingInputStream);
			Set keySet=properties.keySet();
			Iterator commandKeyIteator=keySet.iterator();
			System.out.println("********설정파일(controller_mapping.prpoerties)을 읽어서 Controller객체생성**********");
			while(commandKeyIteator.hasNext()) {
				String commandKey=(String)commandKeyIteator.next();
				String controllerClassName=properties.getProperty(commandKey);
				/*
				  Controller클래스이름을 사용해서 Controller객체생성
					1. Controller클래스이름을 사용해서 클래스를 메모리에로딩
					2. 메모리에로딩된 클래스의 기본생성자를 호출해서객체생성
				 */
				Class controllerClass=Class.forName(controllerClassName);
				//Controller controller=(Controller)controllerClass.newInstance();
				Controller controller=
						(Controller)controllerClass.getDeclaredConstructor().newInstance();
				System.out.println(commandKey+"-->"+controller);
				handlerMapping.put(commandKey, controller);
			}
			System.out.println("************************************************************************************");
		}catch (Exception e) {
			e.printStackTrace();
		}
		
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
