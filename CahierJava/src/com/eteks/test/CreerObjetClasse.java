/*
 * Fichier com/eteks/test/CreerObjetClasse.java
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

class CreerObjetClasse
{
  public static void main(String[] args)
  {
    // Saisie de la classe
    String classe = JOptionPane.showInputDialog("Classe :");
    try
    {
      // Creation d'un objet a partir de la classe saisie
      Object objet = Class.forName(classe).newInstance();
      JOptionPane.showMessageDialog(null, objet);
    }
    catch (ClassNotFoundException 
           | IllegalAccessException 
           | InstantiationException ex)
    {
      JOptionPane.showMessageDialog(null, 
             "Impossible d'instancier la classe " + classe);
    }
  }
}
