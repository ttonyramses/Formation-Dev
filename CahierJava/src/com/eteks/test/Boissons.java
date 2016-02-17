/*
 * Fichier com/eteks/test/Boissons.java
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

class Boisson implements com.eteks.outils.Payant
{
  private String nom;  // Champ memorisant le nom d'une boisson
  private float  prix; // Champ memorisant le prix d'une boisson

  public Boisson(String nom, float prix)
  {
    this.nom  = nom;
    this.prix = prix;
  }

  public String getNom()
  {
    return this.nom;
  }

  public float getPrix()
  {
    return this.prix;
  }
}

class BoissonAlcoolisee extends Boisson
{
  private int degreAlcool; // Champ memorisant le degre d'alcool d'une boisson alcoolisee

  public BoissonAlcoolisee(String nom, float prix, int degreAlcool)
  {
    // Initialisation de l'objet Boisson
    super(nom, prix);
    // Initialisation de l'objet BoissonAlcoolisee
    this.degreAlcool = degreAlcool;
  }

  public int getDegreAlcool()
  {
    return this.degreAlcool;
  }
}

class Boissons
{
  public static void main(String [] args)
  {
    // Creation d'un objet de la super classe com.eteks.test.Boisson
    Boisson jus = new Boisson("Jus d'orange", 3.f);
    String message = jus.getNom() + " \u00e0 "
                     + jus.getPrix() + " \u20ac";
    javax.swing.JOptionPane.showMessageDialog(null, message);
    // Creation d'un objet de la sous classe com.eteks.test.BoissonAlcoolisee
    BoissonAlcoolisee porto;
    porto = new BoissonAlcoolisee("Porto", 9.5f, 18);
    // On peut appeler les methodes getNom, getPrix et getDegreAlcool avec porto
    message = porto.getNom() + " " + porto.getDegreAlcool()
              + "\u00b0 \u00e0 " + porto.getPrix() + " \u20ac";
    javax.swing.JOptionPane.showMessageDialog(null, message); // Affiche Porto 18 deg a 9.5 euro
  }
}


