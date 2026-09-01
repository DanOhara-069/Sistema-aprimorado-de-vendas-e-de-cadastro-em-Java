package model;

import java.util.ArrayList;
import java.util.List;

public class Loja {
    // A loja está guardando 3 grandes listas:
    private List<Cliente> clientes = new ArrayList<>();
    private List<Produto> produtos = new ArrayList<>();
    private List<Venda> vendas = new ArrayList<>();

    // Métodos para adicionar clientes, vendas e produtos:
    public void adicionarCliente(Cliente c) {
        clientes.add(c);
    }
    public void adicionarProduto(Produto p) {
        produtos.add(p);
    }
    public void adicionarVenda(Venda v) {
        vendas.add(v);
    }

    //Métodos de leitura:
    public List<Cliente> getClientes() { return clientes; }
    public List<Produto> getProdutos() { return produtos; }
    public List<Venda> getVendas() { return vendas; }

    public int getTotalClientes() { return clientes.size(); }
    public int getTotalProdutos() { return produtos.size(); }
    
}
