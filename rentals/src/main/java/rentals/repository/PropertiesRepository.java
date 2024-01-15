package rentals.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import rentals.entity.PropertyEntity;

import java.util.List;

@Repository
public interface PropertiesRepository extends JpaRepository<PropertyEntity, Long> {
    List<PropertyEntity> findAll();
//    void save(PropertyEntity propertyEntity);
}