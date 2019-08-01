package com.jorgesaldivar.demo.handler;

import com.jorgesaldivar.demo.message.TickerDetails;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

import java.text.DecimalFormat;
import java.util.Arrays;

@Component
public class TickerHandler {

    private static final DecimalFormat DECIMAL_FORMAT = new DecimalFormat("###.##");

    public Mono<ServerResponse> tickers(ServerRequest request) {
        return ServerResponse
                .ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(BodyInserters.fromObject(
                        Arrays.asList(
                                new TickerDetails("V", DECIMAL_FORMAT.format(Math.random() * ((200 - 150) + 1) + 150)),
                                new TickerDetails("MSFT", DECIMAL_FORMAT.format(Math.random() * ((180 - 120) + 1) + 120)),
                                new TickerDetails("AMZN", DECIMAL_FORMAT.format(Math.random() * ((2000 - 1500) + 1) + 1500)))));
    }

}
