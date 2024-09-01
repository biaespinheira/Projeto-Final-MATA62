import java.util.Scanner;

public class ConsoleIO {

    private static ConsoleIO instancia;
    private Scanner scanner;

    private ConsoleIO() {
        // Inicializa o scanner e o writer
        scanner = new Scanner(System.in);
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
        System.out.println(mensagem);
    }
}