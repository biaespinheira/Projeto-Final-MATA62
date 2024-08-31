import java.util.Date;
class ReservarComando implements Comando {


    @Override
    public void executar(Parametros parametros) {
        Repositorio repositorio = parametros.getRepositorio();

        int codigoLivro = parametros.getCodigoLivro();
        Livro livro = repositorio.buscarLivro(codigoLivro);

        int codigoUsuario = parametros.getCodigoUsuario();
        Usuario usuario = repositorio.buscarUsuario(codigoUsuario);

        if (usuario.qtdReservas()<usuario.getLimiteLivros()){
            System.out.println("Reserva realizada: " + usuario.getNome() + " reservou "+ livro.getTitulo());
            Reserva reserva = new Reserva(usuario, livro, new Date());
            usuario.adicionarReserva(reserva);
            livro.adicionarReserva(reserva);

        }
        else{
            System.out.println("Reserva não realizada: " + usuario.getNome() + " tentou reservar mais que "+usuario.getLimiteLivros()+" livros");
        }
    }

}