create table company(
    id SERIAL primary key ,
    company_email varchar,
    company_name varchar,
    profile_description varchar,
    establishment_date date,
    balance INT
    --company_image blob
);