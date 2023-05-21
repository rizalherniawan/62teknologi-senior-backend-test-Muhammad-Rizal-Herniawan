package backendtest.api.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BusinessFlagDTO {
    boolean hotAndNew;
    boolean requestAQUote;
    boolean reservation;
    boolean waitlistReservation;
    boolean deals;
    boolean genderNeutralRestrooms;
    boolean openToAll;
    boolean wheelchairAccessible;
    boolean likedByVegetarians;
    boolean outdoorSeating;
    boolean parkingGarage;
    boolean parkingLot;
    boolean parkingStreet;
    boolean parkingValet;
    boolean parkingValidated;
    boolean parkingBike;
    boolean restaurantsDelivery;
    boolean restaurantsTakeout;
    boolean wifiFree;
    boolean wifiPaid;
}
