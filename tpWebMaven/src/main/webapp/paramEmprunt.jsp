<%@page contentType="text/html; charset=UTF-8" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	</br>
	</br>
	</br>
	<h2>Formulaire Emprunt</h2>
	<%
		double mensualite = 0.0, montant = 0.0, taux = 0.0;
		int duree = 0;
		String sMontant = request.getParameter("montant");
		String sDuree = request.getParameter("duree");
		String sTaux = request.getParameter("taux");

		//System.out.println("sMontant="+sMontant+" sDuree="+sDuree+" sTaux="+sTaux);
		if (sMontant != null && !sMontant.equals("null") && sTaux != null && !sTaux.equals("null") && sDuree != null && !sDuree.equals("null")) {
			montant = Double.parseDouble(sMontant);
			taux = Double.parseDouble(sTaux) / 12 / 100;
			duree = Integer.parseInt(sDuree)*12;
			mensualite = montant * taux / (1 - Math.pow(1 + taux, -duree));
		}
	%>
	<%="sMontant="+sMontant+" sDuree="+sDuree+" sTaux="+sTaux%>
	
	<form method="get">
		<table>
			<tr>
				<td><label id="Montant_label">Montant:</label></td>
				<td><input name="montant" type="text" value="<%=sMontant%>" /></td>
			</tr>
			<tr>
				<td><label id="Duree_label">Duree: </label></td>
				<td><input name="duree" type="text" value="<%=sDuree%>" /></td>
			</tr>
			<tr>
				<td><label id="Taux_label">Taux:</label></td>
				<td><input name="taux" type="text" value="<%=sTaux%>" /></td>
			</tr>
			<tr>
				<td colspan="2"><input value="Calucler mensualité"
					type="submit" /></td>
			</tr>
		</table>
	</form>



	Mensualite=
	<b><%=mensualite %> €</b>
</body>
</html>
</body>
</html>