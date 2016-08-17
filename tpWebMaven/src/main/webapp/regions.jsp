<%@page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page import="java.util.Map" %>
<%@page import="java.util.HashMap" %>
<%@page import="java.util.List" %>
<%@page import="fr.afcepf.al28.dao.GeoDao" %>

<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">
<title>Regions</title>

</head>
<style type="text/css">
table, td, th {
border-style:solid; border-width: thin;
}
</style>
<body>

	</br>
	<h2>Regions de France</h2>


<% List<String> regions=new GeoDao().rechercheRegions();

/* for(String toto:regions){
	System.out.println(toto);
} */
//request.setAttribute("regions", regions);

%>
<c:set var="regions" value="<%=regions %>"  scope="page"/>
<c:if test="${! empty regions}">
<table>
<c:forEach items="${regions}" var="region">
	<tr>
	<td><c:out value="${region}" /></td>
<%-- 	<td><c:out value="${article.value}" /></td>
 --%>	</tr>
	</c:forEach>
</table>
</c:if>
<a href="index.html"> retour à la page d'accueil</a> <br/>
</body>
</html>
