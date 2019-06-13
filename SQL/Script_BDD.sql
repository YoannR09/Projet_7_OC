
CREATE SEQUENCE public.niveau_acces_id_seq;

CREATE TABLE public.niveau_acces (
                id INTEGER NOT NULL DEFAULT nextval('public.niveau_acces_id_seq'),
                niveau INTEGER NOT NULL,
                labelle VARCHAR NOT NULL,
                CONSTRAINT niveau_acces_pk PRIMARY KEY (id)
);


ALTER SEQUENCE public.niveau_acces_id_seq OWNED BY public.niveau_acces.id;

CREATE SEQUENCE public.compte_id_seq;

CREATE TABLE public.compte (
                id INTEGER NOT NULL DEFAULT nextval('public.compte_id_seq'),
                nom VARCHAR NOT NULL,
                prenom VARCHAR NOT NULL,
                email VARCHAR NOT NULL,
                numero VARCHAR NOT NULL,
                mot_de_passe VARCHAR NOT NULL,
                niveau_acces_id INTEGER NOT NULL,
                CONSTRAINT compte_pk PRIMARY KEY (id)
);


ALTER SEQUENCE public.compte_id_seq OWNED BY public.compte.id;

CREATE SEQUENCE public.image_id_seq;

CREATE TABLE public.image (
                id INTEGER NOT NULL DEFAULT nextval('public.image_id_seq'),
                url VARCHAR NOT NULL,
                description VARCHAR NOT NULL,
                CONSTRAINT image_pk PRIMARY KEY (id)
);


ALTER SEQUENCE public.image_id_seq OWNED BY public.image.id;

CREATE SEQUENCE public.categorie_id_seq;

CREATE TABLE public.categorie (
                id INTEGER NOT NULL DEFAULT nextval('public.categorie_id_seq'),
                nom VARCHAR NOT NULL,
                CONSTRAINT categorie_pk PRIMARY KEY (id)
);


ALTER SEQUENCE public.categorie_id_seq OWNED BY public.categorie.id;

CREATE SEQUENCE public.livre_id_seq;

CREATE TABLE public.livre (
                id INTEGER NOT NULL DEFAULT nextval('public.livre_id_seq'),
                nom VARCHAR NOT NULL,
                auteur VARCHAR NOT NULL,
                date_de_creation DATE NOT NULL,
                langue VARCHAR NOT NULL,
                resume VARCHAR NOT NULL,
                isbn VARCHAR NOT NULL,
                categorie_id INTEGER NOT NULL,
                image_id INTEGER NOT NULL,
                CONSTRAINT livre_pk PRIMARY KEY (id)
);


ALTER SEQUENCE public.livre_id_seq OWNED BY public.livre.id;

CREATE SEQUENCE public.reservation_id_seq;

CREATE TABLE public.reservation (
                id INTEGER NOT NULL DEFAULT nextval('public.reservation_id_seq'),
                date_de_debut DATE NOT NULL,
                date_de_fin DATE NOT NULL,
                prolonge BOOLEAN NOT NULL,
                livre_id INTEGER NOT NULL,
                compte_id INTEGER NOT NULL,
                CONSTRAINT reservation_pk PRIMARY KEY (id)
);


ALTER SEQUENCE public.reservation_id_seq OWNED BY public.reservation.id;

CREATE SEQUENCE public.bibliotheque_id_seq;

CREATE TABLE public.bibliotheque (
                id INTEGER NOT NULL DEFAULT nextval('public.bibliotheque_id_seq'),
                nom VARCHAR NOT NULL,
                adresse VARCHAR NOT NULL,
                CONSTRAINT bibliotheque_pk PRIMARY KEY (id)
);


ALTER SEQUENCE public.bibliotheque_id_seq OWNED BY public.bibliotheque.id;

CREATE SEQUENCE public.stock_id_seq;

CREATE TABLE public.stock (
                id INTEGER NOT NULL DEFAULT nextval('public.stock_id_seq'),
                quantite INTEGER NOT NULL,
                bibliotheque_id INTEGER NOT NULL,
                livre_id INTEGER NOT NULL,
                CONSTRAINT stock_pk PRIMARY KEY (id)
);


ALTER SEQUENCE public.stock_id_seq OWNED BY public.stock.id;

ALTER TABLE public.compte ADD CONSTRAINT niveau_acces_compte_fk
FOREIGN KEY (niveau_acces_id)
REFERENCES public.niveau_acces (id)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE public.reservation ADD CONSTRAINT compte_reservation_fk
FOREIGN KEY (compte_id)
REFERENCES public.compte (id)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE public.livre ADD CONSTRAINT image_livre_fk
FOREIGN KEY (image_id)
REFERENCES public.image (id)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE public.livre ADD CONSTRAINT categorie_livre_fk
FOREIGN KEY (categorie_id)
REFERENCES public.categorie (id)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE public.stock ADD CONSTRAINT livre_stock_fk
FOREIGN KEY (livre_id)
REFERENCES public.livre (id)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE public.reservation ADD CONSTRAINT livre_reservation_fk
FOREIGN KEY (livre_id)
REFERENCES public.livre (id)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE public.stock ADD CONSTRAINT bibliotheque_stock_fk
FOREIGN KEY (bibliotheque_id)
REFERENCES public.bibliotheque (id)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;
