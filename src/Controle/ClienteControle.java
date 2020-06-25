package Controle;

import ConexaoBD.ConexaoDesconexao;
import Modelo.Cliente;
import Modelo.Imovel;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class ClienteControle {

    ConexaoDesconexao conexao = new ConexaoDesconexao();
    /*
    *   BUSCA CLIENTE PELO CPF
    *   Esse método é chamado pelo botão buscar da TelaCadLocacao.
    *   Ele busca os dados referentes ao cliente para popular os campos cliente da TelaCadLocacao e TelaCadCliente
    */
    public ResultSet buscaCliente(String cpf) throws SQLException {
        Connection con = conexao.Conectar();
        String sql = "select cliente_id, cliente_nome, cpf, sexo, data_nascimento, banco, agencia, conta, operacao, "
                + "day(data_nascimento), month(data_nascimento), year(data_nascimento) "
                + "from cliente where cpf = ?";
        java.sql.PreparedStatement statement = null;
        try {
            statement = con.prepareStatement(sql);
            statement.setString(1, cpf);
        } catch (SQLException ex) {
            Logger.getLogger(ImovelControle.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return statement.executeQuery();
    }
    
    /*
    *   METODO PARA INSERIR NOVO CLIENTE
    *   Esse método recebe um Objeto Cliente com as informações dos campos da TelaCadCliente e insere um novo Cliente no banco
    */
     public void novoCliente(Cliente cliente){
        Connection con = conexao.Conectar();
        PreparedStatement stmt = null;
         try {
             stmt = con.prepareStatement("INSERT INTO cliente "
                     + "(cliente_nome, cpf, sexo, banco, agencia, conta, operacao)"
                     + "VALUES (?, ?, ?, ?, ?, ?, ?)");
             stmt.setString(1, cliente.getNome());
             stmt.setString(2, cliente.getCPF());
             stmt.setString(3, String.valueOf(cliente.getSexo()));
             stmt.setString(4, cliente.getNomeBanco());
             stmt.setInt(5, cliente.getNumAgencia());
             stmt.setInt(6, cliente.getNumConta());
             stmt.setInt(7, cliente.getOperacao());
             stmt.executeUpdate();
             
             JOptionPane.showMessageDialog(null, "Salvo com sucesso!");
        } catch (SQLException ex) {
             Logger.getLogger(ImovelControle.class.getName()).log(Level.SEVERE, null, ex);
             JOptionPane.showMessageDialog(null, "Erro ao salvar" + ex);
         }finally{
             conexao.Desconectar();
        }
    }
     
    /*
     *  METODO PARA ALTERAR O CLIENTE
     *  Esse método recebe um objeto Cliente com os dados digitados na tela para realizar o Update no Cliente
     */
     public void alteraCliente(Cliente cliente){
        Connection con = conexao.Conectar();
        PreparedStatement stmt = null;
         try {
             stmt = con.prepareStatement("UPDATE cliente SET cliente_nome = ?, cpf = ?, sexo = ?, "
                     + "banco = ?, agencia = ?, conta = ?, operacao = ? "
                     + "WHERE cliente_id = ?");
             //stmt.setString(2, cliente.getNascimento()); ESTUDAR A UTILIZAÇÃO DE DATE
             stmt.setString(1, cliente.getNome());
             stmt.setString(2, cliente.getCPF());
             stmt.setString(3, String.valueOf(cliente.getSexo()));
             stmt.setString(4, cliente.getNomeBanco());
             stmt.setInt(5, cliente.getNumAgencia());
             stmt.setInt(6, cliente.getNumConta());
             stmt.setInt(7, cliente.getOperacao());
             stmt.setInt(8,cliente.getId());
             
             stmt.executeUpdate();
             
             JOptionPane.showMessageDialog(null, "Atualizado com sucesso! 2");
        } catch (SQLException ex) {
             Logger.getLogger(ImovelControle.class.getName()).log(Level.SEVERE, null, ex);
             JOptionPane.showMessageDialog(null, "Erro ao atualizar" + ex);
         }finally{
             conexao.Desconectar();
        }
    }
    
    /*
    * METODO PARA DELETAR UM CLIENTE
    * Esse método recebe um objeto Cliente com os dados da TelaCadLocação, para excluir o cliente no banco de dados.
    */
    public void deleteCliente(Cliente cliente) {

        Connection con = conexao.Conectar();        
        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("DELETE FROM cliente WHERE cliente_id = ?");
            stmt.setInt(1, cliente.getId());

            stmt.executeUpdate();

            JOptionPane.showMessageDialog(null, "Excluido com sucesso!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao excluir: " + ex);
        } finally {
            conexao.Desconectar();
        }
    }
    
}
