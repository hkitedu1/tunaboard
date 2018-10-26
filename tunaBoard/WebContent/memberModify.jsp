<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="common.css" rel="stylesheet" type="text/css">
<title>홈</title>
</head>
<body>
	<jsp:include page="header.jsp" />
	
	
	<section>
	<h3>회원목록조회/수정</h3>
	<table>
	<form name="frm" action="memberModify" method="post" onsubmit="return chkSubmit();">
			<tr>
				<td class="td1">회원번호</td> 
				<td><input type="text" name="custno" value="${vo.custno}"readonly  ></td>
			</tr>
			<tr>
				<td class="td1">회원성명</td>
				<td><input type="text" name="custname" value="${vo.custname}"></td>
			</tr>
			<tr>
				<td class="td1">회원전화</td>
				<td><input type="text" name="phone" value="${vo.phone}" class="ad2"></td>
			</tr>
			<tr>
				<td class="td1">회원주소</td>
				<td><input type="text" name="address" value="${vo.address}" class="ad"></td>
			</tr>
			<tr>
				<td class="td1">가입일자</td>
				<td><input type="text" name="joindata" value="${vo.joindate}"
					class="ad3"readonly  ></td>
			</tr>
			<tr>
				<td class="td1">고객등급[A:VIP,B:일반,C:직원]</td>
				<td><input type="text" name="grade" value="${vo.grade}"></td>
			</tr>
			<tr>
				<td class="td1">도시코드</td>
				<td><input type="text" name="city" value="${vo.city}"></td>
			</tr>
			<tr>
				<td colspan="2" class="td1"><input type="submit" name=""
					value="수정"><input type="button"
					onclick="location.href='memberFind'" name="" value="조회"></td>
			</tr>

		</form>
</table>
</section>

	<jsp:include page="footer.jsp" />
</body>
<script>
<%
String msg = (String) request.getAttribute("msg");
%>
			var msg = "${msg}";
			if (msg != "") {
				alert(msg)
			}

			function chkSubmit() {
				var frm = document.frm;
				
				if (frm.custno.value == "") {
					alert("회원번호가 입력되지 않았습니다.");
					frm.custno.focus();
					return false;
				} else if (frm.custname.value == "") {
					alert("회원성명이 입력되지 않았습니다.");
					frm.custname.focus();
					return false;
				} else if (frm.phone.value == "") {
					alert("회원전화번호가 입력되지 않았습니다.");
					frm.phone.focus();
					return false;
				} else if (frm.address.value == "") {
					alert("회원주소가 입력되지 않았습니다.");
					frm.address.focus();
					return false;
				} else if (frm.joindata.value == "") {
					alert("가입일자가 입력되지 않았습니다.");
					frm.joindata.focus();
					return false;
				} else if (frm.grade.value == "") {
					alert("회원등급이 입력되지 않았습니다.");
					frm.grade.focus();
					return false;
				} else if (frm.city.value == "") {
					alert("도시코드가 입력되지 않았습니다.");
					frm.city.focus();
					return false;
				}
				alert("입력완료.");
				return true;
			}
		</script>
</html>