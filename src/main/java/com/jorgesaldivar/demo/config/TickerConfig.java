package com.jorgesaldivar.demo.config;

import com.jorgesaldivar.demo.handler.TickerHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RequestPredicates;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

@Configuration
public class TickerConfig {

    @Bean
    public RouterFunction<ServerResponse> route(TickerHandler tickerHandler) {

        return RouterFunctions
                .route(RequestPredicates
                                .GET("/tickers")
                                .and(RequestPredicates
                                        .accept(MediaType.APPLICATION_JSON)), tickerHandler::tickers);

    }

}