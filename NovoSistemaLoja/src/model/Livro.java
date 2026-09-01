package model;
// A classe "Livro" irá herdar todas as variáveis criadas na classe "Produto", visto que é um subproduto dela.
public class Livro extends Produto {
    private String autor;

    public Livro(int id, String nome, double preco, String autor) {
        // O 'super' irá mandar as variáveis devolta para a classe 'Produto' resolver.
        super(id, nome, preco);
        this.autor = autor;
    }
    public String getAutor() { return autor; }
    public void setAutor(String autor) { this.autor = autor; }

    @Override
    public String toString() {
        // Juntamos a impressão do Produto (super.toString()) com a do 'Livro'.
        return super.toString() + "Autor: " + autor;
    }
    
}
