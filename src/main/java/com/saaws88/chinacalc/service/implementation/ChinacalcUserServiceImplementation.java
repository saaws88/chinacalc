package com.saaws88.chinacalc.service.implementation;

import com.saaws88.chinacalc.domain.model.user.ChinacalcUser;
import com.saaws88.chinacalc.domain.model.user.enumerated.Role;
import com.saaws88.chinacalc.infrastructure.repo.UserRepository;
import com.saaws88.chinacalc.infrastructure.util.emailsender.EmailService;
import com.saaws88.chinacalc.infrastructure.util.passgen.PassGen;
import com.saaws88.chinacalc.service.ChinacalcUserService;
import com.saaws88.chinacalc.service.implementation.exception.ObjectAlreadyExistsException;
import com.saaws88.chinacalc.service.implementation.exception.ObjectNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;

@Service
@AllArgsConstructor
public class ChinacalcUserServiceImplementation implements ChinacalcUserService {

  private final UserRepository userRepository;
  private final BCryptPasswordEncoder encoder;
  private final EmailService emailService;

  @Override
  public void createUser(ChinacalcUser user) {

    String userEmail = user.getEmail().toLowerCase();
    if (isEmailExist(userEmail)) {
      throw new ObjectAlreadyExistsException(String.format("Пользователь с почтовым адресом %s уже существует", userEmail));
    }
    user.setEmail(userEmail);
    user.setUsername(userEmail);
    String password = PassGen.generatePassayPassword();
    emailService.sendTemporaryPassword(userEmail, password);
    user.setPassword(encoder.encode(password));
    user.setRoles(new HashSet<>());
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
    return userRepository.findById(id).orElseThrow(() -> new ObjectNotFoundException("Пользователь не найден"));
  }

  @Override
  public void updateUser(ChinacalcUser user) {

    ChinacalcUser updatedUserEntity = getUserById(user.getId());

    if (updatedUserEntity.getEmail().equals(user.getEmail())
        && updatedUserEntity.getRoles().equals(user.getRoles())) {
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
    updatedUserEntity.setPassword(encoder.encode(password));
    emailService.sendTemporaryPassword(updatedUserEntity.getEmail(), password);
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
