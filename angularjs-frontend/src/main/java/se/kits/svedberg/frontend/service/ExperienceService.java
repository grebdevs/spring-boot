package se.kits.svedberg.frontend.service;

import se.kits.svedberg.frontend.model.Experience;

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