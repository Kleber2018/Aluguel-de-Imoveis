/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controle;

import ConexaoBD.ConexaoDesconexao;
import Modelo.Cliente;
import Modelo.Locacao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class LocacaoControle {
    
    ConexaoDesconexao conexao = new ConexaoDesconexao();
    
    /*
     *  INSERE NO BANCO A NOVA LOCACAO
     *  Esse método é chamado pelo construtor da TelaInicial 
     *  e retorna um array de Objeto tipo Locacao para popular a tabela ImoveisLocados
     */
    public void novaLocacao(Locacao locacao){
        //precisa arrumar o insert
        Connection con = conexao.Conectar();
        PreparedStatement stmt = null;
         try {
             stmt = con.prepareStatement("INSERT INTO locacao (data_fim_contrato, observacao, data_ini_contrato, locacao_situacao,"
                     + "valor_reajustado, cliente_id, imovel_id) "
                     + "VALUES (now(),?, now(),'Locado', ?,?,?)");
             
             stmt.setString(1, locacao.getImovel().getObs());
             stmt.setDouble(2, locacao.getValorLocacao());
             stmt.setInt(3, locacao.getCliente().getId());
             stmt.setInt(4, locacao.getImovel().getId());
             
             stmt.executeUpdate();
             
             //Chama o metodo na classe Imovel para alterar status do imovel de Disponível para Locado
             ImovelControle imovelControle = new ImovelControle();
             imovelControle.alteraStatusImovelPLocado(locacao.getImovel().getId());

             
             JOptionPane.showMessageDialog(null, "Salvo com sucesso!");
        } catch (SQLException ex) {
             Logger.getLogger(ImovelControle.class.getName()).log(Level.SEVERE, null, ex);
             JOptionPane.showMessageDialog(null, "Erro ao salvar" + ex);
         }finally{
             conexao.Desconectar();
        }
    }
    
    /*
    *   METODO SALVA A ALTERAÇÃO NA LOCACAO
    *   Esse método é chamado pelo botão Salvar quando a TelaCadLocacao for aberta pelo botão alterar Locacao
    *   Recebe os dados dos campos da TelaCadLocacao e atualiza no banco de dados
    */
    public void alteraLocacao(Locacao locacao){
        Connection con = conexao.Conectar();
        PreparedStatement stmt = null;
         try {
             stmt = con.prepareStatement("UPDATE locacao SET data_fim_contrato = ?, observacao = ?, "
                     + "valor_reajustado = ?, cliente_id = ? "
                     + "WHERE locacao_ID = ?");
             stmt.setString(1, locacao.getDataFinal());
             stmt.setString(2, locacao.getImovel().getObs());
             stmt.setDouble(3, locacao.getValorLocacao());
             stmt.setInt(4, locacao.getCliente().getId());
             stmt.setInt(5, locacao.getIdLocacao());
             
             stmt.executeUpdate();
             
             JOptionPane.showMessageDialog(null, "Atualizado com sucesso!");
        } catch (SQLException ex) {
             Logger.getLogger(ImovelControle.class.getName()).log(Level.SEVERE, null, ex);
             JOptionPane.showMessageDialog(null, "Erro ao atualizar" + ex);
         }finally{
             conexao.Desconectar();
        }
    }
    
    /*
    *   ALTERA O ESTATUS DA LOCACAO PARA ENCERRADO
    *   Esse método é chamado pelo botão Encerra Locacao da TelaInicial
    *   Ele altera o status da locacao para encerrado para não aparecer na tabela locacao
    */
     public void encerraLocacao(int id){
        Connection con = conexao.Conectar();
        PreparedStatement stmt = null;
         try {
             stmt = con.prepareStatement("UPDATE locacao SET  locacao_situacao = 'Encerrado'"
                     + "WHERE locacao_ID = ?");
             stmt.setInt(1, id);
             
             stmt.executeUpdate();
             
        } catch (SQLException ex) {
             Logger.getLogger(ImovelControle.class.getName()).log(Level.SEVERE, null, ex);
             JOptionPane.showMessageDialog(null, "Erro ao atualizar o Status do imovel" + ex);
         }finally{
             conexao.Desconectar();
        }
    }
     
     /*
    *   ALTERA O ESTATUS DA LOCACAO PARA LOCADO NOVAMENTE
    *   Esse método é chamado pelo botão que desfaz o último encerra Locacao da TelaInicial
    *   Ele altera o status da locacao para Locado para aparecer na tabela locacao
    */
     public void desfazEncerraLocacao(int id){
        Connection con = conexao.Conectar();
        PreparedStatement stmt = null;
         try {
             stmt = con.prepareStatement("UPDATE locacao SET  locacao_situacao = 'Locado'"
                     + "WHERE locacao_ID = ?");
             stmt.setInt(1, id);
             
             stmt.executeUpdate();
             
        } catch (SQLException ex) {
             Logger.getLogger(ImovelControle.class.getName()).log(Level.SEVERE, null, ex);
             JOptionPane.showMessageDialog(null, "Erro ao atualizar o Status do imovel" + ex);
         }finally{
             conexao.Desconectar();
        }
    }
    
    /*
     *  RETORNA UM ARRAY DE OBJETO LOCACAO COM OS DADOS
     *  Esse método é chamado pelo construtor da TelaInicial 
     *  e retorna um array de Objeto tipo Locacao para popular a tabela ImoveisLocados
     */
     public java.util.List<Locacao> listaImovelLocado(){
        Connection con = conexao.Conectar();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        java.util.List<Locacao> locacoes = new ArrayList<>();
        
         try {
             stmt = con.prepareStatement("select imovel.tipo, imovel.cidade, imovel.cep, imovel.rua, imovel.numero, imovel.tamanho,"
                     + "locacao.data_fim_contrato, locacao.observacao, locacao.valor_reajustado, cliente.cliente_nome, locacao_id "
                     + "from imovel inner join locacao on (imovel.imovel_id=locacao.imovel_id) "
                     + "inner join cliente on (locacao.cliente_id=cliente.cliente_id) "
                     + "where locacao.locacao_situacao = 'locado'");
             rs = stmt.executeQuery();//colocando dentro do resultset
             
             while(rs.next()){
                Locacao locacao = new Locacao();
                 locacao.getImovel().setTipo(rs.getString("imovel.tipo"));
                 locacao.getImovel().setCidade(rs.getString("imovel.cidade"));
                 locacao.getImovel().setCEP(rs.getString("imovel.cep"));
                 locacao.getImovel().setRua(rs.getString("imovel.rua"));
                 locacao.getImovel().setNumero(rs.getInt("imovel.numero"));
                 locacao.getImovel().setTamanho(rs.getDouble("imovel.tamanho"));
                 locacao.setDataFinal(rs.getString("locacao.data_fim_contrato"));
                 locacao.getImovel().setObs(rs.getString("locacao.observacao"));
                 locacao.setValorLocacao(rs.getDouble("locacao.valor_reajustado"));
                 locacao.getCliente().setNome(rs.getString("cliente.cliente_nome"));
                 locacao.setIdLocacao(rs.getInt("locacao_id"));
                locacoes.add(locacao);//colocando o resultado do select dentro do array list
             }
             
         } catch (SQLException ex) {
             Logger.getLogger(ImovelControle.class.getName()).log(Level.SEVERE, null, ex);
         }finally{
             conexao.Desconectar();
         }
         return locacoes;
    }
     
    /*
     *  RETORNA UM OBJETO LOCACAO COM OS DADOS
     *  Esse método é chamado ao apertar o botão alterar locaçao da Tela Inicial, 
     *  e retorna um Objeto tipo Locacao para popular os campos da TelaCadLocacao
     */
    public Locacao retornaLocacao(int id){
        Locacao locacao = new Locacao();
        Connection con = conexao.Conectar();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
         try {
             stmt = con.prepareStatement("select imovel.tipo, imovel.cidade, imovel.estado, imovel.cep, imovel.rua, imovel.numero, imovel.tamanho,\n"
                     + " locacao.observacao, locacao.valor_reajustado, cliente.cpf, locacao.locacao_id,"
                     + "imovel.imovel_id, imovel.bairro, imovel.qtd_quarto, year(locacao.data_fim_contrato), month(locacao.data_fim_contrato), day(locacao.data_fim_contrato) "
                     + "from imovel inner join locacao on imovel.imovel_id = locacao.imovel_id "
                     + "inner join cliente on locacao.cliente_id = cliente.cliente_id "
                     + "where locacao.locacao_id = ?");
             stmt.setInt(1, id);
             rs = stmt.executeQuery();//colocando resultado dentro do resultset
             
             while(rs.next()){
                 locacao.getImovel().setTipo(rs.getString("imovel.tipo"));
                 locacao.getImovel().setCidade(rs.getString("imovel.cidade"));
                 locacao.getImovel().setEstado(rs.getString("imovel.estado"));
                 locacao.getImovel().setCEP(rs.getString("imovel.cep"));
                 locacao.getImovel().setRua(rs.getString("imovel.rua"));
                 locacao.getImovel().setNumero(rs.getInt("imovel.numero"));
                 locacao.getImovel().setTamanho(rs.getDouble("imovel.tamanho"));
                 locacao.getImovel().setObs(rs.getString("observacao"));
                 locacao.setValorLocacao(rs.getDouble("valor_reajustado"));
                 locacao.getCliente().setCPF(rs.getString("cpf"));
                 locacao.setIdLocacao(rs.getInt("locacao_id"));
                 locacao.getImovel().setId(rs.getInt("imovel_id"));
                 locacao.getImovel().setBairro(rs.getString("bairro"));
                 locacao.getImovel().setQtdQuarto(rs.getInt("qtd_quarto"));
                 locacao.setDataFInalAno(rs.getString("year(locacao.data_fim_contrato)"));
                  locacao.setDataFinalMes(rs.getString("month(locacao.data_fim_contrato)"));
                   locacao.setDataFinalDia(rs.getString("day(locacao.data_fim_contrato)"));
             }
             
         } catch (SQLException ex) {
             Logger.getLogger(ImovelControle.class.getName()).log(Level.SEVERE, null, ex);
         }finally{
             conexao.Desconectar();
         }
        
        return locacao;
    }
     
}
