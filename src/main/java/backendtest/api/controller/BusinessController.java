package backendtest.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import backendtest.api.dto.BusinessDTO;
import backendtest.api.dto.converter.ConverterBusinessToBusinessDTO;
import backendtest.api.dto.response.BaseResponse;
import backendtest.api.entity.Business.Businesses;
import backendtest.api.service.BusinessService;

@RestController
@RequestMapping("/v1/business")
public class BusinessController {

    @Autowired
    BusinessService businessService;

    @Autowired
    ConverterBusinessToBusinessDTO converterBusinessToBusinessDTO;

    @PostMapping
    public ResponseEntity<BaseResponse<Businesses>> postData(@RequestBody BusinessDTO businessDTO) {
        Businesses savedBusiness = this.businessService.create(businessDTO);
        return new ResponseEntity(new BaseResponse<>(true, savedBusiness, null), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<BaseResponse<BusinessDTO>> fecthData(
        @RequestParam(value = "name", required = false) String name,
        @RequestParam(value = "location", required = false) String location,
        @RequestParam(value = "latitude", required = false) Integer latitude,
        @RequestParam(value = "longtitude", required = false) Integer longtitude,
        @RequestParam(value = "categories", required = false) String[] categories
    ) {
        return new ResponseEntity(new BaseResponse<>(true, 
            this.converterBusinessToBusinessDTO.
                convert(this.businessService.fetch(name, location, latitude, longtitude, categories)), null), HttpStatus.OK);
    }
}
