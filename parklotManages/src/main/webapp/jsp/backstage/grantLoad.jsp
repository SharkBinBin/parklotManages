<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <script type="text/javascript" src="${pageContext.request.contextPath}/statics/scripts/jquery/jquery-1.7.1.js"></script>
    <link href="${pageContext.request.contextPath}/statics/style/authority/basic_layout.css" rel="stylesheet" type="text/css">
    <link href="${pageContext.request.contextPath}/statics/style/authority/common_style.css" rel="stylesheet" type="text/css">
    <script type="text/javascript" src="${pageContext.request.contextPath}/statics/scripts/authority/commonAll.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/statics/scripts/fancybox/jquery.fancybox-1.3.4.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/statics/scripts/fancybox/jquery.fancybox-1.3.4.pack.js"></script>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/statics/style/authority/jquery.fancybox-1.3.4.css" media="screen"></link>
    <script type="text/javascript" src="${pageContext.request.contextPath}/statics/scripts/artDialog/artDialog.js?skin=default"></script>
    <title>用户信息</title>
    <script type="text/javascript">
        $(document).ready(function(){
            /** 新增   **/
            $("#addBtn").fancybox({
                'href'  : 'house_edit.html',
                'width' : 733,
                'height' : 530,
                'type' : 'iframe',
                'hideOnOverlayClick' : false,
                'showCloseButton' : false,
                'onClosed' : function() {
                    window.location.href = 'house_list.html';
                }
            });

            /*/!** 导入  **!/
             $("#importBtn").fancybox({
             'href'  : '/xngzf/archives/importFangyuan.action',
             'width' : 633,
             'height' : 260,
             'type' : 'iframe',
             'hideOnOverlayClick' : false,
             'showCloseButton' : false,
             'onClosed' : function() {
             window.location.href = 'house_list.html';
             }
             });*/

            /**编辑   **/
            $("a.edit").fancybox({
                'width' : 733,
                'height' : 530,
                'type' : 'iframe',
                'hideOnOverlayClick' : false,
                'showCloseButton' : false,
                'onClosed' : function() {
                    window.location.href = 'house_list.html';
                }
            });
        });
        /** 用户角色   **/
        var userRole = '';

        /** 模糊查询来电用户  **/
        function search(){
        var loanId = $("#loanId").val()
        location = "aaa.html?loanId=" + loanId;
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
        function jumpNormalPage(page){
            $("#submitForm").attr("action", "house_list.html?page=" + page).submit();
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
                        订单号:<input type="text" id="loanId" name="loanId" class="ui_input_txt01" value="${loanId }"  style="width:100px"/>
                    </div>
                    <div id="box_bottom">
                        <input type="submit" value="查询" class="ui_input_btn01" onclick="search();" />
                    </div>
                </div>
            </div>
        </div>
        <div class="ui_content">
            <div class="ui_tb">
                <table class="table" cellspacing="0" cellpadding="0" width="100%" align="center" border="0">
                    <tr>
                        <th width="100px">借款订单编号</th>
                        <th width="90px">借款金额</th>
                        <th>借款时间</th>
                        <th>截止时间</th>
                        <th>拨款状态</th>
                        <th>审核状态</th>
                        <th>操作</th>
                    </tr>
                    <c:forEach items="${loanList}" var="list">
                    <tr>
                        <td width="90px">${list.loanID}</td>
                        <td>${list.loanMoney}</td>
                        <td>
                        	<fmt:formatDate value="${list.loanDate}" pattern="yyyy-MM-dd"></fmt:formatDate>
                        </td>
                        <td>
                        	<fmt:formatDate value="${list.loanDeadline}" pattern="yyyy-MM-dd"></fmt:formatDate>
                        </td>
                        <td>
                        <c:choose>
                        	<c:when test="${list.loanAMoney == 0}">
                        		未拨款
                        	</c:when>
                        	<c:when test="${list.loanAMoney == 1}">
                        		已拨款
                        	</c:when>
                        </c:choose>
                        </td>
                        <td>
                        <c:choose>
                        	<c:when test="${list.loanType == 0}">
                        		未审核
                        	</c:when>
                        	<c:when test="${list.loanType == 1}">
                        		已审核
                        	</c:when>
                        </c:choose>
                        </td>
                        <td>
                        <c:if test="${list.loanAMoney == 0}">
                        	<a href="<%=basePath%>/loan/updateLoan.html?loanId=${list.loanID}">
                        	<strong>拨款</strong></a>
                        </c:if>
                        </td>
                    </tr>
                    </c:forEach>

                </table>
            </div>
            <div class="ui_tb_h30">
                <div class="ui_flt" style="height: 30px; line-height: 30px;">
                    共有
                    <span class="ui_txt_bold04">${totalCount}</span>
                    条记录，当前第
						<span class="ui_txt_bold04">${currentPageNo}
						/
						${totalpageCount}</span>
                    页
                </div>
                <div class="ui_frt">
                    <!--    如果是第一页，则只显示下一页、尾页 -->
                    <c:if test="${currentPageNo > 1 }">
                    <a href="<%=basePath%>/loan/aaa.html?loanId=${loanId }&pageIndex=1"><input type="button" value="首页" class="ui_input_btn01"/>
                    <a href="<%=basePath%>/loan/aaa.html?loanId=${loanId }&pageIndex=${currentPageNo - 1 }"><input type="button" value="上一页" class="ui_input_btn01" /></a>
                    </c:if>
                    <c:if test="${currentPageNo < totalpageCount }">
                    <a href="<%=basePath%>/loan/aaa.html?loanId=${loanId }&pageIndex=${currentPageNo + 1 }"><input type="button" value="下一页" class="ui_input_btn01"
                           onclick="jumpNormalPage(2);" /></a>
                    <a href="<%=basePath%>/loan/aaa.html?loanId=${loanId }&pageIndex=${totalpageCount}"><input type="button" value="尾页" class="ui_input_btn01"
                           onclick="jumpNormalPage(9);" /></a>
                     </c:if>
                    <!--     如果是最后一页，则只显示首页、上一页 -->
                </div>
            </div>
        </div>
    </div>
</form>

</body>
</html>