<%@page contentType="text/html; charset=UTF-8"%>
<%@page import="java.util.Map" %>
<%@page import="java.util.HashMap" %>

<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">
<title>Ajouter dans le caddy</title>
</head>
<body>

	</br>
	<h2>Ajouter les produits dans le caddy</h2>


	<form method="get" action="">
		<label for="product">produit: </label> <input id="product"
			name="product" type="text" /> <label for="quantity">quantité:</label>

		<select name="quantity">
			<option value="1">1</option>
			<option value="2">2</option>
			<option value="3">3</option>
			<option value="4">4</option>
			<option value="5">5</option>
		</select>
		

<input type="submit" value="ajouter au panier" id="addInCaddySubmit"/>

	</form>
<%
String msg="";
String produit="";
produit=request.getParameter("product");
String sQte=request.getParameter("quantity");
Integer quantite=null;
if(sQte!=null && sQte.length()>0){
	quantite=Integer.parseInt(sQte);
}

Map<String, Integer> panier=(HashMap<String, Integer>)session.getAttribute("caddy");
if(produit!=null && produit.trim().length()>0){
	if(panier==null || panier.size()==0){
		panier=new HashMap<String,Integer>(0);
	}
	panier.put(produit, quantite);
	session.setAttribute("caddy", panier);
	msg="Vous venez d'ajouter "+quantite+" elements du produit "+produit;
}

%>
<br/>
<%=msg %><br/>
<a href="index.html"> retour à la page d'accueil</a> <br/>

</body>
</html>
