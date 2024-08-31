public class ResultadoEmprestimo {
    private boolean podeEmprestar;
    private String mensagem;

    public ResultadoEmprestimo(boolean podeEmprestar, String mensagem) {
        this.podeEmprestar = podeEmprestar;
        this.mensagem = mensagem;
    }

    public boolean podeEmprestar() {
        return podeEmprestar;
    }

    public String getMensagem() {
        return mensagem;
    }
    public void printar() {
        System.out.println(getMensagem());
    }
}
