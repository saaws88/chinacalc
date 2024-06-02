package com.saaws88.chinacalc.service.implementation;

import com.saaws88.chinacalc.domain.model.user.ChinacalcUser;
import com.saaws88.chinacalc.infrastructure.repo.UserRepository;
import com.saaws88.chinacalc.infrastructure.util.emailsender.EmailService;
import com.saaws88.chinacalc.service.implementation.exception.ObjectAlreadyExistsException;
import com.saaws88.chinacalc.service.implementation.exception.ObjectNotFoundException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static com.saaws88.chinacalc.domain.model.user.enumerated.Role.ADMIN;
import static com.saaws88.chinacalc.domain.model.user.enumerated.Role.MANAGER;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ChinacalcUserServiceImplementationTest {

  @Mock
  private UserRepository userRepository;
  @Mock
  private BCryptPasswordEncoder encoder;
  @Mock
  private EmailService emailService;

  @InjectMocks
  private ChinacalcUserServiceImplementation userService;

  @Test
  @DisplayName("Юзер с корректными данными создается корректно")
  public void createUser_validData_creates() {
    ChinacalcUser user = new ChinacalcUser();
    user.setEmail("email@e.mail");

    when(userRepository.findByEmail(anyString())).thenReturn(Optional.empty());
    when(encoder.encode(anyString())).thenReturn("encodedPassword");

    userService.createUser(user);
    verify(userRepository).save(user);

  }

  @Test
  @DisplayName("Создание юзера с имейлом, который уже существует")
  public void createUser_userWithCurrentEmailAlreadyExists_throwsException() {

    ChinacalcUser user1 = new ChinacalcUser();
    user1.setEmail("email@e.mail");
    ChinacalcUser user2 = new ChinacalcUser();
    user2.setEmail("email@e.mail");

    when(userRepository.findByEmail(anyString())).thenReturn(Optional.of(user1));

    assertThrows(ObjectAlreadyExistsException.class, ()-> userService.createUser(user2));

  }

  @Test
  @DisplayName("FindAll с двумя сущностями находит две сущности")
  public void findAll_withTwoEntities_findsAll() {

    ChinacalcUser user1 = new ChinacalcUser();
    user1.setEmail("email@e.mail");
    ChinacalcUser user2 = new ChinacalcUser();
    user2.setEmail("email@ema.il");

    List<ChinacalcUser> savedUsers = new ArrayList<>();
    savedUsers.add(user1);
    savedUsers.add(user2);
    when(userRepository.findAll()).thenReturn(savedUsers);

    List<ChinacalcUser> all = userService.findAll();

    assertEquals(2, all.size());
  }

  @Test
  @DisplayName("Удаление пользователя удаляет пользователя из БД")
  public void deleteUser_idOne_deletesUser() {

    Long userId = 1L;
    userService.deleteUserById(userId);
    verify(userRepository).deleteById(userId);

  }

  @Test
  @DisplayName("Юзер с существующим ID находится")
  public void testGetUserById_PositiveCase() {
    Long userId = 1L;
    ChinacalcUser user = new ChinacalcUser(); // Create a sample user object

    when(userRepository.findById(userId)).thenReturn(Optional.of(user));
    ChinacalcUser retrievedUser = userService.getUserById(userId);

    verify(userRepository).findById(userId);
    assertEquals(user, retrievedUser);

  }

  @Test
  @DisplayName("Юзер с несуществующим ID не находится, бросается исключение")
  public void testGetUserById_NegativeCase() {

    Long userId = 1L;
    when(userRepository.findById(userId)).thenReturn(Optional.empty());
    assertThrows(ObjectNotFoundException.class, () -> userService.getUserById(userId));

  }

  @Test
  @DisplayName("Пользователь c валидными новыми данными обновлен")
  public void updateUser_newUserValidData_Updates() {
    ChinacalcUser user = new ChinacalcUser();
    user.setId(1L);
    user.setEmail("test@example.com");
    user.getRoles().add(MANAGER);

    ChinacalcUser updatedUserEntity = new ChinacalcUser();
    updatedUserEntity.setId(1L);
    updatedUserEntity.setEmail("old@example.com");
    updatedUserEntity.getRoles().add(ADMIN);

    when(userRepository.findById(user.getId())).thenReturn(Optional.of(updatedUserEntity));

    userService.updateUser(user);

    verify(userRepository).save(updatedUserEntity);

    assertEquals(user.getEmail(), updatedUserEntity.getEmail());
    assertTrue(updatedUserEntity.getRoles().contains(MANAGER));

  }

  @Test
  @DisplayName("Пользователь с теми же данными не обновлен")
  public void updateUser_newUserSameData_nothingHappens() {
    ChinacalcUser user = new ChinacalcUser();
    user.setId(1L);
    user.setEmail("test@example.com");
    user.getRoles().add(MANAGER);

    ChinacalcUser updatedUserEntity = new ChinacalcUser();
    updatedUserEntity.setId(1L);
    updatedUserEntity.setEmail("test@example.com");
    updatedUserEntity.getRoles().add(MANAGER);

    when(userRepository.findById(user.getId())).thenReturn(Optional.of(updatedUserEntity));

    userService.updateUser(user);

    verify(userRepository, times(0)).save(any());

  }

  @Test
  @DisplayName("Обновление пароля сохраняет нового пользователя")
  public void testUpdateUserPassword_PositiveCase() {
    ChinacalcUser user = new ChinacalcUser();
    user.setId(1L);
    user.setEmail("test@example.com");

    userService.createUser(user);

    ChinacalcUser updatedUserEntity = new ChinacalcUser();
    updatedUserEntity.setId(1L);
    updatedUserEntity.setEmail("test@example.com");

    when(userRepository.findById(user.getId())).thenReturn(Optional.of(updatedUserEntity));

    userService.updateUserPassword(user);

    verify(userRepository).save(updatedUserEntity);
  }

  @Test
  @DisplayName("Проверка на наличие пользователя с имейлом находит пользователя")
  public void isEmailExist() {

    String mail = "test@e.mail";

    ChinacalcUser user = new ChinacalcUser();
    user.setEmail(mail);

    when(userRepository.findByEmail(mail)).thenReturn(Optional.of(user));

    userService.isEmailExist(mail);

    assertTrue(userService.isEmailExist(mail));

  }

  @Test
  @DisplayName("Блокировка пользователя работает")
  public void blockUserById_validData_blockAsIntended() {

    ChinacalcUser user = new ChinacalcUser();
    user.setId(1L);

    when(userRepository.findById(1L)).thenReturn(Optional.of(user));

    userService.blockUserById(1L);

    assertFalse(userService.getUserById(1L).isCredentialsNonExpired());

  }


}


