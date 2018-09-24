package model;

public class Seguidor {

    private Long id;
    private String nome;
    private String email;
    private int numseguidos;
    private int numseguidores;
    private String localizacao;
    private String url;
    private String imagem_URL;

    public Seguidor(Long id, String nome, String email, int numseguidos, int numseguidores, String localizacao, String url, String imagem_URL) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.numseguidos = numseguidos;
        this.numseguidores = numseguidores;
        this.localizacao = localizacao;
        this.url = url;
        this.imagem_URL = imagem_URL;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public String getLocalizacao() {
        return localizacao;
    }

   
    public void setLocalizacao(String localizacao) {
        this.localizacao = localizacao;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getImagem_URL() {
        return imagem_URL;
    }

   
    public void setImagem_URL(String imagem_URL) {
        this.imagem_URL = imagem_URL;
    }

}
