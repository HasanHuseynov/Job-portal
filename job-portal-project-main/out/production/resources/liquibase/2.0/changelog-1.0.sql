create table user_account(
                             id SERIAL primary key,
                             user_type_id INT,
                             email varchar(255),
                             password varchar(255),
                             date_of_birth date,
                             gender varchar(10),
                             status varchar(10),
                             contact_number numeric(10),
                             registration_date date,
                             role varchar,
                             foreign key (user_type_id) references user_type(id)
);