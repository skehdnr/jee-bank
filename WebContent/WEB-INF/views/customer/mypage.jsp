<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>은행 관리 프로그램</title>

</head>
<body>
마이페이지

<h2>환영합니다 ${customer.name}님</h2>
	<h3>   아이디  ${customer.id} </h3><br/>
    <h3>   비밀번호 ${customer.pass} </h3><br/>
    <h3>   이름 ${customer.name} </h3><br/>
    <h3>   주민번호 ${customer.ssn} </h3><br/>
    <h3>   신용등급${customer.credit}</h3> <br/>
</body>
</html>