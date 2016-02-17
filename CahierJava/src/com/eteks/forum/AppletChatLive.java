/*
 * Fichier com/eteks/forum/AppletChatLive.java
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
package com.eteks.forum;

import java.io.*;

/**
 * Applet de chat live qui garde la connexion avec le serveur.
 */
public class AppletChatLive extends AppletChat
{
  @Override
  public void lireMessages() throws IOException
  {
    try (Reader fluxLecture = new InputStreamReader(
                  connecter(getParameter("lireMessages")), "UTF-8"))
    {
      ByteArrayOutputStream bytes = new ByteArrayOutputStream();
      Writer chars = new OutputStreamWriter(bytes, "UTF-8");
      int c;
      while ((c = fluxLecture.read()) != -1)
        if (c != 0)
          chars.write(c);
        else
        {
          chars.flush();
          byte [] octetsLus = bytes.toByteArray();
          InputStream fluxOctets = new ByteArrayInputStream(octetsLus);
          afficherMessagesXML(fluxOctets);
          // Vide la memoire tampon
          bytes.reset();
        }
    }
  }
}

