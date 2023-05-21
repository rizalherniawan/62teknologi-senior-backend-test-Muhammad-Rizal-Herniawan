create table business_flags(
    id varchar(36),
    hot_and_new bit(1) DEFAULT 0,
    request_a_quote bit(1) DEFAULT 0,
    reservation bit(1) DEFAULT 0,
    waitlist_reservation bit(1) DEFAULT 0,
    deals bit(1) DEFAULT 0, 
    gender_neutral_restrooms bit(1) DEFAULT 0, 
    open_to_all bit(1) DEFAULT 0,
    wheelchair_accessible bit(1) DEFAULT 0,
    liked_by_vegetarians bit(1) DEFAULT 0,
    outdoor_seating bit(1) DEFAULT 0,
    parking_garage bit(1) DEFAULT 0,
    parking_lot bit(1) DEFAULT 0,
    parking_street bit(1) DEFAULT 0,
    parking_valet bit(1) DEFAULT 0,
    parking_validated bit(1) DEFAULT 0,
    parking_bike bit(1) DEFAULT 0,
    restaurants_delivery bit(1) DEFAULT 0,
    restaurants_takeout bit(1) DEFAULT 0,
    wifi_free bit(1) DEFAULT 0,
    wifi_paid bit(1) DEFAULT 0,
    business_id varchar(36),
    primary key (id),
    deleted_at DATETIME,
    created_at TIMESTAMP DEFAULT current_timestamp() ON UPDATE current_timestamp(),
    updated_at DATETIME NULL,
    foreign key (business_id) references businesses(id)         
        ON UPDATE CASCADE
        ON DELETE CASCADE
)