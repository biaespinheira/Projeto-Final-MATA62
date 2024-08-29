import java.util.HashMap;

public class Sistema {
    public HashMap<String, Comando> comandos = new HashMap<String, Comando>();

    public Sistema() {
        initComandos(); 
    }

    public void initComandos() {
        comandos.put("emp", new EmprestarComando());
        comandos.put("dev", new DevolverComando());
        comandos.put("liv", new ConsultarLivroComando());
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
