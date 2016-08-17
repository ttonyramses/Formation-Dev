<%@page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">
<title>paramEmpruntMcv</title>
</head>
<jsp:include page="header.jsp"></jsp:include>
<body>
	</br>
	</br>
	</br>
	<h2>Formulaire Emprunt</h2>
	
	<font color="red">
	<c:forEach items="${objCalcul.msg}" var="item">
	<c:out value="${item}" /><br/>
	</c:forEach>
	</font><!-- eventuel message d'erreur -->
	
	<form method="get" action="MyMvcServlet">
	<input type="hidden" name="task" value="calculMensualite"/>
		<table>
			<tr>
				<td><label id="Montant_label">Montant:</label></td>
				<td><input name="montant" type="text" value="${objCalcul.montant}" /></td>
			</tr>
			<tr>
				<td><label id="Duree_label">Duree: </label></td>
				<td><input name="duree" type="text" value="${objCalcul.duree}" /></td>
			</tr>
			<tr>
				<td><label id="Taux_label">Taux:</label></td>
				<td><input name="taux" type="text" value="${objCalcul.tauxAnnuel}" /></td>
			</tr>
			<tr>
				<td colspan="2"><input value="Calucler mensualité"
					type="submit" /></td>
			</tr>
			
		</table>
	</form>



	Mensualite=
	<b><fmt:formatNumber value="${mensualite}" pattern=".00"/> euro</b> <br/>
</body>
</html>
</body>
</html>