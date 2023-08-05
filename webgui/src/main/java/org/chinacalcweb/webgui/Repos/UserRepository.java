package org.chinacalcweb.webgui.repos;

import org.chinacalcweb.webgui.models.ChinacalcUser;
import org.springframework.data.repository.CrudRepository;
import org.springframework.security.core.userdetails.UserDetails;



public interface UserRepository extends CrudRepository<ChinacalcUser, Long> {
    
    ChinacalcUser findById(long id);

    UserDetails findByLogin(String login);
}
