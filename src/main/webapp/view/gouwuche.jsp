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
<jsp:include page="head.jsp">
		<jsp:param name="name" value="${list.get(0).getZ_uname()}" />
	</jsp:include>
		
		
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
		<c:forEach items="${gwc }" var="mid">
			<div id="shangpin">
				<input type="checkbox" name="sid" value="${mid.c_sid }" class="one"/>
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
								<a class="zuo">-</a>
								<input type="text" id="zhi" value="${mid.c_ssl}" />
								<span class="sid" style="display: none">${mid.c_sid }</span>
								<a  class="you">+</a>
							</div>
						</li>
						<li style="text-align: center;color: #ca151e;font-weight: 700;" class="xj"> ${mid.c_ssl*mid.c_rsprice }</li>
						<li style="text-align: center;color: #a4a4a4;"><span class="sid" style="display: none">${mid.c_sid }</span> <a class="sc">删除</a></li>
					</ul>
				</div>
			</div>
		</c:forEach>
		
		<script>
			$(function () {
			 	var totalPrice = 0;
   				$(".one").click(function() {
   					var zj=0;
					var num=0;
   					$(".one[type='checkbox']:checked").each(function() {
   					    var row = $(this).parent();
   					    var value = row.find(".xj").text();
   					 	zj+= parseInt(value);
   					 	num++;
   					});
   					$("#shul").text(num)
   					$("#zj").text(zj)
				})
   				$(".sc").click(function() {
					var sid=$(this).parent().find(".sid").text();
					window.location.href="DeleteGwcServlet?sid="+sid;
				})
				
				$(".you").click(function() {
					var count = $(this).parent().find("#zhi").val();
					if (count<10) {
						count++;
						var sid=$(this).parent().find(".sid").text();
						$(this).parent().find("#zhi").val(count) ;
		            	$(this).css("color","black");
		           	 	window.location.href="GouwucheshuliangServlet?ssl="+count+"&sid="+sid;
					}else {
						$(this).css("color","#a6a6a6");
					}
				})
				$(".zuo").click(function() {
					var count = $(this).parent().find("#zhi").val();
					if (count>1) {
						count--;
						$(this).parent().find("#zhi").val(count) ;
		           		$(this).css("color","black");
		            	var sid=$(this).parent().find(".sid").text();
		            	window.location.href="GouwucheshuliangServlet?ssl="+count+"&sid="+sid;
					}else {
						$(this).css("color","#a6a6a6");
					}
				})
				$(function() {
					$("#js").click(function() {
						var arr = [];
						$('.one[type="checkbox"]:checked').each(function() {
						    arr.push($(this).val());
						});
						window.location.href = "GwcDindServlet?arr=" + arr;
					})
					$("#sc").click(function(){
						var arr = [];
						$('.one[type="checkbox"]:checked').each(function() {
						    arr.push($(this).val());
						});
						window.location.href = "QuanxuanshanchuServlet?arr=" + arr;
					})
				})
			})
		</script>
		<div id="jiesuan">
			<div id="gongneng">
				<label class="checkall">
					<input type="checkbox" id="qx" />
					<div class="ziti">全选</div>
				</label>
				<div style="font-size: 12px;line-height: 60px;	float: left;margin-left: 20px;"><a id="sc">删除</a></div>
			</div>
				<a id="js">立即结算</a>
			<div id="jilu">
				<p class="zj">
					<label>总计：</label>
					￥<span id="zj">&nbsp;0.00</span>
				</p>
				<div class="xz">已选择<em id="shul">0</em>件商品</div>
			</div>
		</div>
		
		<script>
			$(function() {
				$(".onecheck").click(function() {
					
					$(".one").each(function() {
						$(this).prop("checked",$(".onecheck").prop("checked"));
					})
					$("#qx").prop("checked",$(this).prop("checked"));
					
					var zj=0;
					var num=0;
   					$(".one[type='checkbox']:checked").each(function() {
   					    var row = $(this).parent();
   					    var value = row.find(".xj").text();
   					 	zj+= parseInt(value);
   					 	num++;
   					});
   					$("#shul").text(num)
   					$("#zj").text(zj)
					
				})
				
				$("#qx").click(function() {
					$(".one").each(function() {
						$(this).prop("checked",$("#qx").prop("checked"));
					})
					$(".onecheck").prop("checked",$(this).prop("checked"));
					var zj=0;
					var num=0;
   					$(".one[type='checkbox']:checked").each(function() {
   					    var row = $(this).parent();
   					    var value = row.find(".xj").text();
   					 	zj+= parseInt(value);
   					 	num++;
   					});
   					$("#shul").text(num)
   					$("#zj").text(zj)
					
				})
				
				
			})
			
			
    	</script>
		
		<jsp:include page="di.jsp"></jsp:include>
		
</body>
</html>