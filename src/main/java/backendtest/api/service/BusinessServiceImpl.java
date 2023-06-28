package backendtest.api.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.web.server.ResponseStatusException;

import backendtest.api.dto.BusinessDTO;
import backendtest.api.dto.converter.ConverterBusinessDTOToBusiness;
import backendtest.api.dto.filter.BusinessSpecificationFilter;
import backendtest.api.entity.Business.Businesses;
import backendtest.api.exception.NotFoundException;
import backendtest.api.exception.RequestException;
import backendtest.api.repository.BusinessRepository;
import backendtest.api.repository.BusinessSpecification;

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
    public List<Businesses> fetch(String name, String location, Integer latitude, Integer longtitude, String[] categories) {
        List<Businesses> businesses = new ArrayList<>();
        BusinessSpecificationFilter filter = new BusinessSpecificationFilter();
        if(name != null && StringUtils.isNotEmpty(name)) {
            businesses = this.businessRepository.findByNameContaining(name);
        }
        else if(location != null && StringUtils.isNotEmpty(location)) {
            filter.setLocation(location);
            businesses = this.businessRepository.findAll(new BusinessSpecification(filter));
        }
        else if(latitude != null) {
            filter.setLongtitude(latitude);
            businesses = this.businessRepository.findAll(new BusinessSpecification(filter));
        }
        else if(longtitude != null) {
            filter.setLongtitude(longtitude);
            businesses = this.businessRepository.findAll(new BusinessSpecification(filter));
        }
        else if(categories != null && !CollectionUtils.isEmpty(Arrays.asList(categories))) {
            businesses = this.businessRepository.findByCategoriesContaining(String.join(",", categories));
        }
        return businesses;
    }

    @Override
    public Businesses update(BusinessDTO request, String id) {
        Optional<Businesses> existingBusiness = this.businessRepository.findById(id);
        if(!existingBusiness.isPresent()) {
            throw new NotFoundException("business not found");
        }
        Businesses oldBusiness = existingBusiness.get();
        Businesses newBusiness = this.converterBusinessDTOtoBusiness.convert(request);
        
        oldBusiness.setUpdatedAt(new Date());
        oldBusiness.getBusinessFlag().setUpdatedAt(new Date());
        oldBusiness.getLocation().setUpdatedAt(new Date());
        Businesses updatedBusiness = this.businessRepository.save(oldBusiness);
        return updatedBusiness;
    }
    
}
