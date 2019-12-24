-- create classes
INSERT INTO CLASSE (ID, LIBEL, NOM_COMPLET ) VALUES ( 1, 'glsi-a', 'CII-GLSI-A');
INSERT INTO CLASSE (ID, LIBEL, NOM_COMPLET ) VALUES ( 2, 'glsi-b', 'CII-GLSI-B');

-- create some student
INSERT INTO ETUDIANT ( MATRICULE , NOM , PRENOM ,EMAIL , DATE_DE_NAISSANCE, CLASSE_ID , PHONE_NUMBER ) VALUES ( '00000','hmaier'  ,'ahmed'    , /**/'ahmed.hmayer@gmail.com','1990-10-02', 2 , '+21627119665');
INSERT INTO ETUDIANT ( MATRICULE , NOM , PRENOM ,EMAIL , DATE_DE_NAISSANCE, CLASSE_ID , PHONE_NUMBER ) VALUES ( '00001','torkani' ,'malik'    , /**/'ahmed.hmayer@gmail.com','1991-11-27', 2 , '27119665' );
INSERT INTO ETUDIANT ( MATRICULE , NOM , PRENOM ,EMAIL , DATE_DE_NAISSANCE, CLASSE_ID , PHONE_NUMBER ) VALUES ( '00002','moadeb'  ,'tarek'    , /**/'ahmed.hmayer@gmail.com','1992-12-15', 2 , '27119665' );
INSERT INTO ETUDIANT ( MATRICULE , NOM , PRENOM ,EMAIL , DATE_DE_NAISSANCE, CLASSE_ID , PHONE_NUMBER ) VALUES ( '00003','nasri'   ,'hatem'    , /**/'ahmed.hmayer@gmail.com','1993-01-20', 2 , '27119665' );
INSERT INTO ETUDIANT ( MATRICULE , NOM , PRENOM ,EMAIL , DATE_DE_NAISSANCE, CLASSE_ID , PHONE_NUMBER ) VALUES ( '00004','tlili'   ,'lynn'     , 'ahmed.hmayer@gmail.com','1994-02-10', 2 , '27119665' );
INSERT INTO ETUDIANT ( MATRICULE , NOM , PRENOM ,EMAIL , DATE_DE_NAISSANCE, CLASSE_ID , PHONE_NUMBER ) VALUES ( '00005','hatour'  ,'amel'     , 'ahmed.hmayer@gmail.com','1994-02-10', 2 , '27119665' );
INSERT INTO ETUDIANT ( MATRICULE , NOM , PRENOM ,EMAIL , DATE_DE_NAISSANCE, CLASSE_ID , PHONE_NUMBER ) VALUES ( '00006','madyouni','ghassen'  , 'madyouni.ghassen@gmail.com','1994-02-10', 2 , '27119665' );
INSERT INTO ETUDIANT ( MATRICULE , NOM , PRENOM ,EMAIL , DATE_DE_NAISSANCE, CLASSE_ID , PHONE_NUMBER ) VALUES ( '00007','chahbi'  ,'ali'      , 'chahbi.ali@gmail.com','1994-02-10', 2 , '27119665' );
INSERT INTO ETUDIANT ( MATRICULE , NOM , PRENOM ,EMAIL , DATE_DE_NAISSANCE, CLASSE_ID , PHONE_NUMBER ) VALUES ( '00008','kamoun'  ,'sabrin'   , 'kamoun.sabrine@gmail.com','1994-02-10', 2 , '27119665' );
INSERT INTO ETUDIANT ( MATRICULE , NOM , PRENOM ,EMAIL , DATE_DE_NAISSANCE, CLASSE_ID , PHONE_NUMBER ) VALUES ( '00009','grami'   ,'moez'     , 'grami.moez@gmail.com','1994-02-10', 2 , '27119665' );
INSERT INTO ETUDIANT ( MATRICULE , NOM , PRENOM ,EMAIL , DATE_DE_NAISSANCE, CLASSE_ID , PHONE_NUMBER ) VALUES ( '00010','daouda'  ,'abdo'     , /**/'ahmed.hmayer@gmail.com','1994-02-10', 2 , '27119665' );
INSERT INTO ETUDIANT ( MATRICULE , NOM , PRENOM ,EMAIL , DATE_DE_NAISSANCE, CLASSE_ID , PHONE_NUMBER ) VALUES ( '00011','belaid'  ,'saief'    , 'belaid.saied@gmail.com','1994-02-10', 2  , '27119665' );
INSERT INTO ETUDIANT ( MATRICULE , NOM , PRENOM ,EMAIL , DATE_DE_NAISSANCE, CLASSE_ID , PHONE_NUMBER ) VALUES ( '00012','makhlouf','wajdi'    , 'makhlouf.wajdi@gmail.com','1994-02-10', 2 , '27119665' );
INSERT INTO ETUDIANT ( MATRICULE , NOM , PRENOM ,EMAIL , DATE_DE_NAISSANCE, CLASSE_ID , PHONE_NUMBER ) VALUES ( '00013','kilani'  ,'raniya'   , 'raniya.kilani@gmail.com','1994-02-10', 2 , '27119665' );
INSERT INTO ETUDIANT ( MATRICULE , NOM , PRENOM ,EMAIL , DATE_DE_NAISSANCE, CLASSE_ID , PHONE_NUMBER ) VALUES ( '00014','Rabi'  ,'jammeli'   , 'jemmeli.rabii@gmail.com','1994-02-10', 2 , '99588138' );


