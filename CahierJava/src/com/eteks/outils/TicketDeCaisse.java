/*
 * Fichier com/eteks/outils/TicketDeCaisse.java
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

import java.util.ArrayList;

/**
 * Classe memorisant un ensemble de commandes a payer.
 */
public class TicketDeCaisse
{
  private ArrayList<Payant> lignes = new ArrayList<Payant>();

  /**
   * Ajoute une ligne de commande a ce ticket.
   */
  public void ajouterLigne(Payant ligne)
  {
    this.lignes.add(ligne);
  }

  /**
   * Renvoie la somme des prix des commandes ajoutees a ce ticket.
   */
  public float getPrixTotal()
  {
    float prix = 0;
    for (Payant ligne : this.lignes)
      prix += ligne.getPrix();
    return prix;
  }
}
