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
	<h1>Hi ${username} <br> Welcome to the chat!</h1>
	<br>
	<form name="chatWindow" action="chatWindow">
		Message: 
		<input name="textMessage" type="text" value=""/>
		<input name="commandSend" type="submit" value="Send"/>
		<br><br>
		<a href = "chatWindow">Refresh the room</a>
		<br><br>
		Messages in Chat Box:
		<br><br>
		<textarea name="message" readonly="readonly" rows="20" cols="60"></textarea> 
		<hr> 
	</form>
	</center>
</body>
</html>