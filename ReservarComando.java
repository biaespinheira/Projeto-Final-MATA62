import java.util.Date;
class ReservarComando implements Comando {


    @Override
    public void executar(Parametros parametros) {


        Usuario usuario = parametros.getUsuario();
        Livro livro = parametros.getLivro();

        if (usuario.qtdReservas()<3){
            System.out.println("Reserva realizada: " + usuario.getNome() + " reservou "+ livro.getTitulo());
            Reserva reserva = new Reserva(usuario, livro, new Date());
            usuario.adicionarReserva(reserva);
            livro.adicionarReserva(reserva);

        }
    }


}