<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>地址管理</title>
		<style>
#body{
	width: 78%;
	background: white;
	padding: 50px 50px;
	overflow: hidden;
}
#shdz{
	margin-bottom: 30px;
}
#name{
	margin-right: 130px;
}
#body input{
	width: 230px;
	margin-bottom: 30px;
	padding: 10px 20px;
	outline:none;
}
#xxdiz{
	width: 500px;
}
#sbox{
	display: inline-block;
}
#cbox{
	margin-left: 100px;
}
#qbox{
	margin-left: 100px;
}
.select{
	width: 302px;
	margin-bottom: 30px;
	padding: 10px 20px;
	border: 1px black solid;
}

select{
	border: none;
	outline:none;
	width: 200px;
	text-align: center;
}
#ls table{
	width: 100%;
	text-align: center;
}
#ls table th{
	background-color: #f1f1f1;
	padding: 10px 0;
	color: #b1b1b1;
}
p{
	font-size: 24px;
	height: 35px;
	text-align: center;
	margin-bottom: 20px;
}
			#daoh{
					margin-top: 130px;
				}
			.xiao{
				display: none;
			}
		</style>
		<script src="../jquery-3.5.1.min.js"></script>
		<script src="https://cdn.bootcss.com/jquery/3.2.1/jquery.js"></script>
		<script src="https://cdn.bootcss.com/distpicker/2.0.1/distpicker.js"></script>
		<script>
			$(function(){
				$("#ok").click(function(){
					var name=$("#name").val();
					var phone=$("#phone").val();
					var s=$("#s").val();
					var c=$("#c").val();
					var q=$("#q").val();
					var xxdz=$("#xxdiz").val();
					if(name==""){
						alert("请输入收货人姓名");
						return false;
					}
					if(s==""){
						alert("请选择省份");
						return false;
					}
					if(c==""){
						alert("请选择城市");
						return false;
					}
					if(q==""){
						alert("请选择区");
						return false;
					}
					if(xxdz==""){
						alert("请输入详细地址");
						return false;
					}
					if(phone.val().length!=11){
						alert("请输入11位的手机号");
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
		<div id="bodybig">
			<jsp:include page="dhl.jsp"></jsp:include>
			<div id="body">
				<p>收货地址管理</p>
				<div id="shdz" class="xinz" data-toggle="distpicker" data-autoselect="3">
					<form method="post" action="DizXinzServlet">
						收&nbsp;&nbsp;&nbsp;货&nbsp;&nbsp;&nbsp;人：&nbsp;<input name="name" placeholder="请输入收件人姓名" id="name"/>
						收货人电话：<input name="phone" placeholder="请输入收件人电话" id="phone"/><br />
						收&nbsp;货&nbsp;地&nbsp;址：
						<div class="select" id="sbox">
							省：<select id="s"  v-model="work.province" name="shen"></select>
						</div>
						<div class="select" id="cbox">
							市：<select id="c" v-model="work.city" name="shi"></select>
						</div>
						<div class="select" id="qbox">
							区：<select id="c" v-model="work.area" name="qu"></select>
						</div> 
						
						
						详&nbsp;细&nbsp;地&nbsp;址：&nbsp;<input name="xxdiz" id="xxdiz" placeholder="请输入详细地址"/><br/>
						<input type="submit" id="ok" value="添加该地址"/>
						
					</form>
				</div>
				<div id="shdz" class="xg" data-toggle="distpicker" data-autoselect="3" style="display: none">
					<form method="post" action="XgDizServlet">
					<input name="id" id="id" style="display: none;">
					
						收&nbsp;&nbsp;&nbsp;货&nbsp;&nbsp;&nbsp;人：&nbsp;<input style="margin-right: 130px" name="name" placeholder="请输入收件人姓名" id="xgname"/>
						收货人电话：<input name="phone" placeholder="请输入收件人电话" id="xgdh"/><br />
						收&nbsp;货&nbsp;地&nbsp;址：
						<div class="select" id="sbox">
							省：<select id="xgs"  v-model="work.province" name="shen"></select>
						</div>
						<div class="select" id="cbox">
							市：<select id="xgc" v-model="work.city" name="shi"></select>
						</div>
						<div class="select" id="qbox">
							区：<select id="xgq" v-model="work.area" name="qu"></select>
						</div> 
						
						详&nbsp;细&nbsp;地&nbsp;址：&nbsp;<input style="width: 500px" name="xxdiz" id="xgxxdiz" placeholder="请输入详细地址"/><br/>
						<input type="submit" id="ok" value="确认修改"/>
						
					</form>
				</div>
				<p>已添加的收货地址</p>
				<div id="ls">
					<table>
						<tr>
							<th>收货人</th>
							<th>收货电话</th>
							<th>收货地址</th>
							<th>操作</th>
						</tr>
						<c:forEach items="${dizlist }" var="d">
							<tr>
								<td>${d.getZ_consignee() }</td>
								<td>${d.getZ_phone() }</td>
								<td>${d.getZ_address() }</td>
								<td style="display: none">${d.getZ_aid()}</td>
								<td>
									<button class="xgan">修改</button>
									<button class="sc">删除</button>
								</td>
							</tr>
						</c:forEach>
					</table>
					<script type="text/javascript">
						$(function() {
							//修改收货地址
							$(".xgan").on("click",function(){
								var xgname=$(this).parent().parent().find("td").eq(0).text();
								$("#xgname").val(xgname);
								var xgphone=$(this).parent().parent().find("td").eq(1).text();
								$("#xgdh").val(xgphone);
								var diz=$(this).parent().parent().find("td").eq(2).text();
								var arr=diz.split("-");
								 $("#xgxxdiz").val(arr[3]);
								 var id=$(this).parent().parent().find("td").eq(3).text();
								 $("#id").val(id);
								$(".xinz").css("display","none");
								$(".xg").css("display","block");
							});
							//删除收货地址
							$(".sc").click(function() {
								if(confirm("确定要删除吗？")){
									var id=$(this).parent().parent().find("td").eq(3).text();
									
									window.location.href = "ShanchuDizServlet?id="+id;
								}else  {
									return false;
								}
							})
						})
					</script>
				</div>
			</div>
		</div>
		
		
		<jsp:include page="../di.jsp" ></jsp:include>
	</body>
</html>