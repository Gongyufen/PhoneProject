<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
#sh{
	width: 100%;
	height: 100px;
	background: #e1e1e1;
}
#sh span{
	line-height: 100px;
    font-size: 20px;
	margin-left: 20px;
}
#zhong{
	width: 55%;
	height: 503px;
	background: #a1a1a1;
	display: flex;
	justify-content: center;
}
#zhong form #yh{
	padding-top: 210px;
	margin-left: 45px;
}
#zhong form #yh select{
	width: 165px;
	height: 21px;
}
#zhong form #xb{
	padding-top: 45px;
	margin-left: 31px;
}
#zhong form #xb input{
	width: 165px;
	height: 21px;
}
#wei{
	width: 100%;
	height: 105px;
	background: #e1e1e1;
}
#wei button{
	width: 60px;
    margin-left: 15px;
    float: right;
    border-radius: 5px;
    margin-top: 49px;
    height: 30px;
    background: #a1a1a1;
    border: none;
}
#zhong input#qued {
   right: 110px;
    margin-right: -37px;
    width: 60px;
    height: 30px;
    border-radius: 5px;
    background: #a1a1a1;
    border: none;
    float: right;
    position: absolute;
    margin-top: 248px;
}
#zhong input#qued:hover{
	background-color: dimgray;
}
#wei button:hover{
	background-color: dimgray;
}
</style>
</head>
<body>
	<div id="sh" class="ss">
			<span>编辑数据</span>
		</div>
		<div id="zhong">
			<form action="XGflServlet" method="get" onsubmit="return checkForm();">
				<div id="yh"><span>类别id：&nbsp;&nbsp;&nbsp;</span>
				<input type="text" id="c_cid" readonly style="width: 165px; height: 21px" name="idd">
				</div>
				<div id="xb"><span>类别名称：&nbsp;&nbsp;&nbsp;</span><input type="text" id="c_category" name="lbm"/>
				</div>
				<input type="submit" value="确定" id="qued"/>
			</form>
		</div>
		<div id="wei" class="ss">
			<button id="qd" onclick="closeWindow()">关闭</button>
			<script type="text/javascript">
		function closeWindow() {
		    window.history.back();
		    window.close();
		}
		</script>
		</div>
		<script type="text/javascript">
		document.addEventListener("DOMContentLoaded", function() {
		    const id = sessionStorage.getItem('editId');
		    const c_category = sessionStorage.getItem('editCategory');
		    document.getElementById('c_cid').value = id;
		    document.getElementById('c_category').value = c_category;
		});
			</script>
			<script>
function checkForm() {
    var idd = document.getElementsByName("idd")[0].value;
    if (idd == "") {
        alert("idd 不能为空");
        return false;
    }
    return true;
}
</script>
			
</body>
</html>