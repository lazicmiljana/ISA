REPLACE INTO `role` VALUES (1, 'ADMIN');
REPLACE INTO `role` VALUES (2, 'STANDARD');

REPLACE INTO `user` VALUES (100, 'Novi Sad', 'admin@admin.com', 2, 'Simic', 'Sima', '21232F297A57A5A743894A0E4A801FC3', '065/333-444', 1);
REPLACE INTO `user` VALUES (101, 'Novi Sad', 'mail@mail.com', 2, 'Peric', 'Pera', '21232F297A57A5A743894A0E4A801FC3', '065/444-333', 2);

REPLACE INTO `cinema_type` VALUES (1, 'CINEMA');
REPLACE INTO `cinema_type` VALUES (2, 'THEATER');

/*
REPLACE INTO `ticket` VALUES (1, '10.10.2018', 10, 420, 0, '16:30', 2, null, null);
REPLACE INTO `ticket` VALUES (2, '10.10.2018', 10, 420, 0, '16:30', 2, null, null);
REPLACE INTO `ticket` VALUES (3, '10.10.2018', 10, 420, 0, '16:30', 2, null, null);
REPLACE INTO `ticket` VALUES (4, '10.10.2018', 10, 420, 0, '16:30', 2, null, null);
REPLACE INTO `ticket` VALUES (5, '10.10.2018', 10, 420, 0, '16:30', 2, null, null);
REPLACE INTO `ticket` VALUES (6, '10.10.2018', 10, 420, 0, '16:30', 2, null, null);
REPLACE INTO `ticket` VALUES (7, '10.10.2018', 10, 420, 0, '16:30', 2, null, null);
REPLACE INTO `ticket` VALUES (8, '10.10.2018', 10, 420, 0, '16:30', 2, null, null);
REPLACE INTO `ticket` VALUES (9, '10.10.2018', 10, 420, 0, '16:30', 2, null, null);
REPLACE INTO `ticket` VALUES (10, '10.10.2018', 10, 420, 0, '16:30', 2, null, null);

REPLACE INTO `ticket` VALUES (11, '10.11.2018', 13, 350, 0, '13:15', 2, null, null);
REPLACE INTO `ticket` VALUES (12, '10.11.2018', 13, 350, 0, '13:15', 2, null, null);
REPLACE INTO `ticket` VALUES (13, '10.11.2018', 13, 350, 0, '13:15', 2, null, null);
REPLACE INTO `ticket` VALUES (14, '10.11.2018', 13, 350, 0, '13:15', 2, null, null);
REPLACE INTO `ticket` VALUES (15, '10.11.2018', 13, 350, 0, '13:15', 2, null, null);
REPLACE INTO `ticket` VALUES (16, '10.11.2018', 13, 350, 0, '13:15', 2, null, null);
REPLACE INTO `ticket` VALUES (17, '10.11.2018', 13, 350, 0, '13:15', 2, null, null);
REPLACE INTO `ticket` VALUES (18, '10.11.2018', 13, 350, 0, '13:15', 2, null, null);
REPLACE INTO `ticket` VALUES (19, '10.11.2018', 13, 350, 0, '13:15', 2, null, null);
REPLACE INTO `ticket` VALUES (20, '10.11.2018', 13, 350, 0, '13:15', 2, null, null);
*/

REPLACE INTO `actor` VALUES (1, 'Pera');
REPLACE INTO `actor` VALUES (2, 'Mika');
REPLACE INTO `actor` VALUES (3, 'Zika');
REPLACE INTO `actor` VALUES (4, 'Laza');
REPLACE INTO `actor` VALUES (5, 'Steva');
REPLACE INTO `actor` VALUES (6, 'Milica');
REPLACE INTO `actor` VALUES (7, 'Slavica');
REPLACE INTO `actor` VALUES (8, 'Anica');
REPLACE INTO `actor` VALUES (9, 'Zorica');
REPLACE INTO `actor` VALUES (10, 'Gorica');

REPLACE INTO `genre` VALUES (1, 'Action');
REPLACE INTO `genre` VALUES (2, 'Drama');
REPLACE INTO `genre` VALUES (3, 'Thriller');
