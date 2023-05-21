create table businesses(
    id varchar(36),
    categories varchar(255),
    name varchar(255),
    open_at TIME,
    closed_at TIME,
    price_range INT,
    primary key (id),
    deleted_at DATETIME,
    created_at TIMESTAMP DEFAULT current_timestamp() ON UPDATE current_timestamp(),
    updated_at DATETIME NULL
);