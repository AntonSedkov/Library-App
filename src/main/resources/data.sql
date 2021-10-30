DELETE
FROM users;
INSERT INTO users (id, email, name, password)
VALUES (1,'worm@ani.mal', 'worm', '{noop}pass'),
       (2,'fox@ani.mal', 'fox', '{noop}pass'),
       (3,'pig@ani.mal', 'pig', '{noop}pass');

DELETE
FROM books;
INSERT INTO books (id, title, author, year, genre, is_ebook)
VALUES (1, 'Thinking in Java', 'Bruce Eckel', 2006, 'IT', false),
       (2, 'On the Origin of Species', 'Charles Darwin', 1859, 'SCIENTIFIC', false),
       (3, 'Ulysses', 'James Joyce', 1918, 'FICTION', false),
       (4, 'Captivate', 'Vanessa Van Edwards', 2017, 'SOCIAL', false),
       (5, 'The 7 Habits of Highly Effective People', 'Stephen R. Covey', 1989, 'BUSINESS', false),
       (6, 'The Collected Poems', 'Sergei Yesenin', 2000, 'POETRY', false),
       (7, 'War and Peace', 'Leo Tolstoy', 1867, 'FICTION', true),
       (8, 'Dune', 'Frank Herbert', 1965, 'FICTION', true);

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