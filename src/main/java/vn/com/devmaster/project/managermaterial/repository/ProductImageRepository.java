package vn.com.devmaster.project.managermaterial.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import vn.com.devmaster.project.managermaterial.SQL.Sql;
import vn.com.devmaster.project.managermaterial.domain.ProductImage;
import vn.com.devmaster.project.managermaterial.projection.IProductImage;

import java.util.List;
@Repository
public interface ProductImageRepository extends JpaRepository<ProductImage, Integer> {
    @Query(value = "select p from ProductImage p where p.product.id = :idProduct")
    List<ProductImage> getProductImage(@Param("idProduct") Integer id);

    ProductImage findAllById(Integer id);

}
