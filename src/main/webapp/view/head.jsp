<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <link type="text/css" rel="stylesheet" href="../css/head.css"/>
<div id="head">
			<div id="headone">
				<div id="head-left">
					<ul id="head-left-ul" >
						<li><a href="shouye">首页</a></li>
						<li>|</li>
						<li><a href="">消费者业务网站</a></li>
						<li>|</li>
						<li><a href="">V码（优购码）</a></li>
						<li>|</li>
						<li><a href="">企业商用</a></li>
						<li>|</li>
						<li><a href="">更多精彩</a></li>
					</ul>
				</div>
				<div id="head-right">
					<ul id="head-right-ul">
						<li><a href="">请登录或注册</a></li>
						<li>|</li>
						<li><a href="">我的订单</a></li>
						<li>|</li>
						<li><a href="">客服</a></li>
						<li>|</li>
						<li><a href="">网站导航</a></li>
						<li>|</li>
						<li><a href="">手机版</a></li>
						<li>|</li>
						<li><a href="">购物车</a></li>
					</ul>
				</div>
			</div>
		</div>
		
		<div id="dhl">
			<div id="daohanglan">
				<div class="center">
					<div class="tubiao"><img src="../img/图标.png" /></div>
					<div class="wenzione">华为</div>
					<div class="wenzi">鸿蒙智联</div>
					<div class="wenzi">华为智选</div>
					<div class="wenzi">生态周边</div>
					<div class="kuang">
						<img src="../img/搜索.png" />
						<input type="text" placeholder="搜索商品" id="wenbenkuang"/>
					</div>
				</div>
			</div>
		</div>
		
		<script>
			// 导航栏滚动事件
			
			// 获取目标div的引用
			const daohanglanshijian = document.getElementById('daohanglan');
					
			// 监听页面滚动事件
			function scrollFunction() {
			    var scrollPosition = window.scrollY;
			    if (scrollPosition > 50) { // 当滚动位置超过50px时触发事件
			        daohanglanshijian.style.top = "0px";
			    } else if (scrollPosition < 50) { // 当滚动位置超过50px时触发事件
			        daohanglanshijian.style.top = "38px";
			    }
			}
			// 添加滚动事件监听器
			window.addEventListener('scroll', scrollFunction);
			// 导航栏滚动事件2
			
			// 回车键搜索
			document.getElementById("wenbenkuang").addEventListener("keypress", function(event) {
			    if (event.key === "Enter") {
			    	var where=document.getElementById("wenbenkuang").value;
			    	 event.preventDefault();
				        if(where==""){
				        	alert("搜索框不能为空,请重新输入！")
				        }else{
				        	window.location.href = "sousuo?value="+where;

				        }
			       
			    }
			});
			// 回车键搜索2
		</script>
		