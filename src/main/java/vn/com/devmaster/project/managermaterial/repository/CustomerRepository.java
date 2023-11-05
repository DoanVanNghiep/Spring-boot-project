package vn.com.devmaster.project.managermaterial.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import vn.com.devmaster.project.managermaterial.domain.Customer;
import vn.com.devmaster.project.managermaterial.projection.IProductById;

import java.util.List;

@Repository
@EnableJpaRepositories
public interface CustomerRepository extends JpaRepository<Customer, Integer> {
//    @Query(nativeQuery = true,value = "select * from customer s where s.username=:username and s.password=:password")
//    List<Customer> findByUsername(String username,String password);
//
//    @Query(nativeQuery = true,value = "select * from customer s where s.username=:username")
//    List<Customer> getCustomerByUsername(String username);
//    @Query(nativeQuery = true, value = "select * from customer")
//    List<Customer> getAllCustomer();
//
//    Customer findById(String id);
//    @Query(value = "select * from customer c where c.USERNAME like concat('%', :username ,'%')",nativeQuery = true)
//    Customer findById(@Param("username") String username);
}
