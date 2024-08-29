import java.util.Date;
class Reserva {
    private Usuario usuario;
    private Livro livro;
    private Date dataReserva;

    public Reserva(Usuario usuario, Livro livro, Date dataReserva) {
        this.usuario = usuario;
        this.livro = livro;
        this.dataReserva = dataReserva;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public Livro getLivro() {
        return livro;
    }
}