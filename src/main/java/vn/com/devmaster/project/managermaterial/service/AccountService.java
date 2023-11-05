package vn.com.devmaster.project.managermaterial.service;

import org.springframework.stereotype.Service;
import vn.com.devmaster.project.managermaterial.domain.Customer;

import java.util.List;
import java.util.Optional;

@Service
public interface AccountService {

    Customer save(Customer entity);

    List<Customer> saveAll(List<Customer> entities);

    Optional<Customer> findById(Integer integer);

    boolean existsById(Integer integer);

    List<Customer> findAll();

    Iterable<Customer> findAllById(Iterable<Integer> integers);

    long count();

    void deleteById(Integer integer);

    void delete(Customer entity);

    void deleteAllById(List<Integer> integers);

    void deleteAll(List<Customer> entities);

    void deleteAll();
}
