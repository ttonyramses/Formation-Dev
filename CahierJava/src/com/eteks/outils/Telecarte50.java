/*
 * Fichier com/eteks/outils/Telecarte50.java
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

/**
 * Telecarte de 50 unites.
 */
public class Telecarte50
{
  // Champ memorisant le nombre d'unites d'une telecarte
  // avec une valeur initiale de 50
  private int unites = 50;

  /**
   * Debite cette telecarte du nombre d'unites debit.
   */
  public void debiterUnites(int debit)
  {
    // Calcul du nombre d'unites diminue de debit
    int nouveauCredit = this.unites - debit;
    // Mise a jour du champ unites avec le nouveau credit
    this.unites = nouveauCredit;
  }

  /**
   * Renvoie le nombre d'unites restantes.
   */
  public int getUnites()
  {
    // Renvoie la valeur du champ unites
    return this.unites;
  }
}

