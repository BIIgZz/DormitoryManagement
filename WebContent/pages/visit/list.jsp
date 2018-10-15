<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>

<%@ include file="../basic/base.jsp"%>
<!DOCTYPE html>

<html lang="zh-cn">
<head>
		<link rel="stylesheet" href="../../css/pintuer.css">
<link rel="stylesheet" href="../../css/pintuer.css">
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
	<form method="post" action="../../visitorSearch" id="listform">
		<div class="panel admin-panel">
			
				<c:if test="${sessionScope.user.type=='root' or sessionScope.user.type=='manager'}">
			
				<div class="padding border-bottom">
				<ul class="search" style="padding-left:5px;">
					<li>
						<a class="button border-main icon-plus-square-o"
						href="http://localhost:8080/dormitoryManage/pages/visit/create.jsp"> 来访登记</a>
						</li>
					<if condition="$iscid eq 1">
					<li>
						<select  id="arg1" class="input"
							style="margin-left:0px;width:170px; line-height:17px;">
								<option value="">按来访日期筛选</option>
							<option  value="3" onclick="selectdate(this.value)">三天内</option>
							<option value="7" onclick="selectdate(this.value)">一周内</option>
							<option  value="30" onclick="selectdate(this.value)">一月内</option>
						</select>
						<script type="text/javascript">
							$("select[name='date']").val("${date}");
						</script>
					</li>				<li>
						<select  id="arg2" class="input"
							style="margin-left:0px;width:170px; line-height:17px;">
								<option value="">按来访宿舍筛选</option>
						</select>
						<script type="text/javascript">
							$("select[name='date']").val("${date}");
						</script>
					</li>				
					
					
					</if>
					<li><input type="text" placeholder="模糊查询" id="key"
						class="input"	style="width:150px; margin-left:0px;line-height:17px;display:inline-block" value="${key}"/> 
						<a href="#" class="button border-main icon-search"
						onclick="Sear()">搜索</a></li>
						<a href="#" class="button border-main icon-search"
						onclick="Reset()">重置</a>					
											
					
				</ul>
			</div>

			</c:if>

	<c:if test="${sessionScope.user.type=='root' or sessionScope.user.type=='manager'}">
			<script type="text/javascript">
				$("#arg1").val("${arg1}");
				$("#arg2").val("${arg2}");
				$("#key").val("${key}");
				$.ajax({
					 type: "GET",
		             url: "${ctx}/getBedroom",
		             data: {},
		             dataType: "json",
		             success:function(data){
		            	 //alert(data);
		             	$("#arg2").empty();
	             		$("#arg2").append('<option value="">按来访宿舍筛选</option>');
		             	$.each(data,function(index,item){
		             		$("#arg2").append('<option onclick="selectdate(this.value)" value="'+item["bedroomName"]+'">'+item["bedroomName"]+'</option>');
		             	});
		             },
		             error:function(){
		             }
				}); 
				function Reset(){
					
					$("#arg1").val("");				
					$("#arg2").val("");				
											
				}
				function FinalSearch(){
					var	arg1=$("#arg1").val();
					 
					if(arg1!=null && arg1!='' ){
						arg1=$("#arg1").val();
					}else {
						arg1=null;
					}
					var arg2=$("#arg2").val();
					if(arg2!=null && arg2!=null ){
						arg2=$("#arg2").val();
					}else {
						arg2=null;
					}
					window.location.href="${ctx}/visit/list.action?arg1="+arg1+"&arg2="+arg2;
					
				}
				
				
				
				
 	/* 			$.ajax({
					type: "GET",
					url: "${ctx}/cl/getdata.action",
					data: {},
					dataType:"json",
					success:function(data){
		             	$("#college").empty();
	             		$("#college").append('<option value="">按学院筛选</option>');
		             	$.each(data,function(index,item){
		             		$("#college").append('<option value="'+item["collegeId"]+'">'+item["collegeName"]+'</option>');
		             	});
					},error:function(){
					}
				});
 				if("${college}"!=null)	$("#college").val("${college}");
								
 */				
			</script>

	</c:if>

			<table class="table table-hover text-center ">
				<tr >
					<th width="10"></th>
					<th style="text-align: center;" width="50">访客姓名</th>
					<th style="text-align: center;" width="7%">电话</th>
					<th style="text-align: center;" width="5%">性别</th>
					<th style="text-align: center;" width="50">来访宿舍</th>
					<th style="text-align: center;" width="130">备注</th>
					<th style="text-align: center;" width="80">日期</th>
					<th style="text-align: center;" width="100"></th>
				</tr>

				<c:forEach items="${dataList}" var="obj" varStatus="status">
					<tr class="leirong">
						<td style="text-align:left; padding-left:20px;">
						<input
							type="checkbox" name="visitorId"
							value="${obj.visitorId}" class="sb" /></td>
						<td>${obj.visitorName}</td>
						<td>${obj.visitorCall}</td>
						<td>${obj.visitorSex}</td>
						<td>${obj.bedroomName}</td>
						<td>${obj.reason}</td>
						<td>${obj.visitorDate}</td>
						<td><div class="button-group" style="height:48px;">
								<c:if test="${sessionScope.user.type=='root' or sessionScope.user.type=='manager'}">
									<a class="button border-main"
									href="${ctx}/visitorUpdate?visitorId=${obj.visitorId}"><span
									class="icon-edit"></span>修改</a> <a  id="deleteBtn" class="button border-red"
									href="${ctx}/visitorDelete?visitId=${obj.visitorId}"
									><span class="icon-trash-o"></span>
									删除</a>
								</c:if>
									
									
							</div></td>
					</tr>
				</c:forEach>
	
				<c:if test="${sessionScope.user.type=='root' or sessionScope.user.type=='manager'}">
				
				<tr>
					<td style="text-align:left; padding:19px 0;padding-left:20px;">
					<input	type="checkbox" id="checkall" onchange="checkallClick()"/></td>
					<td colspan="7" style="text-align:left;padding-left:20px;">
						<a	href="" class="button border-red icon-trash-o"
						style="padding:5px 15px;" onclick="DelSelect()"> 删除</a>
				</tr>
				
				</c:if>
				
			</table>
		</div>
	</form>

	
