public class Livro {
    private final int tombo;
    private final String titulo;
    private final String autor;
    private final String categoria;
    private final String editora;
    private final int ano;
    private boolean disponivel;

    public Livro(int tombo, String titulo, String autor, String categoria, String editora, int ano) {
        this.tombo = tombo;
        this.titulo = titulo;
        this.autor = autor;
        this.categoria = categoria;
        this.editora = editora;
        this.ano = ano;
        this.disponivel = true;
    }

    public String getAutor() {
        return autor;
    }

    public String getCategoria() {
        return categoria;
    }

    public String getEditora() {
        return editora;
    }

    public int getAno() {
        return ano;
    }

    public int getTombo() {
        return tombo;
    }

    public String getTitulo() {
        return titulo;
    }

    public boolean isDisponivel() {
        return disponivel;
    }

    public void setDisponivel(boolean disponivel) {
        this.disponivel = disponivel;
    }
}
