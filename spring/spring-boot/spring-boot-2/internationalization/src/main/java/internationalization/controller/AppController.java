package internationalization.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import java.util.Locale;

@Slf4j
@RestController
public class AppController {

    @Autowired
    private MessageSource messageSource;

    /*@GetMapping(value = "/greet", produces = MediaType.TEXT_PLAIN_VALUE)
    public String greeting(@RequestHeader(name = "Accept-Language", required = false) Locale locale) {
        return messageSource.getMessage("hello.message", null, locale);
    }*/

    @GetMapping(value = "/greet2", produces = MediaType.TEXT_PLAIN_VALUE)
    public String greeting2() {
        return messageSource.getMessage("hello.message", null, LocaleContextHolder.getLocale());
    }
}