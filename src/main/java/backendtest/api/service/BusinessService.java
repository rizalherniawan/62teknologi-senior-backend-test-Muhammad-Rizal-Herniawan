package backendtest.api.service;

import java.util.List;

import backendtest.api.dto.BusinessDTO;
import backendtest.api.entity.Business.Businesses;

public interface BusinessService {
    Businesses create(BusinessDTO request);
    List<Businesses> fetch(String name, String location, Integer latitude, Integer longtitude, String[] categories);
    Businesses update(BusinessDTO request, String id);
}
