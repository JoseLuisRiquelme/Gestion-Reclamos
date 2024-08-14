package cl.praxis.GestionReclamos.model.service;

import cl.praxis.GestionReclamos.model.entities.User;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface UserService {
    List<User> findAll();
    User findOne(int id);
    boolean create(User u);
    boolean update(User u);
    boolean delete(int id);
}
