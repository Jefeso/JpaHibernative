package br.edu.fatecpg.JpaHibernative.model;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "recipe")
public class Recipe {
    @Id
    private Integer id;

    @Column
    private String name;

    @ElementCollection
    @CollectionTable(name = "recipe_ingredients", joinColumns = @JoinColumn(name = "recipe_id"))
    @Column(name = "ingredient")
    private List<String> ingredients;

    @Column
    private Integer prepTimeMinutes;

    @Column
    private Integer cookTimeMinutes;

    @Column
    private Integer servings;

    @Column
    private String difficulty;

    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public List<String> getIngredients() { return ingredients; }
    public void setIngredients(List<String> ingredients) { this.ingredients = ingredients; }

    public Integer getPrepTimeMinutes() { return prepTimeMinutes; }
    public void setPrepTimeMinutes(Integer prepTimeMinutes) { this.prepTimeMinutes = prepTimeMinutes; }

    public Integer getCookTimeMinutes() { return cookTimeMinutes; }
    public void setCookTimeMinutes(Integer cookTimeMinutes) { this.cookTimeMinutes = cookTimeMinutes; }

    public Integer getServings() { return servings; }
    public void setServings(Integer servings) { this.servings = servings; }

    public String getDifficulty() { return difficulty; }
    public void setDifficulty(String difficulty) { this.difficulty = difficulty; }

    @Override
    public String toString() {
        return "Receita [ID: " + id + "]\n" +
                "Nome: " + name + "\n" +
                "Ingredientes: " + ingredients + "\n" +
                "Tempo: " + prepTimeMinutes + " min (prep) / " + cookTimeMinutes + " min (coz)\n" +
                "Porções: " + servings + " | Dificuldade: " + difficulty;
    }
}