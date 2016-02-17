/*
 * Fichier com/eteks/forum/AppletChat.java
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

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.net.*;
import java.io.*;
import java.util.*;
import java.text.*;

/**
 * Applet de chat.
 */
public class AppletChat extends JApplet
{
  private JTextArea   texteMessages = new JTextArea();
  private JScrollPane panneauAscenseur =
                         new JScrollPane(texteMessages);
  private JLabel labelMessage  =
                         new JLabel("En cours de connexion...");
  private JTextField saisieMessage = new JTextField(50);
  private DateFormat formatHeure = DateFormat.getTimeInstance();
  private AnalyseurXMLForum analyseurXML = new AnalyseurXMLForum();

  private boolean arretApplet;

  @Override
  public void init()
  {
    // Le champ de saisie multilignes texteMessages est rendu ineditable
    // et met a la ligne automatiquement les phrases qui depassent la largeur du composant
    this.texteMessages.setEditable(false);
    this.texteMessages.setLineWrap(true);
    this.texteMessages.setWrapStyleWord(true);

    JPanel panneauSaisie = new JPanel(new BorderLayout());
    // Ajout du label et du champ de saisie du message au panneau de saisie
    panneauSaisie.add(this.labelMessage, BorderLayout.WEST);
    panneauSaisie.add(this.saisieMessage, BorderLayout.CENTER);
    // Le champ de saisie n'est pas visible tant que la connexion n'est pas etablie
    saisieMessage.setVisible(false);
    // Utilisation pour l'applet d'un layout de classe BorderLayout
    setLayout(new BorderLayout(0, 5));
    // Ajout du panneau a ascenseurs au centre
    // et du panneau de saisie en bas
    add(panneauAscenseur, BorderLayout.CENTER);
    add(panneauSaisie, BorderLayout.SOUTH);
    // Ajout du listener au champ de saisie
    saisieMessage.addActionListener(new ActionListener()
      {
        public void actionPerformed(ActionEvent ev)
        {
          // Recuperation du texte saisi sans les espaces au debut et a la fin
          String texteSaisi = saisieMessage.getText().trim();
          // Envoi du texte saisi si sa longueur n'est pas nulle
          if (texteSaisi.length() > 0)
            envoyerMessage(texteSaisi);
          // Suppression du texte saisi dans le champ de saisie
          saisieMessage.setText("");
        }
      });
  }

  public void afficherMessage(String message)
  {
    this.texteMessages.append(message + "\n");
    this.panneauAscenseur.getVerticalScrollBar().
                                  setValue(Integer.MAX_VALUE);
  }

  public void afficherErreur(String message)
  {
    // Annonce d'un probleme a l'utilisateur et effacement du champ de saisie
    this.labelMessage.setText(message);
    this.saisieMessage.setVisible(false);
    this.arretApplet = true;
  }

  public void annoncerArrivee() throws IOException
  {
    lancerRequete(getParameter("annoncerArrivee"));
  }

  public void lireParticipants() throws IOException
  {
    // Connexion a la page JSP qui renvoie la liste des participants
    InputStream fluxLecture = connecter(getParameter("lireParticipants"));
    Set<Utilisateur> utilisateurs =
        analyseurXML.lireUtilisateursXML(fluxLecture);

    String message = "Participants du chat :";
    for (Utilisateur utilisateur : utilisateurs)
      message += " " + utilisateur.getPseudonyme();

    afficherMessage(message);
  }

  public void lireMessages() throws IOException
  {
    try
    {
      for (arretApplet = false; !arretApplet; )
      {
        InputStream fluxLecture = connecter(getParameter("lireMessages"));
        afficherMessagesXML(fluxLecture);
        Thread.sleep(1000);
      }
    }
    catch (InterruptedException ex)
    {
    }
  }

  public void afficherMessagesXML(InputStream fluxLecture)
                                          throws IOException
  {
    EnsembleMessagesForum messages = 
        analyseurXML.lireMessagesXML(fluxLecture);
    for (MessageForum message : messages)
    {
      String messageAffiche = formatHeure.format(message.getDateCreation())
                              + " - " + message.getAuteur()
                              + " : " + message.getTexte();
      afficherMessage(messageAffiche);
    }
  }

  public void envoyerMessage(final String message)
  {
    Thread threadEnvoiMessage = new Thread()
      {
        public void run()
        {
          try
          {
            // Construction de l'URL d'envoi de message avec le texte du message
            String ajouterMessageAvecTexte =
                 getParameter("ajouterMessage") + "?texte="
                 + URLEncoder.encode(message, "ISO-8859-1");
            lancerRequete(ajouterMessageAvecTexte);
          }
          catch (IOException ex)
          {
            afficherErreur("Envoi du message impossible");
          }
        }
      };
    threadEnvoiMessage.start();
  }

  public void annoncerDepart() throws IOException
  {
    lancerRequete(getParameter("annoncerDepart"));
  }

  public void lancerRequete(String urlRelative) throws IOException
  {
    InputStream fluxLecture = connecter(urlRelative);
    fluxLecture.close();
  }

  public InputStream connecter(String urlRelative) throws IOException
  {
    URL url = new URL(getDocumentBase(), urlRelative);
    return url.openStream();
  }

  @Override
  public void start()
  {
    Thread threadApplet = new Thread()
      {
        public void run()
        {
          try
          {
            annoncerArrivee();
            labelMessage.setText("Message : ");
            // Affichage du champ de saisie
            saisieMessage.setVisible(true);
            lireParticipants();
            lireMessages();
          }
          catch (IOException ex)
          {
            afficherErreur("Acc\u00e8s impossible au serveur");
          }
        }
      };
    threadApplet.start();
  }

  @Override
  public void stop()
  {
    this.arretApplet = true;
    try
    {
      annoncerDepart();
    }
    catch (IOException ex)
    {
      // Annoncer l'erreur a l'utilisateur est inutile puisque l'applet n'est plus a l'ecran
      ex.printStackTrace();
    }
  }
}
