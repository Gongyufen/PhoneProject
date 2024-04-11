<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
</style>
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
						<button class="an din" id="dfh">待发货</button>
						<button class="an din" id="dsh">待收货</button>
						<button class="an din" id="ywc">已完成</button>
						<div id="dindanbox2">
							<table>
								<th>订单编号</th>
								<th>商品</th>
								<th>单价</th>
								<th>数量</th>
								<th>订单状态</th>
								<th>操作</th>
							</table>
						</div>
					</div>
				</div>
		</div>
		<jsp:include page="../di.jsp" ></jsp:include>
</body>
</html>