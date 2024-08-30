class ConsultarLivroComando implements Comando {
    @Override
    public void executar(Parametros parametros) {
        Livro livro = parametros.getLivro();
        System.out
                .println("Título: " + livro.getTitulo() + ", Exemplares Disponíveis: " + livro.temExemplarDisponivel());
    }
}

// Esse aqui tem que alterar
class ConsultarUsuarioComando implements Comando {
    @Override
    public void executar(Parametros parametros) {
        Usuario usuario = parametros.getUsuario();
        for (Emprestimo emprestimo : usuario.getEmprestimos()){
            System.out.println(emprestimo.toString());
        }
        for (Reserva reserva : usuario.getReservas()){
            System.out.println(reserva.toString());
        }
    }
}

class ConsultarNotificacoesComando implements Comando {
    @Override
    public void executar(Parametros parametros){
        Usuario usuario = parametros.getUsuario();
        Observer observer = (Observer) parametros.getUsuario();
        System.out.println(usuario.getNome() + " foi notificado "+ observer.getQtdNotificacoes()+ " vezes.");
    }
}