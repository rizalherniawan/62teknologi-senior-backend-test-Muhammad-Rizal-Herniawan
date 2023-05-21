package backendtest.api.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LocationDTO {
    String id;
    Integer longtitude;
    Integer latitude;
    String address;
    Integer countryCode;
    String languageCode;
    String region;
    Integer radius;
}
