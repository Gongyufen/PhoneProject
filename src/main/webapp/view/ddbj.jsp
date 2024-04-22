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
	margin-left: 29px;
}
#zhong form #yh input{
	width: 165px;
}
#zhong form #xb{
	padding-top: 23px;
	margin-left: 31px;
}
#zhong form #xb select{
	width: 167px;
}
#zhong form #sj{
	padding-top: 23px;
	margin-left: 47px;
}
#zhong form #zt{
	padding-top: 23px;
	margin-left: 62px;
}
#zhong form #zt select{
	width: 168px;
}
#zhong form #ph{
	padding-top: 23px;
	margin-left: 46px;
}
#wei{
	width: 100%;
	height: 105px;
	background: #e1e1e1;
}
#wei button{
	width: 60px;
    margin-left: -10px;
    float: right;
    border-radius: 5px;
    margin-top: 49px;
    height: 30px;
    background: #a1a1a1;
    border: none;
}
#wei #gb{
	float: right;
	margin-right: 15px;
}
#wei #gb:hover{
	background-color: dimgray;
}
#zhong input#qued {
   	right: 110px;
    margin-right: -18px;
    width: 60px;
    height: 30px;
    border-radius: 5px;
    background: #a1a1a1;
    border: none;
    float: right;
    position: absolute;
    margin-top: 277px;
}
#zhong input#qued:hover{
	background-color: dimgray;
}
</style>
</head>
<body>
	<div id="sh" class="ss">
			<span>编辑数据</span>
		</div>
		<script type="text/javascript">
			document.addEventListener("DOMContentLoaded", function() {
		    // 从sessionStorage获取ID
		    const editId = sessionStorage.getItem('editId');
		    // 设置隐藏字段的值
		    document.querySelector('input[name="id"]').value = editId;
		});
		</script>
		<div id="zhong">
			<form action="XGDDServlet" method="get">
			<input type="hidden" name="id" value="<%= session.getAttribute("editId") %>">
				<div id="yh"><span>下单日期：&nbsp;&nbsp;&nbsp;&nbsp;</span><input type="datetime-local" name="rq" id="c_date"/></div>
				<div id="xb"><span>订单状态：&nbsp;&nbsp;&nbsp;</span>
				<select id="c_status" name="zt">
					<option value="待付款">待付款</option>
					<option value="已付款">已付款</option>
					<option value="完成交易">完成交易</option>
				</select>
				</div>
				<div id="sj"><span>收货人：&nbsp;&nbsp;&nbsp;</span>
				<input type="text" id="c_consignee" name="shr"/>
				</div>
				<div id="zt"><span>地址：&nbsp;&nbsp;&nbsp;</span>
					<input type="text" id="c_address" name="dz"/>
				</div>
				<div id="ph">
					<span>手机号：&nbsp;&nbsp;&nbsp;</span>
						<input type="text" id="c_phone" name="sj"/>
				</div>
				<input type="submit" value="确定" id="qued"/>
			</form>
		</div>
		<script>
	document.addEventListener("DOMContentLoaded", function() {
    const id = sessionStorage.getItem('editId');
    const date = sessionStorage.getItem('editDate');
    const status = sessionStorage.getItem('editStatus');
    const consignee = sessionStorage.getItem('editConsignee');
    const address = sessionStorage.getItem('editAddress');
    const phone = sessionStorage.getItem('editPhone');
    document.getElementById('c_date').value = date;
    document.getElementById('c_status').value = status;
    document.getElementById('c_consignee').value = consignee;
    document.getElementById('c_address').value = address;
    document.getElementById('c_phone').value = phone;
});
</script>
		<div id="wei" class="ss">
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