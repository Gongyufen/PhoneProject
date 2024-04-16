<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link type="text/css" rel="stylesheet" href="../css/userbj.css"/>
<style type="text/css">
	#zhong input#qued {
   right: 110px;
    width: 60px;
    height: 30px;
    border-radius: 5px;
    background: #a1a1a1;
    border: none;
    float: right;
    position: absolute;
    margin-top: 320px;
}
#zhong input#qued:hover{
	background-color: dimgray;
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
		<div id="sh" class="ss">
			<span>编辑数据</span>
		</div>
		<div id="zhong">
		<script type="text/javascript">
		document.addEventListener("DOMContentLoaded", function() {
		    // 从sessionStorage获取ID
		    const editId = sessionStorage.getItem('editId');
		    // 设置隐藏字段的值
		    document.querySelector('input[name="id"]').value = editId;
		});
		</script>
			<form method="get" action="XGuserServlet">
				<input type="hidden" name="id" value="<%= session.getAttribute("editId") %>">
				<div id="yh"><span>用户名：&nbsp;&nbsp;&nbsp;&nbsp;</span><input type="text" id="z_uname" name="z_uname"/></div>
				<div id="xb"><span>性别：&nbsp;&nbsp;&nbsp;</span>
				<select id="z_esx" name="z_esx">
					<option value="男">男</option>
					<option value="女">女</option>
				</select>
				</div>
				<div id="sj"><span>手机号：&nbsp;&nbsp;&nbsp;</span>
				<input type="text" id="z_phone" name="z_phone" maxlength="11"/>
				</div>
				<div id="zt"><span>状态：&nbsp;&nbsp;&nbsp;</span>
					<select id="z_state" name="z_state">
						<option value="1">1(可用)</option>
						<option value="2">2(不可用)</option>
					</select>
				</div>
				<input type="submit" value="确定" id="qued">
			</form>
			<script type="text/javascript">
			document.addEventListener("DOMContentLoaded", function() {
			    const editData = JSON.parse(sessionStorage.getItem('editData'));
			    document.getElementById('z_uname').value = editData.z_uname;
			    document.getElementById('z_esx').value = editData.z_esx; 
			    document.getElementById('z_phone').value = editData.z_phone;
			    document.getElementById('z_state').value = editData.z_state;
			    const editId = editData.id; // 获取编辑行的id值
			    sessionStorage.setItem('editId', editId); // 存储编辑行的id值
			});
			</script>
		</div>
		<div id="wei" class="ss">
		<script type="text/javascript">
		function closeWindow() {
		    window.history.back();
		    window.close();
		}
		</script>
			<button id="gb" onclick="closeWindow()">关闭</button>
		</div>
</body>
</html>