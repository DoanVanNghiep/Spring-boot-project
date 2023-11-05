package vn.com.devmaster.project.managermaterial.mapper;

import org.springframework.stereotype.Component;
import vn.com.devmaster.project.managermaterial.DTO.ProductDto;
import vn.com.devmaster.project.managermaterial.domain.Product;

import java.util.ArrayList;
import java.util.List;
@Component
public class ProductMapper implements EntityMapper<Product, ProductDto>{
    @Override
    public Product toEntity(ProductDto productDto) {
        return Product.builder()
                .id(productDto.getId())
                .name(productDto.getName())
                .build();
    }

    @Override
    public List<Product> toEntity(List<ProductDto> d) {
        List<Product> list = new ArrayList<>();
        d.forEach(productDto -> {
            list.add(toEntity(productDto));
        });
        return list;
    }

    @Override
    public ProductDto toDTO(Product product) {
        return ProductDto.builder()
                .id(product.getId())
                .name(product.getName())
                .description(product.getDescription())
                .image(product.getImage())
                .quatity(product.getQuatity())
                .createdBy(product.getCreatedBy())
                .createdDate(product.getCreatedDate())
                .isactive(product.getIsactive())
                .price(product.getPrice())
                .build();
    }

    @Override
    public List<ProductDto> toDTO(List<Product> e) {
        List<ProductDto> dtos = new ArrayList<>();
        e.forEach(product -> {
            dtos.add(toDTO(product));
        });
        return dtos;
    }
}
