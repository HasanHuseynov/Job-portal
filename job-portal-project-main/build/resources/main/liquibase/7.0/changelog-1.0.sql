create table experience_detail(
    experience_id SERIAL primary key,
    is_current_job varchar(3),
    start_date date,
    end_date date,
    job_title varchar(50),
    company_name varchar(50),
    job_location_city varchar(50),
    job_location_state varchar(50),
    job_location_country varchar(50),
    description varchar(100),
    seeker_id INT,
    foreign key (seeker_id) references seeker_profile(seeker_id)
);