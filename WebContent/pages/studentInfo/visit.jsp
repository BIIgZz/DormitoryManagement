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
</head>
<body onload="fun()">
	<form method="post" action="${ctx}/visit/list.action" id="listform">
		<div class="panel admin-panel">
			<table class="table table-hover text-center">
				<tr>
					<th width="10%">访客姓名</th>
					<th width="10%">电话</th>
					<th width="5%">性别</th>
					<th width="20%">来访宿舍</th>
					<th width="130">备注</th>
					<th width="80">日期</th>
				</tr>

				<tr class="leirong" id="cloneTr">
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
<script type="text/javascript" src="../../js/jquery.js"></script>
	<script >
		
		var l="${sessionScope.stu.bedroomName}";
		function fun(){   		 	
			$.ajax({
				url:"../../visitorServlet",
				type:"POST",
				dataType:"Json",
				data:{h:l},
		        success : function(data){   
		        	flushInfo(data);
				},
		        error:function(){
		        	alert("stuInfo");	
		        }
		        });
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
						$(this).html(item.visitorName);
						break;
					case(1):
						   $(this).html(item.visitorCall);
						break;
					 case(2):
                         $(this).html(item.visitorSex);
                         break;
                     case(3):
                         $(this).html(item.bedroomName);
                         break;
                     case(4):
                         $(this).html(item.reason);
                         break;
                     case(5):
                         $(this).html(item.visitorDate);
                         break;

					}
				});
                ct.insertAfter(tr);

			});
			tr.hide();
		}
		
	</script>
</body>
</html>