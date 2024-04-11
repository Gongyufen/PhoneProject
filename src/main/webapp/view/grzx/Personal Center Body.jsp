
<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8">
		<title></title>
		<style type="text/css">
			     input[type="file"] {
				        display: none;
				    }
				
				    /* 自定义上传按钮样式 */
				    .custom-file-upload {
				        display: inline-block;
				        margin-top:30px;
				        padding: 10px 20px;
				        cursor: pointer;
				        background-color: #4CAF50;
				        color: #fff;
				        border: none;
				        border-radius: 4px;
				        transition: background-color 0.3s;
				    }
				
				    /* 按钮悬停时改变背景颜色 */
				    .custom-file-upload:hover {
				        background-color: #45a049;
				    }
				
				    /* 显示所选文件名的容器样式 */
				    .selected-file-name {
				        margin-top: 10px;
				    }
			#yhxx{
				width: 430px;
				overflow: hidden;
				float: left;
			}
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
				overflow: hidden;
			}
			#tui{
				background-color:rgba(0,0,0,0);
				margin-top: 25px;
			}
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
			.txt{
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
				$("#xgmmok").click(function() {
					if($("#lao").val()==""){
						alert("请输入原密码");
						return false;
					}
					if($("#xin").val()==""||$("#xin").val().length<8){
						alert("请输入最少8位数的新密码");
						return false;
					}
					if($("#xin").val()!=$("#xin2").val()){
						alert("两次密码不一致");
						return false;
					}
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
				<div id="yhxx" style="width: 430px">
					<div id="tx">
					 <c:choose>    
						<c:when test="${list.get(0).getZ_avatar()==null }">  
							<img src="../img/ic_avatar.png" style="width: 100%;height: 100%"/>
						</c:when>
						<c:otherwise>
							<img src="${list.get(0).getZ_avatar()}" style="width: 100%;height: 100%"/>	   		 
						</c:otherwise>   
					</c:choose>
					<div id="txyc" style="display:none; color:white;text-align:center;line-height:100px; width: 100%;height: 100%;background-color: rgba(0, 0, 0, 0.5);position: relative;top: -104%; border-radius: 100%;">
						更改头像
					</div>
					</div>
					<script type="text/javascript">
						$(function() {
							$("#tx").click(function() {
								$("#bigbox-tx").css("display","block");
								$("body").css("overflow","hidden");
							})
							$("#tx").hover(function() {
								$("#txyc").css("display","block");
							},function(){
								$("#txyc").css("display","none"); 
							})
						})
					</script>
					
					<div id="name">
						<span>${list.get(0).getZ_uname() }，
						<%
						  // 获取当前时间的小时
						  Date date=new Date();
						  int hour = date.getHours();
						%>
						<%=hour>12?"下午好":"上午好" %>
						</span>
						<span style="color: red;">${ok }</span>
						<br/>
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
								<input name="name" id="nametxt" class="txt" placeholder="请输入你的用户名"/><br/>
								<span style="color:red;">${cf}</span>
								<input name="id" value="${list.get(0).getZ_uid() }" style="display: none">
							</div>
							<input class="update" type="submit" id="xgname" value="确认更改"/>
							<script type="text/javascript">
								$(function() {
									$("#xgname").click(function() {
										if($("#nametxt").val()==""){
											alert("用户名不能为空")；
											return false;
										}
									})
								})
							</script>
						</form>
							
						</div>
					</div>
					<div id="mm" class="yc">
						<div class="neibox">
							<form action="XgMm" method="post">
								<div class="wb" id="mi">
									<input name="lao" placeholder="请输入原密码" id="lao" class="txt"/><br/>
									<input name="xin" placeholder="请输入新密码" id="xin" class="txt"/><br/>
									<input name="id" value="${list.get(0).getZ_uid() }" style="display: none">
									<input placeholder="请确认密码" class="txt" id="xin2" name="xin2" />
									<br/>
									<span style="color:red;" id="ts">${fh}</span>
							</div>
								<input type="submit" class="update" id="xgmmok" value="确认更改"/>
							</form>
							
						</div>
					</div>
					<div id="dh" class="yc">
						<div class="neibox">
						<form action="XgPhoneServlet" method="post">
							<div class="wb">
								<input name="phone" id="dhtxt" placeholder="请输入您想更改的电话" class="txt"/>
								<input name="id" value="${list.get(0).getZ_uid() }" style="display: none">
							</div>
							<input type="submit" class="update" id="phone" value="确认更改"/>
							<script type="text/javascript">
								$(function() {
									$("#phone").click(function() {
										if($("#dhtxt").val().length!=11){
											alert("请输入11位的手机号");
											return false;
										}
									})
								})
							</script>
						</form>
							
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
		<!-- 修改头像 -->
					<div id="bigbox-tx" style="position:absolute;top:0;left:0; display: none;width: 100%;height: 100%;background:rgba(0, 0, 0, 0.5);">
						<div id="xbox" style="width: 250px;border-radius: 10px;margin: 350px auto 0;padding: 10px;background-color: white;text-align: center;">
							<img src="../img/x (2).png" id="x" style="float: right;">
							<span style="font-size: 10px;float: left;">头像修改(仅支持JPG/JPEG、PNG图片格式)</span>
							<form action="XgTxServlet" method="post" enctype="multipart/form-data">
						        <!-- 自定义上传按钮 -->
						        <label for="fileInput" class="custom-file-upload">上传头像</label>
						        <!-- 实际的文件选择输入框 -->
						        <input type="file" id="fileInput" name="file">
								<input name="id" value="${list.get(0).getZ_uid() }" style="display: none">
						        <!-- 显示所选文件名的容器 -->
						        <div class="selected-file-name" style="font-size: 12px">
						            你选择的图片:
						            <br/><span id="fileName"></span>
						        </div>
						
						        <button type="submit" style="padding: 5px 10px;margin-top: 5px">确定</button>
						    </form>
							<script>
						        // 监听文件选择框的变化事件
						        document.getElementById("fileInput").addEventListener("change", function() {
						            // 获取所选文件的文件名
						            var fileName = this.files[0].name;
						            // 将文件名显示在页面上
						            document.getElementById("fileName").textContent = fileName;
						        });
						        //点击“X”关闭修改头像
						        $(function() {
									$("#x").click(function() {                                                                                                                                                                                                                                                                                                                                                                             
										$(this).parent().parent().css("display","none");
										$("body").css("overflow","auto");
									})
								})
						    </script>
						</div>
					</div>
		<jsp:include page="../di.jsp" ></jsp:include>
	</body>
</html>