/*
 * Fichier com/eteks/test/ClavierCalculatrice.java
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

class ClavierCalculatrice
{
  public static void main(String[] args)
  {
    JFrame fenetre = new JFrame("Clavier");
    // Utilisation d'un gestionnaire de layout GridLayout de 4 lignes par
    // 4 colonnes avec un ecart d'un pixel entre les composants
    fenetre.setLayout(new GridLayout(4, 4, 1, 1));

    // Ajout de boutons pour former un clavier de calculatrice
    fenetre.add(new JButton("7"));
    fenetre.add(new JButton("8"));
    fenetre.add(new JButton("9"));
    fenetre.add(new JButton("C"));
    fenetre.add(new JButton("4"));
    fenetre.add(new JButton("5"));
    fenetre.add(new JButton("6"));
    fenetre.add(new JButton("\u00f7"));
    fenetre.add(new JButton("1"));
    fenetre.add(new JButton("2"));
    fenetre.add(new JButton("3"));
    fenetre.add(new JButton("x"));
    fenetre.add(new JButton("0"));
    fenetre.add(new JButton(","));
    fenetre.add(new JButton("+"));
    fenetre.add(new JButton("-"));

    // Calcul de la taille preferee de la fenetre en fonction de son contenu
    fenetre.pack();
    fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    fenetre.setVisible(true);
  }
}
