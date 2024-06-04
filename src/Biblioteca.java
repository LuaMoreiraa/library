import java.util.ArrayList;
import java.util.Scanner;

public class Biblioteca {
    private final ArrayList<Livro> livros = new ArrayList<>();
    private final ArrayList<Usuario> usuarios = new ArrayList<>();
    private final ArrayList<Emprestimo> emprestimos = new ArrayList<>();
    private int proximoCodigoReserva = 1; // Removi o final
    private final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        Biblioteca biblioteca = new Biblioteca();
        biblioteca.exibirMenu();
    }

    public void exibirMenu() {
        int opcao;
        do {
            System.out.println("=== MENU ===");
            System.out.println("1 - Cadastrar Livro");
            System.out.println("2 - Cadastrar Usuário");
            System.out.println("3 - Realizar Empréstimo");
            System.out.println("4 - Devolver Livro");
            System.out.println("5 - Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();

            switch (opcao) {
                case 1 -> cadastrarLivro();
                case 2 -> cadastrarUsuario();
                case 3 -> realizarEmprestimo();
                case 4 -> devolverLivro();
                case 5 -> System.out.println("Saindo...");
                default -> System.out.println("Opção inválida. Tente novamente.");
            }
        } while (opcao != 5);
    }

    public void cadastrarLivro() {
        System.out.println("=== CADASTRAR LIVRO ===");
        System.out.print("Tombo: ");
        int tombo = scanner.nextInt();
        scanner.nextLine(); 
        System.out.print("Título: ");
        String titulo = scanner.nextLine();
        System.out.print("Autor: ");
        String autor = scanner.nextLine();
        System.out.print("Categoria: ");
        String categoria = scanner.nextLine();
        System.out.print("Editora: ");
        String editora = scanner.nextLine();
        System.out.print("Ano: ");
        int ano = scanner.nextInt();

        Livro livro = new Livro(tombo, titulo, autor, categoria, editora, ano);
        livros.add(livro);

        System.out.println("Livro cadastrado com sucesso!");
    }

    public void cadastrarUsuario() {
        System.out.println("=== CADASTRAR USUÁRIO ===");
        System.out.print("ID: ");
        int id = scanner.nextInt();
        scanner.nextLine(); 
        System.out.print("Nome: ");
        String nome = scanner.nextLine();
        System.out.print("Endereço: ");
        String endereco = scanner.nextLine();
        System.out.print("Cidade: ");
        String cidade = scanner.nextLine();
        System.out.print("Estado: ");
        String estado = scanner.nextLine();
        System.out.print("CEP: ");
        String cep = scanner.nextLine();

        Usuario usuario = new Usuario(id, nome, endereco, cidade, estado, cep);
        usuarios.add(usuario);

        System.out.println("Usuário cadastrado com sucesso!");
    }

    public void realizarEmprestimo() {
        System.out.println("=== REALIZAR EMPRÉSTIMO ===");
        System.out.println("Livros disponíveis:");
        for (Livro livro : livros) {
            if (livro.isDisponivel()) {
                System.out.println("Tombo: " + livro.getTombo() + ", Título: " + livro.getTitulo());
            }
        }
    
        System.out.print("Informe o tombo do livro que deseja emprestar: ");
        int tombo = scanner.nextInt();
    
        Livro livroSelecionado = null;
        for (Livro livro : livros) {
            if (livro.getTombo() == tombo && livro.isDisponivel()) {
                livroSelecionado = livro;
                break;
            }
        }
    
        if (livroSelecionado == null) {
            System.out.println("Livro não disponível ou não encontrado!");
            return;
        }
    
        System.out.print("Informe o ID do usuário: ");
        int idUsuario = scanner.nextInt();
    
        Usuario usuarioSelecionado = null;
        for (Usuario usuario : usuarios) {
            if (usuario.getId() == idUsuario) {
                usuarioSelecionado = usuario;
                break;
            }
        }
    
        if (usuarioSelecionado == null) {
            System.out.println("Usuário não encontrado!");
            return;
        }
    
        int codigoReserva = proximoCodigoReserva++;
    
        Emprestimo emprestimo = new Emprestimo(codigoReserva, livroSelecionado, usuarioSelecionado, "dataReserva", "dataDevolucao");
        emprestimos.add(emprestimo);
    
        livroSelecionado.setDisponivel(false);
    
        System.out.println("Empréstimo realizado com sucesso!");
    }

    public void devolverLivro() {
        System.out.println("=== DEVOLVER LIVRO ===");
        System.out.print("Informe o ID do usuário que deseja devolver o livro: ");
        int idUsuario = scanner.nextInt();
    
        boolean usuarioEncontrado = false;
        for (Emprestimo emprestimo : emprestimos) {
            if (emprestimo.getUsuario().getId() == idUsuario) {
                usuarioEncontrado = true;
                System.out.println("Código Reserva: " + emprestimo.getCodigoReserva() + ", Livro: " + emprestimo.getLivro().getTitulo());
            }
        }
    
        if (!usuarioEncontrado) {
            System.out.println("Nenhum livro emprestado encontrado para o usuário com o ID informado!");
            return;
        }
    
        System.out.print("Informe o código de reserva do livro que deseja devolver: ");
        int codigoReserva = scanner.nextInt();
    
        Emprestimo emprestimoSelecionado = null;
        for (Emprestimo emprestimo : emprestimos) {
            if (emprestimo.getCodigoReserva() == codigoReserva && emprestimo.getUsuario().getId() == idUsuario) {
                emprestimoSelecionado = emprestimo;
                break;
            }
        }
    
        if (emprestimoSelecionado == null) {
            System.out.println("Empréstimo não encontrado!");
            return;
        }
    
        emprestimos.remove(emprestimoSelecionado);
    
        emprestimoSelecionado.getLivro().setDisponivel(true);
    
        System.out.println("Livro devolvido com sucesso!");
    }
    

}
