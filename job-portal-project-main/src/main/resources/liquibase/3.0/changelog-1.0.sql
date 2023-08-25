create table user_log(
                         user_log_id SERIAL primary key ,
                         last_login_date date,
                         user_account_id INT,
                         foreign key (user_account_id) references user_account(id)
);