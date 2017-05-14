drop table Ligne;
drop table Commande;
drop table Produit;
drop table Utilisateur;

create table Utilisateur
(
idUtilisateur decimal(20),
nom varchar(50),
prenom varchar(50),
motDePasse varchar(50),
adresse varchar(200),
telephone decimal(10),
mail varchar(100),
idCompte decimal,
constraint pk_Utilisateur primary key (idUtilisateur)
);

create table Produit (
idProduit decimal(20),
nomProduit varchar(50),
libProduit varchar(100),
prix decimal(6,2),
stock int,
constraint pk_Produit primary key (idProduit),
constraint ck_Produit_stock check (stock >=0)
);

create table Commande (
idCommande decimal(20),
dateCommande date,
montantCommande decimal(6,2),
idUtilisateur decimal(20),
etatCommande varchar(11),
constraint pk_Commande primary key (idCommande),
constraint fk_Commande_idUtilisateur foreign key (idUtilisateur) references Utilisateur(idUtilisateur),
constraint ck_Commande_etat check (etatCommande in ('En cours','Validée','Préparation','Expédiée','Livrée','Annulé'))
);

create table Ligne (
idLigne decimal(20),
quantite decimal(3),
idProduit decimal(20),
idCommande decimal(20),
constraint pk_Ligne primary key (idLigne),
constraint fk_Ligne_idProduit foreign key (idProduit) references Produit(idProduit),
constraint fk_Ligne_idCommande foreign key (idCommande) references Commande(idCommande)
);


--TABLE Utilisateur
insert into Utilisateur values (1,'Pillard','Nolwenn','mdp1','adr1',0601020304,'mail1',1);
insert into Utilisateur values (2,'Sutarik','Marine','mdp2','adr2',0605060708,'mail2',2);
insert into Utilisateur values (3,'Rigal','Anaïs','mdp3','adr3',0609101112,'mail3',3);
insert into Utilisateur values (4,'Aztakès','Hélène','mdp4','adr4',0613141516,'mail4',4);


--TABLE Produit
insert into Produit values (1,'Aspirateur','Mieux qu''un balai',29.90,10);
insert into Produit values (2,'Livre','Bon pour la culture',15.50,0);
insert into Produit values (3,'Nintendo Switch','Super console',330.0,20);
insert into Produit values (4,'Télévision 4K','Pratique pour regarder des films',899.90,30);


--TABLE Commande
insert into Commande values (1,'05/05/2017',45.40,1,'En cours'); --aspirateur + livre
insert into Commande values (2,'01/05/2017',345.50,2,'Validée'); -- livre + console
insert into Commande values (3,'02/05/2017',915.40,3,'Préparation'); -- livre + télé
insert into Commande values (4,'03/05/2017',1275.30,4,'Livrée'); -- tout


--TABLE Ligne idLigne, quantite, idProduit, idCommande
--Commande 1
insert into Ligne values (1,1,1,1);
insert into Ligne values (2,1,2,1);

--Commande 2
insert into Ligne values (3,1,2,2);
insert into Ligne values (4,1,3,2);

--Commande 3
insert into Ligne values (5,1,2,3);
insert into Ligne values (6,1,4,3);

--Commande 4
insert into Ligne values (7,1,1,4);
insert into Ligne values (8,1,2,4);
insert into Ligne values (9,1,3,4);
insert into Ligne values (10,1,4,4);