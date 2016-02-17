/*
 * Fichier com/eteks/test/CalculInterets.java
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

class Compte
{
  private String identifiant; // Champ memorisant l'identifiant d'un compte
  private float  solde;       // Champ memorisant le solde d'un compte

  public Compte(String identifiant, float depot)
  {
    this.identifiant = identifiant;
    this.solde       = depot;
  }

  public String getIdentifiant()
  {
    return this.identifiant;
  }

  public float getSolde()
  {
    return this.solde;
  }
}

class CompteEpargne extends Compte
{
  // CompteEpargne herite des champs private identifiant et solde
  private float taux;   // Champ memorisant le taux d'interets applicable
  private int   annees; // Champ memorisant le nombre d'annees d'epargne

  public CompteEpargne(String identifiant, float depot, float taux)
  {
    super(identifiant, depot);
    this.taux = taux;
  }

  public void setAnnees(int annees)
  {
    // Modification du champs annees si le parametre est positif ou nul
    if (annees >= 0)
      this.annees = annees;
  }

  public int getAnnees()
  {
    return this.annees;
  }

  public double getTaux()
  {
    return this.taux;
  }

  @Override
  public float getSolde()
  {
    // Recuperation du solde initial
    float solde = super.getSolde();
    // Multiplication nombre d'annees fois par (1 + taux)
    for (int i = 0; i < this.annees; i++)
      solde *= 1f + this.taux;
    return solde;
  }
}

class CalculInterets
{
  public static void main(String [] args)
  {
    // Creation d'une instance de com.eteks.test.Compte
    Compte compte1 = new Compte("A01", 1000f);
    // Creation d'une instance de com.eteks.test.CompteEpargne
    CompteEpargne compte2;
    compte2 = new CompteEpargne("E99", 1000f, 0.1f);
    compte2.setAnnees(5);
    // Declaration de la reference c de classe com.eteks.test.Compte. c peut designer
    // des objets de classe com.eteks.test.Compte ou com.eteks.test.CompteEpargne
    Compte c;

    String message = "L'argent qui dort ne rapporte rien :";
    // Affectation de la reference compte1 a c pour afficher le solde du 1er compte
    c = compte1;
    message += "\n \u25aa Solde compte n\u00b0"
               + c.getIdentifiant() + " : "
               + c.getSolde() + " \u20ac";

    // Affectation de la reference compte2 a c pour afficher le solde du 2eme compte
    c = compte2;
    message += "\n \u25aa Solde compte n\u00b0"
               + c.getIdentifiant() + " : "
               + c.getSolde() + " \u20ac";

    javax.swing.JOptionPane.showMessageDialog(null, message);
  }
}
