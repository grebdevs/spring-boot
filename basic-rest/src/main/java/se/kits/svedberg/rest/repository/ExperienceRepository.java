package se.kits.svedberg.rest.repository;

import org.springframework.data.repository.CrudRepository;
import se.kits.svedberg.rest.model.Experience;

import java.util.List;

/**
 * Created by Pär Svedberg on 2016-10-24.
 */
public interface ExperienceRepository extends CrudRepository<Experience, Long> {

    @Override
    List<Experience> findAll();
}
