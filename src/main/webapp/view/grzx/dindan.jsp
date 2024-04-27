<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://www.trkj.com/tr03802/tags" prefix="zdy" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
	
#body{
	width: 80%;
}
.an{
	cursor :pointer ;
	border: none;
	width: 100px;
	height: 50px;
	margin-bottom: 10px;
	background-color: white;
}
#dindanbox2{
	margin-bottom:30px ;
	padding: 10px;
	padding-bottom: 1px;
}
 table{
	width: 100%;
	text-align: center;
}
 table th{
	background-color: #f1f1f1;
	padding: 10px 0;
	color: #b1b1b1;
}
.an{
	cursor :pointer ;
	border: none;
	width: 100px;
	height: 50px;
	margin-bottom: 10px;
	background-color: white;
}
td{
	margin-bottom: 10px; 
}
td button {
	border: none;
	padding: 5px 10px;
	margin-bottom: 10px;
}
.xiao{
	display: none;
}
#page a{
	margin: 0 10px;
	font-size: 14px;
}
</style>
 <link type="text/css" rel="stylesheet" href="../../css/head.css"/>
 	<script src="../jquery-3.5.1.min.js"></script>
</head>
<body>
	<jsp:include page="../head.jsp" >
		<jsp:param  name="name" value="${list.get(0).getZ_uname()}"/>
		</jsp:include>
		<div id="bodybig">
		<jsp:include page="dhl.jsp"></jsp:include>
				<div id="body">
					<p id="mydd">我的订单</p>
					<div id="dindanbox">
						<button class="an din" id="quan">全部</button>
						<button class="an din" id="dzf">待付款</button>
						<button class="an din" id="dsh">待收货</button>
						<button class="an din" id="ywc">已完成</button>
						<script type="text/javascript">
							$(function() {
								$("#quan").click(function() {
									window.location.href="DindanServlet";
								})
								$("#dzf").click(function() {
									window.location.href="DindanServlet?zt=待付款";
								})
								$("#dsh").click(function() {
									window.location.href="DindanServlet?zt=已付款";
								})
								$("#ywc").click(function() {
									window.location.href="DindanServlet?zt=完成交易";
								})
							})
						</script>
						<div id="dindanbox2">
							<table>
							<tr>
								<th>订单编号</th>
								<th>商品</th>
								<th>单价</th>
								<th>数量</th>
								<th>小计</th>
								<th>订单总价</th>
								<th>订单状态</th>
								<th>操作</th>
							</tr>
							<c:forEach items="${ddlist }" var="dd" >
								<c:forEach items="${dd}" var="xq" varStatus="status">
									<tr class="shuju">
										<c:if test="${status.index==0}">
											<td rowspan="${fn:length(dd) }" class="id">${xq.getZ_iid() }</td>
										</c:if>
										<td style="line-height: 100px">
											<img alt="" style="float:left; width: 100px;height: 100px" src="../img/${xq.getTup() }">
											${xq.getC_mname() }
											${xq.getColor() }
											${xq.getNc() }
										</td>
										<td>${xq.getC_rsprice() }</td>
										<td>${xq.getZ_number() }</td>
										<td>${xq.getZ_price()}</td>
										<c:if test="${status.index==0}">
											<td rowspan="${fn:length(dd) }">${xq.getDindanzojia() }</td>
										</c:if>
										<c:if test="${status.index==0}">
											<td rowspan="${fn:length(dd) }">${xq.getZ_status() }</td>
										</c:if>
										<c:if test="${status.index==0}">
											<td rowspan="${fn:length(dd) }">
												<c:if test="${xq.getZ_status().equals(\"待付款\") }">
													<button class="fk">立即付款</button>
													<br/>
													<button class="qx">取消订单</button>
													<br/>
												</c:if>
												<c:if test="${xq.getZ_status().equals(\"已付款\") }">
													<button class="sh">确认收货</button>
													<br/>
												</c:if>
												<button class="xq">订单详情</button>
											</td>
										</c:if>
									</tr>
								</c:forEach>
							</c:forEach>
							
							<script>
								$(function() {
									$(".fk").click(function() {
										var id=$(this).parent().parent().find("td").eq(0).text();
										window.location.href="DindanFukServlet?iid="+id+"&cz=付款";
									})
									$(".sh").click(function() {
										var id=$(this).parent().parent().find("td").eq(0).text();
										window.location.href="DindanFukServlet?iid="+id+"&cz=确认收货";
									})
									$(".qx").click(function() {
										var id=$(this).parent().parent().find("td").eq(0).text();
										window.location.href="DindanFukServlet?iid="+id+"&cz=取消";
									})
									$(".xq").click(function() {
										var id=$(this).parent().parent().find("td").eq(0).text();
										window.location.href="DindanXqServlet?iid="+id;
									})
								})
							</script>
							</table>
							<div style="width: 470px;margin: 0 auto;" id="page">
								<zdy:page controller="DindanServlet" pagesize="3" where="${where }" total="${total }" curpage="${curpage }"/>
							</div>
						</div>
					</div>
				</div>
		</div>
		<jsp:include page="../di.jsp" ></jsp:include>
</body>
</html>