package backendtest.api.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.web.server.ResponseStatusException;

import backendtest.api.dto.BusinessDTO;
import backendtest.api.dto.converter.ConverterBusinessDTOToBusiness;
import backendtest.api.entity.Business.Businesses;
import backendtest.api.exception.RequestException;
import backendtest.api.repository.BusinessRepository;

@Service
public class BusinessServiceImpl implements BusinessService {

    @Autowired
    private ConverterBusinessDTOToBusiness converterBusinessDTOtoBusiness;

    @Autowired
    private BusinessRepository businessRepository;

    @Override
    @Transactional
    public Businesses create(BusinessDTO request) {
        if(StringUtils.isEmpty(request.getName())) {
            throw new RequestException("name cannot be empty");
        }
        Businesses setBusiness = this.converterBusinessDTOtoBusiness.convert(request);
        setBusiness.setCreatedAt(new Date());
        setBusiness.getLocation().setCreatedAt(new Date());
        setBusiness.getBusinessFlag().setCreatedAt(new Date());
        Businesses savedBusiness = this.businessRepository.save(setBusiness);
        return savedBusiness;
    }

    @Override
    public List<Businesses> fetch(String name, String location, Integer latitude, Integer longtitude,
            String[] categories) {
        List<Businesses> businesses = new ArrayList<>();
        if(StringUtils.isNotEmpty(name)){
            businesses = this.businessRepository.findByNameContaining(name);
        }
        else if(!CollectionUtils.isEmpty(Arrays.asList(categories))){
            businesses = this.businessRepository.findByCategoriesContaining(String.join(",", categories));
        }
        return businesses;
    }
    
}
