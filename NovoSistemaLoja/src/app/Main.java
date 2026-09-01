package app;

import javax.swing.JOptionPane;
import model.Loja;
import model.Produto;
import model.Venda;
import model.Cliente;
import model.Livro;

public class Main {
    public static void main(String[] args) {
        Loja loja = new Loja();

        String menu = "1: Cadastrar cliente\n" + 
                      "2: Cadastrar produto\n" + 
                      "3: Realizar venda\n" + 
                      "4: Listar clientes\n" + 
                      "5: Listar produtos\n" + 
                      "6: Listar vendas\n" + 
                      "0: Sair";

        int opcao = -1;

        while (opcao != 0) {

            try{
                String entrada = JOptionPane.showInputDialog(menu);
                if (entrada == null) {
                    break;
                }
                opcao = Integer.parseInt(entrada);

                switch(opcao) {
                    case 1:
                        String nomeCliente = JOptionPane.showInputDialog("Digite o nome do cliente:");
                        String cpfInput = JOptionPane.showInputDialog("Digite o CPF do cliente (apenas números):");
                        // Caso o usuário clique em 'Cancelar':
                        if (nomeCliente == null || cpfInput == null) {
                            break;
                        }

                        try {
                            Cliente cliente = new Cliente(nomeCliente, cpfInput.trim());
                            loja.adicionarCliente(cliente);
                            JOptionPane.showMessageDialog(null, "Cliente cadastrado com sucesso!");
                        
                        } catch (IllegalArgumentException erro) {
                            JOptionPane.showMessageDialog(null, "Atenção: " + erro.getMessage());
                        }
                        break;
                    case 2:
                        String[] tipos = {"Produto comum", "Livro"};

                        int tipoSelecionado = JOptionPane.showOptionDialog(null, 
                            "Qual tipo de produto deseja cadastrar?", 
                            "Tipo de produto", 
                            JOptionPane.DEFAULT_OPTION, 
                            JOptionPane.QUESTION_MESSAGE, 
                            null, tipos, tipos[0]);

                        int id = Integer.parseInt(JOptionPane.showInputDialog("Digite o ID do produto (número):"));
                        String nomeProduto = JOptionPane.showInputDialog("Digite o nome do produto:");
                        double preco = Double.parseDouble(JOptionPane.showInputDialog("Digite o preço do produto:"));

                        if (tipoSelecionado == 0) {
                            Produto produto = new Produto(id, nomeProduto, preco);
                            loja.adicionarProduto(produto);
                        }else if (tipoSelecionado == 1) {
                            String autor = JOptionPane.showInputDialog("Digite o nome do autor do livro: ");
                            Livro livro = new Livro(id, nomeProduto, preco, autor);
                            loja.adicionarProduto(livro);
                        }
                        JOptionPane.showMessageDialog(null, "Produto cadastrado com sucesso!");
                        break; 
                    case 3:
                        if (loja.getTotalClientes() == 0 || loja.getTotalProdutos() == 0) {
                            JOptionPane.showMessageDialog(null, "Atenção: Cadastre pelo menos um cliente e um produto antes de vender.");
                            break;
                        }
                        StringBuilder listaParaVenda = new StringBuilder("--- Selecione o cliente pelo número: ---\n");
                        for (int i = 0; i < loja.getTotalClientes(); i++) {
                            listaParaVenda.append(i).append(" - ").append(loja.getClientes().get(i).getNome()).append("\n");
                        }
                        int indiceCliente = Integer.parseInt(JOptionPane.showInputDialog(listaParaVenda.toString()));

                        Cliente clienteComprador = loja.getClientes().get(indiceCliente);

                        Venda novaVenda = new Venda(clienteComprador);

                        StringBuilder listaItens = new StringBuilder("--- Selecione os produtos pela numeração: ---\n");
                        listaItens.append("Use vírgula para listar mais de um item. Ex: 0, 1, 2\n\n");

                        for (int i = 0; i < loja.getTotalProdutos(); i++) {
                            listaItens.append(i).append(" - ").append(loja.getProdutos().get(i).getNome()).append("\n");
                        }
                        // O usuário digita algo como: "0, 2"
                        String entradaIndices = JOptionPane.showInputDialog(listaItens.toString());
                        
                        // Cortamos o texto nas vírgulas. Vira uma lista de pequenos textos: ["0", " 2"]
                        String[] posicoesSeparadas = entradaIndices.split(","); 
                        
                        for (String posicaoStr : posicoesSeparadas) {
                            // trim() tira espaços em branco inúteis. parseInt converte para número.
                            int posicaoNoCarrinho = Integer.parseInt(posicaoStr.trim()); 
                            
                            // Pegamos o produto da loja e jogamos dentro da venda
                            Produto produtoEscolhido = loja.getProdutos().get(posicaoNoCarrinho);
                            novaVenda.AdicionarProduto(produtoEscolhido);
                        }
                        loja.adicionarVenda(novaVenda);
                        JOptionPane.showMessageDialog(null, "Venda realizada!\nResumo: " + novaVenda.toString());
                        break;
                    case 4:
                        StringBuilder relatorioClientes = new StringBuilder("--- Clientes cadastrados: ---\n");
                        for (Cliente c : loja.getClientes()) {
                            relatorioClientes.append(c.toString()).append("\n");
                        }
                        JOptionPane.showMessageDialog(null, relatorioClientes.toString());
                        break;
                    case 5:
                        StringBuilder relatorioProdutos = new StringBuilder("--- Produtos cadastrados: ---\n");
                        for (Produto p : loja.getProdutos()) {
                            relatorioProdutos.append(p.toString()).append("\n");
                        }
                        JOptionPane.showMessageDialog(null, relatorioProdutos.toString());
                        break;
                    case 6:
                        StringBuilder relatorioVendas = new StringBuilder("--- Vendas realizadas: ---\n");
                        for (Venda v : loja.getVendas()) {
                            relatorioVendas.append(v.toString()).append("\n");
                        }
                        JOptionPane.showMessageDialog(null, relatorioVendas.toString());
                        break;
                    case 0:
                        JOptionPane.showMessageDialog(null, "Encerrando sistema...");
                        break;

                    default:
                        JOptionPane.showMessageDialog(null, "Opção inválida! Digite outro número.");
                        break;
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Erro: por favor, digite apenas números válidos!");
            }
        }
    }
    
}