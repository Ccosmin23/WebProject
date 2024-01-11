package rentals.repository;

import org.springframework.data.repository.CrudRepository;
import rentals.persistence.User;

public interface UserRepository extends CrudRepository<User, Long> {
    User findByUsername(String username);
}
