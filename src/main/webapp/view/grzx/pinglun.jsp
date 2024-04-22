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
#pinglun{
	margin: 0 auto;
	margin-top: 50px;
}
#pinglun #yonghu{
	height: 150px;
	float: left;
	margin: 10px 0px 0px 10px;
}
#yonghu #neirong{
	height: 100px;
	float: right;
	margin: 25px 10px 0px 0px;
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
					<p id="mydd">我的评论</p>
					<div id="pinglun">
						<div id="yonghu">
							<div id="neirong">
								.....
								<button class="ck">查看该订单</button>
							</div>
							
						</div>
					</div>
				</div>
		</div>
		<jsp:include page="../di.jsp" ></jsp:include>
</body>
</html>