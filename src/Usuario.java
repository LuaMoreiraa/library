public class Usuario {
    private final int id;
    private final String nome;
    private final String endereco;
    private final String cidade;
    private final String estado;
    private final String cep;

    public Usuario(int id, String nome, String endereco, String cidade, String estado, String cep) {
        this.id = id;
        this.nome = nome;
        this.endereco = endereco;
        this.cidade = cidade;
        this.estado = estado;
        this.cep = cep;
    }

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public String getCidade() {
        return cidade;
    }

    public String getEstado() {
        return estado;
    }

    public String getCep() {
        return cep;
    }
}
