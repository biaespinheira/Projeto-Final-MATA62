import java.util.Date;
class Emprestimo {
    private Usuario usuario;
    //não é preciso livro, pois no exemplar já está o livro
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
}