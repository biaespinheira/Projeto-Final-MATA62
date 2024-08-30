import java.util.List;
import java.util.ArrayList;

class Livro {
    
    private int codigo;
    private String titulo;
    private String editora;
    private String autores;
    private int edicao;
    private int anoPublicacao;
    private List<Exemplar> exemplares;
    private List <Reserva> reservas;

    public Livro(int codigo, String titulo, String editora, String autores, int edicao, int anoPublicacao) {
        this.codigo = codigo;
        this.titulo = titulo;
        this.editora = editora;
        this.autores = autores;
        this.edicao = edicao;
        this.anoPublicacao = anoPublicacao;
        this.exemplares = new ArrayList<Exemplar>();
        this.reservas = new ArrayList<Reserva>();
    }

    public int getCodigo() {
        return codigo;
    }

    public String getTitulo() {
        return titulo;
    }

    public void adicionarExemplar(Exemplar exemplar) {
        exemplares.add(exemplar);
    }
    
    public boolean temExemplarDisponivel() {
        for (Exemplar exemplar : exemplares) {
            if (exemplar.isDisponivel()) {
                return true;
            }
        }
        return false;
    }

    public int getQtdDisponiveis(){
        int qtd=0;
        for (Exemplar exemplar : exemplares) {
            if (exemplar.isDisponivel()) {
                qtd+=1;
            }
        }
        return qtd;
    }
    
    public int getQtdReservas(){
        return this.reservas.size();
    }

    public Exemplar emprestarExemplar() {
        for (Exemplar exemplar : exemplares) {
            if (exemplar.isDisponivel()) {
                exemplar.setDisponivel(false);
                return exemplar;
            }
        }
        return null;
    }

    public Exemplar devolverExemplar(){
        for (Exemplar exemplar : exemplares) {
            if (!exemplar.isDisponivel()) {
                exemplar.setDisponivel(true);
                return exemplar;
            }
        }
        return null;
    }

    public boolean temReserva(Usuario usuario){
        for (Reserva reserva : this.reservas){
            if (reserva.getUsuario()==usuario){
                return true;
            }
        }
        return false;
    }

    public void removerReserva(Usuario usuario){
        for (Reserva reserva : this.reservas){
            if (reserva.getUsuario()==usuario){
                this.reservas.remove(reserva);
                break;
            }
        }
    }

    public void adicionarReserva(Reserva reserva){
        this.reservas.add(reserva);
    }

}