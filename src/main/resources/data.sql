INSERT INTO roles(name) VALUES ('ROLE_USER'),
                               ('ROLE_ADMIN');

INSERT INTO users(name, lastname, password, age, email) VALUES ('user', 'userov', '$2a$12$YLz/yqjc0/HGgS.dBbDoiucnJHNuWOlbBQPsfXpj65BkL0THHvpfK', 23, 'pomogite@mail.ru'),
                                                               ('admin', 'adminov', '$2a$12$RDJQjXlNSQ5YRvzdQxGtUu.i4.QF/VJL7TSTjt2M.s8ZCAgHcfqnO', 21, 'sos@mail.ru');

INSERT INTO users_roles VALUES (1, 1),
                               (2, 1),
                               (2, 2);