class ConsultarLivroComando implements Comando {
    @Override
    public void executar(Parametros parametros) {
        Repositorio repositorio = parametros.getRepositorio();


        // nesse aqui o segundo parâmetro passado é o livro ao invés do usuário
        int codigoLivro = parametros.getCodigoUsuario();
        Livro livro = repositorio.buscarLivro(codigoLivro);

        System.out.println("Título: " + livro.getTitulo());

        System.out.println("Quantidade de reservas: " + livro.getQtdReservas());
        if(livro.getQtdReservas()>=0){
            for(int j=0 ; j<livro.getListaReservas().size();j++) {

                        System.out.println(
                                "Nome da pessoa que reservou: " + livro.getListaReservas().get(j).getUsuario().getNome()
                        );

            }
        }

        if(livro.temExemplarDisponivel())
            System.out.println( "Exemplares Disponíveis: " + livro.getQtdExemplaresDisponiveis());
        else
            System.out.println("Exemplares Disponíveis: 0");


        for(int j=0 ; j<livro.getListaExemplares().size();j++) {
            // "Nome da pessoa que emprestou: " + livro.getListaExemplares().get(j).getEmprestimo().getUsuario().getNome()
            if(livro.getListaExemplares().get(j).isDisponivel() == false){
                System.out.println(
                        "Nome da pessoa que emprestou: " + livro.getListaExemplares().get(j).getEmprestimo().getUsuario().getNome()
                );
            }


        }

    }
}

// Esse aqui tem que alterar
class ConsultarUsuarioComando implements Comando {
    @Override
    public void executar(Parametros parametros) {

        Repositorio repositorio = parametros.getRepositorio();

        int codigoUsuario = parametros.getCodigoUsuario();
        Usuario usuario = repositorio.buscarUsuario(codigoUsuario);

        System.out.println(usuario.getNome());

        // ADICIONAR LÓGICA PARA SAÍDA DE INFORMAÇÕES DO USUÁRIO CONFORME PDF
        for (Emprestimo emprestimo : usuario.getEmprestimos()){
            System.out.println(usuario.getNome()+ " realizou emprestimo de " + emprestimo.getLivro().getTitulo());
        }
        for (Reserva reserva : usuario.getReservas()){
            System.out.println(reserva.getLivro().getTitulo()+ " está reservado para "+ usuario.getNome());
        }

    }
}

class ConsultarNotificacoesComando implements Comando {
    @Override
    public void executar(Parametros parametros){

        Repositorio repositorio = parametros.getRepositorio();
        int codigoUsuario = parametros.getCodigoUsuario();
        
        Usuario usuario = repositorio.buscarUsuario(codigoUsuario);

        Observer observer = (Observer) usuario;

        System.out.println(usuario.getNome() + " foi notificado "+ observer.getQtdNotificacoes()+ " vezes.");
    }
}