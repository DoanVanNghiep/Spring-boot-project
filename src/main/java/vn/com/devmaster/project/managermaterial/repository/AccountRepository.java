package vn.com.devmaster.project.managermaterial.repository;

import org.hibernate.dialect.Ingres9Dialect;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import vn.com.devmaster.project.managermaterial.domain.Customer;
@Repository
public interface AccountRepository extends JpaRepository<Customer, Integer> {
    @Query(value = "select * from Customer c where USERNAME = ?",nativeQuery = true)
    Customer findByUsername(String username);

}
