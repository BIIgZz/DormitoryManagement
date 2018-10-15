<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

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
	*{
	margin: 0;
	}
	
	html, body{
		width: 100%;
		height: 100%;
	}
	.group{
		
		height: 100%;
		
		border: solid 1px #ddd;
    	border-radius: 4px;
    	background: url(../../images/stubg.jpg);
	}
	.group .head{
		height: 50px;
		background-color: #fcfcfc;
   		padding: 0 15px;
   		border-radius: 4px 4px 0 0;
    	border-bottom: solid 1px #ddd;
	}
	
	.group .left{
		width: 50%;
		margin-left: 300px ;
	}
		.group .left>h1{
			width: 100px;
			font-size: 18px;
   			color: #FFF;
   			background: #00a78e;
    		display: inline-block;
    		padding: .5em 1.5em;
    		position: relative;
    		text-align: center;
    		box-shadow: 0 8px 17px 0 rgba(0,0,0,0.2), 0 6px 20px 0 rgba(0,0,0,0.19);
		
		}
		.group .left>h1:before{
			width: 0;
    		height: 0;
   			position: absolute;
    		content: '';
    		bottom: -9px;
    		left: 20px;
    		border-style: solid;
    		border-width: 14px 11px 0 12px;
    		border-color: #00a78e transparent transparent transparent;
		}
		.group .left>h6{
			font-size: 18px;
   			color: #0099FF;
    		letter-spacing: 3px;
    		text-transform: uppercase;
    		height: 30px;
		}
		.group .info{
    		border-top: 1px solid #AFAFAF;
    		padding-top: 0.5em;
		}
		.group .info>li{
   			display: block;
		
		}
			.group .info .text{
				padding: 0;
				height: 30px;
				width: 500px;
				margin-top:5px;
				border-bottom: 1px solid #AFAFAF;
			}
			.group .info .text> li{
				display: inline-block;
    		font-size: 20px;
    			color: black;
    		font-weight: 400;
    		width: 200px;
			}
			.group .info .text> li:first-child{
				font-weight: bold;
			}
		}
</style>
</head>
<body onload="fun()">
	<div class="group">
		<div class="head">
			<strong style="font-size: 25px;">学生信息表</strong>
		</div>
		<div class="left">
			<h1>Hi</h1>
			<h6>Welcome To HUT College!</h6>
			<ul class="info">
					<li>
						<ul class="text">
							<li>姓名</li>
							<li id="name"></li>
						</ul>
					</li>
					<li>
						<ul class="text">
							<li>性别</li>
							<li id="sex"></li>
						</ul>
					</li>
					<li>
						<ul class="text">
							<li>学号</li>
							<li id="num"></li>
						</ul>
					</li>
					<li>
						<ul class="text">
							<li>学院</li>
							<li id="college"></li>
						</ul>
					</li>
					<li>
						<ul class="text">
							<li>班级</li>
							<li id="class"></li>
						</ul>
					</li>
					<li>
						<ul class="text">
							<li>宿舍</li>
							<li id="room"></li>
						</ul>
					</li>
					<li>
						<ul class="text">
							<li>入学年份</li>
							<li id="time"></li>
						</ul>
					</li>
			</ul>
			<input type="password" style="margin-top: 10px;"placeholder="修改密码" id="psd">
			<input type="button" style="margin-top: 10px;" value="保存修改"  onclick="buttionClick()" >
		</div>
	</div>
</body>
<script type="text/javascript" src="../js/jquery.js"></script>
 <script>
 var str=${sessionScope.stu.studentNo};
 	function fun(){
 	$.ajax({
		url:"../../stuInfoServlet",
		type:"POST",
		dataType:"Json",
		data:{h:str},
        success : function(data){        	
        	flushInfo(data);
		},
        error:function(){
        	alert("stuInfo");	
        }
        });
 	}
 	
 	function link(){
 	window.location.href="login.jsp";
 	}
 	function buttionClick(){
		var psd=$("#psd").val();
		    $("#psd").val("");
		    if(psd!=""){
		    $.ajax({
				url:"../../changePasServlet",
				type:"POST",
				data:{id:str,
					  psd:psd
					},
				dataType:"Json",
       			success : function(data){        	
        			alert("密码修改成功,重新登录");
        			window.parent.frames.location.href="${ctx}/loginOut";
				},
       			error:function(){
        			alert("密码修改失败，与原来密码相同");	
        		}
        	});
			}
		    else{
				alert("密码不能为空");
		    }
	}
 	
 	function flushInfo(data){
 		document.getElementById("name").innerText=data["studentName"];
 		var s=data["sex"];
 		if(s.indexOf("b")!=-1){
 	 		document.getElementById("sex").innerText="男";
 		}
 		else{
 			document.getElementById("sex").innerText="女";
 		}
 		s=data["bedroomName"];
 		if(s==null||s==""){
 			document.getElementById("room").innerText="宿舍未分配";

 		}
 		else{
 			document.getElementById("room").innerText=data["bedroomName"];
 		}
 		document.getElementById("num").innerText=data["studentNo"];
 		document.getElementById("college").innerText=data["collegeName"];
 		document.getElementById("class").innerText=data["className"];
 		document.getElementById("time").innerText=data["grade"];
 	}
 </script>
</html>