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
  <div class="panel-head" id="add"><strong><span class="icon-pencil-square-o"></span>按个人腾空宿舍</strong></div>
  <div class="body-content">
    <form method="post" class="form-x" action="../../empByStu">  
        <div class="label" >
          <label>选择待移出的学生：</label>
        </div>
		<div>
		
				<!--根据学院取所属班级 http://localhost:8080/domt/cla/getdata.action?collegeId=2f11518b -->
				<select id="college" class="input" name="collegeId"
					style="margin-left:60px;width:220px;float:left; line-height:17px;" onchange="ejld1(this.value)">
						<option value="">选择学院</option>
						 <c:forEach var="s" items="${collegeList}">
                             <option value="${s.collegeId}">${s.collegeName}</option>
                         </c:forEach>
				</select>
				<select id="class" class="input" name="classId" onchange="setvalue1(this.value)"
					style="margin-left:30px;width:200px; float:left; line-height:17px;">
						<option value="">选择班级</option>
				</select>
				<select id="stu" class="input" name="studentId" onchange="setvalue2(this.value)"
					style="margin-left:30px;width:200px; float:left; line-height:17px;">
						<option value="">选择学生</option>
				</select>
				<br/>
				<br/>
				<br/>
				
				<div class="label" >
		          <label id="tips"></label>
		        </div>
						 

				<script type="text/javascript">
					function setvalue2(stuId){
					$.ajax({
							 type: "GET",
				             url: "../../selectStudent",
				             data: {studentId:stuId},
				             dataType: "json",
				             success:function(data){
				             	$("#tips").empty();
				             	if(data["bedroomName"]=="" || data["bedroomName"]==null){
				             		
				             		$("#tips").html("该学生尚未分配宿舍，请返回查看");
				             		$("#sub")[0].style.display = 'none';
				             	}
				             	else {
				             		$("#tips").html("该学生即将被移出宿舍  "+data["bedroomName"] +" 确认后即可点击提交");
				             		$("#sub")[0].style.display = 'block';
				             	}
				             	
				             },
				             error:function(){
				             	alert("eeror json");
				             }
						});
					
					} 
					function setvalue1(cla){
					$.ajax({
							 type: "POST",
				             url: "../../selectStudents",
				             data: {classId:cla},
				             dataType: "json",
				             success:function(data){
				             	$("#stu").empty();
			             		$("#stu").append('<option>选择学生</option>');
				             	$.each(data,function(index,item){
				             		$("#stu").append('<option value="'+item["studentId"]+'">'+item["studentName"]+'</option>');
				             	});
				             },
				             error:function(){
				             	alert("eeror json");
				             }
						});
					
					} 
					function ejld1(apmId){
						$.ajax({
							 type: "GET",
				             url: "../../selectClass",
				             data: {collegeId: apmId },
				             dataType: "json",
				             success:function(data){
				             	$("#class").empty();
			             		$("#class").append('<option>选择班级</option>');
				             	$.each(data,function(index,item){
				             		$("#class").append('<option value="'+item["classId"]+'">'+item["className"]+'</option>');
				             	});
				             },
				             error:function(){
				             	alert("eeror json");
				             }
						});
						}
					
				</script>      
		</div>

     
				<br/>            
				<br/>
				
	 
     

            <div class="form-group">
        <div class="label">
          <label></label>
        </div>
        <div class="field">
         <button  id = "trueSubmit" type="submit" style="display: none;"></button>
          <div style="margin-left:100px;margin-top:30px;width:200px;" id="sub" class="button bg-main icon-check-square-o submit"> 提交</div>
         </div>
      </div>
    </form>
  </div>
</div>

<div class="dialog">
        <div class="bg-opacity"></div>
        <div class="show-dialog">
            <div class="title"></div>
            <div class="xx"></div>
            <div class="content"></div>
            <div class="d-btn">
                <span class="confirm">确定</span>
                <span class="cancle">取消</span>
            </div>
        </div>
    </div>

<script>

var submit = document.querySelector('.submit');

submit.onclick = function (){

	dialog.setTitle("警告");
    dialog.setContent("确认提交吗 ? ? ");
    
    dialog.show();
    
    dialog.dealConfirm = function () {
        trueSubmit.click();
    }
    
    
    dialog.dealCancle = function () {
    	
    }
}
</script>
</body></html>