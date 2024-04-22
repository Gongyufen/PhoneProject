<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
	#shang{
	width: 55%;
	height: 105px;
	margin-left: 20%;
	margin-top: 15px;
	background-color: #e1e1e1;
	border: 1px solid gray;
	border-radius: 5px;
}
#shang form #yh{
	padding-top: 20px;
	padding-left: 25px;
	font-size: 14px;
}
#shang form #yh input{
	width: 165px;
}
#shang form #sj{
	margin-top: -20px;
	font-size: 14px;
	margin-left: 297px;
}
#shang form #sj select{
	width: 165px;
}
#shang form #b1{
	display: inline-block;
	width: 55px;
	border: none;
	border-radius: 5px;
	margin-top: 20px;
	background: #a1a1a1;
	margin-left: 30px;
	height: 25px;
}
#shang form #b1:hover{
	background-color:dimgray;
}
#shang form #b2{
	display: inline-block;
	width: 55px;
	border: none;
	border-radius: 5px;
	background: #a1a1a1;
	height: 25px;
	margin-left: 20px;
}
#shang form #b2:hover{
	background-color:dimgray;
}
#xia table {
    width: 100%;
	margin-top: 13px;
    border-collapse: collapse;
}
#xia th, #xia td {
    border: 1px solid #ccc; 
    padding: 8px;
    text-align: center;
}
#xia th {
    background-color: #f2f2f2;
}
#xia tr:nth-child(even) {
    background-color: #f9f9f9;
}
#xia tr:hover {
    background-color: #f1f1f1;
}
#xia #tj{
	width: 55px;
	margin-top: 20px;
	height: 30px;
	border: none;
	border-radius: 5px;
	background: #a1a1a1;
}
#xia #sc{
	width: 55px;
	margin-top: 20px;
	height: 30px;
	border: none;
	border-radius: 5px;
	background: #a1a1a1;
	margin-left: 15px;
}
#xia #sc:hover{
	background-color:dimgray ;
}
#xia #tj:hover{
	background-color: dimgray;
}
#xia table tr td button{
	margin-right: 5px;
	width: 40px;
	border: none;
	border-radius: 5px;
	background: #a1a1a1;
	height: 30px;
}
#xia table tr td button:hover{
	background-color:dimgray ;
}
#xia{
	width: 54%;
	height: 400px;
	margin-top: 30px;
	margin-left: 20%;
	background-color: #e1e1e1;
	border: 1px solid gray;
	border-radius: 5px;
	padding: 10px;
	padding-top:0px;
	overflow: auto;
}
.sidebar {
            position: fixed;
            top: 110px;
            left: 0;
            width: 200px;
            height: 100%;
            background-color: #333;
            color: white;
            padding: 10px;
            border-radius: 10px;
			z-index: 1000;
        }
        .sidebar ul {
            list-style: none;
            padding: 0;
            margin: 0;
        }
        .sidebar li {
            margin-bottom: 10px;
        }
        .sidebar a {
            color: gray;
            text-decoration: none;
            display: block;
            padding: 10px;
            margin-top: 15px
        }
        .sidebar a:hover {
            color: white;
        }
        .sub-menu {
            display: none;
            padding-left: 20px;
        }
        .sub-menu li {
            margin-bottom: 5px;
        }
.sidebar ul ul {
            display: none;
            padding-left: 20px;
        }
        .sidebar ul ul li {
            margin-bottom: 10px;
        }
