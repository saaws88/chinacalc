package com.saaws88.chinacalc.service.implementation;

import com.saaws88.chinacalc.domain.model.customer.Customer;
import com.saaws88.chinacalc.infrastructure.repo.CustomerRepository;
import com.saaws88.chinacalc.service.implementation.exception.ObjectNotFoundException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;


@ExtendWith(MockitoExtension.class)
public class CustomerServiceImplementationTest {

  @Mock
  CustomerRepository repository;
  @InjectMocks
  CustomerServiceImplementation service;

  @Test
  @DisplayName("Клиент с валидными данными создается")
  public void createCustomer_validData_saveCustomer() {

    Customer customer = new Customer();

    service.createCustomer(customer);

    verify(repository).save(customer);

  }

  @Test
  @DisplayName("Имя частных лиц слепляется красиво")
  public void createCustomer_isPrivatePerson_customerNameIsConcatenatedContactInfo() {

    Customer customer = Customer.builder().
        id(1L).
        privatePerson(true)
        .contactLastName("Зубенко")
        .contactFirstName("Михаил")
        .contactPatronymic("Петрович")
        .build();

    service.createCustomer(customer);

    assertEquals("Зубенко Михаил Петрович", customer.getCustomerName());
  }

  @Test
  @DisplayName("Удаление по id работает")
  public void deleteById_idEqualsOne_deletes() {

    Customer customer = new Customer();
    customer.setId(1L);

    service.deleteCustomerById(1L);

    verify(repository).deleteById(1L);

  }

  @Test
  @DisplayName("Поиск всех клиентов находит 2 клиента")
  public void findAll_twoCustomers_findsTwoCustomers() {

    List<Customer> customers = new ArrayList<>();
    customers.add(new Customer());
    customers.add(new Customer());

    when(repository.findAll()).thenReturn(customers);

    List<Customer> foundCustomers = service.findAll();

    assertEquals(customers.size(), foundCustomers.size());

  }

  @Test
  @DisplayName("Клиент с новыми данными обновлен")
  public void updateCustomer_newCustomerValidData_Updates() {
    Customer customer = new Customer();
    customer.setId(1L);
    customer.setCustomerName("Aloe Vera");
    customer.setPrivatePerson(true);
    customer.setTaxpayerIdentificationNumber("1111111111");

    Customer updatedCustomer = new Customer();
    updatedCustomer.setId(1L);
    updatedCustomer.setCustomerName("Vera Aloe");
    customer.setPrivatePerson(true);
    customer.setTaxpayerIdentificationNumber("1111111121");

    when(repository.findById(customer.getId())).thenReturn(Optional.of(updatedCustomer));

    service.updateCustomer(customer);

    verify(repository).save(updatedCustomer);

    assertEquals(customer.getId(), updatedCustomer.getId());
    assertNotEquals(customer.getCustomerName(), updatedCustomer.getCustomerName());

  }

  @Test
  @DisplayName("Клиент с теми же данными не обновлен")
  public void updateCustomer_newCustomerSameData_NothingHappens() {
    Customer customer = new Customer();
    customer.setId(1L);
    customer.setCustomerName("Aloe Vera");
    customer.setPrivatePerson(true);
    customer.setTaxpayerIdentificationNumber("1111111111");

    Customer updatedCustomer = customer;

    when(repository.findById(customer.getId())).thenReturn(Optional.of(updatedCustomer));

    service.updateCustomer(customer);

    verify(repository, times(0)).save(updatedCustomer);

  }

  @Test
  @DisplayName("Имя клиента ЮЛ обновляется корректно")
  public void updateCustomer_customerIsNotPrivatePerson_setsNameCorrectly() {
    Customer customer = new Customer();
    customer.setId(1L);
    customer.setCustomerName("Aloe Vera");
    customer.setPrivatePerson(false);

    Customer updatedCustomer = customer;
    updatedCustomer.setCustomerName("Vera Aloe");

    when(repository.findById(customer.getId())).thenReturn(Optional.of(updatedCustomer));

    service.updateCustomer(customer);

    verify(repository, times(0)).save(updatedCustomer);
    assertEquals(customer.getCustomerName(), updatedCustomer.getCustomerName());

  }

  @Test
  @DisplayName("Метод с существующим пользователем обновляет пользователя")
  public void createOrUpdateCustomer_customerExists_updatesCustomer() {

    Customer customer = new Customer();
    customer.setId(1L);
    customer.setCustomerName("Beeb");

    Customer newNamedCustomer = new Customer();
    newNamedCustomer.setId(1L);
    newNamedCustomer.setCustomerName("Boob");

    when(repository.findById(newNamedCustomer.getId())).thenReturn(Optional.of(customer));

    service.createOrUpdateCustomer(newNamedCustomer);

    assertEquals(customer.getCustomerName(), newNamedCustomer.getCustomerName());

  }

  @Test
  @DisplayName("Метод с существующим пользователем обновляет пользователя")
  public void createOrUpdateCustomer_customerNotExist_createsCustomer() {

    Customer customer = new Customer();
    customer.setId(1L);
    customer.setCustomerName("Beeb");

    when(repository.findById(customer.getId())).thenReturn(Optional.empty());

    service.createOrUpdateCustomer(customer);

    verify(repository).save(customer);
    assertEquals(1L, customer.getId());

  }

  @Test
  @DisplayName("Бросает исключение если искать клиента с несуществующим id по id")
  public void getCustomerById_customerNotExist_throwsException() {

    when(repository.findById(anyLong())).thenReturn(Optional.empty());

    assertThrows(ObjectNotFoundException.class, () -> service.getCustomerById(1L));

  }



}
