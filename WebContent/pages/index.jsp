<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="zh-cn">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no" />
    <meta name="renderer" content="webkit">
    <title></title>  
    <link rel="stylesheet" href="../css/pintuer.css">
    <link rel="stylesheet" href="../css/admin.css">
    <script src="../js/jquery.js"></script>   
</head>
<body style="background-color:#f2f9fd;">
<div class="header bg-main">
  <div class="logo margin-big-left fadein-top">
    <h1><img src="../images/y.jpg" class="radius-circle rotate-hover" height="50" alt="" />
    <c:if test="${sessionScope.user.name!=null and  sessionScope.user.type!=null}">
			 	 <c:if test="${ sessionScope.user.type=='student'}">
	  			  ${sessionScope.stu.studentName}
   				 </c:if>
			 	 <c:if test="${ sessionScope.user.type!='student'}">
			 	${sessionScope.user.name}
   				 </c:if>
			
    </c:if>
    
   				  
    
    <c:if test="${sessionScope.user.name==null or sessionScope.user.type==null}">
	    	请先<a href="../pages/basic/login.jsp">登录</a>
    </c:if>
      </h1>
  </div>
  <div class="head-l"><a class="button button-little bg-green" href="../pages/basic/default.jsp" target="right">
	  <span class="icon-home"></span> 前台首页</a> &nbsp;&nbsp;
	  <a href="" class="button button-little bg-blue">
	  <span class="icon-wrench"></span> 清除缓存</a> &nbsp;&nbsp;
	  <a class="button button-little bg-red" href="../loginOut">
	  <span class="icon-power-off"></span> 退出登录</a> 
	  </div>
</div>
<div class="leftnav">
		
    <c:if test="${sessionScope.user.type=='root' }">
     	<div>
			  <div class="leftnav-title"><strong><span class="icon-list">&nbsp&nbsp操作菜单</span></strong></div>
			  
			  <h2><span class="icon-user"></span>基本管理</h2>
			<!--   <ul style="display:block"> -->
			  <ul>
			    <li><a href="../pages/anno/list.jsp" target="right"><span class="icon-caret-right"></span>公告管理</a></li>
				<!--     <li><a href="../pages/apm/list.jsp" target="right"><span class="icon-caret-right"></span>公寓管理</a></li>-->
			    <li><a href="../pages/br/list.jsp" target="right"><span class="icon-caret-right"></span>宿舍管理</a></li>
			    <li><a href="../pages/stu/list.jsp" target="right"><span class="icon-caret-right"></span>学生管理</a></li>  
			   <!-- <li><a href="../pages/cl/list.jsp" target="right"><span class="icon-caret-right"></span>学院管理</a></li>  -->
			    <li><a href="../pages/cla/list.jsp" target="right"><span class="icon-caret-right"></span>班级管理</a></li>  
			    <li><a href="../pages/visit/list.jsp" target="right"><span class="icon-caret-right"></span>访客登记管理</a></li>
			    
			  </ul>
			  
			  <h2><span class="icon-pencil-square-o" id="disRoom"></span>分配宿舍</h2>
			  <ul>
			    <li><a href="../pages/statis/disbystu.jsp" target="right"><span class="icon-caret-right"></span>按个人分配</a></li>
			    <li><a href="../pages/statis/disbycla.jsp" target="right"><span class="icon-caret-right"></span>按班级分配</a></li>
			  <!--   <li><a href="../pages/statis/disbycollege.jsp" target="right"><span class="icon-caret-right"></span>按学院分配</a></li>
			   -->
			  </ul>
			  
			  <h2><span class="icon-pencil-square-o"></span>腾空宿舍</h2>
			  <ul>
			    <li><a href="../pages/statis/empbystu.jsp" target="right"><span class="icon-caret-right"></span>按个人腾空</a></li>
			    <li><a href="../pages/statis/empbyclass.jsp" target="right"><span class="icon-caret-right"></span>按班级腾空</a></li>
			  <!--   <li><a href="../pages/statis/empbycollege.jsp" target="right"><span class="icon-caret-right"></span>按学院腾空</a></li>
			  --> 
			  </ul>
			       
			  <h2><span class="icon-pencil-square-o"></span>系统管理</h2>
			  
			  <ul>
			    <li><a href="../managerList" target="right"><span class="icon-caret-right"></span>分配管理员</a></li>
			  </ul>  
			       
			  <h2><span class="icon-pencil-square-o"></span>统计打印</h2>
			  <ul>
			    <li><a href="../pages/statis/statisstubycollege.jsp" target="right"><span class="icon-caret-right"></span>统计学生名单</a></li>
			    <li><a href="../pages/statis/viewdisbycollege.jsp" target="right"><span class="icon-caret-right"></span>统计宿舍分配</a></li>			 
			     </ul>  
			</div>
			</div>
