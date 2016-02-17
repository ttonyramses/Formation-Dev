<%--
   Fichier erreur.jsp

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
<%@ page isErrorPage='true' %>
<html><head><title>Erreur</title></head>
<body><center><h1>Erreur... </h1>
<p>Votre demande n'a pu aboutir.</p>
<p>Merci de signaler les circonstances de cet incident au
webmaster<br>de ce site en lui transmettant le texte d'erreur
qui suit :</p>
<p><b><%= exception %></b></p>
</center></body></html>
