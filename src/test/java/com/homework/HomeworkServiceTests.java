package com.homework;

import com.homework.web.HomeController;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class HomeworkServiceTests {


    @Autowired
    private HomeController controller;

    @Test
    public void contextLoads() {
        assertThat(controller).as("Check home controller is defined").isNotNull();
    }

}

