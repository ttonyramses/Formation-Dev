/*
 * Fichier com/eteks/test/GrilleLoto.java
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

import com.eteks.outils.Loto;
import java.util.List;
import javax.swing.JOptionPane;

class GrilleLoto
{
  public static void main(String[] args)
  {
    List<Integer> tirageLoto = Loto.creerTirage();
    // Construction d'un tableau HTML (balise <table>) affichant une grille de loto
    String grilleLoto = "<html><table border='1'>";
    for (int ligne = 0; ligne < 10; ligne++)
    {
      // Ajout d'une ligne au tableau HTML (balise <tr>)
      grilleLoto += "<tr>";
      for (int colonne = 0; colonne < 5; colonne++)
      {
        int boule = ligne + (colonne * 10);
        // Ajout d'une cellule a la ligne (balise <td>)
        grilleLoto += "<td><font size='+2'>";
        if (boule > 0)
          // Appel de la methode contains declaree dans l'interface java.util.List
          // et implementee par la classe de l'objet designe par tirageLoto
          if (tirageLoto.contains(boule))
            grilleLoto += "<b>" + boule + "</b>";
          else
            grilleLoto += "<font color='gray'>" + boule + "</font>";
        grilleLoto += "</font></td>";
      }
      grilleLoto += "</tr>";
    }
    grilleLoto += "</table></html>";
    // Affichage du tableau HTML dans une boite de dialogue de titre Loto et sans icone
    JOptionPane.showMessageDialog(null, grilleLoto, "Loto", JOptionPane.PLAIN_MESSAGE);
  }
}
