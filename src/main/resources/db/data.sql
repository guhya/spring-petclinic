INSERT IGNORE INTO vet VALUES (1, 'James', 'Carter');
INSERT IGNORE INTO vet VALUES (2, 'Helen', 'Leary');
INSERT IGNORE INTO vet VALUES (3, 'Linda', 'Douglas');
INSERT IGNORE INTO vet VALUES (4, 'Rafael', 'Ortega');
INSERT IGNORE INTO vet VALUES (5, 'Henry', 'Stevens');
INSERT IGNORE INTO vet VALUES (6, 'Sharon', 'Jenkins');

INSERT IGNORE INTO specialty VALUES (1, 'radiology');
INSERT IGNORE INTO specialty VALUES (2, 'surgery');
INSERT IGNORE INTO specialty VALUES (3, 'dentistry');

INSERT IGNORE INTO vet_specialty VALUES (2, 1);
INSERT IGNORE INTO vet_specialty VALUES (3, 2);
INSERT IGNORE INTO vet_specialty VALUES (3, 3);
INSERT IGNORE INTO vet_specialty VALUES (4, 2);
INSERT IGNORE INTO vet_specialty VALUES (5, 1);

INSERT IGNORE INTO type VALUES (1, 'cat');
INSERT IGNORE INTO type VALUES (2, 'dog');
INSERT IGNORE INTO type VALUES (3, 'lizard');
INSERT IGNORE INTO type VALUES (4, 'snake');
INSERT IGNORE INTO type VALUES (5, 'bird');
INSERT IGNORE INTO type VALUES (6, 'hamster');

INSERT IGNORE INTO owner VALUES (1, 'George', 'Franklin', '110 W. Liberty St.', 'Madison', '6085551023', 'admin', CURRENT_TIMESTAMP(), 'admin', CURRENT_TIMESTAMP());
INSERT IGNORE INTO owner VALUES (2, 'Betty', 'Davis', '638 Cardinal Ave.', 'Sun Prairie', '6085551749', 'admin', CURRENT_TIMESTAMP(), 'admin', CURRENT_TIMESTAMP());
INSERT IGNORE INTO owner VALUES (3, 'Eduardo', 'Rodriquez', '2693 Commerce St.', 'McFarland', '6085558763', 'admin', CURRENT_TIMESTAMP(), 'admin', CURRENT_TIMESTAMP());
INSERT IGNORE INTO owner VALUES (4, 'Harold', 'Davis', '563 Friendly St.', 'Windsor', '6085553198', 'admin', CURRENT_TIMESTAMP(), 'admin', CURRENT_TIMESTAMP());
INSERT IGNORE INTO owner VALUES (5, 'Peter', 'McTavish', '2387 S. Fair Way', 'Madison', '6085552765', 'admin', CURRENT_TIMESTAMP(), 'admin', CURRENT_TIMESTAMP());
INSERT IGNORE INTO owner VALUES (6, 'Jean', 'Coleman', '105 N. Lake St.', 'Monona', '6085552654', 'admin', CURRENT_TIMESTAMP(), 'admin', CURRENT_TIMESTAMP());
INSERT IGNORE INTO owner VALUES (7, 'Jeff', 'Black', '1450 Oak Blvd.', 'Monona', '6085555387', 'admin', CURRENT_TIMESTAMP(), 'admin', CURRENT_TIMESTAMP());
INSERT IGNORE INTO owner VALUES (8, 'Maria', 'Escobito', '345 Maple St.', 'Madison', '6085557683', 'admin', CURRENT_TIMESTAMP(), 'admin', CURRENT_TIMESTAMP());
INSERT IGNORE INTO owner VALUES (9, 'David', 'Schroeder', '2749 Blackhawk Trail', 'Madison', '6085559435', 'admin', CURRENT_TIMESTAMP(), 'admin', CURRENT_TIMESTAMP());
INSERT IGNORE INTO owner VALUES (10, 'Carlos', 'Estaban', '2335 Independence La.', 'Waunakee', '6085555487', 'admin', CURRENT_TIMESTAMP(), 'admin', CURRENT_TIMESTAMP());

INSERT IGNORE INTO pet VALUES (1, 'Leo', '2000-09-07', 1, 1);
INSERT IGNORE INTO pet VALUES (2, 'Basil', '2002-08-06', 6, 2);
INSERT IGNORE INTO pet VALUES (3, 'Rosy', '2001-04-17', 2, 3);
INSERT IGNORE INTO pet VALUES (4, 'Jewel', '2000-03-07', 2, 3);
INSERT IGNORE INTO pet VALUES (5, 'Iggy', '2000-11-30', 3, 4);
INSERT IGNORE INTO pet VALUES (6, 'George', '2000-01-20', 4, 5);
INSERT IGNORE INTO pet VALUES (7, 'Samantha', '1995-09-04', 1, 6);
INSERT IGNORE INTO pet VALUES (8, 'Max', '1995-09-04', 1, 6);
INSERT IGNORE INTO pet VALUES (9, 'Lucky', '1999-08-06', 5, 7);
INSERT IGNORE INTO pet VALUES (10, 'Mulligan', '1997-02-24', 2, 8);
INSERT IGNORE INTO pet VALUES (11, 'Freddy', '2000-03-09', 5, 9);
INSERT IGNORE INTO pet VALUES (12, 'Lucky', '2000-06-24', 2, 10);
INSERT IGNORE INTO pet VALUES (13, 'Sly', '2002-06-08', 1, 10);

INSERT IGNORE INTO visit VALUES (1, 7, '2010-03-04', 'rabies shot');
INSERT IGNORE INTO visit VALUES (2, 8, '2011-03-04', 'rabies shot');
INSERT IGNORE INTO visit VALUES (3, 8, '2009-06-04', 'neutered');
INSERT IGNORE INTO visit VALUES (4, 7, '2008-09-04', 'spayed');
