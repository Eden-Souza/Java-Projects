package model;

public class Livro extends ItemBiblioteca {

    private final String autor;
    private final int numPaginas;

    public Livro(int id, String titulo, int anoPublicacao, boolean disponivel,String autor, int numPaginas) {
        super(id,titulo,anoPublicacao,disponivel);
        this.autor = autor;
        this.numPaginas = numPaginas;

    }


    @Override
    public String exibirInformacoes() {
        return "Id: " + this.id +
                " Título: " + this.titulo +
                " Autor: " + this.autor +
                " Ano Publicação: " + this.anoPublicacao +
                " Páginas: " + this.numPaginas +
                " Disponível: " + this.disponivel;

    }


}
