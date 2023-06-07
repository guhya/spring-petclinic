CREATE TABLE IF NOT EXISTS vet (
  vet_id INT(4) UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY,
  first_name VARCHAR(30),
  last_name VARCHAR(30),
  INDEX(last_name)
) engine=InnoDB;

CREATE TABLE IF NOT EXISTS specialty (
  specialty_id INT(4) UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY,
  name VARCHAR(80),
  INDEX(name)
) engine=InnoDB;

CREATE TABLE IF NOT EXISTS vet_specialty (
  vet_id INT(4) UNSIGNED NOT NULL,
  specialty_id INT(4) UNSIGNED NOT NULL,
  FOREIGN KEY (vet_id) REFERENCES vet(vet_id),
  FOREIGN KEY (specialty_id) REFERENCES specialty(specialty_id),
  UNIQUE (vet_id, specialty_id)
) engine=InnoDB;

CREATE TABLE IF NOT EXISTS type (
  type_id INT(4) UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY,
  name VARCHAR(80),
  INDEX(name)
) engine=InnoDB;

CREATE TABLE IF NOT EXISTS owner (
  owner_id INT(4) UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY,
  first_name VARCHAR(30),
  last_name VARCHAR(30),
  address VARCHAR(255),
  city VARCHAR(80),
  telephone VARCHAR(20),
  created_by VARCHAR(32),
  created_at DATETIME,
  modified_by VARCHAR(32),
  modified_at DATETIME,   
  INDEX(last_name)
) engine=InnoDB;

CREATE TABLE IF NOT EXISTS pet (
  pet_id INT(4) UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY,
  name VARCHAR(30),
  birth_date DATE,
  type_id INT(4) UNSIGNED NOT NULL,
  owner_id INT(4) UNSIGNED,
  INDEX(name),
  FOREIGN KEY (owner_id) REFERENCES owner(owner_id),
  FOREIGN KEY (type_id) REFERENCES type(type_id)
) engine=InnoDB;

CREATE TABLE IF NOT EXISTS visit (
  visit_id INT(4) UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY,
  pet_id INT(4) UNSIGNED,
  visit_date DATE,
  description VARCHAR(255),
  FOREIGN KEY (pet_id) REFERENCES pet(pet_id)
) engine=InnoDB;
