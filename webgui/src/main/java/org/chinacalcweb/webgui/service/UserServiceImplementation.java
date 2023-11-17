package org.chinacalcweb.webgui.service;

import java.util.List;

import org.chinacalcweb.webgui.config.util.PassGen;
import org.chinacalcweb.webgui.model.ChinacalcUser;
import org.chinacalcweb.webgui.model.Role;
import org.chinacalcweb.webgui.repo.UserRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImplementation implements UserService {

  private final UserRepository userRepository;
  private final BCryptPasswordEncoder encoder;
  
  public UserServiceImplementation(UserRepository userRepository, BCryptPasswordEncoder encoder) {

    this.userRepository = userRepository;
    this.encoder = encoder;

  }

  @Override
  public void createUser(ChinacalcUser user) {
    
    String userEmail = user.getEmail();
    if (userRepository.findByEmail(userEmail).isPresent()) {
      throw new RuntimeException("Пользователь с почтовым адресом " + userEmail + " уже существует");
    }
    user.setEmail(userEmail);
    user.setUsername(userEmail);
    String password = PassGen.generatePassayPassword();
    user.setPassword(encoder.encode(password));
    user.getRoles().add(Role.USER);

    userRepository.save(user);
  }

  @Override
  public List<ChinacalcUser> findAll() {
    return userRepository.findAll();  
  }
  
}
