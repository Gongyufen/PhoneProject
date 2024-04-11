<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<style>
*{
	margin: 0;
	padding: 0;
}
ul{
	list-style: none;
}
#body{
	display: inline-block;
}
#bodybig{
	margin: 0 auto;
	margin-top: 80px;
	width: 80%;
	
}
a{
	color:#000;
}
#grzx{
	width: 80%;
	margin: 0 auto;
	padding: 30px;
	overflow: hidden;
}
#daoh{
	height: 100%;
	line-height: 34px;
	background-color: #fafafa;
	margin-right: 6px;
	padding: 10px;
	display: inline-block;
	vertical-align: top;
	border:2px #f1f1f1 solid;
}
#daoh #da{
	font-size: 16px;
}
.xiao{
	padding-left: 10px;
	font-size: 14px;
}
</style>
    <div id="daoh">
				<ul id="da">
					<li>个人信息
						<ul class="xiao">
							<li id="xgyhm">修改用户名</li>
							<li id="xgmm">修改密码</li>
							<li id="xgphone">修改手机号</li>
						</ul>
					</li>
					<li>我的订单</li>
					<li>我的评论</li>
					<li>我浏览过的商品</li>
					<li><a href="SelectDizServlet">收货地址管理</a> </li>
				</ul>
	</div>