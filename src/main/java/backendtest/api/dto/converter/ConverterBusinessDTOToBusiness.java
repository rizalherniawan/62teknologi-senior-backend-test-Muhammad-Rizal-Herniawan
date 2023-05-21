package backendtest.api.dto.converter;

import java.util.Date;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import backendtest.api.dto.BusinessDTO;
import backendtest.api.entity.Business.BusinessFlags;
import backendtest.api.entity.Business.Businesses;
import backendtest.api.entity.Locations.Locations;

@Service(ConverterBusinessDTOToBusiness.CONVERTER)
public class ConverterBusinessDTOToBusiness implements Converter<BusinessDTO, Businesses> {

    public static final String CONVERTER = "ConverterBusinessDTOToBusiness";

    @Override
    public Businesses convert(BusinessDTO object) {
        Businesses business = new Businesses();
        business.setName(object.getName());
        if(object.getCategories() != null && object.getCategories().length > 0) {
            String categories = object.getCategories().length > 1 ? String.join(",", object.getCategories()) : object.getCategories()[0];
            business.setCategories(categories);
        }
        if(object.getOpenAt() != null) {
            business.setOpenAt(object.getOpenAt());
        }
        if(object.getClosedAt() != null) {
            business.setClosedAt(object.getClosedAt());
        }
        if(object.getPriceRange() != null) {
            business.setPriceRange(object.getPriceRange());
        }
        if(object.getLocation() != null) {
            Locations location = new Locations();
            BeanUtils.copyProperties(object.getLocation(), location);
            location.setBusiness(business);
            business.setLocation(location);
        }
        if(object.getFlag() != null){
            BusinessFlags flag = new BusinessFlags();
            BeanUtils.copyProperties(object.getFlag(), flag);
            flag.setBusiness(business);
            business.setBusinessFlag(flag);
        }
        return business;
    }
    
}