INSERT INTO ETUDIANT ( MATRICULE , NOM , PRENOM ,EMAIL , DATE_DE_NAISSANCE, CLASSE_ID , PHONE_NUMBER ) VALUES ( '00025','test 1','test 1'   , 'test@gmail.com','1994-02-10', 1 , '27119665' );
INSERT INTO ETUDIANT ( MATRICULE , NOM , PRENOM ,EMAIL , DATE_DE_NAISSANCE, CLASSE_ID , PHONE_NUMBER ) VALUES ( '00026','test 1','raniya'   , 'test@gmail.com','1994-02-10', 1 , '27119665' );



--
-- -- create 13 modules
INSERT INTO MATIERE (ID, LIBEL, NUMBER_HOURS , PERMIT ) VALUES ( 1, 'Programmation JEE', 41 , 15 );
INSERT INTO MATIERE (ID, LIBEL, NUMBER_HOURS , PERMIT ) VALUES ( 2, 'Algorithme avancé', 41 , 15 );
INSERT INTO MATIERE (ID, LIBEL, NUMBER_HOURS , PERMIT ) VALUES ( 3, 'Base de données avancé', 31.5 , 12 );
INSERT INTO MATIERE (ID, LIBEL, NUMBER_HOURS , PERMIT ) VALUES ( 4, 'Design pattern', 31.5 , 12 );
INSERT INTO MATIERE (ID, LIBEL, NUMBER_HOURS , PERMIT ) VALUES ( 5, 'Developpement Web', 41 , 15 );
INSERT INTO MATIERE (ID, LIBEL, NUMBER_HOURS , PERMIT ) VALUES ( 6, 'intelligence artificiel', 21 , 7 );
INSERT INTO MATIERE (ID, LIBEL, NUMBER_HOURS , PERMIT ) VALUES ( 7, 'complexité des algorithme', 21 , 7 );
INSERT INTO MATIERE (ID, LIBEL, NUMBER_HOURS , PERMIT ) VALUES ( 8, 'Traitement dimage', 21 , 7 );
INSERT INTO MATIERE (ID, LIBEL, NUMBER_HOURS , PERMIT ) VALUES ( 9, 'technique de communication', 21 , 7 );
INSERT INTO MATIERE (ID, LIBEL, NUMBER_HOURS , PERMIT ) VALUES ( 10, 'englais de communication', 21 , 7 );
INSERT INTO MATIERE (ID, LIBEL, NUMBER_HOURS , PERMIT ) VALUES ( 11, 'approch Agile', 21 , 7 );
INSERT INTO MATIERE (ID, LIBEL, NUMBER_HOURS , PERMIT ) VALUES ( 12, 'droit de lentreprise', 21 , 7 );
INSERT INTO MATIERE (ID, LIBEL, NUMBER_HOURS , PERMIT ) VALUES ( 13, 'Projet', 41 , 41 );


