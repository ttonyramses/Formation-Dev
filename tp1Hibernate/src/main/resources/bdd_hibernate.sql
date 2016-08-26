
DROP DATABASE bdd_hibernate;
CREATE DATABASE IF NOT EXISTS bdd_hibernate;
USE bdd_hibernate;


drop table if exists personne;
create table personne (

 id int(10) unsigned not null auto_increment,
 nom varchar (50) not null,
 prenom varchar(50) not null,
 adresse varchar(100) not null,
 naissance date not null,
 
 primary key (id)

 ) ENGINE=InnoDB default charset=latin1;

 
drop table if exists compte;
create table compte (
 numero int(10) unsigned not null auto_increment,
 libelle varchar (50) not null,
 id_personne int(10) unsigned not null,

 primary key (numero),
 key FK_compte_personne (id_personne),

 constraint FK_compte_personne FOREIGN Key (id_personne) REFERENCES personne(id)
 
 ) ENGINE=InnoDB default charset=latin1;
 

drop table if exists operation;
create table operation (

 id int(10) unsigned not null auto_increment,
 montant decimal(8,2) not null,
type varchar(50) not null,
numero_compte int(10) unsigned not null,

primary key (id),
key FK_operation_compte (numero_compte),
 constraint FK_operation_compte FOREIGN Key (numero_compte) REFERENCES compte(numero)
 ) ENGINE=InnoDB default charset=latin1;