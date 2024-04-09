<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
	*{
	margin: 0 auto;
	padding: 0;
}
#shang{
	width:53%;
	height: 105px;
	margin-left:23%;
	margin-top: 75px;
	background-color: #e1e1e1;
	border: 1px solid gray;
	border-radius: 5px;
}
#xia{
	width:51.5%;
	margin-left:23%;
	height: 400px;
	margin-top: 30px;
	background-color: #e1e1e1;
	border: 1px solid gray;
	border-radius: 5px;
	padding: 10px;
	padding-top:0px;
	overflow: auto;
}
#shang form #yh{
	padding-top: 20px;
	padding-left: 25px;
	font-size: 14px;
}
#shang form #sj{
	margin-top: -20px;
	font-size: 14px;
	margin-left: 297px;
}
#shang form #zt{
	margin-left: 24px;
	margin-top: 15px;
	font-size: 14px;
	display: inline-block;
}
#shang form #b1{
	display: inline-block;
	width: 55px;
	border: none;
	border-radius: 5px;
	background: #a1a1a1;
	margin-left: 30px;
	height: 25px;
}
#shang form #b1:hover{
	background-color:dimgray;
}
#shang form #b2{
	display: inline-block;
	width: 55px;
	border: none;
	border-radius: 5px;
	background: #a1a1a1;
	height: 25px;
	margin-left: 20px;
}
#shang form #b2:hover{
	background-color:dimgray;
}
#xia table {
    width: 100%;
	margin-top: 13px;
    border-collapse: collapse;
}
#xia th, #xia td {
    border: 1px solid #ccc; 
    padding: 8px;
    text-align: center;
}
#xia th {
    background-color: #f2f2f2;
}
#xia tr:nth-child(even) {
    background-color: #f9f9f9;
}
#xia tr:hover {
    background-color: #f1f1f1;
}
#xia #tj{
	width: 55px;
	margin-top: 20px;
	height: 30px;
	border: none;
	border-radius: 5px;
	background: #a1a1a1;
}
#xia #sc{
	width: 55px;
	margin-top: 20px;
	height: 30px;
	border: none;
	border-radius: 5px;
	background: #a1a1a1;
	margin-left: 15px;
}
#xia #sc:hover{
	background-color:dimgray ;
}
#xia #tj:hover{
	background-color: dimgray;
}
#xia table tr td button{
	margin-right: 5px;
	width: 40px;
	border: none;
	border-radius: 5px;
	background: #a1a1a1;
	height: 30px;
}
#xia table tr td button:hover{
	background-color:dimgray ;
}
</style>
</head>
<body>
<script>
			       document.addEventListener("DOMContentLoaded", function() {
			           const selectedColor = localStorage.getItem('selectedColor');
			           if (selectedColor) {
			               var divs = document.getElementsByClassName('ss');
			               for (var j = 0; j < divs.length; j++) {
			                   divs[j].style.backgroundColor = selectedColor;
			               }
			           }
			       });
			</script>
	<jsp:include page="../view/head.jsp" >
	<jsp:param  name="name" value="${list.get(0).getZ_uname()}"/>
	</jsp:include>
				<div id="shang" class="ss">
			<form>
				<div id="yh"><span>用户名称：</span><input type="text"/></div>
				<div id="sj"><span>手机号码：</span><input type="text"/></div>
				<div id="zt">
				<span>用户状态：</span>
				<select>
					<option>1(可用)</option>
					<option>2(不可用)</option>
				</select>
				</div>
				<input type="button" id="b1" value="搜索"/>
				<input type="button" id="b2" value="清空"/>
			</form>
		</div>
		<div id="xia" class="ss">
			<button id="tj">添加</button>
			<button id="sc">删除</button>
			<table border="1">
				<script>
				   document.addEventListener("DOMContentLoaded", function() {
				       var button = document.getElementById("tj");
				       button.addEventListener("click", function() {
				           window.location.href = "yhtj.html";
				       });
				       var bjButtons = document.querySelectorAll(".bj");
				       bjButtons.forEach(function(button) {
				           button.addEventListener("click", function() {
				               window.location.href = "yhbj.html";
				           });
				       });
				   });
					</script>
				<tr>
					<th><input type="checkbox"/></th>
					<th>编号</th>
					<th>用户名</th>
					<th>性别</th>
					<th>手机号</th>
					<th>用户状态</th>
					<th>操作</th>
				</tr>
				<tr>
    	<c:forEach items="${list}" var="item">
        <tr>
            <td><input type="checkbox"/></td>
            <td>${item.z_uid}</td>
            <td>${item.z_uname}</td>
            <td>${item.z_esx}</td>
            <td>${item.z_phone}</td>
            <td>${item.z_state}</td>
            <td><button class="bj">编辑</button><button>删除</button></td>
        </tr>
    </c:forEach>
</tr>
				
			</table>
		</div>
	<jsp:include page="../view/wei.jsp" >
	<jsp:param  name="name" value="${list.get(0).getZ_uname()}"/>
	</jsp:include>
</body>
</html>