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
	<form method="post" action="${ctx}/classSearch" id="listform">
		<div class="panel admin-panel">
			<div class="padding border-bottom">
				<ul class="search" style="padding-left:10px;">
						
					<if condition="$iscid eq 1">
					<li>
						<select  name="date" id="arg"  class="input"
							style="margin-left:30px;width:250px; line-height:17px;">
								<option value="">按年级筛选</option>
							<option onclick="selectdate(this.value)" value="1">大一</option>
							<option value="2" onclick="selectdate(this.value)">大二</option>
							<option value="3" onclick="selectdate(this.value)">大三</option>
							<option value="4" onclick="selectdate(this.value)">大四</option>
							<option value="5" onclick="selectdate(this.value)">研一</option>
							<option value="6" onclick="selectdate(this.value)">研二</option>
							<option value="7" onclick="selectdate(this.value)">研三</option>
						</select>
						<script type="text/javascript">
							$("select[name='date']").val("${date}");
						</script>
					</li>
					</if>
					
					<li><input type="text" placeholder="请输入搜索关键字" id="key"
						class="input"	style="width:250px; margin-left:20px;line-height:17px;display:inline-block" value="${key}"/> 
						<a href="#" class="button border-main icon-search"
						onclick="Sear()"> 搜索</a></li>
					<script type="text/javascript">
					</script>
					
				</ul>
			</div>
			<table class="table table-hover text-center">
				<tr>
					<th width="20"></th>
					<th width="15%">班级名称</th>
					<th width="15%">辅导员</th>
					<th width="100">辅导员电话</th>
					<th width="100">所属学院</th>	
					<th width="100">年级</th>
				</tr>

				<c:forEach items="${dataList}" var="obj" varStatus="status">
					<tr class="leirong">
					<td style="text-align:left; padding-left:20px;"></td>
						<td style="text-align:left; padding-left:20px;display:none"><input
							type="checkbox" name="announcementId"
							value="${obj.classId}" class="sb" /></td>
						<td>${obj.className}</td>
						<td>${obj.coach}</td>
						<td width="10%">${obj.coachCall}</td>
						<td>${obj.collegeId}</td>
						<td>${obj.grade}</td>
						<td><div class="button-group" style="height:50px;">
					
									
									
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
			//window.location.href='${ctx}/cla/list.action?arg='+encodeURI(encodeURI(arg)); 
            	if(arg!=null){
    				$.ajax({
    					type : 'post',
    					url : '${ctx}//classSearch', 
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
		}									
		
	
		//搜索
		function Sear(){
			var key=$("#key").val();
			var arg1=$("#arg").val();
			//window.location.href='${ctx}/classSear?key='+encodeURI(encodeURI(key));
			$.ajax({
				type : 'post',
				url : '${ctx}/classSear', 
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

	</script>
</body>
</html>