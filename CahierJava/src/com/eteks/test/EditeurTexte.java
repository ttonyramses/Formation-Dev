/*
 * Fichier com/eteks/test/EditeurTexte.java
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
import com.eteks.outils.ChargeurRessource;

class EditeurTexte
{
  public static void main(String[] args)
  {
    JFrame fenetre = new JFrame("Editeur");
    // Utilisation d'un gestionnaire de layout BorderLayout
    // avec un ecart de 2 pixels entre les composants
    fenetre.setLayout(new BorderLayout(2, 2));

    // Ajout de la barre d'outils en haut
    // Creation d'une barre d'outils utilisant les icones nouveau, couper, copier, coller
    JToolBar outils = new JToolBar();
    ChargeurRessource chargeur =
        new ChargeurRessource("/toolbarButtonGraphics/general/");
    outils.add(new JButton(chargeur.getIcon("New16.gif")));
    outils.addSeparator();
    outils.add(new JButton(chargeur.getIcon("Cut16.gif")));
    outils.add(new JButton(chargeur.getIcon("Copy16.gif")));
    outils.add(new JButton(chargeur.getIcon("Paste16.gif")));

    fenetre.add(outils, BorderLayout.NORTH);
    // Ajout d'une zone de saisie de taille preferee 10 lignes x 50 colonnes
    fenetre.add(new JScrollPane(new JTextArea(10, 50)),
                BorderLayout.CENTER);
    // Ajout d'un label d'etat avec un bord en bas
    JLabel etat = new JLabel(" Application d\u00e9marr\u00e9e");
    etat.setBorder(BorderFactory.createLoweredBevelBorder());
    fenetre.add(etat, BorderLayout.SOUTH);

    // Calcul de la taille preferee de la fenetre en fonction de son contenu
    fenetre.pack();
    fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    fenetre.setVisible(true);
  }
}
