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
            gitHub = GitHub.connectUsingOAuth("4ae38303b4f19b62b09fb1529c161f9925f40b1e");
        }
        return gitHub;
    }
}
