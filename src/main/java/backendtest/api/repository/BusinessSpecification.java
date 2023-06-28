package backendtest.api.repository;

import java.util.*;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.JoinType;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;


import org.springframework.data.jpa.domain.Specification;
import org.springframework.lang.Nullable;

import antlr.StringUtils;
import backendtest.api.dto.filter.BusinessSpecificationFilter;
import backendtest.api.entity.Business.Businesses;
import backendtest.api.entity.Locations.Locations;

public class BusinessSpecification implements Specification<Businesses>{

    private BusinessSpecificationFilter filter;

    public BusinessSpecification(BusinessSpecificationFilter filter) {
        this.filter = filter;
    }

    @Override
    public Predicate toPredicate(Root<Businesses> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
        List<Predicate> predicates = new ArrayList<>();
        Join<Businesses,Locations> join = root.join("location", JoinType.LEFT);
        if(filter.getLatitude() != null) {
            predicates.add(criteriaBuilder.equal(join.get("latitude"), filter.getLatitude()));
        }
        else if(filter.getLongtitude() != null) {
            predicates.add(criteriaBuilder.equal(join.get("longtitude"), filter.getLongtitude()));
        }
        else if(filter.getLocation() != null && org.apache.commons.lang3.StringUtils.isNotEmpty(filter.getLocation())) {
            predicates.add(criteriaBuilder.like(join.get("address"), "%" + filter.getLocation().toLowerCase() + "%"));
        }
        return criteriaBuilder.and(predicates.toArray(new Predicate[predicates.size()]));
    }
    
}
