/*
 * Fichier com/eteks/outils/Societe.java
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
package com.eteks.outils;

import java.util.*;
import javax.xml.bind.annotation.*;

@XmlType(name="Soci\u00e9t\u00e9", 
         propOrder={"nom", "capital", "employes"})
@XmlRootElement(name="soci\u00e9t\u00e9")
@XmlAccessorType(XmlAccessType.FIELD)
public class Societe
{
  @XmlAttribute(required=true)
  private String nom;
  @XmlAttribute(required=true)
  private int capital;
  @XmlElement(name="employ\u00e9")
  private List<Employe> employes = new ArrayList<Employe>();

  public Societe()
  {
    // Constructeur necessaire uniquement pour un unmarshalling
  }
  
  public Societe(String nom, int capital)
  {
    this.nom = nom;
    this.capital = capital;
  }
  
  public String getNom()
  {
    return this.nom;
  }

  public int getCapital()
  {
    return this.capital;
  }
  
  public void ajouter(Employe employe) 
  {
    this.employes.add(employe);
  }

  public List<Employe> getEmployes()
  {
    return this.employes;
  }
}
