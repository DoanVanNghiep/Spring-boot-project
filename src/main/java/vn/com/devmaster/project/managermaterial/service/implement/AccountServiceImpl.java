package vn.com.devmaster.project.managermaterial.service.implement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.com.devmaster.project.managermaterial.domain.Customer;
import vn.com.devmaster.project.managermaterial.repository.RegistrationRepository;
import vn.com.devmaster.project.managermaterial.service.AccountService;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;

@Service
public class AccountServiceImpl implements AccountService {
    @Autowired
    RegistrationRepository repository;

    @Override
    public Customer save(Customer entity) {
        LocalDateTime Date = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy.MM.dd HH:MM:SS");
        entity.setCreatedDate(Date.format(formatter));
        entity.setIsactive((byte) 1);
        return repository.save(entity);
    }

    @Override
    public List<Customer> saveAll(List<Customer> entities) {
        return (List<Customer>)repository.saveAll(entities);
    }

    @Override
    public Optional<Customer> findById(Integer integer) {
        return repository.findById(integer);
    }

    @Override
    public boolean existsById(Integer integer) {
        return repository.existsById(integer);
    }

    @Override
    public List<Customer> findAll() {
        return (List<Customer>) repository.findAll();
    }

    @Override
    public Iterable<Customer> findAllById(Iterable<Integer> integers) {
        return repository.findAllById(integers);
    }

    @Override
    public long count() {
        return repository.count();
    }

    @Override
    public void deleteById(Integer integer) {
        repository.deleteById(integer);
    }

    @Override
    public void delete(Customer entity) {
        repository.delete(entity);
    }

    @Override
    public void deleteAllById(List<Integer> integers) {
        repository.deleteAllById(integers);
    }

    @Override
    public void deleteAll(List<Customer> entities) {
        repository.deleteAll(entities);
    }

    @Override
    public void deleteAll() {
        repository.deleteAll();
    }


}
