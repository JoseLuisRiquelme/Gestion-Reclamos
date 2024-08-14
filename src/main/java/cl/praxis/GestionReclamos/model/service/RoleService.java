package cl.praxis.GestionReclamos.model.service;

import cl.praxis.GestionReclamos.model.entities.Role;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface RoleService {
    List<Role> findAll();
    Role findOne(int id);
    boolean create(Role r);
    boolean update(Role r);
    boolean delete(int id);
}
