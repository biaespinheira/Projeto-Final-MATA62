class RegraEmprestimoProfessor implements IRegraEmprestimo {

    @Override
    public boolean podeEmprestar(Livro livro, Usuario usuario) {
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
            System.out.println("Professor " + usuario.getNome() + " pode pegar o livro!");
        }
        if(!naoDevedor){
            System.out.println("Professor " + usuario.getNome() + " não pode pegar o livro pois está devedor!");
        }
        if(!disponivel){
            System.out.println("Professor " + usuario.getNome() + " não pode pegar o livro pois não tem exemplares disponíveis!");
        }



        return podeEmprestar;
    }
}