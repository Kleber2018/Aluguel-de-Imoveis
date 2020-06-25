
package ConexaoBD;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

public class ConexaoDesconexao {
    
    public Statement stm;
    public ResultSet rs;
    
    public static Connection retornaConexao = null;
    
    public static Connection Conectar(){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            retornaConexao = DriverManager.getConnection("jdbc:mysql://localhost/aluguel_imoveis","root","");
            System.out.println("Conectado.");
        }catch (ClassNotFoundException ex) {
            System.out.println("Class não encontrada, adicione o driver nas bibliotecas.");
        }catch(SQLException e){
            System.out.println(e);
        }
        return retornaConexao;
    }
    
    public void Desconectar(){
        try{
            retornaConexao.close();
            System.out.println("DESCONECTADO");
        }catch (SQLException e){
            System.out.println(e);
        }
    }

    public void executaSql(String sql){
        try{
            stm = retornaConexao.createStatement(rs.TYPE_SCROLL_INSENSITIVE,rs.CONCUR_READ_ONLY);//TYPE_SC.. TRANSFORMA TUDO PARA MINUSCULO
        rs = stm.executeQuery(sql);
        }catch (SQLException ex){
            JOptionPane.showMessageDialog(null, "erro executa SQL" +ex.getMessage());
        }
    }

}
