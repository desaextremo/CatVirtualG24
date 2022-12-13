package com.unab.catvirtual.catvirtualg24.sevice;

import com.unab.catvirtual.catvirtualg24.enitity.Book;
import com.unab.catvirtual.catvirtualg24.enitity.Category;
import com.unab.catvirtual.catvirtualg24.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {
    @Autowired
    private CategoryRepository categoryRepository;

    public List<Category> listCategoryes() {
        return categoryRepository.findAll();
    }

    public Category queryCategory(String id){
        Category category;
        Optional<Category> optional =  categoryRepository.findById(id);

        if(!optional.isEmpty()){
            category = optional.get();
        }else{
            category = null;
        }
        return category;
    }

    public Category addCategory(Category category){
        Optional<Category> optional =  categoryRepository.findById(category.getId());

        if(optional.isEmpty()) return categoryRepository.save(category);
        else return null;
    }

    public Category saveCategory(Category category){
        //1 Buscamos si la categoria existe y recuperamos toda su información
        Optional<Category> opcional = categoryRepository.findById(category.getId());
        //la categoria existe
        if (!opcional.isEmpty()){
            Category categoryDB = opcional.get();
            //2 comparamos si los valores actuales son diferentes a los valores de la categoria recibido como parametro

            if (category.getName()!=null) categoryDB.setName(category.getName());

            return categoryRepository.save(categoryDB);
        }else{ //el libro no existe
            return null;
        }
    }

    public void deleteCategory(String id){
        categoryRepository.deleteById(id);
    }

}
