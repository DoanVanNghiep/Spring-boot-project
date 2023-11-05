package vn.com.devmaster.project.managermaterial.service;

import org.springframework.stereotype.Service;
import vn.com.devmaster.project.managermaterial.DTO.CartDto;

import java.util.Collection;

@Service
public interface ICartSerVice {
    void add(CartDto cartDto);
    CartDto edit(int proID, int qTy);
    void delete(int id);
    int getCount();
    Double TotalPrice();
    Collection<CartDto> getAll();
    void clear();

    double getAmount();
}
