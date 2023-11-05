package vn.com.devmaster.project.managermaterial.repository;

import org.springframework.data.repository.CrudRepository;
import vn.com.devmaster.project.managermaterial.domain.Customer;

public interface RegistrationRepository extends CrudRepository<Customer, Integer> {

}
