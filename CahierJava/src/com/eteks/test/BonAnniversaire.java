/*
 * Fichier com/eteks/test/BonAnniversaire.java
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
import java.util.GregorianCalendar;
import java.util.Date;
import javax.swing.JOptionPane;

class BonAnniversaire
{
  public static void main(String[] args)
  {
    String date = JOptionPane.showInputDialog("Date d'anniversaire (jj/mm) :");
    // Extraction du jour et du mois
    int indiceSlash = date.indexOf('/');
    String jourDate = date.substring(0, indiceSlash);
    String moisDate = date.substring(indiceSlash + 1);
    // Creation d'un objet java.util.GregorianCalendar a la date d'aujourd'hui
    GregorianCalendar aujourdhui = new GregorianCalendar();
    // Creation d'un objet java.util.GregorianCalendar a la date d'anniversaire
    // Attention ! l'indice du mois debute a 0 (0 pour janvier, 1 pour fevrier,...)
    GregorianCalendar anniversaire;
    anniversaire = new GregorianCalendar(aujourdhui.get(GregorianCalendar.YEAR),
                                         Integer.parseInt(moisDate) - 1,
                                         Integer.parseInt(jourDate));
    String message;
    // Calcul de la difference de jours entre les deux dates
    long joursRestant = anniversaire.get(GregorianCalendar.DAY_OF_YEAR)
                        - aujourdhui.get(GregorianCalendar.DAY_OF_YEAR);
    if (joursRestant == 0)
      message = "Bon anniversaire !";
    else
    {
      // Si l'anniversaire est deja passe, la date passe a l'annee prochaine
      if (anniversaire.before(aujourdhui))
      {
        anniversaire.set(GregorianCalendar.YEAR,aujourdhui.get(GregorianCalendar.YEAR)+1);
        GregorianCalendar prochain31Decembre =
            new GregorianCalendar(aujourdhui.get(GregorianCalendar.YEAR), GregorianCalendar.DECEMBER, 31);
        joursRestant = anniversaire.get(GregorianCalendar.DAY_OF_YEAR)
                     + (prochain31Decembre.get(GregorianCalendar.DAY_OF_YEAR)
                     - aujourdhui.get(GregorianCalendar.DAY_OF_YEAR));
      }
      // Mise en forme de la date au format complet (par exemple lundi 12 mai 2003)
      DateFormat formatJour = DateFormat.getDateInstance(DateFormat.FULL);
      Date dateAnniversaire = anniversaire.getTime();
      String texteDateAnniversaire = formatJour.format(dateAnniversaire);
      message =   "Votre anniversaire est dans " + joursRestant + " jours"
                + "\nle " + texteDateAnniversaire;
    }
    JOptionPane.showMessageDialog(null, message);
  }
}
