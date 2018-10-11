package br.ufjf.teamcrowd;

import java.io.IOException;
import org.kohsuke.github.GitHub;

/**
 *
 * @author Rian Alves
 */
public class Conexao {

    GitHub gitHub;

    public GitHub getConexao() throws IOException {
        if (gitHub == null) {
            gitHub = GitHub.connectUsingOAuth("598fa7981183e9872c5d7d295f34fd2808488879");
        }
        return gitHub;
    }
}
