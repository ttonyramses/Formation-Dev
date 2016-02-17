/*
 * Fichier com/eteks/test/ConversionsReferencesPayant.java
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

class ConversionsReferencesPayant
{
  public static void main(java.lang.String [] args)
  {
    // Creation d'objets
    Service           repas     = new Service("D\u00e9jeuner", 15.5f);
    Boisson           jusOrange = new Boisson("Jus d'orange", 2);
    BoissonAlcoolisee whisky    = new BoissonAlcoolisee("Whisky", 7.4f, 45);
    // Declaration d'une reference de type interface
    Payant commande;

    // Conversions de references de type classe vers le type interface

    // Conversion explicite d'une reference type classe vers le type interface
    commande = (Payant)repas;
    // Conversion implicite autorisee si la classe de la reference
    // ou une de ses super classes implemente l'interface de conversion.
    commande = whisky;

    // Avec la reference commande, on peut appeler toutes la methode de l'interface
    // com.eteks.outils.Payant et les methodes de la classe java.lang.Object mais pas
    // les methodes de com.eteks.test.BoissonAlcoolisee, classe effective de l'objet
    javax.swing.JOptionPane.showMessageDialog(null, "Prix de la commande : "
                                                    + commande.getPrix () + " \u20ac");

    // Toute reference peut etre convertie vers la classe java.lang.Object
    Object  objet = commande;

    // Execution OK :
    // Conversion d'une reference de type classe vers le type interface acceptee
    // si la classe de l'objet reference implemente l'interface de conversion.
    // A l'execution, la classe de l'objet reference implemente bien
    // l'interface com.eteks.test.Payant
    commande = (Payant)objet;
    // Exception java.lang.ClassCastException a l'execution :
    // Conversion d'une reference de type classe vers le type interface refusee
    // si la classe de l'objet reference n'implemente pas l'interface de conversion.
    // A l'execution, l'objet n'implemente pas l'interface com.eteks.test.Payant
    commande = (Payant)new Object();

    // Conversions de references de type interface vers le type classe
    Payant commande2 = jusOrange;

    // Execution OK :
    // Conversion d'une reference de type interface vers une reference de type classe
    // acceptee si l'objet reference est effectivement une instance de cette classe.
    // A l'execution, l'objet designe par commande2 est bien un objet
    // de classe com.eteks.test.Boisson
    Boisson boisson = (Boisson)commande2;
    // Exception java.lang.ClassCastException a l'execution :
    // Conversion d'une reference de type interface vers une reference de type classe
    // refusee si l'objet reference n'est pas effectivement une instance de cette
    // classe. A l'execution l'objet designe par commande2 n'est pas un objet
    // de classe com.eteks.outils.Service
    Service service = (Service)commande2;
  }
}
