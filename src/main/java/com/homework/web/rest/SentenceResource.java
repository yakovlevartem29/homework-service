package com.homework.web.rest;


import com.homework.service.SentenceService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.util.Collection;

/**
 * REST controller for managing Patient.
 */
@RestController
@RequestMapping(value = "/api/sentence", produces = MediaType.APPLICATION_JSON_VALUE)
public class SentenceResource {

    private static final Logger LOG = LoggerFactory.getLogger(SentenceResource.class);

    @Autowired
    private SentenceService sentenceService;

    @GetMapping("/duplicates")
    public ResponseEntity<Collection<String>> getDuplicatedWords(
            @RequestParam(value = "sentence", defaultValue = "") String sentence) {
        LOG.debug("Request to find duplicates in sentence [{}]", sentence);
        try {
            Collection<String> duplicateWords = sentenceService.findDuplicateWords(sentence);
            return new ResponseEntity<>(duplicateWords, HttpStatus.OK);
        } catch (Exception e) {
            // oom?
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Failed to find duplicates", e);
        }
    }
}
