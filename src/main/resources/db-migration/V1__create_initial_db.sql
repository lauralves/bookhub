CREATE SEQUENCE IF NOT EXISTS author_sequence START WITH 1 INCREMENT BY 50;

CREATE SEQUENCE IF NOT EXISTS book_sequence START WITH 1 INCREMENT BY 50;

CREATE SEQUENCE IF NOT EXISTS read_sequence START WITH 1 INCREMENT BY 50;

CREATE SEQUENCE IF NOT EXISTS review_sequence START WITH 1 INCREMENT BY 50;

CREATE SEQUENCE IF NOT EXISTS user_sequence START WITH 1 INCREMENT BY 50;

CREATE TABLE author
(
    sq_author  BIGINT       NOT NULL,
    name       VARCHAR(255) NOT NULL,
    created_at TIMESTAMP WITHOUT TIME ZONE,
    updated_at TIMESTAMP WITHOUT TIME ZONE,
    created_by VARCHAR(255),
    updated_by VARCHAR(255),
    CONSTRAINT pk_author PRIMARY KEY (sq_author)
);

CREATE TABLE book
(
    sq_book        BIGINT NOT NULL,
    name           VARCHAR(255),
    published_date date,
    total_pages    INTEGER,
    created_at     TIMESTAMP WITHOUT TIME ZONE,
    updated_at     TIMESTAMP WITHOUT TIME ZONE,
    created_by     VARCHAR(255),
    updated_by     VARCHAR(255),
    sq_author      BIGINT NOT NULL,
    CONSTRAINT pk_book PRIMARY KEY (sq_book)
);

CREATE TABLE read
(
    sq_read    BIGINT NOT NULL,
    start_date date,
    end_date   date,
    pages_read INTEGER,
    created_at TIMESTAMP WITHOUT TIME ZONE,
    updated_at TIMESTAMP WITHOUT TIME ZONE,
    created_by VARCHAR(255),
    updated_by VARCHAR(255),
    sq_user    BIGINT NOT NULL,
    CONSTRAINT pk_read PRIMARY KEY (sq_read)
);

CREATE TABLE review
(
    sq_review  BIGINT NOT NULL,
    stars      INTEGER,
    overview   VARCHAR(255),
    created_at TIMESTAMP WITHOUT TIME ZONE,
    updated_at TIMESTAMP WITHOUT TIME ZONE,
    created_by VARCHAR(255),
    updated_by VARCHAR(255),
    sq_read    BIGINT NOT NULL,
    CONSTRAINT pk_review PRIMARY KEY (sq_review)
);

CREATE TABLE "user"
(
    sq_user    BIGINT NOT NULL,
    name       VARCHAR(255),
    cpf        VARCHAR(255),
    birth_date date,
    email      VARCHAR(255),
    created_at TIMESTAMP WITHOUT TIME ZONE,
    updated_at TIMESTAMP WITHOUT TIME ZONE,
    created_by VARCHAR(255),
    updated_by VARCHAR(255),
    CONSTRAINT pk_user PRIMARY KEY (sq_user)
);

ALTER TABLE author
    ADD CONSTRAINT uc_author_name UNIQUE (name);

ALTER TABLE book
    ADD CONSTRAINT FK_BOOK_ON_SQ_AUTHOR FOREIGN KEY (sq_author) REFERENCES author (sq_author);

ALTER TABLE read
    ADD CONSTRAINT FK_READ_ON_SQ_USER FOREIGN KEY (sq_user) REFERENCES "user" (sq_user);

ALTER TABLE review
    ADD CONSTRAINT FK_REVIEW_ON_SQ_READ FOREIGN KEY (sq_read) REFERENCES read (sq_read);
