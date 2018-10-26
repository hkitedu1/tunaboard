<%@page import="java.util.ArrayList"%>
<%@page import="dbpkg.MemberVO"%>
<%@page import="com.sun.xml.internal.bind.v2.schemagen.xmlschema.Import"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="common.css" rel="stylesheet" type="text/css">


<title>홈</title>
</head>
<% ArrayList<MemberVO> list = (ArrayList<MemberVO>)request.getAttribute("list"); %>
<body>
	<jsp:include page="header.jsp" />
	<section>
	<h3>회원목록조회/수정</h3>
	<table>
		<tr>
			<td>회원번호</td>
			<td>회원성명</td>
			<td>전화번호</td>
			<td>주소</td>
			<td>가입일자</td>
			<td>고객등급</td>
			<td>거주지역</td>
		</tr>

		<%
			for(MemberVO vo : list){
		%>

		<tr>
			<td><a href="memberModify?Custno=<%=vo.getCustno() %>"><%=vo.getCustno() %></a></td>
			<td><%=vo.getCustname() %></td>
			<td><%=vo.getphone() %></td>
			<td><%=vo.getAddress() %></td>
			<td><%=vo.getJoindate() %></td>
			<td><%=vo.getGrade() %></td>
			<td><%=vo.getCity() %></td>
		</tr>
	

		
		<%
			}
		%>

	</table>
	</section>
	<jsp:include page="footer.jsp" />
</body>
</html>