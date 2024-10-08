package cl.praxis.GestionReclamos.model.repositories;

import cl.praxis.GestionReclamos.model.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User,Integer> {
    Optional<User> findOneByEmail(String username);
}
