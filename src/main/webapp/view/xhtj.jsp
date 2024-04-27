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
			<form action="CRXinghaoServlet" method="get" id="firstForm">
			<input type="hidden" name="hiddenValue">
        <script>
        document.addEventListener("DOMContentLoaded", function() {
		    var inputElement = document.querySelector('input[name="hiddenValue"]');
		    var initialValue = localStorage.getItem('customValuePage5');
		    var currentValue = initialValue ? parseInt(initialValue) : 19;
		    inputElement.value = currentValue;
		    currentValue++;
		    localStorage.setItem('customValuePage5', currentValue);
		});
        document.getElementById('firstForm').addEventListener('submit', function(e) {
            e.preventDefault(); // 阻止表单默认提交行为
            var hiddenValue = document.querySelector('input[name="hiddenValue"]').value;
            var spmValue = document.getElementById('c_category').value;
            var lbValue = document.querySelector('select[name="lb"]').value;
            
            // 将lbValue存储到本地存储中
            localStorage.setItem('lbValue', lbValue);
            
            var form = document.getElementById('firstForm');
            var url = 'CRXinghaoServlet?hiddenValue=' + encodeURIComponent(hiddenValue) + '&spm=' + encodeURIComponent(spmValue) + '&lb=' + encodeURIComponent(lbValue);
            form.setAttribute('action', url);
            form.setAttribute('method', 'get');
            form.submit(); // 提交表单
            
            var newValue = 21; // 重新设定初始值为21
            localStorage.setItem('hiddenValue', newValue);
            document.querySelector('input[name="hiddenValue"]').value = newValue;
            localStorage.setItem('lbValue', lbValue);
        });
</script>
				<div id="yh"><span>类别id：&nbsp;&nbsp;&nbsp;</span>
				<select name="lb">
					<option value="1">OPPO</option>
					<option value="2">HUAWEI</option>
					<option value="3">vivo</option>
					<option value="4">iQOO</option>
					<option value="5">Apple</option>
					<option value="6">小米</option>
					<option value="7">荣耀</option>
					<option value="8">三星</option>
					<option value="9">真我</option>
					<option value="10">魅族</option>
				</select>
				</div>
				<div id="xb"><span>商品名称：&nbsp;&nbsp;&nbsp;</span><input type="text" id="c_category" name="spm"/>
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
</body>
</html>