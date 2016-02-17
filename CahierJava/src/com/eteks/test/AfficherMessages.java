/*
 * Fichier com/eteks/test/AfficherMessages.java
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

class MessageSimple
{
  public void afficher()
  {
    JOptionPane.showMessageDialog(null, "Bonjour !");
  }
}

// Sous classe de com.eteks.test.Message
class MessageRiche extends MessageSimple
{
  // Redefinition de la methode afficher() de la super classe
  @Override
  public void afficher()
  {
    // Affiche un message different de celui de sa super classe
    // Si le texte du parametre de javax.swing.JOptionPane.showMessageDialog commence
    // par la balise <html>, le texte est affiche en utilisant le format HTML
    JOptionPane.showMessageDialog(null,
       "<html><b>Vive Java !</b><br> <i>Le programmeur masqu&eacute;</i></html>");
  }
}

class AfficherMessages
{
  public static void main(String [] args)
  {
    // Instanciation des deux classes
    MessageSimple message      = new MessageSimple();
    MessageRiche  messageRiche = new MessageRiche();
    // Affichage des deux messages
    message.afficher();       // Affiche : Bonjour
    messageRiche.afficher();  // Affiche : Vive Java ! ...

    // Conversion de messageRiche dans une reference de sa super classe
    message = messageRiche;
    // La methode appelee n'est pas celle de la classe de la reference
    // mais celle de la classe de l'objet designe par la reference
    message.afficher();       // Affiche encore : Vive Java ! ...
  }
}
