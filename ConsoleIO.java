import java.io.PrintWriter;
import java.util.Scanner;

public class ConsoleIO {

    private static ConsoleIO instancia;
    private Scanner scanner;
    private PrintWriter writer;

    private ConsoleIO() {
        // Inicializa o scanner e o writer
        scanner = new Scanner(System.in);
        writer = new PrintWriter(System.out);
    }

    public static ConsoleIO getInstancia() {
        if (instancia == null) {
            instancia = new ConsoleIO();
        }
        return instancia;
    }

    public String lerComando() {
        return scanner.nextLine();
    }

    public void mostrarMensagem(String mensagem) {
        writer.println(mensagem);
        writer.flush();
    }
}