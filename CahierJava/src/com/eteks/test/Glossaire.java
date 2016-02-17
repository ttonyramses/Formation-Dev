/*
 * Fichier com/eteks/test/Glossaire.java
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

import java.util.HashMap;
import javax.swing.JOptionPane;

class Glossaire
{
  public static void main(String[] args)
  {
    String  definitionInstance   = "Objet cr\u00e9\u00e9 \u00e0 partir d'une classe.";
    String  definitionCollection = "Instance d'une classe g\u00e9rant "
                                   + "un ensemble d'\u00e9l\u00e9ments.";
    String  definitionSousClasse = "Classe h\u00e9ritant d'une autre classe.";
    // Remplissage du glossaire
    HashMap<String, String> glossaire = new HashMap<>();
    glossaire.put("instance", definitionInstance);
    glossaire.put("collection", definitionCollection);
    // sous classe et classe derivee ont la meme definition
    glossaire.put("sous classe", definitionSousClasse);
    glossaire.put("classe d\u00e9riv\u00e9e", definitionSousClasse);

    while (true)
    {
      // Saisie de la recherche
      String recherche = JOptionPane.showInputDialog("Que cherchez-vous ?");
      // Si l'utilisateur choisit Annuler recherche est egal a null
      if (recherche == null)
        System.exit(0);

      // Recherche de la definition sans tenir compte de la casse
      String definition = glossaire.get(recherche.toLowerCase());
      // Affichage avec des icones differentes suivant le resultat de la recherche
      if (definition != null)
        JOptionPane.showMessageDialog(null, recherche + " : " + definition,
                      "R\u00e9sultat de la recherche", JOptionPane.INFORMATION_MESSAGE);
      else
        JOptionPane.showMessageDialog(null, recherche + " non d\u00e9fini",
                      "R\u00e9sultat de la recherche", JOptionPane.WARNING_MESSAGE);
    }
  }
}
