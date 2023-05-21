package backendtest.api.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import backendtest.api.entity.Business.Businesses;

public interface BusinessRepository extends JpaRepository<Businesses, String> {
    List<Businesses> findByNameContaining(String name);
    List<Businesses> findByCategoriesContaining(String categories);
}
