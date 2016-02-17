/*
 * Fichier com/eteks/outils/ChargeurRessource.java
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

import javax.swing.ImageIcon;

/**
 * Chargeur de ressources relatives au classpath.
 * Exemple d'utilisation :
 * <pre>  ChargeurRessource chargeur = new ChargeurRessource("/com/eteks/images/");
 *  // Creation d'une icone avec l'image de la ressource /com/eteks/images/test.jpg
 *  ImageIcon icone = chargeur.getIcon("test.jpg");</pre>
 */
public class ChargeurRessource
{
  private String base;

  /**
   * Initialise un chargeur de ressources avec base comme chemin relatif des ressources.
   * @param base  un chemin d'acces.
   */
  public ChargeurRessource(String base)
  {
    this.base = base;
  }

  public ChargeurRessource()
  {
    this("");
  }

  /**
   * Renvoie l'icone du fichier icon relatif a la base.
   */
  public ImageIcon getIcon(String icon)
  {
    Class classe = getClass();
    return new ImageIcon(classe.getResource(this.base + icon));
  }
}
