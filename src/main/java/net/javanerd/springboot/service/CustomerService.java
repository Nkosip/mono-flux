package net.javanerd.springboot.service;

import net.javanerd.springboot.dao.CustomerDao;
import net.javanerd.springboot.dto.CustomerDto;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

import java.util.List;

@Service
public class CustomerService {
    CustomerDao customerDao;

    public CustomerService(CustomerDao customerDao) {
        this.customerDao = customerDao;
    }

    public List<CustomerDto> loadAllCustomers() {
        return customerDao.getCustomers();
    }

    public Flux<CustomerDto> loadAllCustomersStream() {
        return customerDao.getCustomersStream();
    }
}
