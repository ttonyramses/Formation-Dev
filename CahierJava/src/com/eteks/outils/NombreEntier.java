/*
 * Fichier com/eteks/outils/NombreEntier.java
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

public class NombreEntier
{
  private int nombre;

  public NombreEntier(int n)
  {
    this.nombre = n;
  }

  public int getNombre()
  {
    return this.nombre;
  }

  /**
   * Renvoie ce nombre converti en toutes lettres s'il est compris
   * entre 0 et 99.
   */
  public String convertirEnLettres()
  {
    if (this.nombre >= 0 && this.nombre < 100)
      switch (this.nombre)
      {
        // Tous les case decrivent les cas remarquables simples
        case  0 : return "z\u00e9ro";
        case  1 : return "un";
        case  2 : return "deux";
        case  3 : return "trois";
        case  4 : return "quatre";
        case  5 : return "cinq";
        case  6 : return "six";
        case  7 : return "sept";
        case  8 : return "huit";
        case  9 : return "neuf";
        case 10 : return "dix";
        case 11 : return "onze";
        case 12 : return "douze";
        case 13 : return "treize";
        case 14 : return "quatorze";
        case 15 : return "quinze";
        case 16 : return "seize";
        case 20 : return "vingt";
        case 30 : return "trente";
        case 40 : return "quarante";
        case 50 : return "cinquante";
        case 60 : return "soixante";
        default :
          // Le cas par defaut concatene les dizaines et les unites en toutes lettres :
          // Le plus simple est de creer les objets NombreEntier pour les dizaines et
          // les unites et d'appeler la methode convertirEnToutesLettres sur ces objets
          {
            // Recherche de la dizaine et des unites
            int dizaine = (this.nombre / 10) * 10; // La division entiere supprime les unites
            int unites  = this.nombre % 10; // Les unites sont egales au reste de la division par 10
            if (dizaine == 70 || dizaine == 90)
            {
              dizaine -= 10; // Equivalent a dizaine = dizaine - 10;
              unites  += 10; // Equivalent a unites  = unites  + 10;
            }
            // Si la dizaine du nombre est egal a 80, il faut mettre un s pour 80
            // et pas de s pour les autres nombres
            if (dizaine == 80)
            {
              if (unites == 0)
                return "quatre vingts";
              else
                return "quatre vingt "
                 + new NombreEntier(unites).convertirEnLettres();
            }
            String dizaineEnLettres =
              new NombreEntier(dizaine).convertirEnLettres();
            String unitesEnLettres =
              new NombreEntier(unites).convertirEnLettres();
            // Si les unites sont egales a un ou onze il faut ajouter le texte "et"
            // entre la dizaine et le nombre
            if (unites == 1 || unites == 11)
              return dizaineEnLettres + " et " + unitesEnLettres;
            else
              return dizaineEnLettres + " " + unitesEnLettres;
          }
      }
    else
      // Cette methode se limite aux nombres positifs inferieurs a 100
      return this.nombre + " n\u00e9gatif ou trop grand";
  }
}


