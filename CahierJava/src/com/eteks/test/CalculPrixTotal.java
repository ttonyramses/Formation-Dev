/*
 * Fichier com/eteks/test/CalculPrixTotal.java
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

import com.eteks.outils.*;
import javax.swing.JOptionPane;

class CalculPrixTotal
{
  public static void main(String[] args)
  {
    Boisson jusOrange = new Boisson("Jus d'orange", 2);
    Boisson whisky    = new BoissonAlcoolisee("Whisky", 7.4f, 45);
    Service repas     = new Service("D\u00eener", 22.5f);

    // Creation d'une instance de TicketDeCaisse pour calculer le total
    TicketDeCaisse ticket = new TicketDeCaisse();
    ticket.ajouterLigne(jusOrange);
    ticket.ajouterLigne(whisky);
    ticket.ajouterLigne(repas);
    ticket.ajouterLigne(repas);

    // Interrogation du prix total du ticket calcule en fonction des lignes ajoutees
    float prixTotal = ticket.getPrixTotal();
    JOptionPane.showMessageDialog(null, "Total : " + prixTotal + " \u20ac");
  }
}
