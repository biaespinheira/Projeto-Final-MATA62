class ConsultarUsuarioComando implements Comando {
    @Override
    public void executar(Parametros parametros) {

        Repositorio repositorio = parametros.getRepositorio();
        ConsoleIO console = ConsoleIO.getInstancia();

        int codigoUsuario = parametros.getCodigoUsuario();
        Usuario usuario = repositorio.buscarUsuario(codigoUsuario);

        String informacao="";
        for (Emprestimo emprestimo : usuario.getEmprestimos()){
            informacao+="\nEmpréstimo (corrente) do livro: " + emprestimo.getExemplar().getLivro().getTitulo();
            informacao+="\nData do empréstimo "+ emprestimo.getDataEmprestimo();
            informacao+=" | Data de devolução: "+emprestimo.getDataDevolucao()+"\n";
        }

        for (Emprestimo emprestimo : usuario.getEmprestimosPassados()){
            informacao+="\nEmpréstimo (passado) do livro: " + emprestimo.getExemplar().getLivro().getTitulo();
            informacao+="\nData do empréstimo "+ emprestimo.getDataEmprestimo();
            informacao+=" | Data de devolução: "+emprestimo.getDataDevolucao()+"\n";
        }

        for (Reserva reserva : usuario.getReservas()){
            informacao+="\nReserva (corrente) do livro: "+reserva.getLivro().getTitulo();
            informacao+="\nData da solicitação: "+reserva.getData()+"\n";
        }

        for (Reserva reserva : usuario.getReservasPassadas()){
            informacao+="\nReserva (passada) do livro: "+reserva.getLivro().getTitulo();
            informacao+="\nData da solicitação: "+reserva.getData()+"\n";
        }

        console.mostrarMensagem(informacao);
    }
}
