<%--
   Fichier verifierutilisateur.jsp

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
<%@ page errorPage='erreur.jsp' %>
<%@ include file='/WEB-INF/jspf/bean/connecteurforum.jspf' %>
<%@ include file='/WEB-INF/jspf/bean/utilisateurforum.jspf' %>
<%-- Authentification de l'utilisateur --%>
<jsp:setProperty name='utilisateurForum'
                 property='pseudonyme' param='pseudonyme' />
<% if (   utilisateurForum.rechercher(connecteurForum)
       && utilisateurForum.getMotDePasse().equals(
                            request.getParameter("motDePasse")))
   { %>
     <jsp:forward page='index.jsp' />
<% }
   // Annulation de l'utilisateur s'il n'existe pas ou si le mot de passe est incorrect
   utilisateurForum.setAutorisation(null); %>
<jsp:forward page='identifierutilisateur.jsp'>
  <jsp:param name='erreur' value='Identification incorrecte' />
</jsp:forward>
