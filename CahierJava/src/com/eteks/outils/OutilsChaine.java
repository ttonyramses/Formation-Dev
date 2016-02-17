/*
 * Fichier com/eteks/outils/OutilsChaine.java
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

public class OutilsChaine
{
  public static final String CHAINE_SUITE = " [...]";

  /**
   * Renvoie la chaine limitee a max caracteres.
   */
  public static String limiterLongueur(String chaine, int max)
  {
    if (chaine.length() <= max)
      return chaine;
    else
    {
      int indiceEspace = chaine.lastIndexOf(' ', max - CHAINE_SUITE.length());
      // S'il n'y a pas d'espace avant max, la chaine est coupee a max caracteres
      if (indiceEspace == -1)
        return chaine.substring(0, max - CHAINE_SUITE.length()) + CHAINE_SUITE;
      else
        return chaine.substring(0, indiceEspace) + CHAINE_SUITE;
    }
  }

  /**
   * Convertit les caracteres < ' " et & en leur equivalent HTML.
   */
  public static String convertirEnEntites(String chaine)
  {
    if (chaine != null)
    {
      // Remplacement des caracteres & par des entites &amp;
      chaine = chaine.replace("&",  "&amp;");
      // Remplacement des caracteres < par des entites &lt;
      chaine = chaine.replace("<",  "&lt;");
      // Remplacement des caracteres ' par des entites &apos;
      chaine = chaine.replace("'",  "&apos;");
      // Remplacement des caracteres " par des entites &quot;
      chaine = chaine.replace("\"",  "&quot;");
    }
    return chaine;
  }

  /**
   * Convertit les caracteres < ' " & et retour a la ligne de chaine en leur equivalent HTML.
   */
  public static String convertirEnHTML(String chaine)
  {
    if (chaine != null)
    {

      chaine = convertirEnEntites(chaine);
      // Remplacement des retours a la ligne par des balises <br>
      chaine = chaine.replace("\n",  "<br>");
    }
    return chaine;
  }
}
