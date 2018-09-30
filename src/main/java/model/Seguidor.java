package model;

public class Seguidor {

   

    private Long id;
    private Long idSeguido;
    private String nome;
    private String email;
    private String login;
    private String localizacao;
    private String url;
    private String imagem_URL;

    public Seguidor(Long id, Long idSeguidor, String nome, String email, String login, String localizacao, String url, String imagem_URL) {
        this.id = id;
        this.idSeguido = idSeguidor;
        this.nome = nome;
        this.email = email;
        this.login = login;
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
    
     public Long getIdSeguido() {
        return idSeguido;
    }

   
    public void setIdSeguido(Long idSeguido) {
        this.idSeguido = idSeguido;
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

    
    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }
}
