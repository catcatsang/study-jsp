create table tbl_member(
    id bigint auto_increment primary key,
    member_email varchar(255) not null,
    member_password varchar(255) not null,
    member_name varchar(255) not null,
    member_type varchar(255) not null,
    created_date datetime default current_timestamp,
    updated_date datetime default current_timestamp
);

select * from tbl_member;
