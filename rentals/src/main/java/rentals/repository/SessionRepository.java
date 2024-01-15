package rentals.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import rentals.entity.SessionEntity;
import rentals.persistence.User;

@Repository
public interface SessionRepository extends JpaRepository<User, Long> {
    void save(SessionEntity sessionEntity);
}

