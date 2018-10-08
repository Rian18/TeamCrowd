package br.ufjf.teamcrowd;

import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Colaborador;
import model.Repositorio;
import model.Seguidor;
import org.kohsuke.github.GHRepository;
import org.kohsuke.github.GHRepositorySearchBuilder;
import org.kohsuke.github.GHUser;
import org.kohsuke.github.GitHub;
import org.kohsuke.github.PagedIterable;
import persistence.ColaboradorDAO;
import persistence.ItemDAO;
import persistence.RepositorioDAO;
import persistence.SeguidorDAO;

/**
 *
 * @author Rian Alves
 */
public class MineradorGit {

    private String url = "";

    public void Busca(String keyword) throws IOException, SQLException, ClassNotFoundException {
        Conexao conexao = new Conexao();

        GitHub github = conexao.getConexao();
        GHRepositorySearchBuilder repo = github.searchRepositories();
        GHRepositorySearchBuilder repos = repo.q(keyword);
        PagedIterable<GHRepository> repositorios = repos.list();

        for (GHRepository repositorio : repositorios) {
            //Salvar Repositorio no banco
            java.util.Date dateRepo = repositorio.getCreatedAt();
            java.sql.Date sqlDaterepo = new java.sql.Date(dateRepo.getTime());
            
            Repositorio reposit = new Repositorio(repositorio.getId(), repositorio.getDescription(),
                    repositorio.getFullName(), repositorio.getName(), repositorio.getLanguage(), repositorio.getUrl().toString(), repositorio.getStargazersCount(), repositorio.getWatchers(),sqlDaterepo);
            RepositorioDAO.getINSTANCE().save(reposit);

            PagedIterable<GHRepository.Contributor> colaboradores = repositorio.listContributors();
            for (GHRepository.Contributor colaboradore : colaboradores) {
                java.util.Date dateCol = colaboradore.getCreatedAt();
               java.sql.Date sqlDatecol = new java.sql.Date(dateCol.getTime());
              
                Colaborador colab = new Colaborador(colaboradore.getId(),reposit.getIdRepositorio(), colaboradore.getName(), colaboradore.getEmail(), colaboradore.getLogin(), colaboradore.getContributions(),
                        colaboradore.getFollowersCount(), colaboradore.getFollowingCount(), colaboradore.getLocation(), colaboradore.getHtmlUrl().toString(), colaboradore.getAvatarUrl(),sqlDatecol );
                ColaboradorDAO.getINSTANCE().save(colab);
                ItemDAO.getINSTANCE().saveReposusuario(reposit, colab, keyword);
                for (GHUser seguidor : colaboradore.listFollowers()) {
                    Seguidor seg = new Seguidor(seguidor.getId(), colaboradore.getId(),reposit.getIdRepositorio(), seguidor.getName(), seguidor.getEmail(), seguidor.getLogin(), seguidor.getLocation(), seguidor.getUrl().toString(), seguidor.getAvatarUrl());
                    SeguidorDAO.getINSTANCE().save(seg);

                }
                System.out.println("Outros dados: ");
            }

        }

    }
}
