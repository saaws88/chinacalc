package com.saaws88.chinacalc.infrastructure.dao;

import java.util.List;

import com.saaws88.chinacalc.infrastructure.util.passgen.PassGen;
import com.saaws88.chinacalc.domain.model.user.ChinacalcUser;
import com.saaws88.chinacalc.domain.model.user.enumerated.Role;
import com.saaws88.chinacalc.repo.UserRepository;
import com.saaws88.chinacalc.service.UserPort;
import com.saaws88.chinacalc.infrastructure.util.emailsender.EmailService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class UserDao implements UserPort {

  private final UserRepository userRepository;
  private final BCryptPasswordEncoder encoder;
  private final EmailService emailService;

  @Override
  public void createUser(ChinacalcUser user) {

    String userEmail = user.getEmail().toLowerCase();
    if (isEmailExist(userEmail)) {
      throw new RuntimeException("Пользователь с почтовым адресом " + userEmail + " уже существует");
    }
    user.setEmail(userEmail);
    user.setUsername(userEmail);
    String password = PassGen.generatePassayPassword();
    emailService.sendTemporaryPassword(userEmail, password);
    user.setPassword(encoder.encode(password));
    user.getRoles().add(Role.MANAGER);
    user.setAccountNonExpired(true);
    user.setCredentialsNonExpired(true);
    user.setAccountNonLocked(true);

    userRepository.save(user);
  }

  @Override
  public List<ChinacalcUser> findAll() {
    return userRepository.findAll();
  }

  @Override
  public void deleteUserById(Long id) {
    userRepository.deleteById(id);
  }

  @Override
  public ChinacalcUser getUserById(Long id) {
    return userRepository.findById(id).orElseThrow(() -> new UsernameNotFoundException("Пользователь не найден"));
  }

  @Override
  public void updateUser(ChinacalcUser user) {

    ChinacalcUser updatedUserEntity = getUserById(user.getId());

    if (updatedUserEntity.getEmail().equals(user.getEmail())
        && updatedUserEntity.getRoles().equals(user.getRoles())
        && updatedUserEntity.getUsername().equals(user.getUsername())) {
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
  public void updateUserPassword(ChinacalcUser user) {

    ChinacalcUser updatedUserEntity = getUserById(user.getId());

    String password = PassGen.generatePassayPassword();
    emailService.sendTemporaryPassword(updatedUserEntity.getEmail(), password);
    updatedUserEntity.setPassword(encoder.encode(password));
    userRepository.save(updatedUserEntity);

  }

  @Override
  public boolean isEmailExist(String email) {

    return userRepository.findByEmail(email).isPresent();

  }

  @Override
  public void blockUserById(Long id) {

    ChinacalcUser updatedUserEntity = getUserById(id);

    updatedUserEntity.setCredentialsNonExpired(false);

    userRepository.save(updatedUserEntity);
  }

}
