package com.ivanmix.annotation;

import com.ivanmix.validator.FieldExistsConstraintValidator;
import com.ivanmix.validator.FieldMatchConstraintValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.ANNOTATION_TYPE;
import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Target({ TYPE, ANNOTATION_TYPE })
@Retention(RUNTIME)
@Constraint(validatedBy = FieldExistsConstraintValidator.class)
@Documented
public @interface FieldExists {

    String message() default "FieldExists";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

    String login();

    String email();

    /**
     * Defines several <code>@FieldMatch</code> annotations on the same element
     *
     * @see FieldMatch
     */
    @Target({ TYPE, ANNOTATION_TYPE })
    @Retention(RUNTIME)
    @Documented
    @interface List {
        FieldMatch[] value();
    }
}
