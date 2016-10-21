package se.kits.svedberg.rest.service;

import se.kits.svedberg.rest.model.Experience;

import java.util.Collection;

/**
 * Created by Pär Svedberg on 2016-10-18.
 */
public interface ExperienceService {
    Collection<Experience> findAll();
    Experience findOne(Long id);
    Experience create(Experience exp);
    Experience update(Experience exp);
    Boolean delete(Experience exp);
}