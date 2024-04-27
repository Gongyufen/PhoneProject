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
	padding-top: 210px;
	margin-left: 15px;
}
#zhong form #xb{
	padding-top: 45px;
	margin-left: 31px;
}
#zhong form #xb select{
	width: 167px;
}
#zhong form #sj{
	padding-top: 23px;
	margin-left: 0px;
}
#zhong form #zt{
	padding-top: 23px;
	margin-left: 0px;
}
#zhong form #zt input{
	width: 165px;
}
#zhong form #zt select{
	width: 168px;
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
    margin-top: 254px;
}
#zhong input#qued:hover{
	background-color: dimgray;
}
#zhong form #yh select{
	width: 160px;
	height: 20px;
}
</style>
</head>
<body>
	<div id="sh" class="ss">
			<span>添加数据</span>
		</div>
		<div id="zhong">
			<form action="CRGuiGeServlet" method="get">
			<script>
			document.addEventListener("DOMContentLoaded", function() {
			    var inputElement = document.querySelector('input[name="dd"]');
			    var initialValue = localStorage.getItem('customValuePage1');
			    var currentValue = initialValue ? parseInt(initialValue) : 39;
			    inputElement.value = currentValue;
			    currentValue++;
			    localStorage.setItem('customValuePage1', currentValue);
			});
</script>
				<input type="hidden" name="dd">
				<div id="yh"><span>规格名称：&nbsp;&nbsp;&nbsp;</span>
					<select name="mc">
						<option value="颜色">颜色</option>
						<option value="版本">版本</option>
					</select>
				</div>
					<div id="xb"><span>商品id：&nbsp;&nbsp;&nbsp;</span>
					<select name="bh">
						  <c:forEach var="i" begin="1" end="100">
                    <c:choose>
                        <c:when test="${i == xinh}">
                            <option value="${i}" selected>${i}</option>
                        </c:when>
                        <c:otherwise>
                            <option value="${i}">${i}</option>
                        </c:otherwise>
                    </c:choose>
                </c:forEach>
					</select>
				</div>
				<input type="submit" value="确定" id="qued"/>
			</form>
		</div>
		<div id="wei" class="ss">
			<button id="gb">关闭</button>
		</div>
</body>
</html>