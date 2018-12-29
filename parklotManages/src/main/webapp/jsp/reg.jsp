<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="/reg" method="post">
	姓名：<input type="text" name="mname"/><Br/>
	账号：<input type="text" name="mnumber"/><Br/>
	密码：<input type="text" name="mpassword"/><Br/>
	手机号：<input type="text" name="mphone"/><Br/>
	性别：<input type="text" name="msex"/><Br/>
	身份证号：<input type="text" name="midcard"/><Br/>
	银行卡号：<input type="text" name="mbankid"/><Br/>
	个人地址：<input type="text" name="maddress"/><Br/>
	车牌号码：<input type="text" name="lpnumber"/><Br/>
	邮箱：<input type="text" name="memail"/>
	
	<input type="submit" value="注册">
	</form>
</body>
</html>