package vn.com.devmaster.project.managermaterial.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import vn.com.devmaster.project.managermaterial.domain.OrdersDetail;
@Repository
public interface OrderDetailsRepository extends JpaRepository<OrdersDetail, Integer> {

}
