/*
 * Fichier com/eteks/test/TelecarteEmpruntee.java
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

class TelecarteEmpruntee
{
  public static void main(java.lang.String [] args)
  {
    // Declaration de la variable locale maTelecarte
    // reference de classe com.eteks.outils.Telecarte50
    com.eteks.outils.Telecarte50 maTelecarte;
    // Instanciation de la classe com.eteks.outils.Telecarte50 et affectation
    // de la reference designant le nouvel objet a la reference maTelecarte
    maTelecarte = new com.eteks.outils.Telecarte50();
    // Appel de la methode debiterUnites pour debiter d'une unite la telecarte
    // designee par la reference maTelecarte
    maTelecarte.debiterUnites(1);
    // Appel de la methode getUnites pour interroger le nombre d'unites restant
    // de la telecarte et affectation de la valeur a la nouvelle variable unites
    int unites = maTelecarte.getUnites(); // unites vaut 49

    // Declaration de la variable locale telecarteEmpruntee
    com.eteks.outils.Telecarte50 telecarteEmpruntee;
    // Affectation de la reference maTelecarte a la reference telecarteEmpruntee
    // telecarteEmpruntee et maTelecarte designe le meme objet
    telecarteEmpruntee = maTelecarte;
    // Debit de 46 unites sur la telecarte designee par la reference telecarteEmpruntee
    telecarteEmpruntee.debiterUnites(46);
    // Les references telecarteEmpruntee et maTelecarte designant toutes les deux
    // le meme objet, l'appel a getUnites sur ces references renvoie la meme valeur
    unites = telecarteEmpruntee.getUnites(); // unites vaut 3
    unites = maTelecarte.getUnites();        // unites vaut aussi 3 :(

    // Il est impossible d'utiliser le champ private unites en dehors de la classe
    // com.eteks.outils.Telecarte50, ce qui le protege des modifications intempestives
    // L'instruction suivante est mise en commentaire car le compilateur la refuse
    // telecarteEmpruntee.unites = 48;

    // Declaration de la reference taTelecarte initialisee avec telecarteEmpruntee
    com.eteks.outils.Telecarte50 taTelecarte = telecarteEmpruntee;
    // maTelecarte est reinitialisee avec une deuxieme instance
    // de la classe com.eteks.outils.Telecarte50
    maTelecarte = new com.eteks.outils.Telecarte50();
    // Debit de deux unites sur la telecarte designee par la reference maTelecarte
    maTelecarte.debiterUnites(2);
    // Debit de deux unites sur la telecarte designee par la reference taTelecarte
    taTelecarte.debiterUnites(2);
    // Interrogation du nombre d'unites restant sur les deux telecartes
    int unitesMaTelecarte = maTelecarte.getUnites(); // unitesMaTelecarte vaut 48 :)
    int unitesTaTelecarte = taTelecarte.getUnites(); // unitesTaTelecarte vaut 1  :(
    javax.swing.JOptionPane.showMessageDialog(null,
                         "Les bons comptes font les bons amis");
  }
}
