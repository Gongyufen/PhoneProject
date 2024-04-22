<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
 
<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8">
		<title>订单详情</title>
	</head>
	<style>
		*{
			margin: 0;
			padding: 0;
			
		}
		a{
			text-decoration: none;
			
		}
		.mi-box{
			padding: 36px 48px;
			background-color: #fff;
		
		}
		.box-hd{
			border-bottom:#757575;
			margin-bottom: 20px;
			height: 130px;
			border-bottom: 1px solid #e0e0e0;
		}
		.title{
			margin: 0;
			    font-size: 30px;
			    font-weight: 400;
			    line-height: 68px;
			    color: #757575;
				margin-bottom: 10px;
		}
		.btn{
			margin-right: 5px;
			width: 118px;
			height: 28px;
			font-size: 12px;
			line-height: 28px;
			display: inline-block;
			text-align: center;
		}
		.goods{
			width: 100%;
		}
		.goods-box{
			border-bottom: 1px solid #e0e0e0;
		}
		.cloo{
			text-align: left;
			    color: #333;
				padding-bottom: 20px;
		}
		.goods-img{
			width: 80px;
		}
		.order{
			    position: relative;
			    padding: 0px 0 35px;
			    margin-bottom: 30px;
			    border-bottom: 1px solid #e0e0e0;
				 color: #757575;
		}
		.order table th{
			 color: #757575;
			 padding: 3px 0;
			 padding-right:1em;
		}
		.order table td{
			font-size: 15px;
		}
		.btn-small{
			    width: 118px;
			    height: 28px;
			    font-size: 12px;
			    line-height: 28px;
				display: block;
				margin: 18px 0 10px;
				background: #fff;
				color: #757575;
				border: 1px solid #b0b0b0;
				text-align: center;
		}
		.total{
			margin: 0 0 0 auto;
			color: #757575;
			border-collapse: collapse;
			border-spacing: 0;
		}
		.total td{
			width: 150px;
		}
		.weos{
			    position: relative;
			    padding: 0px 0 35px;
			    margin-bottom: 30px;
				color: #757575;
				height: 123px;
				text-align: right;
		}
#bigbox-diz input{
	width: 230px;
	margin: 30px auto;
	padding: 10px 20px;
	outline:none;
}
#xxdiz{
	width: 500px;
}
#sbox{
	display: inline-block;
}
.select{
	width: 302px;
	margin: 30px auto; 
	padding: 10px 20px;
	border: 1px black solid;
}

