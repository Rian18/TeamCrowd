
package model;




import java.util.Date;
import java.util.List;

public class Colaborador implements Comparable<Colaborador>{

   
    private Long idColaborador;
    private Long idRepositorio;
    private Boolean autor;
    private String nome;
    private String email;
    private String login;
    private int contribuicao;
    private int numseguidores;
    private int numseguidos;
    private String local;
    private String url;
    private String imagem_URL;
    private Date criado_em;
    private List<Seguidor> seguidores;

    public Colaborador(Long idColaborador, String nome, String email, int contribuicao, String localizacao, String url, String imagem_URL, List<Seguidor> seguidores) {
       this.idColaborador = idColaborador;
        this.nome = nome;
        this.email = email;
        this.contribuicao = contribuicao;
        this.local = localizacao;
        this.url = url;
        this.imagem_URL = imagem_URL;
        this.seguidores = seguidores;
    }

    public Colaborador(Long idColaborador,Long idRepositorio, String nome, String email, String login, int contribuicao, int numseguidores, int numseguidos, String local, String url, String imagem_URL, Date criado_em) {
        this.idColaborador = idColaborador;
        this.idRepositorio = idRepositorio;
        this.nome = nome;
        this.email = email;
        this.login = login;
        this.contribuicao = contribuicao;
        this.numseguidores = numseguidores;
        this.numseguidos = numseguidos;
        this.local = local;
        this.url = url;
        this.imagem_URL = imagem_URL;
        this.criado_em = criado_em;
 
    }  
    

    public String getImagem_URL() {
        return imagem_URL;
    }

    public void setImagem_URL(String imagem_URL) {
        this.imagem_URL = imagem_URL;
    }

    public Colaborador(Long idColaborador,Long idRepositorio, String nome, String email, int contribuicao,int numSeguidos,int numSeguidores, String localizacao,String url,String imagem_URL) {
        this.idColaborador = idColaborador;
        this.idRepositorio = idRepositorio;
        this.nome = nome;
        this.email = email;
        this.contribuicao = contribuicao;
        this.numseguidos = numSeguidos;
        this.numseguidores = numSeguidores;
        this.local = localizacao;
        this.url = url;
        this.imagem_URL = imagem_URL;
    }
  
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

     public void setEmail(String email) {
        this.email = email;
    }

    public int getContribuicao() {
        return contribuicao;
    }

    public void setContribuicao(int contribuicao) {
        this.contribuicao = contribuicao;
    }

   
    public String getLocal() {
        return local;
    }

    public void setLocal(String local) {
        this.local = local;
    }

  
    public List<Seguidor> getSeguidores() {
        return seguidores;
    }

    public void setSeguidores(List<Seguidor> seguidores) {
        this.seguidores = seguidores;
    }
    
     public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
    
    public Long getIdColaborador() {
        return idColaborador;
    }

    
    public void setIdColaborador(Long idColaborador) {
        this.idColaborador = idColaborador;
    }
    
        public int getNumseguidos() {
        return numseguidos;
    }

    
    public void setNumseguidos(int numseguidos) {
        this.numseguidos = numseguidos;
    }

    public int getNumseguidores() {
        return numseguidores;
    }

    public void setNumseguidores(int numseguidores) {
        this.numseguidores = numseguidores;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public Date getCriado_em() {
        return criado_em;
    }

    public void setCriado_em(Date criado_em) {
        this.criado_em = criado_em;
    }

    
    public Boolean getAutor() {
        return autor;
    }

   
    public void setAutor(Boolean autor) {
        this.autor = autor;
    }

    public Long getIdRepositorio() {
        return idRepositorio;
    }

    
    public void setIdRepositorio(Long idRepositorio) {
        this.idRepositorio = idRepositorio;
    }
    
    @Override
    public int compareTo(Colaborador colaborador) {
      if (this.contribuicao > colaborador.getContribuicao()) {
          return -1;
     }
     if (this.contribuicao < colaborador.getContribuicao()) {
          return 1;
     }
     return 0;   
    }
    
   

}

