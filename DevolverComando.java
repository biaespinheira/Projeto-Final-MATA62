import java.util.List;

class DevolverComando implements Comando {

    @Override
    public void executar(Parametros parametros) {
        Usuario usuario = parametros.getUsuario();
        List <Emprestimo> emprestimos = usuario.getEmprestimos();
        Livro livro = parametros.getLivro();

        for (Emprestimo emprestimo : emprestimos) {

            if (emprestimo.getLivro().equals(livro)) {

                emprestimo.getLivro().devolverExemplar();

                emprestimos.remove(emprestimo);
                System.out.println("Devolução realizada: " + usuario.getNome() + " devolveu "+ livro.getTitulo());
                return;
            }

        }
        System.out.println("Nenhum empréstimo encontrado para devolução.");
    }
}