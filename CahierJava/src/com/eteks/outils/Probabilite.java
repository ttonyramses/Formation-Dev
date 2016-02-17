/*
 * Fichier com/eteks/outils/Probabilite.java
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

public class Probabilite
{
  /**
   * Renvoie le nombre d'arrangements possibles sans repetition avec p elements pris
   * parmi n elements. Anp = n x (n - 1) x (n - 2) x ... x (n - p + 2) x (n - p + 1)
   */
  public long arrangementsSansRepetition(long n, long p)
  {
    long resultat = n - p + 1;
    long i = resultat + 1; // Indice de boucle
    while (i <= n)
    {
      resultat = resultat * i;
      i = i + 1;
    }
    return resultat;
  }

  /**
   * Renvoie le nombre d'arrangements possibles avec repetition avec p elements pris
   * parmi n elements (n puissance p)
   */
  public long arrangementsAvecRepetition(long n, long p)
  {
    long resultat = 1;
    long i = 1; // Indice de boucle
    do
      resultat *= n;
    while (++i <= p);

    return resultat;
  }

  /**
   * Renvoie le nombre de permutations possibles entre les elements d'un ensemble de
   * n elements. Pn = n! = n x (n - 1) x (n - 2) x ... x 3 x 2 x 1
   */
  public long permutations(long n)
  {
    long resultat = 1;
    for (long i = 2; i <= n; i++)
      resultat *= i;

    return resultat;
  }

  /**
   * Renvoie le nombre de combinaisons possibles entre les elements avec p elements pris
   * parmi n elements. Cnp = Anp / p! = n x (n - 1) x ... x (n - p + 1) / p!
   */
  public long combinaisons(long n, long p)
  {
    return arrangementsSansRepetition(n, p) / permutations(p);
  }
}
