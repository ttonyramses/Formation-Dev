INSERT INTO `personne`(id, nom,prenom,adresse,naissance) VALUES (1,'Tafeumewe','Tony','Rouen','2016-08-26');
INSERT INTO `personne`(id, nom,prenom,adresse,naissance) VALUES (2,'Storero','Nicolas','Montrouge','2016-08-26');
INSERT INTO `compte`(numero,libelle,id_personne) VALUES (1,'Compte Courant',1);
INSERT INTO `compte`(numero,libelle,id_personne) VALUES (2,'Compte Courant',1);
INSERT INTO `compte`(numero,libelle,id_personne) VALUES (3,'Compte Courant',1);
INSERT INTO `operation`(id, montant, type,numero_compte) VALUES (1,'1000.00','Cr�dit',1);
INSERT INTO `operation`(id, montant, type,numero_compte) VALUES (2,'20.99','D�bit',1);
INSERT INTO `operation`(id, montant, type,numero_compte) VALUES (3,'500.00','Virement',1);
INSERT INTO `operation`(id, montant, type,numero_compte) VALUES (4,'498.50','D�bit',1);
INSERT INTO `operation`(id, montant, type,numero_compte) VALUES (5,'1000.00','Cr�dit',2);
INSERT INTO `operation`(id, montant, type,numero_compte) VALUES (6,'20.99','D�bit',2);
INSERT INTO `operation`(id, montant, type,numero_compte) VALUES (7,'500.00','Virement',2);
INSERT INTO `operation`(id, montant, type,numero_compte) VALUES (8,'498.50','D�bit',2);
