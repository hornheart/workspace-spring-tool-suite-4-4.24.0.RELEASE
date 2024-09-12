	package com.itwill.address.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import org.apache.jasper.tagplugins.jstl.core.ForEach;

import com.itwill.address.Address;
import com.itwill.address.AddressService;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;



/**
 * Servlet implementation class AddressListServlet
 */
@WebServlet("/address_list")
public class AddressListServlet extends HttpServlet {

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		try {
			/*
			 * 1.AddressService객체생성 
			 * 2.AddressService객체의 addressList() 메쏘드호출
			 */
			
			AddressService addressService=new AddressService();
			List<Address> addressList=addressService.addressList();
			
			response.setContentType("text/html;charset=UTF-8");
			PrintWriter out = response.getWriter();

			out.println("<!DOCTYPE html>");
			out.println("<html>");
			out.println("<head>");
			out.println("<meta charset='UTF-8'>");
			out.println("<title>Insert title here</title>");
			out.println("</head>");
			out.println("<body>");
			out.println("<h1>[주소록리스트]</h1><hr>");
			out.println("<div>");
			out.println("	<a href='address_insert_form'>[주소록쓰기폼]</a>");
			out.println("</div>");
			out.println("<div>");
			out.println("	<ul>");
			for(Address address:addressList) {
				
				out.printf("		<li><a href='address_detail?no=%d'>[%d]%s</a></li>",address.getNo(),address.getNo(),address.getName());
			}
			out.println("	</ul>");
			out.println("</div>");
			out.println("</body>");
			out.println("</html>");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
