package swagger.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.VendorExtension;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

    private static final Contact CONTACT = new Contact
            ("Avinash Babu Donthu", "https://cerebroap.herokuapp.com/", "avinashbabu.donthu@gmail.com");

    private static final ArrayList<VendorExtension> vendorExtensions = new ArrayList<>();

    private static final ApiInfo API_INFO = new ApiInfo("Cerebro Spring Boot 2 Swagger Example",
            "Cerebro Spring Boot 2 Swagger Example Api Documentation",
            "1.0", "urn:tos",
            CONTACT,
            "Apache 2.0",
            "http://www.apache.org/licenses/LICENSE-2.0",
            vendorExtensions);

    private static final Set<String> PRODUCES_AND_CONSUMES = new HashSet<>(Arrays.asList(MediaType.APPLICATION_JSON_VALUE,
            MediaType.APPLICATION_XML_VALUE));

    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(API_INFO)
                .produces(PRODUCES_AND_CONSUMES)
                .consumes(PRODUCES_AND_CONSUMES);
    }
}
