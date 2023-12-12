package org.chinacalcweb.webgui.repo;

import org.chinacalcweb.webgui.model.CurrencyEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CurrencyRepository extends CrudRepository<CurrencyEntity, String> {}
