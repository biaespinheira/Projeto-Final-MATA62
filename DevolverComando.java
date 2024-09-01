import java.util.List;

class DevolverComando implements Comando {

    @Override
    public void executar(Parametros parametros) {
        Repositorio repositorio = parametros.getRepositorio();

        int codigoLivro = parametros.getCodigoLivro();
        Livro livro = repositorio.buscarLivro(codigoLivro);

        int codigoUsuario = parametros.getCodigoUsuario();
        Usuario usuario = repositorio.buscarUsuario(codigoUsuario);

        List <Emprestimo> emprestimos = usuario.getEmprestimos();

        for (Emprestimo emprestimo : emprestimos) {
            
            if (emprestimo.getExemplar().getLivro().equals(livro)) {

                usuario.removerEmprestimo(emprestimo);
                emprestimo.getExemplar().getLivro().devolverExemplar();
                System.out.println("\nDevolução realizada: " + usuario.getNome() + " devolveu o livro: "+ livro.getTitulo()+"\n");
                return;
            }

        }
        System.out.println("\nUsuário não possui emprestimos em aberto para esse livro.\n");
    }
}