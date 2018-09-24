package br.ufjf.teamcrowd;

import java.io.IOException;
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
            Repositorio reposit = new Repositorio(repositorio.getId(), repositorio.getDescription(),
                    repositorio.getFullName(), repositorio.getName(), repositorio.getUrl().toString(), keyword);
            RepositorioDAO.getINSTANCE().save(reposit);

            PagedIterable<GHRepository.Contributor> colaboradores = repositorio.listContributors();
            for (GHRepository.Contributor colaboradore : colaboradores) {

                Colaborador colab = new Colaborador(colaboradore.getId(), colaboradore.getName(), colaboradore.getEmail(), colaboradore.getContributions(),
                        colaboradore.getFollowingCount(), colaboradore.getFollowersCount(), colaboradore.getLocation(), colaboradore.getUrl().toString(), colaboradore.getAvatarUrl());

                ColaboradorDAO.getINSTANCE().save(colab);
                ItemDAO.getINSTANCE().saveRepoColab(reposit, colab);
                for (GHUser seguidor : colaboradore.listFollowers()) {
                    Seguidor seg = new Seguidor(seguidor.getId(), seguidor.getName(), seguidor.getEmail(), seguidor.getFollowingCount(),
                            seguidor.getFollowersCount(), seguidor.getLocation(), seguidor.getUrl().toString(), seguidor.getAvatarUrl());
                    SeguidorDAO.getINSTANCE().save(seg);
                    ItemDAO.getINSTANCE().saveColabSeguidor(seg, colab);
                }
                System.out.println("Outros dados: ");
            }

        }

    }
}
