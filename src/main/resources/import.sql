insert into account (id, nickname, account_type, account_id, quit) values(nextval('hibernate_sequence'), 'test1', 'LESSOR', 'Lessor 21', false);
insert into account (id, nickname, account_type, account_id, quit) values(nextval('hibernate_sequence'), 'test2', 'REALTOR', 'Realtor 11', false);
insert into account (id, nickname, account_type, account_id, quit) values(nextval('hibernate_sequence'), 'test3', 'REALTOR', 'Realtor 31', true);
insert into account (id, nickname, account_type, account_id, quit) values(nextval('hibernate_sequence'), 'test3', 'LESSEE', 'Lessee 1', true);
-- values(nextval('hibernate_sequence'), 'test3', 'LESSOR', 'Lessor 1', true)