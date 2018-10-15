<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>

<%@ include file="../basic/base.jsp"%>
<!DOCTYPE html>

<html lang="zh-cn">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport"
	content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no" />
<meta name="renderer" content="webkit">
<title></title>
<style>
	.nobg{
		background: url(../../images/bedroombg.gif);
				height: 300px;
	}
</style>
</head>
<body onload="fun()">
	<form method="post" action="${ctx}/visit/list.action" id="listform">
		<div class="panel admin-panel">
			<div class="nobg" id="nobed"></div>
			<table class="table table-hover text-center" id="FK">
				<tr>
					<th width="15%">姓名</th>
					<th width="7%">性别</th>
					<th width="15%">学号</th>
					<th width="20%">学院</th>
					<th width="15%">班级</th>
					<th width="10%">宿舍号</th>
					<th width="50">入学年份</th>
				</tr>

					<tr class="leirong" id="cloneTr">
						<td></td>
						<td></td>
						<td></td>
						<td></td>
						<td></td>
						<td></td>
						<td></td>
					</tr>
				
			</table>
		</div>
	</form>
	<script type="text/javascript" src="../js/jquery.js"></script>
	<script>
	$("#FK").hide();
	$("#nobed").hide();
	var id=${sessionScope.stu.studentId};	
	//var l="${sessionScope.stu.bedroomId}";	
	var kk="${sessionScope.stu.bedroomName}";
	
	function fun(){
		if(kk==null||kk==""){
        	$("#nobed").show();
		}
		else{
		$.ajax({
			url:"${ctx}/bedroomServlet",
			type:"POST",
			dataType:"Json",
			data:{bedNum:kk,
				  stuId:id
			},
	        success : function(data){    
	        	if(data==null||data==""){
	        	$("#nobed").show();
	        	}
	        	else{
	        		$("#FK").show();
	        		flushInfo(data);
	        	}
			},
	        error:function(){
	        	alert("failed");	
	        }
	        });
		}
	}

		function flushInfo(data){
			var tr=$("#cloneTr");
			$.each(data,function(index,item)
			{
				var ct=tr.clone();
				var _index=index;
				ct.children("td").each(function(inner_index){
					switch(inner_index){
					case(0):
						$(this).html(item.studentName);
						break;
					case(1):
						    var s=item.sex;
						    if(s.indexOf("b")!=-1)
							    $(this).html("男");
							else
						    	$(this).html("女");
						break;
					 case(2):
                         $(this).html(item.studentPassword);
                         break;
                     case(3):
                         $(this).html(item.collegeName);
                         break;
                     case(4):
                         $(this).html(item.className);
                         break;
                     case(5):
                         $(this).html(item.bedroomName);
                         break;
					 default:
					 	 $(this).html(item.grade);

					}
				});
                ct.insertAfter(tr);

			});
			tr.hide();
		}
		
	</script>
</body>
</html>