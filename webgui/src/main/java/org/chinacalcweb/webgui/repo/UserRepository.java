package org.chinacalcweb.webgui.repo;

import java.util.Optional;

import org.chinacalcweb.webgui.model.ChinacalcUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<ChinacalcUser, Long> {
  
  Optional<ChinacalcUser> findByEmail(String email);
  
}
