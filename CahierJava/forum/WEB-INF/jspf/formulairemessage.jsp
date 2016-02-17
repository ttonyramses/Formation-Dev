<%--
   Fichier WEB-INF/jspf/formulairemessage.jsp

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
<jsp:useBean id='message' class='com.eteks.forum.MessageForum'
             scope='request'/>
<%-- Formulaire de saisie du message --%>
<form action='<%= request.getParameter("actionFormulaire") %>'
      method='post'>
  <table border='1' cellpadding='2' cellspacing='0' width='90%'>
    <tr>
      <td bgcolor='#9999CC'><b>Sujet</b></td>
      <td><input name='sujet' type='text' size='50'
              maxlength='255'
              value='<%= message.getSujet() != null
                           ? message.getSujet() : "" %>'></td>
    </tr>
    <tr>
      <td valign='top' bgcolor='#9999CC'><b>Message</b></td>
      <td><textarea name='texte' cols='50' rows='5'
          ><%= message.getTexte() != null
                 ? message.getTexte() : "" %></textarea></td>
    </tr>
  </table>
<br><input type='submit'
           value='<%= request.getParameter("labelSubmit") %>'>
</form>
