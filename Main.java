import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Repositorio repositorio = Repositorio.getInstancia();
        ConsoleIO console = ConsoleIO.getInstancia();
        Sistema sistema = new Sistema();

        try (Scanner scanner = new Scanner(System.in)) {

            while (true) {
                console.mostrarMensagem("Digite o comando:");
                String input = console.lerComando();

                String[] parts = input.split(" ");
                String comandoStr = parts[0];
        
        
                int codigoUsuario = -1;
                if (parts.length > 1) {
                    codigoUsuario = Integer.parseInt(parts[1]);
                }
        
                int codigoLivro = -1;
                if (parts.length > 2) {
                    codigoLivro = Integer.parseInt(parts[2]);
                }
        
                Parametros parametros = new Parametros(repositorio, codigoUsuario, codigoLivro);
                sistema.executarComando(comandoStr, parametros);

            }
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }

    }

}
