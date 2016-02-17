/*
 * Fichier com/eteks/test/JoursFeries.java
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

import java.text.DateFormat;
import java.util.*;
import javax.swing.JOptionPane;

class JoursFeries
{
  public static void main(String[] args)
  {
    // Saisie de l'annee
    String texteAnnee = JOptionPane.showInputDialog("Ann\u00e9e recherch\u00e9e :");
    int annee = Integer.parseInt(texteAnnee);
    // Tableau des jours feries mobiles
    GregorianCalendar [] joursFeriesMobiles =
        {new GregorianCalendar(annee, Calendar.JANUARY, 1),
         new GregorianCalendar(annee, Calendar.MAY, 1),
         new GregorianCalendar(annee, Calendar.MAY, 8),
         new GregorianCalendar(annee, Calendar.JULY, 14),
         new GregorianCalendar(annee, Calendar.AUGUST, 15),
         new GregorianCalendar(annee, Calendar.NOVEMBER, 1),
         new GregorianCalendar(annee, Calendar.NOVEMBER, 11),
         new GregorianCalendar(annee, Calendar.DECEMBER, 25)};
    String joursFixes = "Jours f\u00e9ri\u00e9s fixes :"
                        + "\n\u25aa Lundi de p\u00e2ques"
                        + "\n\u25aa Jeudi de l'ascension"
                        + "\n\u25aa Lundi de pentec\u00f4te";
    String joursMobiles = "Jours f\u00e9ri\u00e9s mobiles :";
    DateFormat formatJour = DateFormat.getDateInstance(DateFormat.FULL);
    int nombreJoursFeriesHorsWeekEnd = 3;
    for (GregorianCalendar jour : joursFeriesMobiles)
    {
      // Ajout du jour mis en forme a la liste des jours feries mobiles
      joursMobiles += "\n\u25aa " + formatJour.format(jour.getTime());
      // Decompte des jours hors week end
      if (   jour.get(Calendar.DAY_OF_WEEK) != Calendar.SATURDAY
          && jour.get(Calendar.DAY_OF_WEEK) != Calendar.SUNDAY)
        nombreJoursFeriesHorsWeekEnd++;
    }

    String message = "Calendrier fran\u00e7ais des jours f\u00e9ri\u00e9s de " + annee
                   + " (" + nombreJoursFeriesHorsWeekEnd + " jours hors week end) :"
                   + "\n" + joursFixes
                   + "\n" + joursMobiles;
    JOptionPane.showMessageDialog(null, message);
  }
}
