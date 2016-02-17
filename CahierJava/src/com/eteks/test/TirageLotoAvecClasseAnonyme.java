/*
 * Fichier com/eteks/test/TirageLotoAvecClasseAnonyme.java
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

import com.eteks.outils.Loto;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class TirageLotoAvecClasseAnonyme
{
  public static void main(String[] args)
  {
    final JLabel labelLoto = new JLabel();
    // Creation d'un bouton mettant a jour
    // le label avec un nouveau tirage de
    // loto grace a un listener de classe
    // anonyme
    JButton boutonLoto =
              new JButton("Nouveau tirage");
    boutonLoto.addActionListener(
      new ActionListener()
      {
        public void actionPerformed
                        (ActionEvent ev)
        {
          // Mise a jour du label avec les
          // numeros d'un nouveau tirage.
          // labelLoto doit etre declare
          // final pour pouvoir etre
          // utilise dans la classe anonyme
          labelLoto.setText(Loto.
            creerTirage().toString());
        }
      });
    // Affichage du bouton et du label l'un
    // sous l'autre dans une fenetre
    JFrame fenetre = new JFrame("Loto");
    fenetre.setLayout(new GridLayout(2, 1));
    fenetre.add(boutonLoto);
    fenetre.add(labelLoto);
    fenetre.pack();
    fenetre.setDefaultCloseOperation(
                     JFrame.EXIT_ON_CLOSE);
    fenetre.setVisible(true);
  }
}
