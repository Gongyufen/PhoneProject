<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
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
        #hz2{
	width: 100%;
	height: 110px;
	background-color: white;
	line-height: 110px;
}
#hz2 h2{
	padding: 0px;
	padding-left: 295px;
	margin-left: 0px;
	display: flex;
	align-items: center;
	margin-top: 0px;
}
#xhz {
    display: flex;
    justify-content:center;
    align-items: center;
    height: 80px;
}
#xhz form{
	display: flex;
	align-items: center;
	height: 65px;
	background-color: #e1e1e1;
	margin-top: -80px;
	width: 100%;
	border-radius: 3px;
	margin-left: 275px;
	border: 1px solid gray;
}
#xhz span{
	margin: 20px;
	font-size: 14px;
}
#xhz form .fy{
	width: 40px;
	height: 25px;
}
#xhz form input{
	 margin:-5px; 
	 text-align: center;
}
#xhz form .qd{
	width: 60px;
	height: 29px;
	margin: 75px;
	border-radius: 5px;
	border: 0px;
	background: darkgray;
}
#xhz form .qd:hover{
	background-color: dimgray;
}
p{
	margin-top: 0px;
	margin-left: 285px;
	line-height: 14px;
	padding: 9px;
	padding-bottom: 20px;
	font-size: 14px;
}
hr{
	border: 1px solid transparent;
	border-image: linear-gradient(to right,white ,black);
	border-image-slice: 1; 
}
#big{
	width: 100%;
	height: 505px;
	margin-top: -30px;
	overflow: hidden;
}
#big #hz3{
	width: 40.5%;
    margin-left: 275px;
    height: 170px;
    margin-top: 0px;
    float: left;
    border-radius: 3px;
    background: #e1e1e1;
    border: 1px solid gray;
}
#big h2{
	margin-left: 280px;
	padding: 10px;
	margin-top: 92px;
	padding-left: 20px;
	padding-top: 10px;
}
#big #hz3 p{
	border: none;
	margin-top: 33px;
	margin-left: -10px;
	writing-mode: vertical-rl;
	writing-mode: vertical-rl;
	text-orientation: upright;
	white-space: nowrap;
	width: 20px;
	padding: 5px;
	font-size: 14px;
	top: 27px;
	left: 1px;
}
#big #hz4 p{
	border: none;
	margin-top: 33px;
	margin-left: -10px;
	writing-mode: vertical-rl;
	writing-mode: vertical-rl;
	text-orientation: upright;
	white-space: nowrap;
	width: 20px;
	padding: 5px;
	font-size: 14px;
	top: 27px;
	left: 1px;
}
#big #hz5 p{
	border: none;
	margin-top: 42px;
	margin-left: -10px;
	writing-mode: vertical-rl;
	writing-mode: vertical-rl;
	text-orientation: upright;
	white-space: nowrap;
	width: 20px;
	padding: 5px;
	font-size: 14px;
	top: 27px;
	left: 1px;
}
#big #hz4{
	width: 41%;
    height: 170px;
    margin-top: 0px;
    float: right;
    border-radius: 3px;
    background: #e1e1e1;
    border: 1px solid gray;
}
#big #hz5{
	width: 100%;
    margin-left: 276px;
    height: 170px;
    margin-top: 171px;
    background-color: #e1e1e1;
    border-radius: 3px;
    border: 1px solid gray;
    box-sizing: border-box;
}
#hz6 table {
    width: 100%;
    border-collapse: collapse;
	margin-top: 15px;
}

#hz6 th, #hz6 td {
    border: 1px solid #ccc; 
    padding: 8px;
    text-align: center;
}

#hz6 th {
    background-color: #f2f2f2;
}

#hz6 tr:nth-child(even) {
    background-color: #f9f9f9;
}

#hz6 tr:hover {
    background-color: #f1f1f1;
}
h1{
	margin-bottom: 30px;
}
</style>
</head>
<body>
	<script src="../jquery2-3.5.1.min.js"></script>
	<jsp:include page="../view/head.jsp" >
	<jsp:param  name="name" value="${list.get(0).getZ_uname()}"/>
	</jsp:include>
	<p>欢迎使用后台系统</p>
		<hr/>
		<div id="hz2">
			<h2>系统参数</h2>
			<div id="xhz" >
				<form>
					<span>自定义颜色:</span><input type="color"/>
					<input type="submit" value="确定"  class="qd" onclick="changeColor()"/>
					<script>
					    var colorButtons = document.getElementsByClassName('qd');
					    for (var i = 0; i < colorButtons.length; i++) {
					        colorButtons[i].addEventListener('click', function(event) {
					            event.preventDefault();
					            var colorInput = this.parentNode.querySelector('input[type="color"]');
					            var selectedColor = colorInput.value;
					            var divs = document.getElementsByClassName('changeColor');
					            for (var j = 0; j < divs.length; j++) {
					                divs[j].style.backgroundColor = selectedColor;
					            }
					        });
					    }
						function changeColor() {
						    const selectedColor = document.querySelector('input[type="color"]').value;
						    var divs = document.getElementsByClassName('changeColor');
						    for (var j = 0; j < divs.length; j++) {
						        divs[j].style.backgroundColor = selectedColor;
						    }
						    localStorage.setItem('selectedColor', selectedColor);
						    location.reload(); 
						}
						document.addEventListener("DOMContentLoaded", function() {
						    const selectedColor = localStorage.getItem('selectedColor');
						    if (selectedColor) {
						        var divs = document.getElementsByClassName('changeColor');
						        for (var j = 0; j < divs.length; j++) {
						            divs[j].style.backgroundColor = selectedColor;
						        }
						    }
						});
					</script>
				</form>
			</div>
		</div>
		<div id="big">
			<h2>数据统计</h2>
			<div id="hz3">
				<p>商品价格榜</p>
			</div>
			<div id="hz4">
				<p>商品上架时间榜</p>
			</div>
			<div id="hz5">
				<p>商品售量榜</p>
			</div>
		</div>
		<jsp:include page="../view/wei.jsp" >
	<jsp:param  name="name" value="${list.get(0).getZ_uname()}"/>
	</jsp:include>
	<div class="sidebar changeColor" id="xx">
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
							 <li id="dd"><a href="#">订单</a></li>
							 <script>
		                     	$(function(){
		                     		$("#dd").click(function(){
		                     			window.location.href="dingdan";
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
		                 </ul>
					 <li><a href="#">个人中心</a></li>
		         </ul>
		     </div>
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