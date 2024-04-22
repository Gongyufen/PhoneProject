<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.trkj.com/tr03802/tags" prefix="zdy" %>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
#shangpin{
	width: 290px;
	height: 410px;
	float: left;
	margin: 10px 0px 0px 10px;
	background-color: white;
}
#shangpin:hover{
	cursor: pointer;
	box-shadow: 0 0 20px rgba(0, 0, 0, 0.15);
}
.zi{
	text-align: center;
	line-height: 40px;
}
.zi .js{
	color: #a1a1a1;
}
#body{
	display: list-item;
	width: 80%;
}
.xiao{
				display: none;
			}
</style>
</head>
<body>
	<jsp:include page="head.jsp">
		<jsp:param name="name" value="${list.get(0).getZ_uname()}" />
	</jsp:include>
	<div id="bodybig">
		<jsp:include page="grzx/dhl.jsp"></jsp:include>
		<div id="body">
		<c:forEach items="${lljllist}" var="uid">
			<c:forEach items="${uid}" var="mid">
				<div id="shangpin" class="shangpin">
					<div class="img">
						<img style="width: 100%; height: 100%;" src="../img/1.1千山绿.png" />
					</div>
					<div class="zi">
					<span class="id" style="display: none;">${mid.getC_mid() }</span>
						${mid.c_mname }<br /> <span class="js">${mid.c_describe }</span><br />
						<span class="jg">￥${mid.c_rsprice }</span>
					</div>
				</div>
				<script type="text/javascript" src="../jquery-3.5.1.min.js"></script>
				<script>
					$(function() {
						$(".shangpin").click(function() {
							var mid=$(this).find(".zi").find(".id").text();
							window.location.href="XiangqingServlet?mid="+mid;
						})
					})
				</script>
				
			</c:forEach>
		</c:forEach>
		
		</div>
	</div>
</body>
</html>