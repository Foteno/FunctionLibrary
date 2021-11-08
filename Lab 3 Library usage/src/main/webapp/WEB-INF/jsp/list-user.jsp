<%@ page contentType="text/html;charset=UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<head>
    <title>View Users</title>
</head>
<body>
<table>
    <thead>
    <tr>
        <th>ID</th>
        <th>Name</th>
        <th>Surname</th>
        <th>PhoneNr</th>
        <th>Email</th>
        <th>Address</th>
        <th>Update</th>
        <th>Delete</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${users}" var="user">
        <tr>
            <td>${user.name}</td>
            <td>${user.surname}</td>
            <td>${user.phoneNr}</td>
            <td>${user.email}</td>
            <td>${user.address}</td>
            <td><a type="button" href="/update/${user.userId}">UPDATE</a></td>
            <td><a type="button" href="/delete/${user.userId}">DELETE</a></td>
        </tr>
    </c:forEach>
    </tbody>
</table>

<div>
    <a href="add-user">ADD USERS</a>
</div>
</body>
</html>