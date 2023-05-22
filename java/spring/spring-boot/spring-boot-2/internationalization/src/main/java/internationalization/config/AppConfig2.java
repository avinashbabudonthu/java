package internationalization.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.i18n.AcceptHeaderLocaleResolver;

import java.util.Locale;

@Configuration
public class AppConfig2 {

    @Bean
    public LocaleResolver localeResolver(){
        AcceptHeaderLocaleResolver sessionLocaleResolver = new AcceptHeaderLocaleResolver();
        sessionLocaleResolver.setDefaultLocale(Locale.US);
        return sessionLocaleResolver;
    }

}
