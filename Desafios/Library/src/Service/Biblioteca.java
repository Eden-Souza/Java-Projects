package Service;

import model.Dvd;
import model.ItemBiblioteca;
import model.Livro;
import model.Revista;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Biblioteca {

    List<ItemBiblioteca> itens = new ArrayList<>();

    Scanner pergunta = new Scanner(System.in);
    public ItemBiblioteca criarItem(String tipoAdd) {

        IO.println("Digite o id: ");
        int id = pergunta.nextInt(); // Não consome o enter, tem que ter um intermediario
        pergunta.nextLine();

        IO.println("Digite o titulo: ");
        String titulo = pergunta.nextLine();

        IO.println("Digite ano da publicacao: ");
        int anoPublicacao = pergunta.nextInt();

        IO.println("Digite se está disponivel: ");
        boolean disponivel = pergunta.nextBoolean();
        pergunta.nextLine();

        if (tipoAdd.equalsIgnoreCase("Livro")){

            IO.println("Digite o autor ");
            String autor = pergunta.nextLine();

            IO.println("Digite o número de páginas: ");
            int numPaginas = pergunta.nextInt();

            return new Livro(id,titulo,anoPublicacao,disponivel,autor,numPaginas);

        } else if (tipoAdd.equalsIgnoreCase("Dvd")) {

            IO.println("Digite o diretor: ");
            String diretor = pergunta.nextLine();

            IO.println("Digite a duracao: ");
            int duracao = pergunta.nextInt();

            return new Dvd(id,titulo,anoPublicacao,disponivel,diretor,duracao);

        } else if (tipoAdd.equalsIgnoreCase("Revista")) {

            IO.println("Digite a edição: ");
            int edicao = pergunta.nextInt();

            IO.println("Digite o Mês de Publicação: ");
            int mesPublicacao = pergunta.nextInt();

            return new Revista(id,titulo,anoPublicacao,disponivel,edicao,mesPublicacao);

        } else
            throw new RuntimeException(" Tipo de item incorreto");

    }

    public void addItem(ItemBiblioteca item) {
        itens.add(item);
    }


    public ItemBiblioteca getItem(int id) {
        return itens.stream()
                .filter(item-> item.getId()==id)
                .findFirst().orElseThrow(() -> new RuntimeException("Informe Id valido"));
    }

    public ItemBiblioteca getItem(String titulo) {
        //Tem que atribuir em uma variavel
        return itens.stream()
                .filter(item-> item.getTitulo().equalsIgnoreCase(titulo))
                .findFirst().orElseThrow(() -> new RuntimeException("Informe Titulo valido"));
    }

    public List<ItemBiblioteca> listItemsDisponiveis() {
        return itens.stream()
                .filter(ItemBiblioteca::isDisponivel)// Metodo referencia = item->item.disponivel()
                .toList();
    }

    public void emprestarItemPorId(int id){
        ItemBiblioteca item = itens.stream()
                .filter(i -> i.getId() == id)
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Item não encontrado"));

        if (!item.isDisponivel()){
            throw new RuntimeException("Item já emprestado");
        }

        item.realizarEmprestimo();
    }

    /*
    ItemBiblioteca item = itens.stream()
        .filter(i -> i.getId() == id)
        .findFirst()
        .orElseThrow(() -> new RuntimeException("Item não encontrado"));

    item.realizarDevolucao(); Fazer algo do tipo para ficar melhor
     */
    public void devolverItemPorId(int id){
        itens.get(id-1).realizarDevolucao();
    }
}
