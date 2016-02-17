<%--
   Fichier WEB-INF/jspf/navigation.jsp

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
<%@ include file='/WEB-INF/jspf/bean/utilisateurforum.jspf' %>
<table border='1' cellpadding='2' cellspacing='0' width='90%'>
  <tr bgcolor='#9999CC'>
    <td><a href='index.jsp'>Sujets</a></td>
      <% if (utilisateurForum.getAutorisation() == null)
         { %>
    <td align='right'>
           <a href='identifierutilisateur.jsp'>Identification</a>
           <a href='creerutilisateur.jsp'>Inscription</a>
    </td>
      <% }
         else
         { %>
    <td align='center'>
      <a href='creersujet.jsp'>Nouveau sujet</a>
      <a href='chatlive.jsp'>Chat</a>
    </td>
    <td align='right'>
      Bonjour <%= com.eteks.outils.OutilsChaine.convertirEnHTML(
                           utilisateurForum.getPseudonyme()) %>
      <a href='quitter.jsp'>Quitter</a>
    </td>
      <% } %>
  </tr>
</table>
<% if (request.getParameter("erreur") != null)
   { %>
 <p><font color='#FF0000'>Le serveur reporte cette erreur :
               <%= request.getParameter("erreur") %>.</font></p>
<% }
   if (request.getParameter("information") != null)
   { %>
 <p><font color='##33CC00'>
           <%= request.getParameter("information") %></font></p>
<% } %>

