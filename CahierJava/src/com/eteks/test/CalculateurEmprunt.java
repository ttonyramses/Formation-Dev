/*
 * Fichier com/eteks/test/CalculateurEmprunt.java
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

import javax.swing.JOptionPane;
import com.eteks.outils.*;

class CalculateurEmprunt
{
  public static void main(String[] args)
  {
    // La methode showInputDialog affiche une boite de dialogue de saisie textuelle
    // avec le texte passe en parametre comme commentaire
    String texteCapital = JOptionPane.showInputDialog("Capital emprunt\u00e9 :");
    String texteTaux = JOptionPane.showInputDialog("Taux d'int\u00e9r\u00eat (en %) :");
    String texteNbAnnees = JOptionPane.showInputDialog("Dur\u00e9e (en ann\u00e9es) :");

    // Appel des methodes parse... qui convertissent les valeurs saisies
    double capital      = Double.parseDouble(texteCapital);
    float  taux         = Float.parseFloat(texteTaux) / 100.f / 12f;
    int    nbMensualite = Integer.parseInt(texteNbAnnees) * 12;
    // Calcul des mensualites et des interets
    double mensualite = Emprunt.calculerMensualite(taux, nbMensualite, capital);
    double interets   = mensualite * nbMensualite - capital;
    // Construction d'un message d'information
    String message =   "Pour un capital emprunt\u00e9 de " + texteCapital + " \u20ac"
                     + " sur " + texteNbAnnees + " ann\u00e9es"
                     + " \u00e0 un taux d'int\u00e9r\u00eat de " + texteTaux + " %, "
                     + "\nvos mensualit\u00e9s seront de " + mensualite + " \u20ac"
                     + " et ce cr\u00e9dit vous co\u00fbtera " + interets + " \u20ac";
    JOptionPane.showMessageDialog(null, message);
  }
}
