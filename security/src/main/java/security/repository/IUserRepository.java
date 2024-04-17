package security.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import security.entity.User;
@Repository
public interface IUserRepository extends JpaRepository<User, String> {
    boolean existsByUsername(String username);
}
