insert into account (create_date, create_id, modify_id, update_date,id, nickname, account_type, account_id, quit) values(CURRENT_TIMESTAMP, 1, 1, CURRENT_TIMESTAMP,nextval('hibernate_sequence'), 'test1', 'LESSOR', 'Lessor 21', false);
insert into account (create_date, create_id, modify_id, update_date,id, nickname, account_type, account_id, quit) values(CURRENT_TIMESTAMP, 1, 1, CURRENT_TIMESTAMP,nextval('hibernate_sequence'), 'test2', 'REALTOR', 'Realtor 11', false);
insert into account (create_date, create_id, modify_id, update_date,id, nickname, account_type, account_id, quit) values(CURRENT_TIMESTAMP, 1, 1, CURRENT_TIMESTAMP,nextval('hibernate_sequence'), 'test3', 'REALTOR', 'Realtor 31', true);
insert into account (create_date, create_id, modify_id, update_date,id, nickname, account_type, account_id, quit) values(CURRENT_TIMESTAMP, 1, 1, CURRENT_TIMESTAMP,nextval('hibernate_sequence'), 'test3', 'LESSEE', 'Lessee 1', true);

insert into board (create_date, create_id, modify_id, update_date, account_id, contents, title, id, deleted) values(CURRENT_TIMESTAMP, 1, 1, CURRENT_TIMESTAMP, 1, 'content 1-1', 'title 1-1', nextval('bard_seq'), false);
insert into board (create_date, create_id, modify_id, update_date, account_id, contents, title, id, deleted) values(CURRENT_TIMESTAMP, 1, 1, CURRENT_TIMESTAMP, 1, 'content 1-2', 'title 1-2', nextval('bard_seq'), false);
insert into board (create_date, create_id, modify_id, update_date, account_id, contents, title, id, deleted) values(CURRENT_TIMESTAMP, 1, 1, CURRENT_TIMESTAMP, 2, 'content 2-1', 'title 2-1', nextval('bard_seq'), false);

insert into board_like (create_date, create_id, modify_id, update_date, account_id, board_id, id) values (CURRENT_TIMESTAMP, 1, 1, CURRENT_TIMESTAMP, 1, 1, nextval('hibernate_sequence'));
insert into board_like (create_date, create_id, modify_id, update_date, account_id, board_id, id) values (CURRENT_TIMESTAMP, 1, 1, CURRENT_TIMESTAMP, 2, 1, nextval('hibernate_sequence'));
insert into board_like (create_date, create_id, modify_id, update_date, account_id, board_id, id) values (CURRENT_TIMESTAMP, 1, 1, CURRENT_TIMESTAMP, 3, 1, nextval('hibernate_sequence'));
insert into board_like (create_date, create_id, modify_id, update_date, account_id, board_id, id) values (CURRENT_TIMESTAMP, 1, 1, CURRENT_TIMESTAMP, 4, 1, nextval('hibernate_sequence'));

insert into reply (create_date, create_id, modify_id, update_date, account_id, board_id, contents, id) values (CURRENT_TIMESTAMP, 1, 1, CURRENT_TIMESTAMP, 1, 1, '댓글1', nextval('reply_seq'));
insert into reply (create_date, create_id, modify_id, update_date, account_id, board_id, contents, id) values (CURRENT_TIMESTAMP, 1, 1, CURRENT_TIMESTAMP, 2, 1, '댓글2', nextval('reply_seq'));
insert into reply (create_date, create_id, modify_id, update_date, account_id, board_id, contents, id) values (CURRENT_TIMESTAMP, 1, 1, CURRENT_TIMESTAMP, 3, 1, '댓글3', nextval('reply_seq'));
insert into reply (create_date, create_id, modify_id, update_date, account_id, board_id, contents, id) values (CURRENT_TIMESTAMP, 1, 1, CURRENT_TIMESTAMP, 4, 1, '댓글4', nextval('reply_seq'));
insert into reply (create_date, create_id, modify_id, update_date, account_id, board_id, contents, id) values (CURRENT_TIMESTAMP, 1, 1, CURRENT_TIMESTAMP, 1, 1, '댓글5', nextval('reply_seq'));
insert into reply (create_date, create_id, modify_id, update_date, account_id, board_id, contents, id) values (CURRENT_TIMESTAMP, 1, 1, CURRENT_TIMESTAMP, 1, 1, '댓글6', nextval('reply_seq'));
insert into reply (create_date, create_id, modify_id, update_date, account_id, board_id, contents, id) values (CURRENT_TIMESTAMP, 1, 1, CURRENT_TIMESTAMP, 2, 1, '댓글7', nextval('reply_seq'));
insert into reply (create_date, create_id, modify_id, update_date, account_id, board_id, contents, id) values (CURRENT_TIMESTAMP, 1, 1, CURRENT_TIMESTAMP, 3, 1, '댓글8', nextval('reply_seq'));
insert into reply (create_date, create_id, modify_id, update_date, account_id, board_id, contents, id) values (CURRENT_TIMESTAMP, 1, 1, CURRENT_TIMESTAMP, 4, 1, '댓글9', nextval('reply_seq'));
insert into reply (create_date, create_id, modify_id, update_date, account_id, board_id, contents, id) values (CURRENT_TIMESTAMP, 1, 1, CURRENT_TIMESTAMP, 1, 1, '댓글10', nextval('reply_seq'));
insert into reply (create_date, create_id, modify_id, update_date, account_id, board_id, contents, id) values (CURRENT_TIMESTAMP, 1, 1, CURRENT_TIMESTAMP, 1, 1, '댓글11', nextval('reply_seq'));
insert into reply (create_date, create_id, modify_id, update_date, account_id, board_id, contents, id) values (CURRENT_TIMESTAMP, 1, 1, CURRENT_TIMESTAMP, 1, 1, '댓글12', nextval('reply_seq'));
insert into reply (create_date, create_id, modify_id, update_date, account_id, board_id, contents, id) values (CURRENT_TIMESTAMP, 1, 1, CURRENT_TIMESTAMP, 1, 1, '댓글13', nextval('reply_seq'));
insert into reply (create_date, create_id, modify_id, update_date, account_id, board_id, contents, id) values (CURRENT_TIMESTAMP, 1, 1, CURRENT_TIMESTAMP, 1, 1, '댓글14', nextval('reply_seq'));
insert into reply (create_date, create_id, modify_id, update_date, account_id, board_id, contents, id) values (CURRENT_TIMESTAMP, 1, 1, CURRENT_TIMESTAMP, 1, 1, '댓글15', nextval('reply_seq'));
insert into reply (create_date, create_id, modify_id, update_date, account_id, board_id, contents, id) values (CURRENT_TIMESTAMP, 1, 1, CURRENT_TIMESTAMP, 1, 2, '댓글1', nextval('reply_seq'));
insert into reply (create_date, create_id, modify_id, update_date, account_id, board_id, contents, id) values (CURRENT_TIMESTAMP, 1, 1, CURRENT_TIMESTAMP, 1, 2, '댓글2', nextval('reply_seq'));