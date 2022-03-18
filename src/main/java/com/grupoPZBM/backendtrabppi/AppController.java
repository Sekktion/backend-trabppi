package com.grupoPZBM.backendtrabppi;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AppController {

	@GetMapping("/")
	public String greeting(@RequestParam(value = "name", defaultValue = "mundo")String name) {
		String template = "Olá %s, deu certo. O app está rodando.";
		return String.format(template, name);
	}
	
	@GetMapping("/produtos")
	public Product[] getProducts(@RequestParam(value = "searchParams", defaultValue = "")String searchParams) {
		Product[] products;
		
		//Alocado estaticamente mas deverá ser dinâmico (de acordo com a quantidade de produtos retornados do BD)
		
		products = new Product[3];
		
//		while(false) {
//			//Busca no Banco de Dados todos os produtos cujo nome contenha o recebido em "searchParams"
			//E os adiciona ao array 'products';
//		}
		
		// Inserção de exemplo só para o código rodar, vai ser apagada dps
		
		products[0] = new Product("teste1", "teste1", "teste1", "teste1", 1,"teste1", 1);
		products[1] = new Product("teste2", "teste2", "teste2", "teste2", 2,"teste2", 2);
		products[2] = new Product("teste3", "teste3", "teste3", "teste3", 3,"teste3", 3);
		return products; //Deve retornar JSON, ainda não sei como, mas é isso.
	}
	
	// Em desenvolvimento
//	@GetMapping("/produtos/:id")
//	public Product getProduct(@RequestParam(value = "searchParams", defaultValue = "")String searchParams) {
//		Product[] products;
//		
//		//Alocado estaticamente mas deverá ser dinâmico (de acordo com a quantidade de produtos retornados do BD)
//		
//		products = new Product[3];
//		
////		while(false) {
////			//Busca no Banco de Dados todos os produtos cujo nome contenha o recebido em "searchParams"
//			//E os adiciona ao array 'products';
////		}
//		
//		// Inserção de exemplo só para o código rodar, vai ser apagada dps
//		
//		products[0] = new Product("teste1", "teste1", "teste1", "teste1", 1,"teste1");
//		products[1] = new Product("teste2", "teste2", "teste2", "teste2", 2,"teste2");
//		products[2] = new Product("teste3", "teste3", "teste3", "teste3", 3,"teste3");
//		return products; //Deve retornar JSON, ainda não sei como, mas é isso.
//	}
	
	// Em desenvolvimento
//	@GetMapping("/me/produtos")
//	public Product[] getMyProducts() { 
//		Product[] my_products;
//		
//		//Alocado estaticamente mas deverá ser dinâmico (de acordo com a quantidade de produtos retornados do BD)
//		
//		my_products = new Product[3];
//		
////		while(false) {
////			//Busca no Banco de Dados todos os produtos cujo nome contenha o recebido em "search"
//			//E os adiciona ao array 'products';
////		}
//		
//		// Inserção de exemplo só para o código rodar, vai ser apagada dps
//		
//		my_products[0] = new Product("teste4", "teste4", "teste4", "teste4", 4,"teste4");
//		my_products[1] = new Product("teste5", "teste5", "teste5", "teste5", 5,"teste5");
//		my_products[2] = new Product("teste6", "teste6", "teste6", "teste6", 6,"teste6");
//		return my_products; //Deve retornar JSON, ainda não sei como, mas é isso.
//	}
	
	@PostMapping("/produtos")
	public String postProduto(@RequestParam(value = "nome", defaultValue = "")String name,
			@RequestParam(value = "categoria", defaultValue = "")String category, 
			@RequestParam(value = "tipo", defaultValue = "")String type,
			@RequestParam(value = "imagem", defaultValue = "")String image,
			@RequestParam(value = "valor", defaultValue = "")long price,
			@RequestParam(value = "descricao", defaultValue = "")String desc) {
		
		String statusCode;
		
		if(name == "" || category == "" || type == "" || image == "" || price == 0 || desc == "") {
			statusCode = "500";
			return statusCode;
		}
		
		// Código para gerar ID
		
		Product product = new Product(name, category, type, image, price, desc, 1); // o 1 é um ID, que no momento é arbitrario mas dever ser gerado por uma função
		
		// Código para inserir no banco de dados, de preferência com try e catch
		
		statusCode = "200"; // Exemplo para sinalizar o OK
		return statusCode;
	}
	
	@PostMapping("/cadastro")
	public String userCreation(@RequestParam(value = "username", defaultValue = "") String username,
			@RequestParam(value = "password", defaultValue = "") String password,
			@RequestParam(value = "email", defaultValue = "") String email,
			@RequestParam(value = "phoneNum", defaultValue = "") String phoneNum) {
		
		String statusCode;
		if(username == "" || password == "" || email == "" || phoneNum == "") {
			statusCode = "500";
			return statusCode;
		}
		
		//Código para gerar ID
		
		User user = new User(username, password, email, phoneNum, 1); // o 1 é um ID, que no momento é arbitrario mas dever ser gerado por uma função
		
		//Código para guardar usuário no BD
		//Se deu bigode retorna código de erro, se deu bom retorna token de login
		
		String loginToken = "loremipsumdolorsitamet";
		return loginToken;
	}
	
	@GetMapping("/login")
	public String userLogin(@RequestParam(value = "username", defaultValue = "") String username, 
			@RequestParam(value = "password", defaultValue = "") String password) {
		
		String statusCode;
		if(username == "" || password == "") {
			statusCode = "500";
			return statusCode;
		}
		
		// Código para comparar senha e usuario recebidos com senha e usuario guardados no BD
		// Se deu bigode retorna erro, se não retorna o token de login
		
		String loginToken = "loremipsumdolorsitamet";
		return loginToken;
	}
	
}