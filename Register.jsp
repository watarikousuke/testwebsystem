<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>

<html>
<head>
</head>
<h1>連絡先登録画面</h1>
<!-- エラー表示 -->
<c:if test="${not empty errorList}">
	<p class="red">※以下のエラーがありました。お手数ですが、もう一度入力をお願いします。</p>
	<ul>
		<c:forEach var="errorMessage" items="${errorList}" varStatus="status">
			<li class="red">${errorMessage}</li>
		</c:forEach>
	</ul>
	<hr>
</c:if>
<form action="RegisterConfirm" method="post">
	<p>必要事項を入力して、送信してください。</p>

	名前：<input type="text" name="name"><br> 電話番号：<input
		type="text" name="phone"><br> メールアドレス：<input type="text"
		name="email"><br> <input type="submit" value="送信">
</form>
<p>
	<a href="List">登録済連絡先</a>
</p>
<body>
</body>
</html>
