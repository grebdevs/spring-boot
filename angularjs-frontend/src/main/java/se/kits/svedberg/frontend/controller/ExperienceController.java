package se.kits.svedberg.frontend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import se.kits.svedberg.frontend.model.Experience;
import se.kits.svedberg.frontend.service.ExperienceService;

import java.util.Collection;

/**
 * Created by Pär Svedberg on 2016-10-18.
 */
@RequestMapping("/svedberg/experience")
@RestController
public class ExperienceController {

    @Autowired
    private ExperienceService experienceService;

    @RequestMapping(
//            value = "/",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<Collection<Experience>> getExperiences() {
        return new ResponseEntity<Collection<Experience>>(experienceService.findAll(), HttpStatus.OK);
    }

    @RequestMapping(
            value = "/{id}",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<Experience> getExperience(@PathVariable("id") Long id) {
        Experience exp = experienceService.findOne(id);
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
        return new ResponseEntity<Experience>(experienceService.create(newExperience), HttpStatus.CREATED);
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
        Experience updatedExperience = experienceService.update(exp);
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
    public ResponseEntity<Experience> deleteExperience(@RequestBody Experience exp, @PathVariable("id") Long id) {
        if (exp.getId().compareTo(id) != 0) {
            return new ResponseEntity<Experience>(HttpStatus.BAD_REQUEST);
        }
        if (!experienceService.delete(exp)) {
            return new ResponseEntity<Experience>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<Experience>(HttpStatus.NO_CONTENT);
    }


}
