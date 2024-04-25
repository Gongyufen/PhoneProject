<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>搜索</title>
<link type="text/css" rel="stylesheet" href="../css/sousuo.css" />
<link type="text/css" rel="stylesheet" href="../css/head.css" />
<link type="text/css" rel="stylesheet" href="../css/di.css" />
</head>
<body>
	
	<jsp:include page="head.jsp">
		<jsp:param name="name" value="${list.get(0).getZ_uname()}" />
	</jsp:include>
	
		
		<div id="paixu">
			<ul>
				<li id="ziduan">排序：</li>
				<li id="ziduan"><a href="">综合</a></li>
				<li id="ziduan"><a href="">最新</a></li>
				<li id="ziduan"><a href="">评论数</a></li>
				<li id="ziduan"><a href="">价格</a></li>
			</ul>
			
		</div>
			<div id="hezi">
			<c:choose >
				<c:when test="${sousuo.size()!=0  }">
					<c:forEach items="${sousuo}" var="p">
						<div id="shangpin" class="shangpin" as = '${p}'>
							<div class="img">
								<img style="width: 100%; height: 100%;" src="../img/1.1千山绿.png" />
							</div>
							<div class="zi">
							<span class="mid" style="display: none;">${p.getC_mid() }</span>
								${p.c_mname }<br /> <span class="js">${p.c_describe }</span><br />
								<span class="jg">￥${p.c_rsprice }</span>
							</div>
						</div>
					</c:forEach>
					
				</c:when>
				<c:when test="${sousuo.size()==0 }">
					<div style="font-size: 18px; text-align: center;margin: 20px 0 20px 0;">抱歉，没有找到您搜索的相关商品，试试修改搜索词吧！</div> 
				</c:when>
			</c:choose>
			</div>
			<script type="text/javascript" src="../jquery-3.5.1.min.js"></script>
				<script>
					$(function() {
						$(".shangpin").click(function() {
							var mid=$(this).find(".zi").find(".mid").text();
							window.location.href="XiangqingServlet?mid="+mid;
						})
					})
				</script>
			<div style="text-align: center; color: gray;">到底了</div>
		
		<jsp:include page="di.jsp"></jsp:include>
		
</body>
</html>