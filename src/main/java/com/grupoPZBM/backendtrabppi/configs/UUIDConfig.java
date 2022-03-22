package com.grupoPZBM.backendtrabppi.configs;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import javax.validation.Constraint;
import javax.validation.Payload;
import javax.validation.ReportAsSingleViolation;
import javax.validation.constraints.Pattern;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Configuration
public class UUIDConfig {

    public static final String UUID_PATTERN = "^[0-9A-Fa-f]{8}-[0-9A-Fa-f]{4}-[0-9A-Fa-f]{4}-[0-9A-Fa-f]{4}-[0-9A-Fa-f]{12}$";


    @Bean
    @Primary
    @Pattern(regexp=UUID_PATTERN, message = "Invalid UUID")
    public @interface UUID {
        String message() default "{invalid.uuid}";
        Class<?>[] groups() default {};
        Class<? extends Payload>[] payload() default {};
    }

}
