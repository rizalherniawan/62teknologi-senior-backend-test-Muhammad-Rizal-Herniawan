package backendtest.api.dto.converter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import backendtest.api.dto.BusinessDTO;
import backendtest.api.dto.BusinessFlagDTO;
import backendtest.api.dto.LocationDTO;
import backendtest.api.entity.Business.Businesses;
import backendtest.api.entity.Business.PriceRange;

@Service(ConverterBusinessToBusinessDTO.CONVERTER)
public class ConverterBusinessToBusinessDTO implements Converter<List<Businesses>, List<BusinessDTO>>{

    public static final String CONVERTER = "ConverterBusinessToBusinessDTO";

    @Override
    public List<BusinessDTO> convert(List<Businesses> object) {
        List<BusinessDTO> businesses = new ArrayList<>();
        for(Businesses item: object){
            BusinessDTO business = new BusinessDTO();
            business.setName(item.getName());
            if(StringUtils.isNotEmpty(item.getCategories())) {
                business.setCategories(item.getCategories().split(","));
            }
            if(item.getOpenAt() != null) {
                business.setOpenAt(item.getOpenAt());
            }
            if(item.getClosedAt() != null) {
                business.setClosedAt(item.getClosedAt());
            }
            if(item.getPriceRange() != null) {
                business.setPriceRange(item.getPriceRange());
            }
            if(item.getLocation() != null) {
                LocationDTO location = new LocationDTO();
                BeanUtils.copyProperties(item, location);
                business.setLocation(location);
            }
            if(item.getBusinessFlag() != null) {
                BusinessFlagDTO flag = new BusinessFlagDTO();
                BeanUtils.copyProperties(item, flag);
                business.setFlag(flag);
            }
            businesses.add(business);
        }
        return businesses;
    }

    
}
