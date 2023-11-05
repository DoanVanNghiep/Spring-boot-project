package vn.com.devmaster.project.managermaterial.mapper;

import org.springframework.stereotype.Component;
import vn.com.devmaster.project.managermaterial.DTO.CategoryDto;
import vn.com.devmaster.project.managermaterial.domain.Category;

import java.util.ArrayList;
import java.util.List;
@Component
public class CategoryMapper implements EntityMapper<Category, CategoryDto>{
    @Override
    public Category toEntity(CategoryDto categoryDto) {
        return Category.builder()
                .id(categoryDto.getId())
                .idparent(categoryDto.getIdparent())
                .name(categoryDto.getName())
                .createdDate(categoryDto.getCreatedDate())
                .createdBy(categoryDto.getCreatedBy())
                .build();
    }

    @Override
    public List<Category> toEntity(List<CategoryDto> d) {
        List<Category> categories = new ArrayList<>();
        d.forEach(categoryDto -> {
            categories.add(toEntity(categoryDto));
        });
        return categories;
    }

    @Override
    public CategoryDto toDTO(Category category) {
        return CategoryDto.builder()
                .id(category.getId())
                .idparent(category.getIdparent())
                .icon(category.getIcon())
                .createdDate(category.getCreatedDate())
                .createdBy(category.getCreatedBy())
                .name(category.getName())
                .build();
    }

    @Override
    public List<CategoryDto> toDTO(List<Category> e) {
        List<CategoryDto> dtos = new ArrayList<>();
        e.forEach(category -> {
            dtos.add(toDTO(category));
        });
        return dtos;
    }
}
