<%@ page language="java" contentType="text/html; charset=windows-31j"
         pageEncoding="windows-31j"%>
<%-- 演習5.2. 手順2にて以下の2行を削除 --%>
<%-- 演習5.2. 手順3にて以下の1行を削除 --%>
<%-- 演習5.2. 手順4にてタグライブラリの宣言を追加 --%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=windows-31j">
  <title>演習5</title>
  <link rel="stylesheet" href="exercise.css" type="text/css">
</head>
<body>
  <h1>ROBOT-YA.com</h1>
  <h2>カートの内容</h2>
  <table>
    <tr>
      <th>商品コード</th>
      <th>商品名</th>
      <th>価格</th>
      <th>個数</th>
      <th>小計</th>
    </tr>

<%-- 演習5.2. 手順5にて以下を変更 --%>
<c:set var="sum" value="0" />
<c:forEach var="data" items="${sessionScope.cart}">

    <tr class="product">
      <td><%-- 演習5.2. 手順6にて変更 --%>${ data.value.id}</td>
      <td><%-- 演習5.2. 手順6にて変更 --%>${ data.value.name}</td>
      <td><%-- 演習5.2. 手順9にて変更 --%><fmt:formatNumber
          value="${data.value.price}" type="currency"
          currencySymbol="\\" minFractionDigits="0" />
</td>
      <td><%-- 演習5.2. 手順6にて変更 --%>${ data.value.number}</td>
      <td><%-- 演習5.2. 手順7にて追加 --%>
      <c:set var="intermediate"
         value="${data.value.price * data.value.number}" />

          <%-- 演習5.2. 手順9にて変更 --%><fmt:formatNumber
          value="${intermediate}" type="currency"
          currencySymbol="\\" minFractionDigits="0" />
</td>
    </tr>

<%-- 演習5.2. 手順8にて以下を変更 --%>
  <c:set var="sum" value="${sum+intermediate}" />
</c:forEach>


    <tr>
      <td colspan="3">　</td>
      <td>合計</td>
      <td><%-- 演習5.2. 手順9にて変更 --%><fmt:formatNumber
          value="${sum}" type="currency"
          currencySymbol="\\" minFractionDigits="0" />
</td>
    </tr>
  </table>
  <form action="SearchServlet" method="post">
    <input type="submit" name="submit" value="買い物を続ける">
  </form>
  <form action="ClearServlet" method="POST">
    <input type="submit" name="submit" value="カートのクリア">
  </form>
</body>
</html>