package org.chinacalcweb.webgui.Repos;

import org.chinacalcweb.webgui.Models.User;
import org.springframework.data.repository.CrudRepository;


public interface UserRepository extends CrudRepository<User, Integer> {

}
