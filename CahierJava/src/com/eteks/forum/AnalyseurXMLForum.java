/*
 * Fichier com/eteks/forum/AnalyseurXMLForum.java
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

import java.io.*;
import java.util.*;
import javax.xml.parsers.*;
import javax.xml.bind.DatatypeConverter;
import org.w3c.dom.*;
import org.xml.sax.SAXException;

/**
 * Gestionnaire XML des messages et des utilisateurs.
 */
public class AnalyseurXMLForum
{
  /**
   * Renvoie le document DOM correspondant au document XML lu dans le flux
   * de lecture en parametre.
   */
  public Document lireXML(InputStream fluxLecture) throws IOException
  {
    try
    {
      // Instanciation d'une factory d'analyseurs DOM
      DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
      // Instanciation d'un analyseur DOM
      DocumentBuilder builder = factory.newDocumentBuilder();
      // Analyse du document XML
      Document document = builder.parse(fluxLecture);
      return document;
    }
    catch (ParserConfigurationException | SAXException ex) 
    {
      throw new IOException(ex.getMessage(), ex);
    }
    finally
    {
      // Fermeture du flux de lecture
      fluxLecture.close();
    }
  }

  /**
   * Renvoie l'ensemble des utilisateurs correspondant au document XML lu dans le flux
   * de lecture en parametre.
   */
  public Set<Utilisateur> lireUtilisateursXML(InputStream fluxLecture) throws IOException
  {
    Document document = lireXML(fluxLecture);
    Set<Utilisateur> utilisateurs = new HashSet<>();
    // Recherche des elements du document denommes utilisateur
    NodeList elements = document.getElementsByTagName("utilisateur");
    for (int i = 0; i < elements.getLength(); i++)
      // Ajout a l'ensemble de l'utilisateur correspondant a l'element enfant d'indice i
      utilisateurs.add(lireUtilisateurDOM((Element)elements.item(i)));
    return utilisateurs;
  }

  /**
   * Renvoie l'utilisateur correspondant a l'element DOM en parametre.
   */
  public UtilisateurForum lireUtilisateurDOM(Element element)
  {
    UtilisateurForum utilisateur = new UtilisateurForum();
    // Modification des proprietes de l'utilisateur avec les
    // attributs pseudonyme, motDePasse et autorisation de l'element en parametre
    utilisateur.setPseudonyme(element.getAttribute("pseudonyme"));
    String motDePasse = element.getAttribute("motDePasse");
    if (motDePasse.length() > 0)
      utilisateur.setMotDePasse(motDePasse);
    String autorisation = element.getAttribute("autorisation");
    if (!autorisation.equals("null"))
      utilisateur.setAutorisation(Autorisation.valueOf(autorisation));
    return utilisateur;
  }

  /**
   * Renvoie l'ensemble des messages correspondant au document XML lu dans le flux
   * de lecture en parametre.
   */
  public EnsembleMessagesForum lireMessagesXML(InputStream fluxLecture) throws IOException
  {
    Document document = lireXML(fluxLecture);
    EnsembleMessagesForum messages = new EnsembleMessagesForum();
    // Recherche des elements du document denommes message
    NodeList elements = document.getElementsByTagName("message");
    for (int i = 0; i < elements.getLength(); i++)
      // Ajout a l'ensemble du message correspondant a l'element enfant d'indice i
      messages.ajouter(lireMessageDOM((Element)elements.item(i)));
    return messages;
  }

  /**
   * Renvoie le message correspondant a l'element DOM en parametre.
   */
  public MessageForum lireMessageDOM(Element element)
  {
    MessageForum message = new MessageForum();
    // Modification des proprietes du message avec les
    // attributs id, dateCreation, sujet et auteur de l'element en parametre
    String id = element.getAttribute("id");
    if (id.length() > 0)
      message.setId(Integer.parseInt(id));
    String date = element.getAttribute("dateCreation");
    message.setDateCreation(DatatypeConverter.parseDateTime(date).getTime());
    message.setSujet(element.getAttribute("sujet"));
    message.setAuteur(element.getAttribute("auteur"));
    // Modification de la propriete texte avec les donnees de l'element en parametre
    Text donneesTexte = (Text)element.getFirstChild();
    message.setTexte(donneesTexte.getData());
    return message;
  }
}
