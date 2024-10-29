<%@ page import="br.com.fiap.fintech.Entities.TipoInvestimento" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Insert Investimento</title>
</head>
<body>
<form action="insertInvestimento" method="post">
  <label for="tipoInvestimento">Tipo Investimento:</label>
<%--  <select id="tipoInvestimento" name="tipoInvestimento" required>--%>
<%--    <option value="STOCK">Stocks</option>--%>
<%--    <option value="BONDS">Bonds</option>--%>
<%--  </select>--%>
  <select id="tipoInvestimento" name="tipoInvestimento" required>
    <%
      for (TipoInvestimento tipo : TipoInvestimento.values()) {
    %>
    <option value="<%= tipo.name() %>"><%= tipo.getDescription() %></option>
    <%
      }
    %>
  </select>
  <br><br>

  <label for="valor">Valor:</label>
  <input type="number" id="valor" name="valor" step="0.01" required>
  <br><br>

  <label for="dataInicio">Data de Início:</label>
  <input type="date" id="dataInicio" name="dataInicio" required>
  <br><br>

  <label for="dataResgate">Data de Resgate:</label>
  <input type="date" id="dataResgate" name="dataResgate" required>
  <br><br>
  <input type="hidden" name="usuarioId" value="1">

  <!-- No need for a user ID input field as this would be handled by the session or login context -->
  <input type="submit" value="Insert Investimento">
</form>
</body>
</html>