-- -- -- affect modules to a class glsi-a
-- INSERT INTO CLASSE_MATIERE ( CLASSE_ID , MATIERE_ID ) VALUES ( 1, 1 );
-- INSERT INTO CLASSE_MATIERE ( CLASSE_ID , MATIERE_ID ) VALUES ( 1, 2 );
-- INSERT INTO CLASSE_MATIERE ( CLASSE_ID , MATIERE_ID ) VALUES ( 1, 3 );
-- INSERT INTO CLASSE_MATIERE ( CLASSE_ID , MATIERE_ID ) VALUES ( 1, 4 );
-- INSERT INTO CLASSE_MATIERE ( CLASSE_ID , MATIERE_ID ) VALUES ( 1, 5 );
-- INSERT INTO CLASSE_MATIERE ( CLASSE_ID , MATIERE_ID ) VALUES ( 1, 6 );
-- INSERT INTO CLASSE_MATIERE ( CLASSE_ID , MATIERE_ID ) VALUES ( 1, 7 );
-- INSERT INTO CLASSE_MATIERE ( CLASSE_ID , MATIERE_ID ) VALUES ( 1, 8 );
-- INSERT INTO CLASSE_MATIERE ( CLASSE_ID , MATIERE_ID ) VALUES ( 1, 9 );
-- INSERT INTO CLASSE_MATIERE (ICLASSE_ID , MATIERE_ID ) VALUES (  1, 10 );
-- INSERT INTO CLASSE_MATIERE (ICLASSE_ID , MATIERE_ID ) VALUES (  1, 11 );
-- INSERT INTO CLASSE_MATIERE (ICLASSE_ID , MATIERE_ID ) VALUES (  1, 12 );
-- INSERT INTO CLASSE_MATIERE (ICLASSE_ID , MATIERE_ID ) VALUES (  1, 13 );
--
-- -- affect modules to a class glsi-b
-- INSERT INTO CLASSE_MATIERE (CLASSE_ID , MATIERE_ID ) VALUES ( 2, 1 );
-- INSERT INTO CLASSE_MATIERE (CLASSE_ID , MATIERE_ID ) VALUES ( 2, 2 );
-- INSERT INTO CLASSE_MATIERE (CLASSE_ID , MATIERE_ID ) VALUES ( 2, 3 );
-- INSERT INTO CLASSE_MATIERE (CLASSE_ID , MATIERE_ID ) VALUES ( 2, 4 );
-- INSERT INTO CLASSE_MATIERE (CLASSE_ID , MATIERE_ID ) VALUES ( 2, 5 );
-- INSERT INTO CLASSE_MATIERE (CLASSE_ID , MATIERE_ID ) VALUES ( 2, 6 );
-- INSERT INTO CLASSE_MATIERE (CLASSE_ID , MATIERE_ID ) VALUES ( 2, 7 );
-- INSERT INTO CLASSE_MATIERE (CLASSE_ID , MATIERE_ID ) VALUES ( 2, 8 );
-- INSERT INTO CLASSE_MATIERE (CLASSE_ID , MATIERE_ID ) VALUES ( 2, 9 );
-- INSERT INTO CLASSE_MATIERE (CLASSE_ID , MATIERE_ID ) VALUES ( 2, 10 );
-- INSERT INTO CLASSE_MATIERE (CLASSE_ID , MATIERE_ID ) VALUES ( 2, 11 );
-- INSERT INTO CLASSE_MATIERE (CLASSE_ID , MATIERE_ID ) VALUES ( 2, 12 );
-- INSERT INTO CLASSE_MATIERE (CLASSE_ID , MATIERE_ID ) VALUES ( 2, 13 );


