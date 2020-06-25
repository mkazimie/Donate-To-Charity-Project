package pl.coderslab.charity.service;

import org.springframework.stereotype.Service;
import pl.coderslab.charity.domain.Category;

import java.util.List;

public interface CategoryService {

    Category findById(long id);

    Category findByName(String name);

    List<Category> findAll();

    void deleteCategory(long id);

    Category saveCategory(Category category);
}
