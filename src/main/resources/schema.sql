CREATE TABLE IF NOT EXISTS users
(
    id       identity primary key,
    name     varchar(128) unique not null,
    password varchar(256)        not null
);
CREATE TABLE IF NOT EXISTS books
(
    id       identity primary key,
    title    varchar(64) not null,
    author   varchar(64) not null,
    year     int         not null,
    genre    varchar(32) not null,
    is_ebook boolean     not null default false
);
CREATE TABLE IF NOT EXISTS books_in_use
(
    id         identity primary key,
    id_user_fk bigint not null,
    id_book_fk bigint not null,
    foreign key (id_user_fk) references users (id),
    foreign key (id_book_fk) references books (id)
)