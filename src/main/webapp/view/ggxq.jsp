<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
#zhong form #xb{
	padding-top: 23px;
	margin-left: 31px;
}
#zhong form #xb select{
	width: 167px;
}
#zhong form #sj{
	padding-top: 23px;
	margin-left: 15px;
}
#zhong form #zt{
	padding-top: 23px;
	margin-left: 31px;
}
#zhong form #zt input{
	width: 168px;
}
#wei{
	width: 100%;
	height: 105px;
	background: #e1e1e1;
}
#wei button{
	width: 60px;
	border-radius: 5px;
	margin-top: 15px;
	height: 30px;
	background: #a1a1a1;
	border: none;
}
#wei #gb{
	float: right;
	margin-top:49px;
	margin-right: 35px;
}
#wei #gb:hover{
	background-color: dimgray;
}
#zhong input#qued {
   right: 110px;
    margin-right: 3px;
    width: 60px;
    height: 30px;
    border-radius: 5px;
    background: #a1a1a1;
    border: none;
    float: right;
    position: absolute;
    margin-top: 319px;
}
#zhong input#qued:hover{
	background-color: dimgray;
}
</style>
</head>
<body>
	<div id="sh" class="ss">
			<span>添加数据</span>
		</div>
		<div id="zhong">
		<script>
		document.addEventListener("DOMContentLoaded", function() {
		    var inputElement = document.querySelector('input[name="xq"]');
		    var initialValue = localStorage.getItem('customValuePage2');
		    var currentValue = initialValue ? parseInt(initialValue) : 79;
		    inputElement.value = currentValue;
		    currentValue++;
		    localStorage.setItem('customValuePage2', currentValue);
		});
</script>
			<form action="CRGgxqServlet" method="get">
				<div id="yh"><span>&nbsp;&nbsp;&nbsp;规格详情id：&nbsp;&nbsp;</span><input type="text" name="xq"/></div>
				<div id="xb"><span>商品规格id：</span>
				<select name="gg">
					 <c:forEach var="i" begin="1" end="100">
                    <c:choose>
                        <c:when test="${i == dd}">
                            <option value="${i}" selected>${i}</option>
                        </c:when>
                        <c:otherwise>
                            <option value="${i}">${i}</option>
                        </c:otherwise>
                    </c:choose>
                </c:forEach>
				</select>
				</div>
				<div id="sj"><span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;规格详情：&nbsp;</span>
				<input type="text" name="ggxq"/>
				</div>
				<div id="zt"><span>&nbsp;&nbsp;图片路径：&nbsp;</span>
					<input type="file" name="lj">
				</div>
				<input type="submit" value="确定" id="qued">
			</form>
		</div>
		<div id="wei" class="ss">
			<button id="gb">关闭</button>
		</div>
</body>
</html>