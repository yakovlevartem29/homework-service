package com.homework.web.rest;


import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;


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
    @ApiOperation(value = "Finds all words that are duplicated in the sentence and return an array of those words",
            notes = "A sentence is minimally defined as a word or group of words. "
                    + "We consider a word to be a sequence of letters (i.e.: a-zA-Z ) "
                    + "delimited by a space or non-letter character.\n"
                    + "A repeated word is a case-sensitive word that appears more than once in a sentence (e.g.: 'had' ≠ 'Had').\n"
                    + "Because substrings of a word are not delimited, they are not considered to be words.")
    public ResponseEntity<Collection<String>> getDuplicatedWords(
            @ApiParam(defaultValue = "How much wood could a woodchuck chuck if a woodchuck could chuck wood?")
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
