package backendtest.api.controller;

import java.util.List;

import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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
    public ResponseEntity<BaseResponse<List<BusinessDTO>>> fecthData(
        @RequestParam(required = false) String name,
        @RequestParam(required = false) String location,
        @RequestParam(required = false) Integer latitude,
        @RequestParam(required = false) Integer longtitude,
        @RequestParam(required = false) String[] categories
    ) {
        return new ResponseEntity(new BaseResponse<>(true, 
            this.converterBusinessToBusinessDTO.
                convert(this.businessService.fetch(name, location, latitude, longtitude, categories)), null), HttpStatus.OK);
    }

    @PutMapping("{id}")
    public ResponseEntity<BaseResponse<Businesses>> updateData(
        @PathVariable("id") String id,
        @RequestBody BusinessDTO businessDTO) {
        return new ResponseEntity(new BaseResponse<>(true, 
            this.businessService.update(businessDTO, id), null), HttpStatus.OK);
    }
}
