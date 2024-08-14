package cl.praxis.GestionReclamos.model.service;

import cl.praxis.GestionReclamos.model.entities.Complain;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface ComplainService {
    List<Complain> findAll();
    Complain findOne(int id);
    boolean create(Complain c);
    boolean update(Complain c);
    boolean delete(int id);
}
