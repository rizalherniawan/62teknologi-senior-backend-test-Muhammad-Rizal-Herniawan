package backendtest.api.entity.Business;


import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import backendtest.api.entity.BaseEntity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "business_flags")
public class BusinessFlags extends BaseEntity{
    
    @Column(name = "hot_and_new")
    private boolean hotAndNew;

    @Column(name = "request_a_quote")
    private boolean requestAQUote;

    @Column(name = "reservation")
    private boolean reservation;

    @Column(name = "waitlist_reservation")
    private boolean waitlistReservation;

    @Column(name = "deals")
    private boolean deals;

    @Column(name = "gender_neutral_restrooms")
    private boolean genderNeutralRestrooms;

    @Column(name = "open_to_all")
    private boolean openToAll;

    @Column(name = "wheelchair_accessible")
    private boolean wheelchairAccessible;

    @Column(name = "liked_by_vegetarians")
    private boolean likedByVegetarians;

    @Column(name = "outdoor_seating")
    private boolean outdoorSeating;

    @Column(name = "parking_garage")
    private boolean parkingGarage;

    @Column(name = "parking_lot")
    private boolean parkingLot;

    @Column(name = "parking_street")
    private boolean parkingStreet;

    @Column(name = "parking_validated")
    private boolean parkingValidated;

    @Column(name = "parking_bike")
    private boolean parkingBike;

    @Column(name = "restaurants_delivery")
    private boolean restaurantsDelivery;

    @Column(name = "restaurants_takeout")
    private boolean restaurantsTakeout;

    @Column(name = "wifi_free")
    private boolean wifiFree;

    @Column(name = "wifi_paid")
    private boolean wifiPaid;

    @OneToOne(cascade = CascadeType.ALL)
    @JsonIgnore
    @JoinColumn(name = "business_id", referencedColumnName = "id")
    private Businesses business;
}
