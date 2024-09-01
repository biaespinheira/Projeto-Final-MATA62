class RegraEmprestimoProfessor implements IRegraEmprestimo {
    @Override
    
    public boolean podeEmprestar(Livro livro, Usuario usuario) {
        ConsoleIO console = ConsoleIO.getInstancia();

        boolean disponivel = livro.temExemplarDisponivel();
        boolean naoDevedor = true;

        // talvez fazer isso dentro de usuario;
        for (Emprestimo emprestimo : usuario.getEmprestimos()) {
            if (emprestimo.isAtrasado()) {
                naoDevedor = false;
                break;
            }
        }
        
        boolean podeEmprestar = disponivel && naoDevedor;

        if(podeEmprestar){
            console.mostrarMensagem("\nProfessor " + usuario.getNome() + " pode pegar o livro!\n");
        }
        else if(!disponivel){
            console.mostrarMensagem("\nProfessor " + usuario.getNome() + " não pode pegar o livro pois não tem exemplares disponíveis!\n");
        }
        else if(!naoDevedor){
            console.mostrarMensagem("\nProfessor " + usuario.getNome() + " não pode pegar o livro pois está devedor!\n");
        }

        return podeEmprestar;
    }
}