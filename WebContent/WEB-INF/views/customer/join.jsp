<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>은행 관리 시스템</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
</head>
<body>
<div>
    <h2>회원가입</h2>
    <form id="join_form" action="<%=request.getContextPath()%>/member.do">
        아이디 <input type="text" name="id"/> <br/>
        비밀번호 <input type="text" name="pass"/> <br/>
        이름 <input type="text" name="name"/> <br/>
        주민번호 <input type="text" name="ssn"/> <br/>
        신용등급 <input type="text" name="credit"/> <br/>
       	<input type="hidden" name="action" value="join" />
       	<input type="hidden" name="dest" value="login" />
        <input type="submit" id="text" value="가 입 ">
    </form>
</div>
<script>
$('#join_form').submit(function(){
    alert('테스트5');
  
});
</script>
</body>
</html>