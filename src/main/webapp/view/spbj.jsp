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
	margin-left: 10px;
}
#zhong form #sj{
	padding-top: 180px;
	margin-left: 10px;
}
#zhong form #sj input{
	width: 165px;
}
#zhong form #zt{
	padding-top: 23px;
	margin-left: 10px;
}
#zhong form #zt input{
	width: 165px;
}
#zhong form #zt select{
	width: 168px;
}
#zhong form #zz{
	padding-top: 23px;
	margin-left: 42px;
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
    margin-top: 220px;
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
	<div id="sh">
			<span>编辑数据</span>
		</div>
		<div id="zhong">
		<script type="text/javascript">
		document.addEventListener("DOMContentLoaded", function() {
		    // 获取存储在 sessionStorage 中的数据
		    const id = sessionStorage.getItem('editId');
		    const c_dtime = sessionStorage.getItem('c_dtime');
		    const c_dstate = sessionStorage.getItem('c_dstate');
		    const c_describe = sessionStorage.getItem('c_describe');

		    // 设置对应的 input 和 textarea 的值
		    document.getElementById('editId').value = id;
		    document.getElementById('c_dtime').value = c_dtime;
		    document.getElementById('c_dstate').value = c_dstate;  // 修正为 value
		    document.getElementById('c_describe').value = c_describe; // 修正为 value

		    // 对于 select，根据存储的值设置选中项
		    const selectElement = document.getElementById('c_describe');
		    selectElement.value = c_describe; // 确保 c_describe 与 option 的 value 匹配
		});
			</script>
			<form action="XGShangpServlet" method="get">
				<input type="hidden" name="id"  id="editId"value="<%= session.getAttribute("editId") %>">
				<div id="sj"><span>上架时间：&nbsp;&nbsp;&nbsp;</span>
				<input type="date" class="rq" name="rq" id="c_dtime"/>
				</div>
				<div id="zt"><span>商品描述：&nbsp;&nbsp;&nbsp;</span>
					<textarea rows="4" cols="50" id="c_dstate" name="ms"></textarea>
				</div>
				<div id="zz">
					<span>状态：&nbsp;&nbsp;&nbsp;</span>
					<select class="zt" id="c_describe" name="zt">
						<option value="0">0(待上架)</option>
						<option value="1">1(已上架)</option>
						<option value="2">2(未上架)</option>
					</select>
				</div>
				<input type="submit" value="确定" id="qued"/>
			</form>
		</div>
		<div id="wei">
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