package com.homework.web.rest;

import com.homework.service.SentenceService;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class SentenceResourceTest {

    @Mock
    private SentenceService sentenceService;
    @InjectMocks
    private SentenceResource sentenceResource;

    @Test
    public void testSentenceDuplicates() {
        String sentence = "testSentenceDuplicates";
        sentenceResource.getDuplicatedWords(sentence);
        verify(sentenceService, times(1))
                .findDuplicateWords(eq(sentence));
    }
}
