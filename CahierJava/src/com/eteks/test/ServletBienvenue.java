/*
 * Fichier com/eteks/test/ServletBienvenue.java
 *
 * Les Cahiers du Programmeur Java - Copyright (C) 2003-2012 Emmanuel PUYBARET / eTeks <info@eteks.com>
 *
 * This library is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation; either
 * version 2.1 of the License, or (at your option) any later version.
 *
 * This library is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this library; if not, write to the Free Software
 * Foundation, Inc., 59 Temple Place, Suite 330, Boston, MA  02111-1307  USA
 */
package com.eteks.test;

import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet(urlPatterns="/bienvenue")
public class ServletBienvenue extends HttpServlet
{
  @Override
  public void doGet(HttpServletRequest request,
                    HttpServletResponse response)
                       throws ServletException, IOException
  {
    // Recuperation du parametre nom
    String nom = request.getParameter("nom");
    // Envoi d'une reponse en HTML
    response.setContentType("text/html");
    PrintWriter out = response.getWriter();
    out.write("<html><head><title>Bienvenue</title></head>"
             + "<body><h1>Bienvenue</h1>"
             + "<p>Bonjour ");
    // Generation d'un message different si le parametre existe ou non
    if (nom != null && nom.length() > 0)
      out.write(nom);
    else
      out.write("cher inconnu");
    out.write("</p></body></html>");
  }
}
