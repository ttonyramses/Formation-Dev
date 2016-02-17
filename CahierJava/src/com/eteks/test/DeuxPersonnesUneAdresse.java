/*
 * Fichier com/eteks/test/DeuxPersonnesUneAdresse.java
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

import com.eteks.outils.*;

class DeuxPersonnesUneAdresse
{
  public static void main(String[] args)
  {
    Personne personne1;
    // Creation d'une instance de com.eteks.outils.Personne pour Thomas Durand
    personne1 = new Personne("Durand", "Thomas");
    Adresse adresse1;
    // Creation d'une instance de com.eteks.outils.Adresse
    adresse1 = new Adresse("5, rue de Rennes", 75006, "PARIS");
    // Affectation de son adresse a Thomas
    personne1.setAdresse(adresse1);

    // Creation d'une autre instance de com.eteks.outils.Personne pour Sophie Martin
    Personne personne2 = new Personne("Martin", "Sophie");
    // Affectation directe de l'autre adresse avec une nouvelle instance
    personne2.setAdresse(new Adresse("3, pl. de la Gare", 95300, "PONTOISE"));

    // Plus tard... Sophie demenage chez Thomas et partage donc son adresse
    personne2.setAdresse(personne1.getAdresse());

    // Plus tard... Ils s'agrandissent et demenagent tous les deux
    Adresse adresseCommune = new Adresse("8, rue de Rennes", 75006, "PARIS");
    personne1.setAdresse(adresseCommune);
    personne2.setAdresse(adresseCommune);

    // Et vous annonce la nouvelle.   Les references renvoyees par
    // personne1.getAdresse() et personne2.getAdresse() sont egales et designent le meme objet
    String adresse = personne1.getAdresse().getRue() + " \u00e0 "
                     + personne2.getAdresse().getVille();
    String nouvelle = personne1.getPrenom() + " et " + personne2.getPrenom()
                      + " habitent maintenant au " + adresse;
    // Affiche Thomas et Sophie habitent maintenant au 8, rue de Rennes a PARIS
    javax.swing.JOptionPane.showMessageDialog(null, nouvelle);
  }
}
