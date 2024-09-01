class ConsultarLivroComando implements Comando {
    @Override
    public void executar(Parametros parametros) {

        ConsoleIO console = ConsoleIO.getInstancia();
        Repositorio repositorio = parametros.getRepositorio();

        // O código do livro é recuperado corretamente do parâmetro.
        int codigoLivro = parametros.getCodigoUsuario();
        Livro livro = repositorio.buscarLivro(codigoLivro);

        String informacoes="\n";

        informacoes+="Título: " + livro.getTitulo();
        informacoes+="\nQuantidade de reservas: " + livro.getQtdReservas()+"\n";


        for(Reserva reserva : livro.getReservas()) {
            informacoes+="\nNome da pessoa que reservou: " + reserva.getUsuario().getNome();
        }

        for (Exemplar exemplar : livro.getExemplares()){
            informacoes+="\nCódigo do exemplar: " + exemplar.getCodigo();

            String status = "Disponível";
            if (!exemplar.isDisponivel()){
                status="Emprestado para ";
                Emprestimo emprestimo = exemplar.getEmprestimo();
                status+= emprestimo.getUsuario().getNome();
                status+= "\nData do empréstimo: " + emprestimo.getDataEmprestimo();
                status+= " | Data de devolução: " + emprestimo.getDataDevolucao();
            }

            informacoes+=" | Status: "+ status + "\n";
        }

        console.mostrarMensagem(informacoes);

        }
}

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

class ConsultarNotificacoesComando implements Comando {
    @Override
    public void executar(Parametros parametros){

        ConsoleIO console = ConsoleIO.getInstancia();
        Repositorio repositorio = parametros.getRepositorio();
        int codigoUsuario = parametros.getCodigoUsuario();
        
        Usuario usuario = repositorio.buscarUsuario(codigoUsuario);

        Observer observer = (Observer) usuario;

        console.mostrarMensagem("\n" + usuario.getNome() + " foi notificado "+ observer.getQtdNotificacoes()+ " vezes.\n");
    }
}