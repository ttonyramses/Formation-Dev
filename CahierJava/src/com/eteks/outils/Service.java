/*
 * Fichier com/eteks/outils/Service.java
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
 * Service avec un intitule et un prix.
 */
public class Service implements Payant
{
  private java.lang.String intitule; // Champ memorisant l'intitule du service
  private float            prix;     // Champ memorisant le prix du service

  /**
   * Initialise un service avec son intitule.
   */
  public Service(java.lang.String intitule, float prix)
  {
    this.intitule = intitule; // Modifie le champ intitule avec le parametre intitule
    this.prix     = prix;     // Modifie le champ prix avec la valeur en parametre
  }
  /**
   * Renvoie l'intitule de ce service.
   */
  public java.lang.String getIntitule()
  {
    return this.intitule;
  }

  /**
   * Modifie le prix de ce service.
   */
  public void setPrix(float prix)
  {
    this.prix = prix;
  }

  /**
   * Renvoie le prix de ce service.
   */
  public float getPrix()
  {
    return this.prix;
  }
}
