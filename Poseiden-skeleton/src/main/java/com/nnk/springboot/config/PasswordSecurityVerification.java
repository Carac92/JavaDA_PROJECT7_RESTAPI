package com.nnk.springboot.config;

import lombok.extern.log4j.Log4j2;
import org.springframework.context.annotation.Configuration;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * The type Password security verification.
 *      * Is valid boolean.
 *      *
 *      * @param password the password
 *      * @return the boolean
 */
@Log4j2
@Configuration
public class PasswordSecurityVerification {
    // minimum 8 characters One digit One lower case One upper case One special character
    private static final String PASSWORD_PATTERN
            = "^(?=.*[A-Za-z])(?=.*\\d)(?=.*[@$!%*#?&])[A-Za-z\\d@$!%*#?&]{8,}$";
    private static final Pattern pattern = Pattern.compile(PASSWORD_PATTERN);

    public boolean isValid(String password) {
        Matcher matcher = pattern.matcher(password);
        if(matcher.matches()) {
            log.info("Password is valid");
            return true;
        }
        log.info("Password is not valid");
        return false;
    }

}
