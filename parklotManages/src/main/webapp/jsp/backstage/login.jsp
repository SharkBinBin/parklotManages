<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>SCT-后台系统</title>
<link href="statics/style/authority/login_css.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="statics/scripts/jquery/jquery-1.7.1.js"></script>
<script type="text/javascript">
	/* $(document).ready(function(){
		$("#login_sub").click(function(){
			$("#submitForm").attr("action", "login.html").submit();
		});
	});  */
	
	/*回车事件*/
	/*  function EnterPress(e){ //传入 event 
		var e = e || window.event; 
		if(e.keyCode == 13){ 
			$("#submitForm").attr("action", "login.html").submit();
		} 
	}  */
</script>
</head>
<body>
	<div id="login_center">
		<div id="login_area">
			<div id="login_box">
				<div id="login_form">
					<form id="submitForm" action="${pageContext.request.contextPath }/login.html" method="get">
						<div id="login_tip">
							<span id="login_err" class="sty_txt2"></span>
							<span>${error}</span>
						</div>
						
						<div>
							 用户名：<input type="text" name="user_Name" class="username" id="user_Name" placeholder="请输入用户名" required>
						</div>
						<div>
							密&nbsp;&nbsp;&nbsp;&nbsp;码：<input type="password" name="user_Password" class="pwd" id="user_Password" placeholder="请输入密码" required>
							<!-- onkeypress="EnterPress(event)" onkeydown="EnterPress()" -->
						</div>
						<div id="btn_area">
							<input type="submit" class="login_btn" id="login_sub"  value="登  录">
							<input type="reset" class="login_btn" id="login_ret" value="重 置">
							<span><a href="register.jsp">注册</a></span>
						</div>
					</form>
				</div>
			</div>
		</div>
	</div>




</body>
</html>