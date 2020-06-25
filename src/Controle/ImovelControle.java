package Controle;

import ConexaoBD.ConexaoDesconexao;
import Modelo.Imovel;
import java.awt.List;
//import com.mysql.jdbc.PreparedStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class ImovelControle {

    ConexaoDesconexao conexao = new ConexaoDesconexao();

    /*
    * METODO PARA INSERIR NOVO IMÓVEL
    * Esse metodo recebe um Objeto Imovel com os dados da TelaCadImovel, para a inserção de um novo imóvel na tabela imovel do banco de dados
     */
    public void novoImovel(Imovel im) {
        Connection con = conexao.Conectar();
        PreparedStatement stmt = null;
        try {
            stmt = con.prepareStatement("INSERT INTO IMOVEL "
                    + "(tipo, cidade, bairro, estado, cep, rua, numero, qtd_quarto, tamanho, observacao, valor_locacao, imovel_situacao) "
                    + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, 'Disponível')");
            stmt.setString(1, im.getTipo());
            stmt.setString(2, im.getCidade());
            stmt.setString(3, im.getBairro());
            stmt.setString(4, im.getEstado());
            stmt.setString(5, im.getCEP());
            stmt.setString(6, im.getRua());
            stmt.setInt(7, im.getNumero());
            stmt.setInt(8, im.getQtdQuarto());
            stmt.setDouble(9, im.getTamanho());
            stmt.setString(10, im.getObs());
            stmt.setDouble(11, im.getValor());

            stmt.executeUpdate();

            JOptionPane.showMessageDialog(null, "Salvo com sucesso!");
        } catch (SQLException ex) {
            Logger.getLogger(ImovelControle.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Erro ao salvar: " + ex);
        } finally {
            conexao.Desconectar();
        }
    }

    /*
    * METODO PARA ALTERAR UM IMÓVEL DISPONÍVEL
    * Esse método recebe um objeto Imovel com os dados da TelaCadImovel, para alterar a tabela imovel do banco de dados.
     */
    public void alteraImovel(Imovel im) {
        Connection con = conexao.Conectar();
        PreparedStatement stmt = null;
        try {
            stmt = con.prepareStatement("UPDATE imovel SET tipo = ?, cidade = ?, estado = ?, bairro = ?, cep = ?, rua = ?, "
                    + "numero = ?, qtd_quarto = ?, tamanho = ?, observacao = ?, valor_locacao = ?"
                    + "WHERE IMOVEL_ID = ?");
            stmt.setString(1, im.getTipo());
            stmt.setString(2, im.getCidade());
            stmt.setString(3, im.getEstado());
            stmt.setString(4, im.getBairro());
            stmt.setString(5, im.getCEP());
            stmt.setString(6, im.getRua());
            stmt.setInt(7, im.getNumero());
            stmt.setInt(8, im.getQtdQuarto());
            stmt.setDouble(9, im.getTamanho());
            stmt.setString(10, im.getObs());
            stmt.setDouble(11, im.getValor());
            stmt.setInt(12, im.getId());

            stmt.executeUpdate();

            JOptionPane.showMessageDialog(null, "Atualizado com sucesso!");
        } catch (SQLException ex) {
            Logger.getLogger(ImovelControle.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Erro ao atualizar" + ex);
        } finally {
            conexao.Desconectar();
        }
    }

    public void alteraStatusImovelPLocado(int id) {
        Connection con = conexao.Conectar();
        PreparedStatement stmt = null;
        try {
            stmt = con.prepareStatement("UPDATE imovel SET  imovel_situacao = 'Locado'"
                    + "WHERE IMOVEL_ID = ?");
            stmt.setInt(1, id);

            stmt.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(ImovelControle.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Erro ao atualizar o Status do imovel" + ex);
        } finally {
            conexao.Desconectar();
        }
    }

    /*
    * METODO PARA DELETAR UM IMÓVEL DISPONÍVEL
    * Esse método recebe tipo int com o id do imóvel da TelaCadImovel, para excluir o imóvel no banco de dados.
     */
    public void deleteImovel(int id) {

        Connection con = conexao.Conectar();
        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("DELETE FROM imovel WHERE imovel_id = ?");
            stmt.setInt(1, id);

            stmt.executeUpdate();

            JOptionPane.showMessageDialog(null, "Excluido com sucesso!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao excluir: " + ex);
        } finally {
            conexao.Desconectar();
        }
    }

    /*
    * METODO PARA RETORNAR UMA LISTA DE IMOVEIS COM SITUAÇÃO DISPONÍVEL
    * Esse mótodo é chamado pelo metodo PreencheTableDisponiveis da TelaInicial, 
    * ele retorna uma lista com as informações de todos os imóveis com situação disponível
     */
    public java.util.List<Imovel> listaImovelDisponivel() {
        Connection con = conexao.Conectar();
        PreparedStatement stmt = null;
        ResultSet rs = null;

        java.util.List<Imovel> imoveis = new ArrayList<>();

        try {
            stmt = con.prepareStatement("SELECT imovel_id, rua, numero, bairro, cidade, estado, cep, tipo, qtd_quarto, tamanho, valor_locacao, observacao "
                    + "FROM imovel where imovel_situacao like 'Dispon_vel'");
            rs = stmt.executeQuery();//colocando dentro do resultset

            while (rs.next()) {
                Imovel imovel = new Imovel();
                imovel.setId(rs.getInt("imovel_id"));
                imovel.setRua(rs.getString("rua"));
                imovel.setNumero(rs.getInt("numero"));
                imovel.setBairro(rs.getString("bairro"));
                imovel.setCidade(rs.getString("cidade"));
                imovel.setEstado(rs.getString("estado"));
                imovel.setCEP(rs.getString("CEP"));
                imovel.setTipo(rs.getString("tipo"));
                imovel.setQtdQuarto(rs.getInt("qtd_quarto"));
                imovel.setTamanho(rs.getDouble("tamanho"));
                imovel.setValor(rs.getDouble("valor_locacao"));
                imovel.setObs(rs.getString("observacao"));

                imoveis.add(imovel);//colocando o resultado do select dentro do array list
            }

        } catch (SQLException ex) {
            Logger.getLogger(ImovelControle.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            conexao.Desconectar();
        }
        return imoveis;
    }

    /*
    * METODO PARA RETORNAR UMA LISTA DE IMOVEIS COM SITUAÇÃO LOCADO
    * Esse mótodo é chamado pelo metodo PreencheTableLocado da TelaInicial, 
    * ele retorna uma lista com as informações de todos os imóveis com situação locado
     */
    public java.util.List<Imovel> listaImovelLocado() {
        Connection con = conexao.Conectar();
        PreparedStatement stmt = null;
        ResultSet rs = null;

        java.util.List<Imovel> imoveis = new ArrayList<>();

        try {
            stmt = con.prepareStatement("SELECT imovel_id, rua, numero, bairro, cidade, estado, cep, tipo, qtd_quarto, tamanho, valor_locacao, observacao  from imovel where imovel_situacao like 'Locado'");
            rs = stmt.executeQuery();//colocando dentro do resultset

            while (rs.next()) {
                Imovel imovel = new Imovel();
                imovel.setId(rs.getInt("imovel_id"));
                imovel.setRua(rs.getString("rua"));
                imovel.setNumero(rs.getInt("numero"));
                imovel.setBairro(rs.getString("bairro"));
                imovel.setCidade(rs.getString("cidade"));
                imovel.setEstado(rs.getString("estado"));
                imovel.setCEP(rs.getString("CEP"));
                imovel.setTipo(rs.getString("tipo"));
                imovel.setQtdQuarto(rs.getInt("qtd_quarto"));
                imovel.setTamanho(rs.getDouble("tamanho"));
                imovel.setValor(rs.getDouble("valor_locacao"));
                imovel.setObs(rs.getString("observacao"));

                imoveis.add(imovel);//colocando o resultado do select dentro do array list
            }

        } catch (SQLException ex) {
            Logger.getLogger(ImovelControle.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            conexao.Desconectar();
        }
        return imoveis;
    }

}
