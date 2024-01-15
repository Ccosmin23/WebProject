package rentals.service;

import org.springframework.stereotype.Service;
import rentals.entity.PropertyEntity;
import rentals.repository.PropertiesRepository;

import java.util.List;

@Service
public class PropertiesService {
    private final PropertiesRepository propertiesRepository;

    public PropertiesService(PropertiesRepository propertiesRepository) {
        this.propertiesRepository = propertiesRepository;
    }

    public void save(PropertyEntity propertyEntity) {
        propertiesRepository.save(propertyEntity);
    }

    public List<PropertyEntity> findAll() {
        return propertiesRepository.findAll();
    }
}