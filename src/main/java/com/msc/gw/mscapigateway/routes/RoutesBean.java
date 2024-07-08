package com.msc.gw.mscapigateway.routes;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class RoutesBean {



    public RouteLocator routeLocator(RouteLocatorBuilder builder) {
        return builder

                .routes()
                .route("ms-users", r -> r.path("/users/api/**")
                        .filters(f -> f.rewritePath("/users/api/(?<remaining>.*)", "/ms-users/api/${remaining}"))
                        .uri("lb://msc-ms-users"))
                .route("ms-address", r -> r.path("/address/api/**")
                        .filters(f -> f.rewritePath("/address/api/(?<remaining>.*)", "/ms-address/api/${remaining}"))
                        .uri("lb://msc-ms-address"))
                .route("ms-authentication" , r-> r.path("/authentication/api/**")
                        .filters(f -> f.rewritePath("/authentication/api/(?<remaining>.*)", "/ms-authentication/api/${remaining}"))
                        .uri("lb://msc-ms-authentication"))
                .route("ms-file" , r-> r.path("/file/api/**")
                        .filters(f -> f.rewritePath("/file/api/(?<remaining>.*)", "/ms-file/api/${remaining}"))
                        .uri("lb://msc-ms-file"))
                .route("ms-processor" , r-> r.path("/processor/api/**")
                        .filters(f -> f.rewritePath("/processor/api/(?<remaining>.*)", "/ms-processor/api/${remaining}"))
                        .uri("lb://msc-ms-processor"))
                .build();

    }


}
