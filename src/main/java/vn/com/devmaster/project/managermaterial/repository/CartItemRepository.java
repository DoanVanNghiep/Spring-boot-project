package vn.com.devmaster.project.managermaterial.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import vn.com.devmaster.project.managermaterial.domain.Cartitem;
@Repository
public interface CartItemRepository extends JpaRepository<Cartitem, Integer> {
}
