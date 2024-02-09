package examPAW.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import examPAW.entity.ItemEntity;

import java.util.List;

@Repository
public interface ItemsRepository extends JpaRepository<ItemEntity, Long> {
    ItemEntity findById(Integer id);
    List<ItemEntity> findAll();

    @Override
    <S extends ItemEntity> S save(S entity);
}
