package com.fagenius.fleetapp.services;

import com.fagenius.fleetapp.models.User;
import com.fagenius.fleetapp.models.UserPrincipal;
import com.fagenius.fleetapp.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class MyUserDetailsService implements UserDetailsService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByusername(username);
        if(user == null){
            throw new UsernameNotFoundException("user not found !");
        }
        return new UserPrincipal(user);
    }
}
