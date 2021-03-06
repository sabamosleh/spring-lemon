package com.naturalprogrammer.spring.lemonreactive.validation;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import javax.validation.Constraint;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.naturalprogrammer.spring.lemon.commons.util.UserUtils;

/**
 * Annotation for unique-email constraint,
 * ensuring that the given email id is not already
 * used by a user.  
 * 
 * @author Sanjay Patel
 */
@NotBlank(message = "{com.naturalprogrammer.spring.blank.email}")
@Size(min=UserUtils.EMAIL_MIN, max=UserUtils.EMAIL_MAX,
	message = "{com.naturalprogrammer.spring.invalid.email.size}")
@Email(message = "{com.naturalprogrammer.spring.invalid.email}")
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy=UniqueEmailValidator.class)
public @interface UniqueEmail {
 
    String message() default "{com.naturalprogrammer.spring.duplicate.email}";

    Class[] groups() default {};
    
    Class[] payload() default {};
}
