<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ include file="../basic/base.jsp"%>
<!DOCTYPE html>

<html lang="zh-cn">
<head>
		<link rel="stylesheet" href="../../css/pintuer.css">
<link rel="stylesheet" href="../../css/admin.css">
<script src="../../js/jquery.js"></script>
<script src="../../js/pintuer.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport"
	content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no" />
<meta name="renderer" content="webkit">
<title></title>
</head>
<body>
	<form method="post" action="../../announceSearch" id="listform">
		<div class="panel admin-panel">
			<div class="padding border-bottom">
				<ul class="search" style="padding-left:10px;">
					<li>
					<c:if test="${sessionScope.user.type=='root' or sessionScope.user.type=='manager'}">
						<a class="button border-main icon-plus-square-o"
						href="http://localhost:8080/dormitoryManage/pages/anno/create.jsp"> 添加内容</a>
					</c:if>
						</li>
					<if condition="$iscid eq 1">
					<li>
						<select name="date" class="input ds-arg" id="arg"
							style="margin-left:30px;width:250px; line-height:17px;">
								<option value="" >按日期分类</option>
								<option value="3" >三天内</option>
								<option value="7">一周内</option>
								<option value="30" >一个月内</option>
						</select>
						<script type="text/javascript">
							$("select[name='date']").val("${date}");
						</script>
					</li>
					</if>
					<li><input type="text" placeholder="请输入搜索关键字" id="key" value="${key}"
						class="input"	style="width:250px; margin-left:20px;line-height:17px;display:inline-block" /> 
						<a href="#" class="button border-main icon-search"
						onclick="Sear()"> 搜索</a></li>
				</ul>
			</div>
			<table class="table table-hover text-center DS">
				<tr>
					<th width="5%"></th>
					<th width="20%">时间</th>
					<th width="40%">标题</th>
					 
					<th width="200">操作</th>
				</tr>

				<c:forEach items="${dataList}" var="obj" varStatus="status">
					<tr class="leirong">
						<td style="text-align:left; padding-left:20px;">
						<input
							type="checkbox" name="announcementId"
							value="${obj.announcementId}" class="sb" /></td>
						<td>${obj.createTime}</td>
						<td width="10%">${obj.title}</td>
						 
						<td><div class="button-group" style="height:48px;">
							<c:if test="${sessionScope.user.type=='root' or sessionScope.user.type=='manager'}">
								<a class="button border-main" href="${ctx}/announceUpdate?annoId=${obj.announcementId}">
								<span class="icon-edit"></span>修改</a>
								<a  id="deleteBtn" class="button border-red ds-delete" 
								href="${ctx}/announcementDelete?annoId=${obj.announcementId}"
									><span class="icon-trash-o"></span>
									删除</a>
							</c:if>
									
									
							</div></td>
					</tr>
				</c:forEach>
	
				<tr>
					<td style="text-align:left; padding:19px 0;padding-left:20px;">
					<input	type="checkbox" id="checkall" onchange="checkallClick()"/></td>
					<td colspan="7" style="text-align:left;padding-left:20px;">
					<c:if test="${sessionScope.user.type=='root' or sessionScope.user.type=='manager'}">
						<a	href="" class="button border-red icon-trash-o"
						style="padding:5px 15px;" onclick="DelSelect()"> 删除</a>
					</c:if>
				</tr>
			</table>
		</div>
	</form>



	<script type="text/javascript">
	

		
	</script>
	
	<script type="text/javascript">
	console.log(2322323232323);
	setTimeout(function () {
		window.frames.document.querySelector('.input').selectedIndex = 0;
	}, 30);
	
	
	/* $.ajax({
                cache: true,
                type: "POST",
                url:ajaxCallUrl,
                data:$('#yourformid').serialize(),// 你的formid
                async: false,
                error: function(request) {
                    alert("Connection error");
                },
                success: function(data) {
                    $("#commonLayout_appcreshi").parent().html(data);
                }
            }); */
	
		//下拉列表 分类
		var argument = document.querySelector('.ds-arg');
        argument.onchange = function selectdate(){
		//	window.location.href= '${ctx}/announceSearch?date='+arg; 
		var arg  = this.value;
		console.log(11, arg);
		 	if(arg!=null){
				$.ajax({
					type : 'post',
					url : '${ctx}/announceSearch', 
					data : {
						date:arg		
					},
					success : function(msg) {
						
						$('.table.table-hover.text-center')[0].innerHTML = msg;
						var str = $('.table.table-hover.text-center .table.table-hover.text-center')[0].innerHTML;
						$('.table.table-hover.text-center')[0].innerHTML = str;
						
						
						doDelete();
					
						//console.log(msg);
					}
				});
			
			}
		 	
		}

		
            function doDelete(){
            	var del = document.querySelectorAll('.ds-delete');
				del.forEach((ele) => {
					ele.onclick = function (e) {
						e.preventDefault();

						reg = /annoId=(.*)$/g;
						var id = reg.exec(this.href)[1];

						if (confirm("您确定要删除吗?")) {
							//window.location.href = "${ctx}/announcementDelete?annoId=${obj.announcementId}";
							$.ajax({
								type : 'post',
								url : '${ctx}/announcementDelete', 
								data : {	
									annoId: id
								},
								success : function(msg) {
									console.log(msg);
									/*  $('.table.table-hover.text-center')[0].innerHTML = msg;
									var str = $('.table.table-hover.text-center .table.table-hover.text-center')[0].innerHTML;
									$('.table.table-hover.text-center')[0].innerHTML = str;  */
									 $('.panel.admin-panel')[0].innerHTML = msg;
									var str = $('.panel.admin-panel .panel.admin-panel')[0].innerHTML;
									$('.panel.admin-panel')[0].innerHTML = str;
							
									console.log(msg);
								},
								error: function(e){
									console.log('error.....');
								}
								
							});
						}else {
							return false;
						}
					}
				})
            }
	
		//搜索
		function Sear(){
			var key=$("#key").val();
			var arg1=$("#arg").val();

			//window.location.href='${ctx}/announceSearch?key='+encodeURI(encodeURI(key))+'&date='+arg1;
			
				$.ajax({
					type : 'post',
					url : '${ctx}/announceSear', 
					data : {
						key:key,
						date:arg1		
					},
					success : function(msg) {
						console.log(msg);
						 /*$('.table.table-hover.text-center')[0].innerHTML = msg;
						var str = $('.table.table-hover.text-center .table.table-hover.text-center')[0].innerHTML;
						$('.table.table-hover.text-center')[0].innerHTML = str;*/  
				 
				 //console.log($('.panel.admin-panel'));
				 $('.panel.admin-panel')[0].innerHTML = msg;
						var str = $('.panel.admin-panel .panel.admin-panel')[0].innerHTML;
						$('.panel.admin-panel')[0].innerHTML = str;
					}
				});
			
			
			
			return false;
		}
		/* var ds = document.querySelector('.DS');
		ds.onclick = function (e) {
			console.log(e.target);
			
		}
 */		/* //单个删除
		deleteBtn.onclick = function del(e) {
			e.preventDefault();
			console.log(1111);
			if (confirm("您确定要删除吗?")) {
				window.location.href = "${ctx}/anno/deletebyid.action?annoId=" + ${obj.announcementId};
			}else {
				return false;
			}
		} */
		
		

		//全选
		function checkallClick(){
			$("input[name='announcementId']").each(function() {
				if (this.checked) {
					this.checked = false;
				} else {
					this.checked = true;
				}
			});
		}
		/* $("#checkall").click(function() {
			$("input[name='announcementId']").each(function() {
				if (this.checked) {
					this.checked = false;
				} else {
					this.checked = true;
				}
			});
		}) */

		//批量删除
		function DelSelect() {
			var Checkbox = false;
			var quanshan=true; 
			var ff = "";
			$("input[name='announcementId']").each(function(x, y) {
				if (this.checked == true) {
					Checkbox = true;
					ff += $(this).val() + ",";
				}
				else quanshan=false;
			});
			
			if (Checkbox) {
				var t = confirm("您确认要删除选中的内容吗？");
				if (t == false) {
					return false;
				}
				$.ajax({
					type : 'post',
					url : '${ctx}/announcementDeleteAll',
					dateTye:'text',
					data : {
						sb : ff
					},
					success:function(msg){
					},error:function(){
						
					}
					
				});
				
			} else {
				alert("请选择您要删除的内容!");
				return false;
			}
		}
	</script>
</body>
</html>