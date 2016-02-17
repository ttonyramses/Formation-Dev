/*
 * Fichier com/eteks/test/TestServiceFinal.java
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

import com.eteks.outils.Service;

class TestServiceFinal
{
  public static void main(String [] args)
  {
    // La variable serviceFraisDeplacement est final et ne peut etre modifiee
    final Service serviceFraisDeplacement =
                    new Service("Frais de d\u00e9placement", 28.15f);
    // mais l'objet designe par serviceFraisDeplacement peut etre modifie !
    serviceFraisDeplacement.setPrix(29.55f);
    // L'objet designe par serviceFraisDeplacement a un prix de 29.55 Euro
  }
}
