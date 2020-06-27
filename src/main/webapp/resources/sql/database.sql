-- create database
CREATE DATABASE charity_donation
    CHARACTER SET utf8mb4
    COLLATE utf8mb4_unicode_ci;

-- create sample Institution records
INSERT INTO charity_donation.institutions (name, description) VALUES ('Fundacja "Dbam o zdrowie"', 'Cel i misja: Pomoc dzieciom z
ubogich rodzin.');
INSERT INTO charity_donation.institutions (name, description) VALUES ('Fundacja "A kogo"', 'Cel i misja: Pomoc ' ||
 'wybudzaniu dzieci ze śpiączki.');
INSERT INTO charity_donation.institutions (name, description) VALUES ('Fundacja "Dla dzieci"', 'Cel i misja: Pomoc osobom znajdującym się w trudnej sytuacji życiowej.');
INSERT INTO charity_donation.institutions (name, description) VALUES ('Fundacja "Bez domu"', 'Cel i misja: Pomoc dla osób nie posiadających miejsca zamieszkania
.');

-- create sample Categories records
INSERT INTO charity_donation.categories (name) VALUES ('ubrania, które nadają się do ponownego użycia');
INSERT INTO charity_donation.categories (name) VALUES ('ubrania, do wyrzucenia');
INSERT INTO charity_donation.categories (name) VALUES ('zabawki');
INSERT INTO charity_donation.categories (name) VALUES ('książki');
INSERT INTO charity_donation.categories (name) VALUES ('inne');

-- create roles for Spring Security Authorization
INSERT INTO charity_donation.roles (role_id, role_name) VALUES (null, 'ROLE_USER');
INSERT INTO charity_donation.roles (role_id, role_name) VALUES (null, 'ROLE_ADMIN');

-- create an admin
-- password hashed: admin
INSERT INTO users (user_id, email, enabled, last_name, first_name, password) VALUES (null, 'admin@email.pl',1,'Admin','Admin','$2a$10$p/yv5eCVPdFM6f0K5kGpT.9b9lhP2nLBqF2oGTr/nv0OuNgqmb/si')

-- create a normal user
-- password hashed: user1
INSERT INTO users (user_id, email, enabled, last_name, first_name, password) VALUES (null, 'user@email.pl',1,
'User','User','$2a$10$WzjL5dDmi44TfHiz2iyccOnyXVZNKAWIsw6/711rPrb3D3bSsD9wG')

-- assign role admin to admin
INSERT INTO users_roles(user_id, role_id) VALUES (1, 2);
-- assign role user to normal user
INSERT INTO users_roles(user_id, role_id) VALUES (2, 1);
