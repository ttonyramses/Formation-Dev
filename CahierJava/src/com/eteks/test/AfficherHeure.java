/*
 * Fichier com/eteks/test/AfficherHeure.java
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
import java.util.Date;
import java.text.DateFormat;

class ListenerHeure implements java.awt.event.ActionListener
{
  public void actionPerformed(java.awt.event.ActionEvent ev)
  {
    // Creation d'un texte avec les heures:minutes:secondes du moment
    String heure = DateFormat.getTimeInstance().format(new Date());
    JOptionPane.showMessageDialog(null, "Il est " + heure);
  }
}

class AfficherHeure
{
  public static void main(String[] args)
  {
    // Creation d'un bouton lie a une instance de com.eteks.test.ListenerHeure
    JButton boutonHeure = new JButton("Quelle heure est-il ?");
    java.awt.event.ActionListener actionBouton = new ListenerHeure();
    boutonHeure.addActionListener(actionBouton);

    // Affichage du bouton dans une fenetre
    JFrame fenetre = new JFrame("Heure");
    fenetre.getContentPane().add(boutonHeure);
    fenetre.setResizable(false);
    fenetre.pack();
    fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    fenetre.setVisible(true);
  }
}
