/*
 * Fichier com/eteks/test/Agenda.java
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

import com.eteks.outils.EvenementCalendrier;
import java.util.*;

class Agenda
{
  public static void main(String[] args)
  {
    // Creation d'un agenda trie avec trois evenements
    TreeSet<EvenementCalendrier> agenda = new TreeSet<>();
    agenda.add(new EvenementCalendrier(
        new GregorianCalendar(2012, Calendar.OCTOBER, 19).getTime(),
        "Anniversaire Claire"));
    agenda.add(new EvenementCalendrier(
        new GregorianCalendar(2012, Calendar.SEPTEMBER, 1, 8, 30).getTime(),
        "Rentr\u00e9e scolaire"));
    agenda.add(new EvenementCalendrier(
        new GregorianCalendar(2012, Calendar.SEPTEMBER, 1, 8, 30).getTime(),
        "Cours Java"));

    String evenements = "";
    // Enumeration des evenements en utilisant un iterateur
    Iterator<EvenementCalendrier> it = agenda.iterator();
    while (it.hasNext())
      evenements += it.next() + "\n"; // L'evenement est converti en texte avec toString

    javax.swing.JOptionPane.showMessageDialog(null, evenements);
  }
}
