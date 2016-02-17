/*
 * Fichier com/eteks/test/TriMots.java
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

import java.util.Arrays;
import javax.swing.JOptionPane;

class TriMots
{
  /**
   * Trie les chaines de caracteres contenues dans args puis affiche le resultat
   * de ce tri. Utilisation : java com.eteks.test.TriMots mot1 mot2 mot3 ...
   */
  public static void main(String [] args)
  {
    // Tri du tableau
    Arrays.sort(args);
    // Affichage des mots tries. Si le message a afficher est un tableau, la methode
    // showMessageDialog affiche les elements du tableau l'un en dessous de l'autre.
    JOptionPane.showMessageDialog(null, args);
  }
}
