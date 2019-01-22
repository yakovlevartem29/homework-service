package com.homework.service;

import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class SentenceServiceTests {

    @InjectMocks
    private SentenceService sentenceService;

    @Test
    public void testOneWord() {
        String oneWord = "fruit";
        Assertions.assertThat(sentenceService.findDuplicateWords(oneWord))
                .as("Check single word").isEmpty();
    }

    @Test
    public void testOneDuplicate() {
        String oneDuplicate = "apple  banana apple ";
        Assertions.assertThat(sentenceService.findDuplicateWords(oneDuplicate))
                .as("Check one duplicate word").containsExactly("apple");
    }

    @Test
    public void testMultipleDuplicates() {
        String oneDuplicate = "one two!two?two one-one three_five!five";
        Assertions.assertThat(sentenceService.findDuplicateWords(oneDuplicate))
                .as("Check input has multiple occurrences of the same word")
                .containsExactlyInAnyOrder("one", "two", "five");
    }

    @Test
    public void testInvalidInput() {
        Assertions.assertThat(sentenceService.findDuplicateWords(null))
                .as("Check null input").isEmpty();
    }

}
