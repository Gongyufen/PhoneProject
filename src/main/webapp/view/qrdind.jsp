<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Insert title here</title>
</head>
<link rel="stylesheet" href="../css/qrdindan.css?c=1" />
<script src="https://cdn.bootcss.com/jquery/3.2.1/jquery.js"></script>
<script src="https://cdn.bootcss.com/distpicker/2.0.1/distpicker.js"></script>
<body>
	<div  class="gouwu">
			<!-- 头部 -->
	<jsp:include page="head.jsp">
		<jsp:param name="name" value="${list.get(0).getZ_uname()}" />
	</jsp:include>
		
		<div class="page">
			<div class="connwsn">
				<div class="cheackout">
					<!-- 收货地址 -->
					<div class="deatil">
							<div class="head-title">收货地址</div>
							
							<div class="wos">
														
					<c:forEach items="${dz}" var="l">
					<div class="shouhuo">
					<h4 id="shname">${l.getZ_consignee()}</h4>
					<p id="shphone">${l.getZ_phone()}</p>
					<p id="shaddress">${l.getZ_address()}</p>									
					</div>
					</c:forEach>
					<script type="text/javascript">
						$(function() {
							$(".shouhuo").click(function() {
								$(".shouhuo").attr("id","no");
								$(this).attr("id","ok");
								$(".shouhuo").css("border","1px solid #e0e0e0");
								$(this).css("border","1px solid #ff3333");
							});
						})
					</script>			
					</div>
							
							
					</div>
					<div class="iid" style="display: none;">${addDd.get(0).get(0).getZ_iid() }</div>
					<c:forEach items="${addDd}" var="dd">
					<div class="section">
						<div class="head-deisli">商品</div>
						
						<div class="goods-list">
							<c:forEach items="${dd}" var="xq">
								<div class="goods-itme">
								
									<div class="goods-img">
										<img  src="../img/${xq.getTup()}" style="width: 30px;height: 30px;"/>
									</div>
									
									<div class="goods-name">
										<span style="color: black;">${xq.getC_mname()}&nbsp;&nbsp;&nbsp;${xq.getNc()}&nbsp;&nbsp;&nbsp;${xq.getColor()}</span>
									</div>
									
									<div class="goods-prce">
										<div class="good-total1">${xq.z_number}</div>
									</div>
									
									<div class="goods-prce">
										<div class="good-total">${xq.c_rsprice*xq.z_number}</div>
									</div>
								</div>
							</c:forEach>
							
							
						</div>
						
					</div>
					</c:forEach>
					<c:set var="totalPrice" value="0" /> <!-- 初始化总价为0 -->

<script>
$(function () {
	 // 假设map是一个包含ShoppingCartItem对象的数组
   var totalPrice = 0; // 初始化总价为0

   // 遍历数组计算总价
   $(".good-total").each(function(item) {
       var carJg =$(this).text() ; // 获取商品价格
       
       totalPrice += parseInt(carJg); // 累加到总价上
   });
		$("#zojia").text(totalPrice)
   // 将 JavaScript 中的总价赋值给 JSP 变量
})
 
</script>
					<!-- 输出商品总价 -->
					<div class="weos">
						<table class="total">
							<tbody>
							<tr>
								<td>商品总价:</td>
								<td>
									<span class="num"><c:out value="${totalPrice}" /></span>元
								</td>
							</tr>
							<tr>
								<td>运费:</td>
								<td>
									<span class="num">0</span>元
								</td>
							</tr>
							
							<tr>
								<td>应付金额:</td>
								<td>
									<span class="num" id="zojia" style="font-size: 30px;color: #ff6700;"></span>元
								</td>
							</tr>
							</tbody>
						</table>
						
					</div>
					
					<div class="cleadsi">
						<div class="hendle">
							<div class="operating">
								<a class="btn btn-primary">立即下单</a>
								<a href="javascript:void(0)" class="qx btn btn-return">取消订单</a>
							</div>
						</div>
					</div>
					<script type="text/javascript">
						$(function() {
							$(".qx").click(function() {
								var id=$(".iid").text();
								window.location.href="DindanFukServlet?iid="+id+"&cz=取消";
							})
							$(".btn-primary").click(function () {
								var shname=$("#ok").find("#shname").text();
								var shphone=$("#ok").find("#shphone").text();
								var shaddress=$("#ok").find("#shaddress").text();
								var num=$("#zojia").text();
								window.location.href="DindanDizServlet?shname="+shname+"&shphone="+shphone+"&shaddress="+shaddress+"&num="+num
							})
						})
					</script>
					 	
				</div>
			</div>
		</div>
			<div class="mohu" style="display:none;"id="dizhi1">
			<div class="ii"></div>
			<div class="box" style="position: absolute;">
				<div class="dizhi">
				<div class="form-container">
		        <form action="GouwucheServlet" method="get">
					<div class="item">
					<input type="text" name="name" placeholder="收货人" style="padding-left: 10px"/>
					<input type="text" name="tele" placeholder="电话" style="padding-left: 10px"/>
					</div>
		            <div class="diqu" data-toggle="distpicker" data-autoselect="3">
		                <select v-model="work.province" name="shen"></select>
		                <select v-model="work.city" name="shi"></select>
		                <select v-model="work.area" name="qu"></select>
		            </div>
					
					<textarea class="myTextarea" name="myTextarea" value="" placeholder="详细信息" style="padding-left: 5px;padding-top: 5px"></textarea>
					<div style="margin: 20px;text-align: center;">
						<input type="submit" class="ti" value="提交">
						<input type="button" class="qu" id="dizhi1" onclick="Dizhi()" value="取消">
					</div>
		            
		        </form>
		    </div>
			</div>
			</div>
			</div>
		
		</div>
	
</body>
</html>