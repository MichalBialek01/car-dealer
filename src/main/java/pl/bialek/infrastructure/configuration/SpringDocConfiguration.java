package pl.bialek.infrastructure.configuration;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import pl.bialek.CarDealershipApplication;


@Configuration
public class SpringDocConfiguration {
    @Bean
    public GroupedOpenApi groupedOpenApi() {
        return GroupedOpenApi.builder()
                .group("default")
                .pathsToMatch("/**")
                .packagesToScan(CarDealershipApplication.class.getPackageName())
                .build();
    }

    @Bean
    public OpenAPI springDocOpenApiConf() {
        return new OpenAPI()
                .components(new Components())
                .info(new Info()
                        .title("Dealership application API")
                        .contact(contact())
                        .version("1.0")
                );
    }

    private Contact contact() {
        return new Contact()
                .name("Michal Bialek")
                .url("none")
                .email("kontakt.michalbialek@gmail.com");
    }
}