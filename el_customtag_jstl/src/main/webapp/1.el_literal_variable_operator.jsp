<%@page import="java.util.HashMap"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.itwill.bean.Guest"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%

	pageContext.setAttribute("int1", 10);
	pageContext.setAttribute("int2", 20);
	pageContext.setAttribute("double1", 0.5);
	pageContext.setAttribute("double2", 3.14159);
	pageContext.setAttribute("string1", "KIM");
	pageContext.setAttribute("string2", "경호");
	pageContext.setAttribute("bool1", true);
	pageContext.setAttribute("bool2", false);
	pageContext.setAttribute("married", true);
	pageContext.setAttribute("age", 34);
	pageContext.setAttribute("weight", 78.23);
	pageContext.setAttribute("height", 183);
	/*
	pageContext.setAttribute("1234", 8888888);
	pageContext.setAttribute("3.14159", 777777);
	*/
	Guest guest = null;
	List<Guest> guestList = new ArrayList<Guest>();
	Map<String, Guest> guestMap = new HashMap<String, Guest>();
	String emptyStr = "";
	
	pageContext.setAttribute("guest", guest);
	pageContext.setAttribute("guestList", guestList);
	pageContext.setAttribute("guestMap", guestMap);
	pageContext.setAttribute("emptyStr", emptyStr);

%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>EL 리터럴,변수,연산자</h1>
	<hr>
	<ul>
		<li>----EL 리터럴(상수)----</li>
		
			<ul>${1234}</ul>
			<ul>${1234.1234}</ul>
			<ul>${true}</ul>
			<ul>${'문자1'}</ul>
			<ul>${"문자1"}</ul>
			
		<li>---------EL 변수[SCOPE객체의 속성이름]--------</li>
		
			<ul>${dfsdajkf} </ul>
			<ul>${int1} </ul>
			<ul>${int2} </ul>
			<ul>${double2} </ul>
			<ul>${string1} </ul>
			<ul>${string2} </ul>
			<ul>${bool1} </ul>
			<ul>${bool2} </ul>
			<ul>${age} </ul>
			<ul>${weight} </ul>
			<ul>${height} </ul>
		
		<li>---------EL 연산자--------</li>
		
			<ul>${23+56} </ul>
			<ul>${23-56} </ul>
			<ul>${23/56} </ul>
			<ul>${23*56} </ul>
			<ul>${1/3} </ul>
			<ul>${int1+int2} </ul>
			<ul>${int1-int2} </ul>
			<ul>${int1/int2} </ul>
			<ul>${int1*int2} </ul>
			<ul>${double1+double2+0.956487} </ul>
			<ul>${(int1-67)-89/(double2*56)+89} </ul>
			<ul>&dollar;{(string+'경호'}(x)문자열 연산 사용불가 </ul>
			<ul>${string1}${stirng2} </ul>
			<ul>${string1}${'경호'} </ul>
			<ul>${string1}경호</ul>
			<ul>${age>=30}</ul>
			<ul>age>=30--->${age>=30}</ul>
			<ul>age ge 30--->${age ge 30}</ul>
			
			<ul>age < 30--->${age<30}</ul>
			<ul>age lt 30--->${age lt 30}</ul>
			
			<ul>age!=30--->${age!=30}</ul>
			<ul>age ne 30--->${age ne 30}</ul>
			
			<ul>age==30--->${age==30}</ul>
			<ul>age eq 30--->${age eq 30}</ul>
			
			<ul>30대 인가요? ${age>=30 && age<40}</ul>
			<ul>30대 인가요? ${age>=30 and age<40}</ul>
			<ul>30대 이고 키가 180이상 인가요? ${(age>=30 and age<40) && height>=180}</ul>
			<ul>30대 이고 키가 180이상 인가요? ${(age ge 30 and age lt 40) && height>=180}</ul>
			
		<li>----------null or size체크---------</li>
			
			<ul>${guest==null}</ul>
			<ul>${guestList.size()==0}</ul>
			<ul>${guestMap.size()==0}</ul>
			<ul>${emptyStr.equals("")}</ul>
			
		<li>----------null or size체크(empty연산자)---------</li>
		
			<ul>${empty guest}</ul>
			<ul>${empty guestList}</ul>
			<ul>${empty guestMap}</ul>
			<ul>${empty emptyStr}</ul>

	</ul>
</body>
</html>







