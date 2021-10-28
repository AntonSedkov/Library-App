DELETE
FROM users;
INSERT INTO users (name, password)
VALUES ('worm', '{noop}pass'),
       ('fox', '{noop}pass'),
       ('pig', '{noop}pass');

DELETE
FROM books;
INSERT INTO books (title, author, year, genre, is_ebook)
VALUES ('Thinking in Java', 'Bruce Eckel', 2006, 'IT', false),
       ('On the Origin of Species', 'Charles Darwin', 1859, 'SCIENTIFIC', false),
       ('Ulysses', 'James Joyce', 1918, 'FICTION', false),
       ('Captivate', 'Vanessa Van Edwards', 2017, 'SOCIAL', false),
       ('The 7 Habits of Highly Effective People', 'Stephen R. Covey', 1989, 'BUSINESS', false),
       ('The Collected Poems', 'Sergei Yesenin', 2000, 'POETRY', false),
       ('War and Peace', 'Leo Tolstoy', 1867, 'FICTION', true),
       ('Dune', 'Frank Herbert', 1965, 'FICTION', true);

DELETE
FROM books_in_use;
INSERT INTO books_in_use (id_user_fk, id_book_fk)
VALUES (1, 8),
       (2, 8),
       (3, 7),
       (1, 6),
       (2, 5),
       (3, 4),
       (1, 3),
       (2, 2),
       (3, 1);