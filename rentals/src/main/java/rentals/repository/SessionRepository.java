package rentals.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import rentals.entity.SessionEntity;
import rentals.entity.UserEntity;

@Repository
public interface SessionRepository extends JpaRepository<UserEntity, Long> {
    void save(SessionEntity sessionEntity);
}

