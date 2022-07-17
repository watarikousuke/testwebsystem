<%@ page language="java" contentType="text/html; charset=UTF-8"
 pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html>

<html>
	<head>
	</head>
	<h1>連絡先登録完了画面</h1>
	<p>以下の内容で登録しました</p>
	名前：<c:out value="${itemBean.name}" /><br>
	電話番号：<c:out value="${itemBean.phone}" /><br>
	メールアドレス：<c:out value="${itemBean.email}" /><br>
	<body>
	</body>
</html>
