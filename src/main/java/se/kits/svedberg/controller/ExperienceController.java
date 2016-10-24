package se.kits.svedberg.controller;

import se.kits.svedberg.model.Experience;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import se.kits.svedberg.repository.ExperienceRepository;

import javax.validation.constraints.NotNull;
import java.util.Collection;

/**
 * Created by Pär Svedberg on 2016-10-18.
 */
@RequestMapping("/svedberg/experience")
@RestController
public class ExperienceController {

    @Autowired
    private ExperienceRepository experienceRepository;

    @RequestMapping(
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<Collection<Experience>> getExperiences() {
        return new ResponseEntity<Collection<Experience>>(experienceRepository.findAll(), HttpStatus.OK);
    }

    @RequestMapping(
            value = "/{id}",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<Experience> getExperience(@PathVariable("id") Long id) {
        Experience exp = experienceRepository.findOne(id);
        if (exp == null) {
            return new ResponseEntity<Experience>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<Experience>(exp, HttpStatus.OK);
    }

    @RequestMapping(
            method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<Experience> createExperience(@RequestBody Experience newExperience) {
        return new ResponseEntity<Experience>(experienceRepository.save(newExperience), HttpStatus.CREATED);
    }

    @RequestMapping(
            value = "/{id}",
            method = RequestMethod.PUT,
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<Experience> updateExperience(@RequestBody Experience exp, @PathVariable("id") Long id) {
        if (exp.getId().compareTo(id) != 0) {
            return new ResponseEntity<Experience>(HttpStatus.BAD_REQUEST);
        }
        Experience updatedExperience = experienceRepository.save(exp);
        if (updatedExperience == null) {
            return new ResponseEntity<Experience>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<Experience>(updatedExperience, HttpStatus.OK);
    }

    @RequestMapping(
            value = "/{id}",
            method = RequestMethod.DELETE,
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<Experience> deleteExperience(@NotNull @PathVariable("id") Long id) {
//        if (exp.getId().compareTo(id) != 0) {
//            return new ResponseEntity<Experience>(HttpStatus.BAD_REQUEST);
//        }

        if (!experienceRepository.exists(id)) {
            return new ResponseEntity<Experience>(HttpStatus.NOT_FOUND);
        }
        experienceRepository.delete(id);
        return new ResponseEntity<Experience>(HttpStatus.NO_CONTENT);
    }


}
