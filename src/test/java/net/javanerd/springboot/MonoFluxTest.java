package net.javanerd.springboot;

import org.junit.jupiter.api.Test;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public class MonoFluxTest {

    @Test
    public void testMono() {
        Mono<?> mono = Mono.just("javatechie")
                .then(Mono.error(new RuntimeException("error occured")))
                .log();
        mono.subscribe(System.out::println);
    }

    @Test
    public void testFlux() {
        Flux<String> fluxStrings = Flux.just("Spring","Spring boot","Hibernate","Microservices")
                        .concatWithValues("AWS").log();
        fluxStrings.subscribe(System.out::println);
    }
}
