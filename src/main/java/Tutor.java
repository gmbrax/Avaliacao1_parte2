import java.util.Observable;
import java.util.Observer;

public class Tutor implements Observer {

    private String nome;
    private String telefone;
    private String email;
    private String RG;
    private String CPF;

    private String ultimaNotificacao;


    public String getCPF() {
        return CPF;
    }

    public void setCPF(String CPF) {
        this.CPF = CPF;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getRG() {
        return RG;
    }

    public void setRG(String RG) {
        this.RG = RG;
    }

    public String getUltimaNotificacao() {
        return ultimaNotificacao;
    }

    public void atender(Atendimento atendimento){}


    @Override
    public void update(Observable o, Object arg) {
        this.ultimaNotificacao = this.nome + " teve uma atualização no seu atendimento " + o.toString();
    }
}
