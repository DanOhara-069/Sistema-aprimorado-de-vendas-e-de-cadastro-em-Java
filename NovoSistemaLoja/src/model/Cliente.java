package model;

public class Cliente {
    private String nome;
    private String cpf;

    public Cliente(String nome, String cpf) {
        this.nome = nome;
        setCpf(cpf); // O Setter é utilizado aqui como forma de validação prévia da criação.
    }
    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public String getCpf() { return cpf; }
    public void setCpf(String cpf) {
        // Validação inteligente usando o método Regex (expressão regular).
        if (cpf == null || !cpf.trim().matches("\\d{11}")) {
            throw new IllegalArgumentException("CPF Inválido! O CPF deve conter estritamente 11 dígitos numéricos.");
        }
        // A funcionalidade ".trim()" foi utilizada para garantir que não haja inclusão de espaços vazios que acarretem em 12 dígitos.
        this.cpf = cpf.trim();
    }
    @Override
    public String toString() {
        return "Nome: " + nome + "| CPF: " + cpf;
    }
    
}
