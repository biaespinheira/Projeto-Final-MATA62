public class SairComando implements Comando {
    @Override
    public void executar(Parametros parametros){
        System.exit(0);
    }
}
