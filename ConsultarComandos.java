class ConsultarLivroComando implements Comando {
    @Override
    public void executar(Parametros parametros) {
        Repositorio repositorio = parametros.getRepositorio();

        // nesse aqui o segundo parâmetro passado é o livro ao invés do usuário
        int codigoLivro = parametros.getCodigoUsuario();
        Livro livro = repositorio.buscarLivro(codigoLivro);


        System.out
                .println("Título: " + livro.getTitulo() + ", Exemplares Disponíveis: " + livro.temExemplarDisponivel());
    }
}

// Esse aqui tem que alterar
class ConsultarUsuarioComando implements Comando {
    @Override
    public void executar(Parametros parametros) {

        Repositorio repositorio = parametros.getRepositorio();

        int codigoUsuario = parametros.getCodigoUsuario();
        Usuario usuario = repositorio.buscarUsuario(codigoUsuario);

        // ADICIONAR LÓGICA PARA SAÍDA DE INFORMAÇÕES DO USUÁRIO CONFORME PDF
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

        Repositorio repositorio = parametros.getRepositorio();
        int codigoUsuario = parametros.getCodigoUsuario();
        
        Usuario usuario = repositorio.buscarUsuario(codigoUsuario);

        Observer observer = (Observer) usuario;

        System.out.println(usuario.getNome() + " foi notificado "+ observer.getQtdNotificacoes()+ " vezes.");
    }
}