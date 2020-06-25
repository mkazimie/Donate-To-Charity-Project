package pl.coderslab.charity.service;

import org.springframework.stereotype.Service;
import pl.coderslab.charity.domain.Category;
import pl.coderslab.charity.repository.CategoryRepository;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class CategoryServiceImpl implements CategoryService{

    private final CategoryRepository categoryRepository;

    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public Category findById(long id) {
        Optional<Category> category = categoryRepository.findById(id);
        return category.orElseThrow(() -> new NoSuchElementException("No such record found in our database"));
    }

    @Override
    public Category findByName(String name) {
        return categoryRepository.findByName(name);
    }


    @Override
    public List<Category> findAll() {
        return categoryRepository.findAll();
    }

    @Override
    public void deleteCategory(long id) {
        categoryRepository.delete(findById(id));

    }

    @Override
    public Category saveCategory(Category category) {
        return categoryRepository.save(category);
    }
}
