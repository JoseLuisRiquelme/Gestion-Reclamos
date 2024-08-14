package cl.praxis.GestionReclamos.model.service;

import cl.praxis.GestionReclamos.model.entities.Role;
import cl.praxis.GestionReclamos.model.repositories.RoleRepository;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class RoleServiceImpl implements RoleService {
    RoleRepository rRepo;

    public RoleServiceImpl(RoleRepository rRepo) {
        this.rRepo = rRepo;
    }

    @Override
    public List<Role> findAll() {
        return rRepo.findAll();
    }

    @Override
    public Role findOne(int id) {
        return rRepo.findById(id).orElse(null);
    }

    @Override
    public boolean create(Role r) {
        Role result=rRepo.save(r);
        return result!=null;
    }

    @Override
    public boolean update(Role r) {
        Role result=rRepo.save(r);
        return result!=null;
    }

    @Override
    public boolean delete(int id) {
        boolean exist=rRepo.existsById(id);
        if(exist){
            rRepo.deleteById(id);
        }
        return exist;
    }
}
