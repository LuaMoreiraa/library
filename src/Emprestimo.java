public class Emprestimo {
    private final int codigoReserva;
    private final Livro livro;
    private final Usuario usuario;

    public Emprestimo(int codigoReserva, Livro livro, Usuario usuario, String dataReserva, String dataDevolucao) {
        this.codigoReserva = codigoReserva;
        this.livro = livro;
        this.usuario = usuario;
    }

    public int getCodigoReserva() {
        return codigoReserva;
    }

    public Livro getLivro() {
        return livro;
    }

    public Usuario getUsuario() {
        return usuario;
    }
    
}
