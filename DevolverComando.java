class DevolverComando implements Comando {
    @Override
    public void executar(Parametros parametros) {
        for (Emprestimo emprestimo : parametros.getUsuario().getEmprestimos()) {
            if (emprestimo.getLivro().equals(parametros.getLivro())) {
                Exemplar exemplar = emprestimo.getLivro().emprestarExemplar();
                exemplar.setDisponivel(true);
                parametros.getUsuario().getEmprestimos().remove(emprestimo);
                System.out.println("Devolução realizada: " + parametros.getUsuario().getNome() + " devolveu "+ parametros.getLivro().getTitulo());
                return;
            }
        }
        System.out.println("Nenhum empréstimo encontrado para devolução.");
    }
}