/*
 * Fichier com/eteks/test/CarnetAdresses.java
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
import javax.swing.table.DefaultTableModel;
import java.awt.event.*;
import com.eteks.outils.PanneauContact;

class CarnetAdresses
{
  public static void main(String[] args)
  {
    // La variable locale fenetre doit etre declaree final pour etre utilisable
    // dans la classe anonyme qui implemente ActionListener
    final JFrame fenetre = new JFrame("Contacts");
    // Creation d'un tableau vide dans la fenetre. Ce tableau utilise un modele
    // auquel il est possible d'ajouter des lignes ulterieurement
    String [] colonnes = {"Titre","Nom","Pr\u00e9nom","Adresse"};
    final DefaultTableModel modele = new DefaultTableModel(colonnes, 0);
    JTable tableau = new JTable(modele);
    fenetre.add(new JScrollPane(tableau));

    // Recuperation de la touche utilisee pour les raccourcis (Ctrl ou Pomme)
    int toucheRaccourcis = java.awt.Toolkit.getDefaultToolkit().
                                        getMenuShortcutKeyMask();
    // Creation de l'element de menu Nouveau et son listener associe
    JMenuItem menuNouveau = new JMenuItem("Nouveau", 'N');
    menuNouveau.setAccelerator(
                 KeyStroke.getKeyStroke(KeyEvent.VK_N, toucheRaccourcis));
    menuNouveau.addActionListener(new ActionListener()
      {
        public void actionPerformed(ActionEvent ev)
        {
          // Saisie d'un nouveau contact
          PanneauContact panneau = new PanneauContact();
          int reponse = JOptionPane.showConfirmDialog(fenetre,
                            panneau, "Nouveau contact",
                            JOptionPane.OK_CANCEL_OPTION,
                            JOptionPane.PLAIN_MESSAGE);
          if (reponse == JOptionPane.OK_OPTION)
            // Ajout d'une ligne au tableau des adresses avec les valeurs saisies
            modele.addRow(new String []
                {panneau.getTitre(),  panneau.getNom(),
                 panneau.getPrenom(), panneau.getAdresse()});
        }
      });

    // Creation de l'element de menu Quitter avec son listener associe
    JMenuItem menuQuitter = new JMenuItem("Quitter", 'Q');
    menuQuitter.addActionListener(new ActionListener()
      {
        public void actionPerformed(ActionEvent ev)
        {
          if (JOptionPane.showConfirmDialog(fenetre,
                     "Voulez-vous vraiment quitter ?", "Quitter",
                     JOptionPane.YES_NO_OPTION)
                            == JOptionPane.YES_OPTION)
            System.exit(0); // Arret de la JVM
        }
      });

    // Creation d'une barre de menu avec le
    // menu Fichier et ses elements de menu
    JMenuBar barreMenu = new JMenuBar();
    fenetre.setJMenuBar(barreMenu);
    JMenu menuFichier = new JMenu("Fichier");
    barreMenu.add(menuFichier);
    menuFichier.add(menuNouveau);
    menuFichier.add(menuQuitter);
    // Affichage de la fenetre
    fenetre.setSize(300, 200);
    fenetre.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
    fenetre.setVisible(true);
  }
}
