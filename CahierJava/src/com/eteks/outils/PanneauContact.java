/*
 * Fichier com/eteks/outils/PanneauContact.java
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
package com.eteks.outils;

import java.awt.*;
import javax.swing.*;

/**
 * Panneau de saisie d'un individu.
 */
public class PanneauContact extends JPanel
{
  private final static String [] TITRES = {"Mr", "Mme", "Melle"};
  private JComboBox<String> saisieTitre = new JComboBox<>(TITRES);
  private JTextField saisieNom     = new JTextField(10);
  private JTextField saisiePrenom  = new JTextField(10);
  private JTextArea  saisieAdresse = new JTextArea(4, 20);

  public PanneauContact()
  {
    JPanel panneauLabels = new JPanel(new GridLayout(4, 1, 5, 5));
    panneauLabels.add(new JLabel("Titre :"));
    panneauLabels.add(new JLabel("Nom :"));
    panneauLabels.add(new JLabel("Pr\u00e9nom :"));
    panneauLabels.add(new JLabel("Adresse :"));

    JPanel panneauSaisie = new JPanel(new GridLayout(4, 1, 5, 5));
    panneauSaisie.add(this.saisieTitre);
    panneauSaisie.add(this.saisieNom);
    panneauSaisie.add(this.saisiePrenom);

    setLayout(new BorderLayout(5, 5));
    add(panneauLabels, BorderLayout.WEST);
    add(panneauSaisie, BorderLayout.CENTER);
    add(new JScrollPane(saisieAdresse), BorderLayout.SOUTH);
  }

  public String getTitre()
  {
    return this.saisieTitre.getItemAt(this.saisieTitre.getSelectedIndex());
  }

  public String getNom()
  {
    return this.saisieNom.getText();
  }

  public String getPrenom()
  {
    return this.saisiePrenom.getText();
  }

  public String getAdresse()
  {
    return this.saisieAdresse.getText();
  }
}
