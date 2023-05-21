package backendtest.api.dto;

import java.time.LocalTime;

import backendtest.api.entity.Business.PriceRange;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BusinessDTO {
    String name;
    String[] categories;
    LocalTime openAt;
    LocalTime closedAt;
    PriceRange priceRange;
    LocationDTO location;
    BusinessFlagDTO flag;
}
