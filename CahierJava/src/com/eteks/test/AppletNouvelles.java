/*
 * Fichier com/eteks/test/AppletNouvelles.java
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

import java.awt.event.*;
import javax.swing.*;

/**
 * Applet deplacant verticalement un label parametrable.
 */
public class AppletNouvelles extends JApplet
{
  private Timer timer;

  // Point d'entree d'une applet : Methode appelee au chargement de l'applet
  @Override
  public void init()
  {
    // Creation d'un label utilisant le parametre texte
    final JLabel texte = new JLabel(getParameter("texte"));
    // Positionnement du label en bas de l'applet avec sa taille preferee
    texte.setLocation(0, getHeight());
    texte.setSize(texte.getPreferredSize());
    // Annulation du layout pour effectuer l'animation
    setLayout(null);
    add(texte);
    // Creation d'un listener deplacant le label texte verticalement
    ActionListener timerListener = new ActionListener()
      {
        public void actionPerformed(ActionEvent ev)
        {
          int y = texte.getY();
          // Si tout le texte a defile, le label est repositionne en bas de l'applet
          if (y < -texte.getHeight())
            y = getHeight();
          else
            // Sinon le label est deplace d'un pixel vers le haut
            y--;
          texte.setLocation(texte.getX(), y);
        }
      };
    // Timer appele toutes les 50 millisecondes
    this.timer = new Timer(50, timerListener);
  }

  // Methode appelee a l'affichage de l'applet
  @Override
  public void start()
  {
    this.timer.start(); // Demarrage de l'animation
  }

  // Methode appelee a la disparition de l'applet
  @Override
  public void stop()
  {
    this.timer.stop(); // Arret de l'animation
  }
}
