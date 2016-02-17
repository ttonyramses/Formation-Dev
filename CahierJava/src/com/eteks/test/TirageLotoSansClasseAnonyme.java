/*
 * Fichier com/eteks/test/TirageLotoSansClasseAnonyme.java
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

class NouveauTirage implements ActionListener
{
  private JLabel labelLoto;

  public NouveauTirage(JLabel labelLoto)
  {
    this.labelLoto = labelLoto;
  }

  public void actionPerformed(ActionEvent ev)
  {
    // Mise a jour du label avec les
    // numeros d'un nouveau tirage
    labelLoto.setText(Loto.
      creerTirage().toString());
  }
}

class TirageLotoSansClasseAnonyme
{
  public static void main(String[] args)
  {
    JLabel labelLoto = new JLabel();
    // Creation d'un bouton mettant a jour
    // le label avec un nouveau tirage de
    // loto grace au listener de classe
    // com.eteks.test.NouveauTirage
    JButton boutonLoto =
              new JButton("Nouveau tirage");
    boutonLoto.addActionListener(
              new NouveauTirage(labelLoto));
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
