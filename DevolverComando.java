import java.util.List;

class DevolverComando implements Comando {

    @Override
    public void executar(Parametros parametros) {
        Repositorio repositorio = parametros.getRepositorio();
        ConsoleIO console = ConsoleIO.getInstancia();

        int codigoLivro = parametros.getCodigoLivro();
        Livro livro = repositorio.buscarLivro(codigoLivro);

        int codigoUsuario = parametros.getCodigoUsuario();
        Usuario usuario = repositorio.buscarUsuario(codigoUsuario);

        List <Emprestimo> emprestimos = usuario.getEmprestimos();

        for (Emprestimo emprestimo : emprestimos) {
            
            if (emprestimo.getExemplar().getLivro().equals(livro)) {

                usuario.removerEmprestimo(emprestimo);
                emprestimo.getExemplar().getLivro().devolverExemplar();
                console.mostrarMensagem("\nDevolução realizada: " + usuario.getNome() + " devolveu o livro: "+ livro.getTitulo()+"\n");
                return;
            }

        }
        console.mostrarMensagem("\nUsuário não possui emprestimos em aberto para esse livro.\n");
    }
}