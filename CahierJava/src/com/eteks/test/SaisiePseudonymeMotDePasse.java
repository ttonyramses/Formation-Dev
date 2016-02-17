/*
 * Fichier com/eteks/test/SaisiePseudonymeMotDePasse.java
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
import java.awt.*;

class SaisiePseudonymeMotDePasse
{
  public static void main(String[] args)
  {
    JFrame fenetre = new JFrame("Identification");
    // Utilisation d'un gestionnaire de layout FlowLayout avec un ecart
    // de 5 pixels entre les composants alignes sur la gauche
    fenetre.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 5)); 

    // Ajout de 4 composants
    fenetre.add(new JLabel("Pseudonyme :")); 
    fenetre.add(new JTextField(10));
    fenetre.add(new JLabel("Mot de passe :"));
    fenetre.add(new JPasswordField(10));

    // Calcul de la taille preferee de la fenetre en fonction de son contenu
    fenetre.pack(); 
    fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
    fenetre.setVisible(true); 
  }
}