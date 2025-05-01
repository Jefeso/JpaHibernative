package br.edu.fatecpg.JpaHibernative.services;

import br.edu.fatecpg.JpaHibernative.model.Recipe;
import br.edu.fatecpg.JpaHibernative.model.RecipeDTO;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.WebClientResponseException;

@Service
public class RecipeAPIService {
    private final WebClient webClient;

    public RecipeAPIService(WebClient.Builder webClientBuilder) {
        this.webClient = webClientBuilder
                .baseUrl("https://dummyjson.com/recipes")
                .build();
    }

    public RecipeDTO getRecipeById(int id) {
        try {
            return webClient.get()
                    .uri("/{id}", id)
                    .retrieve()
                    .bodyToMono(RecipeDTO.class)
                    .block();
        } catch (WebClientResponseException e) {
            System.err.println("Erro ao buscar receita: " + e.getMessage());
            return null;
        }
    }

    public Recipe convertToEntity(RecipeDTO dto) {
        Recipe recipe = new Recipe();
        recipe.setId(dto.getId());
        recipe.setName(dto.getName());
        recipe.setIngredients(dto.getIngredients());
        recipe.setPrepTimeMinutes(dto.getPrepTimeMinutes());
        recipe.setCookTimeMinutes(dto.getCookTimeMinutes());
        recipe.setServings(dto.getServings());
        recipe.setDifficulty(dto.getDifficulty());
        return recipe;
    }
}