<%--
   Fichier chatlive/annoncerarrivee.jsp

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
<%@ page import='java.util.*' %>
<%@ include file='/WEB-INF/jspf/bean/utilisateurforum.jspf' %>
<%@ include file='/WEB-INF/jspf/bean/datelecturemessageschat.jspf' %>
<%@ include file='/WEB-INF/jspf/bean/participantschat.jspf' %>
<% synchronized (participantsChat)
   {
     participantsChat.add(utilisateurForum);
   } %>
<% dateLectureMessagesChat.setTime(new Date().getTime()); %>
<jsp:forward page='ajoutermessage.jsp'>
  <jsp:param name='texte' value='<%= "--- Arriv\u00e9e ---" %>'/>
</jsp:forward>
