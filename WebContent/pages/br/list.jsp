<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>

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
	<form method="post" action="../../bedroomSearch" id="listform">
		<div class="panel admin-panel">
			<div class="padding border-bottom">
				<ul class="search" style="padding-left:10px;">
					
					<if condition="$iscid eq 1">
					<li>
						<select name="date" id="arg" class="input"
							style="margin-left:30px;width:250px; line-height:17px;">
								<option value="">按是否住满分类</option>
								<option value="N" onclick="selectdate(this.value)">没住满</option>
								<option value="Y" onclick="selectdate(this.value)">住满</option>
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
			<table class="table table-hover text-center">
				<tr>
					<th width="5%"></th>
					<th width="10%">宿舍名称</th>
					<th width="15%">所属公寓</th>
					<th width="15%">已住人数</th>
					<th width="100">是否住满</th>
					<th width="100"></th>
					
				</tr>

				<c:forEach items="${dataList}" var="obj" varStatus="status">
					<tr class="leirong" >
						<td style="text-align:left; padding-left:20px;"></td>
						<td style="text-align:left; padding-left:20px; display:none;"><input
							type="checkbox" name="announcementId"
							value="${obj.bedroomId}" class="sb" />
							</td>
						<td>${obj.bedroomName}</td>
						<td>${obj.apartmentId}</td>
						<td width="10%">${obj.totalBed}</td>
						<td>${obj.status}</td>
						<td><div class="button-group" style="height:50px;">
							<c:if test="${sessionScope.user.type=='root'}">
								<a class="button border-main"
									href="${ctx}/bedroomUpdate?brId=${obj.bedroomId}"><span
									class="icon-edit"></span>修改</a> <!-- <a  id="deleteBtn" class="button border-red"
									href="${ctx}/br/deletebyid.action?brId=${obj.bedroomId}"
									onclick="return del(1,1,1)"><span class="icon-trash-o"></span>
									删除</a> -->
							</c:if>
							<c:if test="${sessionScope.user.type=='manager'}">
								<a class="button border-main"
									href="${ctx}/bedroomUpdate?brId=${obj.bedroomId}"><span
									class="icon-edit"></span>修改</a> 
							</c:if>
							</div></td>
					</tr>
				</c:forEach>
	

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
		function selectdate(arg){
			//window.location.href='${ctx}/apartmentSearch?arg='+arg; 
            	 if(arg!=null){
    				$.ajax({
    					type : 'post',
    					url : '${ctx}/bedroomSearch', 
    					data : {
    						date:arg		
    					},
    					success : function(msg) {
    						
    						$('.table.table-hover.text-center')[0].innerHTML = msg;
    						var str = $('.table.table-hover.text-center .table.table-hover.text-center')[0].innerHTML;
    						$('.table.table-hover.text-center')[0].innerHTML = str;
    						
    					
    						//console.log(msg);
    					}
    				});
    		
    			} 
		/* 	if(arg!=null){
				$.ajax({
					type : 'post',
					url : '${ctx}/br/list.action', 
					data : {
						date:arg		
					},
					success : function(msg) {
					}
				});
			
			}
		 */		
		}									
		
	
		//搜索
		function Sear(){
			var key=$("#key").val();
			var arg1=$("#arg").val();
			//window.location.href='${ctx}/bedroomSear?key='+encodeURI(encodeURI(key))+'&date='+arg;
			$.ajax({
				type : 'post',
				url : '${ctx}/bedroomSear', 
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
		function del(id, mid, iscid) {
			if (confirm("您确定要删除吗?")) {
				var a=0;
				$(".leirong").each(function(){
					a++;
				});
				if(a==1){
					var id=$(".sb").val();
					window.location.href="${ctx}/br/deletebyid.action?annoId="+id;
					return false;
				}
					
			}else {
				return false;
			}
		}
		//警告
		function warning() {
			if (confirm("您确定要删除吗?")) {
				alert("您没有权限删除！");
					
			}else {
				return false;
			}
		}

		//全选
		$("#checkall").click(function() {
			$("input[name='announcementId']").each(function() {
				if (this.checked) {
					this.checked = false;
				} else {
					this.checked = true;
				}
			});
		})

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
					url : '${ctx}/br/delete.action',
					dateTye:'text',
					data : {
						sb : ff,
						pageNo : ${page.pageNo-1},
						totalPage : ${page.totalPage-1}
					},
					success:function(msg){
					},error:function(){
							if(quanshan){
								if("${page.pageNo}"!='1') window.location.href="${ctx}/br/list.action?pageNo=${page.pageNo-1}&totalPage=${page.totalPage-1}";
								else  window.location.href="${ctx}/br/list.action?pageNo=${page.pageNo}&totalPage=${page.totalPage-1}";
							}
							else	
							window.location.href="${ctx}/br/list.action?pageNo=${page.pageNo}&totalPage=${page.totalPage}";
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