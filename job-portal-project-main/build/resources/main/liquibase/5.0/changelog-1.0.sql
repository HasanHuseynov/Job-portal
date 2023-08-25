create table seeker_profile(
    seeker_id SERIAL primary key,
    first_name varchar(20),
    major varchar,
    cv BYTEA,
    last_name varchar(20),
    user_id INT,
    foreign key (user_id) references user_account
);