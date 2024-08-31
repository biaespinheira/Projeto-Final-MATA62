import java.util.Date;
class Emprestimo {
    private Usuario usuario;
    private Livro livro;
    private Exemplar exemplar;
    private Date dataEmprestimo;
    private Date dataDevolucao;

    public Emprestimo(Usuario usuario, Livro livro, Exemplar exemplar, Date dataEmprestimo, Date dataDevolucao) {
        this.usuario = usuario;
        this.livro = livro;
        this.exemplar = exemplar;
        this.dataEmprestimo = dataEmprestimo;
        this.dataDevolucao = dataDevolucao;
    }

    public boolean isAtrasado() {
        return new Date().after(dataDevolucao);
    }

    public Livro getLivro() {
        return livro;
    }

    public Exemplar getExemplar() {
        return exemplar;
    }

    public void setExemplar(Exemplar exemplar) {
        this.exemplar = exemplar;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Usuario getUsuario() {
        return usuario;
    }
}