package br.edu.fatecpg.JpaHibernative.repository;

import br.edu.fatecpg.JpaHibernative.model.Recipe;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RecipeRepository extends JpaRepository<Recipe, Integer> {
}