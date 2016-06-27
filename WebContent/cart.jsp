<%@ page language="java" contentType="text/html; charset=windows-31j"
         pageEncoding="windows-31j"%>
<%-- ���K5.2. �菇2�ɂĈȉ���2�s���폜 --%>
<%-- ���K5.2. �菇3�ɂĈȉ���1�s���폜 --%>
<%-- ���K5.2. �菇4�ɂă^�O���C�u�����̐錾��ǉ� --%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=windows-31j">
  <title>���K5</title>
  <link rel="stylesheet" href="exercise.css" type="text/css">
</head>
<body>
  <h1>ROBOT-YA.com</h1>
  <h2>�J�[�g�̓��e</h2>
  <table>
    <tr>
      <th>���i�R�[�h</th>
      <th>���i��</th>
      <th>���i</th>
      <th>��</th>
      <th>���v</th>
    </tr>

<%-- ���K5.2. �菇5�ɂĈȉ���ύX --%>
<c:set var="sum" value="0" />
<c:forEach var="data" items="${sessionScope.cart}">

    <tr class="product">
      <td><%-- ���K5.2. �菇6�ɂĕύX --%>${ data.value.id}</td>
      <td><%-- ���K5.2. �菇6�ɂĕύX --%>${ data.value.name}</td>
      <td><%-- ���K5.2. �菇9�ɂĕύX --%><fmt:formatNumber
          value="${data.value.price}" type="currency"
          currencySymbol="\\" minFractionDigits="0" />
</td>
      <td><%-- ���K5.2. �菇6�ɂĕύX --%>${ data.value.number}</td>
      <td><%-- ���K5.2. �菇7�ɂĒǉ� --%>
      <c:set var="intermediate"
         value="${data.value.price * data.value.number}" />

          <%-- ���K5.2. �菇9�ɂĕύX --%><fmt:formatNumber
          value="${intermediate}" type="currency"
          currencySymbol="\\" minFractionDigits="0" />
</td>
    </tr>

<%-- ���K5.2. �菇8�ɂĈȉ���ύX --%>
  <c:set var="sum" value="${sum+intermediate}" />
</c:forEach>


    <tr>
      <td colspan="3">�@</td>
      <td>���v</td>
      <td><%-- ���K5.2. �菇9�ɂĕύX --%><fmt:formatNumber
          value="${sum}" type="currency"
          currencySymbol="\\" minFractionDigits="0" />
</td>
    </tr>
  </table>
  <form action="SearchServlet" method="post">
    <input type="submit" name="submit" value="�������𑱂���">
  </form>
  <form action="ClearServlet" method="POST">
    <input type="submit" name="submit" value="�J�[�g�̃N���A">
  </form>
</body>
</html>