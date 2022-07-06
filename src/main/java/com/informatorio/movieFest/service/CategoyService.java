package com.informatorio.movieFest.service;

import com.informatorio.movieFest.domain.Category;
import com.informatorio.movieFest.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

@Service
public class CategoyService implements ICategoryService {
    @Autowired
    CategoryRepository categoryRepository;

    public void createCategory(Category category) {
        categoryRepository.save(category);

    }
}
