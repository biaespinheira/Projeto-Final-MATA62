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
            
            if (emprestimo.getLivro().equals(livro)) {

                emprestimo.getLivro().devolverExemplar();

                emprestimo.setExemplar(null);
                emprestimos.remove(emprestimo);


                usuario.adicionarEmprestimoAntigo(emprestimo);



                System.out.println("Devolução realizada: " + usuario.getNome() + " devolveu "+ livro.getTitulo());
                return;
            }

        }
        System.out.println("Usuário não possui emprestimos em aberto para esse livro.\n");
    }
}