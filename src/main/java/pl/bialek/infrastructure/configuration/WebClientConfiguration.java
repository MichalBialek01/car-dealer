package pl.bialek.infrastructure.configuration;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.http.codec.json.Jackson2JsonDecoder;
import org.springframework.http.codec.json.Jackson2JsonEncoder;
import org.springframework.web.reactive.function.client.ExchangeStrategies;
import org.springframework.web.reactive.function.client.WebClient;
import pl.bialek.infrastructure.cepik.ApiClient;
import pl.bialek.infrastructure.cepik.api.PojazdyApi;
import pl.bialek.infrastructure.cepik.api.SownikiApi;

@Configuration
public class WebClientConfiguration {

    @Value("${api.cepik.url}")
    private String cepikUrl;

    @Bean
    public WebClient webClient(ObjectMapper objectMapper) {
        final var strategies = ExchangeStrategies
                .builder()
                .codecs(configurer -> {
                    configurer
                            .defaultCodecs()
                            .jackson2JsonEncoder(
                                    new Jackson2JsonEncoder(objectMapper, MediaType.APPLICATION_JSON));
                    configurer
                            .defaultCodecs()
                            .jackson2JsonDecoder(
                                    new Jackson2JsonDecoder(objectMapper, MediaType.APPLICATION_JSON));
                }).build();
        return WebClient.builder()
                .exchangeStrategies(strategies)
                .build();
    }

    @Bean
    public ApiClient apiClient(final WebClient webClient) {
        ApiClient apiClient = new ApiClient(webClient);
        apiClient.setBasePath(cepikUrl);
        return apiClient;
    }

    @Bean
    public SownikiApi sownikiApi(final ApiClient apiClient) {
        return new SownikiApi(apiClient);
    }

    @Bean
    public PojazdyApi pojazdyApi(final ApiClient apiClient) {
        return new PojazdyApi(apiClient);
    }

}