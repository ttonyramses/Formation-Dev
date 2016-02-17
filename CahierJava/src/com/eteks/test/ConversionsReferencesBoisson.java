/*
 * Fichier com/eteks/test/ConversionsReferencesBoisson.java
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

import javax.swing.JOptionPane;

class ConversionsReferencesBoisson
{
  public static void main(java.lang.String [] args)
  {
    // Creation d'objets
    Boisson eau = new Boisson("Eau min\u00e9rale", 1f);
    BoissonAlcoolisee whisky
                = new BoissonAlcoolisee("Whisky", 7.4f, 45);
    // Declaration d'autres references pour les tests
    Boisson           boisson;
    BoissonAlcoolisee boissonForte;
    Boisson           boissonInconnue = null;
    com.eteks.outils.Service  service;

    // Compilation OK et execution OK :
    // Conversion d'une reference d'une classe vers sa super classe acceptee.
    boisson = (Boisson)whisky;
    // Avec la reference boisson, on peut appeler toutes les methodes de la classe
    // com.eteks.test.Boisson mais pas les methodes supplementaires de
    // com.eteks.test.BoissonAlcoolisee, classe effective de l'objet
    JOptionPane.showMessageDialog(null, boisson.getNom());
    // Compilation OK et execution OK :
    // Conversion d'une reference d'une classe vers sa sous classe acceptee
    // a la compilation et a l'execution, si l'objet reference est effectivement
    // une instance de la sous classe. A l'execution, l'objet designe par boisson
    // est bien un objet de classe com.eteks.test.BoissonAlcoolisee
    boissonForte = (BoissonAlcoolisee)boisson;
    // Compilation OK et execution OK :
    // Conversion d'une reference d'une classe vers sa sous classe acceptee
    // a la compilation et a l'execution, si l'objet reference est inconnu.
    boissonForte = (BoissonAlcoolisee)boissonInconnue;
    // Compilation OK mais exception java.lang.ClassCastException a l'execution :
    // Conversion d'une reference d'une classe vers sa sous classe acceptee
    // a la compilation mais refusee a l'execution, si l'objet reference n'est pas
    // effectivement une instance de la sous classe. A l'execution l'objet
    // designe par eau n'est pas  un objet de classe com.eteks.test.BoissonAlcoolisee
    boissonForte = (BoissonAlcoolisee)eau;
    String message = boissonForte.getNom() + " "
                     + boissonForte.getDegreAlcool() + "\u00b0";
    JOptionPane.showMessageDialog(null, message);
    // Erreur de compilation : inconvertible types
    // Conversion d'une reference d'une classe vers une autre classe
    // refusee si les deux classes n'ont aucun lien d'heritage entre elles.
    // service = (com.eteks.outils.Service)eau; // Instruction incorrecte
  }
}
