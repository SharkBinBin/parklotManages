<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html>
<html>
<head>
<title>用户贷款信息录入</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<script type="text/javascript" src="${pageContext.request.contextPath}/statics/scripts/jquery/jquery-1.7.1.js"></script>
<link href="${pageContext.request.contextPath}/statics/style/authority/basic_layout.css" rel="stylesheet" type="text/css">
<link href="${pageContext.request.contextPath}/statics/style/authority/common_style.css" rel="stylesheet" type="text/css">
<script type="text/javascript" src="${pageContext.request.contextPath}/statics/scripts/authority/commonAll.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/statics/scripts/jquery/jquery-1.4.4.min.js"></script>
<script src="${pageContext.request.contextPath}/statics/scripts/My97DatePicker/WdatePicker.js" type="text/javascript" defer="defer"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/statics/scripts/artDialog/artDialog.js?skin=default"></script>
<script type="text/javascript">
	$(document).ready(function() {
		/*
		 * 提交
		 */
		/* $("#submitbutton").click(function() {
			if(validateForm()){
				checkFyFhSubmit();
			}
		}); */
		
		/*
		 * 取消
		 */
		$("#cancelbutton").click(function() {
			/**  关闭弹出iframe  **/
			window.parent.$.fancybox.close();
		});
		
		var result = 'null';
		if(result =='success'){
			/**  关闭弹出iframe  **/
			window.parent.$.fancybox.close();
		}
	});
	
	/** 检测房源房号是否存在  **/
	/*function checkFyFh(){
		// 分别获取小区编号、栋号、层号、房号
		var fyID = $('#fyID').val();
		var fyXqCode = $("#fyXq").val();
		var fyDh = $("#fyDh").val();
		var fyCh = $("#fyCh").val();	
		var fyFh = $("#fyFh").val();
		if(fyXqCode!="" && fyDh!="" && fyCh!="" && fyFh!=""){
			// 给房屋坐落地址赋值
			$("#fyZldz").val($('#fyDh option:selected').text() + fyCh + "-" + fyFh);
			// 异步判断该房室是否存在，如果已存在，给用户已提示哦
			$.ajax({
				type:"POST",
				url:"checkFyFhIsExists.action",
				data:{"fangyuanEntity.fyID":fyID,"fangyuanEntity.fyXqCode":fyXqCode, "fangyuanEntity.fyDhCode":fyDh, "fangyuanEntity.fyCh":fyCh, "fangyuanEntity.fyFh":fyFh},
				dataType : "text",
				success:function(data){
// 					alert(data);
					// 如果返回数据不为空，更改“房源信息”
					if(data=="1"){
						 art.dialog({icon:'error', title:'友情提示', drag:false, resize:false, content:'该房室在系统中已经存在哦，\n请维护其他房室数据', ok:true,});
						 $("#fyFh").css("background", "#EEE");
						 $("#fyFh").focus();
						 return false;
					}
				}
			});
		}
	}*/
	
	/*/!** 检测房源房号是否存在并提交form  **!/
	function checkFyFhSubmit(){
		// 分别获取小区编号、栋号、层号、房号
		var fyID = $('#fyID').val();
		var fyXqCode = $("#fyXq").val();
		var fyDh = $("#fyDh").val();
		var fyCh = $("#fyCh").val();	
		var fyFh = $("#fyFh").val();
		if(fyXqCode!="" && fyDh!="" && fyCh!="" && fyFh!=""){
			// 给房屋坐落地址赋值
			$("#fyZldz").val($('#fyDh option:selected').text()  + fyCh + "-" + fyFh);
			// 异步判断该房室是否存在，如果已存在，给用户已提示哦
			$.ajax({
				type:"POST",
				url:"checkFyFhIsExists.action",
				data:{"fangyuanEntity.fyID":fyID,"fangyuanEntity.fyXqCode":fyXqCode, "fangyuanEntity.fyDhCode":fyDh, "fangyuanEntity.fyCh":fyCh, "fangyuanEntity.fyFh":fyFh},
				dataType : "text",
				success:function(data){
// 					alert(data);
					// 如果返回数据不为空，更改“房源信息”
					if(data=="1"){
						 art.dialog({icon:'error', title:'友情提示', drag:false, resize:false, content:'该房室在系统中已经存在哦，\n请维护其他房室数据', ok:true,});
						 $("#fyFh").css("background", "#EEE");
						 $("#fyFh").focus();
						 return false;
					}else{
						$("#submitForm").attr("action", "/xngzf/archives/saveOrUpdateFangyuan.action").submit();
					}
				}
			});
		}
		return true;
	}*/
	
	/** 表单验证  **/
	function check(){
		/*if($("#fyXqName").val()==""){
			art.dialog({icon:'error', title:'友情提示', drag:false, resize:false, content:'填写房源小区', ok:true,});
			return false;
		}
		return true;
		*/
	}
</script>
</head>
<body>
<form id="submitForm" name="submitForm" action="${pageContext.request.contextPath }/updateUser.html" method="get" >
	<!-- onsubmit="check()" -->
	<!-- /xngzf/archives/initFangyuan.action -->
	<input type="hidden" name="fyID" value="14458625716623" id="fyID"/>
	<div id="container">
		<div id="nav_links">
			当前位置：基础数据&nbsp;>&nbsp;<span style="color: #1A5CC6;">个人信息查看</span>
			<div id="page_close">
				<a href="javascript:parent.$.fancybox.close();">
					<img src="${pageContext.request.contextPath}/statics/images/common/page_close.png" width="20" height="20" style="vertical-align: text-top;"/>
				</a>
			</div>
		</div>
		<div class="ui_content">
			<table  cellspacing="0" cellpadding="0" width="100%" align="left" border="0">
					<input type="hidden" value="${loanUser.user_ID}" name="user_ID" id="user_ID" />
				<tr>
					<td class="ui_text_rt" width="80">姓名</td>
					<td class="ui_text_lt">
						<input type="text" value="${loanUser.user_Name}"  name="user_Name" id="user_Name" class="ui_input_txt01"  style="width:100px" readonly="readonly"/>
					</td>
				</tr>
				<tr>
					<td class="ui_text_rt" width="80">身份证号</td>
					<td class="ui_text_lt">
						<input type="text" value="${loanUser.user_CardID}" name="user_CardID" id="user_CardID"  class="ui_input_txt02"  style="width:200px" readonly="readonly"/>
					</td>
				</tr>
				<tr>
					<td class="ui_text_rt">现住址</td>
					<td class="ui_text_lt">
						<input type="text" value="${loanUser.user_Address}" name="user_Address" id="user_Address" class="ui_input_txt03"  style="width:200px"/>
					</td>
				</tr>
				<tr>
					<td class="ui_text_rt">电话号码</td>
					<td class="ui_text_lt">
						<input type="text" value="${loanUser.user_Phone}" name="user_Phone" id="user_Phone" class="ui_input_txt03"  style="width:200px;"/>
					</td>
				</tr>
				<!-- <tr>
					<td class="ui_text_rt">职业</td>
					<td class="ui_text_lt">
						<input type="text" value="" class="ui_input_txt03"  style="width:120px"/>
					</td>
				</tr> -->
				<tr>
					<td>&nbsp;</td>
					<td class="ui_text_lt">
						&nbsp;<input id="submitbutton" type="submit" value="修改" class="ui_input_btn01"/>
						&nbsp;<input id="cancelbutton" type="button" value="取消" class="ui_input_btn01"/>
					</td>
				</tr>
			</table>
		</div>
	</div>
</form>

</body>
</html>