package com.saaws88.chinacalc.repo;

import java.util.Optional;

import com.saaws88.chinacalc.domain.model.user.ChinacalcUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<ChinacalcUser, Long> {

  Optional<ChinacalcUser> findByEmail(String email);

}