</style>
</head>
<body>
	<script src="../jquery2-3.5.1.min.js"></script>
	<jsp:include page="../view/head.jsp" >
	<jsp:param  name="name" value="${list.get(0).getZ_cid()}"/>
	</jsp:include>
	<div id="shang">
					<form action="ChaPLServlet" method="get">
						<div id="yh"><span>评论时间：</span><input type="datetime-local" name="rq"/></div>
						<div id="sj"><span>评论等级：</span>
						<select name="dj">
							<option value="1">1</option>
							<option value="2">2</option>
							<option value="3">3</option>
							<option value="4">4</option>
							<option value="5">5</option>
						</select></div>
						<input type="submit" id="b1" value="搜索"/>
						<input type="button" id="b2" value="清空"/>
					</form>
				</div>
				<div id="xia">
					<table border="1">
						<tr>
							<th>编号</th>
							<th>评论内容</th>
							<th>评论时间</th>
							<th>评论等级</th>
							<th>操作</th>
						</tr>
						<c:forEach items="${list}" var="item">
        <tr>
            <td>${item.z_cid}</td>
            <td>${item.z_content}</td>
            <td><fmt:formatDate value="${item.z_time}" pattern="yyyy-MM-dd'T'HH:mm"/></td>
            <td>${item.z_evaluation}</td>
            <td>
             <form action="SCPlServlet" method="get">
            <input type="hidden" name="id" value="${item.z_cid}" />
            <button type="submit" class="delete-btn">删除</button>
        </form>
        </tr>
    </c:forEach>
					</table>
				</div>
				<div class="sidebar ss" id="xx">
		         <ul>
					 <li id="sy"><a href="sy.jsp">首页</a></li>
					 <script>
		                     	$(function(){
		                     		$("#sy").click(function(){
		                     			window.location.href="sy.jsp";
		                     		})
		                     	})
		                     </script>
		             <li><a href="#">后台管理</a>
		                 <ul class="sub-menu">
		                     <li id="uesr"><a href="user">用户</a></li>
		                     <script>
		                     	$(function(){
		                     		$("#uesr").click(function(){
		                     			window.location.href="user";
		                     		})
		                     	})
		                     </script>
		                    <li id="gg"><a href="#">商品规格</a></li>
		                     <script>
		                     	$(function(){
		                     		$("#gg").click(function(){
		                     			window.location.href="guige";
		                     		})
		                     	})
		                     </script>
		                     <li id="xq"><a href="#">规格详情</a></li>
		                     <script>
		                     	$(function(){
		                     		$("#xq").click(function(){
		                     			window.location.href="guigexq";
		                     		})
		                     	})
		                     </script>
		                     <li id="fl"><a href="#">分类</a></li>
		                     <script>
		                     	$(function(){
		                     		$("#fl").click(function(){
		                     			window.location.href="fenlei";
		                     		})
		                     	})
		                     </script>
							 <li id="sp"><a href="#">商品</a></li>
							 <script>
		                     	$(function(){
		                     		$("#sp").click(function(){
		                     			window.location.href="shangpin";
		                     		})
		                     	})
		                     </script>
							 <li id="pl"><a href="#">评论</a></li>
							 <script>
		                     	$(function(){
		                     		$("#pl").click(function(){
		                     			window.location.href="pinglun";
		                     		})
		                     	})
		                     </script>
							 <script>
		                     	$(function(){
		                     		$("#dd").click(function(){
		                     			window.location.href="dingdan";
		                     		})
		                     	})
		                     </script>
		                 </ul>
					 <li><a href="#">个人中心</a></li>
		         </ul>
		     </div>
				<jsp:include page="../view/wei.jsp" >
	<jsp:param  name="name" value="${list.get(0).getZ_cid()}"/>
	</jsp:include>
	 <script>
		     const side = document.getElementById('xx');
				
				// 监听页面滚动事件
				function scrollFunction() {
				    var scrollPosition = window.scrollY;
				    if (scrollPosition > 50) { // 当滚动位置超过50px时触发事件
				    	side.style.top = "80px";
				    } else if (scrollPosition < 50) { // 当滚动位置超过50px时触发事件
				    	side.style.top = "110px";
				    }
				}
				// 添加滚动事件监听器
				window.addEventListener('scroll', scrollFunction);
		     </script>
			 <script>
			         const menuItems = document.querySelectorAll('.sidebar a, #head-right-ul a');
			         menuItems.forEach(item => {
			             item.addEventListener('click', function(e) {
			                 e.preventDefault();
			                 const subMenu = this.nextElementSibling;
			                 if (subMenu) {
			                     if (subMenu.style.display === 'block') {
			                         subMenu.style.display = 'none';
			                     } else {
			                         subMenu.style.display = 'block';
			                     }
			                 }
			             });
			         });
			     </script>
</body>
</html>