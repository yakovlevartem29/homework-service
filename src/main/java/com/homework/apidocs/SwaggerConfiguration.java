package com.homework.apidocs;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.EnvironmentAware;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.util.StopWatch;

/**
 * Springfox Swagger configuration.
 */
@Configuration
@EnableSwagger2
public class SwaggerConfiguration implements EnvironmentAware {
    private static final Logger LOG = LoggerFactory.getLogger(SwaggerConfiguration.class);

    @Bean
    public Docket swaggerSpringfoxDocket() {
        LOG.debug("Starting Swagger");
        StopWatch watch = new StopWatch();
        watch.start();
        Docket build = new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.homework.web.rest"))
                .paths(PathSelectors.any())
                .build();
        LOG.debug("Started Swagger in {} ms", watch.getTotalTimeMillis());
        return build;
    }

    @Override
    public void setEnvironment(Environment environment) {

    }
}
