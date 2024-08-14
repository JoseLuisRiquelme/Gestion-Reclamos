package cl.praxis.GestionReclamos.model.service;

import cl.praxis.GestionReclamos.model.entities.Complain;
import cl.praxis.GestionReclamos.model.repositories.ComplainRepository;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ComplainServiceImpl implements ComplainService {

    ComplainRepository cRepo;

    public ComplainServiceImpl(ComplainRepository cRepo) {
        this.cRepo = cRepo;
    }

    @Override
    public List<Complain> findAll() {
        return cRepo.findAll();
    }

    @Override
    public Complain findOne(int id) {
        return cRepo.findById(id).orElse(null);
    }

    @Override
    public boolean create(Complain u) {
        Complain result=cRepo.save(u);
        return result!=null;
    }

    @Override
    public boolean update(Complain u) {
        Complain result=cRepo.save(u);
        return result!=null;
    }

    @Override
    public boolean delete(int id) {
        boolean exist = cRepo.existsById(id);
        if(exist){
            cRepo.deleteById(id);
        }
        return exist;
    }
}
