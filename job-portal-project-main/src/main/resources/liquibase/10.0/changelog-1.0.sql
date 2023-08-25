create table job_post_activity(
    post_activity_id SERIAL primary key,
    user_account_id INT,
    job_post_id INT,
    apply_date date,
    foreign key (user_account_id) references user_account(id),
    foreign key (job_post_id) references job_post(job_post_id)
);