/*
 * Fichier com/eteks/outils/Loto.java
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

import java.util.*;

public class Loto
{
  /**
   * Renvoie une liste de 6 nombres tires aleatoirement dans
   * un ensemble de nombres compris entre 1 et 49.
   */
  public static List<Integer> creerTirage()
  {
    // Creation d'une collection des 49 entiers de 1 a 49
    ArrayList<Integer> boulesLoto = new ArrayList<>(49);
    for (int i = 1; i <= 49; i++)
      boulesLoto.add(i);

    // Melange aleatoire de la collection boulesLoto
    // Conversion implicite d'une reference d'une classe vers l'interface qu'elle
    // implemente acceptee : la classe java.util.ArrayList implemente java.util.List
    Collections.shuffle(boulesLoto);
    // Extraction des 6 premiers entiers de la collection melangee :
    // subList renvoie une reference designant un objet dont la classe implemente
    // l'interface java.util.List
    return boulesLoto.subList(0, 6);
  }
}

