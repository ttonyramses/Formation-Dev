/*
 * Fichier com/eteks/test/AppletBienvenue.java
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

import javax.swing.*;

public class AppletBienvenue extends JApplet
{
  // Point d'entree d'une applet : Methode appelee au chargement de l'applet
  @Override
  public void init()
  {
    // Recuperation du parametre nom
    String nom = getParameter("nom");
    JLabel labelBienvenue = new JLabel ("Bonjour " + nom);
    // Ajout du label au contenu de l'applet
    getContentPane().add(labelBienvenue);
  }
}
