class ConsultarLivroComando implements Comando {
    @Override
    public void executar(Parametros parametros) {
        Repositorio repositorio = parametros.getRepositorio();

        // nesse aqui o segundo parâmetro passado é o livro ao invés do usuário
        int codigoLivro = parametros.getCodigoUsuario();
        Livro livro = repositorio.buscarLivro(codigoLivro);

        System.out.println("\nTítulo: " + livro.getTitulo());
        System.out.println("Quantidade de reservas: " + livro.getQtdReservas());

        if(livro.getQtdReservas()>=0){
            for(Reserva reserva : livro.getReservas()) {
                        System.out.println("Nome da pessoa que reservou: " + reserva.getUsuario().getNome());
            }
        }

        if(livro.temExemplarDisponivel()){
            for (Exemplar exemplar : livro.getExemplares()){
                System.out.println("\nCódigo do exemplar: " + exemplar.getCodigo());

                String status = "Disponível";
                if (!exemplar.isDisponivel()){
                    status="Emprestado para ";
                    Emprestimo emprestimo = exemplar.getEmprestimo();
                    status+= emprestimo.getUsuario().getNome();
                    status+= "\nData do empréstimo: " + emprestimo.getDataEmprestimo();
                    status+= "| Data de devolução: " + emprestimo.getDataDevolucao();
                }

                System.out.println("Status: "+ status + "\n");
            }

        }    
        else{
            System.out.println("\nExemplares Disponíveis: 0\n");
        }
}
}

class ConsultarUsuarioComando implements Comando {
    @Override
    public void executar(Parametros parametros) {

        Repositorio repositorio = parametros.getRepositorio();

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

        System.out.println(informacao);
    }
}

class ConsultarNotificacoesComando implements Comando {
    @Override
    public void executar(Parametros parametros){

        Repositorio repositorio = parametros.getRepositorio();
        int codigoUsuario = parametros.getCodigoUsuario();
        
        Usuario usuario = repositorio.buscarUsuario(codigoUsuario);

        Observer observer = (Observer) usuario;

        System.out.println("\n" + usuario.getNome() + " foi notificado "+ observer.getQtdNotificacoes()+ " vezes.\n");
    }
}