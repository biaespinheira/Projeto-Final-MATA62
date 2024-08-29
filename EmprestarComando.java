import java.util.Date;
class EmprestarComando implements Comando {
    @Override
    public void executar(Parametros parametros) {
        IVerificadorEmprestimos verificador = new VerificadorAluno(); // ou VerificadorProfessor dependendo do usuário

        if (verificador.verificarDisponibilidade(parametros.getLivro(), parametros.getUsuario())) {
            Exemplar exemplarEmprestado = parametros.getLivro().emprestarExemplar();
            Emprestimo emprestimo = new Emprestimo(parametros.getUsuario(), parametros.getLivro(), exemplarEmprestado,
                    new Date(),
                    new Date(
                            System.currentTimeMillis() + parametros.getUsuario().getPrazoDias() * 24 * 60 * 60 * 1000));
            parametros.getUsuario().adicionarEmprestimo(emprestimo);
            System.out.println("Empréstimo realizado: " + parametros.getUsuario().getNome() + " pegou o livro."
                    + parametros.getLivro().getTitulo());
        } else {
            System.out.println("Empréstimo não pode ser realizado para " + parametros.getUsuario().getNome());
        }
    }
}