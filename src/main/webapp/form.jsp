
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>post list</title>
</head>
<body>
<form action="${pageContext.request.contextPath}/user/quick13" method="post">
<%--表明是第几个对象的属性值--%>
    <input type="text" name="userList[0].name" value="林纵"><br>
    <input type="text" name="userList[0].age" value="15"><br>
    <input type="text" name="userList[1].name" value="楚嫣然"><br>
    <input type="text" name="userList[1].age" value="16"><br>
    <input type="submit" value="send"><br>
</form>

</body>
</html>
