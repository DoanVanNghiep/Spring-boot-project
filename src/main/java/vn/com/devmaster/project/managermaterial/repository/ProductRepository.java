package vn.com.devmaster.project.managermaterial.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import vn.com.devmaster.project.managermaterial.DTO.ProductDto;
import vn.com.devmaster.project.managermaterial.SQL.Sql;
import vn.com.devmaster.project.managermaterial.domain.Product;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<Product , Integer> {

    Product findAllById(Integer iDproduct);
    // tìm kiếm img
    @Query(nativeQuery = true,value = Sql.PRODUCT_FIND_NAME)
    List<Product> findAllByName(@Param("name") String name);

    @Query(nativeQuery = true,value = Sql.PRODUCT_FIND_BETWEEN)
    List<Product> findAllByPriceBetween(@Param("value1") Double value1,@Param("value2") Double value2);

    @Query(nativeQuery = true,value = Sql.PRODUCT_FIND_LESSTHAN)
    List<Product> findAllByPriceLessThan(@Param("value3") Double value3);

    @Query(nativeQuery = true,value = Sql.PRODUCT_FIND_MORETHAN)
    List<Product> findAllByPriceBigThan(@Param("value4") double value4);
}
