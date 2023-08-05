package org.chinacalcweb.webgui.services;

import org.chinacalcweb.webgui.repos.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImplementation implements UserDetailsService {
    
    private UserRepository userRepository;
    
    @Autowired
    public UserDetailsServiceImplementation(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    
    @Override
    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
        UserDetails user = userRepository.findByLogin(login);

        if (user == null) {
            throw new UsernameNotFoundException(String.format("Пользователь %s не найден", login));
        }

        return user;
    }
}
