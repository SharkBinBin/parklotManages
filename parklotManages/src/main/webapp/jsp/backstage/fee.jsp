<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <script type="text/javascript" src="/style/scripts/jquery/jquery-1.7.1.js"></script>
    <link href="/style/authority/basic_layout.css" rel="stylesheet" type="text/css">
    <link href="/style/authority/common_style.css" rel="stylesheet" type="text/css">
    <script type="text/javascript" src="/scripts/authority/commonAll.js"></script>
    <script type="text/javascript" src="/scripts/fancybox/jquery.fancybox-1.3.4.js"></script>
    <script type="text/javascript" src="/scripts/fancybox/jquery.fancybox-1.3.4.pack.js"></script>
    <link rel="stylesheet" type="text/css" href="/style/authority/jquery.fancybox-1.3.4.css" media="screen"></link>
    <script type="text/javascript" src="/scripts/artDialog/artDialog.js?skin=default"></script>
    
    <script language="javascript" type="text/javascript" src="My97DatePicker/WdatePicker.js"></script>
    
    <title>用户信息</title>
    <script type="text/javascript">
        $(document).ready(function(){
        	$("#feeExcel").click(function exportExcle(){
            	window.location.href="feeExcel";
           	})
        	
                    $.ajax({
                        type: "GET",
                        url: "statistics1",//请求路径
//                      data: "para="+para,  此处data可以为 a=1&b=2类型的字符串 或 json数据。
                        dataType: "json",
                        success:function(citylist){      
                            //遍历回传的数据添加到二级select
                           $.each(citylist, function(key, citylist) {
                                     var option = '<option value="'+citylist.cityid+'">'+citylist.cityname+'</option>';
                                     $("#type").append(option);
                              })                            
                              
                              //二级select展示
                             $("#type").fadeIn("slow");
                              //三级select隐藏
                                //$("#box-select-third").fadeOut("slow");                                           
                        }
                       
                     });
        });
        
        
        
        /** 用户角色   **/
        var userRole = '';

        /** 模糊查询来电用户  **/
        function search(){
            var type = $("#type").val();
            var type2 = $("#type2").val();
            var type3 = $("#type3").val();
            var platenumber = $("#platenumber").val();
            var method = $("#method").val();
            location="selectAll?type="+type+"&type2="+type2+"&type3="+type3+"&platenumber="+platenumber+"&method="+method;
        }

        /** 新增   **/
        function add(){
            $("#submitForm").attr("action", "/xngzf/archives/luruFangyuan.action").submit();
        }

        /*/!** Excel导出  **!/
         function exportExcel(){
         if( confirm('您确定要导出吗？') ){
         var fyXqCode = $("#fyXq").val();
         var fyXqName = $('#fyXq option:selected').text();
         //	 		alert(fyXqCode);
         if(fyXqCode=="" || fyXqCode==null){
         $("#fyXqName").val("");
         }else{
         //	 			alert(fyXqCode);
         $("#fyXqName").val(fyXqName);
         }
         $("#submitForm").attr("action", "/xngzf/archives/exportExcelFangyuan.action").submit();
         }
         }*/

        /** 删除 **/
        function del(fyID){
            // 非空判断
            if(fyID == '') return;
            if(confirm("您确定要删除吗？")){
                $("#submitForm").attr("action", "/xngzf/archives/delFangyuan.action?fyID=" + fyID).submit();
            }
        }

        /** 批量删除 **/
        function batchDel(){
            if($("input[name='IDCheck']:checked").size()<=0){
                art.dialog({icon:'error', title:'友情提示', drag:false, resize:false, content:'至少选择一条', ok:true,});
                return;
            }
            // 1）取出用户选中的checkbox放入字符串传给后台,form提交
            var allIDCheck = "";
            $("input[name='IDCheck']:checked").each(function(index, domEle){
                bjText = $(domEle).parent("td").parent("tr").last().children("td").last().prev().text();
// 			alert(bjText);
                // 用户选择的checkbox, 过滤掉“已审核”的，记住哦
                if($.trim(bjText)=="已审核"){
// 				$(domEle).removeAttr("checked");
                    $(domEle).parent("td").parent("tr").css({color:"red"});
                    $("#resultInfo").html("已审核的是不允许您删除的，请联系管理员删除！！！");
// 				return;
                }else{
                    allIDCheck += $(domEle).val() + ",";
                }
            });
            // 截掉最后一个","
            if(allIDCheck.length>0) {
                allIDCheck = allIDCheck.substring(0, allIDCheck.length-1);
                // 赋给隐藏域
                $("#allIDCheck").val(allIDCheck);
                if(confirm("您确定要批量删除这些记录吗？")){
                    // 提交form
                    $("#submitForm").attr("action", "/xngzf/archives/batchDelFangyuan.action").submit();
                }
            }
        }

        /** 普通跳转 **/
        function jumpNormalPage(page,currPageNo,count){
            var lid = $("#lid").val();
            var mname = $("#mname").val();
            var type = $("#type").val();
            if(page=1){
            location="BossLoan?lid="+lid+"&mname="+mname+"&type="+type+"&currPageNo=1";
            }
            else if(page=2){
            location="BossLoan?lid="+lid+"&mname="+mname+"&type="+type+"&currPageNo="+(currPageNo-1);
            }
            else if(page=3){
            location="BossLoan?lid="+lid+"&mname="+mname+"&type="+type+"&currPageNo="+(currPageNo+1);
            }
            else if(page=4){
            location="BossLoan?lid="+lid+"&mname="+mname+"&type="+type+"&currPageNo="+count;
            }
        }

        /** 输入页跳转 **/
        function jumpInputPage(totalPage){
            // 如果“跳转页数”不为空
            if($("#jumpNumTxt").val() != ''){
                var pageNum = parseInt($("#jumpNumTxt").val());
                // 如果跳转页数在不合理范围内，则置为1
                if(pageNum<1 | pageNum>totalPage){
                    art.dialog({icon:'error', title:'友情提示', drag:false, resize:false, content:'请输入合适的页数，\n自动为您跳到首页', ok:true,});
                    pageNum = 1;
                }
                $("#submitForm").attr("action", "house_list.html?page=" + pageNum).submit();
            }else{
                // “跳转页数”为空
                art.dialog({icon:'error', title:'友情提示', drag:false, resize:false, content:'请输入合适的页数，\n自动为您跳到首页', ok:true,});
                $("#submitForm").attr("action", "house_list.html?page=" + 1).submit();
            }
        }
        
        function selectSec(){
        	var cityId = $("#type").val();
        		$("#type2").empty();
        		$("#type3").empty();
                $.ajax({
                    type: "GET",
                    url: "tests.json",//请求路径
//                  data: "para="+para,  此处data可以为 a=1&b=2类型的字符串 或 json数据。
                    data: {cityId:cityId},
                    dataType: "json",
                    success:function(secondData){                              
                        //遍历回传的数据添加到二级select
                        var option1 = "<option value=''>--请选择--</option>";
                        $("#type2").append(option1);
                       $.each(secondData, function(key, secondData) {
                                 var option = '<option value="'+secondData.siteid+'">'+secondData.sitename+'</option>';
                                 $("#type2").append(option);
                          })                            
                          
                          //二级select展示
                         $("#type2").fadeIn("slow");
                          //三级select隐藏
                            //$("#box-select-third").fadeOut("slow");                                           
                    }
                   
                 });
        }
        
        function selectThird(){
        	var siteId = $("#type2").val();
        	$("#type3").empty();
                $.ajax({
                    type: "GET",
                    url: "testx.json",//请求路径
//                  data: "para="+para,  此处data可以为 a=1&b=2类型的字符串 或 json数据。
                    data: {siteId:siteId},
                    dataType: "json",
                    success:function(threeDate){                              
                        //遍历回传的数据添加到二级select
                        var option1 = "<option value=''>--请选择--</option>";
                        $("#type3").append(option1);
                       $.each(threeDate, function(key, threeDate) {
                             
                                 var option = '<option value="'+threeDate.gid+'">'+threeDate.gname+'</option>'      
                                 $("#type3").append(option)
                          })                            
                          
                          //二级select展示
                         $("#type2").fadeIn("slow");
                          //三级select隐藏
                            //$("#box-select-third").fadeOut("slow");                                           
                    }
                   
                 });
        }
        
    </script>
    <style>
        .alt td{ background:black !important;}
    </style>