-- CLASSE_MATIERE HAS AN EMBEDDED PRIMARY KEY
-- -- affect modules to a class glsi-a
INSERT INTO CLASSE_MATIERE ( CLASSE_ID , MATIERE_ID ) VALUES ( 1, 1 );
INSERT INTO CLASSE_MATIERE ( CLASSE_ID , MATIERE_ID ) VALUES ( 1, 2 );
INSERT INTO CLASSE_MATIERE ( CLASSE_ID , MATIERE_ID ) VALUES ( 1, 3 );
INSERT INTO CLASSE_MATIERE ( CLASSE_ID , MATIERE_ID ) VALUES ( 1, 4 );
INSERT INTO CLASSE_MATIERE ( CLASSE_ID , MATIERE_ID ) VALUES ( 1, 5 );
INSERT INTO CLASSE_MATIERE ( CLASSE_ID , MATIERE_ID ) VALUES ( 1, 6 );
INSERT INTO CLASSE_MATIERE ( CLASSE_ID , MATIERE_ID ) VALUES ( 1, 7 );
INSERT INTO CLASSE_MATIERE ( CLASSE_ID , MATIERE_ID ) VALUES ( 1, 8 );
INSERT INTO CLASSE_MATIERE ( CLASSE_ID , MATIERE_ID ) VALUES ( 1, 9 );
INSERT INTO CLASSE_MATIERE ( CLASSE_ID , MATIERE_ID ) VALUES (  1, 10 );
INSERT INTO CLASSE_MATIERE ( CLASSE_ID , MATIERE_ID ) VALUES (  1, 11 );
INSERT INTO CLASSE_MATIERE ( CLASSE_ID , MATIERE_ID ) VALUES (  1, 12 );
INSERT INTO CLASSE_MATIERE ( CLASSE_ID , MATIERE_ID ) VALUES (  1, 13 );

-- affect modules to a class glsi-b
INSERT INTO CLASSE_MATIERE (CLASSE_ID , MATIERE_ID ) VALUES ( 2, 1 );
INSERT INTO CLASSE_MATIERE (CLASSE_ID , MATIERE_ID ) VALUES ( 2, 2 );
INSERT INTO CLASSE_MATIERE (CLASSE_ID , MATIERE_ID ) VALUES ( 2, 3 );
INSERT INTO CLASSE_MATIERE (CLASSE_ID , MATIERE_ID ) VALUES ( 2, 4 );
INSERT INTO CLASSE_MATIERE (CLASSE_ID , MATIERE_ID ) VALUES ( 2, 5 );
INSERT INTO CLASSE_MATIERE (CLASSE_ID , MATIERE_ID ) VALUES ( 2, 6 );
INSERT INTO CLASSE_MATIERE (CLASSE_ID , MATIERE_ID ) VALUES ( 2, 7 );
INSERT INTO CLASSE_MATIERE (CLASSE_ID , MATIERE_ID ) VALUES ( 2, 8 );
INSERT INTO CLASSE_MATIERE (CLASSE_ID , MATIERE_ID ) VALUES ( 2, 9 );
INSERT INTO CLASSE_MATIERE (CLASSE_ID , MATIERE_ID ) VALUES ( 2, 10 );
INSERT INTO CLASSE_MATIERE (CLASSE_ID , MATIERE_ID ) VALUES ( 2, 11 );
INSERT INTO CLASSE_MATIERE (CLASSE_ID , MATIERE_ID ) VALUES ( 2, 12 );
INSERT INTO CLASSE_MATIERE (CLASSE_ID , MATIERE_ID ) VALUES ( 2, 13 );

-- some abscence to me xD all of them in the same date
INSERT INTO ABSCENCE (ID, DATE, MATIERE_ID, ETUDIANT_MATRICULE ) VALUES ( 1, '2019-09-09', 1, '00000');
INSERT INTO ABSCENCE (ID, DATE, MATIERE_ID, ETUDIANT_MATRICULE ) VALUES ( 2, '2019-09-09', 1, '00000');
INSERT INTO ABSCENCE (ID, DATE, MATIERE_ID, ETUDIANT_MATRICULE ) VALUES ( 3, '2019-09-09', 1, '00000');
INSERT INTO ABSCENCE (ID, DATE, MATIERE_ID, ETUDIANT_MATRICULE ) VALUES ( 4, '2019-09-09', 1, '00000');
INSERT INTO ABSCENCE (ID, DATE, MATIERE_ID, ETUDIANT_MATRICULE ) VALUES ( 5, '2019-09-09', 1, '00000');
INSERT INTO ABSCENCE (ID, DATE, MATIERE_ID, ETUDIANT_MATRICULE ) VALUES ( 6, '2019-09-09', 1, '00000');
INSERT INTO ABSCENCE (ID, DATE, MATIERE_ID, ETUDIANT_MATRICULE ) VALUES ( 7, '2019-09-09', 1, '00000');
INSERT INTO ABSCENCE (ID, DATE, MATIERE_ID, ETUDIANT_MATRICULE ) VALUES ( 8, '2019-09-09', 1, '00000');
INSERT INTO ABSCENCE (ID, DATE, MATIERE_ID, ETUDIANT_MATRICULE ) VALUES ( 9, '2019-09-09', 1, '00000');
INSERT INTO ABSCENCE (ID, DATE, MATIERE_ID, ETUDIANT_MATRICULE ) VALUES ( 10, '2019-09-09', 1, '00000');
INSERT INTO ABSCENCE (ID, DATE, MATIERE_ID, ETUDIANT_MATRICULE ) VALUES ( 11, '2019-09-09', 1, '00000');

