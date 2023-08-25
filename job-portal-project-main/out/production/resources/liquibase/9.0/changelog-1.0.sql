create table job_location(
                             job_location_id SERIAL primary key,
                             street_address varchar(50),
                             city varchar(50),
                             state varchar(50),
                             country varchar(50),
                             zip varchar(10)
);