<!DOCTYPE html>
<html xmlns:th="http://www.thymeleaf.org">
<head>
    <meta charset="utf-8" />
    <script type="text/javascript" src="/index.js" th:src="@{/index.js}"></script>
</head>
<body>
<strong><div th:text="${message}"></div></strong>
</body>
</html>