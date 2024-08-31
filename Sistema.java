import java.util.HashMap;

public class Sistema {
    public HashMap<String, Comando> comandos = new HashMap<String, Comando>();

    public Sistema() {
        initComandos(); 
    }

    public void initComandos() {
        comandos.put("emp", new EmprestarComando());
        comandos.put("dev", new DevolverComando());
        comandos.put("res", new ReservarComando());
        comandos.put("obs", new RegistrarObservadorComando());
        comandos.put("liv", new ConsultarLivroComando());
        comandos.put("usu", new ConsultarUsuarioComando());
        comandos.put("ntf", new ConsultarNotificacoesComando());
        comandos.put("sai", new SairComando());
    }


    public void executarComando(String strComando, Parametros parametros) {
        Comando comando = comandos.get(strComando);
        if (comando != null) {
            comando.executar(parametros);
        } else {
            System.out.println("Comando não reconhecido: " + strComando);
        }
    }
}
