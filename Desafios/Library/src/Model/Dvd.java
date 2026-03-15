package model;

public class Dvd extends ItemBiblioteca {

    private double duracao;
    private String diretor;

    public Dvd(int id,  String titulo, int anoPublicacao, boolean disponivel,String diretor, double duracao) {
        super(id,titulo,anoPublicacao,disponivel);
        this.diretor = diretor;
        this.duracao = duracao;

    }

    @Override
    public String exibirInformacoes() {
        return "Id: " + this.id +
                " Título: " + this.titulo +
                " Diretor: " + this.diretor +
                " Ano Publicação: " + this.anoPublicacao +
                " Duração: " + this.duracao +
                " Disponível: " + this.disponivel;

    }
}
