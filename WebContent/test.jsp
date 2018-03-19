<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
<!--导入jQuery  -->
<script type="text/javascript" src="/01-02-springmvc/js/j.js"></script>
<!--声明js代码域  -->
<script type="text/javascript">
	$(function(){
		$("#btn").click(function(){
			$.get("show7",{uname:"lisi",age:18},function(data){
				alert(data.uname);
			})
			
		})
		
	})	


</script>
</head>
<body>
	<form action="show5" method="get">
		名字：<input type="text" name="uname11" value="" /><br /><br />
		年龄：<input type="text" name="age" value="" /><br /><br />
		爱好： <input type="checkbox" name="fav" value="0" />LOL
		 	 <input type="checkbox" name="fav" value="1" />魔兽
		 	 <input type="checkbox" name="fav" value="2" />吃鸡
		<input type="submit" value="提交"/>
	</form>
	<a href="show6/zhangsan/12">测试restful传值</a> <input type="button" id="btn" value="测试ajax" />
</body>
</html>