package br.edu.fatecpg.JpaHibernative;

import br.edu.fatecpg.JpaHibernative.model.Recipe;
import br.edu.fatecpg.JpaHibernative.model.RecipeDTO;
import br.edu.fatecpg.JpaHibernative.services.RecipeAPIService;
import br.edu.fatecpg.JpaHibernative.services.RecipeService;
import jakarta.transaction.Transactional;
import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

@SpringBootApplication
public class JpaHibernativeApplication implements ApplicationRunner {
	@Autowired
	private RecipeAPIService apiService;
	@Autowired
	private RecipeService recipeService;

	public static void main(String[] args) {
		SpringApplication.run(JpaHibernativeApplication.class, args);
	}

	@Override
	public void run(ApplicationArguments args) throws Exception {
		Scanner scan = new Scanner(System.in);
		int opt = 0;

		while(opt != 3) {
			System.out.println("\n=== MENU ===");
			System.out.println("1 - Buscar receita por ID");
			System.out.println("2 - Listar receitas salvas");
			System.out.println("3 - Sair");
			System.out.print("Escolha: ");

			try {
				opt = scan.nextInt();
				scan.nextLine();

				switch (opt) {
					case 1:
						buscarReceita(scan);
						break;
					case 2:
						listarReceitasSalvas();
						break;
					case 3:
						System.out.println("Encerrando...");
						break;
					default:
						System.out.println("Opção inválida! Digite 1, 2 ou 3.");
				}
			} catch (InputMismatchException e) {
				System.out.println("Erro: Você deve digitar um número!");
				scan.nextLine();
				opt = 0;
			}
		}
		scan.close();
	}

	private void buscarReceita(Scanner scan) {
		System.out.print("Digite o ID da receita: ");
		int id = scan.nextInt();
		scan.nextLine();

		RecipeDTO receitaDTO = apiService.getRecipeById(id);
		if (receitaDTO != null) {
			Recipe receita = apiService.convertToEntity(receitaDTO);
			System.out.println("\n=== RECEITA ENCONTRADA ===");
			System.out.println(receita);

			System.out.print("\nDeseja salvar esta receita? (S/N): ");
			String resposta = scan.nextLine();

			if (resposta.equalsIgnoreCase("S")) {
				recipeService.saveRecipe(receita);
				System.out.println("Receita salva com sucesso!");
			}
		} else {
			System.out.println("Receita não encontrada para o ID: " + id);
		}
	}

	@Transactional
	public void listarReceitasSalvas() {
		List<Recipe> receitas = recipeService.listAllRecipes();

		if (receitas.isEmpty()) {
			System.out.println("\nNenhuma receita salva no banco de dados.");
		} else {
			System.out.println("\n=== RECEITAS SALVAS ===");
			receitas.forEach(receita -> {
				System.out.println("\n--------------------------------");
				// Carrega explicitamente os ingredientes
				Hibernate.initialize(receita.getIngredients());
				System.out.println(receita);
				System.out.println("--------------------------------");
			});
			System.out.println("\nTotal de receitas: " + receitas.size());
		}
	}
}