/*
 * Fichier com/eteks/test/PlanLogement.java
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
import java.awt.*;

/**
 * Composant graphique affichant le plan d'une maison.
 */
class Plan extends JComponent
{
  @Override
  public void paintComponent (Graphics g)
  {
    // Remplissage du fond du composant en blanc
    g.setColor(Color.white);
    g.fillRect(0, 0, getWidth(), getHeight());
    // Creation des tableaux de coordonees (x,y) du contour du logement
    int [] x = {30, 30, 310, 310,  30, 30, 36,  36, 304, 304, 36, 36};
    int [] y = {45, 25,  25, 230, 230, 80, 80, 224, 224,  31, 31, 45};
    g.setColor(Color.GRAY);
    g.fillPolygon(x, y, x.length); // Remplissage du contour en gris
    g.setColor(Color.BLACK);
    g.drawPolygon(x, y, x.length); // Contour en noir
    // Dessin des cloisons en noir
    g.drawLine(215,  31, 215, 224);
    g.drawLine(215, 145, 304, 145);
    // Dessin des portes avec un arc de cercle et une ligne
    g.drawArc(185, 125, 60, 60, 270, 90);
    g.drawLine(215, 155, 245, 155);
    g.drawArc(185,  105, 60, 60,   0, 90);
    g.drawLine(215, 135, 245, 135);
    g.drawArc(1,  10, 70, 70, 270, 90);
    g.drawLine(36, 45, 71, 45);
    // Dessin du bac de douche et du lavabo
    g.drawRect(270, 190, 34, 34);
    g.drawArc(220, 204, 45, 40, 0, 180);
    // Legendes des pieces
    g.drawString("Salon", 110, 135);
    g.drawString("Cuisine", 240, 90);
    g.drawString("S.d.Bain", 243, 180);
  }

  @Override
  public Dimension getPreferredSize ()
  {
    return new Dimension (330, 250);
  }
}

class PlanLogement
{
  public static void main(String[] args)
  {
    JFrame fenetre = new JFrame ("Plan de la maison");
    // Ajout d'une instance du composant Plan a la fenetre
    fenetre.getContentPane().add (new Plan ());
    fenetre.pack();
    fenetre.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
    fenetre.setVisible (true);
  }
}
