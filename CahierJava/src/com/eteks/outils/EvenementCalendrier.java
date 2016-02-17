/*
 * Fichier com/eteks/outils/EvenementCalendrier.java
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

import java.util.Date;
import java.text.DateFormat;

/**
 * Classe d'evenement avec une date et une description.
 */
public class EvenementCalendrier implements Comparable<EvenementCalendrier>
{
  private Date   date;
  private String description;
  // Instanciation d'un objet de classe utilise pour la mise en forme de dates
  private static DateFormat format =
             DateFormat.getDateTimeInstance(DateFormat.FULL, DateFormat.SHORT);

  public EvenementCalendrier(Date date, String description)
  {
    this.date        = date;
    this.description = description;
  }

  public Date getDate()
  {
    return this.date;
  }

  public String getDescription()
  {
    return this.description;
  }

  // Implementation de la methode compareTo de l'interface java.lang.Comparable
  public int compareTo(EvenementCalendrier evenement)
  {
    // Utilisation de la comparaison de Date pour comparer d'abord dans l'ordre chronologique
    int ecartDate = this.date.compareTo(evenement.date);
    if (ecartDate != 0)
      return ecartDate;
    else
      // Si les dates des evenements sont egales, utilisation de comparaison des descriptions
      return this.description.compareToIgnoreCase(evenement.description);
  }

  // Redefinition des methodes de la classe java.lang.Object
  @Override
  public boolean equals(Object obj)
  {
    if (obj instanceof EvenementCalendrier)
    {
      EvenementCalendrier evenement = (EvenementCalendrier)obj;
      return this.date.equals(evenement.date)
             && this.description.equalsIgnoreCase(evenement.description);
    }
    else
      return false;
  }

  @Override
  public int hashCode()
  {
    return this.date.hashCode() + this.description.hashCode();
  }

  @Override
  public String toString()
  {
     // Mise en forme de la date dans la langue de l'utilisateur
     return format.format(this.date) + " : " + this.description;
  }
}
