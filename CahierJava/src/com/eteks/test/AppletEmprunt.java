/*
 * Fichier com/eteks/test/AppletEmprunt.java
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

import com.eteks.outils.Emprunt;
import java.text.NumberFormat;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 * Applet de calcul de mensualite d'un emprunt.
 */
public class AppletEmprunt extends JApplet
{
  @Override
  public void init()
  {
    // Recuperation des valeurs par defaut passees en parametre
    Double  capital = new Double(getParameter("capital"));
    Double  taux    = new Double(getParameter("taux"));
    Integer duree   = new Integer(getParameter("duree"));
    // Creation des composants de saisie du capital, du taux et de la duree de l'emprunt
    final JFormattedTextField saisieCapital = new JFormattedTextField(capital);
    final JFormattedTextField saisieTaux    = new JFormattedTextField(taux);
    final JSpinner saisieDuree   = new JSpinner();
    saisieDuree.setValue(duree);
    final JLabel labelMensualite = new JLabel();
    final JLabel labelCout = new JLabel();

    // Ajout des composants a un panneau utilisant une grille de 5 lignes x 2 colonnes
    JPanel panneauEmprunt = new JPanel(new java.awt.GridLayout(5, 2, 0, 2));
    panneauEmprunt.add(new JLabel("Capital emprunt\u00e9 :"));
    panneauEmprunt.add(saisieCapital);
    panneauEmprunt.add(new JLabel("Taux d'int\u00e9r\u00eat (en %) :"));
    panneauEmprunt.add(saisieTaux);
    panneauEmprunt.add(new JLabel("Dur\u00e9e (en ann\u00e9es) :"));
    panneauEmprunt.add(saisieDuree);
    panneauEmprunt.add(new JLabel("Mensualit\u00e9s :"));
    panneauEmprunt.add(labelMensualite);
    panneauEmprunt.add(new JLabel("Co\u00fbt :"));
    panneauEmprunt.add(labelCout);

    // Creation du bouton qui provoque un calcul de mensualite
    JButton boutonCalculer = new JButton("Calculer");
    boutonCalculer.addActionListener(new ActionListener()
      {
        public void actionPerformed(ActionEvent ev)
        {
          // Recuperation des valeurs saisies
          double capital      = ((Number)saisieCapital.getValue()).doubleValue();
          double taux         = ((Number)saisieTaux.getValue()).doubleValue() / 100. / 12;
          int    nbMensualite = ((Number)saisieDuree.getValue()).intValue() * 12;
          if (nbMensualite <= 0)
            JOptionPane.showMessageDialog(AppletEmprunt.this,
                         "La dur\u00e9e doit \u00eatre positive.",
                         "Calcul Mensualit\u00e9", JOptionPane.WARNING_MESSAGE);
          else
          {
            // Calcul des mensualites et des interets
            double mensualite = Emprunt.calculerMensualite(taux, nbMensualite, capital);
            double interets   = mensualite * nbMensualite - capital;
            NumberFormat formatNombre = NumberFormat.getInstance();
            labelMensualite.setText(formatNombre.format(mensualite));
            labelCout.setText(formatNombre.format(interets));
          }
        }
      });
    // Ajout du bouton a un panneau utilisant un layout de classe java.awt.FlowLayout
    // (layout par defaut de JPanel) pour qu'il prenne ses dimensions preferees
    JPanel panneauCalcul = new JPanel();
    panneauCalcul.add(boutonCalculer);
    // Ajout des deux panneaux au contenu de l'applet
    getContentPane().add(panneauEmprunt, BorderLayout.NORTH);
    getContentPane().add(panneauCalcul, BorderLayout.SOUTH);
  }
}
