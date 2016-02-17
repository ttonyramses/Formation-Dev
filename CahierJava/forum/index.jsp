<%--
   Fichier index.jsp

   Les Cahiers du Programmeur Java - Copyright (C) 2003-2012 Emmanuel PUYBARET / eTeks <info@eteks.com>

   This library is free software; you can redistribute it and/or
   modify it under the terms of the GNU Lesser General Public
   License as published by the Free Software Foundation; either
   version 2.1 of the License, or (at your option) any later version.

   This library is distributed in the hope that it will be useful,
   but WITHOUT ANY WARRANTY; without even the implied warranty of
   MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
   Lesser General Public License for more details.

   You should have received a copy of the GNU Lesser General Public
   License along with this library; if not, write to the Free Software
   Foundation, Inc., 59 Temple Place, Suite 330, Boston, MA  02111-1307  USA
--%>
<%@ page import='java.util.*,java.net.*,java.text.*,
  com.eteks.forum.*,com.eteks.outils.*' errorPage='erreur.jsp' %>
<%@ include file='/WEB-INF/jspf/bean/connecteurforum.jspf' %>
<html><head><title>Forum : Accueil</title></head>
<body><center><h1>Forum</h1>
<jsp:include page='/WEB-INF/jspf/navigation.jsp' /><br>
<table border='1' cellpadding='2' cellspacing='0' width='90%'>
  <tr bgcolor='#9999CC' align='center'>
    <td><b>Sujet</b></td>
    <td><b>Dernier message</b></td>
  </tr>
  <% EnsembleMessagesForum sujets = new EnsembleMessagesForum();
     sujets.rechercherSujets(connecteurForum);
     DateFormat dateFormat = DateFormat.getInstance();
     int ligne = 0;
     for (MessageForum sujet : sujets)
     { %>
  <tr bgcolor='<%= ligne++ % 2 == 0 ? "#FFFFFF"
                                    : "#CCCCCC" %>'>
    <%-- Affichage des sujets renvoyes ligne par ligne --%>
    <td><a href='<%= "liresujet.jsp?sujet="
         + URLEncoder.encode(sujet.getSujet(), "ISO-8859-1") %>'
        ><%= OutilsChaine.convertirEnHTML(
                                 sujet.getSujet()) %></a></td>
    <td align='center'><%= dateFormat.format(
                              sujet.getDateCreation()) %></td>
  </tr>
  <% } %>
</table>
</center></body></html>
