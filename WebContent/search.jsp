<%@ page language="java" contentType="text/html; charset=windows-31j"
	pageEncoding="windows-31j"%>
<%@ page import="to.Product"%>
<%-- 演習5.1. 手順2にて追加 --%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<%-- 演習5.1. 手順3にて以下2行を削除 --%>
<jsp:useBean id="searchlist" class="java.util.ArrayList" scope="request" />
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=windows-31j">
<title>演習5</title>
<link rel="stylesheet" href="exercise.css" type="text/css">
</head>
<body>
	<h1>ROBOT-YA.com</h1>
	<form action="SearchServlet" method="post">
		<select name="category">

			<c:choose>
				<c:when test="${sessionScope.category == 'すべて'}">
					<OPTION selected>すべて</OPTION>
				</c:when>
				<c:otherwise>
					<OPTION>すべて</OPTION>
				</c:otherwise>
			</c:choose>
			<c:choose>
				<c:when test="${sessionScope.category == '人型'}">
					<OPTION selected>人型</OPTION>
				</c:when>
				<c:otherwise>
					<OPTION>人型</OPTION>
				</c:otherwise>
			</c:choose>
			<c:choose>
				<c:when test="${sessionScope.category == '動物型'}">
					<OPTION selected>動物型</OPTION>
				</c:when>
				<c:otherwise>
					<OPTION>動物型</OPTION>
				</c:otherwise>
			</c:choose>
		</select>
		<%-- 演習5.1. 手順5にて変更 --%>
		<INPUT type="text" name="searchkey" size="20"
			value="${sessionScope.searchkey}"> <input type="submit"
			value="検索">
	</form>
	<br>

	<%
		int count = 0;
		if (searchlist != null) {
			count = searchlist.size();
		}
	%>

	検索結果：<%=count%>件
	<table width="98%" border="0">
		<tr>
			<th width="30%">商品コード</th>
			<th width="30%">商品名</th>
			<th width="30%">価格</th>
			<th rowspan="2">商品購入</th>
		</tr>
		<tr>
			<th colspan="3">商品の説明</th>
		</tr>

		<%-- 演習5.1. 手順6にて変更 --%>
		<c:forEach var="data" items="${requestScope.searchlist}">

			<tr class="product">
				<td width="30%">
					<%-- 演習5.1. 手順7にて変更 --%>${ data.id}</td>
				<td width="30%">
					<%-- 演習5.1. 手順7にて変更 --%>${ data.name}</td>
				<td width="30%">
					<%-- 演習5.1. 手順8にて変更 --%>
					<fmt:formatNumber value="${data.price}" type="currency"
						currencySymbol="\\" minFractionDigits=" 0" />
				</td>
				<td rowspan="2" align="center" valign="middle">
					<form action="CartServlet" method="post">
						<input type="hidden" name="product_id"
							value="<%-- 演習5.1. 手順7にて変更 --%>${ data.id}"> <input
							type="submit" name="submit" value="購入">
					</form>
				</td>
			</tr>
			<tr>
				<td colspan="3"><span class="description">
						<%-- 演習5.1. 手順7にて変更 --%>${ data.description}</span></td>
			</tr>

			<%-- 演習5.1. 手順6にて変更 --%>

		</c:forEach>

	</table>
</body>
</html>