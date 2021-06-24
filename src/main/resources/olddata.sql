insert ignore into authorities
values (1, 'ROLE_USER');
insert ignore into authorities
values (2, 'ROLE_ADMIN');

insert ignore into users(id, username, password, first_name)
values(1, 'root', "$2a$10$RFaHxxVQx4JS1yKvSS2JyO0GJgGCebQ30HGTngNiUS.45KwyW5/7u", "Admin");

insert ignore into user_authorities(user_id, authorities_id)
values (1,2);

update users
set enabled = 1
where id = 1;

insert ignore into items(id, name, price)
values(1, 'flute', 100.00)
