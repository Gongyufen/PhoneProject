<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>首页</title>
<link type="text/css" rel="stylesheet" href="../css/shouye.css"/>
<link type="text/css" rel="stylesheet" href="../css/head.css"/>
<link type="text/css" rel="stylesheet" href="../css/di.css"/>
</head>
<body>
	<section id="one"></section>
		<jsp:include page="head.jsp" >
			<jsp:param  name="name" value="${list.get(0).getZ_uname()}"/>
		</jsp:include>
		
		
		<div id="lunbotu">
			<!-- 轮播图1 -->
			<div class="lbt">
			    <div class="tupian">
			        <img src="../img/1.webp" alt="Image 1">
			    </div>
			    <div class="tupian">
			        <img src="../img/2.webp" alt="Image 2">
			    </div>
			    <div class="tupian">
			        <img src="../img/3.webp" alt="Image 3">
			    </div>
			
			    <div class="yuandian">
			        <span class="yd"></span>
			        <span class="yd"></span>
			        <span class="yd"></span>
			    </div>
			</div>
			
			<script>
			    let tupianIndex = 0;
			    let shijian;
			
			    showtupians();
			
			    function showtupians() {
			        let i;
			        const tupians = document.getElementsByClassName("tupian");
			        const yuandian = document.getElementsByClassName("yd");
			        for (i = 0; i < tupians.length; i++) {
			            tupians[i].style.display = "none";
			        }
			        tupianIndex++;
			        if (tupianIndex > tupians.length) { tupianIndex = 1; }
			        for (i = 0; i < yuandian.length; i++) {
			            yuandian[i].className = yuandian[i].className.replace(" active", "");
			        }
			        tupians[tupianIndex - 1].style.display = "block";
			        yuandian[tupianIndex - 1].className += " active";
			
			        shijian = setTimeout(showtupians, 3000); // 切换时间间隔为 2 秒
			    }
			
			    const yuandian = document.getElementsByClassName("yd");
			    for (let i = 0; i < yuandian.length; i++) {
			        yuandian[i].onclick = function () {
			            tupianIndex = i;
			            clearTimeout(shijian); // 清除之前的定时器
			            showtupians();
			        };
			    }
			</script>
			<!-- 轮播图2 -->
			<script type="text/javascript" src="../jquery-3.5.1.min.js"></script>
			
			<div id="fenlei">
			<script>
				$(function(){
					var shuju=$(".a");
					shuju.each(function(index) { // 为当前元素添加点击事件处理程序 
						$(this).mouseenter( function() { 
								var name=".model"+index;
								$(name).css("display","block");
								$(name).mouseenter( function() { 
									$(this).css("display","block");
								});
								$(name).mouseleave( function() { 
									$(this).css("display","none");
								});
							});
						$(this).mouseleave( function() { 
								var name=".model"+index;
								$(name).css("display","none");
							});
					})
				})
			</script>
				<div id="leione">
					<c:forEach items="${cclass}" var="p">
						<div id="shuju" class="a">${p.category }<div style="float: right;">></div>
							
						</div>
					</c:forEach>
				</div>
				
				<div id="leitwo" class="model0" >
					<c:forEach items="${model0}" var="m">
						<div id="shuju"><img src="/img/图标.png"/>${m.mname }</div>
					</c:forEach>
				</div>
				<div id="leitwo" class="model1" >
					<c:forEach items="${model1}" var="m">
						<div id="shuju"><img src="/img/图标.png"/>${m.mname }</div>
					</c:forEach>
				</div>
				<div id="leitwo" class="model2">
					<c:forEach items="${model2}" var="m">
						<div id="shuju"><img src="/img/图标.png"/>${m.mname }</div>
					</c:forEach>
				</div>
				<div id="leitwo" class="model3">
					<c:forEach items="${model3}" var="m">
						<div id="shuju"><img src="/img/图标.png"/>${m.mname }</div>
					</c:forEach>
				</div>
				<div id="leitwo" class="model4" >
					<c:forEach items="${model4}" var="m">
						<div id="shuju"><img src="/img/图标.png"/>${m.mname }</div>
					</c:forEach>
				</div>
				<div id="leitwo" class="model5" >
					<c:forEach items="${model5}" var="m">
						<div id="shuju"><img src="/img/图标.png"/>${m.mname }</div>
					</c:forEach>
				</div>
				<div id="leitwo" class="model6" >
					<c:forEach items="${model6}" var="m">
						<div id="shuju"><img src="/img/图标.png"/>${m.mname }</div>
					</c:forEach>
				</div>
				<div id="leitwo" class="model7" >
					<c:forEach items="${model7}" var="m">
						<div id="shuju"><img src="/img/图标.png"/>${m.mname }</div>
					</c:forEach>
				</div>
				<div id="leitwo" class="model8" >
					<c:forEach items="${model8}" var="m">
						<div id="shuju"><img src="/img/图标.png"/>${m.mname }</div>
					</c:forEach>
				</div>
				<div id="leitwo" class="model9" >
					<c:forEach items="${model9}" var="m">
						<div id="shuju"><img src="/img/图标.png"/>${m.mname }</div>
					</c:forEach>
				</div>
				
			</div>
			
			
		</div>
		<!-- 锚链接1 -->
			<a href="#one" class="tiaozhuan"><button id="maolianjie" class="maolianjie"><img src="../img/收缩上箭头.png" />返回顶部</button></a>
		<script>
		    document.querySelectorAll('.tiaozhuan').forEach(anchor => {
		        anchor.addEventListener('click', function(e) {
		            e.preventDefault();
		
		            const targetId = this.getAttribute('href');
		            const targetPosition = document.querySelector(targetId).offsetTop;
		
		            window.scrollTo({
		                top: targetPosition,
		                behavior: 'smooth'
		            });
		        });
		    });
			
			// 获取目标div的引用
			const targetDiv = document.getElementById('maolianjie');
			
			// 监听页面滚动事件
			window.onscroll = function() {
						        var scrollPosition = window.scrollY;
						        if (scrollPosition > 500) { // 当滚动位置超过500px时触发事件
						           targetDiv.style.display="block";
						        }else if (scrollPosition < 500) { // 当滚动位置超过500px时触发事件
						           targetDiv.style.display="none";
						        }
						    };
		</script>
		<!-- 锚链接2 -->
		
		<div id="box">
			<p id="biaoti">最新上架</p>
				<div id="shangpin">
					
				</div>
				<div id="shangpin">
					
				</div>
				<div id="shangpin">
					
				</div>
				<div id="shangpin">
					
				</div>
				<div id="shangpin">
					
				</div>
		</div>
		
		<div id="remai">
			<p id="biaoti">热卖商品</p>
				<div id="shangpin">
					
				</div>
				<div id="shangpin">
					
				</div>
				<div id="shangpin">
					
				</div>
				<div id="shangpin">
					
				</div>
				<div id="shangpin">
					
				</div>
		</div>
		
		
		<div id="hezi">
			<p id="biaoti">OPPO</p>
				
					
					<c:forEach items="${product}" var="p">
						<div id="shangpin">
							<div class="img"><img style="width: 100%; height: 100%;" src="../img/1.1千山绿.png"/></div>
								<div class="zi">
								${p.c_mname }<br/>
								<span class="js">${p.c_describe }</span><br/>
								<span class="jg">￥${p.c_rsprice }</span>
							</div>
						</div>
					</c:forEach>
		</div>
		
		<div id="hezi">
			<p id="biaoti">HUAWEI</p>
				<div id="shangpin">
					
				</div>
				<div id="shangpin">
					
				</div>
				<div id="shangpin">
					
				</div>
				<div id="shangpin">
					
				</div>
				<div id="shangpin">
					
				</div>
		</div>
		
		<div id="hezi">
			<p id="biaoti">vivo</p>
				<div id="shangpin">
					
				</div>
				<div id="shangpin">
					
				</div>
				<div id="shangpin">
					
				</div>
				<div id="shangpin">
					
				</div>
				<div id="shangpin">
					
				</div>
		</div>
		
		<div id="hezi">
			<p id="biaoti">iQOO</p>
				<div id="shangpin">
					
				</div>
				<div id="shangpin">
					
				</div>
				<div id="shangpin">
					
				</div>
				<div id="shangpin">
					
				</div>
				<div id="shangpin">
					
				</div>
		</div>
		
		<div id="hezi">
			<p id="biaoti">Apple</p>
				<div id="shangpin">
					
				</div>
				<div id="shangpin">
					
				</div>
				<div id="shangpin">
					
				</div>
				<div id="shangpin">
					
				</div>
				<div id="shangpin">
					
				</div>
		</div>
		
		<div id="hezi">
			<p id="biaoti">小米</p>
				<div id="shangpin">
					
				</div>
				<div id="shangpin">
					
				</div>
				<div id="shangpin">
					
				</div>
				<div id="shangpin">
					
				</div>
				<div id="shangpin">
					
				</div>
		</div>
		
		<div id="hezi">
			<p id="biaoti">荣耀</p>
				<div id="shangpin">
					
				</div>
				<div id="shangpin">
					
				</div>
				<div id="shangpin">
					
				</div>
				<div id="shangpin">
					
				</div>
				<div id="shangpin">
					
				</div>
		</div>
		
		<div id="hezi">
			<p id="biaoti">三星</p>
				<div id="shangpin">
					
				</div>
				<div id="shangpin">
					
				</div>
				<div id="shangpin">
					
				</div>
				<div id="shangpin">
					
				</div>
				<div id="shangpin">
					
				</div>
		</div>
		
		<div id="hezi">
			<p id="biaoti">真我</p>
				<div id="shangpin">
					
				</div>
				<div id="shangpin">
					
				</div>
				<div id="shangpin">
					
				</div>
				<div id="shangpin">
					
				</div>
				<div id="shangpin">
					
				</div>
		</div>
		
		<div id="hezi">
			<p id="biaoti">魅族</p>
				<div id="shangpin">
					
				</div>
				<div id="shangpin">
					
				</div>
				<div id="shangpin">
					
				</div>
				<div id="shangpin">
					
				</div>
				<div id="shangpin">
					
				</div>
		</div>
		<jsp:include page="di.jsp" ></jsp:include>
		
</body>
</html>