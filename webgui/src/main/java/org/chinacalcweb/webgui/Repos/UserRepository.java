package org.chinacalcweb.webgui.Repos;

import org.chinacalcweb.webgui.Models.ChinacalcUser;
import org.springframework.data.repository.CrudRepository;


public interface UserRepository extends CrudRepository<ChinacalcUser, Integer> {

}
