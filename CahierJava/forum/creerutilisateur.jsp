<%--
   Fichier creerutilisateur.jsp

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
<html><head><title>Forum : Demande d'inscription</title></head>
<body><center><h1>Demande d'inscription</h1>
<jsp:include page='/WEB-INF/jspf/navigation.jsp' /><br>
<%-- Formulaire de saisie de l'utilisateur --%>
<form action='ajouterutilisateur.jsp' method='post'>
  <table width='90%' border='1' cellpadding='2' cellspacing='0'>
    <tr>
      <td bgcolor='#9999CC'><b>Pseudonyme</b></td>
      <td><input name='pseudonyme' type='text'
                 size='30' maxlength='30' ></td>
    </tr>
    <tr>
      <td bgcolor='#9999CC'><b>Mot de passe</b></td>
      <td> <i>Le mot de passe permettant de vous identifier
        est g&eacute;n&eacute;r&eacute; par le serveur</i></td>
    </tr>
  </table>
  <br><input type='submit' value='Envoyer la demande'>
</form></center></body></html>
