package cl.praxis.GestionReclamos.model.repositories;

import cl.praxis.GestionReclamos.model.entities.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role,Integer> {
    Role findByName(String name);
}
