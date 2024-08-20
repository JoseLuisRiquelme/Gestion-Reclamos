package cl.praxis.GestionReclamos.model.service;

import cl.praxis.GestionReclamos.model.entities.User;
import cl.praxis.GestionReclamos.model.repositories.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UserServiceImpl implements UserService {
    private final UserRepository uRepo;
    private final PasswordEncoder passwordEncoder;

    public UserServiceImpl(UserRepository uRepo, PasswordEncoder passwordEncoder) {
        this.uRepo = uRepo;
        this.passwordEncoder = passwordEncoder;
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
        u.setPassword(passwordEncoder.encode(u.getPassword()));
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
