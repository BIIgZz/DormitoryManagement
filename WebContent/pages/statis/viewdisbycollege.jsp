<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ include file="../basic/base.jsp"%>
<!DOCTYPE html>
<html lang="zh-cn">

<head>
	<link rel="stylesheet" href="../../../css/pintuer.css">
	<link rel="stylesheet" href="../../../css/admin.css">
	<script src="../../../js/jquery.js"></script>
	<script src="../../../js/pintuer.js"></script>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no" />
	<meta name="renderer" content="webkit">
	<title></title>
</head>

<body>
	<div class="panel admin-panel">
		<div class="panel-head" id="add"><strong><span class="icon-pencil-square-o"></span>查看college学生宿舍分配情况</strong></div>
		<div class="body-content">

			<!--根据学院取所属班级 http://localhost:8080/domt/cla/getdata.action?collegeId=2f11518b -->
			<select id="college" class="input" name="classId" style="margin-left:60px;width:220px;float:left; line-height:17px;">
				<option value="">选择所属区</option>
				<option value="1">西苑</option>
				<option value="2">东苑</option>
				<option value="3">南苑</option>
				<option value="4">北苑</option>
			</select>

		</div>

		<div class="field">
			<button style="margin-left:100px;margin-top:30px;width:200px;" class="submit button bg-main icon-check-square-o"
			 type="submit">
				提交</button>
		</div>

	</div>

</body>
<script>
	college.onchange = function () {

		sessionStorage.setItem('regionId', this.value);
		
		window.location.href = './displayDormitory.jsp';

	}
</script>

</html>