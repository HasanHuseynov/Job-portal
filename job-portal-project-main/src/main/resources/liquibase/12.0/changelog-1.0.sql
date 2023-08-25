create table token(
    id SERIAL primary key,
    user_id int,
    token varchar,
    token_type  varchar,
    revoked BOOLEAN,
    expired BOOLEAN,
    foreign key (user_id) references user_account(id)

);