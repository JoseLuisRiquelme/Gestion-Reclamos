package cl.praxis.GestionReclamos.model.repositories;

import cl.praxis.GestionReclamos.model.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Integer> {
    User findByEmail(String email);
}
