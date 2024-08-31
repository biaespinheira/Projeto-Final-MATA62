public class RegraEmprestimo {

    private Boolean disponivel;
    private Boolean naoDevedor;

    public RegraEmprestimo(Boolean disponivel, Boolean naoDevedor) {
        this.disponivel = disponivel;
        this.naoDevedor = naoDevedor;
    }

    // Getters
    public Boolean isDisponivel() {
        return disponivel;
    }

    public Boolean isNaoDevedor() {
        return naoDevedor;
    }

    public void setDisponivel(Boolean disponivel) {
        this.disponivel = disponivel;
    }

    public void setNaoDevedor(Boolean naoDevedor) {
        this.naoDevedor = naoDevedor;
    }
}