</c:if>


  <c:if test="${sessionScope.user.type=='manager'}">
     	<div>
			  <div class="leftnav-title"><strong><span class="icon-list">&nbsp&nbsp操作菜单</span></strong></div>
			  <h2><span class="icon-user"></span>基本管理</h2>
			   <!--<ul style="display:block"> -->
			<ul>
			    <li><a href="../pages/anno/list.jsp" target="right"><span class="icon-caret-right"></span>公告管理</a></li>
			    <li><a href="../pages/br/list.jsp" target="right"><span class="icon-caret-right"></span>宿舍管理</a></li>
			    <li><a href="../pages/stu/list.jsp" target="right"><span class="icon-caret-right"></span>学生管理</a></li>  
			    <li><a href="../pages/cla/list.jsp" target="right"><span class="icon-caret-right"></span>班级管理</a></li>  
			    <li><a href="../pages/visit/list.jsp" target="right"><span class="icon-caret-right"></span>访客登记管理</a></li>		    
			  </ul>
			  <h2><span class="icon-pencil-square-o"></span>分配宿舍</h2>
			  <ul>
			    <li><a href="../pages/statis/disbystu.jsp" target="right"><span class="icon-caret-right"></span>按个人分配</a></li>
			    <li><a href="../pages/statis/disbycla.jsp" target="right"><span class="icon-caret-right"></span>按班级分配</a></li>
			  </ul>
			  
			  <h2><span class="icon-pencil-square-o"></span>腾空宿舍</h2>
			  <ul>
			    <li><a href="../pages/statis/empbystu.jsp" target="right"><span class="icon-caret-right"></span>按个人腾空</a></li>
			    <li><a href="../pages/statis/empbyclass.jsp" target="right"><span class="icon-caret-right"></span>按班级腾空</a></li>
			  </ul>
			       
			  <h2><span class="icon-pencil-square-o"></span>统计打印</h2>
			  <ul>
			    <li><a href="../pages/statis/statisstubycla.jsp" target="right"><span class="icon-caret-right"></span>统计班级学生名单</a></li>
			    <li><a href="../pages/statis/statisstubycollege.jsp" target="right"><span class="icon-caret-right"></span>统计学院学生名单</a></li>
			    <li><a href="../pages/statis/viewdisbycla.jsp" target="right"><span class="icon-caret-right"></span>统计班级宿舍分配</a></li>
			    <li><a href="../pages/statis/viewdisbycollege.jsp" target="right"><span class="icon-caret-right"></span>统计学院宿舍分配</a></li>
			    <li><a href="../pages/printstu.jsp" target="right"><span class="icon-caret-right"></span>打印所有学生信息</a></li>
			    <li><a href="../pages/printbr.jsp" target="right"><span class="icon-caret-right"></span>打印所有宿舍信息</a></li>
			  </ul>  
			</div>
			</div>
</c:if>

         
        <c:if test="${sessionScope.user.type=='student'}">
     	<div>
			  <div class="leftnav-title"><strong><span class="icon-list">&nbsp&nbsp操作菜单</span></strong></div>
			  <h2><span class="icon-user"></span>基本信息</h2>
			   <ul>
			    <li><a href="../pages/studentInfo/info.jsp" target="right">
			    		<span class="icon-caret-right"></span>个人信息</a></li>
			    <li><a href="../pages/studentInfo/anno.jsp" target="right"><span class="icon-caret-right"></span>公告查看</a></li>
			    <li><a href="../pages/studentInfo/room.jsp" target="right">
			    		<span class="icon-caret-right"></span>我的室友</a></li>
			    <li><a href="../pages/studentInfo/classmates.jsp" target="right"><span class="icon-caret-right"></span>我的同班同学</a></li>  
			    <li><a href="../pages/studentInfo/visit.jsp" target="right"><span class="icon-caret-right"></span>我的宿舍访客记录</a></li>
			  </ul>
			<!--   <h2><span class="icon-pencil-square-o"></span>查询信息</h2>
			  <ul>
			    <li><a href="../pages/statis/viewdisbycla.jsp" target="right"><span class="icon-caret-right"></span>查看班级宿舍分配</a></li>
			  </ul>  
			  --> 
			</div>
			
		</div>
</c:if>
<script type="text/javascript">
$(function(){
  $(".leftnav h2").click(function(){
	  $(this).next().slideToggle(200);	
	  $(this).toggleClass("on"); 
  })
  
 
  $(".leftnav ul li a").click(function(){
	    $("#a_leader_txt").text($(this).text());
  		$(".leftnav ul li a").removeClass("on");
		$(this).addClass("on");
  })
});
</script>
<ul class="bread">
  <li><a href="../pages/basic/default.jsp" target="right" class="icon-home"> 首页</a></li>
  <li><a href="##" id="a_leader_txt">网站信息</a></li>
</ul>
<div class="admin">

  <iframe scrolling="auto" rameborder="0" src="../pages/basic/default.jsp" name="right" width="100%" height="100%">
  
  </iframe>
</div>
<div style="text-align:center;">
</div>
</body>
</html>