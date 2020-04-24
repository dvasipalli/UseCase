insert into user(userid, password, customer_name, last_login_date, customer_type, customer_sessionid, session_status)
values('abc@xyz.com', 'asdf123', 'Name1', to_date('07 Mar 2020'), 'TIER1', 'c457041f-a7a1-4370-9e24-3dbc9ccb6126', 'ACTIVE');
insert into user(userid, password, customer_name, last_login_date, customer_type, customer_sessionid, session_status)
values('cast_123', 'qwer345', 'Name2', to_date('01 Jan 2020'), 'TIER2', 'c457041f-a7a1-4370-9e24-3dbc9ccb6156', 'INACTIVE');
insert into user(userid, password, customer_name, last_login_date, customer_type, customer_sessionid, session_status)
values('someday_me', 'aczdf&86q', 'Name3', to_date('07 Feb 2019'), 'TIERELITE', 'c457041f-bda1-4370-9e24-3dertccb6126', 'ACTIVE');
insert into user(userid, password, customer_name, last_login_date, customer_type, customer_sessionid, session_status)
values('first.last', 'qwerd346', 'Name4', to_date('07 Mar 2019'), 'TIERGOLD', 'cas7041f-a7a1-4370-9e24-3dbc9ccbasd6', 'INACTIVE');

insert into account(userid, account_number, account_type, account_branch_code, account_balance, account_currency, account_status) values ('abc@xyz.com', 12341234, 'CHECKING', 2345, 10098, 'USD', 'ACTIVE');
insert into account(userid, account_number, account_type, account_branch_code, account_balance, account_currency, account_status) values ('cast_123', 897645612, 'SAVINGS', 2346, 21345, 'USD', 'ACTIVE');

insert into transaction(account_number, transaction_date, transaction_amount, transaction_currency, transaction_status, transaction_description) values (12341234, to_date('07 Apr 2020'), 1000, 'USD', 'POSTED', 'Payment towards house rent');
insert into transaction(account_number, transaction_date, transaction_amount, transaction_currency, transaction_status, transaction_description) values (897645612, to_date('07 Apr 2020'), 230, 'USD', 'PENDING', 'Payment towards groceries');

insert into reward(REWARDS_ACCOUNT_ID, REWARDS_BALANCE, REWARDS_EXPIRY,	REWARDS_REDEEM_STATUS, REWARDS_TYPE, USERID) values (12341234, 500, to_date('10 Jul 2020'), 'AVAILABLE', 'ANNUAL', 'abc@xyz.com');
insert into reward(REWARDS_ACCOUNT_ID, REWARDS_BALANCE, REWARDS_EXPIRY,	REWARDS_REDEEM_STATUS, REWARDS_TYPE, USERID) values (896745612, 400, to_date('12 Jul 2020'), 'UNAVAILABLE', 'ANNUAL', 'cast_123');
