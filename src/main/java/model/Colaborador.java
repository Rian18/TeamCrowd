
package model;

import java.util.List;

public class Colaborador {


    private Long idColaborador;
    private String nome;
    private String email;
    private int contribuicao;
    private int numseguidos;
    private int numseguidores;
    private String localizacao;
    private String url;
    private String imagem_URL;
    private List<Seguidor> seguidores;

    public Colaborador(Long idColaborador, String nome, String email, int contribuicao, String localizacao, String url, String imagem_URL, List<Seguidor> seguidores) {
       this.idColaborador = idColaborador;
        this.nome = nome;
        this.email = email;
        this.contribuicao = contribuicao;
        this.localizacao = localizacao;
        this.url = url;
        this.imagem_URL = imagem_URL;
        this.seguidores = seguidores;
    }

    public String getImagem_URL() {
        return imagem_URL;
    }

    public void setImagem_URL(String imagem_URL) {
        this.imagem_URL = imagem_URL;
    }

    public Colaborador(Long idColaborador, String nome, String email, int contribuicao,int numSeguidos,int numSeguidores, String localizacao,String url,String imagem_URL) {
        this.idColaborador = idColaborador;
        this.nome = nome;
        this.email = email;
        this.contribuicao = contribuicao;
        this.numseguidos = numSeguidos;
        this.numseguidores = numSeguidores;
        this.localizacao = localizacao;
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

   
    public String getLocalizacao() {
        return localizacao;
    }

    public void setLocalizacao(String localizacao) {
        this.localizacao = localizacao;
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

}
