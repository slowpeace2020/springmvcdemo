<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script src="${pageContext.request.contextPath}/js/jquery-3.3.1.js"></script>
<script>
    var userList = new Array();
    userList.push({name:"杜隐",age:24})
    userList.push({name:"审遇",age:40})
    userList.push({name:"周德威",age:30})
    $.ajax({
      type:"POST",
      url:"${pageContext.request.contextPath}/user/quick14",
      data:JSON.stringify(userList),
      contentType:"application/json;charset=utf-8",
    });
</script>
</head>
<body>
<h1>why can't find js file?</h1>
</body>
</html>
