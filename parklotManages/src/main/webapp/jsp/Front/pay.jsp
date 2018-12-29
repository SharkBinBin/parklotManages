<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<input id="body" type="hidden" value="停车场余额充值"/>
	商品金额：<input id="money"/>
	<input type="button" value="支付" id="pay"/>
	
	<div id="code">
	
	</div>
	
	<script type="text/javascript" src="js/jquery-3.3.1.min.js"></script>
	<script type="text/javascript" src="js/qrcode.js"></script>
	<script type="text/javascript">
		$("#pay").click(function(){
			var body = $("#body").val();
			var money = $("#money").val();
			$.ajax({
				url:"pay",
				data:{"body":body,"money":money},
				type:"post",
				success:function(data){
					//参数1表示图像大小，取值范围1-10；参数2表示质量，取值范围'L','M','Q','H'
					var qr = qrcode(10, 'H');
					qr.addData(data);
					qr.make();
					
					$("#code").html(qr.createImgTag());
					
					setInterval(query,5000);
				}
				
			});
		});
		
		function query(){
			$.ajax({
				url:"query",
				type:"POST",
				dataType:"json",
				success:function(data){
					console.log(data);
					if(data==true){
						location.href="http://localhost:8080/success";
					}
				},
				error:function(e){
					console.log(e);
				}
			});
		}
	</script>
	
</body>
</html>