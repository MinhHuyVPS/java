package security.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import security.entity.Role;
import security.entity.User;

import java.util.Optional;

@Repository
public interface IRoleRepository extends JpaRepository<Role, String> {

}
