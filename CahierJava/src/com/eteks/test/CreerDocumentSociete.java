/*
 * Fichier com/eteks/test/CreerDocumentSociete.java
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

import java.io.File;

import javax.xml.bind.JAXB;

import com.eteks.outils.Employe;
import com.eteks.outils.Societe;

class CreerDocumentSociete
{
  public static void main(String[] args)
  {
    // Creation d'une societe avec deux employes
    Societe entreprise = new Societe("Ma Petite Entreprise", 10000);
    entreprise.ajouter(new Employe("Martin", "Sophie", "Dirigeant", "3, place de la Gare 95300 Pontoise"));
    entreprise.ajouter(new Employe("Durand", "Thomas", "Programmeur", "8, rue de Rennes 75006 Paris"));
    
    JAXB.marshal(entreprise, new File("societe.xml"));
  }
}
