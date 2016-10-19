package se.kits.svedberg.frontend.service;

import org.springframework.stereotype.Service;
import se.kits.svedberg.frontend.model.Experience;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Pär Svedberg
 * Handles CRUD operations of {@link Experience}
 */

@Service
public class ExperienceServiceBean implements ExperienceService {
    private static Long nextId;
    private static Map<Long, Experience> experiences;

    private static Experience store(Experience exp) {
        // Init map
        if (experiences == null) {
            experiences = new HashMap<>();
            nextId = 0L;
        }

        if (exp.getId() == null || experiences.get(exp.getId()) == null) {
            // Create
            while (experiences.get(nextId) != null) {
                nextId = nextId + 1L;
            };
            if (exp.getId() == null) { exp.setId(nextId); }
        } else {
            // Update
            Experience oldExp = experiences.get(exp.getId());
            if (exp.getDuration() == null) { exp.setDuration(oldExp.getDuration()); }
            if (exp.getResponsibilities() == null) { exp.setResponsibilities(oldExp.getResponsibilities()); }
            if (exp.getRole() == null) { exp.setRole(oldExp.getRole()); }
            if (exp.getWorkPlace() == null) { exp.setWorkPlace(oldExp.getWorkPlace()); }
        }

        experiences.put(exp.getId(), exp);
        return exp;
    }

    static {
        Experience e1 = new Experience();
        e1.setRole("Junior backend developer");
        e1.setWorkPlace("Kits AB");
        e1.setResponsibilities("Java stack dev");
        e1.setDuration("August 2016 - present");
        store(e1);

        Experience e2 = new Experience();
        e2.setRole("Master student");
        e2.setWorkPlace("Chalmers University of Technology");
        e2.setResponsibilities("Computer Systems and Networks");
        e2.setDuration("September 2015 - June 2016");
        store(e2);

        Experience e3 = new Experience();
        e3.setRole("Student");
        e3.setWorkPlace("Chalmers University of Technology");
        e3.setResponsibilities("BSc. in Computer Engineering");
        e3.setDuration("September 2012 - June 2015");
        store(e3);
    }

    @Override
    public Collection<Experience> findAll() {
        return experiences.values();
    }

    @Override
    public Experience findOne(Long id) {
        return experiences.get(id);
    }

    @Override
    public Experience create(Experience exp) {
        Experience storedExp = store(exp);
        return storedExp;
    }

    @Override
    public Experience update(Experience exp) {
        Experience updatedExp = update(exp);
        return updatedExp;
    }

    @Override
    public Boolean delete(Experience exp) {
        if (exp == null) return false;
        return experiences.remove(exp) != null;
    }
}
