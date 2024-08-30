public class Parametros {
    private int codigoUsuario;
    private int codigoLivro;
    private Repositorio repositorio;

    public Parametros(Repositorio repositorio, int codigoUsuario, int codigoLivro) {
        this.repositorio = repositorio;
        this.codigoUsuario = codigoUsuario;
        this.codigoLivro = codigoLivro;
    }

    public int getCodigoUsuario() {
        return this.codigoUsuario;
    }

    public int getCodigoLivro() {
        return this.codigoLivro;
    }

    public Repositorio getRepositorio (){
        return this.repositorio;
    }
}
