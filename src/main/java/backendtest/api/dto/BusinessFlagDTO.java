package backendtest.api.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
public class BusinessFlagDTO {
    String id;
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
    boolean parkingValidated;
    boolean parkingBike;
    boolean restaurantsDelivery;
    boolean restaurantsTakeout;
    boolean wifiFree;
    boolean wifiPaid;
}