<script type="text/javascript">
	
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
	/* 	function selectdate(arg){
			window.location.href='${ctx}/visit/list.action?arg='+encodeURI(encodeURI(arg)); 
		} */	
            
   		//下拉列表 分类
   		function selectdate(arg){
			var str1=$("#arg1").val();
   			var str=$("#arg2").val();
   			//window.location.href='${ctx}/cla/list.action?arg='+encodeURI(encodeURI(arg)); 
               	if(arg!=null){
       				$.ajax({
       					type : 'post',
       					url : '${ctx}/visitorSearch', 
       					data : {
       						date:str1,
       						bedroom:str
       					},
       					success : function(msg) {
       						
       						$('.table.table-hover.text-center')[0].innerHTML = msg;
       						var str = $('.table.table-hover.text-center .table.table-hover.text-center')[0].innerHTML;
       						$('.table.table-hover.text-center')[0].innerHTML = str;
       						
       					
       						//console.log(msg);
       					}
       				});
       			
       			}
   		}	
	
	
		/* //搜索
		function Sear(){
			var key=$("#key").val();
			window.location.href='${ctx}/visit/list.action?key='+encodeURI(encodeURI(key));
			return false;
		} */
		
		//搜索
		function Sear(){
			var key=$("#key").val();
			var arg1=$("#arg").val();

			//window.location.href='${ctx}/announceSearch?key='+encodeURI(encodeURI(key))+'&date='+arg1;
			
				$.ajax({
					type : 'post',
					url : '${ctx}/visitorSear', 
					data : {
						key:key,
						date:arg1		
					},
					success : function(msg) {
						
						$('.table.table-hover.text-center')[0].innerHTML = msg;
						var str = $('.table.table-hover.text-center .table.table-hover.text-center')[0].innerHTML;
						$('.table.table-hover.text-center')[0].innerHTML = str; 
						
					
						console.log(msg);
					}
				});
			
			
			
			return false;
		}

		//单个删除
/* 		function del(id, mid, iscid) {
			if (confirm("您确定要删除吗?")) {
				var a=0;
				$(".leirong").each(function(){
					a++;
				});
				if(a==1){
					var id=$(".sb").val();
					window.location.href="${ctx}/visit/deletebyid.action?visitId="+id+"&pageNo=${page.pageNo-1}&totalPage=${page.totalPage-1}";
					return false;
				}
					
			}else {
				return false;
			}
		} */

		//全选
		function checkallClick(){
			$("input[name='visitorId']").each(function() {
				if (this.checked) {
					this.checked = false;
				} else {
					this.checked = true;
				}
			});
		}
		

		//批量删除
		function DelSelect() {

			var Checkbox = false;
			var quanshan=true; 
			var ff = "";
			$("input[name='visitorId']").each(function(x, y) {
				if (this.checked == true) {
					Checkbox = true;
					ff += $(this).val() + " ";
				}
				else quanshan=false;
			});
			console.log(ff);
			if (Checkbox) {
				var t = confirm("您确认要删除选中的内容吗？");
				if (t == false) {
					return false;
				}
				$.ajax({
					type : 'post',
					url : '${ctx}/visitorDeleteAll',
					dateTye:'text',
					data : {
						sb : ff
					},
					success:function(msg){
					},error:function(){
						alert("error");
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