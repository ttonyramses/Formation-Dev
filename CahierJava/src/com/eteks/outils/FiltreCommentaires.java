/*
 * Fichier com/eteks/outils/FiltreCommentaires.java
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

import java.io.*;

/**
 * Classe filtrant tous les commentaires /* et // d'un flux de caracteres.
 */
public class FiltreCommentaires extends FilterReader
{
  // Champ utilise pour memoriser le caractere qui suit le caractere slash
  private int caractereSuivant = -1;
  private static char RETOUR_A_LA_LIGNE = System.getProperty("line.separator").charAt(0);

  // Constructeur repassant le flux en entree a la super classe FilterReader
  public FiltreCommentaires(Reader fluxLecture)
  {
    super(fluxLecture);
  }

  // Redefinition de la methode read eliminant les commentaires des caracteres renvoyes
  public int read() throws IOException
  {
    // Recuperation du caractere suivant
    int c;
    if (this.caractereSuivant == -1)
      c = super.read();
    else
    {
      c = this.caractereSuivant;
      this.caractereSuivant = -1;
    }
    // Si le caractere est un slash, lecture et test du caractere suivant
    if (c == '/')
    {
      int caractereSuivant = super.read();
      switch (caractereSuivant)
      {
        case '/' : c = passerCommentaireSlashSlash();
                   break;
        case '*' : c = passerCommentaireSlashEtoile();
                   break;
        default  : // Si les deux caracteres lus ne sont pas le debut d'un commentaire,
                   // le caractere suivant est memorise pour le prochain appel a read
                   this.caractereSuivant = caractereSuivant;
                   break;
      }
    }
    return c;
  }

  // Redefinition de la methode read utilisant un tableau de caracteres
  public int read(char buffer[], int offset, int length) throws IOException
  {
    // Lecture du prochain caractere
    int c = read();
    // Si la fin est atteinte on renvoie -1
    if (c == -1)
      return -1;
    // Remplissage du tableau a partir de l'indice offset
    int i = offset;
    do
    {
      buffer[i++] = (char)c;
      c = read();
    }
    while (i < length && c != -1);
    // Renvoie le nombre de caracteres lus
    return i - offset;
  }

  private int passerCommentaireSlashSlash() throws IOException
  {
    // Lecture de tous les caracteres jusqu'au premier caractere de retour a la ligne
    int c;
    do
      c = super.read();
    while (c != -1 && c != RETOUR_A_LA_LIGNE);
    return c;
  }

  private int passerCommentaireSlashEtoile() throws IOException
  {
    int c;
    // Lecture de tous les caracteres jusqu'aux caracteres */
    do
    {
      do
        c = super.read();
      while (c != -1 && c != '*');
      c = super.read();
    }
    while (c != -1 && c != '/');
    return super.read();
  }
}
