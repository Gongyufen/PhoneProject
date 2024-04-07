<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<link type="text/css" rel="stylesheet" href="../css/head.css"/>
<div id="head">
				<div id="head-left">
					<ul id="head-left-ul" >
						<li id="img"></li>
						<li><a href="">首页</a></li>
						<li><a href="">热卖商品</a></li>
						<li><a href="猜你喜欢.html">猜你喜欢</a></li>
						<li><a href="浏览记录.html">浏览记录</a></li>
					</ul>
				</div>
				<div id="head-right">
					<ul id="head-right-ul">
						<li><%= request.getParameter("name") %></li>
						<li><a href="个人中心.html#mydd">我的订单</a></li>
						<li><a href="">我的购物车</a></li>
					</ul>
				</div>
			</div>