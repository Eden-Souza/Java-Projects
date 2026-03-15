package model;

import Interface.Emprestavel;

// Como terá diferentes tips de itens, instanciar essa classe iria trazer confusão
// Cria esse classe base e depois cria as filhas
// pode ser publico e abstract
public abstract class ItemBiblioteca implements Emprestavel {

    // Como terá classes filhas é interessantes ser protected para que as filhas reconhecem os atributos da mãe
    protected int id;
    protected String titulo;
    protected int anoPublicacao;
    protected boolean disponivel;

    ItemBiblioteca(int id, String titulo, int anoPublicacao, boolean disponivel) {
        this.id = id;
        this.titulo = titulo;
        this.anoPublicacao = anoPublicacao;
        this.disponivel = disponivel;
    }

    public int getId(){
        return this.id;
    }

    public String getTitulo(){
        return this.titulo;
    }

    public int getAnoPublicacao(){
        return this.anoPublicacao;
    }

    public boolean isDisponivel(){
        return this.disponivel;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public void setAnoPublicacao(int anoPublicacao) {
        this.anoPublicacao = anoPublicacao;
    }

    public void setDisponivel(boolean disponivel) {
        this.disponivel = disponivel;
    }

    @Override
    public void realizarEmprestimo(){
        if (this.disponivel){
            this.disponivel = false;
        } else {
            throw new RuntimeException("Livro já foi emprestado");
        }

    }

    @Override
    public void realizarDevolucao(){
        this.disponivel = true;
    }

    public abstract String exibirInformacoes();
}
