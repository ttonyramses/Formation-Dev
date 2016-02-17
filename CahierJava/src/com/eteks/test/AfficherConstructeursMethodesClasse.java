/*
 * Fichier com/eteks/test/AfficherConstructeursMethodesClasse.java
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

class AfficherConstructeursMethodesClasse
{
  public static void main(String[] args)
  {
    // Saisie du nom de la classe
    String classe = JOptionPane.showInputDialog("Classe :");
    try
    {
      // Obtention de l'objet representant la classe saisie
      Class objetClasse = Class.forName(classe);
      // Affichage des constructeurs et des methodes public de la classe
      JOptionPane.showMessageDialog(null, objetClasse.getConstructors(),
         "Constructeurs de " + classe, JOptionPane.PLAIN_MESSAGE);
      JOptionPane.showMessageDialog(null, objetClasse.getMethods(),
         "M\u00e9thodes de " + classe, JOptionPane.PLAIN_MESSAGE);
    }
    catch (ClassNotFoundException ex)
    {
      JOptionPane.showMessageDialog(null, "La classe " + classe + " n'existe pas");
    }
  }
}
