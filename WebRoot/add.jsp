<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html>
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>直接跳转到显示所有成绩的页面</title>
    <meta charset="utf-8">
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link rel="stylesheet" type="text/css" href="<%=basePath%>css/font-awesome.css">	
	<link rel="stylesheet" type="text/css" href="<%=basePath%>css/main.css">
	<link rel="shortcut icon"   href="<%=basePath%>images/logo.png">
	<link rel="stylesheet" href="<%=basePath%>css/bootstrap.css">
  </head>
  
  <body>

    <s:form action="score/score_addScore" method="post">
     <p>姓名： <s:textfield name="score.user.name" label="姓名"></s:textfield></p>
     <p>学号： <s:textfield name="score.user.userid" label="学号"></s:textfield></p>
     <p>科目： <s:textfield name="score.subject.subject" label="科目"></s:textfield></p>
     <p>分数： <s:textfield name="score.score" label="分数"></s:textfield></p>
      <s:submit value="提交"></s:submit>
    </s:form>
    <br>
  </body>
</html>
