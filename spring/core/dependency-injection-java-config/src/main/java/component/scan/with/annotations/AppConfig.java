package component.scan.with.annotations;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = { "component.scan.with.annotations" })
public class AppConfig {

}
