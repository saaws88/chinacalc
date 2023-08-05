package org.chinacalcweb.webgui.repos;

import org.chinacalcweb.webgui.models.ChinacalcUser;
import org.springframework.data.repository.CrudRepository;



public interface UserRepository extends CrudRepository<ChinacalcUser, Long> {
    ChinacalcUser findById(long id);
}
