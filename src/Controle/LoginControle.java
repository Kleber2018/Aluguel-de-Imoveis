package Controle;

import java.awt.HeadlessException;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.JOptionPane;

/**
 *
 * @author Kleber, Eduardo
 */
public class LoginControle {
    
    /*
    *   MANIPULANDO ARQUIVO DE TESTO
    *   MÉTODO PARA VALIDAR O USUÁRIO E SENHA DA TELA LOGIN
    *   Esse método é chamado pela classe TelaLogin e recebe por parâmetros o usuário e senha, 
    *   valida de acordo com o que está escrito no arquivo de texto.txt
    */
    public boolean verificaLogin(String login, String senha) throws IOException {
        File file = new File("login.txt");

        FileReader fler = new FileReader(file);
        BufferedReader bler = new BufferedReader(fler);
        String linha = bler.readLine();
        String clogin;
        String csenha;
        while (linha != null) {
            clogin = linha.split(";")[0];
            csenha = linha.split(";")[1];
            if (clogin.equals(login)) {
                if (csenha.equals(senha)) {
                    return true;}
                /*} else {
                JOptionPane.showMessageDialog(null, "Senha errada! Tente novamente");
                return false;
                }*/
            }
            linha = bler.readLine();
        }
        JOptionPane.showMessageDialog(null, "Login não encontrado! Tente novamente");
        return false;
    }

    /*
    *   METODO PARA CADASTRAR NOVA LINHA NO ARQUIVO DE TEXTO
    *   Esse método é chamado pela TelaUsuario para salvar uma nova linha no arquivo de texto.txt
    */
    
    public void confirmaCadastro(String login, String senha, String nome) {
        File file = new File("login.txt");

        try {
            if (file.exists() == false) {
                file.createNewFile();
            }

            FileWriter fescr = new FileWriter(file, true);
            BufferedWriter bescr = new BufferedWriter(fescr);
            bescr.write(login + ";");
            bescr.write(senha + ";");
            bescr.write(nome + ";");
            bescr.newLine();
            bescr.close();
            fescr.close();

        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

}
