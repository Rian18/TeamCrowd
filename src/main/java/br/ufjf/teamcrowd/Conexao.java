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
            gitHub = GitHub.connectUsingOAuth("b8220b1d3174e806619394b164758e78fa928c31");
        }
        return gitHub;
    }
}
