<%--
   Fichier listecourses.jsp

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
<jsp:useBean id='articles' class='java.util.ArrayList' 
             type='java.util.ArrayList<String>'  scope='session'/>
<% if (request.getParameter("article") != null)
     articles.add(request.getParameter("article")); %>
<html><head><title>Liste de courses</title></head><body><center>
<h1>Liste de courses</h1>
<a href='editerarticle.html'>Ajouter un article</a></center>
<blockquote>
<% for (String article : articles)
   { %>
       <%= article %><br>
<% } %>
</blockquote></body></html>
