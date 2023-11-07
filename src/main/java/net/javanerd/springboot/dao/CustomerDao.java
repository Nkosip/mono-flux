package net.javanerd.springboot.dao;

import net.javanerd.springboot.dto.CustomerDto;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Component
public class CustomerDao {

    public List<CustomerDto> getCustomers() {
        return IntStream.rangeClosed(1,10)
                .peek(i -> System.out.println("processing count "+i))
                .mapToObj(i-> new CustomerDto(i,"customer "+i))
                .collect(Collectors.toList());
    }

    public Flux<CustomerDto> getCustomersStream() {
        return Flux.range(1,10)
                .doOnNext(i -> System.out.println("processing count "+i))
                .map(i-> new CustomerDto(i,"customer "+i));
    }
}
