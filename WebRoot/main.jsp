<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%

String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html>
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>成绩查询</title>
    
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

     <header>
     <div class="logo"><i class="fa fa-ul fa-cutlery"></i>学生成绩查询</div> 
     <div class="account">
         <c:choose>
		       <c:when test="${user.userid ==null}">
		         
		         <a href="login.jsp">登录</a>
		       </c:when>
		       <c:otherwise>
		        <c:out value="${user.userid}"></c:out>, 欢迎您!
		       </c:otherwise>
		    </c:choose>
       </div>
       <div class="logo"></div>
       </header>
        <main>
	  	    <s:form action="score/score_queryFoods" method="post">
	     <div class="form-inline search-box">
              <div class="form-group pull-right mr200">
                <input class="search-field form-control input-sm" title="关键词" name="keyWords" placeholder="输入关键词...">
                <button class="btn btn-info btn-sm" type="submit">搜  索</button>
              </div> 
            </div>	
	      <ul>
	         <s:if test="#session.user.name =='admin'">
	        <li>		        
		            <div class="add"><a href="add.jsp"><i class="fa fa-plus"></i> 添加成绩</a></div>
		              <p>点击上面的链接可以添加成绩</p>		        
	        </li>
	        <s:iterator value="scoretList" status="status">
	        <li>
	             <img src="<%=basePath%><s:property value='filepath'/>">
	                   <p>
	              <s:a href="score/score_showDetail?score.scoreid=%{scoreid}">查看</s:a>
	              <s:property value="user.name"></s:property>
	                 <s:property value="subject.subject"></s:property>
	                 <s:property value="score.score"></s:property>
	             </p>
	          </li>
	        </s:iterator>
	        </s:if>
	       <s:else>
	          <s:iterator value="scoreList" status="status">
	          <li>
	             <img src="<%=basePath%><s:property value='filepath'/>">
	             <p>
	              <s:a href="score/score_showDetail?score.scoreid=%{scoreid}">查看</s:a>
	                
	               <s:property value="user.name"></s:property>
	              <s:property value="subject.subject"></s:property>
	              <s:property value="score.score"></s:property>
	             </p>
	          </li>
	        </s:iterator>
	        </s:else>
	      
	      
	         </ul>
		    </s:form> 
 </main>
  </body>
</html>
