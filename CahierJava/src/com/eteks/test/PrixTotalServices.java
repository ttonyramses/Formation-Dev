/*
 * Fichier com/eteks/test/PrixTotalServices.java
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

class PrixTotalServices
{
  public static void main(java.lang.String [] args)
  {
    java.lang.String         installation = "Installation";
    com.eteks.outils.Service serviceInstallation;
    // Instanciation d'un service de classe com.eteks.outils.Service initialise avec
    // l'intitule installation et le prix 80.f puis affectation a serviceInstallation
    serviceInstallation = new com.eteks.outils.Service(installation, 80.f);

    // Creation d'une deuxieme instance de com.eteks.outils.Service
    com.eteks.outils.Service serviceFraisDeplacement =
                    new com.eteks.outils.Service("Frais de d\u00e9placement", 28.15f);
    // Appel de la methode setPrix pour modifier le prix
    serviceFraisDeplacement.setPrix(29.55f);

    // Calcul de la somme des deux prix
    float prixInstallation = serviceInstallation.getPrix();
    float prixFrais        = serviceFraisDeplacement.getPrix();
    float somme = prixInstallation + prixFrais;

    // Instanciation de la classe java.lang.Float memorisant un nombre de type
    // primitif float initialise dans son constructeur avec la valeur en parametre
    java.lang.Float objetSomme = new java.lang.Float(somme);
    // Appel de la methode toString qui renvoie un texte contenant le nombre
    java.lang.String texteSomme = objetSomme.toString();

    java.lang.String texteTotal = "Total : ".concat(texteSomme);
    java.lang.String message    = texteTotal.concat(" \u20ac");
    // Affiche le texte Total : 109.55 euro
    javax.swing.JOptionPane.showMessageDialog(null, message);
  }
}
