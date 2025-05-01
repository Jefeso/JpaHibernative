package br.edu.fatecpg.JpaHibernative.services;

import br.edu.fatecpg.JpaHibernative.model.Recipe;
import br.edu.fatecpg.JpaHibernative.repository.RecipeRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class RecipeService {
    private final RecipeRepository repository;

    public RecipeService(RecipeRepository repository) {
        this.repository = repository;
    }

    @Transactional(readOnly = true)
    public List<Recipe> listAllRecipes() {
        return repository.findAll();
    }

    @Transactional
    public Recipe saveRecipe(Recipe recipe) {
        return repository.save(recipe);
    }
}