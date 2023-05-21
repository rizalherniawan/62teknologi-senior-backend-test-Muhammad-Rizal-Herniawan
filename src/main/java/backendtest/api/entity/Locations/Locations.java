package backendtest.api.entity.Locations;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import backendtest.api.entity.BaseEntity;
import backendtest.api.entity.Business.Businesses;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "locations")
public class Locations extends BaseEntity{
    
    @Column(name = "longtitude")
    private Integer longtitude;

    @Column(name = "latitude")
    private Integer latitude;

    @Column(name = "address")
    private String address;

    @Column(name = "country_code")
    private Integer countryCode;

    @Column(name = "language_code")
    private String languageCode;

    @Column(name = "region")
    private String region;

    @Column(name = "radius")
    private Integer radius;

    @OneToOne
    @JsonIgnore
    @JoinColumn(name = "business_id", referencedColumnName = "id")
    private Businesses business;

}
