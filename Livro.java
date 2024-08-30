import java.util.List;
import java.util.ArrayList;

interface Subject {
    void registrarObservador(Observer observer);
}

class Livro implements Subject{
    
    private int codigo;
    private String titulo;
    private String editora;
    private String autores;
    private int edicao;
    private int anoPublicacao;
    private List<Exemplar> exemplares;
    private List <Reserva> reservas;
    private List <Observer> observers;

    public Livro(int codigo, String titulo, String editora, String autores, int edicao, int anoPublicacao) {
        this.codigo = codigo;
        this.titulo = titulo;
        this.editora = editora;
        this.autores = autores;
        this.edicao = edicao;
        this.anoPublicacao = anoPublicacao;
        this.exemplares = new ArrayList<Exemplar>();
        this.reservas = new ArrayList<Reserva>();
        this.observers = new ArrayList<Observer>();
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
        this.notificarObservadores();
    }

    @Override
    public void registrarObservador(Observer observer){
        // talvez precise verificar se o usuário já é observador
        this.observers.add(observer);
    }

    public void notificarObservadores(){
        if (this.getQtdReservas()>=2){
            observers.forEach(o -> o.notificar());
        }
    }
}