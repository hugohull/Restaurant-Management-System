<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>List of Restaurants</title>
</head>
<body>
<c:forEach items="${restaurants}" var="restaurant">
    <p>${restaurant.toString()}</p>
</c:forEach>
</body>
</html>