</head>
<body>
<form id="submitForm" name="submitForm" action="" method="post">
    <input type="hidden" name="allIDCheck" value="" id="allIDCheck"/>
    <input type="hidden" name="fangyuanEntity.fyXqName" value="" id="fyXqName"/>
    <div id="container">
        <div class="ui_content">
            <div class="ui_text_indent">
                <div id="box_border">
                    <div id="box_top">搜索</div>
                    <div id="box_center">
                    
                   
                        所在城市:	<select name="type" id="type" onchange="selectSec()">
                        <option value="">--请选择--</option> 
                        <c:forEach items="${citylist}" var="aa">
                        <option value="${aa.cityid}" >${aa.cityname}</option>
                        </c:forEach> 
                        </select>
                   		
                   
                        所在区域:   <select name="type2" id="type2" onchange="selectThird()">
                        <option value="">--请选择--</option>
                        </select>
                        
                        
                        停车场:     <select name="type3" id="type3">
                         <option value="">--请选择--</option>
                         </select>
                         
                        车牌号:	 <input type="text" id="platenumber" name="platenumber" class="ui_input_txt01" style="width:100px">
                    
                        收费方式:	<select name="method" id="method">
                        	<option value="">--请选择--</option>
                        	<option value="1">停车场自收</option>
                        	<option value="2">平台代扣</option>
                        </select>
                        
                     </div>
                    
                    <div id="box_bottom">
                    	<input id="feeExcel" type="button" value="导出Excel" class="ui_input_btn01" onclick=""/>
                    	<input type="button" value="清屏" class="ui_input_btn01" onclick=""/>
                        <input type="button" value="查询" class="ui_input_btn01" onclick="search();return;"/>
                    </div>
                </div>
            </div>
        </div>
        <div class="ui_content">
            <div class="ui_tb">
                <table class="table" cellspacing="1" cellpadding="1" width="100%" align="center" border="1">
                    <tr>
                        <td>序号</td>
                        <td>城市</td>
                        <td>区域</td>
                        <td>停车场</td>
                        <td>车牌号</td>
                        <td>会员账号</td>
                        <td>停车开始时间</td>
                        <td>离场时间</td>
                        <td>收费方式</td>
						<td>交款金额</td>
						
                    </tr>
                    <c:forEach items="${listchar}" var="ll" varStatus="status">
                   	 	<tr align="center">
                    	<td>${status.count}</td> 
                    	<td>${ll.cityName}</td>
                        <td>${ll.siteName}</td>
                        <td>${ll.gname}</td>
                        <td>${ll.lpnumber}</td>
                        <td>${ll.mnumber}</td>
                        <td>${ll.sdate}</td>
                        <td>${ll.edate}</td>
                        <td>
						<c:if test="${ll.ttype==1}">停车场自收</c:if>
						<c:if test="${ll.ttype==2}">平台代扣</c:if>
						</td>
                        <td>${ll.tmoney}</td>
                        
                        
						</tr>
						</c:forEach>
					<tr>
						<td></td>
						<td></td>
						<td></td>
						<td></td>
						<td></td>
						<td></td>
						<td></td>
						<td></td>
						<td></td>
						<td>合计:${size}</td>
					</tr>
                </table>
                
            </div>
            <div class="ui_tb_h30">
                <div class="ui_flt" style="height: 30px; line-height: 30px;">
                    共有
                    <span class="ui_txt_bold04">${totalPageCount}</span>
                    条记录，当前第
						<span class="ui_txt_bold04">${currPageNo}
						/
						${count}</span>
                    页
                </div>
                <div class="ui_frt">
                    <!--    如果是第一页，则只显示下一页、尾页 -->
					<c:if test="${currPageNo!=1}"><a href="test?currPageNo=1"><input type="button" value="首页" class="ui_input_btn01"  /></a></c:if>
					<c:if test="${currPageNo!=1}"><a href="test?currPageNo=${currPageNo-1}"><input type="button" value="上一页" class="ui_input_btn01" /></a></c:if>
                    <c:if test="${currPageNo!=count}"><a href="test?currPageNo=${currPageNo+1}"><input type="button" value="下一页" class="ui_input_btn01"  /></a></c:if>
                    <c:if test="${currPageNo!=count}"><a href="test?currPageNo=${count}"><input type="button" value="尾页" class="ui_input_btn01"  /></a></c:if>
                    <!--     如果是最后一页，则只显示首页、上一页 -->


                </div>
            </div>
        </div>
    </div>
</form>

</body>
</html>