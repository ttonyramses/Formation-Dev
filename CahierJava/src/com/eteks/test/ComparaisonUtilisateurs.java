/*
 * Fichier com/eteks/test/ComparaisonUtilisateurs.java
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

import com.eteks.forum.*;

class ComparaisonUtilisateurs
{
  public static void main(String[] args)
  {
    // Creation de 3 utilisateurs
    Utilisateur moderateur   = new Utilisateur(
           "moderateur", "azerty", Autorisation.MODERATEUR);
    Utilisateur utilisateur1 = new Utilisateur(
           "thomas", "tomtom", Autorisation.UTILISATEUR);
    Utilisateur utilisateur2 = new Utilisateur(
           "thomas", "sophie", Autorisation.UTILISATEUR);

    String message = "Bonjour " + moderateur;
    // Equivalent a "Bonjour ".concat(moderateur.toString())

    // Comparaison des deux premiers utilisateurs
    if (!moderateur.equals(utilisateur1))
      message += "\n" + moderateur + " et " + utilisateur1
                 + " sont des utilisateurs diff\u00e9rents";

    // Declaration de 2 references de classe java.lang.Object designant les utilisateurs egaux.
    // Toute classe heritant de java.lang.Object, il est possible de convertir implicitement
    // une reference de n'importe quelle classe en une reference de type java.lang.Object
    Object objetA = utilisateur1;
    Object objetB = utilisateur2;

    if (objetA.equals(objetB))
      message += "\n" + objetA + " et " + objetB
                 + " sont \u00e9gaux";
    // Si la classe de l'objet ne redefinie pas les methodes de java.lang.Object
    // ce sont les methodes de la classe java.lang.Object qui sont appelees
    objetA = new Boisson("Jus d'orange", 3.f);
    objetB = new Boisson("Jus d'orange", 3.f);
    if (!objetA.equals(objetB))
      // Meme si les deux boissons memorisent les memes valeurs, ce sont deux objets
      // differents pour la methode equals de la classe java.lang.Object
      message += "\nLes deux objets " + objetA + " et "+ objetB
                 + " ne sont pas \u00e9gaux";

    javax.swing.JOptionPane.showMessageDialog(null, message);
  }
}
