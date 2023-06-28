package backendtest.api.repository;

import java.util.List;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import backendtest.api.entity.Business.Businesses;

public interface BusinessRepository extends JpaRepository<Businesses, String>, JpaSpecificationExecutor<Businesses>{
    List<Businesses> findByNameContaining(String name);
    List<Businesses> findByCategoriesContaining(String categories);
}
