package model;

public class Produto {
    // Variáveis declaradas de forma privada para que elas não possam ser modificadas diretamente.
    private int id;
    private String nome;
    private double preco;

    // Construtor: função chamada na hora de criar (ou instanciar) um produto.
    public Produto(int id, String nome, double preco) {
        this.id = id;
        this.nome = nome;
        this.preco = preco;
    }

    // Getters e Setters: as portas de acesso para as variáveis.
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public double getPreco() { return preco; }
    public void setPreco(double preco) { this.preco = preco; }
    
    // A declaração do método ToString irá ajudar a imprimir os objetos na tela.
    @Override
    public String toString() {
        return "ID: " + id + "| Nome: " + nome + " |Preço: R$" + preco;
    }
}


