package vn.com.devmaster.project.managermaterial.mapper;

import java.util.List;

public interface EntityMapper <E, D>{
    E toEntity(D d);
    List<E> toEntity(List<D> d);
    D toDTO(E e);
    List<D> toDTO(List<E> e);
}
