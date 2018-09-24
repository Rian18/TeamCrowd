
package model;

import java.util.List;

public class Repositorio {
    
    private long id; 
    private String description;
    private String fullName;
    private String name;
    private String email;
    private String url;
    private String palavraChave;
    private List<Colaborador> colaboradores;
    
     public Repositorio(long id, String description, String fullName, String name, String url, String palavraChave) {
        this.id = id;
        this.description = description;
        this.fullName = fullName;
        this.name = name;
        this.url = url;
        this.palavraChave = palavraChave;}

    
    public List <Colaborador> getColaboradores() {
        return colaboradores;
    }

    public void setColaboradores(List <Colaborador> colaboradores) {
        this.colaboradores = colaboradores;
    }
   

    

    public Repositorio(long id,String description, String fullName, String name, String email,List<Colaborador> colaboradores,String url) {
        this.id = id;
        this.description = description;
        this.fullName = fullName;
        this.name = name;
        this.email = email;
        this.colaboradores = colaboradores;
        this.url = url;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

   
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
    
    public String getPalavraChave() {
        return palavraChave;
    }

    public void setPalavraChave(String palavraChave) {
        this.palavraChave = palavraChave;
    }
}