--
--
-- -- some abscence to abdo design pattern
INSERT INTO ABSCENCE (ID, DATE, MATIERE_ID, ETUDIANT_MATRICULE ) VALUES ( 12, '2019-09-09', 4, '00010');
INSERT INTO ABSCENCE (ID, DATE, MATIERE_ID, ETUDIANT_MATRICULE ) VALUES ( 13, '2019-09-09', 4, '00010');
INSERT INTO ABSCENCE (ID, DATE, MATIERE_ID, ETUDIANT_MATRICULE ) VALUES ( 14, '2019-09-09', 4, '00010');
INSERT INTO ABSCENCE (ID, DATE, MATIERE_ID, ETUDIANT_MATRICULE ) VALUES ( 15, '2019-09-09', 4, '00010');
INSERT INTO ABSCENCE (ID, DATE, MATIERE_ID, ETUDIANT_MATRICULE ) VALUES ( 16, '2019-09-09', 4, '00010');
INSERT INTO ABSCENCE (ID, DATE, MATIERE_ID, ETUDIANT_MATRICULE ) VALUES ( 17, '2019-09-09', 4, '00010');
INSERT INTO ABSCENCE (ID, DATE, MATIERE_ID, ETUDIANT_MATRICULE ) VALUES ( 18, '2019-09-09', 4, '00010');
INSERT INTO ABSCENCE (ID, DATE, MATIERE_ID, ETUDIANT_MATRICULE ) VALUES ( 19, '2019-09-09', 4, '00010');
INSERT INTO ABSCENCE (ID, DATE, MATIERE_ID, ETUDIANT_MATRICULE ) VALUES ( 20, '2019-09-09', 4, '00010');
INSERT INTO ABSCENCE (ID, DATE, MATIERE_ID, ETUDIANT_MATRICULE ) VALUES ( 21, '2019-09-09', 4, '00010');
INSERT INTO ABSCENCE (ID, DATE, MATIERE_ID, ETUDIANT_MATRICULE ) VALUES ( 22, '2019-09-09', 4, '00010');

-- some abscence to Lynn agile
INSERT INTO ABSCENCE (ID, DATE, MATIERE_ID, ETUDIANT_MATRICULE ) VALUES ( 23, '2019-09-09', 11, '00004');
INSERT INTO ABSCENCE (ID, DATE, MATIERE_ID, ETUDIANT_MATRICULE ) VALUES ( 24, '2019-09-09', 11, '00004');
INSERT INTO ABSCENCE (ID, DATE, MATIERE_ID, ETUDIANT_MATRICULE ) VALUES ( 25, '2019-09-09', 11, '00004');
INSERT INTO ABSCENCE (ID, DATE, MATIERE_ID, ETUDIANT_MATRICULE ) VALUES ( 26, '2019-09-09', 11, '00004');
INSERT INTO ABSCENCE (ID, DATE, MATIERE_ID, ETUDIANT_MATRICULE ) VALUES ( 27, '2019-09-09', 11, '00004');
INSERT INTO ABSCENCE (ID, DATE, MATIERE_ID, ETUDIANT_MATRICULE ) VALUES ( 28, '2019-09-09', 11, '00004');

