package com.informatorio.movieFest.controller;

import com.informatorio.movieFest.domain.Actor;
import com.informatorio.movieFest.domain.Category;
import com.informatorio.movieFest.repository.CategoryRepository;
import com.informatorio.movieFest.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CategoryController {

    @Autowired
    ICategoryService iCategoryService;

    @PostMapping("/category")
    public ResponseEntity<?> addStudent(@RequestBody Category category) {
        iCategoryService.createCategory(category);
        return ResponseEntity.status(HttpStatus.OK).body("La operacion fue relizada con exito");
    }
}
