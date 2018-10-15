<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

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
<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no" />
<meta name="renderer" content="webkit">
<title></title>
</head>
<body>
<div class="panel admin-panel">
  <div class="panel-head" id="add"><strong><span class="icon-pencil-square-o"></span>来访登记</strong></div>
  <div class="body-content">
    <form method="post" class="form-x" action="../../visitorAdd">  
      
      
      
       <div class="form-group">
        <div class="label">
          <label>访客姓名：</label>
        </div>
           <div class="field">
          <input type="text"  class="input input-name"  style="width:100px;" name="visitorName" value=""/>
        </div>
      </div>
      <div class="form-group">
        <div class="label" >
          <label>电话：</label>
        </div>
           <div class="field">
          <input type="text"  class="input input-phone" style="width:200px;" name="visitorCall" value=""/>
        </div>
      </div>
		<select id="sex1" class="input input-sex"  name="visitorSex"
			style="margin-left:250px;width:100px; line-height:17px;" >
				<option value="">选择性别</option>
				<option value="男">男</option>
				<option value="女">女</option>
		</select>
    
		<br/>

  <div class="form-group">
        <div class="label" >
          <label>来访宿舍：</label>
        </div>
           <div class="field">
          <input type="text"  class="input input-bedroom" style="width:250px;" name="bedroomName" value=""/>
        </div>
      </div>
      
      <div class="form-group">
        <div class="label">
          <label>备注：</label>
        </div>
        <div class="field">
          <textarea name="reason" class="input input-remark" style="height:100px; border:1px solid #ddd;"></textarea>
          <div class="tips"></div>
        </div>
      </div>
			</div>
     
     	<div>

		<div>
     </div>            
     
      <div class="form-group">
        <div class="label">
          <label></label>
        </div>
        <div class="field">
          <button  type="submit" style="display: none;" id="submit"></button>
          <div style="margin-left:120px;margin-top:30px;width:200px;" class="button bg-main icon-check-square-o ds-submit"> 提交</div>
        </div>
      </div>
    </form>
  </div>
</div>

</body>

<script>
	$('.ds-submit')[0].onclick = function (){
		
		var name = $('.input-name').val()
		var phone = $('.input-phone').val()
		var sex = $('.input-sex').val()
		var bedroom = $('.input-bedroom').val()
		var remark = $('input-remark').val()
		
		if(name==""){
			alert("姓名不能为空");
			return;
		}
		if(!phone.match(/^(\d){11}$/g)){
			alert("请输入正确的手机号码");
			return;
		}
		if(sex==""){
			alert("请选择性别")
			return;
		}
		if(!bedroom.match(/^(\d){1,2}-(\d){3}$/g)){
			alert("宿舍名格式错误");
			return;
		}
		
		submit.click();
		
	}
	

</script>

</html>