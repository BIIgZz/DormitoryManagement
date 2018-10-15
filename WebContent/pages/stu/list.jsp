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

	<form method="post" action="../../studentSearch" id="listform">
		<div class="panel admin-panel">
			<div class="padding border-bottom">
				<ul class="search" style="padding-left:5px;">
					<if condition="$iscid eq 1">
					
					<c:if test="${sessionScope.user.type=='root' or sessionScope.user.type=='manager'}">
								<li>
									<select  id="status" class="input"
										style="margin-left:0px;width:150px; line-height:17px;">
											<option value="">按是否分配宿舍筛选</option>
										<option  value="N" onclick="selectdate(this.value)">未分配宿舍</option>
										<option value="Y" onclick="selectdate(this.value)">已分配宿舍</option>
									</select>
									<script type="text/javascript">
							$("select[name='date']").val("${date}");
						</script>
								</li>				<li>
									<select  id="college" class="input"
										style="margin-left:0px;width:110px; line-height:17px;" onclick="selectdate(this.value)">
											<option value="">按学院筛选</option>
											<c:forEach var="s" items="${collegeList}">
                            					 <option value="${s.collegeId}">${s.collegeName}</option>
                        					 </c:forEach>
									</select>
									<script type="text/javascript">
							$("select[name='date']").val("${date}");
						</script>
								</li>				<li>
									<select  id="grade" class="input"
										style="margin-left:0px;width:110px; line-height:17px;">
											<option value="">按年级筛选</option>
										<option  value="1" onclick="selectdate(this.value)">大一</option>
										<option value="2" onclick="selectdate(this.value)">大二</option>
										<option value="3" onclick="selectdate(this.value)">大三</option>
										<option value="4" onclick="selectdate(this.value)">大四</option>
										<option value="5" onclick="selectdate(this.value)">研一</option>
										<option value="6" onclick="selectdate(this.value)">研二</option>
										<option value="7" onclick="selectdate(this.value)">研三</option>
									</select>
								</li>		<li>
									<select  id="sex" class="input"
										style="margin-left:0px;width:110px; line-height:17px;">
											<option value="">按性别筛选</option>
											<option value="男" onclick="selectdate(this.value)">男</option>
											<option value="女" onclick="selectdate(this.value)">女</option>
									</select>
								
								</li>
								</if>
								<li><input type="text" placeholder="模糊查询" id="key"
									class="input"	style="width:100px; margin-left:0px;line-height:17px;display:inline-block" value="${key}"/> 
									<a href="#" class="button border-main icon-search"
									onclick="Sear()">搜索</a></li>
									<a href="#" class="button border-main icon-search"
									onclick="Reset()">重置</a>								
					
					</c:if>
					
					
				</ul>
			</div>

		<c:if test="${sessionScope.user.type=='root' or sessionScope.user.type=='manager'}">
				<script type="text/javascript">
					var status="${status}";
					var grade="${grade}";
					var sex="${sex}";
	
					$("#status").val(status);				
					$("#grade").val(grade);				
					$("#sex").val(sex);				
					
				
				
					 /* $.ajax({
						 type: "GET",
			             url: "${ctx}/cl/getdata.action",
			             data: {},
			             dataType: "json",
			             success:function(data){
			             	alert(data);
			             	$("#college").empty();
		             		$("#college").append('<option>按学院筛选</option>');
			             	$.each(data,function(index,item){
			             		$("#college").append('<option value="'+item["collegeId"]+'">'+item["collegeName"]+'</option>');
			             	});
			             },
			             error:function(){
			             	alert("eeror json");
			             }
					});  */
					$.ajax({
						type: "GET",
						url: "${ctx}/disbycla",
						data: {},
						dataType:"json",
						success:function(data){
							console.log(data);
			             	$("#college").empty();
		             		$("#college").append('<option value="">按学院筛选</option>');
			             	$.each(data,function(index,item){
			             		$("#college").append('<option onclick="selectdate(this.value)" value="'+item["collegeId"]+'">'+item["collegeName"]+'</option>');
			             	}             	
			             	);
			 				if("${college}"!=null)	$("#college").val("${college}");
						},error:function(){
							console.log('error.....');
						}
					});
	 				
					
					function Reset(){
							
						$("#status").val("");				
						$("#grade").val("");				
						$("#sex").val("");				
						$("#college").val("");
						$("#key").val("");
												
					}
					function FinalSearch(){
						var status=$("#status").val();
						
						var college;
						if($("#college").val()!=null){
							college=$("#college").val();
						}else {
							college=null;
						}
						var grade=encodeURI(encodeURI($("#grade").val()));
						var sex="";
						if($("#sex").val()!=null){
							sex=encodeURI(encodeURI($("#sex").val()));
						}else{
							sex=null;
						} 
						window.location.href="${ctx}/stu/list.action?status="+status+"&college="+college+"&grade="+grade+"&sex="+sex;
						
					}
					
					
				</script>

			</c:if>

			<table class="table table-hover text-center">
				<tr >
					<th width="20"></th>
					<th width="50">姓名</th>
					<th width="7%">学号</th>
					<th width="5%">性别</th>
					<th width="70">是否分配宿舍</th>
					<th width="80">所在宿舍</th>
					<th width="80">班级</th>
					<th width="50">年级</th>
					<th width="50">学院</th>
					<th width="100"></th>
				</tr>

				<c:forEach items="${dataList}" var="obj" varStatus="status">
					<tr class="leirong">
					<td style="text-align:left; padding-left:20px;"></td>
						<td style="text-align:left; padding-left:20px;display:none"><input
							type="checkbox" name="studentId"
							value="${obj.studentId}" class="sb" /></td>
						<td>${obj.studentName}</td>
						<td>${obj.studentNo}</td>
						<td>${obj.sex}</td>
						<td>${obj.status}</td>
						<td>${obj.bedroomName}</td>
						<td>${obj.className}</td>
						<td>${obj.grade}</td>
						
						<td>${obj.collegeName}</td>
					</tr>
				</c:forEach>
			</table>
		</div>
	</form>
	<c:if test="${sessionScope.user.type=='root' or sessionScope.user.type=='manager'}">
	
	<script type="text/javascript">
			/* var key="${key}";
			alert(key);
		$("input[name='arg']").each(function(){
			if($(this).val()==${arg}){
				alert("pipei");
				$(this).attr("selected","selected");
			}
		}); */	
		
	</script>
	
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
            	var arg1=$("#status").val();
       			var arg2=$("#college").val();
       			var arg3=$("#grade").val();
       			var arg4=$("#sex").val();
       			
                   	if(arg!=null){
           				$.ajax({
           					type : 'post',
           					url : '${ctx}/studentSearch', 
           					data : {
           						status:arg1,
           						college:arg2,
           						grade:arg3,
           						sex:arg4
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
			var arg=$("#key").val();

			//window.location.href='${ctx}/announceSearch?key='+encodeURI(encodeURI(key))+'&date='+arg1;
			
				$.ajax({
					type : 'post',
					url : '${ctx}/studentSear', 
					data : {
						key:arg,
	
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

		function warningUp(){
			alert("您没有修改权限！");
		}
		
		function warningDe(){
			alert("您没有删除权限！");
		}

	</script>
	
	
	</c:if>
	
</body>
</html>