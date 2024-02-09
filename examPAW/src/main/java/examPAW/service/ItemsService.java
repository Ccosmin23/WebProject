package examPAW.service;

import org.springframework.stereotype.Service;
import examPAW.entity.ItemEntity;
import examPAW.repository.ItemsRepository;

import java.util.List;

@Service
public class ItemsService {
    private final ItemsRepository itemsRepository;

    public ItemsService(ItemsRepository itemsRepository) {
        this.itemsRepository = itemsRepository;
    }

    public ItemEntity saveItem(ItemEntity itemEntity) {
        return itemsRepository.save(itemEntity);
    }

    public ItemEntity findByID(Integer id) {
        return itemsRepository.findById(id);
    }

    public List<ItemEntity> getAllItems() {
        return itemsRepository.findAll();
    }

}