package vn.com.devmaster.project.managermaterial.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import vn.com.devmaster.project.managermaterial.domain.Order;

public interface OrderRepository extends JpaRepository<Order, Integer> {
}
