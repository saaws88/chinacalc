package org.chinacalcweb.webgui.repo;

import java.util.Optional;

import org.chinacalcweb.webgui.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long>{

  Optional<Customer> findByIndividualTaxpayerNumber(String itn);

}
