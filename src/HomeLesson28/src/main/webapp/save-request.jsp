<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Ввод данных</title>
</head>
<body>
<form action="/save-request" method="post">
    <label for="name">Имя:</label>
    <input type="text" id="name" name="name">
    <br>
    <label for="age">Возраст:</label>
    <input type="number" id="age" name="age">
    <br>
    <button type="submit">Отправить</button>
</form>
</body>
</html>
