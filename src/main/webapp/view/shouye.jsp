<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
		<div id="head">
			<div id="head-left">
				<ul id="head-left-ul" >
					<li id="img"></li>
					<li><a href="">首页</a></li>
					<li><a href="">猜你喜欢</a></li>
				</ul>
			</div>
			<div id="head-right">
				<ul id="head-right-ul">
					<li><a href="">请登录</a>（没有账号？请<a href="">注册</a>）</li>
					<li><a href="">我的订单</a></li>
					<li><a href="../购物车/gouwuche.html">我的购物车</a></li>
				</ul>
			</div>
		</div>
		
		<div id="daohanglan">
			<input type="text" placeholder="搜索商品" id="wenbenkuang"/>
		</div>
		<div id="lunbotu">
			<!-- 轮播图1 -->
			<div class="lbt">
			    <div class="tupian">
			        <img src="../1.jpg" alt="Image 1">
			    </div>
			    <div class="tupian">
			        <img src="../2.jpg" alt="Image 2">
			    </div>
			    <div class="tupian">
			        <img src="../3.jpg" alt="Image 3">
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
			
			<div id="fenlei">
				<div id="leione" onmouseover="showBox2()" onmouseout="hideBox2()">
					<div id="shuju">数据<div style="float: right;">></div></div>
					<div id="shuju">数据<div style="float: right;">></div></div>
					<div id="shuju">数据<div style="float: right;">></div></div>
					<div id="shuju">数据<div style="float: right;">></div></div>
					<div id="shuju">数据<div style="float: right;">></div></div>
					<div id="shuju">数据<div style="float: right;">></div></div>
					<div id="shuju">数据<div style="float: right;">></div></div>
					<div id="shuju">数据<div style="float: right;">></div></div>
					<div id="shuju">数据<div style="float: right;">></div></div>
					<div id="shuju">数据<div style="float: right;">></div></div>
				</div>
				<div id="leitwo" onmouseover="showBox2()" onmouseout="hideBox2()">
					<div id="shuju"><img src="/img/图标.png"/>数据</div>
					<div id="shuju"><img src="/img/图标.png"/>数据</div>
					<div id="shuju"><img src="/img/图标.png"/>数据</div>
					<div id="shuju"><img src="/img/图标.png"/>数据</div>
					<div id="shuju"><img src="/img/图标.png"/>数据</div>
					<div id="shuju"><img src="/img/图标.png"/>数据</div>
					<div id="shuju"><img src="/img/图标.png"/>数据</div>
					<div id="shuju"><img src="/img/图标.png"/>数据</div>
					<div id="shuju"><img src="/img/图标.png"/>数据</div>
				</div>
				<!-- 鼠标悬浮显示div1 -->
				<script>
					function showBox2() {
					    document.getElementById("leitwo").style.display = "block";
					}
					
					function hideBox2() {
					    document.getElementById("leitwo").style.display = "none";
					}
				
				</script>
				<!-- 鼠标悬浮显示div2 -->
			</div>
			
			
		</div>
		<!-- 锚链接1 -->
			<a href="#one" class="tiaozhuan"><button id="maolianjie" class="maolianjie"><img src="../收缩上箭头.png" />返回顶部</button></a>
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
			<p id="biaoti">手机名称</p>
				<div id="shangpin">
					<div class="img"><img style="width: 100%; height: 100%;" src="../手机.webp"/></div>
					<div class="zi">
						nove12<br/>
						<span class="js">1111111111111</span><br/>
						<span class="jg">￥1111</span>
					</div>
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
			<p id="biaoti">手机名称</p>
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
			<p id="biaoti">手机名称</p>
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
			<p id="biaoti">手机名称</p>
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
			<p id="biaoti">手机名称</p>
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
			<p id="biaoti">手机名称</p>
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
			<p id="biaoti">手机名称</p>
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
		
		<div id="di">
					<div id="di1">
						<ul>
							<li>购物指南</li>
							<li>享0分期利息</li>
							<li>以旧换新</li>
							<li>众测活动</li>
							<li>企业购</li>
							<li>O2O采购</li>
							<li>教育购</li>
						</ul>
						<ul>
							<li>售后服务</li>
							<li>门店维修</li>
							<li>保修政策</li>
							<li>防伪查询</li>
							<li>退换货政策</li>
							<li>手机寄修服务</li>
						</ul>
						<ul>
							<li>服务支持</li>
							<li>服务店查询</li>
							<li>维修备件价格</li>
							<li>维修服务</li>
							<li>上门安装</li>
							<li>问题排查</li>
						</ul>
						<ul>
							<li>特色服务</li>
							<li>防伪查询</li>
							<li>补购保障</li>
							<li>以旧换新</li>
						</ul>
						<ul>
							<li>关于我们</li>
							<li>公司介绍</li>
							<li>华为零售店</li>
							<li>商家中心</li>
							<li>意见反馈</li>
							<li>规则中心</li>
						</ul>
						<ul>
							<li>友情链接</li>
							<li>华为集团</li>
							<li>华为消费者业务</li>
							<li>华为云</li>
							<li>华为应用市场</li>
							<li>华为心声社区</li>
						</ul>
					</div>
					<div id="di2">
						<ul>
							<li>华为集团</li>
							<li>消费者业务网站</li>
							<li>HarmonyOS</li>
							<li>华为应用市场</li>
							<li>华为终端云空间</li>
							<li>开发者联盟</li>
							<li>华为商城手机版</li>
						</ul>
						<br/>
						隐私声明 服务协议 COOKIES Copyright © 2012-2024 华为终端有限公司 版权所有 | 经营资质 | 粤ICP备19015064号|粤公网安备 44190002003939号
						增值电信业务经营许可证：粤B2-20190762|备案主体编号：44201919072182|粤新出网备（2021）2号|（粤）网械平台备字[2022]第00005号
						互联网药品信息服务资格证（粤）-非经营性-2020-0102  | 广东省网络食品交易第三方平台备案：GDWS10168
					</div>
				</div>
</body>
</html>