-- some abscence to Lynn agile
INSERT INTO ABSCENCE (ID, DATE, MATIERE_ID, ETUDIANT_MATRICULE ) VALUES ( 29, '2019-09-09', 6, '00004');
INSERT INTO ABSCENCE (ID, DATE, MATIERE_ID, ETUDIANT_MATRICULE ) VALUES ( 30, '2019-09-09', 6, '00004');
INSERT INTO ABSCENCE (ID, DATE, MATIERE_ID, ETUDIANT_MATRICULE ) VALUES ( 31, '2019-09-09', 6, '00004');
INSERT INTO ABSCENCE (ID, DATE, MATIERE_ID, ETUDIANT_MATRICULE ) VALUES ( 32, '2019-09-09', 6, '00004');
INSERT INTO ABSCENCE (ID, DATE, MATIERE_ID, ETUDIANT_MATRICULE ) VALUES ( 33, '2019-09-09', 6, '00004');
INSERT INTO ABSCENCE (ID, DATE, MATIERE_ID, ETUDIANT_MATRICULE ) VALUES ( 34, '2019-09-09', 6, '00004');


-- some abscence to Hatem web
INSERT INTO ABSCENCE (ID, DATE, MATIERE_ID, ETUDIANT_MATRICULE ) VALUES ( 35, '2019-09-09', 5, '00003');
INSERT INTO ABSCENCE (ID, DATE, MATIERE_ID, ETUDIANT_MATRICULE ) VALUES ( 36, '2019-09-09', 5, '00003');
INSERT INTO ABSCENCE (ID, DATE, MATIERE_ID, ETUDIANT_MATRICULE ) VALUES ( 37, '2019-09-09', 5, '00003');
INSERT INTO ABSCENCE (ID, DATE, MATIERE_ID, ETUDIANT_MATRICULE ) VALUES ( 38, '2019-09-09', 5, '00003');
INSERT INTO ABSCENCE (ID, DATE, MATIERE_ID, ETUDIANT_MATRICULE ) VALUES ( 39, '2019-09-09', 5, '00003');
INSERT INTO ABSCENCE (ID, DATE, MATIERE_ID, ETUDIANT_MATRICULE ) VALUES ( 40, '2019-09-09', 5, '00003');
INSERT INTO ABSCENCE (ID, DATE, MATIERE_ID, ETUDIANT_MATRICULE ) VALUES ( 41, '2019-09-09', 5, '00003');
INSERT INTO ABSCENCE (ID, DATE, MATIERE_ID, ETUDIANT_MATRICULE ) VALUES ( 42, '2019-09-09', 5, '00003');
INSERT INTO ABSCENCE (ID, DATE, MATIERE_ID, ETUDIANT_MATRICULE ) VALUES ( 43, '2019-09-09', 5, '00003');
INSERT INTO ABSCENCE (ID, DATE, MATIERE_ID, ETUDIANT_MATRICULE ) VALUES ( 44, '2019-09-09', 5, '00003');
INSERT INTO ABSCENCE (ID, DATE, MATIERE_ID, ETUDIANT_MATRICULE ) VALUES ( 45, '2019-09-09', 5, '00003');

-- some abscence to tarek web
INSERT INTO ABSCENCE (ID, DATE, MATIERE_ID, ETUDIANT_MATRICULE ) VALUES ( 46, '2019-09-09', 3, '00002');
INSERT INTO ABSCENCE (ID, DATE, MATIERE_ID, ETUDIANT_MATRICULE ) VALUES ( 47, '2019-09-09', 3, '00002');
INSERT INTO ABSCENCE (ID, DATE, MATIERE_ID, ETUDIANT_MATRICULE ) VALUES ( 48, '2019-09-09', 3, '00002');
INSERT INTO ABSCENCE (ID, DATE, MATIERE_ID, ETUDIANT_MATRICULE ) VALUES ( 49, '2019-09-09', 3, '00002');
INSERT INTO ABSCENCE (ID, DATE, MATIERE_ID, ETUDIANT_MATRICULE ) VALUES ( 50, '2019-09-09', 3, '00002');
INSERT INTO ABSCENCE (ID, DATE, MATIERE_ID, ETUDIANT_MATRICULE ) VALUES ( 51, '2019-09-09', 3, '00002');
INSERT INTO ABSCENCE (ID, DATE, MATIERE_ID, ETUDIANT_MATRICULE ) VALUES ( 52, '2019-09-09', 3, '00002');
INSERT INTO ABSCENCE (ID, DATE, MATIERE_ID, ETUDIANT_MATRICULE ) VALUES ( 53, '2019-09-09', 3, '00002');
INSERT INTO ABSCENCE (ID, DATE, MATIERE_ID, ETUDIANT_MATRICULE ) VALUES ( 54, '2019-09-09', 3, '00002');
INSERT INTO ABSCENCE (ID, DATE, MATIERE_ID, ETUDIANT_MATRICULE ) VALUES ( 55, '2019-09-09', 3, '00002');
INSERT INTO ABSCENCE (ID, DATE, MATIERE_ID, ETUDIANT_MATRICULE ) VALUES ( 56, '2019-09-09', 3, '00002');

