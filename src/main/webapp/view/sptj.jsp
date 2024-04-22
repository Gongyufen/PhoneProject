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
	padding-top: 75px;
	margin-left: 15px;
}
#zhong form #yh select{
	width: 165px;
}
#zhong form #xb{
	padding-top: 23px;
	margin-left: 46px;
}
#zhong form #xb select{
	width: 167px;
}
#zhong form #sj{
	padding-top: 23px;
	margin-left: 28px;
}
#zhong form #sj input{
	width: 165px;
}
#zhong form #zt{
	padding-top: 23px;
	margin-left: 28px;
}
#zhong form #zt input{
	width: 165px;
}
#zhong form #zt select{
	width: 168px;
}
#zhong form #zz{
	padding-top: 23px;
	margin-left: 59px;
}
#zhong form #zz select{
	width: 170px;
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
    margin-top: 276px;
}
#zhong input#qued:hover{
	background-color: dimgray;
}
</style>
</head>
<body>
	<div id="sh">
			<span>添加数据</span>
		</div>
		<div id="zhong">
			<form>
				<div id="yh"><span>商品型号id：&nbsp;&nbsp;&nbsp;&nbsp;</span><select id="productIdsSelect">
					 <option value="">请选择商品型号ID</option>
				</select></div>
				<script>
				var xhr = new XMLHttpRequest();
				xhr.open('GET', 'XingHaoid', true);
				xhr.onreadystatechange = function() {
				    if (xhr.readyState === XMLHttpRequest.DONE) {
				        if (xhr.status === 200) {
				            var productIds = JSON.parse(xhr.responseText);
				            var selectElement = document.getElementById('productIdsSelect');
				            selectElement.innerHTML = ''; // 清空下拉框
				            productIds.forEach(function(product) {
				                var option = document.createElement('option');
				                option.value = product.c_mid; // 使用具体的商品型号ID值
				                option.text = product.c_mid; // 设置选项显示的文本
				                selectElement.appendChild(option);
				            });
				        }
				    }
				};
				xhr.send();
</script>
				<div id="xb"><span>类别id：&nbsp;&nbsp;&nbsp;</span>
					<select>
						<option>1</option>
						<option>1</option>
						<option>1</option>
						<option>1</option>
						<option>1</option>
					</select>
				</div>
				<div id="sj"><span>上架时间：&nbsp;&nbsp;&nbsp;</span>
				<input type="date"/>
				</div>
				<div id="zt"><span>商品描述：&nbsp;&nbsp;&nbsp;</span>
					<input type="textarea" rows="4" cols="50"/>
				</div>
				<div id="zz">
					<span>状态：&nbsp;&nbsp;&nbsp;</span>
					<select>
						<option>0(待上架)</option>
						<option>1(已上架)</option>
						<option>2(未上架)</option>
					</select>
				</div>
				<input type="submit" value="确定" id="qued"/>
			</form>
		</div>
		<div id="wei">
			<button id="gb" onclick="closeWindow()">关闭</button>
			<script type="text/javascript">
		function closeWindow() {
		    window.history.back();
		    window.close();
		}
		</script>
		</div>
</body>
</html>