/*
 * Fichier com/eteks/forum/Utilisateur.java
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

/**
 * Utilisateur du forum avec son pseudonyme, son mot de passe
 * et les droits sur le forum qui lui sont autorises.
 */
public class Utilisateur
{
  private String pseudonyme;
  private String motDePasse;
  private Autorisation autorisation;

  public Utilisateur(String pseudonyme, String motDePasse,
                     Autorisation autorisation)
  {
    this.pseudonyme = pseudonyme;
    this.motDePasse = motDePasse;
    this.autorisation = autorisation;
  }

  public String getPseudonyme()
  {
    return this.pseudonyme;
  }

  public void setPseudonyme(String pseudonyme)
  {
    this.pseudonyme = pseudonyme;
  }

  public String getMotDePasse()
  {
    return this.motDePasse;
  }

  public void setMotDePasse(String motDePasse)
  {
    this.motDePasse = motDePasse;
  }

  public Autorisation getAutorisation()
  {
    return this.autorisation;
  }

  public boolean isModerateur()
  {
    return this.autorisation == Autorisation.MODERATEUR;
  }

  public void setAutorisation(Autorisation autorisation)
  {
    this.autorisation = autorisation;
  }

  @Override
  public boolean equals(Object obj)
  {
    if (this.pseudonyme != null)
      if (obj instanceof Utilisateur)
      {
        Utilisateur utilisateur = (Utilisateur)obj;
        return this.pseudonyme.equals(utilisateur.pseudonyme);
      }
    return false;
  }

  @Override
  public int hashCode()
  {
    if (this.pseudonyme == null)
      return super.hashCode();
    else
      return this.pseudonyme.hashCode();
  }

  @Override
  public String toString()
  {
    if (isModerateur())
      return this.pseudonyme + " (Mod\u00e9rateur)";
    else if (this.pseudonyme != null)
      return this.pseudonyme + " (Utilisateur)";
    else
      return "Utilisateur inconnnu";
  }
}
