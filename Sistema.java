import java.util.HashMap;
import java.util.List;

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

    public void processarEntrada(String input, List<Usuario> usuarios, List<Livro> livros) {
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

        Usuario usuario = encontrarUsuario(codigoUsuario, usuarios);
        Livro livro = encontrarLivro(codigoLivro, livros);

        Parametros parametros = new Parametros(usuario, livro, usuarios, livros);
        executarComando(comandoStr, parametros);
    }

    private Usuario encontrarUsuario(int codigoUsuario, List<Usuario> usuarios) {
        for (Usuario u : usuarios) {
            if (u.getCodigo() == codigoUsuario) {
                return u;
            }
        }
        return null;
    }

    private Livro encontrarLivro(int codigoLivro, List<Livro> livros) {
        for (Livro l : livros) {
            if (l.getCodigo() == codigoLivro) {
                return l;
            }
        }
        return null;
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
