package br.com.italooliveira.mscloudgateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableDiscoveryClient
public class MscloudgatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(MscloudgatewayApplication.class, args);
	}

	@Bean
	public RouteLocator routes(RouteLocatorBuilder builder) {
		return builder
				.routes()
					.route(rota -> rota.path("/clientes/**").uri("lb://mscliente"))
					.route(rota -> rota.path("/cartoes/**").uri("lb://mscartoes"))
					.route(rota -> rota.path("/avaliacoes-credito/**").uri("lb://msavaliadorcredito"))
				.build();
	}
}
