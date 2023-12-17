package rentals.repository;

import org.springframework.data.repository.CrudRepository;
import rentals.persistence.User;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends CrudRepository<User, Long> {
    List<User> findAll();

    Optional<User> findById(Long id);
    // custom queries here if needed
}
