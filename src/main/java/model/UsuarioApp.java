
package model;


public class UsuarioApp {   
    private String nome;
    private String apelido;
    private String urlGit;
    private String email;
    private String foto_url;
    private String senha;

    public UsuarioApp(String nome,String apelido, String urlGit, String email, String foto_url, String senha) {
        this.nome = nome;
        this.apelido = apelido;
        this.urlGit = urlGit;
        this.email = email;
        this.foto_url = foto_url;
        this.senha = senha;
    }

    public String getApelido() {
        return apelido;
    }

    public void setApelido(String apelido) {
        this.apelido = apelido;
    }
    
    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
    
       public String getNome() {
        return nome;
    }

    
    public void setNome(String nome) {
        this.nome = nome;
    }

    
    public String getUrlGit() {
        return urlGit;
    }

    public void setUrlGit(String urlGit) {
        this.urlGit = urlGit;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFoto_url() {
        return foto_url;
    }

    public void setFoto_url(String foto_url) {
        this.foto_url = foto_url;
    }
    
}
