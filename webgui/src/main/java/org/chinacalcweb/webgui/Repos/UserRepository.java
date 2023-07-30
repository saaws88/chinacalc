package org.chinacalcweb.webgui.Repos;

import org.springframework.data.repository.CrudRepository;
import org.chinacalcweb.webgui.Models.User;


public interface UserRepository extends CrudRepository<User, Integer> {
    
}
