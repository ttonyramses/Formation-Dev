/*
 * Fichier com/eteks/outils/ConvertisseurEuro.java
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
 * Classe de conversion monetaire Euro/Franc Francais.
 */
public class ConvertisseurEuro
{
  private float montantEnEuro;

  public ConvertisseurEuro(float montantEnEuro)
  {
    this.montantEnEuro = montantEnEuro;
  }

  /**
   * Renvoie le montant en Euros.
   */
  public float getMontantEnEuro()
  {
    return this.montantEnEuro;
  }

  /**
   * Renvoie le montant en Francs Francais.
   */
  public float getMontantEnFranc()
  {
    float montantFrancNonArrondi = this.montantEnEuro * 6.55957f;
    // Calcul de l'arrondi en centime de Franc (0.5f est utilise pour l'arrondi)
    float montantCentimeFrancNonArrondi = montantFrancNonArrondi * 100f + 0.5f;
    // Suppression des decimales en convertissant dans un type entier
    long  montantCentimeFrancSansDecimale = (long)montantCentimeFrancNonArrondi;
    // Conversion en float pour avoir un nombre decimal puis division par 100
    float montantCentimeFrancAvecDecimale = (float)montantCentimeFrancSansDecimale;
    float montantCentimeFrancArrondi = montantCentimeFrancAvecDecimale / 100f;
    return montantCentimeFrancArrondi;
  }
}
