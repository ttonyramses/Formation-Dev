<%--
   Fichier identifierutilisateur.html

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
<html><head><title>Identification</title></head>
<body><center><h1>Forum</h1>
<jsp:include page='/WEB-INF/jspf/navigation.jsp' />
  <p>Identifiez-vous pour participer au forum :</p>
<form action='verifierutilisateur.jsp' method='post'>
  <table border='0'>
    <tr>
      <td>Pseudonyme :</td>
      <td><input name='pseudonyme' type='text'
                 maxlength='30'></td>
    </tr>
    <tr>
      <td>Mot de passe :</td>
      <td><input name='motDePasse' type='password'
                 maxlength='30'></td>
    </tr>
  </table>
  <input type='submit' value='Identifier'>
</form>
</center></body></html>
