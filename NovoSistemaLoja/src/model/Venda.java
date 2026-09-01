package model;

import java.util.ArrayList;
import java.util.List;

public class Venda {

    private Cliente cliente;
    private List<Produto> produtos; // Uma lista dinâmica a qual não precisamos mais dizer o tamanho máximo.
    
    // Na hora de criar a venda, ela começa vazia, apenas com o cliente.
    public Venda(Cliente cliente) {
        this.cliente = cliente;
        this.produtos = new ArrayList<>(); // Inicializa uma gaveta mágica (ou um novo vetor).
    }
    public void AdicionarProduto(Produto p) {
        this.produtos.add(p); // Estrutura que possibilitará a adição de novos produtos no carrinho de compras.
    }
    public double CalcularTotal() {
        double total = 0;
        // Declaramos um laço de repetição 'for' para que a estrutura percorra todos os itens 'p' presentes na lista "produtos".
        for(Produto p : produtos) {
            total = total + p.getPreco();
        }
        return total;
    }
    @Override
    public String toString() {
        return "Cliente: " + cliente.getNome() + "| Total: " + CalcularTotal() + "| Quantidade: " + produtos.size();
    }
}
