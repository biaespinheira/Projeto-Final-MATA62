public class SairComando implements Comando {
    @Override
    public void executar(Parametros parametros){
        ConsoleIO console = ConsoleIO.getInstancia();
        console.mostrarMensagem("\nSaindo do sistema...\n");
        System.exit(0);
    }
}
