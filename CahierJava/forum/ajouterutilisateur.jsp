<%--
   Fichier ajouterutilisateur.jsp

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
<%@ page import='com.eteks.forum.*,com.eteks.outils.*'
         errorPage='erreur.jsp' %>
<%@ include file='/WEB-INF/jspf/bean/connecteurforum.jspf' %>
<jsp:useBean id='utilisateur'
       class='com.eteks.forum.UtilisateurForum' >
  <jsp:setProperty name='utilisateur' property='*'/>
</jsp:useBean>
<%-- Verification si le pseudonyme d'un utilisateur est correct --%>
<% if (utilisateur.getPseudonyme() == null)
   { %>
  <jsp:forward page='creerutilisateur.jsp'>
    <jsp:param name='erreur'
               value='Vous devez choisir un pseudonyme' />
  </jsp:forward>
<% } %>
<%-- Verification si le pseudonyme d'un utilisateur n'existe pas deja --%>
<% if (utilisateur.rechercher(connecteurForum))
   { %>
  <jsp:forward page='creerutilisateur.jsp'>
    <jsp:param name='erreur' value='<%= "Pseudonyme <i>"
           + utilisateur.getPseudonyme()
           + "</i> d&eacute;j&agrave; utilis&eacute;.<br>"
           + "Choisissez-en un autre" %>' />
  </jsp:forward>
<% } %>
<%-- Ajout de l'utilisateur --%>
<% utilisateur.setAutorisation(Autorisation.UTILISATEUR);
   utilisateur.setMotDePasse(MotDePasse.creer());
   utilisateur.ajouter(connecteurForum); %>
<%-- Renvoi a la page d'accueil --%>
<jsp:forward page='index.jsp'>
  <jsp:param name='information' value='<%= "Vous pouvez vous"
         + " identifier maintenant avec le pseudonyme "
         + utilisateur.getPseudonyme() + " et le mot de passe "
         + utilisateur.getMotDePasse() %>' />
</jsp:forward>
