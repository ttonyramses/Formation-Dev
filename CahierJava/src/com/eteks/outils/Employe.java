/*
 * Fichier com/eteks/outils/Employe.java
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

import javax.xml.bind.annotation.*;

@XmlType(propOrder={"nom", "prenom", "poste", "adresse"})
@XmlAccessorType(XmlAccessType.PROPERTY)
public class Employe
{
  private String nom;
  private String prenom;
  private String poste;
  private String adresse;
  
  public Employe() 
  {
    // Constructeur sans parametre obligatoire pour JAXB
  }
  
  public Employe(String nom, String prenom, String poste, String adresse)
  {
    this.nom = nom;
    this.prenom = prenom;
    this.poste = poste;
    this.adresse = adresse;
  }

  @XmlAttribute(required=true)
  public String getNom()
  {
    return this.nom;
  }
  
  public void setNom(String nom) {
    this.nom = nom; 
  }

  @XmlAttribute(name="pr\u00e9nom", required=true)
  public String getPrenom()
  {
    return this.prenom;
  }
  
  public void setPrenom(String prenom) {
    this.prenom = prenom; 
  }
  
  @XmlAttribute(required=false)
  public String getPoste()
  {
    return this.poste;
  }
  
  public void setPoste(String poste) {
    this.poste = poste; 
  }
  
  @XmlValue
  public String getAdresse()
  {
    return this.adresse;
  }

  public void setAdresse(String adresse) {
    this.adresse = adresse; 
  }
}
