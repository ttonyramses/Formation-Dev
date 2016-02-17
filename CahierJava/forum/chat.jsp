<%--
   Fichier chat.jsp

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
<html><head><title>Chat</title></head>
<body><center><h1>Chat</h1>
<jsp:include page='/WEB-INF/jspf/navigation.jsp' /><br>
<applet code='com.eteks.forum.AppletChat' codebase='classes'
        width='90%' height='300'>
  <% String infoIdSession = ";jsessionid="
                          + request.getSession().getId(); %>
  <param name='annoncerArrivee'
         value='chat/annoncerarrivee.jsp<%= infoIdSession %>' >
  <param name='annoncerDepart'
         value='chat/annoncerdepart.jsp<%= infoIdSession %>' >
  <param name='ajouterMessage'
         value='chat/ajoutermessage.jsp<%= infoIdSession %>' >
  <param name='lireParticipants'
         value='chat/lireparticipants.jsp<%= infoIdSession %>'>
  <param name='lireMessages'
         value='chat/liremessages.jsp<%= infoIdSession %>' >
  <p>Pour utiliser le chat, vous devez installer et autoriser
     <a href='http://java.sun.com/getjava/'>Java</a></p>
</applet>
</center></body></html>
