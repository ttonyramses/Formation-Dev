<%@page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page import="java.util.Map" %>
<%@page import="java.util.HashMap" %>

<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">
<title>Afficher le panier</title>

</head>
<style type="text/css">
table, td, th {
border-style:solid; border-width: thin;
}
</style>
<body>

	</br>
	<h2>Afficher le panier</h2>


<%
Map<String, Integer> panier=(Map<String, Integer>)session.getAttribute("caddy");

if(panier!=null && panier.size()>0){
%>
<table >
<tr>
<th>Produit</th>
<th>Quantite</th>
</tr>
<%
for(String produit:panier.keySet()){
	%>
<tr>
<td ><%=produit %></td>
<td ><%=panier.get(produit) %></td>
</tr>
<%	
}
}
%>
</table>

<br/>
<c:if test="${sessionScope.caddy}!=null">
<table>
<c:forEach items="${sessionScope.caddy}" var="article">
	<tr>
	<td><c:out value="${article.key}" /></td>
	<td><c:out value="${article.value}" /></td>
	</tr>
	</c:forEach>
</table>
</c:if>
<a href="index.html"> retour à la page d'accueil</a> <br/>
</body>
</html>
