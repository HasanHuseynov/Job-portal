create table education_detail(
                                 education_detail_id SERIAL primary key,
                                 seeker_id INT,
                                 major varchar(50),
                                 certificate_degree_name varchar(50),
                                 university_name varchar(50),
                                 starting_date date,
                                 completion_date date,
                                 degree varchar(50),
                                 gpa INT,
                                 foreign key (seeker_id) references seeker_profile(seeker_id)
);