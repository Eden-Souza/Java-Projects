package Controller;
import Service.Biblioteca;
import model.ItemBiblioteca;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);


        Biblioteca biblioteca1 = new Biblioteca();

        int menu = 1;
        while (menu != 0) {
            IO.println("Menu para iniciar o Biblioteca: \n");
            IO.println("1 - Adicionar Item\n" +
                    "2 - Listar Itens\n" +
                    "3 - Emprestar Item\n" +
                    "4 - Devolver Item\n" +
                    "5 - Buscar Item\n" +
                    "0 - Sair");

            menu = scanner.nextInt();
            scanner.nextLine();

            if (menu == 1) {
                IO.println("Digite o tipo de item a ser criado ");
                String itemCriado = scanner.nextLine();
                ItemBiblioteca item = biblioteca1.criarItem(itemCriado);
                biblioteca1.addItem(item);
            } else if (menu == 2) {
                biblioteca1.listItemsDisponiveis()
                        .forEach(item -> IO.println(item.exibirInformacoes())); // Metodo reference eu passo a classe e depois o metodo
            } else if (menu == 3) {

                IO.println("Pegar emprestado pelo id ou pelo titulo");
                String busca = scanner.nextLine();

                if (busca.equals("id")) {
                    int idItem = scanner.nextInt();
                    scanner.nextLine();
                    biblioteca1.emprestarItemPorId(idItem);
                    IO.println("Itém Emprestado foi " + biblioteca1.getItem(idItem).exibirInformacoes());
                } else if (busca.equalsIgnoreCase("titulo")) {
                    String tituloItem = scanner.nextLine();
                    ItemBiblioteca item = biblioteca1.getItem(tituloItem);

                    biblioteca1.emprestarItemPorId(item.getId());
                    IO.println("Itém Emprestado foi " + biblioteca1.getItem(tituloItem).exibirInformacoes());
                }
            } else if (menu == 4) {
                IO.println("Devolver pelo id ou pelo titulo");
                String busca = scanner.nextLine();

                if (busca.equals("id")) {
                    int idItem = scanner.nextInt();
                    scanner.nextLine();
                    biblioteca1.devolverItemPorId(idItem);
                    IO.println("Itém devolvido foi " + biblioteca1.getItem(idItem).exibirInformacoes());
                } else if (busca.equalsIgnoreCase("titulo")) {
                    String tituloItem = scanner.nextLine();
                    ItemBiblioteca item = biblioteca1.getItem(tituloItem);
                    biblioteca1.devolverItemPorId(item.getId());
                    IO.println("Itém devolvido foi " + biblioteca1.getItem(tituloItem).exibirInformacoes());

                }
            } else if (menu == 5) {
                IO.println("Qual item deseja buscar ? ");
                int busca = scanner.nextInt();
                ItemBiblioteca itemEscolhido = biblioteca1.getItem(busca);
                IO.println("Item escolhido é " + itemEscolhido.exibirInformacoes());

            } else if (menu == 0) {
                IO.println("Log off Biblioteca");
            }

        }
    }
}