<%@ page import="br.com.fiap.fintech.Entities.Investimento" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Investimentos</title>
</head>
<body>
<h2>List of Investments</h2>
<%
    List<Investimento> investimentos = (List<Investimento>) request.getAttribute("investimentos");
    if (investimentos != null && !investimentos.isEmpty()) {
%>
<table border="1">
    <tr>
        <th>ID</th>
        <th>Tipo Investimento</th>
        <th>Valor</th>
        <th>Data de Início</th>
        <th>Data de Resgate</th>
        <th>Usuário ID</th>
    </tr>
    <% for (Investimento investimento : investimentos) { %>
    <tr>
        <td><%= investimento.getId() %></td>
        <td><%= investimento.getTipoInvestimento() %></td>
        <td><%= investimento.getValor() %></td>
        <td><%= investimento.getDataInicio() %></td>
        <td><%= investimento.getDataResgate() %></td>
        <td><%= investimento.getUsuarioId() %></td>
    </tr>
    <% } %>
</table>
<%
} else {
%>
<p>No investments found.</p>
<%
    }
%>
</body>
</html>
