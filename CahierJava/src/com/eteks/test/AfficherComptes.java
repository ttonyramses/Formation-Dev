/*
 * Fichier com/eteks/test/AfficherComptes.java
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

class AfficherComptes
{
  /**
   * Affiche un texte decrivant le compte et son solde.
   */
  public static void afficherCompte(Compte c)
  {
    // c peut designer des objets de classe com.eteks.test.Compte ou com.eteks.test.CompteEpargne
    String message = "Solde du compte n\u00b0" + c.getIdentifiant()
                     + " : " + c.getSolde() + " \u20ac";

    JOptionPane.showMessageDialog(null, message);
  }

  public static void main(String [] args)
  {
    // Creation d'une instance de com.eteks.test.Compte
    Compte compte1 = new Compte("A01", 1000f);
    // Creation d'une instance de com.eteks.test.CompteEpargne
    CompteEpargne compte2 = new CompteEpargne("E99", 1000f, 0.1f);
    compte2.setAnnees(5);
    // Appel de la methode afficherCompte avec compte1
    // equivalent a AfficherComptes.afficherCompte(compte1);
    afficherCompte(compte1);
    // Appel de la methode afficherCompte avec compte2
    // la reference compte2 est convertie implicitement dans le type com.eteks.test.Compte
    afficherCompte(compte2);
  }
}
