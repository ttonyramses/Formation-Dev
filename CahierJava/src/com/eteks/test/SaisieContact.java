/*
 * Fichier com/eteks/test/SaisieContact.java
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

import javax.swing.*;
import com.eteks.outils.PanneauContact;

class SaisieContact
{
  public static void main(String[] args)
  {
    PanneauContact panneau = new PanneauContact();
    int reponse = JOptionPane.showConfirmDialog(null, panneau,
                       "Contact", JOptionPane.OK_CANCEL_OPTION,
                       JOptionPane.PLAIN_MESSAGE);
    if (reponse == JOptionPane.OK_OPTION)
      JOptionPane.showMessageDialog(null, "Contact :\n"
         + panneau.getTitre() + " "
         + panneau.getPrenom() + " " + panneau.getNom()
         + "\n" + panneau.getAdresse());
  }
}
