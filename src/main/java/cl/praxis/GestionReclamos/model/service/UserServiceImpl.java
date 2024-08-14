package cl.praxis.GestionReclamos.model.service;

import cl.praxis.GestionReclamos.model.entities.User;
import cl.praxis.GestionReclamos.model.repositories.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UserServiceImpl implements UserService {
    UserRepository uRepo;

    public UserServiceImpl(UserRepository uRepo) {
        this.uRepo = uRepo;
    }

    @Override
    public List<User> findAll() {
        return uRepo.findAll();
    }

    @Override
    public User findOne(int id) {
        return uRepo.findById(id).orElse(null);
    }

    @Override
    public boolean create(User u) {
        User result=uRepo.save(u);
        return result!=null;
    }

    @Override
    public boolean update(User u) {
        User result=uRepo.save(u);
        return result!=null;
    }

    @Override
    public boolean delete(int id) {
        boolean exist = uRepo.existsById(id);
        if(exist){
            uRepo.deleteById(id);
        }
        return exist;
    }
}
