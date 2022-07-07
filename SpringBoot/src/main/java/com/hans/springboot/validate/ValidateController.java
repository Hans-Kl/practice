package com.hans.springboot.validate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

/**
 * @author klhans
 */
@RestController
public class ValidateController {
    @Autowired
    MessageSource messageSource;

    @Bean
    public LocalValidatorFactoryBean localValidatorFactoryBean(MessageSource messageSource) {
        LocalValidatorFactoryBean bean = new LocalValidatorFactoryBean();
        bean.setValidationMessageSource(messageSource);
        return bean;
    }

    @PostMapping("/drink")
    public String drink(@RequestBody @Validated({Foo.Adult.class}) Foo foo, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            Map<String, String> errors = new HashMap<String, String>();

            for (FieldError fieldError : bindingResult.getFieldErrors()) {
                String[] str = fieldError.getField().split("\\.");
                if (str.length > 1) {
                    errors.put(str[1], fieldError.getDefaultMessage());
                } else {
                    errors.put(fieldError.getField(), fieldError.getDefaultMessage());
                }

                LocaleContextHolder.setLocale(Locale.ENGLISH);
                String message = messageSource.getMessage(fieldError, LocaleContextHolder.getLocale());
                System.out.println(message);
            }
            return "fail";
        }
        return "success";
    }

    @RequestMapping("/live")
    public String live(@RequestBody @Validated({Foo.Adult.class}) Foo foo) {
        return LocaleContextHolder.getLocale().getLanguage();
    }
}
