create table locations(
    id varchar(36),
    longtitude INT,
    latitude INT,
    address text,
    country_code INT,
    language_code varchar(10),
    region varchar(255),
    radius INT,
    business_id varchar(36),
    deleted_at DATETIME,
    created_at TIMESTAMP DEFAULT current_timestamp() ON UPDATE current_timestamp(),
    updated_at DATETIME NULL,
    primary key (id),
    foreign key (business_id) references businesses(id)         
        ON UPDATE CASCADE
        ON DELETE CASCADE
);