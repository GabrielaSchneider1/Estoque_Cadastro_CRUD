package com.fundatec.lpi.estoque;

import java.security.Provider.Service;
import java.util.List;
import java.util.Scanner;

import com.fundatec.lpi.estoque.dao.BaseDao;
import com.fundatec.lpi.estoque.dao.ItemDao;
import com.fundatec.lpi.estoque.dominio.Item;
import com.fundatec.lpi.estoque.servico.ValidadorNome;
import com.fundatec.lpi.estoque.servico.ValidadorNomeCapitalizado;

public class App {
	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);

		int comando = 0;
		do {
			System.out.println("Escolha uma opção:");
			System.out.println("------------------");
			System.out.println("1 - Cadastro de item");
			System.out.println("2 - Listar itens");
			System.out.println("3 - Editar item por ID");
			System.out.println("4 - Excluir item por ID");
			System.out.println("5 - Mostrar custo total do estoque");
			System.out.println("0 - Sair");
			System.out.println("");
			System.out.print("Qual opção? ");
			comando = scanner.nextInt();

			ValidadorNome validadorNome = new ValidadorNomeCapitalizado();

			if (comando == 1) {
				System.out.println("Voce quer cadastrar item");
				System.out.println("ID: ");
				System.out.println("NOME: ");
				System.out.println("PRECO: ");

				int id = scanner.nextInt();
				String nome = scanner.next() + "\n";
				float preco = scanner.nextFloat();
				System.out.println(id);

				String novoNome = validadorNome.valida(nome);
				Item item = new Item(novoNome);

				BaseDao<Item> itemDao = new ItemDao();
				itemDao.save(item);

			} else if (comando == 2) {
				System.out.println("=== Listando itens ===");

				ItemDao itemDao = new ItemDao();
				List<Item> itens = itemDao.listAll();

				for (Item item : itens) {
					System.out.format("%s - %s - R$ %s\n", item.getId(), item.getNome(), item.getPreco());
				}
				System.out.println();

			} else if (comando == 3) {

				System.out.println("Qual o id do item que deseja atualizar?");
				int id = scanner.nextInt();
				System.out.println("Qual o novo nome do item?");
				String novoNome = scanner.next();
				System.out.println("Qual o novo preço do item?");
				float novoPreco = scanner.nextFloat();

				String nomeCapitalizado = validadorNome.valida(novoNome);

				Item item = new Item(id, nomeCapitalizado, novoPreco);
				ItemDao itemDao = new ItemDao();
				itemDao.update(item);

			} else if (comando == 4) {

				System.out.println("Qual o id do item que deseja excluir?");

				int id = scanner.nextInt();
				ItemDao itemDao = new ItemDao();
				itemDao.delete(id);

			} else if (comando == 5) {

				System.out.println("Valor total do estoque: ");

			} else if (comando == 0) {
				System.out.println("Saindo....");

			} else {
				System.out.println("Comando inválido");
			}

		} while (comando != 0);

		scanner.close();

		System.out.println("Bye bye!");
	}
}
