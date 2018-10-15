<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ include file="../basic/base.jsp"%>
<!DOCTYPE html>
<html lang="zh-cn">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no" />
<meta name="renderer" content="webkit">
<title></title>
</head>
<body>
<div class="panel admin-panel">
  <div class="panel-head" id="add"><strong><span class="icon-pencil-square-o"></span>增加内容</strong></div>
  <div class="body-content">
    <form method="post" class="form-x" action="../../announce">  
      
      <div class="form-group">
        <div class="label">
          <label>公告标题：</label>
        </div>
        <div class="field">
          <input type="text" class="input input-title" name="title" value=""/>
        </div>
      </div>
     
     
      <div class="form-group">
        <div class="label content">
          <label>公告内容：</label>
        </div>
        <div class="field">
          <textarea name="content" class="input input-content" style="height:250px; border:1px solid #ddd;"></textarea>
          <div class="tips"></div>
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
		
		var title = $('.input-title').val()
		var content = $('.input-content').val()
		
		if(title.trim() == ''){
			alert("标题不能为空");
			return;
		}
		if(title.length > 20){
			alert("标题过长");
			return;
		}
		if(content.trim() == ''){
			alert("内容不能为空")
			return;
		}
		
		submit.click();
		
	}
	

</script>

</html>