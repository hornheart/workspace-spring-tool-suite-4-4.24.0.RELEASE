package com.itwill.servlet;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
@WebServlet("/response_mp3")
public class MIMETypeMP3ResponseServlet extends HelloServlet{

	@Override
	protected void service(HttpServletRequest requst, HttpServletResponse response) throws ServletException,IOException {
		response.setContentType("audio/mpeg");
//		response.getOutputStream();
		OutputStream out= response.getOutputStream();
		String mp3FilePath="C:\\2024-07-JAVA-DEVELOPER\\workspace-spring-tool-suite-4-4.24.0.RELEASE\\servletSite\\src\\main\\webapp\\image\\test.mp3";
		FileInputStream fis=new FileInputStream(mp3FilePath);
		
		while (true) {
			int readByte = fis.read();
			if(readByte==-1)break;
			out.write(readByte);
		}
		fis.close();
		out.close();
	}
}
