package com.java.controller.impl;

import com.java.controller.I18NController;
import lombok.RequiredArgsConstructor;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Locale;

@RequiredArgsConstructor
@RestController
public class I18NControllerImpl implements I18NController {

    private final MessageSource messageSource;

    @Override
    public String helloWorld() {
        Locale locale = LocaleContextHolder.getLocale();
        return messageSource.getMessage("hello.message", null, "UNKNOWN message", locale);
    }

    @Override
    public String helloWorldWithName(@PathVariable("name") String name) {
        Locale locale = LocaleContextHolder.getLocale();
        return messageSource.getMessage("hello.message.name", new Object[]{name}, "UNKNOWN message", locale);
    }

}