select{
	border: none;
	outline:none;
	width: 200px;
	text-align: center;
}
	</style>
			<script src="../jquery-3.5.1.min.js"></script>
	
	<body>
	<jsp:include page="../head.jsp" >
		<jsp:param  name="name" value="${list.get(0).getZ_uname()}"/>
		</jsp:include>
		<div style="width: 978px;height: 677px;background-color: wheat;margin: 0 auto;">
			<div class="mi-box">
				
				<div class="box-hd">
					<h1 class="title">订单详情</h1>
					<div style="float: left;height: 30px;line-height: 30px;">
						<span>订单编号:${ddxq.get(0).get(0).getZ_iid() }</span>
					</div>
					</div>
					
					<div style="padding: 35px 0;">
						<table class="goods" style="border-collapse:collapse;border-spacing: 0;">
							<c:forEach  items="${ddxq}" var="xq">
							<c:forEach items="${xq }" var="xqsp">
								<tr class="goods-box">
									<td class="cloo" style="line-height: 80px">	
										<img src="../img/${xqsp.getTup() }" style="float:left;width: 80px;height: 80px;"/>
										${xqsp.getC_mname() }
											${xqsp.getColor() }
											<span style="display: none;" id="did"> ${xqsp.getDid() }</span>
											${xqsp.getNc() }*${xqsp.getZ_number()}
									</td>
									<td>
										单价：${xqsp.getC_rsprice()}<br/>
										小计：${xqsp.getC_rsprice()*xqsp.getZ_number()}
									</td>
									<td>
									<c:if test="${ddxq.get(0).get(0).getZ_status().equals(\"完成交易\") }">
								<button class="pl" style="padding: 5px 15px;background-color: #f1f1f1;border: 1px solid #a1a1a1;">去评论</button>
								<script type="text/javascript">
									$(function() {
										$(".pl").click(function() {
											$(".did").val($("#did").html());
											$("#bigbox-pl").css("display","block");
										})
									})
								</script>
							</c:if>
										
									</td>
								</tr>
							</c:forEach>
							</c:forEach>
							
						</table>
						
					</div>
					
					<div class="order">
						<h3>收货信息</h3>
						<table>
							<tr>
								<th>姓&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;名:</th>
								<td>${ddxq.get(0).get(0).getZ_consignee() }</td>
							</tr>
							<tr>
								<th>联系电话:</th>
								<td>${ddxq.get(0).get(0).getZ_phone() }</td>
							</tr>
							<tr>
								<th>收货地址:</th>
								<td>${ddxq.get(0).get(0).getZ_address() }</td>
							</tr>
						</table>
						<div style="position: absolute;top: 5px;right: 0;">
							<c:if test="${ddxq.get(0).get(0).getZ_status().equals(\"待付款\") }">
								<button class="xg btn" style="border: 1px solid #b0b0b0;color: #757575;background-color: white;" >修改</button>
								<script type="text/javascript">
									$(function() {
										$(".xg").click(function() {
											
											$("#bigbox-diz").css("display","block");
										})
									})
								</script>
								<script src="https://cdn.bootcss.com/jquery/3.2.1/jquery.js"></script>
								<script src="https://cdn.bootcss.com/distpicker/2.0.1/distpicker.js"></script>
							</c:if>
						</div>
					</div>
					
					<div class="order">
						<h3>支付方式</h3>
						<table>
							<tr>
								<th>支付方式:</th>
								<td>在线支付</td>
							</tr>
						</table>
					</div>
					
					<div class="weos">
						<table class="total">
							<tbody>
							<tr>
								<td>订单总价:</td>
								<td>
									<span class="num">${ddxq.get(0).get(0).getZ_price() }</span>元
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
									<span class="num" style="font-size: 30px;">${ddxq.get(0).get(0).getZ_price() }</span>元
								</td>
							</tr>
							
							</tbody>
						</table>
					</div>
				
				
			</div>
		</div>
		
		<!-- 修改地址 -->
		<div id="bigbox-diz" style="position:absolute;top:0;left:0; display: none;width: 100%;height: 100%;background:rgba(0, 0, 0, 0.5);">
			<div id="xbox" style="width: 700px; overflow: hidden; border-radius: 10px;margin: 350px auto 0;padding: 10px;background-color: white;text-align: center;">
				<span>修改订单地址</span>
				<img src="../img/x (2).png" id="x" style="float: right;">
				<div id="shdz" class="xg" data-toggle="distpicker" data-autoselect="3">
					<form method="get" action="DindanDizServlet">
						<br/>
						<input value="${ddxq.get(0).get(0).getZ_iid() }" name="id" style="display: none;">
						<input style=" margin:0 auto;" name="name" placeholder="请输入收件人姓名" id="xgname"/>
						<br/>
						<input name="phone" placeholder="请输入收件人电话" id="xgdh" style="margin:0 aotu;"/><br />
						<br/>
						<div class="select" id="sbox" style="margin:0 aotu;">
							省：<select id="xgs"  v-model="work.province" name="shen"></select>
						</div>
						<div class="select" id="cbox">
							市：<select id="xgc" v-model="work.city" name="shi"></select>
						</div>
						<div class="select" id="qbox">
							区：<select id="xgq" v-model="work.area" name="qu"></select>
						</div> 
						<input style="width: 500px;margin:0 aotu;" name="xxdiz" id="xgxxdiz" placeholder="请输入详细地址" /><br/>
						<input type="submit" id="ok" value="确认修改"/>
					</form>
				</div>
				<script>
					$(function() {
				        $("#ok").click(function(){
							var name=$("#name").val();
							var phone=$("#phone").val();
							var s=$("#s").val();
							var c=$("#c").val();
							var q=$("#q").val();
							var xxdz=$("#xxdiz").val();
							if(name==""){
								alert("请输入收货人姓名");
								return false;
							}
							if(s==""){
								alert("请选择省份");
								return false;
							}
							if(c==""){
								alert("请选择城市");
								return false;
							}
							if(q==""){
								alert("请选择区");
								return false;
							}
							if(xxdz==""){
								alert("请输入详细地址");
								return false;
							}
							if(phone.val().length!=11){
								alert("请输入11位的手机号");
								return false;
							}
						})
						$("#x").click(function() {                                                                                                                                                                                                                                                                                                                                                                             
							$(this).parent().parent().css("display","none");
						})
					})
				</script>
			</div>
		</div>
		<!-- 评论 -->
		<div id="bigbox-pl" style="position:absolute;top:0;left:0; display: none;width: 100%;height: 100%;background:rgba(0, 0, 0, 0.5);">
			<div id="xbox" style="width: 500px; height:200px; overflow: hidden; border-radius: 10px;margin: 350px auto 0;padding: 10px;background-color: white;text-align: center;">
				<span>评论</span>
				<img src="../img/x (2).png" id="xpl" style="float: right;">
				<div id="shdz" class="xg" data-toggle="distpicker" data-autoselect="3">
					<form method="get" action="PinglunServlet">
						<br/>
						满意度:
						<select name="pj" id="pj">
							<option value="1">很不满意</option>
							<option value="2">不满意</option>
							<option value="3">一般</option>
							<option value="4">满意</option>
							<option value="5">很满意</option>
						</select>
						<input name="iid" style="display: none;" value="${ ddxq.get(0).get(0).getZ_iid()}">
						<input name="did" class="did" style="display: none;">
						<textarea style="margin: 20px 0" id="message" name="message" rows="4" cols="50"></textarea><br>
						<input type="submit" id="ok" value="发布评论"/>
					</form>
				</div>
				<script>
			       $(function() {
						$("#xpl").click(function() {                                                                                                                                                                                                                                                                                                                                                                             
							$(this).parent().parent().css("display","none");
						})
					})
				</script>
			</div>
		</div>
		<jsp:include page="../di.jsp" ></jsp:include>
	</body>
</html>