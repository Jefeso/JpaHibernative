package br.edu.fatecpg.JpaHibernative.model;

import java.util.List;

public class RecipeDTO {
    private Integer id;
    private String name;
    private List<String> ingredients;
    private Integer prepTimeMinutes;
    private Integer cookTimeMinutes;
    private Integer servings;
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
        return "ID: " + id + "\n" +
                "Nome: " + name + "\n" +
                "Ingredientes: " + ingredients + "\n" +
                "Tempo de preparo: " + prepTimeMinutes + " min\n" +
                "Tempo de cozimento: " + cookTimeMinutes + " min\n" +
                "Porções: " + servings + "\n" +
                "Dificuldade: " + difficulty;
    }
}