<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8">
		<title></title>
		<style type="text/css">
					
			#body{
				width: 82%;
				margin:0 auto;
				padding: 20px 0px 20px 50px;
				overflow: hidden;
				display: inline-block;
			}
			#bodybig{
				width: 80%;
				margin: 0 auto;
			}
			.an{
				cursor :pointer ;
				border: none;
				width: 100px;
				height: 50px;
				margin-bottom: 10px;
				background-color: white;
			}
			
			#name{
				padding-top: 20px;
				font-size: 20px;
				float: left;
			}
			#tx{
				width: 100px;
				height: 100px;
				border-radius: 100%;
				background-repeat: no-repeat;
				background-position: 20px;
				float: left;
				margin-right: 30px;
			}
			#tui{
				background-color:rgba(0,0,0,0);
				margin-top: 25px;
			}
			/* 我的订单 */
			/* 更改用户名 */
			.neibox{
				margin: 0 auto;
				width: 400px;
				background-color: white;
				padding:5px 10px;
				text-align: center;
				line-height: 30px;
				border-radius: 10px;
			}
			.update{
				width: 100px;
				height: 50px;
				border-radius: 10px;
				border: #f1f1f1 1px solid;
				
			}
			#txt{
				width: 300px;
				padding: 10px 10px;
				margin-bottom: 10px;
			}
			.yc{
				display: none;
			}
			 .yc:first-of-type{
				 display: block;
			 }
			.neibox .wb{
				margin-top: 65px;
				margin-bottom: 20px;
			}
			#mi {
				margin: 10% auto;
			}
			p{
				font-size: 24px;
				height: 35px;
				margin-bottom: 20px;
			}
		</style>
		<script src="../jquery-3.5.1.min.js"></script>
		<script>
			$(function(){
				$("#dz").click(function(){
					window.location.href="收货地址.html";
				})
				$("#xgyhm").click(function(){
					$("#p").html("修改用户名");
					$("#mm").css("display","none");
					$("#dh").css("display","none");
					$("#yhm").css("display","block");
				})
				$("#xgmm").click(function(){
					$("#p").html("修改密码");
					$("#yhm").css("display","none");
					$("#dh").css("display","none");
					$("#mm").css("display","block");
					
				})
				$("#xgphone").click(function(){
					$("#p").html("修改电话");
					$("#mm").css("display","none");
					$("#yhm").css("display","none");
					$("#dh").css("display","block");
				})
			})
		</script>
	</head>
	<body>
	<jsp:include page="../head.jsp" >
	<jsp:param  name="name" value="${list.get(0).getZ_uname()}"/>
	</jsp:include>
	
			<!-- 主体 -->
			<p>个人中心</p>
			
			<div id="grzx" class="box">
				<!-- 信息管理 -->
				<div id="yhxx">
					<div id="tx">
					 <c:choose>    
						<c:when test="${list.get(0).getZ_avatar()==null }">  
							<img src="../img/ic_avatar.png" style="width: 100%;height: 100%"/>
						</c:when>
						<c:otherwise>
							<img src="${list.get(0).getZ_avatar()}" style="width: 100%;height: 100%"/>	   		 
						</c:otherwise>   
					</c:choose>
					</div>
					<div id="name">
						<span>${list.get(0).getZ_uname() }</span><br/>
						<span>${ list.get(0).getZ_phone()}</span>
					</div>
					
				</div>
				<button style="float: right;" class="an" id="tui">退出登录</button>
			</div>
			<div id="bodybig">
				
			<jsp:include page="dhl.jsp"></jsp:include>
			
			<div id="body">
				<div>
					<p id="p">修改用户名</p>
					<div id="yhm" class="yc">
						<div class="neibox">
						<form action="XgnameServlet" method="post">
							<div class="wb">
								<input name="name" id="txt" placeholder="请输入你的用户名"/><br/>
								<span style="color:red;">${cf}</span>
								<input name="id" value="${list.get(0).getZ_uid() }" style="display: none">
							</div>
							<input class="update" type="submit" value="确认更改"/>
						</form>
							
						</div>
					</div>
					<div id="mm" class="yc">
						<div class="neibox">
							<div class="wb" id="mi">
								<input name="name" placeholder="请输入原密码" id="txt"/><br/>
								<input name="name" placeholder="请输入新密码" id="txt"/><br/>
								<input placeholder="请确认密码" id="txt" name="name" />
							</div>
							<input type="submit" class="update" value="确认更改"/>
						</div>
					</div>
					<div id="dh" class="yc">
						<div class="neibox">
							<div class="wb">
								<input name="name" placeholder="请输入您想更改的电话" id="txt"/>
							</div>
							<input type="submit" class="update" value="确认更改"/>
						</div>
					</div>
					<!-- 
					<p id="mydd">我的评论</p>
					<div id="dindanbox">
						
						<div id="dindanbox2">
							<table>
								<th>商品</th>
								<th style="width: 500px;">评论</th>
								<th>评论时间</th>
							</table>
						</div>
					</div> -->
				</div>
			</div>
			
		</div>
		<jsp:include page="../di.jsp" ></jsp:include>
	</body>
</html>