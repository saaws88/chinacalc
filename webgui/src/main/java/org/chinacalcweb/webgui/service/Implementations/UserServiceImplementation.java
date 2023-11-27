package org.chinacalcweb.webgui.service.Implementations;

import java.util.List;

import org.chinacalcweb.webgui.config.util.PassGen;
import org.chinacalcweb.webgui.model.ChinacalcUser;
import org.chinacalcweb.webgui.model.Role;
import org.chinacalcweb.webgui.repo.UserRepository;
import org.chinacalcweb.webgui.service.UserService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
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
    
    String userEmail = user.getEmail().toLowerCase();
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

  @Override
  public void deleteUserById (Long id) {
    userRepository.deleteById(id);
  }

  @Override
  public ChinacalcUser getUserById(Long id) {
    return userRepository.findById(id).get();
  }

  @Override
  public void updateUser(ChinacalcUser user) {

    ChinacalcUser updatedUserEntity = userRepository.findById(user.getId()).
      orElseThrow(() -> new UsernameNotFoundException("Пользователь не найден"));

    if (updatedUserEntity.equals(user)) {
      return;
    }
    
    updatedUserEntity.setEmail(user.getEmail());
    updatedUserEntity.setUsername(user.getEmail());
    
    updatedUserEntity.getRoles().clear();
    
    for (Role role : user.getRoles()) {
      updatedUserEntity.getRoles().add(role);
    }
   
    userRepository.save(updatedUserEntity);

  }

  @Override
  public void blockUserById(Long id) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'blockUserById'");
  }

  @Override
  public boolean isExist(String email) {
    
    if (!userRepository.findByEmail(email).isPresent()) {
      return false;
    }

    return true;

  }

}
