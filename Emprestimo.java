import java.util.Date;
class Emprestimo {
    private Usuario usuario;
    private Exemplar exemplar;
    private Date dataEmprestimo;
    private Date dataDevolucao;

    public Emprestimo(Usuario usuario, Livro livro, Exemplar exemplar, Date dataEmprestimo, Date dataDevolucao) {
        this.usuario = usuario;
        this.exemplar = exemplar;
        this.dataEmprestimo = dataEmprestimo;
        this.dataDevolucao = dataDevolucao;
    }

    public Exemplar getExemplar(){
        return this.exemplar;
    }

    public boolean isAtrasado() {
        return new Date().after(dataDevolucao);
    }

    public Usuario getUsuario(){
        return this.usuario;
    }

    public Date getDataEmprestimo(){
        return this.dataEmprestimo;
    }

    public Date getDataDevolucao(){
        return this.dataDevolucao;
    }

    public void setDataDevolucao(Date dataDevolucao){
        this.dataDevolucao = dataDevolucao;
    }
}