-- some abscence to malik web
INSERT INTO ABSCENCE (ID, DATE, MATIERE_ID, ETUDIANT_MATRICULE ) VALUES ( 57, '2019-09-09', 3, '00001');
INSERT INTO ABSCENCE (ID, DATE, MATIERE_ID, ETUDIANT_MATRICULE ) VALUES ( 58, '2019-09-09', 3, '00001');
INSERT INTO ABSCENCE (ID, DATE, MATIERE_ID, ETUDIANT_MATRICULE ) VALUES ( 59, '2019-09-09', 3, '00001');
INSERT INTO ABSCENCE (ID, DATE, MATIERE_ID, ETUDIANT_MATRICULE ) VALUES ( 60, '2019-09-09', 3, '00001');
INSERT INTO ABSCENCE (ID, DATE, MATIERE_ID, ETUDIANT_MATRICULE ) VALUES ( 61, '2019-09-09', 3, '00001');
INSERT INTO ABSCENCE (ID, DATE, MATIERE_ID, ETUDIANT_MATRICULE ) VALUES ( 62, '2019-09-09', 3, '00001');
INSERT INTO ABSCENCE (ID, DATE, MATIERE_ID, ETUDIANT_MATRICULE ) VALUES ( 63, '2019-09-09', 3, '00001');
INSERT INTO ABSCENCE (ID, DATE, MATIERE_ID, ETUDIANT_MATRICULE ) VALUES ( 64, '2019-09-09', 3, '00001');
INSERT INTO ABSCENCE (ID, DATE, MATIERE_ID, ETUDIANT_MATRICULE ) VALUES ( 65, '2019-09-09', 3, '00001');
INSERT INTO ABSCENCE (ID, DATE, MATIERE_ID, ETUDIANT_MATRICULE ) VALUES ( 66, '2019-09-09', 3, '00001');
INSERT INTO ABSCENCE (ID, DATE, MATIERE_ID, ETUDIANT_MATRICULE ) VALUES ( 67, '2019-09-09', 3, '00001');

-- abs to rabii
INSERT INTO ABSCENCE (ID, DATE, MATIERE_ID, ETUDIANT_MATRICULE ) VALUES ( 68, '2019-09-09', 4, '00014');
INSERT INTO ABSCENCE (ID, DATE, MATIERE_ID, ETUDIANT_MATRICULE ) VALUES ( 69, '2019-09-09', 4, '00014');
INSERT INTO ABSCENCE (ID, DATE, MATIERE_ID, ETUDIANT_MATRICULE ) VALUES ( 70, '2019-09-09', 4, '00014');
INSERT INTO ABSCENCE (ID, DATE, MATIERE_ID, ETUDIANT_MATRICULE ) VALUES ( 71, '2019-09-09', 4, '00014');
INSERT INTO ABSCENCE (ID, DATE, MATIERE_ID, ETUDIANT_MATRICULE ) VALUES ( 72, '2019-09-09', 4, '00014');
INSERT INTO ABSCENCE (ID, DATE, MATIERE_ID, ETUDIANT_MATRICULE ) VALUES ( 73, '2019-09-09', 4, '00014');
INSERT INTO ABSCENCE (ID, DATE, MATIERE_ID, ETUDIANT_MATRICULE ) VALUES ( 74, '2019-09-09', 4, '00014');
INSERT INTO ABSCENCE (ID, DATE, MATIERE_ID, ETUDIANT_MATRICULE ) VALUES ( 75, '2019-09-09', 4, '00014');
INSERT INTO ABSCENCE (ID, DATE, MATIERE_ID, ETUDIANT_MATRICULE ) VALUES ( 76, '2019-09-09', 4, '00014');
INSERT INTO ABSCENCE (ID, DATE, MATIERE_ID, ETUDIANT_MATRICULE ) VALUES ( 77, '2019-09-09', 4, '00014');
INSERT INTO ABSCENCE (ID, DATE, MATIERE_ID, ETUDIANT_MATRICULE ) VALUES ( 78, '2019-09-09', 4, '00014');

