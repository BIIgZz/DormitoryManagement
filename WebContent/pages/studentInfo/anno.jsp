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
<style>
#t1:read-only{
    cursor:default;
    background:white;
}
#t2:read-only{
    cursor:default;
    background:white;
}
</style>
<body onload="fun()">
<div class="panel admin-panel">
  <div class="body-content">
    <form method="post" class="form-x" action="${ctx}/anno/create.action">  
      <div class="form-group">
        <div class="label">
          <label>公告标题：</label>
        </div>
        <div class="field">
          <input type="text" id="t1" class="input" name="title" readonly="readonly"/>
        </div>
      </div>
      <div class="form-group">
        <div class="label">
          <label>公告内容：</label>
        </div>
        <div class="field">
          <textarea name="content" id="t2" class="input" style="height:450px; border:1px solid #ddd;" readonly="readonly">
          </textarea>
          <div class="tips"></div>
        </div>
      </div>

      <div class="form-group">
        <div class="label">
          <label></label>
        </div>
      </div>
    </form>
  </div>
</div>
<script type="text/javascript" src="../js/jquery.js"></script>
<script>
	function fun(){
			$.ajax({
			url:"../../annoServlet",
			type:"POST",
			dataType:"Json",
	        success : function(data){
	        	document.getElementById("t1").value = data["title"];
	    		document.getElementById("t2").value = data["content"];	        
			},
	        error:function(){
	        	alert("Failed");	
	        }
	        });
	}
</script>
</body></html>