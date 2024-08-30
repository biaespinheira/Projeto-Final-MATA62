import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

public class Main {
    private List<Usuario> usuarios = new ArrayList<Usuario>();
    private List<Livro> livros = new ArrayList<Livro>();

    public void inicializarDadosTeste() {
        // Adicionar livros
        Livro livro1 = new Livro(100, "Engenharia de Software", "Addison Wesley", "Ian Sommervile", 6, 2000);
        Livro livro2 = new Livro(101, "UML – Guia do Usuário", "Campus", "Grady Booch, James Rumbaugh, Ivar Jacobson",
                7, 2000);
        Livro livro3 = new Livro(200, "Code Complete", "Microsoft Press", "Steve McConnell", 2, 2014);
        Livro livro4 = new Livro(201, "Agile Software Development, Principles, Patterns, and Practices",
                "Prentice Hall", "Robert Martin", 1, 2002);
        Livro livro5 = new Livro(300, "Refactoring: Improving the Design of Existing Code",
                "AddisonWesley Professional", "Martin Fowler", 1, 1999);
        Livro livro6 = new Livro(301, "Software Metrics: A Rigorous and Practical Approach", "CRC Press",
                "Norman Fenton, James Bieman", 3, 2014);
        Livro livro7 = new Livro(400, "Design Patterns: Elements of Reusable Object-Oriented Software",
                "AddisonWesley Professional", "Erich Gamma, Richard Helm, Ralph Johnson, John Vlissides", 1, 1994);
        Livro livro8 = new Livro(401, "UML Distilled: A Brief Guide to the Standard Object Modeling Language",
                "AddisonWesley Professional", "Martin Fowler", 3, 2003);

        // Adicionar exemplares
        livro1.adicionarExemplar(new Exemplar(1));
        livro1.adicionarExemplar(new Exemplar(2));
        livro2.adicionarExemplar(new Exemplar(3));
        livro3.adicionarExemplar(new Exemplar(4));
        livro4.adicionarExemplar(new Exemplar(5));
        livro5.adicionarExemplar(new Exemplar(6));
        livro5.adicionarExemplar(new Exemplar(7));
        livro7.adicionarExemplar(new Exemplar(8));
        livro7.adicionarExemplar(new Exemplar(9));

        // Adicionar livros ao sistema
        livros.add(livro1);
        livros.add(livro2);
        livros.add(livro3);
        livros.add(livro4);
        livros.add(livro5);
        livros.add(livro6);
        livros.add(livro7);
        livros.add(livro8);

        // Adicionar usuários
        Usuario aluno1 = new Graduacao("João Silva", 123, new RegraEmprestimoAluno());
        Usuario aluno2 = new PosGraduacao("Luiz Fernando Rodrigues", 456, new RegraEmprestimoAluno());
        Usuario aluno3 = new Graduacao("Pedro Paulo", 789, new RegraEmprestimoAluno());
        Usuario professor1 = new Professor("Carlos Lucena", 100, new RegraEmprestimoProfessor());

        usuarios.add(aluno1);
        usuarios.add(aluno2);
        usuarios.add(aluno3);
        usuarios.add(professor1);
    }

    public static void main(String[] args) {
        Main sistema = new Main();
        sistema.inicializarDadosTeste();

        Sistema sis = new Sistema();

        try (Scanner scanner = new Scanner(System.in)) {
            while (true) {
                System.out.println("Digite o comando:");
                String input = scanner.nextLine();
                sis.processarEntrada(input, sistema.usuarios, sistema.livros);
            }
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
    }

}
