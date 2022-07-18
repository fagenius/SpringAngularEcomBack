package com.fagenius.fleetapp.services;

import com.fagenius.fleetapp.models.State;
import com.fagenius.fleetapp.models.User;
import com.fagenius.fleetapp.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private BCryptPasswordEncoder encoder;
    @Autowired
    private UserRepository userRepository;

    public void save(User user) {
        user.setPassword( encoder.encode( user.getPassword() ) );
        userRepository.save( user );
    }

    public List<User> findAll() {
        return userRepository.findAll();
    }

    public Optional<User> findById(Integer id) {
        return userRepository.findById( id );
    }

    public void delete(Integer id) {
        userRepository.deleteById( id );
    }
}
