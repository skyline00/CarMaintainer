<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="core" %>
<html>
<head>
<title>Car Maintainer Login Page</title>
</head>
<body>
${message}
	<form:form commandName="user" action="welcome" method="POST">
		<form:input path="login" /><br/>
		<form:button>Sing in</form:button>
	</form:form>
	
</body>
</html>