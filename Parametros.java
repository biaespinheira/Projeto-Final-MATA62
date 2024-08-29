 import java.util.List;

public class Parametros {
    private Usuario usuario;
    private Livro livro;
    private List<Usuario> usuarios;
    private List<Livro> livros;

    public Parametros(Usuario usuario, Livro livro, List<Usuario> usuarios, List<Livro> livros) {
        this.usuario = usuario;
        this.livro = livro;
        this.usuarios = usuarios;
        this.livros = livros;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public Livro getLivro() {
        return livro;
    }

    public List<Usuario> getUsuarios() {
        return usuarios;
    }

    public List<Livro> getLivros() {
        return livros;
    }
}
