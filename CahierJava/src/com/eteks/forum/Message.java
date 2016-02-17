/*
 * Fichier com/eteks/forum/Message.java
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
package com.eteks.forum;

import java.util.Date;
import java.text.DateFormat;

/**
 * Message du forum avec son auteur, son sujet, son texte
 * et sa date de creation.
 */
public class Message
{
  private String auteur;
  private Date   dateCreation = new Date();
  private String sujet;
  private String texte;

  public Message (Utilisateur auteur, String sujet,
                  String texte)
  {
    if (auteur != null)
      this.auteur = auteur.getPseudonyme();
    this.sujet  = sujet;
    this.texte  = texte;
  }

  public String getAuteur()
  {
    return this.auteur;
  }

  public void setAuteur(String auteur)
  {
    this.auteur = auteur;
  }

  public void setAuteur(Utilisateur auteur)
  {
    this.auteur = auteur.getPseudonyme();
  }


  public boolean estEcritPar(Utilisateur auteur)
  {
    return this.auteur.equals(auteur.getPseudonyme());
  }

  public void setDateCreation(Date date)
  {
    this.dateCreation = date;
  }

  public Date getDateCreation()
  {
    return this.dateCreation;
  }

  public void setSujet(String sujet)
  {
    if (sujet == null)
      this.sujet = null;
    else
      this.sujet = sujet.trim();
  }

  public String getSujet()
  {
    return this.sujet;
  }

  public void setTexte(String texte)
  {
    if (texte == null)
      this.texte = null;
    else
      this.texte = texte.trim();
  }

  public String getTexte()
  {
    return this.texte;
  }


  private static DateFormat formatDate  =
            DateFormat.getDateInstance(DateFormat.MEDIUM);
  private static DateFormat formatHeure =
            DateFormat.getTimeInstance(DateFormat.SHORT);

  @Override
  public String toString()
  {
    return "De " + this.auteur + " le "
           + formatDate.format(this.dateCreation)
           + " \u00e0 " + formatHeure.format(this.dateCreation)
           + "\nSujet : " + this.sujet
           + "\n" + this.texte;
  }
}
