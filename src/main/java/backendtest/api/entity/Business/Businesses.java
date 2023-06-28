package backendtest.api.entity.Business;

import java.time.LocalDateTime;
import java.time.LocalTime;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import backendtest.api.entity.BaseEntity;
import backendtest.api.entity.Locations.Locations;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "businesses")
public class Businesses extends BaseEntity {
    
    @Column(name = "categories")
    private String categories;

    @Column(name = "name")
    private String name;

    @Column(name = "open_at")
    private LocalTime openAt;

    @Column(name = "closed_at")
    private LocalTime closedAt;

    @Column(name = "price_range")
    @Enumerated(EnumType.STRING)
    private PriceRange priceRange;

    @OneToOne(mappedBy = "business", cascade = CascadeType.ALL)
    private BusinessFlags businessFlag;

    @OneToOne(mappedBy = "business", cascade = CascadeType.ALL)
    private Locations location;

}
