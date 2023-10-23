package org.chinacalcweb.webgui.service;

import org.chinacalcweb.webgui.config.ChinacalcUserDetails;
import org.chinacalcweb.webgui.model.ChinacalcUser;
import org.chinacalcweb.webgui.repo.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import lombok.NoArgsConstructor;

@Service
@NoArgsConstructor
public class ChinacalcUserDetailsService implements UserDetailsService {
    
    private UserRepository userRepository;
    
    public ChinacalcUserDetailsService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
      ChinacalcUser user = userRepository.findByEmail(email)
          .orElseThrow(() -> new UsernameNotFoundException("User not found"));
      return new ChinacalcUserDetails(user);
    }

}
