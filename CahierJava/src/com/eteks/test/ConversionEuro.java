/*
 * Fichier com/eteks/test/ConversionEuro.java
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

import com.eteks.outils.ConvertisseurEuro;

class ConversionEuro
{
  public static void main(String [] args)
  {
    short montant1 = 40;
    short montant2 = 300;
    // Toutes les operateurs operant sur des entiers byte, short, char ou int
    // renvoient un resultat de type int
    int montantTotal = montant1 + montant2;
    // La conversion en type byte est acceptee mais montantByte, trop petit pour stocker
    // 340 (= 0x0154 = 101010100), contient 84 (= 0x54 = 01010100 partie basse de 0x0154)
    byte  montantOctet = (byte)montantTotal;

    ConvertisseurEuro convertisseur;
    // Une valeur passee en parametre ou une valeur de retour peut etre aussi convertie
    convertisseur = new ConvertisseurEuro((float)montantTotal);
    float montantEnFranc = convertisseur.getMontantEnFranc();

    String texteMontantEnFranc;
    String texteMontantTotal;
    // Il est impossible de convertir un nombre de type primitif en type objet
    // (de classe java.lang.String ou autre) avec un operateur de cast (et inversement)
    // texteMontantEnFranc = (java.lang.String)montantEnFranc; // Instruction incorrecte
    // texteMontantTotal   = (java.lang.String)montantTotal;   // Instruction incorrecte
    Float objetMontantEnFranc = new Float(montantEnFranc);
    texteMontantEnFranc = objetMontantEnFranc.toString();
    // Similairement a la classe java.lang.Float, la classe java.lang.Integer a un champ
    // de type int et une methode toString capable de convertir cet entier en son texte
    Integer objetMontantTotal = new Integer(montantTotal);
    texteMontantTotal = objetMontantTotal.toString();

    String messageEuro  = texteMontantTotal.concat(" \u20ac = ");
    String messageFranc = texteMontantEnFranc.concat(" FF");
    String message = messageEuro.concat(messageFranc);
    // Affiche 340 euro = 2230.25 FF
    javax.swing.JOptionPane.showMessageDialog(null, message);
  }
}
