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
	width: 100%;
	overflow: hidden;
}
#pinglun #yonghu{
	float: left;
	margin: 10px 0px 0px 10px;
}
#yonghu #neirong{
	float: left;
	margin: 25px 10px 0px 0px;
}
.cz button{
 	padding: 5px 10px;
	background-color: #f1f1f1; 
	border: 1px #a1a1a1 solid;
}
.cz span {
	display: none;
}
.xiao{
	display: none;
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
					<c:forEach items="${pllst}" var="pl">
						<div id="pinglun" >
								<div id="neirong" style="float: left;">
										<div style="width: 100px;height: 10px;border-radius: 5px;background-color: #f1f1f1;">
											<div style="background-color:#ff1212; height: 10px;border-radius: 5px; width: ${pl.evaluation/5*100}%;"></div>
										</div>
										
									<div style="margin: 20px">${pl.txt }</div>
								</div>
								<div style="float: right;">
									${pl.z_time }
								</div>
						</div>
						<div class="cz">
							<span class="cid">${pl.z_cid }</span>
							<span class="did">${pl.getDid() }</span>
							<span class="iid">${pl.getIid() }</span>
							<button class="ck" >查看该订单</button>
							<button class="sc" >删除评论</button>
						</div>
					</c:forEach>
					<script type="text/javascript">
						$(function() {
							$(".ck").click(function() {
								var iid=$(this).parent().find(".iid").text();
								window.location.href="DindanXqServlet?iid="+iid;
							})
							$(".sc").click(function() {
								var cid=$(this).parent().find(".cid").text();
								window.location.href="DeleteplServlet?cid="+cid;
							})
							
						})
					</script>
					
				</div>
		</div>
		<jsp:include page="../di.jsp" ></jsp:include>
</body>
</html>