<%--
   Fichier creermessage.jsp

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
<%@ page import='com.eteks.outils.*' errorPage='erreur.jsp' %>
<jsp:useBean id='message' class='com.eteks.forum.MessageForum'
             scope='request'>
 <jsp:setProperty name='message' property='sujet' param='sujet'/>
</jsp:useBean>
<html><head><title>Forum : <%= OutilsChaine.convertirEnHTML(
      OutilsChaine.limiterLongueur(message.getSujet(), 50)) %>
</title></head><body><center><h1>Nouveau message</h1>
<jsp:include page='/WEB-INF/jspf/navigation.jsp' /><br>
<%-- Formulaire de saisie du message --%>
<jsp:include page='/WEB-INF/jspf/formulairemessage.jsp' >
  <jsp:param name='actionFormulaire' value='ajoutermessage.jsp'/>
  <jsp:param name='labelSubmit' value='Ajouter le message' />
</jsp:include>
</center></body></html>
