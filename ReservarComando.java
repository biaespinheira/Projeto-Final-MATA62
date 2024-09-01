import java.util.Date;
class ReservarComando implements Comando {


    @Override
    public void executar(Parametros parametros) {
        ConsoleIO console = ConsoleIO.getInstancia();

        Repositorio repositorio = parametros.getRepositorio();

        int codigoLivro = parametros.getCodigoLivro();
        Livro livro = repositorio.buscarLivro(codigoLivro);

        int codigoUsuario = parametros.getCodigoUsuario();
        Usuario usuario = repositorio.buscarUsuario(codigoUsuario);

        if (usuario.qtdReservas()<3){
            console.mostrarMensagem("\nReserva realizada: " + usuario.getNome() + " reservou "+ livro.getTitulo()+"\n");
            Reserva reserva = new Reserva(usuario, livro, new Date());
            usuario.adicionarReserva(reserva);
            livro.adicionarReserva(reserva);
        } else{
            console.mostrarMensagem("\nNão foi possível realizar a reserva pois o usuário já possui mais de 3 reservas!\n");
        }
    }


}