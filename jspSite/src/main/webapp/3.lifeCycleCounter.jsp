<%@page contentType="text/html; charset=UTF-8" %>
<%!
	private int count=0;

	public void jspInit(){
		System.out.println("생성 후 단 한번 호출[객체초기화]"+this);
	}
	public void jspDestroy(){
		System.out.println("객체가 메모리에서 해지될 때 한번 호출[객체리소스반납]"+this);
		
	}

%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
</head>
			<body bgcolor=#40e0d0 style=font-size:9pt;line-height:140%;> 
			<center>			
			 현재까지의 페이지뷰수
			<font color=#0000FF>
			 
			 <%
			 	out.print(++count);
			 %>
			</font>
			 번입니다
			</center> 
			</body> 
			
			
</html> 
