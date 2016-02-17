/*
 * Fichier com/eteks/test/NombresEnToutesLettres.java
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

import com.eteks.outils.NombreEntier;

class NombresEnToutesLettres
{
  public static void main(String[] args)
  {
    String message = "Quelques nombres en toutes lettres :";
    NombreEntier n15 = new NombreEntier(15);
    message += "\n" + n15.getNombre() + " : "
                    + n15.convertirEnLettres();
    NombreEntier n23 = new NombreEntier(23);
    message += "\n" + n23.getNombre() + " : "
                    + n23.convertirEnLettres();
    NombreEntier n71 = new NombreEntier(71);
    message += "\n" + n71.getNombre() + " : "
                    + n71.convertirEnLettres();
    NombreEntier n80 = new NombreEntier(80);
    message += "\n" + n80.getNombre() + " : "
                    + n80.convertirEnLettres();
    NombreEntier n98 = new NombreEntier(98);
    message += "\n" + n98.getNombre() + " : "
                    + n98.convertirEnLettres();
    javax.swing.JOptionPane.showMessageDialog(null, message);
  }
}
