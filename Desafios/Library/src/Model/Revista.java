package model;

public class Revista extends ItemBiblioteca {

    private int edicao;
    private int mesPublicacao;

    public Revista(int id,  String titulo, int anoPublicacao, boolean disponivel,int edicao, int mesPublicacao) {
        super(id,titulo,anoPublicacao,disponivel);
        this.edicao = edicao;
        this.mesPublicacao = mesPublicacao;

    }

    @Override
    public String exibirInformacoes() {
        return "Id: " + this.id +
                " Título: " + this.titulo +
                " Edição: " + this.edicao +
                " Ano Publicação: " + this.anoPublicacao +
                " Páginas: " + this.mesPublicacao +
                " Disponível: " + this.disponivel;

    }
}
