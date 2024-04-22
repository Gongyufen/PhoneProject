<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>商品详情</title>
<link type="text/css" rel="stylesheet" href="../css/xiangqing.css" />
<link type="text/css" rel="stylesheet" href="../css/head.css" />
</head>
<body>
	<jsp:include page="head.jsp">
		<jsp:param name="name" value="${list.get(0).getZ_uname()}" />
	</jsp:include>
	
	<div id="xiangqing">
			<div id="tupianhezi">
				<div id="tupian">
					<img src="../img/手机.webp" />
				</div>
				<div id="tupiancolor">
					<button class="zuojiantou"><img src="../img/商品详情箭头.png" /></button>
					<div class="tupianwenjian">
						<ul>
							<li><img src="../img/手机.webp" /></li>
							<li><img src="../img/手机.webp" /></li>
							<li><img src="../img/手机.webp" /></li>
							<li><img src="../img/手机.webp" /></li>
							<li><img src="../img/手机.webp" /></li>
						</ul>
					</div>
					<button class="youjiantou"><img src="../img/商品详情箭头.png" /></button>
				</div>
				
			</div>
			<div id="neirong">
				<div id="mingcheng">
					<p class="mc">${product.get(0).getC_mname() }</p>
					<p class="ms">${product.get(0).getC_describe() }</p>
					<p style="color: #d42342;font-size: 30px;">￥<span class="jg">${product.get(0).getC_rsprice() }</span> <span id="jgid" style="display: none"> ${product.get(0).getC_rid()}</span> </p>
				</div>
				<div class="yanse">
				<c:forEach items="${guige.get(0)}" var="ys" varStatus="yans">
					<c:if test="${yans.index==0 }">
						<p>${ys.getC_aname() }</p>
					</c:if>
					
					<div class="xuanzhe" id="ysxuanz" ><span class="ysid" style="display: none">${ys.getC_gid() }</span>${ys.getC_gtails() }</div>
				</c:forEach>
					
				</div>
				<script type="text/javascript" src="../jquery-3.5.1.min.js"></script>
				<script type="text/javascript">
					$(function() {
						$(".xuanzhe").click(function() {
							$(".xuanzhe").attr("id","no");
							$(this).attr("id","ysxuanz");
						})
					})
				</script>
				<script>
					var shijian = document.querySelectorAll('.xuanzhe');
					shijian.forEach(function(div) {
			            div.addEventListener('click', function() {
			            	shijian.forEach(function(otherDiv) {
			                    if (otherDiv !== div) {
			                        otherDiv.classList.remove('selected');
			                        otherDiv.classList.add('xuanzhe');
			                    }
			                });
			                div.classList.remove('xuanzhe');
			                div.classList.add('selected');
			            });
			        });
					
				</script>
				
				<div id="banben">
				<span class="did" style="display: none">${guige.get(1).get(1).getC_did()}</span>
					<c:forEach items="${guige.get(1)}" var="ys" varStatus="yans">
						<c:if test="${yans.index==0 }">
							<p>${ys.getC_aname() }</p>
						</c:if>
						
						<div class="xuanxiang" class='btn'><span class="ncid" style="display: none">${ys.getC_gid() }</span>${ys.getC_gtails() }</div>
					</c:forEach>
				</div>
				<script type="text/javascript">
					$(function() {
						$(".xuanxiang").click(function() {
							$(".xuanxiang").attr("id","no");
							$(this).attr("id","xuanznc");
							var ysid=$("#ysxuanz").find(".ysid").text();
							
							var ncid=$("#xuanznc").find(".ncid").text();
							$.getJSON("JubushuaxinjiageServlet?ysid="+ysid+"&ncid="+ncid,{},function(v){
								$(".jg").text(v[0].c_rsprice);
								$("#jgid").text(v[0].c_rid);
							})
						})
					})
				</script>
				<script>
					var dianji = document.querySelectorAll('.xuanxiang');
					dianji.forEach(function(div) {
			            div.addEventListener('click', function() {
			            	dianji.forEach(function(otherDiv) {
			                    if (otherDiv !== div) {
			                        otherDiv.classList.remove('selected');
			                        otherDiv.classList.add('xuanxiang');
			                    }
			                });
			                div.classList.remove('xuanxiang');
			                div.classList.add('selected');
			            });
			        });
					
				</script>
				
				<div id="goumai">
					<div class="gmone">
						<button class="one" id="jinyong" onclick="jian()">-</button>
						<div class="two" id="zhi">1</div>
						<button class="three" id="jinyong2" onclick="jia()">+</button>
						<!-- 加减功能 -->
						<script>
						        let count = 1;
						        const jiage = document.getElementById('jg');
								
						        function jia() {
						        	if (count<10) {
										count++;
										if (count==10) {
											jinyong2.style.color="#a6a6a6";
										}
							            document.getElementById("zhi").innerHTML = count;
										jinyong.style.color="black";
										
									}
						            
						        }
						
						        function jian() {
						            if (count>1) {
						            	count--;
						            	if (count==1) {
											jinyong.style.color="#a6a6a6";
										}
										document.getElementById("zhi").innerHTML = count;
										jinyong2.style.color="black";
									}
						        }
    					</script>
    					<!-- 加减功能2 -->
    					
					</div>
						<button class="gmtwo">加入购物车</button>
						<span class="xhid" style="display: none"><%=request.getParameter("mid") %></span>
						
						<script type="text/javascript" src="../jquery-3.5.1.min.js"></script>
						<script>
							$(function() {
								$(".gmtwo").click(function() {
									var xhid=$(".xhid").text();
									var jgid=$("#jgid").text();
									var did=$(".did").text();
									var ysid=$("#ysxuanz").find(".ysid").text();
									var ncid=$("#xuanznc").find(".ncid").text();
									window.location.href="GouwucheServlet?mid="+xhid+"&rid="+jgid+"&ysid="+ysid+"&ncid="+ncid+"&did="+did;
								})
							})
						</script>
					
					<button class="gmthree">立即购买</button>
				</div>
			</div>
		</div>
		
		
    
		<br />
		<br />
		<hr />
		
		<div id="pinglun">
			<div id="yonghu">
				<div id="touxiang">
					
				</div>
				<div id="neirong">
					
				</div>
			</div>
			<div id="yonghu">
				<div id="touxiang">
					
				</div>
				<div id="neirong">
					
				</div>
			</div>
			<div id="yonghu">
				<div id="touxiang">
					
				</div>
				<div id="neirong">
					
				</div>
			</div>
			<div id="yonghu">
				<div id="touxiang">
					
				</div>
				<div id="neirong">
					
				</div>
			</div>
			<div id="yonghu">
				<div id="touxiang">
					
				</div>
				<div id="neirong">
					
				</div>
			</div>
		</div>
		
		<div id="fenye">
			<div id="neirong">
				
			</div>
		</div>
</body>
</html>