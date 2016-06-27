<%@ page language="java" contentType="text/html; charset=windows-31j"
	pageEncoding="windows-31j"%>
<%@ page import="to.Product"%>
<%-- ���K5.1. �菇2�ɂĒǉ� --%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<%-- ���K5.1. �菇3�ɂĈȉ�2�s���폜 --%>
<jsp:useBean id="searchlist" class="java.util.ArrayList" scope="request" />
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=windows-31j">
<title>���K5</title>
<link rel="stylesheet" href="exercise.css" type="text/css">
</head>
<body>
	<h1>ROBOT-YA.com</h1>
	<form action="SearchServlet" method="post">
		<select name="category">

			<c:choose>
				<c:when test="${sessionScope.category == '���ׂ�'}">
					<OPTION selected>���ׂ�</OPTION>
				</c:when>
				<c:otherwise>
					<OPTION>���ׂ�</OPTION>
				</c:otherwise>
			</c:choose>
			<c:choose>
				<c:when test="${sessionScope.category == '�l�^'}">
					<OPTION selected>�l�^</OPTION>
				</c:when>
				<c:otherwise>
					<OPTION>�l�^</OPTION>
				</c:otherwise>
			</c:choose>
			<c:choose>
				<c:when test="${sessionScope.category == '�����^'}">
					<OPTION selected>�����^</OPTION>
				</c:when>
				<c:otherwise>
					<OPTION>�����^</OPTION>
				</c:otherwise>
			</c:choose>
		</select>
		<%-- ���K5.1. �菇5�ɂĕύX --%>
		<INPUT type="text" name="searchkey" size="20"
			value="${sessionScope.searchkey}"> <input type="submit"
			value="����">
	</form>
	<br>

	<%
		int count = 0;
		if (searchlist != null) {
			count = searchlist.size();
		}
	%>

	�������ʁF<%=count%>��
	<table width="98%" border="0">
		<tr>
			<th width="30%">���i�R�[�h</th>
			<th width="30%">���i��</th>
			<th width="30%">���i</th>
			<th rowspan="2">���i�w��</th>
		</tr>
		<tr>
			<th colspan="3">���i�̐���</th>
		</tr>

		<%-- ���K5.1. �菇6�ɂĕύX --%>
		<c:forEach var="data" items="${requestScope.searchlist}">

			<tr class="product">
				<td width="30%">
					<%-- ���K5.1. �菇7�ɂĕύX --%>${ data.id}</td>
				<td width="30%">
					<%-- ���K5.1. �菇7�ɂĕύX --%>${ data.name}</td>
				<td width="30%">
					<%-- ���K5.1. �菇8�ɂĕύX --%>
					<fmt:formatNumber value="${data.price}" type="currency"
						currencySymbol="\\" minFractionDigits=" 0" />
				</td>
				<td rowspan="2" align="center" valign="middle">
					<form action="CartServlet" method="post">
						<input type="hidden" name="product_id"
							value="<%-- ���K5.1. �菇7�ɂĕύX --%>${ data.id}"> <input
							type="submit" name="submit" value="�w��">
					</form>
				</td>
			</tr>
			<tr>
				<td colspan="3"><span class="description">
						<%-- ���K5.1. �菇7�ɂĕύX --%>${ data.description}</span></td>
			</tr>

			<%-- ���K5.1. �菇6�ɂĕύX --%>

		</c:forEach>

	</table>
</body>
</html>