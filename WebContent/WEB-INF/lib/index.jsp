<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Chat Engine</title>
</head>
<body bgcolor ="#0099B8">
	<center>
	<h1>Welcome to the Chat Engine!</h1>
	<br><br>
	
	<br><br>
	<h2>LOGIN</h2>
	<form name="userLogin" action="userLogin" method="POST">
		<table border="0" width="30" cellpadding="20">
			<tbody>
				<tr>
					<td> Enter an username </td>
					<td><input name="username" type="text" value=""/> </td>
				</tr>
			</tbody>
		</table>
		<input name="login" type="submit" value="Join the chat room!"/>
	</form>
	</center>
</body>
</html>