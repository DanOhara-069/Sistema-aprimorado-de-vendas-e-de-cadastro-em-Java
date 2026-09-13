# Sistema de gestão de uma loja:

Um sistema interativo de gerenciamento de clientes, produtos e vendas, desenvolvido em Java. 

Este repositório representa a evolução técnica de um projeto acadêmico legado. Todo o código base foi refatorado do zero com o objetivo de substituir lógicas procedurais por **Programação Orientada a Objetos (POO)** e estruturar a aplicação com foco em boas práticas, legibilidade e segurança de dados.

## Funcionalidades:

* **Gestão de clientes:** Cadastro de clientes com validação rigorosa de dados (CPF).
* **Catálogo de produtos:** Sistema híbrido que suporta o cadastro de Produtos Comuns e Livros, aproveitando o conceito de herança para reaproveitamento de código.
* **Processamento de vendas:** Carrinho de compras dinâmico que permite adicionar múltiplos itens simultaneamente via separação por vírgulas, vinculando a compra a um cliente específico.
* **Relatórios em tela:** Listagem iterativa de clientes, catálogo e histórico de vendas.

## Tecnologias e conceitos aplicados:

O projeto foi construído utilizando **Java puro**, focando nos fundamentos da linguagem e da engenharia de software:

* **Orientação a Objetos (POO):** Uso de herança (`Livro` estendendo `Produto`) e encapsulamento para garantir a integridade das regras de negócio.
* **Estruturas de dados dinâmicas:** Substituição de vetores clássicos (`Arrays`) pelo *Java Collections Framework* (`ArrayList`), permitindo dimensionamento automático da base de dados em memória.
* **Tratamento de exceções e resiliência:** Implementação de blocos `try-catch` globais no fluxo da aplicação. Exceções customizadas (`IllegalArgumentException`) protegem o sistema contra entradas inválidas (ex: CPF incorreto barrado via *Regex* `\\d{11}`).
* **Interface gráfica nativa:** Utilização da biblioteca `javax.swing.JOptionPane` para criar uma experiência de usuário (UX) fluida através de caixas de diálogo, substituindo o terminal padrão.
  
## Como executar o projeto na sua máquina:

* Certifique-se de ter o **Microsoft Build of OpenJDK** instalado no seu computador para obter gratuitamente todas as ferramentas da linguagem Java e assim poder executá-las dentro do seu VS Code.
  
## Arquitetura do projeto:

O código-fonte está dividido para respeitar a responsabilidade de cada classe:

```text
src/
 ├── model/          # Regras de negócio, moldes e armazenamento de dados em memória
 │    ├── Cliente.java
 │    ├── Produto.java
 │    ├── Livro.java
 │    ├── Venda.java
 │    └── Loja.java  # Classe gerenciadora (Banco de Dados em memória)
 │
 └── app/            # Camada de visualização e interação com o usuário
      └── Main.java  # Loop principal do programa e roteamento de menus
