


<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

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
<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no" />
<meta name="renderer" content="webkit">
<title></title>
</head>
<body>
<div class="panel admin-panel">
  <div class="panel-head" id="add"><strong><span class="icon-pencil-square-o"></span>修改宿舍信息</strong></div>
  <div class="body-content">
    <form method="post" class="form-x" action="${ctx}/bedroomChange">  
      <input type="hidden" name="bedroomId" value="${obj.bedroomId}"/>
      <div class="form-group">
        <div class="label">
        </div>
      </div>
     

      <div class="form-group">
        <div class="label">
          <label>宿舍名称：</label>
        </div>
           <div class="field">
          <input type="text"  class="input input-name" name="bedroomName" value="${obj.bedroomName}"/>
        </div>
      </div>
      <div class="form-group">
        <div class="label" >
          <label>已住人数：</label>
        </div>
           <div class="field">
          <input type="text"  class="input num" name="totalBed" value="${obj.totalBed}"/>
        </div>
      </div>
     
     
     
      <div class="form-group">
        <div class="label">
          <label></label>
        </div>
        <div class="field">
 
           <button  type="submit" style="display: none;" id="submit"></button>
          <div class="button bg-main icon-check-square-o ds-submit"> 提交</div>
        </div>
      </div>
    </form>
  </div>
</div>

</body>
<script>
	$('.ds-submit')[0].onclick = function (){
		
		var name = $('.input-name').val()
		var num = $('.num').val()
		
		if(num.trim() == ''){
			alert("人数不能为空");
			return;
		}
		if(num>4||num<0){
			alert("人数错误");
			return;
		}
		if(!name.match(/^(\d){1,2}-(\d){3}$/g)){
			alert("宿舍名错误");
			return;
		}

		
		submit.click();
		
	}
	

</script>
</html>