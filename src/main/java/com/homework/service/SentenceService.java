package com.homework.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

/**
 * Service for sentence related operations
 */
@Service
public class SentenceService {

    private static final Logger LOG = LoggerFactory.getLogger(SentenceService.class);
    private static final String ASCII_WORD_DELIMITER_REGEX = "[^a-zA-Z]+";

    /**
     * Finds all words that are duplicated in the {@code sentence} and return a collection of those words.
     *
     * @param sentence the original sentence
     * @return the collection with duplicated words.
     */
    public Collection<String> findDuplicateWords(String sentence) {
        boolean isEmpty = StringUtils.isEmpty(sentence);
        LOG.debug("Looking for duplicates in the sentence [length={}]",
                isEmpty ? 0 : sentence.length());
        Set<String> duplicates = new HashSet<>();
        if (!isEmpty) {
            Set<String> allWords = new HashSet<>();
            String[] words = sentence.split(ASCII_WORD_DELIMITER_REGEX);
            for (String word : words) {
                if (!allWords.add(word)) {
                    duplicates.add(word);
                }
            }
        }
        LOG.debug("Found [{}] duplicates in the sentence", duplicates.size());
        return duplicates;
    }
}
