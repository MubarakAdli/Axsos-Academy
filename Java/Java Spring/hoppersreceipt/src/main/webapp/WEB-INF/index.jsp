
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
</head>
<body>
    <h1>Customer Name:<c:out value="${name}"/></h1>
    <h2>Item name:<c:out value="${itemName}"/></h2>
    <h2>Price:<c:out value="${price}"/></h2>
    <h2>Description:<c:out value="${description}"/></h2>
    <h2>Vendor:<c:out value="${vendor}"/></h2>
    
</body>
</html>