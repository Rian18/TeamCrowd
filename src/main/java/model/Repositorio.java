
package model;



import java.util.Date;
import java.util.List;

public class Repositorio {
  
    private long idRepositorio; 
    private String description;
    private String fullName;
    private String name;
    private String linguagem;
    private String url;
    private int numEstrelas;
    private int observadores;
    private Date data_criacao;
    private List<Colaborador> colaboradores;

    public Repositorio(long idRepositorio, String description, String fullName, String name, String linguagem, String url, int numEstrelas, int observadores, Date data_criacao, List<Colaborador> colaboradores) {
        this.idRepositorio = idRepositorio;
        this.description = description;
        this.fullName = fullName;
        this.name = name;
        this.linguagem = linguagem;
        this.url = url;
        this.numEstrelas = numEstrelas;
        this.observadores = observadores;
        this.data_criacao = data_criacao;
        this.colaboradores = colaboradores;
    }
    
    public Repositorio(long idRepositorio, String description, String fullName, String name, String linguagem, String url, int numEstrelas, int observadores, Date data_criacao) {
        this.idRepositorio = idRepositorio;
        this.description = description;
        this.fullName = fullName;
        this.name = name;
        this.linguagem = linguagem;
        this.url = url;
        this.numEstrelas = numEstrelas;
        this.observadores = observadores;
        this.data_criacao = data_criacao;
      
    }
 
    public List <Colaborador> getColaboradores() {
        return colaboradores;
    }

    public void setColaboradores(List <Colaborador> colaboradores) {
        this.colaboradores = colaboradores;
    }
 
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLinguagem() {
        return linguagem;
    }

    public void setLinguagem(String linguagem) {
        this.linguagem = linguagem;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

   
    public long getIdRepositorio() {
        return idRepositorio;
    }

    public void setIdRepositorio(long idRepositorio) {
        this.idRepositorio = idRepositorio;
    }
    
    
     public int getNumEstrelas() {
        return numEstrelas;
    }

    public void setNumEstrelas(int numEstrelas) {
        this.numEstrelas = numEstrelas;
    }
    
    
    
    public Date getData_criacao() {
        return data_criacao;
    }

    public void setData_criacao(Date data_criacao) {
        this.data_criacao = data_criacao;
    }
    
     public int getObservadores() {
        return observadores;
    }

    public void setObservadores(int observadores) {
        this.observadores = observadores;
    }
}