insert into App_User (USER_ID, USER_NAME, ENCRYTED_PASSWORD, ENABLED)
values (2, 'user1', '$2a$10$PrI5Gk9L.tSZiW9FXhTS8O8Mz9E97k2FZbFvGFFaSsiTUIl.TCrFu', 1);

insert into App_User (USER_ID, USER_NAME, ENCRYTED_PASSWORD, ENABLED)
values (1, 'admin1', '$2a$10$PrI5Gk9L.tSZiW9FXhTS8O8Mz9E97k2FZbFvGFFaSsiTUIl.TCrFu', 1);

---

insert into app_role (ROLE_ID, ROLE_NAME)
values (1, 'ROLE_ADMIN');

insert into app_role (ROLE_ID, ROLE_NAME)
values (2, 'ROLE_USER');

---

insert into user_role (ID, USER_ID, ROLE_ID)
values (1, 1, 1);

insert into user_role (ID, USER_ID, ROLE_ID)
values (2, 1, 2);

insert into user_role (ID, USER_ID, ROLE_ID)
values (3, 2, 2);
---















-- SELECT * FROM ETUDIANT;
--
-- INSERT INTO CLASSE (ID, NAME) VALUES ( 1,' GLSI-A' );
-- INSERT INTO CLASSE (ID, NAME) VALUES ( 2,' GLSI-B' );
--
-- INSERT INTO ETUDIANT ( MATRICULE , NAME, CLASSE_ID) VALUES ( '00000','hmaier', 1  );
-- INSERT INTO ETUDIANT ( MATRICULE , NAME, CLASSE_ID) VALUES ( '00001','bouabid', 2  );
--
-- --
-- INSERT INTO MATIERE (ID, LIBEL) VALUES ( 1, 'matiere1' );
-- INSERT INTO MATIERE (ID, LIBEL) VALUES ( 2, 'matiere2' );
-- --
-- --
-- INSERT INTO ABSCENCE (ID,  ETUDIANT_MATRICULE, MATIERE_ID ) VALUES ( 1,  '00000', 1);
-- INSERT INTO ABSCENCE (ID,  ETUDIANT_MATRICULE, MATIERE_ID ) VALUES ( 2,  '00000', 1);
-- INSERT INTO ABSCENCE (ID,  ETUDIANT_MATRICULE, MATIERE_ID ) VALUES ( 3,  '00000', 2);
-- --
-- INSERT INTO ABSCENCE (ID,  ETUDIANT_MATRICULE, MATIERE_ID ) VALUES ( 4,  '00001', 2);
-- INSERT INTO ABSCENCE (ID,  ETUDIANT_MATRICULE, MATIERE_ID ) VALUES ( 5,  '00001', 2);
-- INSERT INTO ABSCENCE (ID,  ETUDIANT_MATRICULE, MATIERE_ID ) VALUES ( 6,  '00001', 1);



-- DELETE FROM ABSCENCE WHERE ETUDIANT_MATRICULE = '00000'
-- DELETE FROM ABSCENCE WHERE MATIERE_ID = 1

-- DELETE FROM ETUDIANT WHERE MATRICULE  = '00000'
-- DELETE FROM MATIERE WHERE ID  = 1
-- DELETE FROM CLASSE WHERE ID  = 1

-- INSERT INTO CLASSE_MATIERES (ID, CLASSE_ID , MATIERES_ID ) VALUES ( 1 , 1, 1)



