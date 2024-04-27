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
    margin-top: 250px;
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
			<span>添加数据</span>
		</div>
		<div id="zhong">
		<script>
		document.addEventListener("DOMContentLoaded", function() {
		    var inputElement = document.querySelector('input[name="jj"]');
		    var initialValue = localStorage.getItem('customValuePage3');
		    var currentValue = initialValue ? parseInt(initialValue) : 19;
		    inputElement.value = currentValue;
		    currentValue++;
		    localStorage.setItem('customValuePage3', currentValue);
		});
</script>
			<form action="CRJiageServlet" method="get">
				<div id="yh"><span>价格id：&nbsp;&nbsp;&nbsp;</span>
				<input type="text" name="jj"/>
				</div>
				<div id="xb"><span>商品单价：&nbsp;&nbsp;&nbsp;</span><input type="text" name="dj"/>
				</div>
				<input type="submit" value="确定" id="qued">
			</form>
		</div>
		<div id="wei" class="ss">
			<button id="gb">关闭</button>
		</div>
</body>
</html>