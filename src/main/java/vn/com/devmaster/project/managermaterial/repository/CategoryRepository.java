package vn.com.devmaster.project.managermaterial.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import vn.com.devmaster.project.managermaterial.domain.Category;
import vn.com.devmaster.project.managermaterial.domain.Customer;
@Repository
public interface CategoryRepository extends JpaRepository<Category, Integer> {
}
