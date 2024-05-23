package com.saaws88.chinacalc.repo;

import java.util.Optional;

import com.saaws88.chinacalc.domain.model.customer.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long>{

  Optional<Customer> findByIndividualTaxpayerNumber(String itn);

}
