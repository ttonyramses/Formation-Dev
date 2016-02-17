<%--
   Fichier liresujet.jsp

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
<%@ include file='/WEB-INF/jspf/bean/utilisateurforum.jspf' %>
<% String sujet = request.getParameter("sujet"); %>
<html><head><title>Forum : <%= OutilsChaine.convertirEnHTML(
     OutilsChaine.limiterLongueur(sujet, 50)) %></title></head>
<body><center><h1>Forum</h1>
<jsp:include page='/WEB-INF/jspf/navigation.jsp' /><br>
<table border='1' cellpadding='2' cellspacing='0' width='90%'>
  <tr bgcolor='#9999CC'>
    <td align='center'><b>Messages du sujet
      <i><%= OutilsChaine.convertirEnHTML(sujet) %></i></b></td>
  </tr>
  <%-- Affichage des messages du sujet ligne par ligne --%>
  <% EnsembleMessagesForum messages= new EnsembleMessagesForum();
     messages.rechercherMessagesSujet(connecteurForum, sujet);
     DateFormat formatDate  = DateFormat.getDateInstance();
     DateFormat formatHeure = DateFormat.getTimeInstance();
     int ligne = 0;
     for (MessageForum message : messages)
     { %>
  <tr bgcolor='<%= ligne++ % 2 == 0 ? "#FFFFFF" : "#CCCCCC" %>'>
    <td>De <b><%= OutilsChaine.convertirEnHTML(
                                   message.getAuteur()) %></b>
        le <b><%= formatDate.format(
                              message.getDateCreation()) %></b>
        &agrave; <b><%= formatHeure.format(
                              message.getDateCreation()) %></b>
    <blockquote><%= OutilsChaine.convertirEnHTML(
                       message.getTexte()) %></blockquote>
    <% if (utilisateurForum.getAutorisation() != null)
      { %>
      <a href='<%= "creermessage.jsp?sujet="
                   + URLEncoder.encode(sujet, "ISO-8859-1") %>'
       >R&eacute;pondre</a>
      <% if (   utilisateurForum.isModerateur()
             || message.estEcritPar(utilisateurForum))
         { %>
        <a href='<%= "modifiermessage.jsp?id="
                     + message.getId() %>'>Modifier</a>
      <% } %>
    <% } %></td>
  </tr>
  <% } %>
</table>
</center></body></html>
