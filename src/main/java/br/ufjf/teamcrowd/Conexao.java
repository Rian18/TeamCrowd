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
            gitHub = GitHub.connectUsingOAuth("71e2869f55bae8dfdefdcbad66c3212152171007");
        }
        return gitHub;
    }
}
