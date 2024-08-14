package cl.praxis.GestionReclamos.model.repositories;

import cl.praxis.GestionReclamos.model.entities.Complain;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ComplainRepository extends JpaRepository<Complain,Integer> {
}
