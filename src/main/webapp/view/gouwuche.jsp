<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>购物车</title>
<link type="text/css" rel="stylesheet" href="../css/gouwuche.css" />
<link type="text/css" rel="stylesheet" href="../css/head.css" />
<link type="text/css" rel="stylesheet" href="../css/di.css" />
		<script type="text/javascript" src="../jquery-3.5.1.min.js"></script>

</head>
<body>
<div id="head">
			<div id="headone">
				<div id="head-left">
					<ul id="head-left-ul" >
						<li><a href="">首页</a></li>
						<li>|</li>
						<li><a href="">消费者业务网站</a></li>
						<li>|</li>
						<li><a href="">V码（优购码）</a></li>
						<li>|</li>
						<li><a href="">企业商用</a></li>
						<li>|</li>
						<li><a href="">更多精彩</a></li>
					</ul>
				</div>
				<div id="head-right">
					<ul id="head-right-ul">
						<li><a href="">请登录</a></li>
						<li><a href="">注册</a></li>
						<li>|</li>
						<li><a href="">我的订单</a></li>
						<li>|</li>
						<li><a href="">客服</a></li>
						<li>|</li>
						<li><a href="">网站导航</a></li>
						<li>|</li>
						<li><a href="">手机版</a></li>
						<li>|</li>
						<li><a href="">购物车</a></li>
					</ul>
				</div>
			</div>
		</div>
		
		<div id="daohanglan">
			<div class="dhl">
				<div class="tupian"><img src="../img/图标.png" /></div>
				<div class="ziti">我的购物车</div>
			</div>
			
		</div>
			
		
		<div id="mingcheng">
			<div id="mc">
				<label class="biaotione" id="checkall">
					<input type="checkbox" class="onecheck" />
					<div class="two">全选</div>
				</label>
				<ul>
					<li class="sp">商品</li>
					<li>单价</li>
					<li>数量</li>
					<li>小计</li>
					<li>操作</li>
				</ul>
			</div>
		</div>
		<c:forEach items="${mid }" var="mid">
			<div id="shangpin">
				<input type="checkbox" class="one"/>
				<div class="two">
					<img src="../img/手机.webp" />
					<ul>
						<li class="sp">
							<p>${mid.c_mname }</p>
							<p>${mid.c_ysgtails }</p>
							<p>${mid.c_ncgtails }</p>
						</li>
						<li style="text-align: center;"><span style="display: none;">${mid.c_rid }</span>¥ ${mid.c_rsprice }</li>
						<li style="text-align: center;">
							<div class="shu">
								<a href="" class="zuo">-</a>
								<input type="text" />
								<a href="" class="you">+</a>
							</div>
						</li>
						<li style="text-align: center;color: #ca151e;font-weight: 700;">¥ 299.00</li>
						<li style="text-align: center;color: #a4a4a4;"><a href="">删除</a></li>
					</ul>
				</div>
			</div>
		</c:forEach>
		
		
		<div id="jiesuan">
			<div id="gongneng">
				<label class="checkall">
					<input type="checkbox" id="qx" />
					<div class="ziti">全选</div>
				</label>
				<div class="sc"><a href="">删除</a></div>
			</div>
				<a href="" id="js">立即结算</a>
			<div id="jilu">
				<p class="zj">
					<label>总计：</label>
					<span>￥&nbsp;0.00</span>
				</p>
				<div class="xz">已选择<em>0</em>件商品</div>
			</div>
		</div>
		
		<script>
			$(function() {
				$(".onecheck").click(function() {
					
					$(".one").each(function() {
						$(this).prop("checked",$(".onecheck").prop("checked"));
					})
					$("#qx").prop("checked",$(this).prop("checked"));
				})
				
				$("#qx").click(function() {
					
					$(".one").each(function() {
						$(this).prop("checked",$("#qx").prop("checked"));
					})
					$(".onecheck").prop("checked",$(this).prop("checked"));
				})
			})
			
			
    	</script>
		
		<jsp:include page="di.jsp"></jsp:include>
		
</body>
</html>