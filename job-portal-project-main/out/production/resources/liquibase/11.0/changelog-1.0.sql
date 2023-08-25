create table job_post(
    job_post_id SERIAL primary key,
    job_location_id INT,
    job_type_id INT,
    company_id INT,
    major varchar,
    status varchar,
    priority varchar,
    created_date date,
    promotion_end_date date,
    job_description varchar(200),
    salary numeric,
    expiration_date date,
    foreign key (job_location_id) references job_location(job_location_id),
    foreign key (job_type_id) references job_type(job_type_id),
    foreign key (company_id) references company(id)

);